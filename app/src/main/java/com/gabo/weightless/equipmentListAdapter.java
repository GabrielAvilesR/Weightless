package com.gabo.weightless;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by LIC on 08/03/2017.
 */

public class equipmentListAdapter extends BaseAdapter implements ListAdapter{
    private ArrayList<Equipment> data;
    private Activity activity;

    public equipmentListAdapter(ArrayList<Equipment> data, Activity activity){
        this.data = data;
        this.activity = activity;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return data.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView == null){
            convertView = activity.getLayoutInflater().inflate(R.layout.equipmentrow, null);
        }
        TextView name, owner;
        name = (TextView) convertView.findViewById(R.id.title);
        owner = (TextView) convertView.findViewById(R.id.owner);
        name.setText(data.get(position).getName());
        owner.setText(data.get(position).getOwner());

        return convertView;
    }
}
