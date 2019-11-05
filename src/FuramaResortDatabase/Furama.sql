DROP DATABASE if exists Furama;
CREATE DATABASE Furama;
USE Furama;
CREATE TABLE tblVitri (
    IdVitri int auto_increment primary key,
    tenViTri varchar(45)
);
CREATE TABLE tblTrinhDo (
    IdTrinhDo int auto_increment primary key,
    tenTrinhDo varchar(45)
);
CREATE TABLE tblBoPhan(
	IdBoPhan int auto_increment primary key,
	tenBoPhan varchar(45)
);
CREATE TABLE tblNhanVien(
	IdNhanVien int auto_increment primary key,
	hoTen varchar(45),
    IdviTri int,
    IdTrinhDo int, 
    idBoPhan int,
    ngaySinh date,
    soCMND varchar(45),
    luong varchar(45),
    soDienThoai varchar(45),
    email varchar(45),
    diaChi varchar(45),
    foreign Key (IdViTri) references tblViTri(IdViTri),
    foreign Key (IdTrinhDo) references tblTrinhDo(IdTrinhDo),
    foreign Key (IdBoPhan) references tblBoPhan(IdBoPhan)
);

CREATE TABLE tblLoaiKhach(
	IdLoaiKhach int auto_increment primary key,
	tenLoaiKhach varchar(45)
);
CREATE TABLE tblKhachHang(
	IdKhachHang int auto_increment primary key,
	IdLoaiKhach int ,
    hoTen varchar(45),
	ngaySinh date,
    soCMND varchar(45),
    soDienThoai varchar(45),
    email varchar(45),
    diaChi varchar(45),
    foreign Key (IdLoaiKhach) references tblLoaiKhach(IdLoaiKhach)
);


CREATE TABLE tblKieuThue(
	IdKieuThue int auto_increment primary key,
	tenKieuThue varchar(45),
    gia varchar(45)
);
CREATE TABLE tblLoaiDichVu(
	IdLoaiDichVu int auto_increment primary key,
	tenLoaiDichVu varchar(45)
);
CREATE TABLE tblDichVu(
	IdDichVu int auto_increment primary key,
	tenDichVu varchar(45),
    dienTich float,
    soTang int,
    soNguoiToiDa int,
    chiPhiThue float,
    IdLoaiDichVu int,
    IdkieuThue int,
    trangThai nvarchar(45),
    foreign Key (IdLoaiDichVu) references tblLoaiDichVu(IdLoaiDichVu),
    foreign Key (IdKieuThue) references tblKieuThue(IdKieuThue)
    );
    
    
    CREATE TABLE tblHopDong(
	IdHopDong int auto_increment primary key,
    IdNhanVien int,
    IdKhachHang int,
    idDichVu int,
    ngayLamHopDong date,
    ngayKetThuc date,
    tiendatCoc float,
    TongTien float,
    foreign Key (IdNhanVien) references tblNhanVien(IdNhanVien),
    foreign Key (IdKhachHang) references tblKhachHang(IdKhachHang),
    foreign Key (idDichVu) references tblDichVu(idDichVu)
);

CREATE TABLE tblDichVuDiKem(
	IdDichVuDiKem int auto_increment primary key,
	tenDichVuDikem varchar(45),
    gia float,
    donVi int,
    trangThaiKhaDung varchar(45)
);
CREATE TABLE tblHopDongChiTiet(
	IdhopdongChiTiet int auto_increment primary key,
	IdHopDong int,
    IdDichVuDiKem int,
    soLuong int,
	foreign Key (IdDichVuDiKem) references tblDichVuDiKem(IdDichVuDiKem),
	foreign Key (IdHopDong) references tblHopDong(IdHopDong)
);


insert into tblViTri value ('Nhân Viên'),('Giám Đốc'),('Bảo Vệ'),('Quản Lý'),('Trưởng Phòng');
insert into tblBoPhan value ('Nhân Sự'),('Thông Tin'),('Sale'),('Maketting'),('Kho');
insert into tblDichVu value ('Villa'),('House'),('Room');
insert into tblTrinhDo value ('Đại Học'),('Cao Đẳng'),('Trung Cấp'),('Thạc Sĩ'),('Lao Động Phổ Thông');





