/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shreeka.enquirymanagement;

import com.shreeka.enquirymanagement.dao.EnquiryDAO;
import com.shreeka.enquirymanagement.entity.Enquiry;
import com.shreeka.enquirymanagement.impl.EnquiryDAOImpl;
import java.util.Scanner;

/**
 *
 * @author Decode
 */
public class Program {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       Scanner input= new Scanner(System.in);
        EnquiryDAO enquiryDAO=new EnquiryDAOImpl();
        while(true)
        {
            System.out.println("");
        System.out.println("1.Add Enquiry");
        System.out.println("2.Delete Enquiry");
        System.out.println("3.Show All");
        System.out.println("4.Search by ID");
            System.out.println("5.Update a enquiry");
        System.out.println("6.Exit");
        System.out.print("Enter your choice [1-6]: ");
        
        switch(input.nextInt())
        {
            case 1:
                Enquiry c=new Enquiry();
                System.out.println("Add new enquiry");
                System.out.print("Enter enquiry Id: ");
                c.setId(input.nextInt());
                System.out.print("Enter enquiry description: ");
                c.setDesc(input.next());
                System.out.print("Asked by user: ");
                c.setUser(input.next());
                System.out.print("Enter status: ");
                c.setStatus(input.nextBoolean());
                               
                
                if(enquiryDAO.insert(c))
                {
                    System.out.println("Inserted successfully");
                }else
                    System.out.println("Data full");
                
                break;
                
            case 2:
                System.out.print("Enter enquiry id to be deleted: ");
                if(enquiryDAO.delete(input.nextInt()))
                {
                    System.out.println("Enquiry deleted.");   
                }else
                    System.out.println("Null enquiry id. Cannot be deleted. ");
                break;
                
            case 3:
                System.out.println("Display all enquirys");
                Enquiry[] enquiryList= enquiryDAO.getAll();
                for(int i=0;i<enquiryList.length;i++)
                {   if(enquiryList[i]!=null)
                {
                    System.out.println("Enquiry id: "+enquiryList[i].getId());
                    System.out.println("Enquiry description: "+enquiryList[i].getDesc());
                    System.out.println("Asked by user: "+enquiryList[i].getUser());
                    System.out.println("Enquiry status: "+enquiryList[i].isStatus());
                    System.out.println("");
                }
                }
                break;
                
            case 4:
                System.out.print("Enter enquiry id to be searched: ");
                Enquiry enquiry= enquiryDAO.getById(input.nextInt());
                if(enquiry!=null){
                System.out.println("Enquiry id: "+enquiry.getId());
                System.out.println("Enquiry description: "+enquiry.getDesc());
                System.out.println("Asked by user: "+enquiry.getUser());
                System.out.println("Enquiry status: "+enquiry.isStatus());
                }else
                    System.out.println("Enquiry could not be found.");
                break;
                
            case 5:
                System.out.print("Enter enquiry id to be updated: ");
                int id=input.nextInt();
                Enquiry cupdate=enquiryDAO.getById(id);
                if(cupdate!=null){

                System.out.println("1. Update enquiry id");
                System.out.println("2. Update enquiry description");
                System.out.println("3. Update user");
                    System.out.println("4.Update status");
                System.out.print("Enter your choice: ");
                switch(input.nextInt())
                {
                    case 1:
                        System.out.print("Enter new enquiry id: ");
                        cupdate.setId(input.nextInt());
                        break;
                    case 2:
                        System.out.print("Enter new enquiry description: ");
                        cupdate.setDesc(input.next());
                        break;
                    case 3:
                        System.out.print("Enter new username: ");
                        cupdate.setUser(input.next());
                        break;
                    case 4:
                        System.out.print("Enter new status: ");
                        cupdate.setStatus(input.nextBoolean());
                        break;
                }
                    System.out.println("Updated successfully");
                }else
                System.out.println("Enquiry could not be found.");
                break;
                
            case 6:
                System.out.print("Do you really want to exit?(y/n)");
                if((input.next()).equalsIgnoreCase("y")){
                System.exit(0);
                }
                break;
                    
        }
        }
    }
   
    
}
