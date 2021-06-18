package com.hiepnd.mailer;

import android.app.Application;

public class MailApplication extends Application {
    public AppComponent appComponent = DaggerAppComponent.create();
}
