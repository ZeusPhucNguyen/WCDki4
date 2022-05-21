package com.example.figureshop.entity;

import sun.security.krb5.internal.crypto.Des;

public class Product {
    private String ProductId;
    private String ProductName;
    private String Description;
    private double StandardCost;
    private double ListPrice;
    private int Qty;
    private int status;
    private String CategoryId;

public Product(String ProductId,String ProductName,String Description,double StandardCost,double ListPrice,int Qty,String CategoryId,int status)  {
    this.ProductId = ProductId;
    this.ProductName = ProductName;
    this.Description = Description;
    this.StandardCost = StandardCost;
    this.ListPrice = ListPrice;
    this.Qty = Qty;
    this.CategoryId = CategoryId;
    this.status = status;
}
public Product(){
    this.ProductId = "";
    this.ProductName = "";
    this.Description = "";
    this.CategoryId = "";
}

    @Override
    public String toString() {
        return "Product{" +
                "ProductId='" + ProductId + '\'' +
                ", ProductName='" + ProductName + '\'' +
                ", Description='" + Description + '\'' +
                ", CategoryId='" + CategoryId + '\'' +
                ", StandardCost=" + StandardCost +
                ", ListPrice=" + ListPrice +
                ", Qty=" + Qty +
                ", status=" + status +
                '}';
    }

    public String getProductId() {
        return ProductId;
    }

    public void setProductId(String productId) {
        ProductId = productId;
    }

    public String getProductName() {
        return ProductName;
    }

    public void setProductName(String productName) {
        ProductName = productName;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public double getStandardCost() {
        return StandardCost;
    }

    public void setStandardCost(double standardCost) {
        StandardCost = standardCost;
    }

    public double getListPrice() {
        return ListPrice;
    }

    public void setListPrice(double listPrice) {
        ListPrice = listPrice;
    }

    public int getQty() {
        return Qty;
    }

    public void setQty(int qty) {
        Qty = qty;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getCategoryId() {
        return CategoryId;
    }

    public void setCategoryId(String categoryId) {
        CategoryId = categoryId;
    }
}
