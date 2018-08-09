package mao.com.multiplelayout.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import mao.com.multiplelayout.R;

/**
 * Description:普通的RecyclerView的多布局适配器
 * author:jingmaolin
 * email:1271799407@qq.com.
 * phone:13342446520.
 * date: 2018/8/9.
 */
public class SimpleRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<String> mList;
    private LayoutInflater mInflater;

    private final int HEAD_VIEW = 0;
    private final int MIDDLE_VIEW = 1;
    private final int BOTTOM_VIEW = 2;

    private static final String TAG = "SimpleRecyclerViewAdapt";

    public SimpleRecyclerViewAdapter(Context context, List<String> list) {
        this.mList = list;
        this.mInflater = LayoutInflater.from(context);
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return HEAD_VIEW;
        } else if (position == getItemCount() - 1) {
            return BOTTOM_VIEW;
        } else {
            return MIDDLE_VIEW;
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == HEAD_VIEW) {
            return new HeadViewHolder(mInflater.inflate(R.layout.item_list_head, parent, false));
        } else if (viewType == BOTTOM_VIEW) {
            return new BottomHolder(mInflater.inflate(R.layout.item_list_bottom, parent, false));
        } else {
            return new MiddleHolder(mInflater.inflate(R.layout.item_list_middle, parent, false));
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof HeadViewHolder) {
            HeadViewHolder headViewHolder = (HeadViewHolder) holder;
            headViewHolder.textView.setText(mList.get(position));
            headViewHolder.imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.d(TAG, "imageView is clicked");
                }
            });
            headViewHolder.button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.d(TAG, "button is clicked");
                }
            });
        } else if (holder instanceof MiddleHolder) {
            MiddleHolder middleHolder = (MiddleHolder) holder;
            middleHolder.textView.setText(mList.get(position));
        } else if (holder instanceof BottomHolder) {
            BottomHolder bottomHolder = (BottomHolder) holder;
            bottomHolder.textView.setText(mList.get(position));
        }
    }

    @Override
    public int getItemCount() {
        return mList == null ? 0 : mList.size();
    }

    public static class HeadViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageView;
        private TextView textView;
        private Button button;

        public HeadViewHolder(View itemView) {
            super(itemView);
            button = itemView.findViewById(R.id.head_button);
            imageView = itemView.findViewById(R.id.imageView);
            textView = itemView.findViewById(R.id.head_textView);
        }
    }

    public static class MiddleHolder extends RecyclerView.ViewHolder {
        private TextView textView;

        public MiddleHolder(View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.middle_textView);
        }
    }

    public static class BottomHolder extends RecyclerView.ViewHolder {
        private TextView textView;
        private ImageView imageView;

        public BottomHolder(View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.bottom_textView);
            imageView = itemView.findViewById(R.id.bottom_imageView);
        }
    }
}
