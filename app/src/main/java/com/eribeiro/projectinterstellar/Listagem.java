package com.eribeiro.projectinterstellar;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.ListView;

import com.eribeiro.projectinterstellar.customizado.ListViewDados;
import com.eribeiro.projectinterstellar.modelDAO.DadoDAO;

/**
 * Created by lgpbentes on 09/09/15.
 */
public class Listagem extends ActionBarActivity {
    private DadoDAO dadoDAO;
    ListView listView;
    ListViewDados listViewDados;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listagem_dados);
        this.dadoDAO = new DadoDAO(getApplicationContext());
        listView = (ListView) findViewById(R.id.listView);

        listViewDados = new ListViewDados(getApplicationContext(), dadoDAO.getDados());
        listView.setAdapter(listViewDados);
    }

}
