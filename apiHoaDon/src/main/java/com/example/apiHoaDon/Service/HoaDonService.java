package com.example.apiHoaDon.Service;


import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.apiHoaDon.Entity.ChiTietHoaDon;
import com.example.apiHoaDon.Entity.HoaDon;
import com.example.apiHoaDon.Entity.SanPham;
import com.example.apiHoaDon.IService.IHoaDonService;
import com.example.apiHoaDon.Repository.ChiTietHoaDonRepository;
import com.example.apiHoaDon.Repository.HoaDonRepository;
import com.example.apiHoaDon.Repository.SanPhamRepository;

@Service
public class HoaDonService implements IHoaDonService{

	@Autowired
	private HoaDonRepository hoaDonRepo;
	
	@Autowired
	private SanPhamRepository sanPhamRepo;
	
	@Autowired
	private ChiTietHoaDonRepository chiTietRepo;
	
	private LocalDate date = LocalDate.now();
	
	@Override
	@Transactional(rollbackOn = {ObjectNotFoundException.class})
	public HoaDon themHoaDon(HoaDon hoaDon) {
		hoaDon.setMaGiaoDich(maGiaoDich());
		hoaDon.setThoiGianTao(date);
		hoaDon.setTongTien(0);
		hoaDonRepo.save(hoaDon);
		
		List<ChiTietHoaDon> dsChiTiet = hoaDon.getChiTietHoaDons();
		dsChiTiet.forEach(chiTiet -> {
			
			Optional<SanPham> sanPham = sanPhamRepo.findById(chiTiet.getSanPham().getSanPhamId());
			
			if(sanPham.isPresent()) {
				
				chiTiet.setThanhTien(chiTiet.getSoLuong() * sanPham.get().getGiaThanh());
				
				chiTiet.setHoaDon(hoaDon);
				
				chiTiet.setSanPham(sanPham.get());
				
				chiTietRepo.save(chiTiet);
				
			}else {
				throw new ObjectNotFoundException(chiTiet.getSanPham().getSanPhamId(), "Id khong hop le");
			}
		});
		
		double tongTien = 0;
		for(ChiTietHoaDon chiTiet:dsChiTiet) {
			tongTien += chiTiet.getThanhTien();
		}
		
		hoaDon.setTongTien(tongTien);
		return hoaDonRepo.save(hoaDon);
	}
	
	
	private String maGiaoDich() {
		String chuoi = "";
		chuoi += date.getYear();
		chuoi += date.getMonth().getValue();
		chuoi += date.getDayOfMonth();
		chuoi += "_";
		
		List<HoaDon> dsHoaDonTrongNgay = hoaDonRepo.findByThoiGianTao(date);
		int maX = dsHoaDonTrongNgay.size();
		
		if(maX < 10) {
			chuoi += "00" + maX;
		}else if (maX >= 10 && maX < 100) {
			chuoi += "0" + maX;
		}else {
			chuoi += maX;
		}
		
		return chuoi;
	}


	@Transactional(rollbackOn = {ObjectNotFoundException.class})
	public HoaDon suaHoaDon(int id) {
		Optional<HoaDon> hoaDon = hoaDonRepo.findById(id);
		if(hoaDon.isPresent()) {
			List<ChiTietHoaDon> dsChiTiet = hoaDon.get().getChiTietHoaDons();
			double tongTien = 0;
			for(ChiTietHoaDon chiTiet : dsChiTiet) {
				tongTien += chiTiet.getThanhTien();
			}
			hoaDon.get().setTongTien(tongTien);
			hoaDon.get().setThoiGianCapNhat(date);
			hoaDonRepo.save(hoaDon.get());
		}
		else {
			throw new ObjectNotFoundException(id, "Id khong ton tai");
		}
		return hoaDon.get();
	}


	@Override
	@Transactional(rollbackOn = {ObjectNotFoundException.class})
	public void xoaHoaDon(int id) {
		Optional<HoaDon> hoaDon = hoaDonRepo.findById(id);
		if(hoaDon.isPresent()) {
			hoaDonRepo.delete(hoaDon.get());
		}
		else {
			throw new ObjectNotFoundException(id, "Id khong ton tai");
		}
	}
	
	
	public List<HoaDon> findByThoiGianTaoDesc(int page, int size){
		Pageable paging = (Pageable) PageRequest.of(page, size);
		Page<HoaDon> pageResult = hoaDonRepo.findByOrderByThoiGianTaoDesc(paging);
		return pageResult.toList();
	}
	
	
	public List<HoaDon> findByYearMonth(int page, int size, int year, int month){
		Pageable paging = (Pageable) PageRequest.of(page, size);
		if(year > 0) {
			Page<HoaDon> pageResult = hoaDonRepo.findByYear(paging, year);
			return pageResult.toList();
		}
		if(month > 0) {
			Page<HoaDon> pageResult = hoaDonRepo.findByMonth(paging, month);
			return pageResult.toList();
		}
		return null;
	}
	
	public List<HoaDon> findByThoiGianTaoBetween(int page, int size, LocalDate start, LocalDate end){
		Pageable paging = (Pageable) PageRequest.of(page, size);
		Page<HoaDon> pageResult = hoaDonRepo.findByThoiGianTaoBetween(paging, start, end);
		return pageResult.toList();
	}

}
