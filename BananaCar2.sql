USE [master]
GO
/****** Object:  Database [BananaCar]    Script Date: 8/3/2022 2:19:08 PM ******/
CREATE DATABASE [BananaCar]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'BananaCar', FILENAME = N'D:\Hoai Bao\Quan tri CSDL SQL sever\IDE\MSSQL15.SQLEXPRESS\MSSQL\DATA\BananaCar.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'BananaCar_log', FILENAME = N'D:\Hoai Bao\Quan tri CSDL SQL sever\IDE\MSSQL15.SQLEXPRESS\MSSQL\DATA\BananaCar_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
 WITH CATALOG_COLLATION = DATABASE_DEFAULT
GO
ALTER DATABASE [BananaCar] SET COMPATIBILITY_LEVEL = 150
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [BananaCar].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [BananaCar] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [BananaCar] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [BananaCar] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [BananaCar] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [BananaCar] SET ARITHABORT OFF 
GO
ALTER DATABASE [BananaCar] SET AUTO_CLOSE ON 
GO
ALTER DATABASE [BananaCar] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [BananaCar] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [BananaCar] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [BananaCar] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [BananaCar] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [BananaCar] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [BananaCar] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [BananaCar] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [BananaCar] SET  ENABLE_BROKER 
GO
ALTER DATABASE [BananaCar] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [BananaCar] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [BananaCar] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [BananaCar] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [BananaCar] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [BananaCar] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [BananaCar] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [BananaCar] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [BananaCar] SET  MULTI_USER 
GO
ALTER DATABASE [BananaCar] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [BananaCar] SET DB_CHAINING OFF 
GO
ALTER DATABASE [BananaCar] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [BananaCar] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [BananaCar] SET DELAYED_DURABILITY = DISABLED 
GO
ALTER DATABASE [BananaCar] SET ACCELERATED_DATABASE_RECOVERY = OFF  
GO
ALTER DATABASE [BananaCar] SET QUERY_STORE = OFF
GO
USE [BananaCar]
GO
/****** Object:  UserDefinedFunction [dbo].[demsohoadon]    Script Date: 8/3/2022 2:19:09 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE FUNCTION [dbo].[demsohoadon]()
	RETURNS int
	AS
	BEGIN
		DECLARE @sohoadon int
		SELECT @sohoadon = COUNT(*) FROM HoaDon
		RETURN @sohoadon
	END
GO
/****** Object:  Table [dbo].[ChiTietTraGop]    Script Date: 8/3/2022 2:19:09 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ChiTietTraGop](
	[MaCTTG] [int] IDENTITY(1,1) NOT NULL,
	[MaHDTG] [varchar](10) NULL,
	[MaXe] [varchar](10) NULL,
	[DonGia] [decimal](12, 3) NULL,
	[SoLuong] [int] NULL,
	[ThanhTien] [decimal](12, 3) NULL,
 CONSTRAINT [PK_ChiTietTraGop] PRIMARY KEY CLUSTERED 
(
	[MaCTTG] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[HangXe]    Script Date: 8/3/2022 2:19:09 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[HangXe](
	[MaHang] [varchar](10) NOT NULL,
	[TenHang] [nvarchar](100) NOT NULL,
	[DienThoai] [varchar](12) NOT NULL,
	[Email] [varchar](80) NOT NULL,
	[DiaChi] [nvarchar](100) NOT NULL,
	[TrangThai] [bit] NOT NULL,
 CONSTRAINT [PK_HangXe] PRIMARY KEY CLUSTERED 
(
	[MaHang] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[HoaDon]    Script Date: 8/3/2022 2:19:09 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[HoaDon](
	[MaHD] [varchar](10) NOT NULL,
	[MaKH] [varchar](10) NOT NULL,
	[MaNhanVien] [varchar](10) NOT NULL,
	[NgayBan] [date] NOT NULL,
	[TongSoLuong] [int] NOT NULL,
	[GiamGia] [decimal](12, 3) NOT NULL,
	[GTGT] [decimal](3, 1) NOT NULL,
	[ThanhTien] [decimal](12, 3) NOT NULL,
	[HoaHong] [decimal](3, 2) NOT NULL,
 CONSTRAINT [PK_HoaDon] PRIMARY KEY CLUSTERED 
(
	[MaHD] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[HoaDonChiTiet]    Script Date: 8/3/2022 2:19:09 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[HoaDonChiTiet](
	[MaHDCT] [int] IDENTITY(1,1) NOT NULL,
	[MaHD] [varchar](10) NOT NULL,
	[MaXe] [varchar](10) NOT NULL,
	[DonGia] [decimal](12, 3) NOT NULL,
	[SoLuong] [int] NOT NULL,
	[ThanhTien] [decimal](12, 3) NOT NULL,
 CONSTRAINT [PK_HoaDonChiTiet] PRIMARY KEY CLUSTERED 
(
	[MaHDCT] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[HoaDonTraGop]    Script Date: 8/3/2022 2:19:09 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[HoaDonTraGop](
	[MaHDTG] [varchar](10) NOT NULL,
	[MaKH] [varchar](10) NOT NULL,
	[MaNV] [varchar](10) NOT NULL,
	[NgayBan] [date] NOT NULL,
	[TongSoLuong] [int] NOT NULL,
	[GiamGia] [decimal](12, 3) NOT NULL,
	[GTGT] [decimal](3, 1) NOT NULL,
	[SoNamTraGop] [int] NOT NULL,
	[TraGopMoiThang] [decimal](12, 3) NOT NULL,
	[TongTienTraGop] [decimal](12, 3) NOT NULL,
 CONSTRAINT [PK_HoaDonTraGop] PRIMARY KEY CLUSTERED 
(
	[MaHDTG] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[KhachHang]    Script Date: 8/3/2022 2:19:09 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[KhachHang](
	[MaKH] [varchar](10) NOT NULL,
	[HoTen] [nvarchar](80) NOT NULL,
	[DienThoai] [nvarchar](12) NOT NULL,
	[GioiTinh] [bit] NOT NULL,
	[NgaySinh] [date] NOT NULL,
	[NVQuanLy] [varchar](10) NOT NULL,
	[Email] [varchar](80) NOT NULL,
	[DiaChi] [nvarchar](100) NOT NULL,
	[GhiChu] [nvarchar](50) NULL,
	[TrangThai] [bit] NOT NULL,
 CONSTRAINT [PK_KhachHang] PRIMARY KEY CLUSTERED 
(
	[MaKH] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[LoaiXe]    Script Date: 8/3/2022 2:19:09 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[LoaiXe](
	[MaLoai] [varchar](10) NOT NULL,
	[TenLoai] [nvarchar](100) NOT NULL,
	[GhiChu] [nvarchar](100) NULL,
 CONSTRAINT [PK_LoaiXe] PRIMARY KEY CLUSTERED 
(
	[MaLoai] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[NguoiDung]    Script Date: 8/3/2022 2:19:09 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[NguoiDung](
	[TenDangNhap] [varchar](10) NOT NULL,
	[MatKhau] [varchar](20) NOT NULL,
	[HoTen] [nvarchar](80) NOT NULL,
	[DienThoai] [varchar](12) NOT NULL,
	[GioiTinh] [bit] NOT NULL,
	[NgaySinh] [date] NOT NULL,
	[Email] [varchar](80) NOT NULL,
	[DiaChi] [nvarchar](100) NOT NULL,
	[Luong] [decimal](12, 3) NOT NULL,
	[VaiTro] [bit] NOT NULL,
 CONSTRAINT [PK_NguoiDung] PRIMARY KEY CLUSTERED 
(
	[TenDangNhap] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[PhieuNhapChiTiet]    Script Date: 8/3/2022 2:19:09 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[PhieuNhapChiTiet](
	[MaPNCT] [int] IDENTITY(1,1) NOT NULL,
	[MaPhieuNhap] [nvarchar](10) NOT NULL,
	[MaXe] [varchar](10) NOT NULL,
	[SoLuong] [int] NOT NULL,
	[GiaNhap] [decimal](12, 3) NOT NULL,
	[ThanhTien] [decimal](12, 3) NOT NULL,
 CONSTRAINT [PK_PhieuNhapChiTiet] PRIMARY KEY CLUSTERED 
(
	[MaPNCT] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[PhieuNhapHang]    Script Date: 8/3/2022 2:19:09 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[PhieuNhapHang](
	[MaPhieuNhap] [nvarchar](10) NOT NULL,
	[MaNV] [varchar](10) NOT NULL,
	[NgayNhap] [date] NOT NULL,
	[MaHang] [varchar](10) NOT NULL,
	[TongSoLuong] [int] NOT NULL,
	[ChietKhau] [decimal](3, 1) NOT NULL,
	[GTGT] [decimal](3, 1) NOT NULL,
	[ThanhTien] [decimal](12, 3) NOT NULL,
	[GhiChu] [nvarchar](50) NULL,
 CONSTRAINT [PK_PhieuNhapHang] PRIMARY KEY CLUSTERED 
(
	[MaPhieuNhap] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Xe]    Script Date: 8/3/2022 2:19:09 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Xe](
	[MaXe] [varchar](10) NOT NULL,
	[TenXe] [varchar](100) NOT NULL,
	[MaHang] [varchar](10) NOT NULL,
	[MaLoai] [varchar](10) NOT NULL,
	[TonKho] [int] NOT NULL,
	[DinhMucNhoNhat] [int] NOT NULL,
	[DinhMucLonNhat] [int] NULL,
	[GiaBan] [decimal](12, 3) NOT NULL,
	[Hinh] [nvarchar](50) NULL,
	[TrangThai] [bit] NOT NULL,
	[ChoNgoi] [int] NOT NULL,
	[DongCo] [int] NOT NULL,
	[SucManh] [int] NOT NULL,
	[TayLaiTroLuc] [bit] NOT NULL,
	[TuiKhi] [bit] NOT NULL,
	[HTChongBoCungPhanh] [bit] NOT NULL,
	[BaoHanh] [int] NOT NULL,
 CONSTRAINT [PK_Xe] PRIMARY KEY CLUSTERED 
(
	[MaXe] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
ALTER TABLE [dbo].[ChiTietTraGop]  WITH CHECK ADD  CONSTRAINT [FK_ChiTietTraGop_HoaDonTraGop] FOREIGN KEY([MaHDTG])
REFERENCES [dbo].[HoaDonTraGop] ([MaHDTG])
GO
ALTER TABLE [dbo].[ChiTietTraGop] CHECK CONSTRAINT [FK_ChiTietTraGop_HoaDonTraGop]
GO
ALTER TABLE [dbo].[ChiTietTraGop]  WITH CHECK ADD  CONSTRAINT [FK_ChiTietTraGop_Xe] FOREIGN KEY([MaXe])
REFERENCES [dbo].[Xe] ([MaXe])
GO
ALTER TABLE [dbo].[ChiTietTraGop] CHECK CONSTRAINT [FK_ChiTietTraGop_Xe]
GO
ALTER TABLE [dbo].[HoaDon]  WITH CHECK ADD  CONSTRAINT [FK_HoaDon_KhachHang] FOREIGN KEY([MaKH])
REFERENCES [dbo].[KhachHang] ([MaKH])
GO
ALTER TABLE [dbo].[HoaDon] CHECK CONSTRAINT [FK_HoaDon_KhachHang]
GO
ALTER TABLE [dbo].[HoaDon]  WITH CHECK ADD  CONSTRAINT [FK_HoaDon_NguoiDung] FOREIGN KEY([MaNhanVien])
REFERENCES [dbo].[NguoiDung] ([TenDangNhap])
GO
ALTER TABLE [dbo].[HoaDon] CHECK CONSTRAINT [FK_HoaDon_NguoiDung]
GO
ALTER TABLE [dbo].[HoaDonChiTiet]  WITH CHECK ADD  CONSTRAINT [FK_HoaDonChiTiet_HoaDon] FOREIGN KEY([MaHD])
REFERENCES [dbo].[HoaDon] ([MaHD])
GO
ALTER TABLE [dbo].[HoaDonChiTiet] CHECK CONSTRAINT [FK_HoaDonChiTiet_HoaDon]
GO
ALTER TABLE [dbo].[HoaDonChiTiet]  WITH CHECK ADD  CONSTRAINT [FK_HoaDonChiTiet_Xe] FOREIGN KEY([MaXe])
REFERENCES [dbo].[Xe] ([MaXe])
GO
ALTER TABLE [dbo].[HoaDonChiTiet] CHECK CONSTRAINT [FK_HoaDonChiTiet_Xe]
GO
ALTER TABLE [dbo].[HoaDonTraGop]  WITH CHECK ADD  CONSTRAINT [FK_HoaDonTraGop_KhachHang] FOREIGN KEY([MaKH])
REFERENCES [dbo].[KhachHang] ([MaKH])
GO
ALTER TABLE [dbo].[HoaDonTraGop] CHECK CONSTRAINT [FK_HoaDonTraGop_KhachHang]
GO
ALTER TABLE [dbo].[HoaDonTraGop]  WITH CHECK ADD  CONSTRAINT [FK_HoaDonTraGop_NguoiDung] FOREIGN KEY([MaNV])
REFERENCES [dbo].[NguoiDung] ([TenDangNhap])
GO
ALTER TABLE [dbo].[HoaDonTraGop] CHECK CONSTRAINT [FK_HoaDonTraGop_NguoiDung]
GO
ALTER TABLE [dbo].[KhachHang]  WITH CHECK ADD  CONSTRAINT [FK_KhachHang_NguoiDung] FOREIGN KEY([NVQuanLy])
REFERENCES [dbo].[NguoiDung] ([TenDangNhap])
GO
ALTER TABLE [dbo].[KhachHang] CHECK CONSTRAINT [FK_KhachHang_NguoiDung]
GO
ALTER TABLE [dbo].[PhieuNhapChiTiet]  WITH CHECK ADD  CONSTRAINT [FK_PhieuNhapChiTiet_PhieuNhapHang] FOREIGN KEY([MaPhieuNhap])
REFERENCES [dbo].[PhieuNhapHang] ([MaPhieuNhap])
GO
ALTER TABLE [dbo].[PhieuNhapChiTiet] CHECK CONSTRAINT [FK_PhieuNhapChiTiet_PhieuNhapHang]
GO
ALTER TABLE [dbo].[PhieuNhapChiTiet]  WITH CHECK ADD  CONSTRAINT [FK_PhieuNhapChiTiet_Xe] FOREIGN KEY([MaXe])
REFERENCES [dbo].[Xe] ([MaXe])
GO
ALTER TABLE [dbo].[PhieuNhapChiTiet] CHECK CONSTRAINT [FK_PhieuNhapChiTiet_Xe]
GO
ALTER TABLE [dbo].[PhieuNhapHang]  WITH CHECK ADD  CONSTRAINT [FK_PhieuNhapHang_HangXe] FOREIGN KEY([MaHang])
REFERENCES [dbo].[HangXe] ([MaHang])
GO
ALTER TABLE [dbo].[PhieuNhapHang] CHECK CONSTRAINT [FK_PhieuNhapHang_HangXe]
GO
ALTER TABLE [dbo].[PhieuNhapHang]  WITH CHECK ADD  CONSTRAINT [FK_PhieuNhapHang_NguoiDung] FOREIGN KEY([MaNV])
REFERENCES [dbo].[NguoiDung] ([TenDangNhap])
GO
ALTER TABLE [dbo].[PhieuNhapHang] CHECK CONSTRAINT [FK_PhieuNhapHang_NguoiDung]
GO
ALTER TABLE [dbo].[Xe]  WITH CHECK ADD  CONSTRAINT [FK_Xe_HangXe] FOREIGN KEY([MaHang])
REFERENCES [dbo].[HangXe] ([MaHang])
GO
ALTER TABLE [dbo].[Xe] CHECK CONSTRAINT [FK_Xe_HangXe]
GO
ALTER TABLE [dbo].[Xe]  WITH CHECK ADD  CONSTRAINT [FK_Xe_LoaiXe] FOREIGN KEY([MaLoai])
REFERENCES [dbo].[LoaiXe] ([MaLoai])
GO
ALTER TABLE [dbo].[Xe] CHECK CONSTRAINT [FK_Xe_LoaiXe]
GO
USE [master]
GO
ALTER DATABASE [BananaCar] SET  READ_WRITE 
GO
