package com.example.api1_2;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class Adapter extends ArrayAdapter {

    Context context;
    ArrayList<DataOperasi> datas = new ArrayList();
    LayoutInflater layoutInflater;

    ImageView img;
    TextView title, lateVersi, dev, website, description;

    public Adapter(Context context, ArrayList<DataOperasi> data) {
        super(context, R.layout.list, data);
        this.context = context;
        layoutInflater = LayoutInflater.from(context);
        this.datas = data;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = layoutInflater.inflate(R.layout.list, parent, false);
        DataOperasi data = datas.get(position);

        img = convertView.findViewById(R.id.imgList);
        title = convertView.findViewById(R.id.titleList);
        lateVersi = convertView.findViewById(R.id.lateVersion);
        dev = convertView.findViewById(R.id.dev);
        website = convertView.findViewById(R.id.website);
        description = convertView.findViewById(R.id.desc);

        Glide
                .with(context)
                .load(data.getLogo())
                .into(img);
        title.setText(data.getName());
        lateVersi.setText(data.getLate());
        dev.setText(data.getDevelover());
        website.setText(data.getWeb());
        description.setText(data.getDesc());

        return convertView;
    }
}