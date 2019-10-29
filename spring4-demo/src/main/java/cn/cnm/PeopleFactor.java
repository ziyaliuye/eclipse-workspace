package cn.cnm;

import cn.cnm.pojo.People;

public class PeopleFactor {
	// 一般工厂模式的方法就是叫 newInstance
	public static People newInstance() {
		return new People();
	}
}
