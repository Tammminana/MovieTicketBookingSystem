import java.util.List;

public class Theatre {
    private String name;
    private String location;
    private List<Room> rooms;

    public Theatre(String name, String location, List<Room> rooms) {
        this.name = name;
        this.location = location;
        this.rooms = rooms;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }
}

