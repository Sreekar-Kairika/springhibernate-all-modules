package com;

import java.util.LinkedHashMap;

public class Student {
    private String firstName;
    private String lastName;

    private String country;

    private LinkedHashMap<String,String> countryOptions;

    private String favouriteLanguage;



    private String[] familiarOS;
    public Student(){

        countryOptions = new LinkedHashMap<>();
        countryOptions.put("US","America");
        countryOptions.put("UK","England");
        countryOptions.put("FR","FRANCE");
        countryOptions.put("GE","GERMANY");
        countryOptions.put("IN","INDIA");

    }
    public void setFirstName(String firstName){
        this.firstName = firstName;
    }
    public void setLastName(String lastName){
        this.lastName = lastName;
    }
    public String getFirstName(){
        return firstName;
    }
    public String getLastName(){
        return lastName;
    }

    public void setCountry(String country){
        this.country = country;
    }
    public String getCountry(){
        return country;
    }

    public LinkedHashMap<String,String> getCountryOptions(){
        return countryOptions;
    }

    public String getFavouriteLanguage() {
        return favouriteLanguage;
    }

    public void setFavouriteLanguage(String favouriteLanguage) {
        this.favouriteLanguage = favouriteLanguage;
    }

    public String[] getFamiliarOS() {
        return familiarOS;
    }

    public void setFamiliarOS(String[] familiarOS) {
        this.familiarOS = familiarOS;
    }
}
