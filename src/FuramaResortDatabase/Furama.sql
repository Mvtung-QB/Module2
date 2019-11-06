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

insert into tblHopdong(iDNhanVien,idKhachHang,idDichVu,NgayLamHopDong,NgayKetThuc,TienDatcoc) value
(1, 1,2,'2018/5/2','2018/5/6',2000000),
(3, 2,1,'2019/6/2','2019/6/6',2000000),
(1, 3,2,'2018/7/2','2018/7/6',2000000),
(2, 1,3,'2019/8/2','2019/8/6',2000000),
(4, 4,2,'2019/9/2','2019/9/6',2000000);

insert into tblHopdongChiTiet(IdHopDong,idDichVuDiKem,SoLuong) value (1,1,2),(2,3,2),(3,2,1),(1,3,2),(3,4,4),(1,4,2),(3,1,2);
--------------------------------------------------------------------------------------------------------------------
-- task2 	Hiển thị thông tin của tất cả nhân viên có trong hệ thống có tên bắt đầu là một trong các ký tự “H”, “T” hoặc “K” và có tối đa 15 ký tự.
select * from tblnhanVien where (hoten like 'H%' or hoten like 'K%' or hoten like 'T%') and length(hoten)<15;

-- task3 	Hiển thị thông tin của tất cả khách hàng có độ tuổi từ 18 đến 50 tuổi và có địa chỉ ở “Đà Nẵng” hoặc “Quảng Trị”.
select * from tblKhachHang where ngaySinh>"1970/1/1" and ngaySinh < "2001/1/1" and (DiaChi = 'Đà Nẵng' or DiaChi = 'Quảng Trị');

-- task4  4.	Đếm xem tương ứng với mỗi khách hàng đã từng đặt phtblhopdongòng bao nhiêu lần.
			--  Kết quả hiển thị được sắp xếp tăng dần theo số lần đặt phòng của khách hàng. 
			-- Chỉ đếm những khách hàng nào có Tên loại khách hàng là “Diamond”.

select hoten,tenloaiKhach ,count(tblHopDong.idKhachHang) as 'Số Lần đặt' FROM tblKhachHang
inner join tblHopDong on tblKhachHang.idKhachHang = tblHopDong.idKhachHang
inner join tblLoaiKhach on tblKhachHang.idLoaiKhach = tblLoaiKhach.idLoaiKhach
where tenLoaiKhach = 'Diamond'
group by hoten
order by tblHopDong.idKhachHang asc;

-- task5.	Hiển thị IDKhachHang, HoTen, TenLoaiKhach, IDHopDong, TenDichVu, NgayLamHopDong, NgayKetThuc,
-- TongTien (Với TongTien được tính theo công thức như sau: ChiPhiThue + SoLuong*Gia, 
-- với SoLuong và Giá là từ bảng DichVuDiKem) cho tất cả các Khách hàng đã từng đặt phỏng.
-- (Những Khách hàng nào chưa từng đặt phòng cũng phải hiển thị ra).
select tblKhachHang.idKhachHang,hoTen,TenLoaiKhach,IdHopDong,tendichVu,ngayLamHopDong,NgayKetThuc,tongTien=(ChiPhiThue + SoLuong*Gia)
from tblKhachHang
left join tblHopDong on tblKhachHang.idKhachHang = tblHopDong.idKhachHang
left join tblLoaiKhach on tblKhachHang.idLoaiKhach= tblLoaiKhach.idLoaiKhach
left join tblDichVu on tblDichVu.IDdichVu = tblHopDong.idDichVu






