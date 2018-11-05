package com.example.ura.myapplication18;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

import static com.example.ura.myapplication18.InitSocket.hasConnection;

class Icommand extends Variable{
    Context context;
    private static String message;
    private String user;

    Icommand(Context ctx) {
        super();
        this.context = ctx;
    }

    Icommand(Context ctx, String s) {
        super();
        this.context = ctx;
        user = s;
    }

    void commit(int i) {
        Log.e(debug, "msg -> " + i);
        switch (i) {
            case R.id.Rest:
                if ( sock == null && hasConnection(context)) {
                    if(intentserv == null) {
                        intentserv = new Intent(context, ServiceInit.class);
                        context.startService(intentserv);
                    }
                    else {
                        context.stopService(intentserv);
                        context.startService(intentserv);
                    }
                }
                else
                    Send_Message("#***");
                break;
        }

    }
}

