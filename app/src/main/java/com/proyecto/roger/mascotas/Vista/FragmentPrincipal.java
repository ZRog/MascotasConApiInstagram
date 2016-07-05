package com.proyecto.roger.mascotas.Vista;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.proyecto.roger.mascotas.Adapter.MascotaAdaptador;
import com.proyecto.roger.mascotas.Pojo.Mascota;
import com.proyecto.roger.mascotas.Presentador.IRecyclerViewFragmentPresenter;
import com.proyecto.roger.mascotas.Presentador.RecyclerViewFragmentPresenter;
import com.proyecto.roger.mascotas.R;

import java.util.ArrayList;

/**
 * Created by Joan on 29/06/2016.
 */
public class FragmentPrincipal extends Fragment implements IRecyclerViewFragmentView{

    private RecyclerView rvPrincipal;
    private IRecyclerViewFragmentPresenter presenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_principal,container,false);

        rvPrincipal = (RecyclerView) v.findViewById(R.id.rvPrincipal);

        presenter = new RecyclerViewFragmentPresenter(this,getContext(),3);

        return v;
    }

    @Override
    public void generarLinearLayoutVertical() {
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 3);
        rvPrincipal.setLayoutManager(gridLayoutManager);
    }

    @Override
    public MascotaAdaptador crearAdaptador(ArrayList<Mascota> mascotas) {
        MascotaAdaptador adaptador = new MascotaAdaptador(mascotas,getActivity());
        return adaptador;
    }

    @Override
    public void inicializarAdaptadorRV(MascotaAdaptador adaptador) {
        rvPrincipal.setAdapter(adaptador);
    }
}
