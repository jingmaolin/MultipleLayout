package mao.com.multiplelayout.adapter;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import mao.com.multiplelayout.R;

/**
 * Description ：普通的ListView 多布局适配器
 * Created by jingmaolin on 2018/8/9.
 * Job number：600029
 * Phone ：13342446520
 * Email：jingmaolin@syswin.com
 * Person in charge ： jingmaolin
 * Leader：wangyue
 */

public class SimpleListViewAdapter extends BaseAdapter {
    private Context mContext;
    private List<String> mList;

    private final int HEAD_VIEW = 0;
    private final int MIDDLE_VIEW = 1;
    private final int BOTTOM_VIEW = 2;
    private final int VIEW_TYPE_COUNT = 3;

    private int mHeadCount = 0;
    private int mMiddleCount = 0;
    private int mBottomCount = 0;

    private static final String TAG = "maoTest";

    public SimpleListViewAdapter(Context context, List<String> list) {
        this.mContext = context;
        this.mList = list;
    }

    @Override
    public int getCount() {
        return mList == null ? 0 : mList.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getViewTypeCount() {
        return VIEW_TYPE_COUNT;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return HEAD_VIEW;
        } else if (position == getCount() - 1) {
            return BOTTOM_VIEW;
        } else {
            return MIDDLE_VIEW;
        }
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            switch (getItemViewType(position)) {
                case HEAD_VIEW:
                    mHeadCount++;
                    Log.d(TAG, "getView: " + "head null; " + "count=" + mHeadCount);
                    convertView = View.inflate(mContext, R.layout.item_list_head, null);
                    break;
                case MIDDLE_VIEW:
                    mMiddleCount++;
                    Log.d(TAG, "getView: " + "middle null; " + "count=" + mMiddleCount);
                    convertView = View.inflate(mContext, R.layout.item_list_middle, null);
                    break;
                case BOTTOM_VIEW:
                    mBottomCount++;
                    Log.d(TAG, "getView: " + "bottom null; " + "count=" + mBottomCount);
                    convertView = View.inflate(mContext, R.layout.item_list_bottom, null);
                    break;
            }
        }

        TextView textView = null;

        switch (getItemViewType(position)) {
            case HEAD_VIEW:
                textView = convertView.findViewById(R.id.head_textView);
                break;
            case MIDDLE_VIEW:
                textView = convertView.findViewById(R.id.middle_textView);
                break;
            case BOTTOM_VIEW:
                textView = convertView.findViewById(R.id.bottom_textView);
                break;
        }
        textView.setText(mList.get(position));
        return convertView;
    }
}
