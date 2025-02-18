package management;

import java.util.ArrayList;
import java.util.List;

public class ReservationManager {

    private final List<Reservation> reservations = new ArrayList<>();

    public void addReservation(Reservation reservation) {
        reservations.add(reservation);
    }

    public void checkExpiredReservations() {
        reservations.removeIf(reservation -> {
            if (reservation.isExpired()) {
                reservation.getItem().setAvailable(true);
                return false;
            }
            return true;
        });
    }
}
