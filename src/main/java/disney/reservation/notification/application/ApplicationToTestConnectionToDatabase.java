package disney.reservation.notification.application;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * If we want to make sure we are wired into a mongo database and that there is a table of
 * reservations
 * <p>
 * It is also showing how we will use the mongoDB with Repository-like adapters.
 */
public class ApplicationToTestConnectionToDatabase {

  public static void main(String[] args) {
    final ApplicationContext applicationContext =
        new AnnotationConfigApplicationContext(NotificationContext.class);

    final MongoClient dbConnection = applicationContext.getBean(MongoClient.class);
    final MongoDatabase dbAdapter = applicationContext.getBean(MongoDatabase.class);

    Document reservations = dbAdapter.getCollection("reservations")
        .find()
        .limit(1)
        .first();

    System.out.println("name of reservation: ".concat(reservations.getString("name")));
    System.out.println(reservations);

    dbConnection.close();
  }
}
