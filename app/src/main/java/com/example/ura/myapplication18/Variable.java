package com.example.ura.myapplication18;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;

class Variable {
    static Intent intentserv;
    static Handler handtv;
    static String debug = "DBGMR";
    static BufferedReader reader;
    static PrintWriter writer;
    volatile static Socket sock;
    static ArrayList<ArrayList> buf = new ArrayList<>();
    Message msg = null;
    static String imei;
    static String head;

    static void Send_Message(String message) {
        Log.e(debug,"send->" + message);
        Thread SendThread = new Thread(new SendMessage(message));
        SendThread.start();
    }
}
