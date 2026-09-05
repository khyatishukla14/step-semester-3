package week5;
class BookingReceipt {
    private final String bookingId;
    private final String[] seatNumbers;

    public BookingReceipt(String bookingId, String[] seatNumbers) {
        this.bookingId = bookingId;
        this.seatNumbers = seatNumbers.clone();          // defensive copy in
    }

    public String getBookingId() { return bookingId; }
    public String[] getSeatNumbers() { return seatNumbers.clone(); }   // defensive copy out

    public BookingReceipt withUpdatedSeat(int index, String newSeat) {
        String[] s = getSeatNumbers();
        s[index] = newSeat;
        return new BookingReceipt(bookingId, s);
    }
}

final class GroupBookingReceipt extends BookingReceipt {
    private final int groupSize;
    public GroupBookingReceipt(String bookingId, String[] seatNumbers, int groupSize) {
        super(bookingId, seatNumbers);
        this.groupSize = groupSize;
    }
    public int getGroupSize() { return groupSize; }
}

public class Problem5 {
    static String processNightlySettlement(BookingReceipt[] receipts) {
        int nulls = 0, group = 0, indiv = 0;
        for (BookingReceipt r : receipts) {
            if (r == null) nulls++;
            else if (r instanceof GroupBookingReceipt) group++;
            else indiv++;
        }
        return (group + indiv) + " processed | " + nulls + " null skipped | " + group + " group | " + indiv + " individual";
    }

    public static void main(String[] args) {
        BookingReceipt b = new BookingReceipt("CH-1001", new String[]{"A1", "A2"});
        String[] seats = b.getSeatNumbers();
        seats[0] = "X";
        System.out.println(b.getSeatNumbers()[0]);
        BookingReceipt updated = b.withUpdatedSeat(1, "A3");
        System.out.println(java.util.Arrays.toString(b.getSeatNumbers()) + " " + java.util.Arrays.toString(updated.getSeatNumbers()));
        System.out.println(processNightlySettlement(new BookingReceipt[]{
                new GroupBookingReceipt("CH-2002", new String[]{"B1", "B2"}, 2), null,
                new BookingReceipt("CH-3003", new String[]{"C1"})}));
    }
}
