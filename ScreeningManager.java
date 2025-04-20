import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ScreeningManager {
    private final Map<Movie, List<Screening>> screeningsByMovie;
    private final Map<Screening, List<Ticket>> ticketsByScreening;

    public ScreeningManager() {
        this.screeningsByMovie = new HashMap<>();
        this.ticketsByScreening = new HashMap<>();
    }

    public Map<Movie, List<Screening>> getScreeningsByMovie() {
        return new HashMap<>(screeningsByMovie);
    }

    public Map<Screening, List<Ticket>> getTicketsByScreening() {
        return new HashMap<>(ticketsByScreening);
    }

    public void addScreening(Movie movie, Screening screening) {
        screeningsByMovie
                .computeIfAbsent(movie, k -> new ArrayList<>())
                .add(screening);
    }

    public void addTicket(Screening screening, Ticket ticket) {
        ticketsByScreening
                .computeIfAbsent(screening, k -> new ArrayList<>())
                .add(ticket);
    }

    public List<Screening> getScreeningsForMovie(Movie movie) {
        return new ArrayList<>(screeningsByMovie.getOrDefault(movie, new ArrayList<>()));
    }

    public List<Ticket> getTicketsForScreening(Screening screening) {
        return new ArrayList<>(ticketsByScreening.getOrDefault(screening, new ArrayList<>()));
    }


    public List<Seat> getAvailableSeats(Screening screening){
        List<Seat> allSeats = screening.getRoom().getLayout().getAllSeats();
        List<Ticket> bookedTickets = getTicketsForScreening(screening);

        List<Seat>  availableSeats = new ArrayList<>(allSeats);
        for (Ticket ticket: bookedTickets) {
            availableSeats.remove(ticket.getSeat());

        }
        return availableSeats;
    }
}
