package com.sistemas.omarin.pokemonrest.adaptador;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.sistemas.omarin.pokemonrest.R;
import com.sistemas.omarin.pokemonrest.modelo.Result;

import java.util.ArrayList;

/**
 * Created by Sistemas on 20/04/2017.
 */

public class ResultAdapter extends RecyclerView.Adapter<ResultAdapter.ResultHolder>{

    private ArrayList<Result> dataSet;
    private Context context;

    public interface ResulAdapterListener{
        void OnItemClicked(Result result);
    }

    public ResultAdapter(Context context,ArrayList<Result> dataSet) {
        this.dataSet = dataSet;
        this.context = context;
    }

    @Override
    public ResultAdapter.ResultHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_pokemon, parent, false);
        return new ResultHolder(v); //El nuevo poseedor de la vista inflada
    }

    @Override
    public void onBindViewHolder(ResultAdapter.ResultHolder holder, int position) {
        final Result pokemon = dataSet.get(position);
        holder.tvName.setText(pokemon.getName());
        holder.tvName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*if (context instanceof ResulAdapterListener){
                    ((ResulAdapterListener)context).OnItemClicked(pokemon);
                }*/
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }

    public static class ResultHolder extends RecyclerView.ViewHolder {
        //@BindView(R.id.tv_name)
        TextView tvName;
        public ResultHolder(View itemView) {
            super(itemView);
            //ButterKnife.bind(itemView);
            tvName = (TextView)itemView.findViewById(R.id.tv_name);
        }
    }
}
