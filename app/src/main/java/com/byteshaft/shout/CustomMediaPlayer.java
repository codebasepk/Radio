package com.byteshaft.shout;

import android.content.Context;

import wseemann.media.FFmpegMediaPlayer;

public class CustomMediaPlayer extends FFmpegMediaPlayer {

    private PlaybackNotification mPlaybackNotification;
    static CustomMediaPlayer sCustomMediaPlayer;

    static CustomMediaPlayer getInstance(Context context) {
        if (sCustomMediaPlayer == null) {
            sCustomMediaPlayer = new CustomMediaPlayer(context);
            return sCustomMediaPlayer;
        } else {
            return sCustomMediaPlayer;
        }
    }

    static CustomMediaPlayer getInsance(Context context, boolean forceConstruct) {
        if (forceConstruct) {
            sCustomMediaPlayer = null;
            return getInstance(context);
        } else {
            return getInstance(context);
        }
    }

    private CustomMediaPlayer(Context context) {
        super();
        mPlaybackNotification = PlaybackNotification.getInstance(context);
    }

    @Override
    public void start() throws IllegalStateException {
        super.start();
        Helpers.updateMainViewButton("Pause");
        mPlaybackNotification.show();
    }

    @Override
    public void stop() throws IllegalStateException {
        super.stop();
        Helpers.updateMainViewButton("Play");
        mPlaybackNotification.remove();
    }

    @Override
    public void pause() throws IllegalStateException {
        super.pause();
        Helpers.updateMainViewButton("Play");
        mPlaybackNotification.remove();
    }
}