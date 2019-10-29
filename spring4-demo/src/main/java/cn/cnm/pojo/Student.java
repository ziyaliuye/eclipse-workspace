package cn.cnm.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data // get/set
@AllArgsConstructor // 全参构造
@NoArgsConstructor // 无参构造
@Accessors(chain = true) // 链式风格访问
public class Student {
	private Teacher teacher;
	private int id;
	private int name;
}
