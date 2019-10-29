package cn.cnm;

import java.io.IOException;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;

public class SolrQueryHello {

	public static void main(String[] args) throws SolrServerException, IOException {
		// ʵ���� Solr ��������
		String urlString = "http://localhost:8983/solr/techproducts";
		SolrClient solr = new HttpSolrClient.Builder(urlString).build();

		// ��ѯ��
		SolrQuery solrQuery = new SolrQuery();
		// ���ò�ѯ�ؼ���
		solrQuery.set("1", "name:PLUS");
		// ��ѯ���� ǰ���д����໥�ȼۣ���������ʾ���ʹ���������q�����ò�ѯ�ַ���
		// solrQuery.set("fl", "category,title,price");
		// solrQuery.setFields("category", "title", "price");
		solrQuery.set("q", "name:1T");

		// ��ѯ����
		QueryResponse response = solr.query(solrQuery);
		// �Ӳ�ѯ����л�ȡ����
		// �ͻ��˽����������Ӳ����Ͳ�ѯ��Solr�����ѯ��������Ӧ���Ͳ�����Ϊһ��QueryResponse��
		// QueryResponse��һ�������ѯ�������ĵ���������ʹ�� getResults ()
		// ֱ�Ӽ����ĵ������������Ե������������������й�ͻ����ʾ��facet����Ϣ
		SolrDocumentList list = response.getResults();

		long num = list.getNumFound();
		System.out.println("��ѯ��ȡ������" + num);
		for (SolrDocument sd : list) {
			System.out.println(sd.get("id"));
			System.out.println(sd.get("name"));
			System.out.println(sd.get("price"));
			System.out.println(sd.get("features"));
		}
	}
}
