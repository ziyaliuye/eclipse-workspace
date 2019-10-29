package cn.cnm.entity;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

// 实体类一定要实现序列化接口
@SuppressWarnings("serial")
@AllArgsConstructor // 创建全参构造方法
@NoArgsConstructor // 创建无参构造方法
@Data // 每个属都生成 get/set 方法
@Accessors(chain = true) // 链式风格访问
public class Dept implements Serializable {
	private Long deptno; // 主键
	private String dname; // 部门名称
	// 来自哪个数据库， 因为微服务架构可以一个服务对应一个数据， 同一个信息被存储到不同的数据库中
	private String db_source;
}
