import java.util.*;

public class BookingRequest {
    public final RoomType roomType;
    public final List<AddOns> addOns;

    public BookingRequest(RoomType roomType, List<AddOns> addOns) {
        this.roomType = roomType;
        this.addOns = addOns;
    }
}
