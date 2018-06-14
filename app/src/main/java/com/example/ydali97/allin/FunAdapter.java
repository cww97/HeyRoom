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

public class FunAdapter extends ArrayAdapter<FunText>{
    private int resid;
    public FunAdapter(@NonNull Context context, int textViewResourceId, List<FunText> objects) {
        super(context, textViewResourceId, objects);
        resid = textViewResourceId;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        FunText fun = getItem(position);
        View view  = LayoutInflater.from(getContext()).inflate(resid, parent, false);
        ImageView funimage = (ImageView) view.findViewById(R.id.fun_image);
        TextView funname = (TextView) view.findViewById(R.id.fun_name);
        funimage.setImageResource(fun.getImageid());
        funname.setText(fun.getname());
        return view;
    }
}
