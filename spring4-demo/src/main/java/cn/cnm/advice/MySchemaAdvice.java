package cn.cnm.advice;

import org.springframework.aop.ThrowsAdvice;

public class MySchemaAdvice implements ThrowsAdvice {
	// 这里不是重写接口的方法， 而是新建的方法， 名字还得按要求写这个
	// 官方的例子写 RemoteException 就会捕捉不到， 所以最好写精准异常类型或者直接写 Exception
	public void afterThrowing(Exception ex) throws Throwable {
		System.out.println("执行了 SchemaAdvice 异常通知");
	}

}
