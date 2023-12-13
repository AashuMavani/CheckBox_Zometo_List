package com.example.checkbox_zometo_list;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

public class List_Adapter extends BaseAdapter {
    MainActivity mainActivity;
    TextView total;
    int sum = 0;
    public List_Adapter(MainActivity mainActivity, TextView total) {
        this.mainActivity = mainActivity;
        this.total=total;
    }

    @Override
    public int getCount() {
        return Config.img.length;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        view = LayoutInflater.from(mainActivity).inflate(R.layout.listview_item, parent, false);
        ImageView imageView = view.findViewById(R.id.img_item);
        CheckBox checkBox = view.findViewById(R.id.chekname);
        TextView textView = view.findViewById(R.id.name);
        TextView textView1 = view.findViewById(R.id.price);

        imageView.setImageResource(Config.img[position]);
        textView.setText(Config.name[position]);
        textView.setText("Rs="+Config.price[position]);
        checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkBox.isChecked()) {
                    sum = sum + Config.price[position];
                } else if (!checkBox.isChecked()) {
                    sum = sum - Config.price[position];
                }
             total.setText("Total="+sum);
            }
        });
        return view;
    }
}
