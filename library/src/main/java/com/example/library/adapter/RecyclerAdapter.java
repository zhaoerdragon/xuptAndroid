package com.example.library.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.example.library.R;

import java.util.ArrayList;

/**
 * RecyclerView适配器的基本架构
 */
public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder> {

    private ArrayList<String> mStrings;
    private Context mContext;

    public RecyclerAdapter(Context context, ArrayList<String> arrayList) {
        mContext = context;
        mStrings = arrayList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        MyViewHolder viewHolder = new MyViewHolder(LayoutInflater.from(mContext).inflate(R.layout
                .adapter_recycler, parent, false));
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.textView.setText(mStrings.get(position));
    }

    @Override
    public int getItemCount() {
        return mStrings.size();
    }

    //定义ViewHolder
    public class MyViewHolder extends RecyclerView.ViewHolder{

        public TextView textView;

        public MyViewHolder(View itemView) {
            super(itemView);
            textView = (TextView)itemView;
        }
    }

}
