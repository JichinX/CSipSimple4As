package me.xujichang.lib.csipsimple.preference;

import android.os.Bundle;
import android.support.v14.preference.PreferenceFragment;

/**
 * Des:Linkage - me.xujichang.lib.csipsimple.preference
 *
 * @author xujichang
 * @date 2019-04-24 - 13:08
 * <p>
 * modify:
 */
public class PrefsFragment extends PreferenceFragment {
    @Override
    public void onCreatePreferences(Bundle bundle, String s) {
        getArguments().getInt("res_value");
    }
}
