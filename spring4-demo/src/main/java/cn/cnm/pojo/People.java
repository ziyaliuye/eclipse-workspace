package cn.cnm.pojo;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data // get/set
@AllArgsConstructor // 全参构造
@NoArgsConstructor // 无参构造
@Accessors(chain = true) // 链式风格访问
public class People {
	private int id;
	private String name;
	private Set<String> sets;
	private List<String> lists;
	private String[] strings;
	private Map<String, String> maps;
	private Properties files;
}
