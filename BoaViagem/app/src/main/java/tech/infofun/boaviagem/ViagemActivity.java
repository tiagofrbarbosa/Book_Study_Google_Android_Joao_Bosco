package tech.infofun.boaviagem;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;

import java.util.Calendar;

/**
 * Created by admin on 13/03/2017.
 */

public class ViagemActivity extends Activity {
    private DatabaseHelper helper;
    private EditText destino, quantidadedePessoas, orcamento;
    private RadioGroup radioGroup;
    private int ano, mes, dia;
    private Button dataChegadaButton, dataSaidaButton;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nova_viagem);

        Calendar calendar = Calendar.getInstance();
        ano = calendar.get(Calendar.YEAR);
        mes = calendar.get(Calendar.MONTH);
        dia = calendar.get(calendar.DAY_OF_MONTH);

        dataChegadaButton = (Button) findViewById(R.id.dataChegada);
        dataSaidaButton = (Button) findViewById(R.id.dataSaida);

        destino = (EditText) findViewById(R.id.destino);
        quantidadedePessoas = (EditText) findViewById(R.id.quantidadedePessoas);
        orcamento = (EditText) findViewById(R.id.orcamento);
        radioGroup = (RadioGroup) findViewById(R.id.tipoViagem);

        helper = new DatabaseHelper(this);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.viagem_menu, menu);
        return true;
    }

    @Override
    public boolean onMenuItemSelected(int featureId, MenuItem item){
        switch(item.getItemId()){
            case R.id.novo_gasto:
                startActivity(new Intent(this,GastoActivity.class));
                return true;
            case R.id.remover:
                return true;
            default:
                return super.onMenuItemSelected(featureId, item);
        }
    }

    public void salvarViagem(View view){
        SQLiteDatabase db = helper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("destino", destino.getText().toString());
        values.put("data_chegada",dataChegadaButton.getTime());
    }
}






















