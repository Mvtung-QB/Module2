package FuramaResort.Models;

import FuramaResort.Models.Services;

public class Villa extends House {
    public Villa() {
        super();
    }

    public float getDienTichHoBoi() {
        return DienTichHoBoi;
    }

    public void setDienTichHoBoi(float dienTichHoBoi) {
        DienTichHoBoi = dienTichHoBoi;
    }

    private float DienTichHoBoi;

    public Villa(String tieuChuan, String moTa, int soTang, float dienTichHoBoi) {
        super(tieuChuan, moTa, soTang);
        DienTichHoBoi = dienTichHoBoi;
    }

    public Villa(String id,String nameServises, int areaUse, int rentalCosts, int maxUser, String typeServices, String tieuChuan, String moTa, int soTang, float dienTichHoBoi) {
        super(id,nameServises, areaUse, rentalCosts, maxUser, typeServices, tieuChuan, moTa, soTang);
        DienTichHoBoi = dienTichHoBoi;
    }

    @Override
    public String showInfor() {
        return " ID Service: " + this.getId() +
                 " type Service: " + this.getTypeServices() +
                 " Name Service: " + this.getNameServises() +
                " Area use:  " + this.getAreaUse() +
                " Chi phí thuê:  " + this.getRentalCosts() +
                " Max user:  " + this.getMaxUser() +
                " Type service:  " + this.getTypeServices() +
                " Tiêu chuẩn:  " + this.getTieuChuan() +
                " Tiện nghi:  " + this.getMoTa() +
                " Diện tích hồ bơi:  " + this.getDienTichHoBoi() +
                " Số tầng:  " + this.getSoTang();
    }
}
