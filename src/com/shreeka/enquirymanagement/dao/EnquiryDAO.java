/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shreeka.enquirymanagement.dao;

import com.shreeka.enquirymanagement.entity.Enquiry;


/**
 *
 * @author Decode
 */
public interface EnquiryDAO {
   
     boolean insert(Enquiry s);
    boolean delete(int id);
    Enquiry getById(int id);
    Enquiry[] getAll();
    
}
