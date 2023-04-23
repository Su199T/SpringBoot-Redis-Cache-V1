package com.javabootpro.appComponent.enumType;

public enum OrderType {
    // ASC和DESC
    ASC("默认顺序",1),
    DESC("倒序",2);

    OrderType(String order, Integer type) {
        this.order = order;
        this.type = type;
    }

    private String order;
    private Integer type;

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}
