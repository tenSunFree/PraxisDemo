package com.home.praxisdemo.list.view;

import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseViewHolder;
import com.home.praxisdemo.R;
import com.home.praxisdemo.common.base.BaseHeaderAdapter;
import com.home.praxisdemo.home.model.HomePojo;
import com.home.praxisdemo.list.model.ListMultiItemEntity;

import java.util.List;

public class ListBaseHeaderAdapter<T extends ListMultiItemEntity> extends BaseHeaderAdapter<T> {

    public ListBaseHeaderAdapter(List<T> data) {
        super(data);
    }

    @Override
    protected void addItemTypes() {
        addItemType(BaseHeaderAdapter.TYPE_HEADER, R.layout.item_pinned_header);
        addItemType(BaseHeaderAdapter.TYPE_DATA, R.layout.item_data);
    }

    @Override
    protected void convert(BaseViewHolder holder, T item) {
        switch (holder.getItemViewType()) {
            case BaseHeaderAdapter.TYPE_HEADER:
                holder.setText(R.id.tv_animal, item.getPinnedHeaderName());
                break;
            case BaseHeaderAdapter.TYPE_DATA:
                HomePojo.Result.Results results = (HomePojo.Result.Results) item.getData();
                ImageView imageView = holder.getView(R.id.image_view);
                holder.setText(R.id.text_view, results.getF_Name_En());
                Glide.with(imageView.getContext()).load(results.getF_Pic01_URL()).into(imageView);
                break;
        }
    }
}
