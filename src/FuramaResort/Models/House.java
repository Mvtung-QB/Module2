package FuramaResort.Models;

public class House extends Services {
    private String tieuChuan;
    private String moTa;
    private int soTang;

    public House() {

    }

    public String getTieuChuan() {
        return tieuChuan;
    }

    public void setTieuChuan(String tieuChuan) {
        this.tieuChuan = tieuChuan;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public int getSoTang() {
        return soTang;
    }

    public void setSoTang(int soTang) {
        this.soTang = soTang;
    }

    public House(String tieuChuan, String moTa, int soTang) {
        this.tieuChuan = tieuChuan;
        this.moTa = moTa;
        this.soTang = soTang;
    }

    public House(String id,String nameServises, int areaUse, int rentalCosts, int maxUser, String typeServices, String tieuChuan, String moTa, int soTang) {
        super(id,nameServises, areaUse, rentalCosts, maxUser, typeServices);
        this.tieuChuan = tieuChuan;
        this.moTa = moTa;
        this.soTang = soTang;
    }

    @Override
    public String showInfor() {
        return " ID Service: " + this.getId() +
                " Type Service: " + this.getTypeServices() +
                 " Name Service: " + this.getNameServises() +
                " Area use:  " + this.getAreaUse() +
                " Chi phí thuê:  " + this.getRentalCosts() +
                " Max user:  " + this.getMaxUser() +
                " Type service:  " + this.getTypeServices() +
                " Tiêu chuẩn:  " + this.getTieuChuan() +
                " Tiện nghi:  " + this.getMoTa() +
                " Số tầng:  " + this.getSoTang();
    }
}
