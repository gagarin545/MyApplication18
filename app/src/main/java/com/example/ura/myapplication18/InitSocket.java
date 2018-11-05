package com.example.ura.myapplication18;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

class InitSocket extends Variable {

    private InitSocket() {}

    static void getSock() throws IOException {
        int portNumber = 35135; //34335; 35135;
        String Host = "192.168.100.4";   //    "10.183.5.99";   "192.168.100.4";     "178.46.165.205";

        if (sock == null) {
            sock = new Socket(Host, portNumber);
            reader = new BufferedReader(new InputStreamReader(sock.getInputStream()));
            writer = new PrintWriter(sock.getOutputStream(), true);
        }
         Log.e(debug, "Socket "  + sock.getPort()  );
        //return sock;
    }


    static String read() throws IOException { return reader.readLine(); }

    static boolean hasConnection(final Context context)
    {
        ConnectivityManager cm = (ConnectivityManager)context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo wifiInfo = cm.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
        if (wifiInfo != null && wifiInfo.isConnected())
            return true;

        wifiInfo = cm.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
        if (wifiInfo != null && wifiInfo.isConnected())
            return true;

        wifiInfo = cm.getActiveNetworkInfo();
        if (wifiInfo != null && wifiInfo.isConnected())
            return true;

        return false;
    }

}




