package cn.cnm.proxy;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data // get/set
@AllArgsConstructor // ȫ�ι���
@NoArgsConstructor // �޲ι���
@Accessors(chain = true) // ��ʽ������
public class Boos implements Action {
	private String name;

	public void talk() {
		System.out.println("��Boss��̸������");
	}

	public void eat() {
		System.out.println("��Boss�Է�������");
	}
}
