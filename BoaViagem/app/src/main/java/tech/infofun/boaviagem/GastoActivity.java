package tech.infofun.boaviagem;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.icu.util.Calendar;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;

/**
 * Created by admin on 13/03/2017.
 */

public class GastoActivity extends Activity {

    private int ano, mes, dia;
    private Button dataGasto;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gasto);
        Calendar calendar = Calendar.getInstance();
        ano = calendar.get(Calendar.YEAR);
        mes = calendar.get(Calendar.MONTH);
        dia = calendar.get(Calendar.DAY_OF_MONTH);

        dataGasto = (Button) findViewById(R.id.data);
        dataGasto.setText(dia + "/" + (mes+1) + "/" + ano);
    }

    public void selecionarData(View view){
        showDialog(view.getId());
    }

    @Override
    protected Dialog onCreateDialog(int id){
        if(R.id.data == id){
            return new DatePickerDialog(this, listener, ano, mes, dia);
        }
        return null;
    }

    private DatePickerDialog.OnDateSetListener listener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
            ano = year;
            mes = month;
            dia = dayOfMonth;
            dataGasto.setText(dia + "/" + (mes+1) + "/" + ano);
        }
    };

    }
