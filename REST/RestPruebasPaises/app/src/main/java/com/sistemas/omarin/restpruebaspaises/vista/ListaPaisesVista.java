package com.sistemas.omarin.restpruebaspaises.vista;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.sistemas.omarin.restpruebaspaises.Model.Pais;
import com.sistemas.omarin.restpruebaspaises.Model.PaisResponse;
import com.sistemas.omarin.restpruebaspaises.Adaptador.PaisAdaptador;
import com.sistemas.omarin.restpruebaspaises.R;
import com.sistemas.omarin.restpruebaspaises.restApi.EndPointsApi;
import com.sistemas.omarin.restpruebaspaises.restApi.RestApiAdapter;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListaPaisesVista extends AppCompatActivity {

    private ArrayList<Pais> Paises;
    private RecyclerView rvListaPaises;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lista_paises_vista);

        rvListaPaises = (RecyclerView)findViewById(R.id.rvListaPais);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        rvListaPaises.setLayoutManager(llm);

        obtenerMediosRecientes();
        //crearListaTiendas();
        startAdaptador();
    }
    public void startAdaptador(){
        PaisAdaptador adaptador= new PaisAdaptador(Paises,this);
        rvListaPaises.setAdapter(adaptador);
    }

    public void crearListaTiendas() {
        Paises = new ArrayList<Pais>();
        Paises.add(new Pais("1","Lopez","100"));
        Paises.add(new Pais("2","Aranda","80"));
        Paises.add(new Pais("3","Articulo","40"));
        Paises.add(new Pais("4","Tacubaya","0"));
        Paises.add(new Pais("5","Tlalnepantla","0"));
    }

    public void obtenerMediosRecientes(){
        RestApiAdapter restApiAdapter=new RestApiAdapter();

        EndPointsApi endPointsApi=restApiAdapter.establecerConexion();
        Call<PaisResponse> paisResponseCall =endPointsApi.getRecentDate();

        paisResponseCall.enqueue(new Callback<PaisResponse>() {
            @Override
            public void onResponse(Call<PaisResponse> call, Response<PaisResponse> response) {
                PaisResponse paisResponse = response.body();
                Paises = paisResponse.getPaises();
            }

            @Override
            public void onFailure(Call<PaisResponse> call, Throwable t) {
                Toast.makeText(ListaPaisesVista.this, "Falló conexión", Toast.LENGTH_SHORT).show();
                Log.e("FALLO LA CONEXIÓN: ", t.toString());
            }
        });
    }

}
