package in.springpebbles.customclip;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.*;

/**
 * Created by todo on 30.06.2017.
 */

public class PreferenceFragment extends android.preference.PreferenceFragment implements SharedPreferences.OnSharedPreferenceChangeListener {

    ListPreference listTheme;
    ListPreference listStart;
    ListPreference listLayout;
    @Override
    public void onCreate(Bundle s){
        super.onCreate(s);
        addPreferencesFromResource(R.xml.ime_preferences);
        listTheme = (ListPreference) findPreference("theme");
        listStart = (ListPreference) findPreference("start");
        listLayout = (ListPreference) findPreference("layout");
        listTheme.setSummary(listTheme.getEntry());
        listStart.setSummary(listStart.getEntry());
        listLayout.setSummary(listLayout.getEntry());
        PreferenceManager.getDefaultSharedPreferences(getActivity().getBaseContext()).registerOnSharedPreferenceChangeListener(this);
    }


    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String s) {
        listTheme.setSummary(listTheme.getEntry());
        listStart.setSummary(listStart.getEntry());
        listLayout.setSummary(listLayout.getEntry());
    }
}
