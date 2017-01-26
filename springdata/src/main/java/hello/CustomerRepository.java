package hello;

import hello.model.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CustomerRepository extends MongoRepository<Customer, String>
{
	
	@Query("{ 'city' : ?0 }")
	public Customer findByStadt( String firstName );
	
	public List<Customer> findByLastName( String lastName );

	public List<Customer> findByCity( String city );
}