package me.xujichang.lib.csipsimple.preference;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import me.xujichang.lib.csipsimple.R;
import com.csipsimple.api.SipManager;
import com.csipsimple.ui.prefs.PrefsFilters;
import com.csipsimple.ui.prefs.PrefsLogic;
import com.csipsimple.ui.prefs.cupcake.PrefsLoaderActivity;
import com.csipsimple.utils.PreferencesWrapper;

import java.util.ArrayList;
import java.util.List;

/**
 * Des:Linkage - me.xujichang.lib.csipsimple.preference
 *
 * @author xujichang
 * @date 2019-04-24 - 12:58
 * <p>
 * modify:
 */
public class MainPreferenceActivity extends AppCompatActivity {

    private PreferencesWrapper prefsWrapper;
    private RecyclerView mSipLibRvSettingModules;
    private SettingAdapter mAdapter;
    private List<PrefGroup> mGroups;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        prefsWrapper = new PreferencesWrapper(this);
        setContentView(R.layout.siplib_activity_main_prefs);
        initView();
        initData();
    }

    private Intent getIntentForType(int t) {
        Intent it = new Intent(this, PrefsLoaderActivity.class);
        it.putExtra(PrefsLogic.EXTRA_PREFERENCE_TYPE, t);
        return it;
    }

    private void initData() {
        mGroups.clear();
        mGroups.add(new PrefGroup(R.string.prefs_fast, R.string.prefs_fast_desc,
                R.drawable.ic_prefs_fast, new Intent(SipManager.ACTION_UI_PREFS_FAST)));
        mGroups.add(new PrefGroup(R.string.prefs_network, R.string.prefs_network_desc,
                R.drawable.ic_prefs_network, getIntentForType(PrefsLogic.TYPE_NETWORK)));
        mGroups.add(new PrefGroup(R.string.prefs_media, R.string.prefs_media_desc,
                R.drawable.ic_prefs_media, getIntentForType(PrefsLogic.TYPE_MEDIA)));
        mGroups.add(new PrefGroup(R.string.prefs_ui, R.string.prefs_ui_desc,
                R.drawable.ic_prefs_ui, getIntentForType(PrefsLogic.TYPE_UI)));
        mGroups.add(new PrefGroup(R.string.prefs_calls, R.string.prefs_calls_desc,
                R.drawable.ic_prefs_calls, getIntentForType(PrefsLogic.TYPE_CALLS)));
        mGroups.add(new PrefGroup(R.string.filters, R.string.filters_desc,
                R.drawable.ic_prefs_filter, new Intent(this, PrefsFilters.class)));
        mAdapter.notifyDataSetChanged();
    }

    private void initView() {
        mGroups = new ArrayList<>();
        mAdapter = new SettingAdapter(mGroups, this);
        mSipLibRvSettingModules = findViewById(R.id.sip_lib_rv_setting_modules);
        mSipLibRvSettingModules.setLayoutManager(new LinearLayoutManager(this));
        mSipLibRvSettingModules.setAdapter(mAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_prefs, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        PrefsLogic.onMainActivityPrepareOptionMenu(menu, this, prefsWrapper);
        return super.onPrepareOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (PrefsLogic.onMainActivityOptionsItemSelected(item, this, prefsWrapper)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private class SettingAdapter extends RecyclerView.Adapter<ViewHolder> {
        private List<PrefGroup> mGroups;
        private Context mContext;

        public SettingAdapter(List<PrefGroup> groups, Context context) {
            mGroups = groups;
            mContext = context;
        }

        @NonNull
        @Override

        public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            View mView = LayoutInflater.from(mContext).inflate(R.layout.icon_preference_screen, viewGroup, false);
            return new ViewHolder(mView);
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
            viewHolder.bindData(mGroups.get(i));
        }

        @Override
        public int getItemCount() {
            return mGroups.size();
        }
    }

    private class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView title_view;
        private final ImageView icon_view;
        private final TextView summary_view;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            icon_view = (ImageView) itemView.findViewById(R.id.icon);
            title_view = (TextView) itemView.findViewById(android.R.id.title);
            summary_view = (TextView) itemView.findViewById(android.R.id.summary);
        }

        public void bindData(final PrefGroup prefGroup) {
            icon_view.setImageResource(prefGroup.icon);
            title_view.setText(prefGroup.title);
            summary_view.setText(prefGroup.summary);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(prefGroup.intent);
                }
            });
        }
    }

    class PrefGroup {
        public String title;
        public int icon;
        public String summary;
        public Intent intent;

        public PrefGroup(String title, String summary, int icon, Intent intent) {
            this.title = title;
            this.summary = summary;
            this.icon = icon;
            this.intent = intent;
        }

        public PrefGroup(int title_res, int summary_res, int icon, Intent intent) {
            this.title = getString(title_res);
            this.summary = getString(summary_res);
            this.icon = icon;
            this.intent = intent;
        }
    }

}
