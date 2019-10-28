package Models;

public class Customer {
    private String id;
    private String nameCustumer;
    private String gender;
    private String birtherday;
    private int  idCard;
    private int phoneNumber;
    private String email;
    private String loại;
    private String address;
    private Services services;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNameCustumer() {
        return nameCustumer;
    }

    public void setNameCustumer(String nameCustumer) {
        this.nameCustumer = nameCustumer;
    }

    public String isGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBirtherday() {
        return birtherday;
    }

    public void setBirtherday(String birtherday) {
        this.birtherday = birtherday;
    }

    public int getIdCard() {
        return idCard;
    }

    public void setIdCard(int idCard) {
        this.idCard = idCard;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLoại() {
        return loại;
    }

    public void setLoại(String loại) {
        this.loại = loại;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Services getServices() {
        return services;
    }

    public void setServices(Services services) {
        this.services = services;
    }

    public Customer(String id,String nameCustumer, String gender, String birtherday, int idCard, int phoneNumber, String email, String loại, String address, Services services) {
        this.id = id;
        this.nameCustumer = nameCustumer;
        this.gender = gender;
        this.birtherday = birtherday;
        this.idCard = idCard;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.loại = loại;
        this.address = address;
        this.services = services;
    }

    public Customer() {
    }

    public String showInformation() {
        return "Name Custumer " + this.getNameCustumer() +
                " Gender " + this.isGender() +
                " Birthday " + this.getBirtherday() +
                " ID Card " + this.getIdCard() +
                " Phone Number " + this.getPhoneNumber() +
                " Email " + this.getEmail() +
                " Loai " + this.getLoại() +
                " Address " + this.getAddress() +
                " Service " + this.getServices();
    }
    public String showIDName(){
        return "Name Custumer " + this.getNameCustumer() +
                " ID Card " + this.getIdCard();
    }
}
