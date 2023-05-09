package com.example.apiHoaDon.Controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.apiHoaDon.Entity.HoaDon;
import com.example.apiHoaDon.Service.HoaDonService;

@RestController
@RequestMapping("api-hoadon")
public class HoaDonController {
	
	@Autowired
	private HoaDonService hoaDonSer;

	@PostMapping("/themHoaDon")
	public ResponseEntity<HoaDon> themHoaDon(@RequestBody HoaDon hoaDon){
		return new ResponseEntity<>(hoaDonSer.themHoaDon(hoaDon), HttpStatus.CREATED);
	}
	
	@PutMapping("/suaHoaDon/{id}")
	public ResponseEntity<HoaDon> suaHoaDon(@PathVariable int id){
		return new ResponseEntity<>(hoaDonSer.suaHoaDon(id), HttpStatus.OK);
	}
	
	@DeleteMapping("/xoaHoaDon/{id}")
	public void xoaHoaDon(@PathVariable int id){
		hoaDonSer.xoaHoaDon(id);
	}
	
	@GetMapping("/findHoaDonByThoiGianTao/{page}/{size}")
	public ResponseEntity<List<HoaDon>> findHoaDonByThoiGianTao(@PathVariable int page, @PathVariable int size){
		return new ResponseEntity<>(hoaDonSer.findByThoiGianTaoDesc(page, size), HttpStatus.OK);
	}
	
	@GetMapping("/findYearMonth/{page}/{size}")
	public ResponseEntity<List<HoaDon>> findYearMonth(@PathVariable int page, @PathVariable int size,@RequestParam(value = "year", defaultValue = "0") int year, @RequestParam(value = "month", defaultValue = "0") int month ){
		return new ResponseEntity<>(hoaDonSer.findByYearMonth(page, size, year, month), HttpStatus.OK);
	}
	
	@GetMapping("/findThoiGianTaoBetween/{page}/{size}")
	public ResponseEntity<List<HoaDon>> findYearMonth(@PathVariable int page, @PathVariable int size,@RequestParam("start") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate start, @RequestParam("end") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate end ){
		return new ResponseEntity<>(hoaDonSer.findByThoiGianTaoBetween(page, size, start, end), HttpStatus.OK);
	}
	
}
