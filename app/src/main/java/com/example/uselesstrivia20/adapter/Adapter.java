package com.example.uselesstrivia20.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.uselesstrivia20.R;
import com.example.uselesstrivia20.levels.Level1;
import com.example.uselesstrivia20.levels.Level2;
import com.example.uselesstrivia20.levels.Level3;
import com.example.uselesstrivia20.levels.Level4;
import com.example.uselesstrivia20.levels.Level5;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    List<String> livelli;
    Context context;
    LayoutInflater inflater;

    public Adapter(Context ctx, List<String> livelli){
        this.livelli = livelli;
        this.context = ctx;
        this.inflater = LayoutInflater.from(ctx);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.custom_grid_layout,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.txtNomeLivello.setText(livelli.get(position));
    }

    @Override
    public int getItemCount() {
        return livelli.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView txtNomeLivello;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtNomeLivello = itemView.findViewById(R.id.txtNomeLivello);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    switch (getAdapterPosition()){
                        case 0: context.startActivity(new Intent(context, Level1.class)); break;
                        case 1: context.startActivity(new Intent(context, Level2.class)); break;
                        case 2: context.startActivity(new Intent(context, Level3.class)); break;
                        case 3: context.startActivity(new Intent(context, Level4.class)); break;
                        case 4: context.startActivity(new Intent(context, Level5.class)); break;
                        default:break;
                    }
                }
            });
        }
    }

}
