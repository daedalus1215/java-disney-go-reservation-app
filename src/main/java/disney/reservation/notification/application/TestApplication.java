package disney.reservation.notification.application;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestApplication {

    public static void main(String[] args) {
        System.out.println("TestApplication: main");
        final ApplicationContext serviceLocator =
            new AnnotationConfigApplicationContext(NotificationContext.class);
        new CheckForReservationAndEmail(serviceLocator).apply();
    }
}
