-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th4 06, 2024 lúc 09:28 PM
-- Phiên bản máy phục vụ: 10.4.28-MariaDB
-- Phiên bản PHP: 8.1.17

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `quancoffee`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `blog`
--

CREATE TABLE `blog` (
  `id` int(11) NOT NULL,
  `title` varchar(250) NOT NULL,
  `description` varchar(4000) NOT NULL,
  `imgurl` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `blog`
--

INSERT INTO `blog` (`id`, `title`, `description`, `imgurl`) VALUES
(4, 'Entertainment', 'Need something to read? Check out our bookshelf for the hottest New York Bestsellers in the past year. We also have free daily newspapers for anyone\'s leisure. Our television is on throughout the day. Daily events occur ranging from karaoke to concerts from our local school band!', './img/entertainment.jpg'),
(5, 'Day & Night Parking', 'We allow any customer 24/7 parking on our block as long as you are a customer signed up on our email list. However, it is first-come-first-serve so you have to be quick or else someone might take your spot!', './img/parking.jpg'),
(6, 'Venue for Parties', 'We can host any parties for you or your loved ones! We provide the foods from donuts to birthday cakes. We also can play music, provide games, and much more!', './img/venue.jpg'),
(7, 'Hình ảnh it', 'Học IT đòi hỏi sự tập trung cao độ. Khi mệt mỏi, hãy thưởng thức Drip Coffee - đậm vị, ngậy hương, mang đến nguồn năng lượng mới. Drip Coffee sẽ là người bạn đồng hành lý tưởng trên hành trình chinh phục ngôn ngữ lập trình.', './img/it.jpg');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `hoadon`
--

CREATE TABLE `hoadon` (
  `stt` int(11) NOT NULL,
  `MaHoaDon` int(11) DEFAULT NULL,
  `MaMon` int(11) DEFAULT NULL,
  `NgayTaoHoaDon` date DEFAULT NULL,
  `SoLuong` int(11) DEFAULT NULL,
  `Dongia` float DEFAULT NULL,
  `TongBill` float DEFAULT NULL,
  `TenMon` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `hoadon`
--

INSERT INTO `hoadon` (`stt`, `MaHoaDon`, `MaMon`, `NgayTaoHoaDon`, `SoLuong`, `Dongia`, `TongBill`, `TenMon`) VALUES
(74, 2, 55, '2023-12-19', 1, 25000, 25000, NULL),
(75, 2, 56, '2023-12-19', 2, 30000, 60000, NULL),
(76, 2, 57, '2023-12-19', 3, 20000, 60000, NULL),
(77, 2, 58, '2023-12-19', 4, 20000, 80000, NULL),
(78, 3, 55, '2023-12-19', 2, 25000, 50000, NULL),
(79, 4, 55, '2024-01-29', 1, 25000, 25000, NULL),
(80, 4, 56, '2024-01-29', 2, 30000, 60000, NULL),
(81, 4, 59, '2024-01-29', 3, 22000, 66000, NULL);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `khachhang`
--

CREATE TABLE `khachhang` (
  `IDKhachHang` int(11) NOT NULL,
  `TenKhachHang` varchar(255) DEFAULT NULL,
  `SoLanThanhToan` int(11) DEFAULT NULL,
  `DiaChi` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `SDT` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `khachhang`
--

INSERT INTO `khachhang` (`IDKhachHang`, `TenKhachHang`, `SoLanThanhToan`, `DiaChi`, `username`, `SDT`) VALUES
(2, 'Nguyễn Sơn Lâm', 999, '31/13c to 3 khu pho 5', NULL, '0918938732'),
(3, 'Phạm Đức Thông', 10, 'Ho Chi Minh', NULL, '0918'),
(4, 'Phạm Đức Thông', 0, '31/13c to 3 khu pho 5', 'NSL', '1'),
(16, 'Dương Minh Trọng ', 0, '31/13c to 3 khu pho 5', NULL, '0987678787');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `kiemkho`
--

CREATE TABLE `kiemkho` (
  `IDPhieuKiem` int(11) NOT NULL,
  `IDNguyenLieu` int(11) DEFAULT NULL,
  `TenNguyenLieu` varchar(255) DEFAULT NULL,
  `SoLuongConLai` int(11) DEFAULT NULL,
  `SoLuongNhap` int(11) DEFAULT NULL,
  `NgayKiemKho` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `kiemkho`
--

INSERT INTO `kiemkho` (`IDPhieuKiem`, `IDNguyenLieu`, `TenNguyenLieu`, `SoLuongConLai`, `SoLuongNhap`, `NgayKiemKho`) VALUES
(1, 1, 'Tra', 8, 10, '2023-12-01'),
(2, 2, 'Dao', 18, 20, '2023-12-02'),
(3, 3, 'Vai', 13, 15, '2023-12-03');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `menu`
--

CREATE TABLE `menu` (
  `MaMon` int(11) NOT NULL,
  `TenMon` varchar(255) DEFAULT NULL,
  `MoTaMon` varchar(255) DEFAULT NULL,
  `GiaTien` float DEFAULT NULL,
  `HinhAnh` varchar(1000) DEFAULT NULL,
  `NguyenLieuCanThiet` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `menu`
--

INSERT INTO `menu` (`MaMon`, `TenMon`, `MoTaMon`, `GiaTien`, `HinhAnh`, `NguyenLieuCanThiet`) VALUES
(55, 'Tra Olong Chanh', 'Olong Tươi / Chanh', 1000000, 'https://th.bing.com/th/id/OIP.iSdAUwQI2aTJKrTalTtn1QHaHa?w=218&h=218&c=7&r=0&o=5&dpr=1.3&pid=1.7', 'Olong 500ml / chanh 50ml/ đường 60ml'),
(56, 'Tra Olong Đào', 'Olong Tươi / Chanh/ Đào Tươi', 30000, 'Images/tra-dao.jpg', 'Olong 500ml / chanh 50ml/ đường 60ml/ 50ml Đào'),
(57, 'Olong Mật Ong', 'Olong Tươi/ Mật Ong/ Gừng', 20000, 'Images/trataodo.jpg', 'Olong 500ml / chanh 10ml/ đường 20ml/ Mật ong 30ml/ Gừng 2 lát '),
(58, 'Cafe Đen', 'Cafe Đen ( Epresso)', 20000, 'Images/cafeden.jpg', 'Cafe 100Gram'),
(59, 'Cafe Sữa', 'Cafe Đen ( Epresso)/ Sữa tách béo', 22000, 'Images/Cafesua.jpg', 'Cafe 100Gram/ 50ml sữa tách báo');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `nguyenlieu`
--

CREATE TABLE `nguyenlieu` (
  `IDNguyenLieu` int(11) NOT NULL,
  `TenNguyenLieu` varchar(255) DEFAULT NULL,
  `SoLuongNhap` int(11) DEFAULT NULL,
  `DonGiaNhap` float DEFAULT NULL,
  `TongTienNhap` float DEFAULT NULL,
  `NgayNhap` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `nguyenlieu`
--

INSERT INTO `nguyenlieu` (`IDNguyenLieu`, `TenNguyenLieu`, `SoLuongNhap`, `DonGiaNhap`, `TongTienNhap`, `NgayNhap`) VALUES
(1, 'Tra', 10, 10000, 100000, '2023-11-30'),
(2, 'Dao', 20, 5000, 100000, '2023-11-30'),
(3, 'Vai', 15, 7000, 105000, '2023-11-30'),
(6, 'Olong', 3, 30000, 90000, '2023-12-21');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `nhanvien`
--

CREATE TABLE `nhanvien` (
  `IDNhanVien` int(11) NOT NULL,
  `TenNhanVien` varchar(255) DEFAULT NULL,
  `NgaySinh` date DEFAULT NULL,
  `SDT` int(11) DEFAULT NULL,
  `User` varchar(255) DEFAULT NULL,
  `Password` varchar(255) DEFAULT NULL,
  `ChucVu` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `nhanvien`
--

INSERT INTO `nhanvien` (`IDNhanVien`, `TenNhanVien`, `NgaySinh`, `SDT`, `User`, `Password`, `ChucVu`) VALUES
(1, 'Nguyen Van An Nam', '1980-01-01', 123456790, 'nva', 'password1', 'Quản lý'),
(2, 'Tran Thi B', '1985-02-02', 982123456, 'ttb', 'password2', 'Nhan vien'),
(10, 'Nguyễn Sơn Lâm', '2023-09-25', 918938732, 'sonlam4403', NULL, 'Quan Lý'),
(12, 'Phạm Đức Thông', '2003-03-01', 918938732, 'Tinoqqqq', '', 'Security');

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `blog`
--
ALTER TABLE `blog`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `hoadon`
--
ALTER TABLE `hoadon`
  ADD PRIMARY KEY (`stt`),
  ADD KEY `MaMon` (`MaMon`);

--
-- Chỉ mục cho bảng `khachhang`
--
ALTER TABLE `khachhang`
  ADD PRIMARY KEY (`IDKhachHang`);

--
-- Chỉ mục cho bảng `kiemkho`
--
ALTER TABLE `kiemkho`
  ADD PRIMARY KEY (`IDPhieuKiem`),
  ADD KEY `IDNguyenLieu` (`IDNguyenLieu`);

--
-- Chỉ mục cho bảng `menu`
--
ALTER TABLE `menu`
  ADD PRIMARY KEY (`MaMon`);

--
-- Chỉ mục cho bảng `nguyenlieu`
--
ALTER TABLE `nguyenlieu`
  ADD PRIMARY KEY (`IDNguyenLieu`);

--
-- Chỉ mục cho bảng `nhanvien`
--
ALTER TABLE `nhanvien`
  ADD PRIMARY KEY (`IDNhanVien`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `blog`
--
ALTER TABLE `blog`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT cho bảng `hoadon`
--
ALTER TABLE `hoadon`
  MODIFY `stt` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=82;

--
-- AUTO_INCREMENT cho bảng `khachhang`
--
ALTER TABLE `khachhang`
  MODIFY `IDKhachHang` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- AUTO_INCREMENT cho bảng `kiemkho`
--
ALTER TABLE `kiemkho`
  MODIFY `IDPhieuKiem` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT cho bảng `menu`
--
ALTER TABLE `menu`
  MODIFY `MaMon` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=61;

--
-- AUTO_INCREMENT cho bảng `nguyenlieu`
--
ALTER TABLE `nguyenlieu`
  MODIFY `IDNguyenLieu` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT cho bảng `nhanvien`
--
ALTER TABLE `nhanvien`
  MODIFY `IDNhanVien` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;

--
-- Các ràng buộc cho các bảng đã đổ
--

--
-- Các ràng buộc cho bảng `hoadon`
--
ALTER TABLE `hoadon`
  ADD CONSTRAINT `hoadon_ibfk_1` FOREIGN KEY (`MaMon`) REFERENCES `menu` (`MaMon`);

--
-- Các ràng buộc cho bảng `kiemkho`
--
ALTER TABLE `kiemkho`
  ADD CONSTRAINT `kiemkho_ibfk_1` FOREIGN KEY (`IDNguyenLieu`) REFERENCES `nguyenlieu` (`IDNguyenLieu`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
