package FuramaResort.Models;

public abstract class Services {

    class DichVuDikem {
        private String tenDichVu;
        private String donVi;
        private double giaTien;

        public String getTenDichVu() {
            return tenDichVu;
        }

        public void setTenDichVu(String tenDichVu) {
            this.tenDichVu = tenDichVu;
        }

        public String getDonVi() {
            return donVi;
        }

        public void setDonVi(String donVi) {
            this.donVi = donVi;
        }

        public double getGiaTien() {
            return giaTien;
        }

        public void setGiaTien(double giaTien) {
            this.giaTien = giaTien;
        }

    }

    public DichVuDikem getDichVuDiKem() {
        return new DichVuDikem();
    }
    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }
    private String Id;
    private String nameServises;
    private float areaUse;
    private int rentalCosts;
    private int maxUser;

    public String getNameServises() {
        return nameServises;
    }

    public void setNameServises(String nameServises) {
        this.nameServises = nameServises;
    }

    public float getAreaUse() {
        return areaUse;
    }

    public void setAreaUse(float areaUse) {
        this.areaUse = areaUse;
    }

    public int getRentalCosts() {
        return rentalCosts;
    }

    public void setRentalCosts(int rentalCosts) {
        this.rentalCosts = rentalCosts;
    }

    public int getMaxUser() {
        return this.maxUser;
    }

    public void setMaxUser(int maxUser) {
        this.maxUser = maxUser;
    }

    public String getTypeServices() {
        return typeServices;
    }

    public void setTypeServices(String typeServices) {
        this.typeServices = typeServices;
    }

    public Services() {
    }

    public Services(String ID, String nameServises, int areaUse, int rentalCosts, int maxUser, String typeServices) {
        this.Id = ID;
        this.nameServises = nameServises;
        this.areaUse = areaUse;
        this.rentalCosts = rentalCosts;
        this.maxUser = maxUser;
        this.typeServices = typeServices;
    }
    private String typeServices;

    abstract String showInfor();
}
