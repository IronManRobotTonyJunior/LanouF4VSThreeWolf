package com.example.dllo.bibilala.live.view;


import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.dllo.bibilala.R;
import com.example.dllo.bibilala.activity.login.SignActivity;
import com.example.dllo.bibilala.entity.live.liverecommend.LiveEntity;
import com.example.dllo.bibilala.entity.live.liverecommend.PartitionEntity;
import com.example.dllo.bibilala.entity.live.liverecommend.RecommendDataEntity;
import com.example.dllo.bibilala.entity.live.livetype.BannerEntity;
import com.example.dllo.bibilala.entity.live.livetype.DataTypeEntity;
import com.example.dllo.bibilala.live.type.view.AllTypeActivitys;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;

import java.util.ArrayList;
import java.util.List;

public class LiveAdapter extends RecyclerView.Adapter implements View.OnClickListener {
    // 推荐主播
    //    private List<LiveEntity> mLiveEntities;
    //    private PartitionEntity mPartitionEntities;
    //    private List<LiveEntity> mLongEntity;
    // 分类主播带轮播图
    private List<BannerEntity> mBannerEntities;
    private List<RecommendDataEntity> mAllPartitionEntities;
    private Context mContext;
    private static final int TYPE_BANNER = 1;
    private static final int TYPE_SEARCH = 2;
    private static final int TYPE_HEAD = 3;
    private static final int TYPE_BODY = 4;
    private static final int TYPE_FOOT = 5;
    private LayoutInflater mInflater;
    private int count = 17 + 6 * 9;
    private List<String> mBannerUrl;
    private PartitionEntity mEntity;
    private final SpannableStringBuilder mBuilderBody;
    private final ForegroundColorSpan mPinkSpan;
    private final SpannableStringBuilder mBuilderHead;
    private onRecyclerViewOnItemListener listener;

    public void setListener(onRecyclerViewOnItemListener listener) {
        this.listener = listener;
    }

    private View.OnClickListener mOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.item_live_search_follow:
                    Toast.makeText(mContext, "请先登录", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(mContext, SignActivity.class);
                    mContext.startActivity(intent);
                    break;
                case R.id.item_live_search_room:
                    Toast.makeText(mContext, "请先登录", Toast.LENGTH_SHORT).show();
                    Intent intentRoom = new Intent(mContext, SignActivity.class);
                    mContext.startActivity(intentRoom);
                    break;
                case R.id.item_live_search_center:
                    Intent intentCenter = new Intent(mContext, SignActivity.class);
                    mContext.startActivity(intentCenter);
                    break;
                case R.id.item_live_search_all:
                    Intent intentAll = new Intent(mContext, AllTypeActivitys.class);
                    mContext.startActivity(intentAll);
                    break;
            }

        }
    };
    private OnRecyclerViewItemClickListener mOnRecyclerViewItemClickListener;


    public void setOnRecyclerViewItemClickListener(OnRecyclerViewItemClickListener onRecyclerViewItemClickListener) {
        mOnRecyclerViewItemClickListener = onRecyclerViewItemClickListener;
    }


    public LiveAdapter(Context context) {
        mInflater = LayoutInflater.from(context);
        mBannerEntities = new ArrayList<>();
        mAllPartitionEntities = new ArrayList<>();
        mContext = context;
        mBuilderBody = new SpannableStringBuilder();
        mBuilderHead = new SpannableStringBuilder();
        mPinkSpan = new ForegroundColorSpan(mContext.getResources().getColor(R.color.colorPinkAlways));
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType) {
            case TYPE_BANNER:
                View bannerView = mInflater.inflate(R.layout.item_live_type_banner, parent, false);
                return new BannerViewHolder(bannerView);
            case TYPE_SEARCH:
                View searchView = mInflater.inflate(R.layout.item_live_type_search, parent, false);
                return new SearchViewHolder(searchView);
            case TYPE_HEAD:
                View headView = mInflater.inflate(R.layout.item_live_type_head, parent, false);
                return new HeadViewHolder(headView);
            case TYPE_BODY:
                View bodyView = mInflater.inflate(R.layout.item_live_type_body, parent, false);
                return new BodyViewHolder(bodyView);
            case TYPE_FOOT:
                View footView = mInflater.inflate(R.layout.item_live_type_foot, parent, false);
                return new FootViewHolder(footView);
            default:
                return null;
        }

    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, int position) {
        int groupPosition = (position - 17) / 6 + 1;
        holder.itemView.setTag(holder);
        holder.itemView.setOnClickListener(this);
        switch (getItemViewType(position)) {
            case TYPE_BANNER:
                BannerViewHolder bannerViewHolder = (BannerViewHolder) holder;
                mBannerUrl = new ArrayList<>();
                for (BannerEntity bannerEntity : mBannerEntities) {
                    mBannerUrl.add(bannerEntity.getImg());
                }
                bannerViewHolder.mBanner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR);
                bannerViewHolder.mBanner.setIndicatorGravity(BannerConfig.RIGHT);
                bannerViewHolder.mBanner.setImages(mBannerUrl);
                break;
            case TYPE_SEARCH:
                final SearchViewHolder searchViewHolder = (SearchViewHolder) holder;
                searchViewHolder.mTvSearchAll.setOnClickListener(mOnClickListener);
                searchViewHolder.mTvSearchCenter.setOnClickListener(mOnClickListener);
                searchViewHolder.mTvSearchFollow.setOnClickListener(mOnClickListener);
                searchViewHolder.mTvSearchRoom.setOnClickListener(mOnClickListener);
                if (listener != null) {
                    searchViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            int position = searchViewHolder.getAdapterPosition();
                            listener.onItemClickListener(searchViewHolder, position, v);
                        }
                    });
                }
                break;
            case TYPE_HEAD:
                HeadViewHolder headViewHolder = (HeadViewHolder) holder;
                if (position >= 17) {
                    mEntity = mAllPartitionEntities.get(groupPosition).getPartition();
                } else {
                    mEntity = mAllPartitionEntities.get(0).getPartition();
                }
//                if (2 == position) {
//                    Glide.with(mContext).load(mPartitionEntities.getSub_icon().getSrc()).into(headViewHolder.mImgHeadIcon);
//                    headViewHolder.mTvHeadText.setText(mPartitionEntities.getName());
//                    headViewHolder.mTvHeadPopulate.setText(mPartitionEntities.getCount());
//                } else {
//                    Glide.with(mContext).load(entity.getSub_icon().getSrc()).into(headViewHolder.mImgHeadIcon);
//                    headViewHolder.mTvHeadText.setText(entity.getName());
//                    headViewHolder.mTvHeadPopulate.setText(entity.getCount());
//                }
                Glide.with(mContext).load(mEntity.getSub_icon().getSrc()).into(headViewHolder.mImgHeadIcon);
                headViewHolder.mTvHeadText.setText(mEntity.getName());
                headViewHolder.mTvHeadPopulate.setText("当前" + mEntity.getCount() + "个主播");
                mBuilderHead.clear();
                mBuilderHead.append(headViewHolder.mTvHeadPopulate.getText());
                mBuilderHead.setSpan(mPinkSpan, 2, headViewHolder.mTvHeadPopulate.getText().length() - 3, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                headViewHolder.mTvHeadPopulate.setText(mBuilderHead);

                break;
            case TYPE_BODY:
                final BodyViewHolder bodyViewHolder = (BodyViewHolder) holder;
                LiveEntity mLiveEntity;
                if (position < 16) {
                    mLiveEntity = mAllPartitionEntities.get(0).getLives().get(position - 3);
                    bodyViewHolder.mTvTitleType.setText("#" + mLiveEntity.getArea() + "# " + mLiveEntity.getTitle());
                    mBuilderBody.clear();
                    mBuilderBody.append(bodyViewHolder.mTvTitleType.getText());
                    mBuilderBody.setSpan(mPinkSpan, 0, 6, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                    bodyViewHolder.mTvTitleType.setText(mBuilderBody);

                } else {
                    mLiveEntity = mAllPartitionEntities.get(groupPosition).getLives().get((position - 1) % 6);
                    bodyViewHolder.mTvTitleType.setText(mLiveEntity.getTitle());
                }
                Glide.with(mContext).load(mLiveEntity.getCover().getSrc()).into(bodyViewHolder.mImgBodyImg);
                bodyViewHolder.mTvAuthor.setText(mLiveEntity.getOwner().getName());
                bodyViewHolder.mTvAudience.setText(mLiveEntity.getOnline() + "");
                final LiveEntity entity = mLiveEntity;
                if (mOnRecyclerViewItemClickListener != null) {
                    bodyViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            mOnRecyclerViewItemClickListener.onItemClick(entity.getPlayurl()
                                    , entity.getTitle()
                                    , entity.getOwner().getName()
                                    , entity.getOnline()
                                    , entity.getRoom_id()
                                    , entity.getOwner().getFace());

                        }
                    });
                }
                break;
            case TYPE_FOOT:
                FootViewHolder footViewHolder = (FootViewHolder) holder;
                footViewHolder.mBtnFootMore.setOnClickListener(this);
                break;
            default:
                break;


        }

    }

    @Override
    public int getItemViewType(int position) {
        if (0 == position) {
            return TYPE_BANNER;
        } else if (1 == position) {
            return TYPE_SEARCH;
        } else if (2 == position || position >= 17 && 0 == (position - 17) % 6) {
            return TYPE_HEAD;
        } else if (position >= 16 && 0 == (position - 16) % 6) {
            return TYPE_FOOT;
        } else {
            return TYPE_BODY;
        }

    }

    @Override
    public int getItemCount() {
        return count;
    }


    public void refreshTypeData(DataTypeEntity datas) {
        mBannerEntities = datas.getBanner();
        Log.d("LiveAdapter", "datas.getBanner().size():" + datas.getBanner().size());
        mAllPartitionEntities = datas.getPartitions();
        notifyDataSetChanged();
    }

    @Override
    public void onClick(View v) {

    }

    public static class BannerViewHolder extends RecyclerView.ViewHolder {

        private final Banner mBanner;

        public BannerViewHolder(View itemView) {
            super(itemView);
            mBanner = (Banner) itemView.findViewById(R.id.item_live_banner);
        }
    }

    public static class HeadViewHolder extends RecyclerView.ViewHolder {

        private ImageView mImgHeadIcon;
        private TextView mTvHeadText;
        private TextView mTvHeadPopulate;

        public HeadViewHolder(View itemView) {
            super(itemView);

            mTvHeadPopulate = (TextView) itemView.findViewById(R.id.item_live_head_population);
            mTvHeadText = (TextView) itemView.findViewById(R.id.item_live_head_text);
            mImgHeadIcon = (ImageView) itemView.findViewById(R.id.item_live_head_icon);
        }
    }

    public static class BodyViewHolder extends RecyclerView.ViewHolder {

        private final ImageView mImgBodyImg;
        private TextView mTvTitleType;
        private TextView mTvAuthor;
        private TextView mTvAudience;

        public BodyViewHolder(View itemView) {
            super(itemView);
            mTvAuthor = (TextView) itemView.findViewById(R.id.item_live_body_author);
            mTvAudience = (TextView) itemView.findViewById(R.id.item_live_body_audience);
            mTvTitleType = (TextView) itemView.findViewById(R.id.item_live_body_title_type);
            mImgBodyImg = (ImageView) itemView.findViewById(R.id.item_live_body_img);


        }
    }

    public static class SearchViewHolder extends RecyclerView.ViewHolder {
        private TextView mTvSearchFollow;
        private TextView mTvSearchCenter;
        private TextView mTvSearchRoom;
        private TextView mTvSearchAll;

        public SearchViewHolder(View itemView) {
            super(itemView);
            mTvSearchFollow = (TextView) itemView.findViewById(R.id.item_live_search_follow);
            mTvSearchRoom = (TextView) itemView.findViewById(R.id.item_live_search_room);
            mTvSearchCenter = (TextView) itemView.findViewById(R.id.item_live_search_center);
            mTvSearchAll = (TextView) itemView.findViewById(R.id.item_live_search_all);
        }
    }

    public static class FootViewHolder extends RecyclerView.ViewHolder {

        private final TextView mTvFootRefresh;
        private final Button mBtnFootMore;

        public FootViewHolder(View itemView) {
            super(itemView);
            mTvFootRefresh = (TextView) itemView.findViewById(R.id.item_live_foot_refresh);
            mBtnFootMore = (Button) itemView.findViewById(R.id.item_live_foot_more);
        }
    }

    public interface OnRecyclerViewItemClickListener {
        void onItemClick(String url, String title, String name, int online, int roomId, String iconUrl);
    }


}

interface onRecyclerViewOnItemListener {
    void onItemClickListener(LiveAdapter.SearchViewHolder holder, int position, View view);
}



