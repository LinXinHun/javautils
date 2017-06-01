package com.linxinhun.mo.entity;

import java.io.Serializable;

/**
 * Created by zhoulin on 2017/5/31.
 */
public class GreenTea implements Serializable {

    private static final long serialVersionUID = -1L;

    private String name;

    private String color;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString(){
        return "name:" + this.name + ", color:" + this.color;
    }

}
