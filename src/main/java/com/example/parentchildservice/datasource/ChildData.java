package com.example.parentchildservice.datasource;

public class ChildData {
    private int id;
    private int paidAmount;
    private int parentId;

    public ChildData(ChildData childData) {
    }

    public ChildData(int id, int paidAmount, int parentId) {
        this.id = id;
        this.paidAmount = paidAmount;
        this.parentId = parentId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPaidAmount() {
        return paidAmount;
    }

    public void setPaidAmount(int paidAmount) {
        this.paidAmount = paidAmount;
    }

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }
}
