package com.proyecto.roger.mascotas.Adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.mikhaellopez.circularimageview.CircularImageView;
import com.proyecto.roger.mascotas.Pojo.Mascota;
import com.proyecto.roger.mascotas.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

        //      RECIBE UN ARRAY DE MASCOTAS Y LO TRATA PARA QUE LO MUESTRE EL RECYCLERVIEW

public class MascotaAdaptador extends RecyclerView.Adapter<MascotaAdaptador.MascotaViewHolder> {

    ArrayList<Mascota> mascotas;
    Activity activity;

    public MascotaAdaptador(ArrayList<Mascota> mascotas, Activity activity){
        this.activity = activity;
        this.mascotas = mascotas;
    }

    @Override
    public MascotaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mascota,parent,false);
        return new MascotaViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MascotaViewHolder holder, int position) {
        final Mascota mascota = mascotas.get(position);
        Picasso.with(activity)
                .load(mascota.getUrlFoto())
                .placeholder(R.drawable.barney)
                .into(holder.imgFoto);
            holder.tvNombreCV.setText(mascota.getNombreCompleto());
            holder.tvTelefonoCV.setText(String.valueOf(mascota.getLikes()));
    }

    @Override
    public int getItemCount() {
        return mascotas.size();
    }

    public static class MascotaViewHolder extends RecyclerView.ViewHolder{

        private ImageView imgFoto;
        private TextView tvNombreCV;
        private TextView tvTelefonoCV;
        private CircularImageView imgCircular;

        public MascotaViewHolder(View itemView) {
            super(itemView);
            imgFoto = (ImageView) itemView.findViewById(R.id.imgFoto);
            tvNombreCV = (TextView) itemView.findViewById(R.id.tvNombreCV);
            tvTelefonoCV = (TextView) itemView.findViewById(R.id.tvTelefonoCV);
            imgCircular = (CircularImageView) itemView.findViewById(R.id.imagenCircular);
        }
    }
}
