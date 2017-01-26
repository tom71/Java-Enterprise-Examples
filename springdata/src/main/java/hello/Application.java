package hello; /**
 * Created on 18.01.2017.
 */

import hello.model.Customer;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.inject.Inject;

@SpringBootApplication
public class Application implements CommandLineRunner
{

	@Inject
	private CustomerRepository repository;

	public static void main( String[] args )
	{
		SpringApplication.run( Application.class, args );
	}

	@Override
	public void run( String... args ) throws Exception
	{

		repository.deleteAll();

		repository.save( new Customer( "Alice", "Smith","Berlin" ) );
		repository.save( new Customer( "Bob", "Smith" ,"Kassel") );
		
	}
}