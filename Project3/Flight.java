package Project3;

public class Flight extends Colors{
    //--------------variable-----------//
    private  String FlightId;
    private  String Origin;
    private  String Destination;
    private  String Year;
    private  String Month;
    private  String Day;
    private  String Time;
    private  String Price;
    private  String Seat;
    Files files = new Files();
    //---------------Constructor------------//
    public Flight(String flightId, String origin, String destination, String year, String month, String day, String time, String price, String seat) {
        try {
//            flightId = files.setFlightID(flightId);
//        System.out.println("flightId :"+flightId.length());
//            Files.random_Flight.writeBytes(flightId);
            FlightId = flightId;
//            origin = files.setOrigin(origin);
//        System.out.println("origin :"+origin.length());
//            Files.random_Flight.writeBytes(origin);
            Origin = origin;
//            destination = files.setDestination(destination);
//        System.out.println("destination :"+destination.length());
//            Files.random_Flight.writeBytes(destination);
            Destination = destination;
//            String date = year + month + day;
//        date = files.setDate(date);
//        System.out.println("date :"+date.length());
            Year = year;
            Month = month;
            Day = day;
//            Files.random_Flight.writeBytes(date);
//            time = files.setTime(time);
//        System.out.println("time :"+time.length());
//            Files.random_Flight.writeBytes(time);
            Time = time;
//            price = files.setPrice(price);
//        System.out.println("price :"+price.length());
//            Files.random_Flight.writeBytes(Price);
            Price = price;
//            seat = files.setSeat(seat);
//        System.out.println("seat :"+seat.length());
//            Files.random_Flight.writeBytes(Seat);
            Seat = seat;
        }catch (Exception a){
            System.out.println("Error");
            return;
        }
    }
    //----------------Sets && Gets-------------//

    public String getFlightId() {
        return FlightId;
    }

    public void setFlightId(String flightId) {
        FlightId = flightId;
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

    public String getTime() {
        return Time;
    }

    public void setTime(String time) {
        Time = time;
    }

//    public long getPrice() {
//        return Price;
//    }

//    public void setPrice(long price) {
//        Price = price;
//    }

//    public int getSeat() {
//        return Seat;
//    }

//    public void setSeat(int seat) {
//        Seat = seat;
//    }


    public String getPrice() {
        return Price;
    }

    public void setPrice(String price) {
        Price = price;
    }

    public String getSeat() {
        return Seat;
    }

    public void setSeat(String seat) {
        Seat = seat;
    }
}
