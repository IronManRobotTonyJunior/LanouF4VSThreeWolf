package com.example.dllo.bibilala.search.view;


import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.example.dllo.bibilala.R;
import com.example.dllo.bibilala.base.BaseActivity;
import com.example.dllo.bibilala.entity.search.term.SearchEntity;
import com.example.dllo.bibilala.entity.search.term.TagNumEntity;
import com.example.dllo.bibilala.search.presenter.SearchPresenter;
import com.example.dllo.bibilala.search.scan.ScanActivity;
import com.example.dllo.bibilala.search.searchdetail.view.SearchDetailActivity;
import com.example.dllo.bibilala.tool.db.DBTools;
import com.example.dllo.bibilala.tool.rx.TextObservable;
import com.example.dllo.bibilala.url.UrlClass;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import io.reactivex.functions.Consumer;

public class SearchActivity extends BaseActivity implements View.OnClickListener
        , View.OnLayoutChangeListener, ISearchView<SearchEntity> {

    private LinearLayout mLinearLayout;
    private Animator mAnimator;
    private LinearLayout LinearLayoutAll;
    private AnimatorSet mSet;
    private int mHeight;
    private int mWidth;
    private SearchPresenter mSearchPresenter;
    private EditText mEditSearch;
    private SearchAdapter mSearchAdapter;
    private ListView mLvHistory;
    private List<TagNumEntity> mEntities;
    private List<TagNumEntity> mHistory;
    private LinearLayout mLinearLayoutEdit;
    private Intent mIntentDetail;
    private DBTools mDBTools;


//
//        mAnimatior = ViewAnimationUtils.createCircularReveal(mLinearLayout,
//                mLinearLayout.getWidth(),
//                mLinearLayout.getHeight() / 2,
//                0,
//                mLinearLayout.getWidth() / 2);
//        mAnimatior.setInterpolator(new AccelerateDecelerateInterpolator());
//        mAnimatior.setDuration(2000);
//        mAnimatior.start();


    @Override
    protected int setLayout() {
        return R.layout.custom_dialog;
    }


    @Override
    protected void initView() {
        mHistory = new ArrayList<>();
        mDBTools = DBTools.getInstance();
        mDBTools.queryAllDB(new DBTools.QueryListener<TagNumEntity>() {
            @Override
            public void onQuery(List<TagNumEntity> data) {
                mHistory.addAll(data);
            }
        }, TagNumEntity.class);
        mSearchPresenter = new SearchPresenter(this);
        mLinearLayout = (LinearLayout) findViewById(R.id.search_animator_ll);
        mLinearLayoutEdit = (LinearLayout) findViewById(R.id.dialog_ll);
        LinearLayoutAll = (LinearLayout) findViewById(R.id.search_linear);
        LinearLayoutAll.setOnClickListener(this);
        ImageButton imgBack = (ImageButton) findViewById(R.id.img_search_back);
        ImageButton imgScan = (ImageButton) findViewById(R.id.img_search_scan);
        ImageButton imgSearch = (ImageButton) findViewById(R.id.img_search);
        mEditSearch = (EditText) findViewById(R.id.edit_search);
        mLvHistory = (ListView) findViewById(R.id.lv_search_history);
        imgBack.setOnClickListener(this);
        imgScan.setOnClickListener(this);
        imgSearch.setOnClickListener(this);
        mEntities = new ArrayList<>();
        mIntentDetail = new Intent(SearchActivity.this, SearchDetailActivity.class);
        mLvHistory.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                mIntentDetail.putExtra("keyWord", mEntities.get(position).getName());
                dismissAnimator();
                Log.d("SearchActivity", "ss" + SearchDetailActivity.class.getSimpleName());
                Log.d("SearchActivity", "getActivity(SearchDetailActivity.class.getSimpleName().toString()):" + getActivity(SearchDetailActivity.class.getSimpleName()));
                if (getActivity(SearchDetailActivity.class.getSimpleName()) != null) {
                    getActivity(SearchDetailActivity.class.getSimpleName()).finish();
                    Log.d("SearchActivity", "finish");
                }
                mDBTools.insertDB(mEntities.get(position).getName());
                finish();
                startActivity(mIntentDetail);
            }
        });
    }

    // 延时多少发送网络请求
    @Override
    protected void initData(Bundle savedInstanceState) {
        TextObservable.create(mEditSearch, 100)
                .subscribe(new Consumer<CharSequence>() {
                    @Override
                    public void accept(CharSequence s) throws Exception {
                        mSearchPresenter.startRequest(UrlClass.URL_SEARCH(s.toString()), SearchEntity.class);
                    }
                });
        mSearchAdapter = new SearchAdapter(this, R.layout.item_search_list, mEntities);
        mLvHistory.setAdapter(mSearchAdapter);
        mEntities.addAll(mHistory);
        Log.d("SearchActivity", "mEntities.size():" + mEntities.size());
        mSearchAdapter.notifyDataSetChanged();
    }


    @Override
    protected void onStart() {
        super.onStart();
        mLinearLayout.addOnLayoutChangeListener(this);

    }

    @Override
    public void onLayoutChange(View v, int left, int top, int right, int bottom, int oldLeft, int oldTop, int oldRight, int oldBottom) {
        showAnimator();
    }

    // 点击搜索跳转
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.img_search_back:
            case R.id.search_linear:
                dismissAnimator();
                break;
            case R.id.img_search:
                if (mEditSearch.getText().length() != 0) {
                    mIntentDetail.putExtra("keyWord", mEditSearch.getText().toString());
                    dismissAnimator();
                    if (getActivity(SearchDetailActivity.class.getSimpleName()) != null) {
                        getActivity(SearchDetailActivity.class.getSimpleName()).finish();
                        Log.d("SearchActivity", "finish");
                    }
                    startActivity(mIntentDetail);
                }
                TagNumEntity entity = new TagNumEntity();
                entity.setName(mEditSearch.getText().toString());
                mDBTools.insertDB(entity);
                finish();
                break;
            case R.id.img_search_scan:
                Intent intentScan = new Intent(SearchActivity.this, ScanActivity.class);
                startActivity(intentScan);
                break;

        }

    }


    public void showAnimator() {
        mHeight = mLinearLayoutEdit.getHeight();
        mWidth = mLinearLayoutEdit.getWidth();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            if (mAnimator == null) {
                mAnimator = ViewAnimationUtils.createCircularReveal(mLinearLayout,
                        mWidth,
                        mHeight / 2,
                        0,
                        mWidth);
                mAnimator.removeAllListeners();
                mAnimator.setDuration(500);
                mAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
                if (!mAnimator.isRunning()) {
                    mAnimator.start();
                }
            }

        } else {
            if (mSet == null) {
                ObjectAnimator revealAnimatorX = ObjectAnimator.ofFloat(
                        mLinearLayout, "scaleX", 0, 1);
                ObjectAnimator revealAnimatorY = ObjectAnimator.ofFloat(
                        mLinearLayout, "scaleY", 0, 1);
                ObjectAnimator revealAnimatorPivotX = ObjectAnimator.ofFloat(
                        mLinearLayout, "pivotX", mWidth);
                ObjectAnimator revealAnimatorPivotY = ObjectAnimator.ofFloat(
                        mLinearLayout, "pivotY", mHeight / 2);
                mSet = new AnimatorSet();
                mSet.setDuration(300);
                mSet.setInterpolator(new AccelerateDecelerateInterpolator());
                mSet.playTogether(revealAnimatorX, revealAnimatorY, revealAnimatorPivotX, revealAnimatorPivotY);
                if (!mSet.isRunning()) {
                    mSet.start();
                }
            }
        }

    }


    public void dismissAnimator() {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            mAnimator = ViewAnimationUtils.createCircularReveal(mLinearLayout,
                    mWidth,
                    mHeight / 2,
                    mWidth,
                    0);
            mAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
            mAnimator.setDuration(300);
            mAnimator.start();
        } else {
            ObjectAnimator revealAnimatorX = ObjectAnimator.ofFloat(
                    mLinearLayout, "scaleX", 1, 0);
            ObjectAnimator revealAnimatorY = ObjectAnimator.ofFloat(
                    mLinearLayout, "scaleY", 1, 0);
            ObjectAnimator revealAnimatorPivotX = ObjectAnimator.ofFloat(
                    mLinearLayout, "pivotX", mWidth);
            ObjectAnimator revealAnimatorPivotY = ObjectAnimator.ofFloat(
                    mLinearLayout, "pivotY", mHeight / 2);
            mSet = new AnimatorSet();
            mSet.setDuration(300);
            mSet.setInterpolator(new AccelerateDecelerateInterpolator());
            mSet.playTogether(revealAnimatorX, revealAnimatorY, revealAnimatorPivotX, revealAnimatorPivotY);
            mSet.start();
//            ScaleAnimation scale = null;
//            scale = new ScaleAnimation()
        }
        if (mAnimator != null) {
            mAnimator.addListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    super.onAnimationEnd(animation);
                    finish();
                    overridePendingTransition(0, 0);
                }
            });
        } else {
            mSet.addListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    super.onAnimationEnd(animation);
                    finish();
                    overridePendingTransition(0, 0);
                }
            });
        }

    }


    @Override
    public void onResponse(SearchEntity result) {
        Object tags = result.getTag();
        Map<String, Object> map = (Map<String, Object>) tags;
        if (map != null) {
            mEntities.clear();
            mEntities.addAll(mHistory);
            for (String s : map.keySet()) {
                Object obj = map.get(s);
                Map<String, String> tag = (Map<String, String>) obj;
                String name = tag.get("name");
                String total = tag.get("total");
                Map<String, Double> tagm = (Map<String, Double>) obj;
                Double spid = tagm.get("spid");
                Double ref = tagm.get("ref");
                TagNumEntity tagNum = new TagNumEntity(name, total, spid, ref);
                mEntities.add(tagNum);
                mSearchAdapter.notifyDataSetChanged();
            }
        } else {
            mEntities.clear();
            mEntities.addAll(mHistory);
        }
        mSearchAdapter.notifyDataSetChanged();
    }

    @Override
    public void error() {

    }
}
