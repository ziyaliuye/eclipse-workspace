package cn.cnm;

import java.io.IOException;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;

public class DeleteSolr {

	public static void main(String[] args) throws SolrServerException, IOException {
		// ʵ���� Solr ��������
		String urlString = "http://localhost:8983/solr/techproducts";
		SolrClient solr = new HttpSolrClient.Builder(urlString).build();
		String id = "10001";
		solr.deleteById(id);
		System.out.println("ɾ��id:" + id + " ���ݳɹ�");
	}

}
