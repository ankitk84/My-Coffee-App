package com.example.mycoffeeapp.Models;

public class OrdersModel {
    int orderImage;
    String sitemname,price,ordernumber;

    public int getOrderImage() {
        return orderImage;
    }

    public void setOrderImage(int orderImage) {
        this.orderImage = orderImage;
    }

    public String getSitemname() {
        return sitemname;
    }

    public void setSitemname(String sitemname) {
        this.sitemname = sitemname;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getOrdernumber() {
        return ordernumber;
    }

    public void setOrdernumber(String ordernumber) {
        this.ordernumber = ordernumber;
    }

    public OrdersModel(int orderImage, String sitemname, String price, String ordernumber) {
        this.orderImage = orderImage;
        this.sitemname = sitemname;
        this.price = price;
        this.ordernumber = ordernumber;
    }
}
