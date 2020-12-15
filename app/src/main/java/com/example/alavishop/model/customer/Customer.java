package com.example.alavishop.model.customer;

public class Customer {

    private long mId;

    private String mName;

    private String mLastName;

    private String mEmail;

    private String mUserName;

    private Billing mBilling;

    public Customer(long id, String name, String lastName, String email, Billing billing, String userName) {
        mId = id;
        mName = name;
        mLastName = lastName;
        mEmail = email;
        mBilling = billing;
        mUserName=userName;
    }


    public long getId() {
        return mId;
    }

    public String getName() {
        return mName;
    }

    public String getLastName() {
        return mLastName;
    }

    public String getEmail() {
        return mEmail;
    }

    public Billing getBilling() {
        return mBilling;
    }

    public void setId(long id) {
        this.mId = id;
    }

    public void setName(String name) {
        this.mName = name;
    }

    public void setLastName(String lastName) {
        this.mLastName = lastName;
    }

    public void setEmail(String email) {
        this.mEmail = email;
    }

    public void setBilling(Billing billing) {
        this.mBilling = billing;
    }
}


