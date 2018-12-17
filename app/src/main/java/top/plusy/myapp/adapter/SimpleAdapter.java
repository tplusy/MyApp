package top.plusy.myapp.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import top.plusy.myapp.R;

/**
 * Author: WangHui
 * Date: 2018/12/17.
 */
public class SimpleAdapter implements IDelegateAdapter{

    onItemClickListener listener;

    public void setOnItemClickListener(onItemClickListener listener) {
        this.listener = listener;
    }

    @Override
    public boolean isForViewType(SimpleData data) {
        return data.dataType == 1;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int ViewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.simple_layout, parent, false);
        SimpleViewHolder holder = new SimpleViewHolder(view);
        holder.setOnItemClickListener(listener);
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position, SimpleData data) {
        SimpleViewHolder viewHolder = (SimpleViewHolder) holder;
        MyData myData = (MyData) data.dataList.get(position);
        viewHolder.title.setText(myData.title);
    }

    static class SimpleViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView title;
        onItemClickListener mOnItemClickListener;

        public SimpleViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.textView);
            itemView.setOnClickListener(this);
        }

        public void setOnItemClickListener(onItemClickListener listener)
        {
            this.mOnItemClickListener = listener;
        }

        @Override
        public void onClick(View v) {
            if(mOnItemClickListener != null) {
                mOnItemClickListener.onItemClick(v, getAdapterPosition());
            }
        }
    }
}
