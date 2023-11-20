package com.uts.jwp.Domain;

public class Teacher {
    private String nip;
    private String fullName;
    private String email;
    private String numberphone;

    public Teacher(){

    }
    public String getnip(){
        return nip;
    }
    public void setnip(String nip){
        this.nip = nip;
    }
    public String getfullName(){
        return fullName;
    }
    public void setfullName(String fullName){
        this.fullName = fullName;
    }
    public String getemail(){
        return email;
    }
    public void setemail(String email){
        this.email = email;
    }
    public String getnumberphone(){
        return numberphone;
    }
    public void setnophone(String numberphone){
        this.numberphone = numberphone;
    }
}
