package com.example.annu.mycms;

/**
 * Created by annu on 4/1/18.
 */

public class ComplaintDetails {
    private double longitude;
    private double latitute;
    private String email;
    private String title;
    private String description;
    private String fir;


    public ComplaintDetails() {
        // This is default constructor.
    }




   /* public void Lati(double latitute) {

        this.latitute = latitute;
    }
    public double getLati() {
        return latitute;
    }



    public void Longi(double longitude) {

        this.longitude = longitude;
    }
    public double getLongi() {

        return longitude;
    }
*/
public void setEmail(String email)
{
    this.email =email;
}
    public  String getEmail(){
        return email;
    }


    public void Title(String title)
    {
        this.title=title;
    }
    public String getTitle() {
        return  title;
    }


    public void Description(String description)
    {
        this.description=description;
    }
    public String getDescription() {
        return description;
    }


    public void Fir(String fir)
    {
        this.fir=fir;
    }
    public String getFir(){
        return fir;
    }

}
