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
		// 实例化 Solr 操作对象
		String urlString = "http://localhost:8983/solr/techproducts";
		SolrClient solr = new HttpSolrClient.Builder(urlString).build();

		// 查询类
		SolrQuery solrQuery = new SolrQuery();
		// 设置查询关键词
		solrQuery.set("1", "name:PLUS");
		// 查询数据 前两行代码相互等价，第三行显示如何使用任意参数q来设置查询字符串
		// solrQuery.set("fl", "category,title,price");
		// solrQuery.setFields("category", "title", "price");
		solrQuery.set("q", "name:1T");

		// 查询数据
		QueryResponse response = solr.query(solrQuery);
		// 从查询结果中获取数据
		// 客户端建立网络连接并发送查询。Solr处理查询，并将响应发送并解析为一个QueryResponse。
		// QueryResponse是一组满足查询参数的文档。您可以使用 getResults ()
		// 直接检索文档，并且您可以调用其他方法来查找有关突出显示或facet的信息
		SolrDocumentList list = response.getResults();

		long num = list.getNumFound();
		System.out.println("查询获取条件：" + num);
		for (SolrDocument sd : list) {
			System.out.println(sd.get("id"));
			System.out.println(sd.get("name"));
			System.out.println(sd.get("price"));
			System.out.println(sd.get("features"));
		}
	}
}
