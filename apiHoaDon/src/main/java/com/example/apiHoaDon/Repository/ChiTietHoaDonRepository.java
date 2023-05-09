package com.example.apiHoaDon.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.apiHoaDon.Entity.ChiTietHoaDon;

@Repository
public interface ChiTietHoaDonRepository extends JpaRepository<ChiTietHoaDon, Integer>{

}
