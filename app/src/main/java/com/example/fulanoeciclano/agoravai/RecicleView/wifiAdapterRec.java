package com.example.fulanoeciclano.agoravai.RecicleView;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.fulanoeciclano.agoravai.Modelo.Wifi_modelo;
import com.example.fulanoeciclano.agoravai.R;

import java.util.List;

/**
 * Created by fulanoeciclano on 15/01/2018.
 */

public class wifiAdapterRec extends RecyclerView.Adapter<WifiHolder> {

    private final List<Wifi_modelo> wifi_modelo;

    public wifiAdapterRec(List<Wifi_modelo> wifi_modelo){
        this.wifi_modelo=wifi_modelo;
    }

    public WifiHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new WifiHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_list_cad, parent, false));
    }

    @Override
    public void onBindViewHolder(WifiHolder holder, int position) {
        holder.nomewifi.setText(wifi_modelo.get(position).getNome_wifi());
    }

    @Override
    public int getItemCount()
    {
        return wifi_modelo!=null ?
                wifi_modelo.size():0;
    }
}
