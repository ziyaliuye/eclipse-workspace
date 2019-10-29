package cn.cnm.service;

import java.util.List;

import cn.cnm.entity.Dept;

public interface DeptService {
	public boolean add(Dept dept);

	public Dept get(Long id);

	public List<Dept> list();
}
