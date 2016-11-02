package com.example.dllo.bibilala.recommend.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.dllo.bibilala.R;
import com.example.dllo.bibilala.entity.recommendentity.LBBean;

import static com.example.dllo.bibilala.R.id.img;

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
public class RecommenLBdAdapter extends PagerAdapter {



    private LBBean lbBean;
    private Context context;


    public RecommenLBdAdapter(Context context) {
        this.context = context;
    }

    public void setLbBean(LBBean lbBean) {
        this.lbBean = lbBean;
    }

    @Override
    public int getCount() {
        return lbBean == null ? 0 : Integer.MAX_VALUE;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view = LayoutInflater.from(context).inflate(R.layout.lunbo_recommend_item, container, false);
        ImageView imageView = (ImageView) view.findViewById(img);



        Glide.with(context).load(lbBean.getData().get(position % lbBean.getData().size()).getImage()).into(imageView);



        container.addView(view);

//        viewPager.addOnPageChangeListener(this);

        return view;

    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {

    }
//
//    @Override
//    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
//
//    }
//
//    @Override
//    public void onPageSelected(int position) {
//        for (int i = 0; i < tip.length; i++) {
//            if (i== position % lbBean.getData().size()) {
//                tip[i].setImageResource(R.mipmap.red_title);
//
//            }else {
//                tip[i].setImageResource(R.mipmap.white_title);
//            }
//        }
//
//    }
//
//    @Override
//    public void onPageScrollStateChanged(int state) {
//
//    }
}
