package cn.cnm.service.impl;

import com.alibaba.dubbo.config.annotation.Reference;

import cn.cnm.service.DemoService;
import cn.cnm.service.TestService;

public class TestServiceImpl implements TestService {
	// 从注册中心获取该结构的代理对象
	@Reference
	private DemoService demoService;

	// 调用 Provider 中的功能
	@Override
	public void test() {
		// 调用代理对象并获取返回值
		String result = demoService.demo("hello Dubbo");
		System.out.println(result);
	}

}
