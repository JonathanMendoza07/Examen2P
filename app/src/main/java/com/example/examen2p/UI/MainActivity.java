package com.example.examen2p.UI;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.example.examen2p.Adapter.AdapterMaintaner;
import com.example.examen2p.Class.MaintanerClass;
import com.example.examen2p.R;
import com.example.examen2p.Rest.Model.MaintanerModel;
import com.example.examen2p.Rest.Service.Maintaner;
import com.example.examen2p.Rest.ConfigAPI;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    public Maintaner maintanerPeticion;
    public RecyclerView recyclerViewMaintener;

    public ArrayList<MaintanerClass> listMaintaner = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        maintanerPeticion = ConfigAPI.client().create(Maintaner.class);
        recyclerViewMaintener = findViewById(R.id.Recycler_view_maintener);
        peticionesManteiner();

    }

    private void peticionesManteiner(){
        Call<List<MaintanerModel>> call =  maintanerPeticion.getListMaintainer();
        call.enqueue(new Callback<List<MaintanerModel>>() {
            @Override
            public void onResponse(Call<List<MaintanerModel>> call, Response<List<MaintanerModel>> response) {
                Log.d("responseMaintaner", response.code()+"");

                List<MaintanerModel> responseData = response.body();

                for (MaintanerModel itemlist: responseData){
                listMaintaner.add( new MaintanerClass(itemlist.id));
                listMaintaner.add(new MaintanerClass(itemlist.created_at));
                }

                AdapterMaintaner adapterMaintaner = new AdapterMaintaner(listMaintaner);
                recyclerViewMaintener.setLayoutManager( new LinearLayoutManager(getBaseContext()));
                recyclerViewMaintener.setAdapter(adapterMaintaner);
            }

            @Override
            public void onFailure(Call<List<MaintanerModel>> call, Throwable t) {
                Log.d("ResponseMaintener", t.getMessage());
                call.cancel();

            }
        });
    }
}