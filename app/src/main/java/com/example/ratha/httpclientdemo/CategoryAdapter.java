package com.example.ratha.httpclientdemo;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.ratha.httpclientdemo.entity.CategoryResponse;

import java.util.List;

/**
 * Created by Asus on 12/8/2017.
 */

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.ViewHolder> {

    List<CategoryResponse.Category> list;
    Context context;
    public CategoryAdapter(Context context, List<CategoryResponse.Category> list){
        this.list=list;
        this.context=context;
    }
    public void setCategories(List<CategoryResponse.Category> list){
        this.list=list;
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(
                R.layout.category_item, parent,false
        );

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        if(null!=list || !list.isEmpty()){
            CategoryResponse.Category category= list.get(position);
            if(category.getCate_name()!=null){
                holder.tvTitle.setText(category.getCate_name());
            }else{
                holder.tvTitle.setText("");
            }
        }

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        TextView tvTitle;
        public ViewHolder(View item){
            super(item);
            tvTitle=item.findViewById(R.id.title);

        }
    }
}
