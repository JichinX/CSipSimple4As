package me.xujichang.lib.csipsimple;

import android.app.Application;

/**
 * Des:CSipSimple - me.xujichang.lib.csipsimple
 *
 * @author xujichang
 * @date 2019-05-06 - 12:26
 * <p>
 * modify:
 */
public class SipApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        SipCustomConfig.init(this);
    }
}
