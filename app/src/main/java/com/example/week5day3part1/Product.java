package com.example.week5day3part1;

import android.os.Parcel;
import android.os.Parcelable;

public class Product implements Parcelable {
    private String productName;
    private String productID;
    private String productInventoryCount;
    private String productdescription;

    public Product(String productName, String productID, String productInventoryCount, String productdescription) {
        this.productName = productName;
        this.productID = productID;
        this.productInventoryCount = productInventoryCount;
        this.productdescription = productdescription;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public String getProductInventoryCount() {
        return productInventoryCount;
    }

    public void setProductInventoryCount(String productInventoryCount) {
        this.productInventoryCount = productInventoryCount;
    }

    public String getProductdescription() {
        return productdescription;
    }

    public void setProductdescription(String productdescription) {
        this.productdescription = productdescription;
    }

    protected Product(Parcel in) {
        productName = in.readString();
        productID = in.readString();
        productInventoryCount = in.readString();
        productdescription = in.readString();
    }

    public static final Creator<Product> CREATOR = new Creator<Product>() {
        @Override
        public Product createFromParcel(Parcel in) {
            return new Product(in);
        }

        @Override
        public Product[] newArray(int size) {
            return new Product[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(productName);
        dest.writeString(productID);
        dest.writeString(productInventoryCount);
        dest.writeString(productdescription);
    }
}