package com.example.dllo.bibilala.bangumi.adapter;
 /*
        quu..__
         $$$b  `---.__
          "$$b        `--.                          ___.---uuudP
           `$$b           `.__.------.__     __.---'      $$$$"              .
             "$b          -'            `-.-'            $$$"              .'|
               ".                                       d$"             _.'  |
                 `.   /                              ..."             .'     |
                   `./                           ..::-'            _.'       |
                    /                         .:::-'            .-'         .'
                   :                          ::''\          _.'            |
                  .' .-.             .-.           `.      .'               |
                  : /'$$|           .@"$\           `.   .'              _.-'
                 .'|$u$$|          |$$,$$|           |  <            _.-'
                 | `:$$:'          :$$$$$:           `.  `.       .-'
                 :                  `"--'             |    `-.     \
                :                |                |#'     `..'`..'          `                 \                                   xXX|     /    ./
                  \                                xXXX'|    /   ./
                  /`-.                                  `.  /   /
                 :    `-  ...........,                   | /  .'
                 |         ``:::::::'       .            |<    `.
                 |             ```          |           x| \ `.:``.
                 |                         .'    /'   xXX|  `:`M`M':.
                 |    |                    ;    /:' xXXX'|  -'MMMMM:'
                 `.  .'                   :    /:'       |-'MMMM.-'
                  |  |                   .'   /'        .'MMM.-'
                  `'`'                   :  ,'          |MMM<
                    |                     `'            |tbap\
                     \                                  :MM.-'
                      \                 |              .''
                       \.               `.            /
                        /     .:::::::.. :           /
                       |     .:::::::::::`.         /
                       |   .:::------------\       /
                      /   .''               >::'  /
                      `',:                 :    .'
                                           `:.:'

         
        */

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.dllo.bibilala.R;
import com.example.dllo.bibilala.entity.bangumentity.BangUmiEntity;

/**
 * Created by dllo on 16/10/22.
 */

public class BangumiPageAdapter extends PagerAdapter implements ViewPager.OnPageChangeListener {
    private Context context;
    private ImageView[] point;
    private BangUmiEntity entity;
    private ViewPager viewPager;

    public void setViewPager(ViewPager viewPager) {
        this.viewPager = viewPager;
    }

    public void setPoint(ImageView[] point) {
        this.point = point;
    }

    public void setEntity(BangUmiEntity entity) {
        this.entity = entity;
    }

    public BangumiPageAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return entity.getResult().getAd().getHead().size()==0 ? 0 : Integer.MAX_VALUE;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {

        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view = LayoutInflater.from(context).inflate(R.layout.view_pager_bang_umi, container, false);
        ImageView imageView = (ImageView) view.findViewById(R.id.item_bang_umi_view_pager_ima);
        Glide.with(context).load(entity.getResult().getAd().getHead().get(position % entity.getResult().getAd().getHead().size()).getImg()).into(imageView);
        container.addView(view);
        viewPager.addOnPageChangeListener(this);
        return view;
    }



    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        if (point!=null&&point.length!=0){
            for (int i = 0; i < point.length; i++) {
                if (i == position % 4) {
                    point[i].setImageResource(R.mipmap.fennima);
                } else {
                    point[i].setImageResource(R.mipmap.bai);
                }
            }
        }


    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {

    }
}
