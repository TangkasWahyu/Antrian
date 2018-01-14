package com.apk.antrian.antrian;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class AntrianAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<Person> list;

    public AntrianAdapter(List<Person> list) {
        this.list = list;
    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new AntrianViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.listview_activity,parent,false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((AntrianViewHolder)holder).bind(list.get(position),position);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    private class AntrianViewHolder extends RecyclerView.ViewHolder {
        TextView no = (TextView)itemView.findViewById(R.id.viewnomor);
        TextView nama = (TextView)itemView.findViewById(R.id.viewname);
        public AntrianViewHolder(View itemView) {
            super(itemView);
        }

        public void bind(Person person, int position) {
            no.setText(String.valueOf(person.getId()));
            nama.setText(person.getNama());
        }
    }
}
