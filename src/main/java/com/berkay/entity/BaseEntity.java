package com.berkay.entity;

public class BaseEntity {
    long createAt;
    long updateAt;
    int state;
    public BaseEntity(){
        long now = System.currentTimeMillis();
        this.createAt = now;
        this.updateAt = now;
    }

    public BaseEntity(long createAt, long updateAt, int state) {
        this.createAt = createAt;
        this.updateAt = updateAt;
        this.state = state;
    }

    public long getCreateAt() {
        return createAt;
    }

    public void setCreateAt(long createAt) {
        this.createAt = createAt;
    }

    public long getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(long updateAt) {
        this.updateAt = updateAt;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state =state;
}
}
