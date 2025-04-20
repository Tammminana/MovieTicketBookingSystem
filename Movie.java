import java.time.Duration;

public class Movie {

    // Movie contains immutable static details about the title,rating,genre and duration
    private String title;
    private int durationInMinutes;
    private String rating;
    private String genre;

    public Movie(String title, int durationInMinutes, String rating, String genre) {
        this.title = title;
        this.durationInMinutes = durationInMinutes;
        this.rating = rating;
        this.genre = genre;
    }

    public String getTitle() {
        return title;
    }

    public Duration getDuration() {
        return Duration.ofMinutes(durationInMinutes);
    }

    public String getRating() {
        return rating;
    }

    public String getGenre() {
        return genre;
    }
    public int getDurationInMinutes() {
        return durationInMinutes;
    }
}
