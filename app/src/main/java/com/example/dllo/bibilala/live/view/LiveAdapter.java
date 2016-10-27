package com.example.dllo.bibilala.live.view;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.dllo.bibilala.R;
import com.example.dllo.bibilala.live.liveentity.liverecommendentity.LiveEntity;
import com.example.dllo.bibilala.live.liveentity.liverecommendentity.PartitionEntity;
import com.example.dllo.bibilala.live.liveentity.liverecommendentity.RecommendDataEntity;
import com.example.dllo.bibilala.live.liveentity.livetypeentity.BannerEntity;
import com.example.dllo.bibilala.live.liveentity.livetypeentity.DataTypeEntity;
import com.youth.banner.Banner;

import java.util.ArrayList;
import java.util.List;

public class LiveAdapter extends RecyclerView.Adapter implements View.OnClickListener {// 推荐主播
//    private List<LiveEntity> mLiveEntities;
//    private PartitionEntity mPartitionEntities;
//    private List<LiveEntity> mLongEntity;
    // 分类主播带轮播图
    private List<BannerEntity> mBannerEntities;
    private List<RecommendDataEntity> mAllPartitionEntities;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

        }
    };


    private Context mContext;
    private static final int TYPE_BANNER = 1;
    private static final int TYPE_SEARCH = 2;
    private static final int TYPE_HEAD = 3;
    private static final int TYPE_BODY = 4;
    private static final int TYPE_FOOT = 5;
    private LayoutInflater mInflater;
    private int count = 17 + 6 * 9;
    private List<String> mBannerUrl;
    private LiveEntity mLiveEntity;
    private PartitionEntity mEntity;
    private final SpannableStringBuilder mBuilder;
    private final ForegroundColorSpan mPinkSpan;

    public LiveAdapter(Context context) {
//        mLiveEntities = new ArrayList<>();
//        mPartitionEntities = new PartitionEntity();
//        mLongEntity = new ArrayList<>();
        mInflater = LayoutInflater.from(context);
        mBannerEntities = new ArrayList<>();
        mAllPartitionEntities = new ArrayList<>();
        mBannerUrl = new ArrayList<>();
        mContext = context;
        mBuilder = new SpannableStringBuilder();
        mPinkSpan = new ForegroundColorSpan(mContext.getResources().getColor(R.color.colorPinkMain));
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
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        int groupPosition = (position - 17) / 6 + 1;
        holder.itemView.setTag(holder);
        holder.itemView.setOnClickListener(this);
        switch (getItemViewType(position)) {
            case TYPE_BANNER:
                BannerViewHolder bannerViewHolder = (BannerViewHolder) holder;
                for (BannerEntity bannerEntity : mBannerEntities) {
                    mBannerUrl.add(bannerEntity.getImg());
                }
                bannerViewHolder.mBanner.setImages(mBannerUrl);
                break;
            case TYPE_SEARCH:
                SearchViewHolder searchViewHolder = (SearchViewHolder) holder;
                searchViewHolder.mTvSearchAll.setOnClickListener(mOnClickListener);
                searchViewHolder.mTvSearchCenter.setOnClickListener(mOnClickListener);
                searchViewHolder.mTvSearchFollow.setOnClickListener(mOnClickListener);
                searchViewHolder.mTvSearchRoom.setOnClickListener(mOnClickListener);
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
                mBuilder.append(mEntity.getCount() + "");
                break;
            case TYPE_BODY:
                BodyViewHolder bodyViewHolder = (BodyViewHolder) holder;

                if (position < 16) {
                    mLiveEntity = mAllPartitionEntities.get(0).getLives().get(position - 3);
                    bodyViewHolder.mTvTitleType.setText("#" + mLiveEntity.getArea() + "# " + mLiveEntity.getTitle());
                    mBuilder.append(bodyViewHolder.mTvTitleType.getText());
                    mBuilder.setSpan(mPinkSpan, 0, 6, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                    bodyViewHolder.mTvTitleType.setText(mBuilder);
//                if (9 == position) {
//                    Glide.with(mContext).load(mLongEntity.get(0).getCover().getSrc()).into(bodyViewHolder.mImgBodyImg);
//                }
                } else {
                    mLiveEntity = mAllPartitionEntities.get(groupPosition).getLives().get((position - 1) % 6);
                    bodyViewHolder.mTvTitleType.setText(mLiveEntity.getTitle());
                }
                Glide.with(mContext).load(mLiveEntity.getCover().getSrc()).into(bodyViewHolder.mImgBodyImg);
                bodyViewHolder.mTvAuthor.setText(mLiveEntity.getOwner().getName());
                bodyViewHolder.mTvAudience.setText(mLiveEntity.getOnline() + "");
                break;
            case TYPE_FOOT:
                FootViewHolder footViewHolder = (FootViewHolder) holder;
                footViewHolder.mBtnFootMore.setOnClickListener(this);
                break;
//            case TYPE_LONG:
//                LongViewHolder longViewHolder = (LongViewHolder) holder;
//                break;
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


//    public void refreshRecommendData(RecommendDataEntity datas) {
//        mLiveEntities = datas.getLives();
//        mPartitionEntities = datas.getPartition();
//        mLongEntity = datas.getBanner_data();
//        notifyDataSetChanged();
//    }

    public void refreshTypeData(DataTypeEntity datas) {
        mBannerEntities = datas.getBanner();
        mAllPartitionEntities = datas.getPartitions();
        notifyDataSetChanged();
    }

    @Override
    public void onClick(View v) {
        RecyclerView.ViewHolder viewHolder = (RecyclerView.ViewHolder) v.getTag();
        int position = viewHolder.getLayoutPosition();


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


}

