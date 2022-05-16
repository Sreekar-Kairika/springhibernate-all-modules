package com.jackson.json.demo;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.StringReader;

public class Driver {
    public static void main(String[] args){

        try{
            //create object mapper
            ObjectMapper mapper = new ObjectMapper();
            //read JSON file & map/covert to Java POJO
            Student theStudent =
                    mapper.readValue(new File("data/sample-full.json") , Student.class);
            //print data
            System.out.println("First Name : "+theStudent.getFirstName());
            System.out.println("Last Name : "+theStudent.getLastName());

            Address tempAddress = theStudent.getAddress();
            System.out.println(tempAddress.getCountry());

           for(String tempLang: theStudent.getLanguages()){
               System.out.println(tempLang);
           }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
