package com.example.apiHoaDon.Entity;

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
@Table(name = "loaisanpham")
public class LoaiSanPham {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "loaisanphamid")
	private int loaiSanPhamId;
	
	@Column(name = "tenloaisanpham")
	private String tenLoaiSanPham;
	
	@OneToMany(mappedBy = "loaiSanPham",
			fetch = FetchType.LAZY,
			cascade = CascadeType.ALL)
	@JsonIgnoreProperties(value = "loaiSanPham")
	private List<SanPham> sanPhams;
	
	public LoaiSanPham() {
		
	}

	public int getLoaiSanPhamId() {
		return loaiSanPhamId;
	}

	public void setLoaiSanPhamId(int loaiSanPhamId) {
		this.loaiSanPhamId = loaiSanPhamId;
	}

	public String getTenLoaiSanPham() {
		return tenLoaiSanPham;
	}

	public void setTenLoaiSanPham(String tenLoaiSanPham) {
		this.tenLoaiSanPham = tenLoaiSanPham;
	}

	public List<SanPham> getSanPhams() {
		return sanPhams;
	}

	public void setSanPhams(List<SanPham> sanPhams) {
		this.sanPhams = sanPhams;
	}
	
	
}
