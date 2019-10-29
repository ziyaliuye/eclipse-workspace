package cn.cnm.service.impl;

import cn.cnm.pojo.Person;
import cn.cnm.service.PersonService;

public class PersonServiceImpl implements PersonService {

	@Override
	public Person getPerson(String id) {
		System.out.println("传入ID：" + id);
		return new Person(id, "蛋蛋", 18);
	}

}
