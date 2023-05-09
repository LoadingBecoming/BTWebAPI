package com.example.apiHoaDon.Entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "hoadon")
public class HoaDon {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "hoadonid")
	private int hoaDonId;
	
	@Column(name = "tenhoadon")
	private String tenHoaDon;
	
	@Column(name = "magiaodich")
	private String maGiaoDich;
	
	@Column(name = "thoigiantao")
	private LocalDate thoiGianTao;
	
	@Column(name = "thoigiancapnhat")
	private LocalDate thoiGianCapNhat;
	
	@Column(name = "ghichu")
	private String ghiChu;
	
	@Column(name = "tongtien")
	private double tongTien;
	
	@ManyToOne
	@JoinColumn(name = "khachhangid")
	@JsonIgnoreProperties(value = "hoaDons")
	private KhachHang khachHang;
	
	
	@OneToMany(mappedBy = "hoaDon",
			fetch = FetchType.LAZY,
			cascade = {CascadeType.DETACH, CascadeType.REMOVE})
	@JsonIgnoreProperties(value = "hoaDon")
	private List<ChiTietHoaDon> chiTietHoaDons;
	
	
	public HoaDon() {
		
	}

	public int getHoaDonId() {
		return hoaDonId;
	}


	public void setHoaDonId(int hoaDonId) {
		this.hoaDonId = hoaDonId;
	}


	public String getTenHoaDon() {
		return tenHoaDon;
	}


	public void setTenHoaDon(String tenHoaDon) {
		this.tenHoaDon = tenHoaDon;
	}


	public String getMaGiaoDich() {
		return maGiaoDich;
	}


	public void setMaGiaoDich(String maGiaoDich) {
		this.maGiaoDich = maGiaoDich;
	}


	public LocalDate getThoiGianTao() {
		return thoiGianTao;
	}


	public void setThoiGianTao(LocalDate thoiGianTao) {
		this.thoiGianTao = thoiGianTao;
	}


	public LocalDate getThoiGianCapNhat() {
		return thoiGianCapNhat;
	}


	public void setThoiGianCapNhat(LocalDate thoiGianCapNhat) {
		this.thoiGianCapNhat = thoiGianCapNhat;
	}


	public String getGhiChu() {
		return ghiChu;
	}


	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}


	public double getTongTien() {
		return tongTien;
	}


	public void setTongTien(double tongTien) {
		this.tongTien = tongTien;
	}


	public KhachHang getKhachHang() {
		return khachHang;
	}


	public void setKhachHang(KhachHang khachHang) {
		this.khachHang = khachHang;
	}


	public List<ChiTietHoaDon> getChiTietHoaDons() {
		return chiTietHoaDons;
	}


	public void setChiTietHoaDons(List<ChiTietHoaDon> chiTietHoaDons) {
		this.chiTietHoaDons = chiTietHoaDons;
	}
	
	
	

}
