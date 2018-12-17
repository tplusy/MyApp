package top.plusy.myapp.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: WangHui
 * Date: 2018/12/17.
 */
public class MyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private SimpleData simpleData;
    List<IDelegateAdapter> delegateAdapterList = new ArrayList<>();

    public MyAdapter(SimpleData simpleData) {
        this.simpleData = simpleData;
    }
    public void addDelegateAdapter(IDelegateAdapter delegateAdapter) {
        delegateAdapterList.add(delegateAdapter);
    }

    @Override
    public int getItemViewType(int position) {
        for(IDelegateAdapter delegateAdapter : delegateAdapterList) {
            if(delegateAdapter.isForViewType(simpleData)) {
                return  delegateAdapterList.indexOf(delegateAdapter);
            }
        }

        throw new RuntimeException("Can not find any delegate adapter.");
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        IDelegateAdapter delegateAdapter = delegateAdapterList.get(viewType);
        RecyclerView.ViewHolder holder = delegateAdapter.onCreateViewHolder(viewGroup, viewType);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int position) {
        int viewType = viewHolder.getItemViewType();
        IDelegateAdapter delegateAdapter = delegateAdapterList.get(viewType);
        delegateAdapter.onBindViewHolder(viewHolder, position, simpleData);
    }

    @Override
    public int getItemCount() {
        return simpleData.dataList.size();
    }
}
