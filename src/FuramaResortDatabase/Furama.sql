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
    foreign Key (IdViTri) references tblViTri(IdViTri)on update cascade on delete cascade ,
    foreign Key (IdTrinhDo) references tblTrinhDo(IdTrinhDo)on update cascade on delete cascade,
    foreign Key (IdBoPhan) references tblBoPhan(IdBoPhan)on update cascade on delete cascade
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
    foreign Key (IdNhanVien) references tblNhanVien(IdNhanVien) on update cascade on delete cascade,
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
	foreign Key (IdHopDong) references tblHopDong(IdHopDong)on update cascade on delete cascade
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
(4,'Hùng',"2005/11/12",245125462,245124521,'abc123@gmail.com','Quảng Ngãi'),
(4,'Tùng',"2005/11/12",245125462,245124521,'abc123@gmail.com','Vinh'),
(4,'Giang',"2005/11/12",245125462,245124521,'abc123@gmail.com','Đà Nẵng'),
(4,'Hậu',"2005/11/12",245125462,245124521,'abc123@gmail.com','Quảng Ngãi'),
(4,'Nhân',"2005/11/12",245125462,245124521,'abc123@gmail.com','Quảng Ngãi'),
(4,'Quốc',"2005/11/12",245125462,245124521,'abc123@gmail.com','Vinh'),
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
(4, 7,2,'2019/9/2','2019/9/6',2000000),
(6, 8,2,'2019/9/2','2019/9/6',2000000),
(7, 9,2,'2019/9/2','2019/9/6',2000000),
(6, 10,2,'2019/12/2','2019/12/6',2000000),
(4, 11,2,'2019/11/2','2019/12/6',2000000),
(1, 10,2,'2019/10/2','2019/10/6',2000000),
(2, 1,4,'2018/9/2','2018/9/6',2000000);

insert into tblHopdongChiTiet(IdHopDong,idDichVuDiKem,SoLuong) value (1,1,2),(2,3,2),(3,2,1),(1,3,2),(3,4,4),(1,4,2),(10,1,2),(7,5,2),(8,4,2),(9,3,2),(6,2,2);


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

select tblKhachHang.idKhachHang,hoTen,TenLoaiKhach,tblHopDong.idHopDong,
tendichVu,ngayLamHopDong,NgayKetThuc,sum(ChiPhiThue + SoLuong*Gia) as TongTien
from tblKhachHang
left join tblHopDong on tblKhachHang.idKhachHang = tblHopDong.idKhachHang
left join tblLoaiKhach on tblKhachHang.idLoaiKhach= tblLoaiKhach.idLoaiKhach
left join tblDichVu on tblDichVu.IDdichVu = tblHopDong.idDichVu
left join tblHopDongchiTiet on tblHopDong.IdHopDong = tblHopDongchiTiet.idhopDong
left join tblDichVuDikem on tblHopDongchiTiet.idDichVuDiKem = tblDichVuDikem.idDichVuDiKem
group by tblKhachHang.idKhachHang;

-- task6.	Hiển thị IDDichVu, TenDichVu, DienTich, ChiPhiThue, TenLoaiDichVu
--  của tất cả các loại Dịch vụ chưa từng được Khách hàng thực hiện đặt từ quý 1 của năm 2019 (Quý 1 là tháng 1, 2, 3).

select tblDichvu.IdDichVu,tenDichVu,DienTich,ChiPhiThue,TenLoaiDichVu 
from tblDichVu
inner join tblLoaiDichvu on tblDichVu.idLoaiDichVu = tblLoaiDichvu.idLoaiDichVu
where not exists ( select tblHopDong.ngayLamHopDong from tblHopDong where  (tblhopdong.ngayLamHopDong between "2019-01-01" and  curdate()) 
					and tblDichVu.idDichVu = tblHopDong.idDichVu);
                    
-- task7.	Hiển thị thông tin IDDichVu, TenDichVu, DienTich, SoNguoiToiDa, ChiPhiThue, TenLoaiDichVu 
-- của tất cả các loại dịch vụ đã từng được Khách hàng đặt phòng trong năm 2018 nhưng chưa từng được Khách hàng đặt phòng  trong năm 2019.
	
select tblDichvu.IdDichVu,tenDichVu,DienTich,soNguoiToiDa,ChiPhiThue,TenLoaiDichVu 
from tblDichVu
inner join tblLoaiDichvu on tblDichVu.idLoaiDichVu = tblLoaiDichvu.idLoaiDichVu
where exists ( select tblHopDong.ngayLamHopDong from tblHopDong where  (tblhopdong.ngayLamHopDong between "2018-01-01" and  "2018-12-31") 
					and tblDichVu.idDichVu = tblHopDong.idDichVu) 
                    and not exists (select tblHopDong.ngayLamHopDong from tblHopDong where  (tblhopdong.ngayLamHopDong between "2019-01-01" and  curdate()) 
					and tblDichVu.idDichVu = tblHopDong.idDichVu);

-- task8.	Hiển thị thông tin HoTenKhachHang có trong hệ thống, với yêu cầu HoThenKhachHang không trùng nhau.
-- Học viên sử dụng theo 3 cách khác nhau để thực hiện yêu cầu trên

select hoTen from tblKhachHang group by Hoten;
select distinct Hoten from tblKhachHang ;
select hoten from tblKhachHang
union
select hoten from tblKhachHang;

-- task9.	Thực hiện thống kê doanh thu theo tháng,
--  nghĩa là tương ứng với mỗi tháng trong năm 2019 thì sẽ có bao nhiêu khách hàng thực hiện đặt phòng.

select meses.month , count(month(NgayLamHopDong)) as sokhachhangdangki
FROM
           (
                     SELECT 1 AS MONTH
                      UNION SELECT 2 AS MONTH
                      UNION SELECT 3 AS MONTH
                      UNION SELECT 4 AS MONTH
                      UNION SELECT 5 AS MONTH
                      UNION SELECT 6 AS MONTH
                      UNION SELECT 7 AS MONTH
                      UNION SELECT 8 AS MONTH
                      UNION SELECT 9 AS MONTH
                      UNION SELECT 10 AS MONTH
                      UNION SELECT 11 AS MONTH
                      UNION SELECT 12 AS MONTH
           ) as meses
left join tblhopdong on month(tblhopdong.NgayLamHopDong) = meses.month
left join tblkhachhang on tblkhachhang.IDKhachHang = tblhopdong.IDKhachHang
where year(tblhopdong.NgayLamHopDong) = '2019' or year(tblhopdong.NgayLamHopDong) is null or month(tblhopdong.NgayLamHopDong) is null
group by meses.month
order by meses.month;

-- task10.	Hiển thị thông tin tương ứng với từng Hợp đồng thì đã sử dụng bao nhiêu Dịch vụ đi kèm. Kết quả hiển thị bao gồm 
-- IDHopDong, NgayLamHopDong, NgayKetthuc, TienDatCoc, SoLuongDichVuDiKem (được tính dựa trên việc count các IDHopDongChiTiet).

select tblHopDongChiTiet.IDHopDong, NgayLamHopDong, NgayKetthuc, TienDatCoc, sum(SoLuong) as SoLuongDichVuDiKem
from tblHopDongChiTiet
inner join tblHopDong on tblHopDong.IdHopDong = tblHopDongChiTiet.idHopDong
group by tblHopDongChiTiet.idHopDong;

-- 11.	Hiển thị thông tin các Dịch vụ đi kèm đã được sử dụng bởi những Khách hàng có TenLoaiKhachHang là “Diamond” 
-- và có địa chỉ là “Vinh” hoặc “Quảng Ngãi”.

select tblDichVuDiKem.idDichVuDiKem, tenDichVuDiKem, Gia,DonVi
from tblDichVuDiKem
inner join tblHopDongChiTiet on tblDichVuDiKem.idDichVuDiKem = tblHopDongChiTiet.idDichVuDiKem
inner join tblHopDong on tblHopDongChiTiet.idHopDong = tblHopDong.idHopDong
inner join tblKhachHang on tblHopDong.idKhachHang = tblKhachHang.idKhachHang
inner join tblLoaiKhach on tblKhachHang.idLoaiKhach = tblLoaiKhach.idLoaiKhach
where tblLoaiKhach.TenLoaiKhach = 'Diamond' and (tblKhachHang.diaChi = 'Vinh' or tblKhachHang.diaChi = 'Quảng Ngãi' );

-- 12.	Hiển thị thông tin IDHopDong, TenNhanVien, TenKhachHang, SoDienThoaiKhachHang, TenDichVu, SoLuongDichVuDikem 
-- (được tính dựa trên tổng Hợp đồng chi tiết), TienDatCoc của tất cả các dịch vụ
-- đã từng được khách hàng đặt vào 3 tháng cuối năm 2019 nhưng chưa từng được khách hàng đặt vào 6 tháng đầu năm 2019.

select tblHopDong.IDHopDong, tblNhanVien.hoTen as 'Tên Nhân Viên',tblKhachHang.hoTen as 'Tên Khách Hàng',
 tblKhachHang.SoDienThoai, TenDichVu, sum(SoLuong) as 'Số Lượng Dịch Vụ ĐI Kèm',sum( TienDatCoc) as 'Tổng tiền dặt cọc'
from tblKhachHang
inner join tblHopDong on tblKhachHang.idKhachhang = tblHopDong.idKhachhang
inner join tblDichVu on tblHopDong.idDichVu = tblDichVu.idDichVu
inner join tblNhanVien on tblHopDong.idNhanVien = tblNhanVien.idNhanVien
inner join tblHopDongChiTiet on tblHopDong.idHopDong = tblHopDongChiTiet.idHopDong
inner join tblDichVuDiKem on tblHopDongChiTiet.iddichvuDiKem = tblDichVuDiKem.iddichvuDiKem
where exists ( select tblHopDong.ngayLamHopDong from tblHopDong where  (tblhopdong.ngayLamHopDong between "2019-10-01" and  curdate()) 
	and tblDichVu.idDichVu = tblHopDong.idDichVu) 
	and not exists (select tblHopDong.ngayLamHopDong from tblHopDong where  (tblhopdong.ngayLamHopDong between "2019-01-01" and  "2019-9-31"))
group by tblHopDong.IDHopDong;

-- task13.	Hiển thị thông tin các Dịch vụ đi kèm được sử dụng nhiều nhất bởi các Khách hàng đã đặt phòng.
-- (Lưu ý là có thể có nhiều dịch vụ có số lần sử dụng nhiều như nhau).

select tblDichVuDiKem.idDichVuDiKem,TenDichVuDiKem,Gia,Donvi,TrangThaiKhaDung,count(tblDichVuDiKem.IdDichVuDikem) as SoLanSuDung 
from tblDichVuDiKem 
inner join tblHopDongChiTiet on tblDichVuDiKem.idDichVuDiKem = tblHopDongChiTiet.idDichVuDiKem
group by tblDichVuDiKem.idDichVuDiKem
having  SoLanSuDung >= ALL (sELECT  count(tblDichVuDiKem.IdDichVuDikem) from tblDichVuDiKem
							inner join tblHopDongChiTiet on tblDichVuDiKem.idDichVuDiKem = tblHopDongChiTiet.idDichVuDiKem
							group by tblDichVuDiKem.idDichVuDiKem);

-- task14.	Hiển thị thông tin tất cả các Dịch vụ đi kèm chỉ mới được sử dụng một lần duy nhất.
-- Thông tin hiển thị bao gồm IDHopDong, TenLoaiDichVu, TenDichVuDiKem, SoLanSuDung.

select tblHopDong.idHopDong,TenLoaiDichVu,tblDichVuDiKem.idDichVuDiKem,TenDichVuDiKem,count(tblDichVuDiKem.IdDichVuDikem) as SoLanSuDung 
from tblHopDong 
inner join tblHopDongChiTiet on tblHopDong.idHopDong = tblHopDongChiTiet.idHopDong
inner join tblDichVuDiKem on tblDichVuDiKem.idDichVuDiKem = tblHopDongChiTiet.idDichVuDiKem
inner join tblDichVu on tblHopDong.idDichVu = tblDichVu.idDichVu
inner join tblLoaiDichVu on tblDichVu.idLoaiDichVu = tblLoaiDichVu.idLoaiDichVu
group by tblDichVuDiKem.idDichVuDiKem
having count(tblDichVuDiKem.IdDichVuDikem) = 1;

-- task15.	Hiển thi thông tin của tất cả nhân viên bao gồm IDNhanVien, HoTen, TrinhDo, TenBoPhan, SoDienThoai, DiaChi 
-- mới chỉ lập được tối đa 3 hợp đồng từ năm 2018 đến 2019.

select tblNhanVien.IDNhanVien, HoTen, TenTrinhDo, TenBoPhan, SoDienThoai, DiaChi 
from tblNhanVien
inner join tblBoPhan on tblNhanVien.idBoPhan = tblboPhan.idBoPhan
inner join tblTrinhDo on tblNhanVien.idTrinhDo = tbltrinhDo.idTrinhDo
inner join tblHopDong on tblNhanVien.idNhanVien = tblHopDong.idNhanVien
where ngaylamhopDong between '2018-1-1' and	'2019-12-31'
group by HoTen
having count( tblNhanVien.IDNhanVien) = 3;

-- 16.	Xóa những Nhân viên chưa từng lập được hợp đồng nào từ năm 2017 đến năm 2019.

set SQL_SAFE_UPDATES = 0;
delete tblNhanVien
from tblNhanVien
left join tblhopDong on tblhopDong.idNhanVien = tblNhanVien.idNhanVien
left join tblhopDongChiTiet on tblhopDong.idhopDong = tblhopDongChiTiet.idhopDong
where year(NgayLamHopDong) not between '2018' and '2019';
-- not exists (Select idNhanVien from tblHopDong where ngayLamHopDong not between  '2018-1-1' and '2019-12-31');
set SQL_SAFE_UPDATES = 1;

-- 17.	Cập nhật thông tin những khách hàng có TenLoaiKhachHang từ  Platinium lên Diamond,
--  chỉ cập nhật những khách hàng đã từng đặt phòng với tổng Tiền thanh toán trong năm 2019 là lớn hơn 10.000.000 VNĐ.


