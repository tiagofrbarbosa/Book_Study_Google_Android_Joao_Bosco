package tech.infofun.boaviagem;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by admin on 12/03/2017.
 */

public class DashboardActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dashboard);
    }

    public void selecionarOpcao(View view){

        switch(view.getId()){
            case R.id.nova_viagem:
                startActivity(new Intent(this, ViagemActivity.class));
            case R.id.novo_gasto:
                startActivity(new Intent(this, GastoActivity.class));
                break;
        }

    }
}
