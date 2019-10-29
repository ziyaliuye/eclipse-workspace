package cn.cnm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import cn.cnm.mapper.AirportMapper;
import cn.cnm.pojo.Airport;
import cn.cnm.service.AirportService;

public class AirportServiceImpl implements AirportService {
	@Autowired
	private AirportMapper airportMapper;

	@Value("${jdbc.username}")
	private String username;

	public List<Airport> show() {
		System.out.println("userName: " + username);
		return this.airportMapper.selectAll();
	}

	public void insertShangHai() {
		this.airportMapper.insertShangHai();
		this.insertHongKong();
		int i = 1 / 0;
	}

	public void insertHongKong() {
		this.airportMapper.insertHongKong();
	}
}
