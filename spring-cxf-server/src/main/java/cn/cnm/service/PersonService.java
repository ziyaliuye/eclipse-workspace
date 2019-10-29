package cn.cnm.service;

import javax.jws.WebMethod;
import javax.jws.WebService;

import cn.cnm.pojo.Person;

// 定义接口（SEI）
@WebService
public interface PersonService {
	@WebMethod
	Person getPerson(String id);
}
