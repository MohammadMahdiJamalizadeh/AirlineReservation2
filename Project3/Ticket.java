package Project3;

public class Ticket {
    //-----------variable------------//
    private  String Origin;
    private  String Destination;
    private  String FlightId;
    private  long Price;
    private  String Time;
    private  String Year;
    private  String Month;
    private  String Day;
    private  int Seat;
    private int TicketId;
    private int i = 0;
    public Ticket[] ticket = new Ticket[50];
    //----------constructor----------//

    public Ticket(String flightId, String origin, String destination, String year, String month, String day, String time, String price,String ticketId) {
        FlightId = flightId;
        Origin = origin;
        Destination = destination;
        Year = year;
        Month = month;
        Day = day;
        Time = time;
        Price = Long.parseLong(price);
//        Seat = seats;
        TicketId = Integer.parseInt(ticketId);
    }
    public Ticket() {
    }
    //----------Sets && Gets---------//


    public int getTicketId() {
        return TicketId;
    }

    public void setTicketId(int ticketId) {
        TicketId = ticketId;
    }

    public String getOrigin() {
        return Origin;
    }

    public void setOrigin(String origin) {
        Origin = origin;
    }

    public String getDestination() {
        return Destination;
    }

    public void setDestination(String destination) {
        Destination = destination;
    }

    public String getFlightId() {
        return FlightId;
    }

    public void setFlightId(String flightId) {
        FlightId = flightId;
    }

    public long getPrice() {
        return Price;
    }

    public void setPrice(long price) {
        Price = price;
    }

    public String getTime() {
        return Time;
    }

    public void setTime(String time) {
        Time = time;
    }

    public String getYear() {
        return Year;
    }

    public void setYear(String year) {
        Year = year;
    }

    public String getMonth() {
        return Month;
    }

    public void setMonth(String month) {
        Month = month;
    }

    public String getDay() {
        return Day;
    }

    public void setDay(String day) {
        Day = day;
    }

    public int getSeat() {
        return Seat;
    }

    public void setSeat(int seat) {
        Seat = seat;
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }
}
