package mao.com.multiplelayout;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

import mao.com.multiplelayout.adapter.SimpleRecyclerViewAdapter;

/**
 * Description ：RecyclerView 多布局的简单实现
 * Created by jingmaolin on 2018/8/9.
 * Phone ：13342446520
 * Person in charge ： jingmaolin
 */

public class RecyclerViewTypesActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private LinearLayout mLinearLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recyclerview_types);

        initView();
    }

    private void initView() {
        mRecyclerView = findViewById(R.id.recyclerView);
        mLinearLayout = findViewById(R.id.linearLayout);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayout.VERTICAL, false));
        SimpleRecyclerViewAdapter recyclerViewAdapter = new SimpleRecyclerViewAdapter(this, initData());
        mRecyclerView.setAdapter(recyclerViewAdapter);
        mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
                if (layoutManager instanceof LinearLayoutManager) {
                    LinearLayoutManager manager = (LinearLayoutManager) layoutManager;
                    int position = manager.findFirstVisibleItemPosition();
                    if (position >= 0) {
                        mLinearLayout.setVisibility(View.VISIBLE);
                    } else {
                        mLinearLayout.setVisibility(View.GONE);
                    }
                }
            }
        });
    }

    private List<String> initData() {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            if (i == 0) {
                list.add("this is header");
            } else if (i == 49) {
                list.add("this is tail");
            } else {
                list.add("this is content");
            }
        }
        return list;
    }
}
