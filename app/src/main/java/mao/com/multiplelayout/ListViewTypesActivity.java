package mao.com.multiplelayout;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import mao.com.multiplelayout.adapter.SimpleListViewAdapter;

/**
 * Description ：ListView多布局的简单实现
 * Created by jingmaolin on 2018/8/9.
 * Phone ：13342446520
 */

public class ListViewTypesActivity extends Activity {
    private ListView mListView;
    private LinearLayout mLinearLayout;
    private SimpleListViewAdapter mAdapter;

    private static final String TAG = "maoTest";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview_types);
        initView();
        judgeFocus();
    }

    private void initView() {
        mListView = findViewById(R.id.listView);
        mLinearLayout = findViewById(R.id.linearLayout);
        mAdapter = new SimpleListViewAdapter(this, initData());
        addHeader();
        mListView.setAdapter(mAdapter);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.d(TAG, "onItemClick: " + position);
            }
        });
        Log.d(TAG, "initView: " + mAdapter.getCount());

        mListView.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {

            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
                if (firstVisibleItem >= 2) {
                    mLinearLayout.setVisibility(View.VISIBLE);
                } else {
                    mLinearLayout.setVisibility(View.GONE);
                }
            }
        });
    }

    private void addHeader() {
        TextView textView = new TextView(this);
        textView.setText("添加头部");
        textView.setGravity(Gravity.CENTER);
        AbsListView.LayoutParams params = new AbsListView.LayoutParams(AbsListView.LayoutParams.MATCH_PARENT, AbsListView.LayoutParams.WRAP_CONTENT);
        textView.setLayoutParams(params);

        TextView textView2 = new TextView(this);
        textView2.setText("添加头部2");
        textView2.setGravity(Gravity.CENTER);
        AbsListView.LayoutParams params2 = new AbsListView.LayoutParams(AbsListView.LayoutParams.MATCH_PARENT, AbsListView.LayoutParams.WRAP_CONTENT);
        textView2.setLayoutParams(params2);

        mListView.addHeaderView(textView);
        mListView.addHeaderView(textView2);
    }

    private List<String> initData() {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            if (i == 0) {
                list.add("this is head");
            } else if (i == 49) {
                list.add("this is tail");
            } else {
                list.add("just simple content");
            }
        }
        return list;
    }

    private void judgeFocus() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    View rootView = getWindow().getDecorView();
                    Log.d(TAG, "current focus is : " + rootView.findFocus().getClass().getSimpleName());
                }

            }
        }).start();
    }
}
