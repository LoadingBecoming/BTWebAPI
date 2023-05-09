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
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "khachhang")
public class KhachHang {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "khachhangid")
	private int khachHangId;
	
	@Column(name = "hoten")
	private String hoTen;
	
	@Column(name = "ngaysinh")
	private LocalDate ngaySinh;
	
	@Column(name = "sdt")
	private String sdt;
	
	@OneToMany(mappedBy = "khachHang",
			fetch = FetchType.LAZY,
			cascade = {CascadeType.DETACH,CascadeType.REMOVE})
	@JsonIgnoreProperties(value = "khachHang")
	private List<HoaDon> hoaDons;
	
	public KhachHang() {
		
	}

	public int getKhachHangId() {
		return khachHangId;
	}

	public void setKhachHangId(int khachHangId) {
		this.khachHangId = khachHangId;
	}

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public LocalDate getNgaySinh() {
		return ngaySinh;
	}

	public void setNgaySinh(LocalDate ngaySinh) {
		this.ngaySinh = ngaySinh;
	}

	public String getSdt() {
		return sdt;
	}

	public void setSdt(String sdt) {
		this.sdt = sdt;
	}

	public List<HoaDon> getHoaDons() {
		return hoaDons;
	}

	public void setHoaDons(List<HoaDon> hoaDons) {
		this.hoaDons = hoaDons;
	}
	
	
	
}
