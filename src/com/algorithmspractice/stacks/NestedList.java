package com.algorithmspractice.stacks;

import java.util.List;

public class NestedList implements NestedInteger {

    List<NestedInteger> list;
    Integer number;

    public NestedList(List<NestedInteger> list){
        this.list = list;
    }

    public NestedList(Integer num){
        this.number = num;
    }
    @Override
    public boolean isInteger() {
        return list == null;
    }

    @Override
    public Integer getInteger() {
        return number;
    }

    @Override
    public List<NestedInteger> getList() {
        return list;
    }
}
