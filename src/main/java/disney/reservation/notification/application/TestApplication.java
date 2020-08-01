package disney.reservation.notification.application;

public class TestApplication {

    public static void main(String[] args) {
        new CheckForReservationAndEmail().apply();
    }
}
