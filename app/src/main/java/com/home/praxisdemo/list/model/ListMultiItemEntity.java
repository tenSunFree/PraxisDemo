package com.home.praxisdemo.list.model;

import com.chad.library.adapter.base.entity.MultiItemEntity;

public class ListMultiItemEntity<T> implements MultiItemEntity {

    private final int itemType;

    private T data;

    private String pinnedHeaderName;

    private int sortNumber;

    public ListMultiItemEntity(T data, int itemType, String pinnedHeaderName, int sortNumber) {
        this.data = data;
        this.itemType = itemType;
        this.pinnedHeaderName = pinnedHeaderName;
        this.sortNumber = sortNumber;
    }

    public void setData(T data) {
        this.data = data;
    }

    public void setPinnedHeaderName(String pinnedHeaderName) {
        this.pinnedHeaderName = pinnedHeaderName;
    }

    public T getData() {
        return data;
    }

    public String getPinnedHeaderName() {
        return pinnedHeaderName;
    }

    @Override
    public int getItemType() {
        return itemType;
    }

    public int getSortNumber() {
        return sortNumber;
    }

    public void setSortNumber(int sortNumber) {
        this.sortNumber = sortNumber;
    }
}
