/*
 *
 *  * Copyright 2017 Kojadin
 *  *
 *  * Licensed under the Apache License, Version 2.0 (the "License");
 *  * you may not use this file except in compliance with the License.
 *  * You may obtain a copy of the License at
 *  *
 *  *        http://www.apache.org/licenses/LICENSE-2.0
 *  *
 *  * Unless required by applicable law or agreed to in writing, software
 *  * distributed under the License is distributed on an "AS IS" BASIS,
 *  * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  * See the License for the specific language governing permissions and
 *  * limitations under the License.
 *
 */

package com.erevacation.challenge;

import android.app.Application;

import com.erevacation.challenge.injection.components.AppComponent;
import com.erevacation.challenge.injection.components.DaggerAppComponent;
import com.erevacation.challenge.injection.modules.AppModule;
import com.facebook.drawee.backends.pipeline.Fresco;

import timber.log.Timber;

/**
 * Created by kojadin on 12/7/16.
 */

public class ProductsApp extends Application {

    private static ProductsApp sInstance = null;

    private static AppComponent sAppComponent = null;

    public static AppComponent getAppComponent() {
        return sAppComponent;
    }

    public static ProductsApp getInstance() {
        return sInstance;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        Fresco.initialize(this);

        sInstance = this;
        sAppComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();

        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
        }
    }
}
