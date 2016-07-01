package solr;


import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.solr.repository.SolrCrudRepository;
import org.springframework.data.solr.repository.SolrRepository;

import java.io.Serializable;

/**
 * Created by Fornia.fu on 2016/6/29.
 */
public interface SolrUserRepository extends SolrCrudRepository<User, String>
{

}
