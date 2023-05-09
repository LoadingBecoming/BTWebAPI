package com.example.apiHoaDon.IService;

import com.example.apiHoaDon.Entity.HoaDon;

public interface IHoaDonService {
	public HoaDon themHoaDon(HoaDon hoaDon);
	public HoaDon suaHoaDon(int id);
	public void xoaHoaDon(int id);
}
