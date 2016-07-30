/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shreeka.enquirymanagement.entity;

/**
 *
 * @author Decode
 */
public class Enquiry {
    
    private int id;
    private String desc,user;
    private boolean status;

    public Enquiry() {
    }

    public int getId() {
        return id;
    }

    public String getDesc() {
        return desc;
    }

    public String getUser() {
        return user;
    }

    public boolean isStatus() {
        return status;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

}