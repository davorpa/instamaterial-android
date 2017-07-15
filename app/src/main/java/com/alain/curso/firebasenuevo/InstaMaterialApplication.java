package com.alain.curso.firebasenuevo;

import android.app.Application;
import timber.log.Timber;

public class InstaMaterialApplication extends Application {
  @Override
  public void onCreate() {
    super.onCreate();
    Timber.plant(new Timber.DebugTree());
  }
}
