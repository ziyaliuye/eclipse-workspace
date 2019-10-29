package cn.cnm.advice;

public class MyThrowAdvice {
	// 类名和方法名随意， 如果 spring 配置文件里配置了 <aop:after-throwing> 的 throwing 属性
	// 要不就不写参数， 要不就类型是 Exception， 参数名和配置文件必须一样 不然会报错
	public void mythorw(Exception e) {
		System.out.println("有异常！！！");
		System.out.println(e);
	}
}
