package cn.cnm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.cnm.dao.DeptDao;
import cn.cnm.entity.Dept;
import cn.cnm.service.DeptService;

@Service
public class DeptServiceImpl implements DeptService {
	@Autowired
	private DeptDao dao;

	@Override
	public boolean add(Dept dept) {
		return this.dao.addDept(dept);
	}

	@Override
	public Dept get(Long id) {
		return this.dao.findById(id);
	}

	@Override
	public List<Dept> list() {
		return this.dao.findAll();
	}

}
