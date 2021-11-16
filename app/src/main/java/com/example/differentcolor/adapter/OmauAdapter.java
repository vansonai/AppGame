package com.example.differentcolor.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.differentcolor.object.ImgCustom;
import com.example.differentcolor.object.OMau;
import com.example.differentcolor.R;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class OmauAdapter extends ArrayAdapter<OMau> {

    private Context ct;
    private ArrayList<OMau> arrOMau;

    public OmauAdapter(@NonNull Context context, int resource, @NonNull List<OMau> objects) {
        super(context, resource, objects);

        this.ct = context;
        this.arrOMau = new ArrayList<>(objects);
    }
public void upDate(ArrayList<OMau> arr){
        this.arrOMau.clear();
        this.arrOMau.addAll(arr);
        notifyDataSetChanged();
}

    @Override
    public int getCount() {
        return arrOMau.size();
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if(convertView==null){
            LayoutInflater inflater = (LayoutInflater) ct.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.item_o_mau, null);
        }
        if(arrOMau.size() > 0){
            OMau o = arrOMau.get(position);
            ImgCustom imgCustom = convertView.findViewById(R.id.imgOmau);
            imgCustom.setColorFilter(Color.parseColor(o.maMau));
        }

        return convertView;
    }
}
