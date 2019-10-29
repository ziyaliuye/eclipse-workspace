package cn.cnm.service.impl;

import org.springframework.stereotype.Service;

import cn.cnm.service.TestService;

@Service
public class TestDaoImpl implements TestService {

	public String test() {
		return "OJBK!!!";
	}

}
