package cn.cnm.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import cn.cnm.pojo.Airport;

public interface AirportMapper {
	@Select("select * from airport")
	public List<Airport> selectAll();

	@Insert("insert airport(id, portName, cityName) values(3, '���Ż���', '�Ϻ���')")
	public void insertShangHai();
	
	@Insert("insert airport(id, portName, cityName) values(3, '��۹��ʻ���', '���')")
	public void insertHongKong();
}
