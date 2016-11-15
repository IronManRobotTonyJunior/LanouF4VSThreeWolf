package com.example.dllo.bibilala.tool.db;


import android.os.Handler;
import android.os.Looper;

import com.example.dllo.bibilala.app.BiBiLaiLaiApp;
import com.example.dllo.bibilala.entity.search.term.TagNumEntity;
import com.litesuits.orm.LiteOrm;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DBTools {

    private final Handler mHandler;
    private LiteOrm mLiteOrm;
    private final ExecutorService threadPool;

    private DBTools() {
        mLiteOrm = LiteOrm.newSingleInstance(BiBiLaiLaiApp.getContext(), DBValues.SQL_NAME);
        threadPool = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors() + 1);
        mHandler = new Handler(Looper.getMainLooper());
    }

    private static final class SingletonDB {
        private static final DBTools DB_TOOLS = new DBTools();
    }

    public static DBTools getInstance() {
        return SingletonDB.DB_TOOLS;
    }

//    public void insertDB(final Object content) {
//        threadPool.execute(new Runnable() {
//            @Override
//            public void run() {
//                deleteAllDB(content.getClass());
//                mLiteOrm.insert(content);
//            }
//        });
//    }

    public void insertHistoryDB(final TagNumEntity entity) {
        threadPool.execute(new Runnable() {
            @Override
            public void run() {
//                deleteAllDB(TagNumEntity.class);
//                ArrayList<TagNumEntity> historyBeen = queryAllDB(TagNumEntity.class);
//                for (int i = 0; i < historyBeen.size(); i++) {
//                    if (historyBeen.get(i).getName().equals(entity.getName())) {
//                        return;
//
                mLiteOrm.insert(entity);
            }
        });
    }


    public <T> void deleteAllDB(final Class<T> clazz) {
        threadPool.execute(new Runnable() {
            @Override
            public void run() {
                mLiteOrm.delete(clazz);
            }
        });
    }

    public <T> void queryAllDB(final QueryListener<T> queryListener, final Class<T> clazz) {
        threadPool.execute(new Runnable() {
            @Override
            public void run() {
                ArrayList<T> entity = queryDB(clazz);
                mHandler.post(new HandlerRunnable<>(queryListener, entity));
            }


        });
    }

    private <T> ArrayList<T> queryDB(Class<T> clazz) {
        ArrayList<T> entity = mLiteOrm.query(clazz);
        return entity;
    }

    public interface QueryListener<T> {
        void onQuery(List<T> data);
    }

    private class HandlerRunnable<T> implements Runnable {
        private QueryListener<T> mTQueryListener;
        private List<T> mList;

        public HandlerRunnable(QueryListener<T> TQueryListener, List<T> list) {
            mTQueryListener = TQueryListener;
            mList = list;
        }

        @Override
        public void run() {
            mTQueryListener.onQuery(mList);
        }
    }
}
