package com.expocodetech.ectretrofit2.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.expocodetech.ectretrofit2.R;
import com.expocodetech.ectretrofit2.model.Post;

import java.util.ArrayList;

/**
 * Created by ExpoCode Tech http://expocodetech.com
 */

public class PostRVAdapter extends RecyclerView.Adapter<PostRVAdapter.ViewHolder> {
    private ArrayList<Post> mDataset;
    private Context mContext;

    public interface PostRVAdapterListener{
        void OnItemClicked(Post aPost);
    }

    public PostRVAdapter(Context context, ArrayList<Post> posts){
        mDataset = posts;
        mContext = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.post_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final Post aPost = mDataset.get(position);
        holder.mTvTitle.setText(aPost.getTitle());
        holder.rootView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mContext instanceof PostRVAdapterListener) {
                    ((PostRVAdapterListener) mContext).OnItemClicked(aPost);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        View rootView;
        TextView mTvTitle;
        ViewHolder(View itemView) {
            super(itemView);
            rootView = itemView;
            mTvTitle = (TextView) itemView.findViewById(R.id.tvTitle);
        }
    }
}
