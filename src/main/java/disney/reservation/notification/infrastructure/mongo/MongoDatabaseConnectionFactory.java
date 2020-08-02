package disney.reservation.notification.infrastructure.mongo;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import config.AppConfig;
import org.springframework.beans.factory.FactoryBean;

public class MongoDatabaseConnectionFactory implements FactoryBean<MongoClient> {

  private final AppConfig appConfig;

  public MongoDatabaseConnectionFactory(AppConfig appConfig) {
    this.appConfig = appConfig;
  }

  @Override
  public MongoClient getObject() {
    final String mongoURL = "mongodb://"
        .concat(appConfig.getDatabaseUser())
        .concat(":")
        .concat(appConfig.getDbPassword())
        .concat("@")
        .concat(appConfig.getDbHost())
        .concat(":")
        .concat(appConfig.getDbPort())
        .concat("/admin");

    return new MongoClient(new MongoClientURI(mongoURL));
  }

  @Override
  public Class<?> getObjectType() {
    return MongoClient.class;
  }

  @Override
  public boolean isSingleton() {
    return true;
  }
}
