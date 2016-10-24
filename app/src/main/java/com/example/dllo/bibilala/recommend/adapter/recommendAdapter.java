package com.example.dllo.bibilala.recommend.adapter;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.dllo.bibilala.R;
import com.example.dllo.bibilala.recommendentity.AllBean;
import com.example.dllo.bibilala.recommendentity.LBBean;

import java.util.ArrayList;

import static android.R.attr.y;
import static android.icu.lang.UCharacter.GraphemeClusterBreak.L;

/**
 * 　　　　　　　　┏┓　　　┏┓+ +
 * 　　　　　　　┏┛┻━━━┛┻┓ + +
 * 　　　　　　　┃　　　　　　　┃
 * 　　　　　　　┃　　　━　　　┃ ++ + + +
 * 　　　　　　 ████━████ ┃+
 * 　　　　　　　┃　　　　　　　┃ +
 * 　　　　　　　┃　　　┻　　　┃
 * 　　　　　　　┃　　　　　　　┃ + +
 * 　　　　　　　┗━┓　　　┏━┛
 * 　　　　　　　　　┃　　　┃
 * 　　　　　　　　　┃　　　┃ + + + +
 * 　　　　　　　　　┃　　　┃　　　　Code is far away from bug with the animal protecting
 * 　　　　　　　　　┃　　　┃ + 　　　　神兽保佑,代码无bug
 * 　　　　　　　　　┃　　　┃
 * 　　　　　　　　　┃　　　┃　　+
 * 　　　　　　　　　┃　 　　┗━━━┓ + +
 * 　　　　　　　　　┃ 　　　　　　　┣┓
 * 　　　　　　　　　┃ 　　　　　　　┏┛
 * 　　　　　　　　　┗┓┓┏━┳┓┏┛ + + + +
 * 　　　　　　　　　　┃┫┫　┃┫┫
 * 　　　　　　　　　　┗┻┛　┗┻┛+ + + +
 * <p/>
 * Created by 刘城羊 on 16/7/10.
 */
public class RecommendAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private ArrayList<Integer>types;
    private Context context;
    private AllBean allBean;
    private LBBean lbBean;

    public void setLbBean(LBBean lbBean) {
        this.lbBean = lbBean;
    }

    public void setTypes(ArrayList<Integer> types) {
        this.types = types;
    }

    public void setAllBean(AllBean allBean) {
        this.allBean = allBean;
    }

    public RecommendAdapter(Context context) {
        this.context = context;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //加载Item iew 的时候根据不同Type 加载不同的布局
        RecyclerView.ViewHolder holder =null;

        switch (viewType) {
            case   0:
                View view = LayoutInflater.from(context).inflate(R.layout.recommend_lunbo,parent,false);
                holder = new LBHolder(view);


                break;

        }






        return holder;
    }



    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        int viewType =getItemViewType(position);
        switch (viewType) {
            case 0:
                LBHolder lbHolder = (LBHolder) holder;
                lbHolder.lBdAdapter.setLbBean(lbBean);
                lbHolder.viewPager.setAdapter(lbHolder.lBdAdapter);
                speed(lbHolder);


        }





    }

    private void speed(final LBHolder lbHolder) {

        lbHolder.handler =new Handler(new Handler.Callback() {
            @Override
            public boolean handleMessage(Message message) {
                lbHolder.viewPager.setCurrentItem(lbHolder.viewPager.getCurrentItem() + 1);
                return false;
            }
        });
        



    }

    @Override
    public int getItemCount() {
        return types.size();
    }


    @Override
    public int getItemViewType(int position) {
        return types.get(position);
    }



    private class LBHolder extends RecyclerView.ViewHolder {
        private ViewPager viewPager;
        private RecommenLBdAdapter lBdAdapter;
        private boolean mFalg = true;
        private boolean flag = true;
        private Handler handler;

        public LBHolder(View view) {
            super(view);

        }
    }



}
