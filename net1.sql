CREATE DATABASE QLNET
USE QLNET

CREATE TABLE NhanVien(
IDNV NVARCHAR(50) PRIMARY KEY,
TenNV nvarchar(50) not null, 
TenDangNhap nvarchar(50) not null,
MatKhau nvarchar(50) not null,
VaiTro bit not null
)

create table May(
IDMay nvarchar(50) primary key,
TrangThai bit not null,
gia money not null
)

create table LoaiDV(
IDLoaiDV nvarchar(50) primary key,
TenLoaiDV nvarchar(50) not null
)

create table DichVu(
IDDV nvarchar(50) primary key,
TenDV nvarchar(50) not null,
gia money not null,
IDLoaiDV nvarchar(50) not null,
foreign key (IDLoaiDV) references LoaiDV(IDLoaiDV)
)

create table HoaDon(
IDHD nvarchar(50) primary key,
GioBatDau time not null,
GioKetThuc time not null,
TongGio float not null,
TongTien money not null,
IDNV nvarchar(50) not null,
IDMay nvarchar(50) not null,
TrangThai bit not null
foreign key (IDNV) references NhanVien(IDNV),
foreign key (IDMay) references May(IDMay)
)

create table HDCT(
IDHDCT nvarchar(50) primary key,
IDHD nvarchar(50) not null,
IDDV nvarchar(50) not null,
SoLuong int not null,
ThanhTien Money not null,
Gia money not null,
foreign key (IDHD) references HoaDon(IDHD),
foreign key (IDDV) references DichVu(IDDV)
)

insert into NhanVien(IDNV, TenNV, TenDangNhap, MatKhau, VaiTro) values 
('ad1', 'n', 'n123@gmail.com', 'ad1', 1),
('nv1', 'q', 'q123@gmail.com', 'nv1', 0)

insert into May(IDMay, TrangThai, Gia) values
('1', 1, 5000),
('2', 0, 5000),
('3', 1, 5000)
insert into May values
('4', 1, 5000)

insert into LoaiDV(IDLoaiDV, TenLoaiDV) values
('ldv1', 'Do An'),
('ldv2', 'Do Uong'),
('ldv3', 'The Nap')

insert into DichVu(IDDV, TenDV, gia, IDLoaiDV) values 
('dv1', 'Banh My', 15000, 'ldv1'),
('dv2', 'Cafe', 10000, 'ldv2'),
('dv3', 'My 2 trung', 15000, 'ldv1'),
('dv4', 'The Greana 50k', 50000, 'ldv3')

insert into HoaDon(IDHD, GioBatDau, GioKetThuc, TongGio, TongTien, IDMay, IDNV, TrangThai) values 
('hd1', '8:00:00', '9:00:00', 1.0, 5000, 1, 'nv1', 1),
('hd2', '8:00:00', '9:30:00', 1.5, 7500, 2, 'nv1', 1),
('hd3', '11:00:00', '13:00:00', 2.0, 10000, 1, 'ad1', 0)

INSERT INTO HDCT VALUES ('hdct1', 'hd1', 'dv1', 2, 30000, 15000); -- 2 Bánh M?
INSERT INTO HDCT VALUES ('hdct2', 'hd1', 'dv2', 1, 10000, 10000); -- 1 Cafe
INSERT INTO HDCT VALUES ('hdct3', 'hd2', 'dv3', 3, 45000, 15000); -- 3 M? 2 tr?ng
INSERT INTO HDCT VALUES ('hdct4', 'hd2', 'dv4', 1, 50000, 50000); -- 1 th? Garena
INSERT INTO HDCT VALUES ('hdct5', 'hd3', 'dv2', 2, 20000, 10000); -- 2 Cafe

--(Thêm 1 b?ng dv t?m ?? có th? d? l?u d? li?u và truy su?t thanh toán h?n)
create table DichVuMay_Tam(
IDTam nvarchar(50) primary key,
IDLoaiDV nvarchar(50) not null,
IDDV nvarchar(50) not null,
IDMay nvarchar(50) not null,
SoLuong Int,
Gia Money,
ThanhTien AS  (SoLuong * Gia) persisted  
foreign key (IDLoaiDV) references LoaiDV(IDLoaiDV),
foreign key (IDDV) references DichVu(IDDV),
foreign key (IDMay) references May(IDMay),
)
select  dv.IDDV, dv.TenDV, dv.gia
                from LoaiDV as LDV 
                join DichVu as DV on ldv.IDLoaiDV = dv.IDLoaiDV
				where dv.IDLoaiDV = 'ldv1'

select * from DichVuMay_Tam
