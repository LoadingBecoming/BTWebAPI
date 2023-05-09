package com.example.apiHoaDon.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.apiHoaDon.Entity.SanPham;

@Repository
public interface SanPhamRepository extends JpaRepository<SanPham, Integer>{

}
