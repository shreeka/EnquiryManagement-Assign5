/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shreeka.enquirymanagement.impl;

import com.shreeka.enquirymanagement.dao.EnquiryDAO;
import com.shreeka.enquirymanagement.entity.Enquiry;

/**
 *
 * @author Decode
 */
public class EnquiryDAOImpl implements EnquiryDAO {
    
    private int counter=0;
    private Enquiry[] enquiryList=new Enquiry[10];

    @Override
    public boolean insert(Enquiry c) {
        if(counter<enquiryList.length)
        {
            enquiryList[counter]=c;
            counter++;
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(int id) {
        for(int i=0;i<enquiryList.length;i++)
        {
            Enquiry c=enquiryList[i];
            if(c!=null && c.getId()==id)
            {
                c=null;
                return true;
            }
        }
        return false;
    }

    @Override
    public Enquiry getById(int id) {
        for(int i=0;i<enquiryList.length;i++)
        {
            Enquiry c= enquiryList[i];
            if(c!=null && c.getId()==id){
            return c;
            }
        }
        return null;  
    }

    @Override
    public Enquiry[] getAll() {
        return enquiryList;
    }
    
}
