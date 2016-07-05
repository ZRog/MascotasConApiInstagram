package com.proyecto.roger.mascotas;


import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.proyecto.roger.mascotas.Adapter.PageAdapter;
import com.proyecto.roger.mascotas.Mail.Contacto;
import com.proyecto.roger.mascotas.Vista.FragmentPrincipal;
import com.proyecto.roger.mascotas.Vista.RecyclerViewFragment;

import java.util.ArrayList;

        //CONTROLAMOS Y ACTIVAMOS EL VIEWPAGER

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.miToolbar);
        tabLayout = (TabLayout) findViewById(R.id.TabLayout);
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        setUpViewPager();

        if(toolbar!=null) {
            setSupportActionBar(toolbar);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_opciones,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.ConfigurarCuenta:
                Intent intent = new Intent(MainActivity.this,ConfigurarCuenta.class);
                startActivity(intent);
                break;

            case R.id.contacto:
                Intent intent2 = new Intent(MainActivity.this, Contacto.class);
                startActivity(intent2);
                break;

            case R.id.acercaDe:
                Intent intent3 = new Intent(MainActivity.this, AcercaDe.class);
                startActivity(intent3);
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    private ArrayList<Fragment> agregarFragments(){
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new RecyclerViewFragment());
        fragments.add(new FragmentPrincipal());

        return fragments;
    }

    private void setUpViewPager(){
        viewPager.setAdapter(new PageAdapter(getSupportFragmentManager(), agregarFragments()));
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setIcon(R.drawable.ic_casa);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_animal);
    }
}
