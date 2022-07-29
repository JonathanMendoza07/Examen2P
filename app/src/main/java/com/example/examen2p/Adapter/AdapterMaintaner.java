package com.example.examen2p.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.examen2p.Class.MaintanerClass;
import com.example.examen2p.R;

import java.util.ArrayList;

public class AdapterMaintaner  extends RecyclerView.Adapter<AdapterMaintaner.ViewHolderAdapterMaintaner> {

    ArrayList<MaintanerClass> listMaintaner;

    public AdapterMaintaner(ArrayList<MaintanerClass> listMaintaner) {this.listMaintaner =listMaintaner ;}


    @NonNull
    @Override
    public ViewHolderAdapterMaintaner onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_maintaner, null, false);
        return new ViewHolderAdapterMaintaner(view);
    }

    @Override
    public void onBindViewHolder(ViewHolderAdapterMaintaner holder, int position) {
        holder.createTextView.setText(listMaintaner.get(position).getCreate());
    }


    @Override
    public int getItemCount() {
        return listMaintaner.size() ;
    }



    public class ViewHolderAdapterMaintaner extends RecyclerView.ViewHolder {
       TextView createTextView;

        public ViewHolderAdapterMaintaner( View itemView) {
            super(itemView);
            createTextView = itemView.findViewById(R.id.created_at_textview);
        }
    }
}
