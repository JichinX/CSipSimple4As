package me.xujichang.lib.csipsimple;

import android.app.Application;

import com.csipsimple.api.SipConfigManager;
import com.csipsimple.api.SipManager;

/**
 * Des:CSipSimple - me.xujichang.lib.csipsimple
 *
 * @author xujichang
 * @date 2019-05-06 - 12:24
 * <p>
 * modify:
 */
public class SipCustomConfig {

    public static void init(Application application) {
//        SipConfigManager.AUTHORITY = getPackageName(application) + ".prefs";
//        SipManager.AUTHORITY = getPackageName(application) + ".db";
    }

    private static String getPackageName(Application application) {
        return application.getPackageName();
    }
}
