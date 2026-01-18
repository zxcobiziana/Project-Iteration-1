package com.company.models;

public class OrderProduct {
    private int id;
    private int order_id;
    private int product_id;
    private int count;

    public OrderProduct() {

    }

    public OrderProduct(int order_id, int product_id, int count) {
        setOrderId(order_id);
        setProductId(product_id);
        setCount(count);
    }

    public OrderProduct(int id, int order_id, int product_id, int count) {
        this(order_id, product_id, count);
        setId(id);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOrderId() {
        return order_id;
    }

    public void setOrderId(int order_id) {
        this.order_id = order_id;
    }

    public int getProductId() {
        return product_id;
    }

    public void setProductId(int product_id) {
        this.product_id = product_id;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "OrderProduct{" +
                "id=" + id +
                ", order_id='" + order_id + '\'' +
                ", product_id='" + product_id + '\'' +
                ", count='" + count +
                '}';
    }
}
