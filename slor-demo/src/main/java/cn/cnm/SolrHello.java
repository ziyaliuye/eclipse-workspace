package cn.cnm;

import java.io.IOException;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.common.SolrInputDocument;

public class SolrHello {

	public static void main(String[] args) throws SolrServerException, IOException {
		// ʵ���� Solr ��������
		String urlString = "http://localhost:8983/solr/techproducts";
		SolrClient solr = new HttpSolrClient.Builder(urlString).build();

		SolrInputDocument doc1 = new SolrInputDocument();
		// ���Ϊkey�� ����ʹ��ʾ��ģ�壬 ����key������ģ�����
		doc1.setField("id", "10001");
		doc1.setField("name", "IPHONE X MAX PLUS 1T");
		doc1.setField("price", "20000");
		doc1.setField("features", "/images/001.png");

		SolrInputDocument doc2 = new SolrInputDocument();
		doc2.setField("id", "10002");
		doc2.setField("name", "IPAD PRO 1T");
		doc2.setField("price", "18888");
		doc2.setField("features", "/images/002.png");

		// ���÷�����������Ϣ���ύ
		solr.add(doc1);
		solr.add(doc2);

		// �ύ��������
		solr.commit();
		System.out.println("�ύ�ɹ�.....");
	}

}
