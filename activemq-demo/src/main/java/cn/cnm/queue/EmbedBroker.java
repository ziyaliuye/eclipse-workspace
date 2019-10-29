package cn.cnm.queue;

import org.apache.activemq.broker.BrokerService;

// 嵌入式Broker
public class EmbedBroker {
	public static void main(String[] args) throws Exception {
		// ActiveMQ支持在VM中通信基于嵌入式的Broker
		BrokerService brokerService = new BrokerService();
		brokerService.setUseJmx(true);
		// 本机的ActiveMQ后台使用的端口
		brokerService.addConnector("tcp://localhost:61616");
		brokerService.start();
	}

}
