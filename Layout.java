import java.util.HashMap;
import java.util.Map;
import java.util.List;

public class Layout{
    private final int rows;
    private final int columns;

    private final Map<String, Seat> seatsByNumber;
    private final Map<Integer, Map<Integer,Seat>> seatsByPosition;

    public Layout (int rows, int columns){
        this.rows = rows;
        this.columns = columns;
        this.seatsByNumber = new HashMap();
        this.seatsByPosition = new HashMap();

        initializeLayout();
    }


    private void initializeLayout(){
        for (int i =0; i < rows; i++){
            for ( int j = 0;  j < columns;  j++){
                String seatNumber = i + "=" + j;
                addSeat(seatNumber, i, j, new Seat(seatNumber, null));
            }
        }
    }


    public void addSeat(String seatNumber, int row, int column, Seat seat){
        seatsByNumber.put(seatNumber,seat);
        seatsByPosition
                .computeIfAbsent(row, k-> new HashMap<>())
                .put(column,seat);
    }

    public Seat getSeatByNumber(String seatNumber){
        return seatsByNumber.get(seatNumber)
    }

    public Seat getSeatByPosition(int row, int column){
        Map<Integer, Seat> rowSeats = seatsByPosition.get(row);
        return (rowSeats != null) ? rowSeats.get(column) : null;
    }

    public List<Seat> getAllSeats(){
        return List.copyOf(seatsByNumber.values());
    }
}
