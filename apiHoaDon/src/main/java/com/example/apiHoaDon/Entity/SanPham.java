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
@Table(name = "sanpham")
public class SanPham {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "sanphamid")
	private int sanPhamId;
	
	@Column(name = "tensanpham")
	private String tenSanPham;
	
	@Column(name = "giathanh")
	private double giaThanh;
	
	@Column(name="mota")
	private String moTa;
	
	@Column(name = "ngayhethan")
	private LocalDate ngayHetHan;
	
	@Column(name = "kyhieusanpham")
	private String kyHieuSanPham;
	
	@ManyToOne
	@JoinColumn(name = "loaisanphamid")
	@JsonIgnoreProperties(value = "sanPhams")
	private LoaiSanPham loaiSanPham;
	
	@OneToMany(mappedBy = "sanPham",
			fetch = FetchType.LAZY,
			cascade = CascadeType.ALL)
	@JsonIgnoreProperties(value = "sanPham")
	private List<ChiTietHoaDon> chiTietHoaDons;
	
	public SanPham() {
		
	}

	public int getSanPhamId() {
		return sanPhamId;
	}

	public void setSanPhamId(int sanPhamId) {
		this.sanPhamId = sanPhamId;
	}

	public String getTenSanPham() {
		return tenSanPham;
	}

	public void setTenSanPham(String tenSanPham) {
		this.tenSanPham = tenSanPham;
	}

	public double getGiaThanh() {
		return giaThanh;
	}

	public void setGiaThanh(double giaThanh) {
		this.giaThanh = giaThanh;
	}

	public String getMoTa() {
		return moTa;
	}

	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}

	public LocalDate getNgayHetHan() {
		return ngayHetHan;
	}

	public void setNgayHetHan(LocalDate ngayHetHan) {
		this.ngayHetHan = ngayHetHan;
	}

	public String getKyHieuSanPham() {
		return kyHieuSanPham;
	}

	public void setKyHieuSanPham(String kyHieuSanPham) {
		this.kyHieuSanPham = kyHieuSanPham;
	}

	public LoaiSanPham getLoaiSanPham() {
		return loaiSanPham;
	}

	public void setLoaiSanPham(LoaiSanPham loaiSanPham) {
		this.loaiSanPham = loaiSanPham;
	}

	public List<ChiTietHoaDon> getChiTietHoaDons() {
		return chiTietHoaDons;
	}

	public void setChiTietHoaDons(List<ChiTietHoaDon> chiTietHoaDons) {
		this.chiTietHoaDons = chiTietHoaDons;
	}
	
	

}
