/*
 * Copyright 2015 Synced Synapse. All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.xbmc.kore.ui;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;

import org.xbmc.kore.Settings;
import org.xbmc.kore.utils.UIUtils;
import org.xbmc.kore.utils.Utils;

/**
 * Base activity, where common behaviour is implemented
 */
public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        setTheme(UIUtils.getThemeResourceId(
                prefs.getString(Settings.KEY_PREF_THEME, Settings.DEFAULT_PREF_THEME)));

        setPreferredLocale();
        super.onCreate(savedInstanceState);
    }

    private void setPreferredLocale() {
        String preferredLocale = android.preference.PreferenceManager.getDefaultSharedPreferences(this)
                                                                     .getString(Settings.KEY_PREF_SELECTED_LANGUAGE, "");
        if (! preferredLocale.isEmpty()) {
            Utils.setLocale(this, preferredLocale);
        }
    }

    //    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.global, menu);
//        return super.onCreateOptionsMenu(menu);
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        switch (item.getItemId()) {
//            case R.id.action_settings:
//                return true;
//            default:
//                break;
//        }
//
//        return super.onOptionsItemSelected(item);
//    }
}
