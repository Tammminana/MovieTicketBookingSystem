import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.ArrayList;

public class Order {
    private final List<Ticket> tickets;
    private final LocalDateTime orderDate;

    public Order(List<Ticket> tickets) {
        this.tickets = new ArrayList<>(tickets);
        this.orderDate = LocalDateTime.now();
    }

    public List<Ticket> getTickets() {
        return new ArrayList<>(tickets);
    }

    public void addTicket(Ticket ticket) {
        tickets.add(ticket);
    }

    public void removeTicket(Ticket ticket) {
        tickets.remove(ticket);
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public BigDecimal calculateTotalPrice(){

        return tickets.stream()
                .map(Ticket::getPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
