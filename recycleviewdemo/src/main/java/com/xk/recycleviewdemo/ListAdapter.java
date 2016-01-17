package com.xk.recycleviewdemo;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by clks on 2016/1/17.
 */
public class ListAdapter extends RecyclerView.Adapter<ListAdapter.MyHolder> {

    private Context mContent;
    private List<MyBean> mDatas;


    public ListAdapter(Context content,List<MyBean> datas) {
        mContent = content;
        mDatas = datas;
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {//决定根布局
        View itemView = android.view.View.inflate(mContent,R.layout.item,null);//根布局
        return new MyHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyHolder holder, int position) {//填充数据
        holder.setDataAndRefreshUI(mDatas.get(position));
    }

    @Override
    public int getItemCount() {//条目总数量
        if(mDatas!=null){return mDatas.size();}
        return 0;
    }

    public class MyHolder extends RecyclerView.ViewHolder{
        private TextView mTvTitle ;
        private ImageView mIvIcon ;

        public MyHolder(View itemView) {
            super(itemView);
            mTvTitle = (TextView) itemView.findViewById(R.id.tv_name);
            mIvIcon = (ImageView) itemView.findViewById(R.id.iv_icon);
        }

        public void setDataAndRefreshUI(MyBean data) {
            mTvTitle.setText(data.title);
            mIvIcon.setImageResource(data.iconId);
        }
    }
}
