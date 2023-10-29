package com.example.group9.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.group9.ProductDetail;
import com.example.group9.R;
import com.example.group9.model.Foods;

import java.text.DecimalFormat;
import java.util.List;

public class FoodsAdapter extends BaseAdapter {

    private Context context;
    private int layout;
    private List<Foods> foodsList;

    public FoodsAdapter(Context context, int layout, List<Foods> foodsList) {
        this.context = context;
        this.layout = layout;
        this.foodsList = foodsList;
    }

    @Override
    public int getCount() {
        return foodsList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    private class ViewHolder{
        ImageView imageClothes;
        TextView nameClothes;
        TextView price;
    }
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if(view == null){
            holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(layout, null);
            holder.nameClothes= (TextView) view.findViewById(R.id.nameFoods);
            holder.price= (TextView) view.findViewById(R.id.priceFoods);
            holder.imageClothes = (ImageView) view.findViewById(R.id.imageFoods) ;
            view.setTag(holder);
        }else{
            holder = (ViewHolder) view.getTag();
        }
        Foods foods = foodsList.get(i);
        holder.nameClothes.setText(foods.getNameFoods());
        // Định dạng giá tiền
        DecimalFormat decimalFormat = new DecimalFormat("#,##0.00");
        String formattedPrice = "$" + decimalFormat.format(foods.getPriceFoods());
        holder.price.setText("Price : " + formattedPrice);
        holder.imageClothes.setImageResource(foods.getImageFoods());



        // Lắng nghe sự kiện click trên mỗi mục sản phẩm
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Lấy sản phẩm tại vị trí i
                Foods foods = foodsList.get(i);

                // Tạo Intent để chuyển đến ProductDetailActivity
                Intent intent = new Intent(context, ProductDetail.class);

                // Truyền dữ liệu sản phẩm (ví dụ: ID sản phẩm) vào Intent
                intent.putExtra("product_id", foods.getIdFoods());

                // Chuyển đến ProductDetailActivity
                context.startActivity(intent);
            }
        });

        return view;
    }
}
