package com.example.ydali97.allin;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class LightAdapter extends ArrayAdapter<Light_item>{
    private int resid;
    public LightAdapter(@NonNull Context context, int textViewResourceId, List<Light_item> objects) {
        super(context, textViewResourceId, objects);
        resid = textViewResourceId;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        Light_item light = getItem(position);
        View view  = LayoutInflater.from(getContext()).inflate(resid, parent, false);
        ImageView roomimage = (ImageView) view.findViewById(R.id.room_image);
        TextView roomname = (TextView) view.findViewById(R.id.room_name);
        roomimage.setImageResource(light.getImageid());
        roomname.setText(light.getname());
        return view;
    }
}

