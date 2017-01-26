package hello.config;

import hello.GreetingController;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JerseyConfig extends ResourceConfig
{
	public JerseyConfig() {
		register( GreetingController.class);
	}
}
