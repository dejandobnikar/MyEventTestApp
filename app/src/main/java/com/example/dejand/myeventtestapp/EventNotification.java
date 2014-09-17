package com.example.dejand.myeventtestapp;

/**
 * Created by DejanD on 17.9.2014.
 */
public class EventNotification {

    private int eventNum;
    private int fragment;


    public EventNotification(int i, int fragment) {
        this.eventNum = i;
        this.fragment = fragment;
    }

    public int getEventNum() {
        return eventNum;
    }

    public void setEventNum(int eventNum) {
        this.eventNum = eventNum;
    }


    public int getFragment() {
        return fragment;
    }

    public void setFragment(int fragment) {
        this.fragment = fragment;
    }
}
