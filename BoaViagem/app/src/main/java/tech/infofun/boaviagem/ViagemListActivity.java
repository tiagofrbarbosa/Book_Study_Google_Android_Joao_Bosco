package tech.infofun.boaviagem;

import android.app.AlertDialog;
import android.app.ListActivity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * Created by tfbarbosa on 18/03/17.
 */

public class ViagemListActivity extends ListActivity implements AdapterView.OnItemClickListener, DialogInterface.OnClickListener{

    private List<Map<String, Object>> viagens;
    private AlertDialog alertDialog;
    private int viagemSelecionada;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        String[] de = {"imagem", "destino", "data", "total"};
        int[] para = {R.id.tipoViagem, R.id.destino, R.id.data, R.id.valor};

        SimpleAdapter adapter = new SimpleAdapter(this, listarViagens(), R.layout.lista_viagem,de,para);
        setListAdapter(adapter);
        getListView().setOnItemClickListener(this);

        this.alertDialog = criaALertDialog();
    }

    private List<Map<String, Object>> listarViagens(){
        viagens = new ArrayList<Map<String, Object>>();

        Map<String, Object> item =
                new HashMap<String, Object>();
                item.put("imagem", R.drawable.negocios);
                item.put("destino", "São Paulo");
                item.put("data","02/02/2012 a 04/02/2012");
                item.put("total","Gasto total R$ 314,98");
                viagens.add(item);

                item = new HashMap<String, Object>();
                item.put("imagem", R.drawable.lazer);
                item.put("destino","Maceió");
                item.put("data","14/05/2012 a 22/05/2012");
                item.put("total", "Gasto total R$ 25834,67");
                viagens.add(item);

                return viagens;
    }



    @Override
    public void onClick(DialogInterface dialog, int item){
        switch(item){
            case 0:
                startActivity(new Intent(this, ViagemActivity.class));
                break;
            case 1:
                startActivity(new Intent(this, GastoActivity.class));
                break;
            case 2:
                startActivity(new Intent(this, GastoListActivity.class));
                break;
            case 3:
                viagens.remove(this.viagemSelecionada);
                getListView().invalidateViews();
                break;
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id){
        this.viagemSelecionada = position;
        alertDialog.show();
    }

    private AlertDialog criaALertDialog(){
        final CharSequence[] items = {
                getString(R.string.editar),
                getString(R.string.novo_gasto),
                getString(R.string.gastos_realizados),
                getString(R.string.remover)};

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(R.string.opcoes);
        builder.setItems(items, this);

        return builder.create();
    }
}


















