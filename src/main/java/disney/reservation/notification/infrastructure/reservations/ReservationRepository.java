package disney.reservation.notification.infrastructure.reservations;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import disney.reservation.notification.domain.Repository;
import disney.reservation.notification.domain.reservations.entities.Reservation;
import java.util.ArrayList;
import java.util.List;
import org.bson.Document;

public class ReservationRepository implements Repository<Reservation> {

  private MongoDatabase database;

  public ReservationRepository(MongoDatabase database) {
    this.database = database;
  }

  @Override
  public List<Reservation> fetchAll() {
    final MongoCollection<Document> mongoReservations = database
        .getCollection("reservations");

    List<Reservation> reservations = new ArrayList<>();

    for (Document doc : mongoReservations.find()) {
      reservations.add(hydrate(doc));
    }

    return reservations;
  }

  private Reservation hydrate(Document document) {
    return new Reservation(
        document.getString("name"),
        document.getString("url"),
        document.getInteger("partySize"),
        document.getString("startDate"),
        document.getString("endDate"),
        document.getString("time")
    );
  }
}
