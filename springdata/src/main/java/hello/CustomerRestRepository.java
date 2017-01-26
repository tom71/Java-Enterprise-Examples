package hello;

import hello.model.Customer;
import org.springframework.data.repository.query.Param;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

/**
 * Created on 19.01.2017.
 */
@RepositoryRestResource(collectionResourceRel = "customer", path = "customers")
public interface CustomerRestRepository  extends MongoRepository<Customer, String>
{
	List<Customer> findByLastName( @Param("name") String name);
}
