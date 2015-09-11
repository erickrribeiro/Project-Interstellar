package com.eribeiro.projectinterstellar.customizado;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.eribeiro.projectinterstellar.R;
import com.eribeiro.projectinterstellar.model.Dado;

import java.util.List;

/**
 * Created by lgpbentes on 09/09/15.
 */
public class ListViewDados extends BaseAdapter{

    LayoutInflater layoutInflater;
    Context context;
    List<Dado> lista;

    public ListViewDados(Context context, List<Dado> lista){
        this.context = context;
        this.lista = lista;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return lista.size();
    }

    @Override
    public Object getItem(int position) {
        return lista.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null){
            LayoutInflater mInflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            convertView = mInflater.inflate(R.layout.dados_linha, null);
        }

        TextView link, data;
        link = (TextView) convertView.findViewById(R.id.dados_linha_link);
        data = (TextView) convertView.findViewById(R.id.dados_linha_data);

        link.setText(lista.get(position).getLink());
        data.setText(lista.get(position).getData());

        return convertView;
    }
}
