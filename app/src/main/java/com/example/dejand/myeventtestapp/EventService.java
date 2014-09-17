package com.example.dejand.myeventtestapp;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import java.util.Timer;
import java.util.TimerTask;

import de.greenrobot.event.EventBus;

public class EventService extends Service {
    public EventService() {

    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    public static final String ARG_COMMAND = "command";
    public static final int COMMAND_START = 1;
    public static final int COMMAND_STOP = 2;
    private int i = 0;

    private Timer timer;

    @Override
    public void onCreate() {
        super.onCreate();
    }


    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        int command = intent.getIntExtra(ARG_COMMAND, COMMAND_STOP);

        if (command == COMMAND_START) {
            startNotifications();
        } else {
            stopNotifications();
        }

        return START_STICKY;
    }

    private void stopNotifications() {

        if (timer != null) {
            timer.cancel();
            timer = null;
        }

        stopSelf();

    }

    private void startNotifications() {

        if (timer == null) {
            timer = new Timer();
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    EventBus bus = EventBus.getDefault();
                    bus.post(new EventNotification(++i));
                }
            }, 1000, 1000);
        }

    }


}