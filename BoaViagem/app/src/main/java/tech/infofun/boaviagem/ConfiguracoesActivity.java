package tech.infofun.boaviagem;

import android.os.Bundle;
import android.preference.PreferenceActivity;

/**
 * Created by tfbarbosa on 19/03/17.
 */
public class ConfiguracoesActivity extends PreferenceActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.preferencias);
    }
}
