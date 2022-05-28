-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th5 28, 2022 lúc 09:12 AM
-- Phiên bản máy phục vụ: 10.4.21-MariaDB
-- Phiên bản PHP: 8.0.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `test`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `categories`
--

CREATE TABLE `categories` (
  `id` int(11) NOT NULL,
  `name` varchar(250) NOT NULL,
  `createdAt` datetime NOT NULL,
  `updatedAt` datetime NOT NULL,
  `status` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `categories`
--

INSERT INTO `categories` (`id`, `name`, `createdAt`, `updatedAt`, `status`) VALUES
(1, 'Chicken Soup', '2022-05-27 23:45:49', '2022-05-27 23:45:49', 1),
(2, 'Pizza Mozela', '2022-05-27 23:45:49', '2022-05-27 23:45:49', 1),
(3, 'Vegetarian dish', '2022-05-27 23:45:49', '2022-05-27 23:45:49', 1),
(4, 'Drinks\n', '2022-05-27 23:45:49', '2022-05-27 23:45:49', 1),
(5, 'Burger-Sanwich', '2022-05-28 16:28:52', '2022-05-28 16:28:52', 1);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `products`
--

CREATE TABLE `products` (
  `id` int(11) NOT NULL,
  `categoryId` int(11) NOT NULL,
  `name` varchar(250) NOT NULL,
  `description` varchar(250) NOT NULL,
  `price` double(15,4) NOT NULL,
  `detail` text NOT NULL,
  `thumbnail` text NOT NULL,
  `createdAt` datetime NOT NULL,
  `updatedAt` datetime NOT NULL,
  `status` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `products`
--

INSERT INTO `products` (`id`, `categoryId`, `name`, `description`, `price`, `detail`, `thumbnail`, `createdAt`, `updatedAt`, `status`) VALUES
(1, 1, 'Pizzahaisan', 'Lorem ipsum', 100.00, '<p>Lorem ipsum</p>\r\n', 'https://res.cloudinary.com/codelean/image/upload/v1653739672/o2zdvqf8tiawi1ccmwzd.jpg', '2022-05-28 17:44:27', '2022-05-28 17:44:27', 1),
(2, 2, 'Noodlesandchickensoup', 'Lorem ipsum', 100.00, '<p>Lorem ipsum</p>\r\n', 'https://res.cloudinary.com/codelean/image/upload/v1653739644/javyvl2p4knqchrwawgt.jpg', '2022-05-28 09:48:56', '2022-05-28 09:48:56', 1),
(9, 1, 'HamBurger', 'Good', 123.560, '<p>Good</p>\r\n\r\n<p>&nbsp;</p>\r\n', 'https://res.cloudinary.com/codelean/image/upload/v1653739550/xmdme0weozqlknqwok28.jpg', '2022-05-28 09:48:15', '2022-05-28 09:48:15', 1),
(19, 1, 'Beff', 'Lorem ipsum', 10640.0000, 'Lorem ipsum', 'https://res.cloudinary.com/codelean/image/upload/v1653739496/leatoawkgzq9syoc6sls.jpg', '2022-05-28 17:09:01', '2022-05-28 17:09:01', -1),
(20, 5, 'SteakandPotato', 'Good Sport', 12.5500, '<p>sadsds</p>', 'https://res.cloudinary.com/codelean/image/upload/v1653739524/ql4uhecx9ist8v5jnbyj.jpg', '2022-05-28 17:13:02', '2022-05-28 17:13:02', 1);

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `categories`
--
ALTER TABLE `categories`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `products`
--
ALTER TABLE `products`
  ADD PRIMARY KEY (`id`),
  ADD KEY `foreignKeyProduct` (`categoryId`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `categories`
--
ALTER TABLE `categories`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT cho bảng `products`
--
ALTER TABLE `products`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

--
-- Các ràng buộc cho các bảng đã đổ
--

--
-- Các ràng buộc cho bảng `products`
--
ALTER TABLE `products`
  ADD CONSTRAINT `foreignKeyProduct` FOREIGN KEY (`categoryId`) REFERENCES `categories` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
