package Project3;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Files {
    Users users = new Users();
    private static final int FIX_SIZE = 29;
    private static long byt;
    private static int num;
    static RandomAccessFile random_user;
    static RandomAccessFile random_Flight;

    public void Random() throws FileNotFoundException {
        this.random_user = new RandomAccessFile("Users1.dat", "rw");
        this.random_Flight = new RandomAccessFile("Flight1.dat","rw");
    }
    public String File_User(String username, String password) throws IOException {
        String str = username + password;
        random_user.seek((num*30) + (num*500));
        try {
            if (str.length() > FIX_SIZE) {
                str = str.substring(0, 28);
                str += "\n";
                random_user.writeBytes(str);
                byt += 500 + random_user.getFilePointer();
                random_user.seek(byt);
                num++;
                return str;
            }
            if (str.length() < FIX_SIZE) {
                for (int i = str.length(); i < FIX_SIZE; i++) {
                    str += " ";
                }
                str += "\n";
                random_user.writeBytes(str);
                byt = 500 + random_user.getFilePointer();
                random_user.seek(byt);
                num++;
                return str;
            }
        } catch (Exception a) {
        }
        return str;
    }
    public void ReadUser()throws Exception{
        long end = 0;
        while (true) {
            try {
                random_user.seek(end);
                String str = random_user.readLine();
                if (str.equals("null")){
                    return;
                }
                Small_User small_user = new Small_User(str);
                users.setUsers(small_user);
                end = 500 + random_user.getFilePointer();
                num++;
            }catch (Exception a){
                return;
            }
        }
    }
    public void ReadCharge() throws IOException {
        try {
            long end = 30;
                long charge;
                while (random_user.length() != 0) {
                    for (int i = 0; i < num; i++) {
                        random_user.seek(end);
                        charge = random_user.readLong();
                        Users.users[i].setCharge(charge);
                        end = random_user.getFilePointer() + 522;
                    }
                }
        }catch (Exception a){
            return;
        }
    }
    public String setFlightID(String flightID){
        if (flightID.length() < 15){
            for (int i = flightID.length(); i < 15; i++) {
                flightID += " ";
            }
        }
        return flightID;
    }
    public String setOrigin(String Origin){
        if (Origin.length() < 20){
            for (int i = Origin.length(); i < 20; i++) {
                Origin += " ";
            }
        }
        return Origin;
    }
    public String setDestination(String Destination){
        if (Destination.length() < 20){
            for (int i = Destination.length(); i < 20; i++) {
                Destination += " ";
            }
        }
        return Destination;
    }
    public String setDate(String Date){
        if (Date.length() < 9){
            for (int i = Date.length(); i < 8; i++) {
                Date += " ";
            }
        }
        return Date;
    }
    public String setPrice(String price){
        if (price.length() < 11){
            for (int i = price.length(); i < 10; i++) {
                price += " ";
            }
        }
        return price;
    }
    public String setTime(String Time){
        if (Time.length() < 6){
            for (int i = Time.length(); i < 5; i++) {
                Time += " ";
            }
        }
        return Time;
    }
    public String setSeat(String Seat){
        if (Seat.length() < 5){
            for (int i = Seat.length(); i < 4; i++) {
                Seat += " ";
            }
        }
        Seat += "\n";
        return Seat;
    }
    public void ReadFlight_User() {
        long num;
        Tickets tickets = new Tickets();
        String flightId,Origin,Destination,yard,month,day,Price,Time,Seat;
        for (int j = 0; j <users.getI(); j++) {
            for (int i = 0; i < 50; i++) {
                try {
                    num = (i)*83+38+(j * 530L);
                    random_user.seek(num);
                    String str = random_user.readLine();
//                    System.out.println(str);
                    flightId = str.substring(0, 15);
//                    System.out.println(flightId);
                    Origin = str.substring(15, 35);
                    Destination = str.substring(35, 55);
                    yard = str.substring(55, 59);
                    month = str.substring(59, 61);
                    day = str.substring(61, 63);
                    Time = str.substring(63, 68);
                    Price = str.substring(68, 78);
                    Seat = str.substring(78, 83);
                    Ticket ticket = new Ticket(flightId.trim(), Origin.trim(), Destination.trim(), yard.trim(), month.trim(), day.trim(), Time.trim(), Price.trim(), Seat.trim());
                    tickets.setTicket(Users.users[j], ticket);
                }
                catch (Exception a){
                    break;
                }
            }
        }
    }
    public void SetTicket(int j) {
        String flightId, Origin, Destination, yard, month, day, Price, Time, Seat;
        String date;
        try {
            for (int i = 0; i < Users.users[j].ticket.getI(); i++) {
                flightId = Users.users[j].ticket.ticket[i].getFlightId();
                flightId = setFlightID(flightId);
                random_user.writeBytes(flightId);
                Origin = Users.users[j].ticket.ticket[i].getOrigin();
                Origin = setOrigin(Origin);
                random_user.writeBytes(Origin);
                Destination = Users.users[j].ticket.ticket[i].getDestination();
                Destination = setDestination(Destination);
                random_user.writeBytes(Destination);
                yard = Users.users[j].ticket.ticket[i].getYear();
                month = Users.users[j].ticket.ticket[i].getMonth();
                day = Users.users[j].ticket.ticket[i].getDay();
                date = setDate(yard+month+day);
                random_user.writeBytes(date);
                Time = Users.users[j].ticket.ticket[i].getTime();
                Time = setTime(Time);
                random_user.writeBytes(Time);
                Price = String.valueOf((Users.users[j].ticket.ticket[i].getPrice()));
                Price = setPrice(Price);
                random_user.writeBytes(Price);
                Seat = String.valueOf(Users.users[j].ticket.ticket[i].getTicketId());
                Seat += "\n";
                random_user.writeBytes(Seat);
            }
        }catch (Exception a){
        }
    }
    public void ReadFlight_Admin() {
        String flightId,Origin,Destination,yard,month,day,Price,Time,Seat;
        String b = "";
        try {
            random_Flight.seek(0);
            while (random_Flight.getFilePointer() < random_Flight.length()) {
                String str = random_Flight.readLine();
                flightId = str.substring(0, 15);
                if (flightId.trim().equals(b)){
                    break;
                }
                Origin = str.substring(15, 35);
                Destination = str.substring(35, 55);
                yard = str.substring(55, 59);
                month = str.substring(59, 61);
                day = str.substring(61, 63);
                Time = str.substring(63, 68);
                Price = str.substring(68, 78);
                Seat = str.substring(78, 82);
                Flight flight = new Flight(flightId.trim(), Origin.trim(), Destination.trim(), yard.trim(), month.trim(), day.trim(), Time.trim(), Price.trim(), Seat.trim());
                Flies.setFlies(flight);
            }
        }catch(Exception a){
            return;
        }
    }
}
