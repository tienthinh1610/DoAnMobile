package com.huflit.doanmobile.adapter;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;

import com.huflit.doanmobile.R;
import com.huflit.doanmobile.SqlHelper.Mydatabase;
import com.huflit.doanmobile.activity.CategoryListActivity;
import com.huflit.doanmobile.activity.TrangchuActivity;
import com.huflit.doanmobile.classs.Book;
import com.huflit.doanmobile.classs.Category;
import com.huflit.doanmobile.classs.Users;

import java.util.ArrayList;
import java.util.List;

public class AdapterLvNav extends BaseAdapter {
    private Context mContext;
    private List<Category> mcateList;
    private String musername;

    public AdapterLvNav(Context context, List<Category> cateList, String username) {
        mContext = context;
        mcateList = cateList;
        musername = username;
    }

    @Override
    public int getCount() {
        return mcateList.size();
    }

    @Override
    public Object getItem(int position) {
        return mcateList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        AdapterLvNav.ViewHolder holder;

        if (view == null) {
            LayoutInflater inflater = LayoutInflater.from(mContext);
            view = inflater.inflate(R.layout.layout_itemnav, null);
            holder = new AdapterLvNav.ViewHolder();
            holder.txtnamecate = (TextView) view.findViewById(R.id.tv_namecate);
            view.setTag(holder);
        } else {
            holder = (AdapterLvNav.ViewHolder) view.getTag();
        }

        final Category cate = mcateList.get(position);
        holder.txtnamecate.setText(cate.getCatename());
        holder.txtnamecate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent a = new Intent(mContext, CategoryListActivity.class);
                Bundle b = new Bundle();
                b.putInt("categoryID", cate.getCateId());
                b.putString("categoryname", cate.getCatename());
                b.putString("username", musername);
                a.putExtras(b);
                mContext.startActivity(a);
            }
        });
        return view;
    }

    static class ViewHolder {
        TextView txtnamecate;
    }
}
