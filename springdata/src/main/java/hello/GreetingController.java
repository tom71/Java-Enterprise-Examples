package hello;

import hello.model.Customer;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import javax.ws.rs.*;
import java.util.List;

@Component
@Path( "/hello" )
public class GreetingController
{

	@Inject
	private CustomerRepository repository;

	@GET
	@Produces( "application/json" )
	public List<Customer> message()
	{
		List<Customer> customers = repository.findByLastName( "Smith" );

		return customers;
	}

	@GET
	@Path( "customer" )
	@Produces( "application/json" )
	public List<Customer> greeting( @QueryParam( value = "name" ) String name )
	{
		return repository.findByLastName( name );
	}

	@GET
	@Path( "customer/firstName" )
	@Produces( "application/json" )
	public Customer findByFirstNameLike( @QueryParam( value = "name" ) String name )
	{
		Customer customer = repository.findByStadt( name );
		return customer;
	}

	@GET
	@Path( "city" )
	@Produces( "application/json" )
	public List<Customer> city( @QueryParam( value = "city" ) String city )
	{
		return repository.findByCity( city );
	}
}