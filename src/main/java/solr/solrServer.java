package solr;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrResponse;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.beans.Field;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.common.util.NamedList;

import java.util.Iterator;
import java.util.List;

/**
 * Created by Fornia.fu on 2016/6/28.
 */
public class solrServer
{
    public static void main(String[] args)
    {
        try{
            String baseUrl = "http://10.3.30.20:8983/solr/test/";
            SolrClient client = new HttpSolrClient(baseUrl);

            SolrQuery solrQuery = new SolrQuery();
            solrQuery.set("q","{!term f=userAddress}路");
            SolrResponse response = client.query(solrQuery);
            System.out.println(response.getElapsedTime());
            NamedList list =  response.getResponse();
            for(Object o:list){
                System.out.println(o);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
