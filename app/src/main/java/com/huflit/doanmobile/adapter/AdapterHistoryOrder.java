package com.huflit.doanmobile.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.huflit.doanmobile.R;
import com.huflit.doanmobile.activity.OrderDetailActivity;
import com.huflit.doanmobile.classs.HistoryOrder;

import java.util.ArrayList;
import java.util.List;

public class AdapterHistoryOrder extends ArrayAdapter<HistoryOrder> {
    private Context context;
    private List<HistoryOrder> historyOrders;

    public AdapterHistoryOrder(Context context, int resource, List<HistoryOrder> objects) {
        super(context, resource, objects);
        this.context = context;
        this.historyOrders = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.layout_item_historyorder, parent, false);
        }
        HistoryOrder historyOrder = historyOrders.get(position);

        TextView Madonhang = convertView.findViewById(R.id.tv_madonhang);
        Madonhang.setText("Đơn hàng #123" + historyOrder.getOrderid());

        TextView chitiet = convertView.findViewById(R.id.tv_chitiet);
        chitiet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, OrderDetailActivity.class);
                Bundle b = new Bundle();
                b.putInt("orderID", historyOrder.getOrderid());
                intent.putExtras(b);
                context.startActivity(intent);
            }
        });

        return convertView;
    }
}
