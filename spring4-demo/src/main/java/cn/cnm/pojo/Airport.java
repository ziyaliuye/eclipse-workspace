package cn.cnm.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data // get/set
@AllArgsConstructor // ȫ�ι���
@NoArgsConstructor // �޲ι���
@Accessors(chain = true) // ��ʽ������
public class Airport {
	private int id;
	private String portName;
	private String cityName;
}
