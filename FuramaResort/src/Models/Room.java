package Models;

public class Room extends Services {
    public Room(String id, String nameServises, int areaUse, int rentalCosts, int maxUser, String typeServices) {
        super(id, nameServises, areaUse, rentalCosts, maxUser, typeServices);
    }

    public Room() {
    }

    @Override
    public String showInfor() {
        return " ID Service: " + this.getId() +
                " Type Service: " + this.getTypeServices() +
                " Name Service: " + this.getNameServises() +
                " Area use:  " + this.getAreaUse() +
                " Chi phí thuê:  " + this.getRentalCosts() +
                " Max user:  " + this.getMaxUser() +
                " Type service:  " + this.getTypeServices();
    }
}
