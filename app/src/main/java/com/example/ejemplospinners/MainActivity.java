package com.example.ejemplospinners;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.*;

public class MainActivity extends AppCompatActivity {

    Spinner sp;
    TextView tv1;
    Spinner sp2;
    TextView tv2;

    String[] paises= {"España","Francia","Alemania"};
    int[]  imagenes={R.drawable.spain,R.drawable.france,R.drawable.germany};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv1=findViewById(R.id.tv1);
        sp=findViewById(R.id.sp);


        ArrayAdapter<String> adapter=new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,paises);

        sp.setAdapter(adapter);


        tv2=findViewById(R.id.tv2);
        sp2=findViewById(R.id.sp2);

        AdaptadorPersonalizado adaptador2=new AdaptadorPersonalizado();
        sp2.setAdapter(adaptador2);




    }

    public void reaccionaSpinner1(View view) {
        String elementoSeleccionado=sp.getSelectedItem().toString();
        tv1.setText(elementoSeleccionado);
    }

    public void reacccionadaSpinner2(View view) {
        String elementoSeleccionado=sp2.getSelectedItem().toString();
        tv2.setText(elementoSeleccionado);
    }

    private class AdaptadorPersonalizado extends BaseAdapter {
        @Override
        public int getCount() {
            return paises.length;
        }

        @Override
        public Object getItem(int i) {
            return paises[i];
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {

            LayoutInflater inflater=LayoutInflater.from(MainActivity.this);

            view=inflater.inflate(R.layout.spinner,null);

            ImageView iv=view.findViewById(R.id.iv);
            TextView tv=view.findViewById(R.id.tv);

            iv.setImageResource(imagenes[i]);
            tv.setText(paises[i]);

            return view;
        }
    }
}