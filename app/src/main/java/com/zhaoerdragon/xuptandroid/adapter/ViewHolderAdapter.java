package com.zhaoerdragon.xuptandroid.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.zhaoerdragon.xuptandroid.R;

import java.util.List;

/**
 * ListView适配类，可以在使用ListView的地方通用，只需要修改文件和参数就行了
 */
public class ViewHolderAdapter extends BaseAdapter{

    private List<String> stringList;
    private LayoutInflater layoutInflater;

    public ViewHolderAdapter(Context context, List<String> strings){
        stringList = strings;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return stringList.size();
    }

    @Override
    public Object getItem(int position) {
        return stringList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if(convertView == null){
            viewHolder = new ViewHolder();
            convertView = layoutInflater.inflate(R.layout.adapter_viewholder,null);
            viewHolder.textView = (TextView)convertView.findViewById(R.id
                    .adapter_viewholder_textview);
            convertView.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder)convertView.getTag();
        }
        viewHolder.textView.setText(stringList.get(position));
        return convertView;
    }

    public class ViewHolder{
        public TextView textView;
    }
}
