package hello.config;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;

/**
 * Created on 18.01.2017.
 */
@Configuration
public class MongoConfig extends AbstractMongoConfiguration
{

	@Override
	protected String getDatabaseName() {
		return "test";
	}

	@Override
	public Mongo mongo() throws Exception {
		return new MongoClient( "172.24.3.163", 27017);
	}

	@Override
	protected String getMappingBasePackage() {
		return "hello";
	}
}