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
    soCMND int,
    luong float,
    soDienThoai int,
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
    soCMND int,
    soDienThoai int,
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

-- task1 
insert into tblViTri(tenViTri) value ('Nhân Viên'),('Giám Đốc'),('Bảo Vệ'),('Quản Lý'),('Trưởng Phòng');
insert into tblBoPhan(tenBoPhan) value ('Nhân Sự'),('Thông Tin'),('Sale'),('Maketting'),('Kho');
insert into tblLoaiDichVu(TenLoaiDichVu) value ('Villa'),('House'),('Room');
insert into tblTrinhDo(tenTrinhDo) value ('Đại Học'),('Cao Đẳng'),('Trung Cấp'),('Thạc Sĩ'),('Lao Động Phổ Thông');
insert into tblLoaiKhach(tenLoaiKhach) value ('Silver'),('Platinium'),('Gold'),('Diamond'),('Member');
insert into tblKieuThue(tenKieuThue) value ('Ngày'),('Tháng'),('Năm'),('Quý'),('Giờ');

insert into tblNhanVien(hoTen,IdVitri,IdTrinhDo,idBoPhan,NgaySinh,SoCMND,Luong,SoDienThoai,email,diaChi) value
	('Mai Văn Tùng',2,2,2,"1992/11/12",111111111,5000000,222222222,'shane92mai@gmail.com','Quang Binh'),
	('Nguyễn văn Hùng',2,1,1,"1992/11/12",111111111,5000000,222222222,'shane92mai@gmail.com','Quang Binh'),
	('Trần Văn Long',1,2,1,"1992/11/12",111111111,5000000,222222222,'shane92mai@gmail.com','Quang Binh'),
	('Kiên',1,1,1,"1992/11/12",111111111,5000000,222222222,'shane92mai@gmail.com','Quang Binh'),
	('Hải',2,2,2,"1992/11/12",111111111,5000000,222222222,'shane92mai@gmail.com','Quang Binh'),
	('Tâm',2,2,2,"1992/11/12",111111111,5000000,222222222,'shane92mai@gmail.com','Quang Binh'),
	('Lâm',2,2,2,"1992/11/12",111111111,5000000,222222222,'shane92mai@gmail.com','Quang Binh');

insert into tblKhachHang(idLoaiKhach,hoten,NgaySinh,soCMND,SoDienThoai,email,diaChi) value
(1,'Long',"1992/11/12",245125462,245124521,'abc123@gmail.com','quang Nam'),
(2,'Hòa',"1962/11/12",245125462,245124521,'abc123@gmail.com','Đà Nẵng'),
(3,'Kiên',"1952/11/12",245125462,245124521,'abc123@gmail.com','Quảng Trị'),
(4,'Nhật',"1972/11/12",245125462,245124521,'abc123@gmail.com','Đà Nẵng'),
(1,'Phương',"1982/11/12",245125462,245124521,'abc123@gmail.com','quang Nam'),
(4,'Anh',"2001/11/12",245125462,245124521,'abc123@gmail.com','quang Nam'),
(2,'Hùng',"2005/11/12",245125462,245124521,'abc123@gmail.com','Đà Nẵng'),
(1,'Tiến',"1992/11/12",245125462,245124521,'abc123@gmail.com','Quảng Trị');

-- massage, karaoke, thức ăn, nước uống, thuê xe di chuyển tham quan resort.
insert into tblDichVuDiKem(tenDichVuDiKem,gia,donVi,trangThaiKhaDung) value
('massage',500000,2,'fulll'),
('karaoke',500000,2,'fulll'),
('thức ăn',500000,2,'fulll'),
('nước uống',500000,2,'fulll'),
('thuê xe',500000,2,'fulll');

insert into tblDichVu(tenDichVu,dientich,soTang,SoNguoiToiDa,ChiPhiThue,IdloaiDichVu,IdkieuThue,trangThai) value
('My Villa', 100,5,10,5000000,1,1,'full'),
('My House', 100,5,10,5000000,2,1,'full'),
('My Room', 100,5,10,5000000,3,1,'full'),
('My service', 100,5,10,5000000,1,1,'full'),
('My Room2', 100,5,10,5000000,3,1,'full');

-- task2 	Hiển thị thông tin của tất cả nhân viên có trong hệ thống có tên bắt đầu là một trong các ký tự “H”, “T” hoặc “K” và có tối đa 15 ký tự.
select * from tblnhanVien where (hoten like 'H%' or hoten like 'K%' or hoten like 'T%') and length(hoten)<15;

-- task3 	Hiển thị thông tin của tất cả khách hàng có độ tuổi từ 18 đến 50 tuổi và có địa chỉ ở “Đà Nẵng” hoặc “Quảng Trị”.
select * from tblKhachHang where ngaySinh>"1970/1/1" and ngaySinh < "2001/1/1" and (DiaChi = 'Đà Nẵng' or DiaChi = 'Quảng Trị');
