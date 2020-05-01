package com.example.warehouse;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class LinearAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    private Context mContext;
    private  OnItemClickListener mListener;
//    private List<String> list;

    public LinearAdapter(Context context,OnItemClickListener listener){
        this.mContext =context;
        this.mListener = listener;
    }

    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        if(viewType == 0)
            return new LinearViewHolder(LayoutInflater.from(mContext).inflate(R.layout.layout_linear_item,parent,false));

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        if(getItemViewType(position)==0) {
            ((LinearViewHolder)holder).textView.setText("货物1");
            ((LinearViewHolder)holder).imageView.setImageResource(R.drawable.good1);
        }
        else if(getItemViewType(position)==1){
            ((LinearViewHolder)holder).textView.setText("货物2");
            ((LinearViewHolder)holder).imageView.setImageResource(R.drawable.good2);
        }
        else if(getItemViewType(position)==2){
            ((LinearViewHolder)holder).textView.setText("货物3");
            ((LinearViewHolder)holder).imageView.setImageResource(R.drawable.good3);
        }
        else {
            ((LinearViewHolder)holder).textView.setText("货物4");
            ((LinearViewHolder)holder).imageView.setImageResource(R.drawable.good4);
        }
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.onClick(position);
            }
        });
    }

    @Override
    public int getItemViewType(int position) {
        if(position % 4 ==0){
            return  0;
        }
        else if(position % 4 == 1){
            return 1;
        }
        else if(position % 4 == 2){
            return 2;
        }
        else {
            return 3;
        }
//        return super.getItemViewType(position);
    }

    @Override
    public int getItemCount() {
        return 8;
    }

    class LinearViewHolder extends RecyclerView.ViewHolder{

        private TextView textView;
        private ImageView imageView;

        public LinearViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.tv_title);
            imageView = itemView.findViewById(R.id.iv_image);
        }
    }



    public interface OnItemClickListener{
        void onClick(int pos);
    }
}
