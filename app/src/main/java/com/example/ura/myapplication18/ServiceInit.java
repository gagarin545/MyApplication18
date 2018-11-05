package com.example.ura.myapplication18;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.Message;
import android.util.Log;

import java.util.ArrayList;

import static com.example.ura.myapplication18.Variable.debug;

public class ServiceInit extends Service {

    public ServiceInit() {
        Thread initThread = new Thread(new InitSock());
        initThread.start();
         Log.e(debug, initThread.getName() + initThread.getId());
    }

    public class InitSock extends Variable implements Runnable {
        public void run() {

            try {
                InitSocket.getSock();
                Thread SendThread = new Thread(new SendMessage("#usr" + imei + getString(R.string.codSity)));
                SendThread.start();
                ArrayList<String> list = null;
                buf.clear();

                while (true) {
                    msg = new Message();
                    String s = InitSocket.read();
                    Log.e(debug, "read -> " + s );
                    switch (s.substring(1, 2)) {
                        case "-":
                            continue;
                        case "&":
                            msg.obj = s.substring(2) + "<br/>";
                            handtv.sendMessage(msg);
                            continue;
                        case "~":
                            msg.obj = s.substring(2);
                            handtv.sendMessage(msg);
                           continue;
                        case "^":
                            msg.obj = "-";
                            handtv.sendMessage(msg);
                            continue;
                        default:
                            msg.obj = s;
                    }
                    handtv.sendMessage(msg);
                }
            } catch (Exception ex) {
                sock = null;
                msg.obj = "Откл";
                handtv.sendMessage(msg);
                ex.printStackTrace();
            }
        }
    }

    @Override
    public void onDestroy(){
        super.onDestroy();
        // Log.e(debug, "init: onDestroy");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        // Log.e(debug, "onStartCommand Flag: " + flags + " Id: " + startId );
        return Service.START_NOT_STICKY;
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
