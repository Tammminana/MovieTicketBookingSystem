import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class MovieBookingSystem {
    private final List<Movie> movies;
    private final List<Theatre> theatres;
    private final ScreeningManager screeningManager;

    public MovieBookingSystem() {
        this.movies = new ArrayList<>();
        this.theatres = new ArrayList<>();
        this.screeningManager = new ScreeningManager();
    }

    public List<Movie> getMovies() {
        return new ArrayList<>(movies);
    }

    public List<Theatre> getTheatres() {
        return new ArrayList<>(theatres);
    }

    public void addMovie(Movie movie) {
        movies.add(movie);
    }

    public void removeMovie(Movie movie) {
        movies.remove(movie);
    }

    public void addTheatre(Theatre theatre) {
        theatres.add(theatre);
    }

    public void removeTheatre(Theatre theatre) {
        theatres.remove(theatre);
    }

    public List<Screening> getScreeningsForMovie(Movie movie) {
        return screeningManager.getScreeningsForMovie(movie);
    }

    public List<Ticket> getTicketsForScreening(Screening screening) {
        return screeningManager.getTicketsForScreening(screening);
    }

    public int getTicketCount(Screening screening) {
        return screeningManager.getTicketsForScreening(screening).size();
    }

    public List<Seat> getAvailableSeats(Screening screening){
        return screeningManager.getAvailableSeats(screening);
    }

    public void bookTicket(Screening screening, Seat seat){
        BigDecimal price = seat.getPricingStrategy().getPrice();
        Ticket ticket = new Ticket(screening, seat, price);

        screeningManager.addTicket(screening,ticket);
    }


}
