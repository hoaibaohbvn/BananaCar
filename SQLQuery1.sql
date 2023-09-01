
CREATE FUNCTION demsohoadon()
	RETURNS int
	AS
	BEGIN
		DECLARE @sohoadon int
		SELECT @sohoadon = COUNT(*) FROM HoaDon
		RETURN @sohoadon
	END

CREATE PROC sp_insert_hoadon
	@MaKhachHang	varchar(10) = null,
	@MaNhanVien		varchar(10) = null,
	@NgayBan		date = null,
	@TongSoLuong	int = null,
	@ChietKhau		decimal(12,3) = null,
	@GTGT			decimal(3,1) = null,
	@ThanhTien		decimal(12,3) = null,
	@TienKhachTra	decimal(12,3) = null,
	@TrangThai bit = null,
	@HoaHong decimal(12,3) = null
	AS
	BEGIN TRY
		BEGIN TRAN
			DECLARE @MaHoaDon varchar(10)
			SET @MaHoaDon = 'HD'+CAST((dbo.demsohoadon()+1) AS varchar)
			INSERT INTO HoaDon(MaHD, MaKH, MaNhanVien, NgayBan, TongSoLuong, ChietKhau, GTGT, ThanhTien, TienKhachTra, TrangThai, HoaHong)
				VALUES
				(@MaHoaDon, @MaKhachHang, @MaNhanVien, @NgayBan, @TongSoLuong, @ChietKhau, @GTGT, @ThanhTien, @TienKhachTra, @TrangThai,@HoaHong)
		COMMIT TRAN
	END TRY
	BEGIN CATCH
		ROLLBACK TRAN
		PRINT N'Loi roi nha'
	END CATCH