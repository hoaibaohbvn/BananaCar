
-- trigger cập nhập soluongton sau khi cap nhap hoac nhap hang
create trigger soluong on phieunhapchitiet after insert as
begin
	update Xe
	set TonKho = TonKho + (
	select soluong
	from inserted
	where MaXe = Xe.MaXe
	)
	from Xe
	join inserted on Xe.MaXe = inserted.MaXe
end
-- huy don nhap
create trigger conglaisoluongNH on phieunhapchitiet for delete as
begin
	update xe
	set TonKho = TonKho -
		( select soluong from deleted where MaXe = Xe.MaXe)
		from Xe
		join deleted on xe.MaXe = deleted.MaXe

end


-- trigger cập nhập soluongton sau khi cap nhap hoac dat hang
create trigger trusoluong on hoadonchitiet after insert as
begin
	update xe
	set TonKho = TonKho - (
	select SoLuong
	from inserted
	where MaXe = Xe.MaXe
	)
	from Xe
	join inserted on Xe.MaXe = inserted.MaXe
end
-- trigger cập nhập soluongton sau khi huy dat hang
create trigger conglaisoluong on hoadonchitiet for delete as
begin
	update xe
	set TonKho = TonKho +
		( select soluong from deleted where MaXe = Xe.MaXe)
		from Xe
		join deleted on xe.MaXe = deleted.MaXe

end


-- tra gop
-- thanh toan
create trigger trusoluongTG on chitiettragop after insert as
begin
	update xe
	set TonKho = TonKho - (
	select SoLuong
	from inserted
	where MaXe = Xe.MaXe
	)
	from Xe
	join inserted on Xe.MaXe = inserted.MaXe
end
-- huy hang
create trigger conglaisoluongTG on chitiettragop for delete as
begin
	update xe
	set TonKho = TonKho +
		( select soluong from deleted where MaXe = Xe.MaXe)
		from Xe
		join deleted on xe.MaXe = deleted.MaXe

end
