package com.example.fulanoeciclano.agoravai.RecicleView;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.fulanoeciclano.agoravai.R;

/**
 * Created by fulanoeciclano on 15/01/2018.
 */

public class WifiHolder extends  RecyclerView.ViewHolder {

    public TextView nomewifi;
    public ImageButton btnEditar;
    public ImageButton btnExcluir;

    public WifiHolder(View itemView) {
        super(itemView);
        nomewifi =(TextView) itemView.findViewById(R.id.nomeWifi);
        //btnEditar = (ImageButton) itemView.findViewById(R.id.btnEdit);
        //btnExcluir = (ImageButton) itemView.findViewById(R.id.btnDelete);
    }
}