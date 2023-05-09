package com.example.apiHoaDon.Repository;


import java.time.LocalDate;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.apiHoaDon.Entity.HoaDon;

@Repository
public interface HoaDonRepository extends JpaRepository<HoaDon, Integer>{

	public List<HoaDon> findByThoiGianTao(LocalDate date);
	
	public Page<HoaDon> findByOrderByThoiGianTaoDesc(Pageable paging);
	
	@Query(value = "SELECT H.* FROM hoadon H WHERE YEAR(H.thoigiantao) = :year", 
			countQuery = "SELECT H.* FROM hoadon H WHERE YEAR(H.thoigiantao) = :year",
			nativeQuery = true)
	public Page<HoaDon> findByYear(Pageable paging, @Param("year") int year);
	
	@Query(value = "SELECT H.* FROM hoadon H WHERE MONTH(H.thoigiantao) = :month", 
			countQuery = "SELECT H.* FROM hoadon H WHERE MONTH(H.thoigiantao) = :month",
			nativeQuery = true)
	public Page<HoaDon> findByMonth(Pageable paging, @Param("month") int month);
	
	
	public Page<HoaDon> findByThoiGianTaoBetween(Pageable paging, LocalDate start, LocalDate end);
}
