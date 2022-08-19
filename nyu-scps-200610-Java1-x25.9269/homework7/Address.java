import java.io.Serializable;

public class Address implements Serializable,Cloneable{
    private String street;
    private String city;
    private String state;
    private String zip;

    public Address(){
    }

    public Address(String aStreet, String aCity,
            String aState, String aZip){

        // call changeAddress to store the address information.
        changeAddress(aStreet,aCity,aState,aZip);
    }

    public void changeAddress(String aStreet,
        String aCity, String aState, String aZip){
        street= aStreet;
        city= aCity;
        state=aState;
        zip= aZip;
    }
    public String getStreet(){
        return street;
    }
    public String getCity(){
        return city;
    }
    public String getState(){
        return state;
    }
    public String getZip(){
        return zip;
    }
    public Object clone(){
        try{
            return super.clone();
        }
        catch(Exception e){
            //do nothing - will never happen.
            return null;
        }
    }
    public void printAddress(){
        System.out.println(street);
        System.out.println(city + "," + state + "," + zip);
    }
}