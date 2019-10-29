package cn.cnm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cn.cnm.entity.Dept;
import cn.cnm.service.DeptClentService;

@RestController
public class DeptController {
	@Autowired
	private DeptClentService service;

	@RequestMapping(value = "/dept/get{id}", method = RequestMethod.GET)
	public Dept get(@PathVariable("id") Long id) {
		return this.service.get(id);
	}

	@RequestMapping(value = "/dept/list", method = RequestMethod.GET)
	public List<Dept> list() {
		return this.service.list();
	}

	@RequestMapping(value = "/dept/add", method = RequestMethod.GET)
	public boolean add(Dept dept) {
		return this.service.add(dept);
	}
}
