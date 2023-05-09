package com.example.apiHoaDon.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "chitiethoadon")
public class ChiTietHoaDon {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "chitiethoadonid")
	private int chiTietHoaDonId;
	
	@Column(name = "soluong")
	private int soLuong;
	
	@Column(name = "dvt")
	private String dvt;
	
	@Column(name = "thanhtien")
	private double thanhTien;
	
	
	@ManyToOne
	@JoinColumn(name = "sanphamid")
	@JsonIgnoreProperties(value = "chiTietHoaDons")
	private SanPham sanPham;
	
	@ManyToOne
	@JoinColumn(name = "hoadonid")
	@JsonIgnoreProperties(value = "chiTietHoaDons")
	private HoaDon hoaDon;
	
	public ChiTietHoaDon() {
		
	}

	public int getChiTietHoaDonId() {
		return chiTietHoaDonId;
	}

	public void setChiTietHoaDonId(int chiTietHoaDonId) {
		this.chiTietHoaDonId = chiTietHoaDonId;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	public String getDvt() {
		return dvt;
	}

	public void setDvt(String dvt) {
		this.dvt = dvt;
	}

	public double getThanhTien() {
		return thanhTien;
	}

	public void setThanhTien(double thanhTien) {
		this.thanhTien = thanhTien;
	}

	public SanPham getSanPham() {
		return sanPham;
	}

	public void setSanPham(SanPham sanPham) {
		this.sanPham = sanPham;
	}

	public HoaDon getHoaDon() {
		return hoaDon;
	}

	public void setHoaDon(HoaDon hoaDon) {
		this.hoaDon = hoaDon;
	}
	
	
	
	
	
}
