package hello;

import hello.model.Customer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.linesOf;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)

public class GreetingControllerTest {

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void health() {
		ResponseEntity<List> entity = this.restTemplate.getForEntity("/hello",
		                                                                 List.class);

		assertThat(entity.getStatusCode()).isEqualTo(HttpStatus.OK);
	}

	@Test
	public void customer() {
		ResponseEntity<Customer> entity = this.restTemplate.getForEntity("/hello/customer/firstName?name=Berlin",
		                                                 Customer.class);
		System.out.println(entity.getBody());	
		assertThat(entity.getStatusCode()).isEqualTo(HttpStatus.OK);
	}

	@Test
	public void city() {
		ResponseEntity<List> entity = this.restTemplate.getForEntity("/hello/city?city=Berlin",
		                                                             List.class);

		assertThat(entity.getStatusCode()).isEqualTo(HttpStatus.OK);
	}
}