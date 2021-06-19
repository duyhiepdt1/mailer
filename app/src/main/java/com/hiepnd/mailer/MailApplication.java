package com.hiepnd.mailer;

import android.app.Application;

public class MailApplication extends Application {
    public ApplicationComponent applicationComponent = DaggerApplicationComponent.create();
}
