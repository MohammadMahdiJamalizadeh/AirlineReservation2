package Project2;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Files extends Colors{
    private static long byt;
    private static int number;
    static RandomAccessFile random_user;
    static RandomAccessFile random_Flight;
    static RandomAccessFile random_Ticket;
    public void Random() throws FileNotFoundException {
        random_user = new RandomAccessFile("Users1.dat", "rw");
        random_Flight = new RandomAccessFile("Flight1.dat","rw");
        random_Ticket = new RandomAccessFile("Ticket1.dat","rw");
    }
    public String Fix_UserName(String username) throws IOException {
        String str = username;
        try {
            if (str.length() > 15) {
                str = str.substring(0, 15);
                random_user.writeBytes(str);
                return str;
            }
            if (str.length() < 15) {
                for (int i = str.length(); i < 15; i++) {
                    str += " ";
                }
                random_user.writeBytes(str);
                return str;
            }
        } catch (Exception a) {
        }
        return str;
    }
    public String Fix_Password(String password) {
        String str = password;
        try {
            if (str.length() > 15) {
                str = str.substring(0, 14);
                random_user.writeBytes(str);
                return str;
            }
            if (str.length() < 15){
                for (int i = str.length(); i < 14; i++) {
                    str += " ";
                }
                str += "\n";
                random_user.writeBytes(str);
                return str;
            }
        }catch (Exception a){
            return null;
        }
        return null;
    }
    public void ReadUser1(){
        long byt = 0;
        try {
            while (byt < random_user.length()){
                random_user.seek(byt);
                String s = random_user.readLine();
                if (s.equals("null")){
                    return;
                }
                else
                    Users.setNum_User(Users.getNum_User()+1);
                byt = random_user.getFilePointer()+8;
            }
        }catch (Exception a){
            return;
        }
    }
    public String ReadUser(){
            try {
                String str = random_user.readLine();
                str = str.substring(0,15).trim() + str.substring(15,29).trim();
//                System.out.println(str);
                if (str.equals("null")){
                    return null;
                }
                else {
                    return str.trim();
                }
            }catch (Exception a){
                return null;
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
    public String setYear(String y){
        if (y.length() < 5){
            for (int i = y.length(); i < 4; i++) {
                y += " ";
            }
        }
        return y;
    }public String setMonth(String y){
        if (y.length() < 3){
            for (int i = y.length(); i < 2; i++) {
                y += " ";
            }
        }
        return y;
    }
    public String setDay(String y){
    if (y.length() < 3){
        for (int i = y.length(); i < 2; i++) {
            y += " ";
        }
    }
    return y;
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
        try {
        random_Ticket.seek(0);
        for (int j = 0; j <Users.getNum_User(); j++) {
            while (random_Ticket.getFilePointer() < random_Ticket.length()){
                String str = random_Ticket.readLine();
                    if (!str.trim().equals("")) {
                        number++;
                    }
                }
            }
        }catch (Exception a){
            return;
        }
    }
    public int ReadFlight_User1(String s1) {
        int x = 0,j = 0;
        int flag = 0;
        try {
            random_Ticket.seek(0);
                while (random_Ticket.getFilePointer() < random_Ticket.length()){
                    String str = random_Ticket.readLine();
//                    System.out.println(str);
                    if (!str.trim().equals("")) {
                        if (s1.substring(0,15).trim().equals(str.substring(0,29).trim())){
                            if (flag == 0){
                                System.out.printf("%-20s", ANSI_GREEN + "|FlightId|" + ANSI_RESET);
                                System.out.printf("%-20s", ANSI_GREEN + "|Origin|" + ANSI_RESET);
                                System.out.printf("%-25s", ANSI_GREEN + "|Destination|" + ANSI_RESET);
                                System.out.printf("%-25s", ANSI_GREEN + "|Date|" + ANSI_RESET);
                                System.out.printf("%-20s", ANSI_GREEN + "|Time|" + ANSI_RESET);
                                System.out.printf("%-20s", ANSI_GREEN + "|Price|" + ANSI_RESET);
                                System.out.printf("%-15s", ANSI_GREEN + "|TicketId|" + ANSI_RESET);
                                System.out.println();
                                System.out.println(ANSI_BLACK_BOLD + "...................................................................................." + ANSI_RESET);
                                flag = 1;
                            }
                            System.out.printf("%-20s", Colors.colors[j] + (j + 1) + "-" + "|" + str.substring(29,44).trim() + "|" + ANSI_RESET);
                            System.out.printf("%-20s", Colors.colors[j] + "|" + str.substring(44,64).trim() + "|" + ANSI_RESET);
                            System.out.printf("%-25s", Colors.colors[j] + "|" + str.substring(64,84).trim() + "|" + ANSI_RESET);
                            System.out.printf("%-25s", Colors.colors[j] + "|" + str.substring(84,88).trim() + "/" + str.substring(88,90).trim() + "/" + str.substring(90,92).trim() + "|" + ANSI_RESET);
                            System.out.printf("%-20s", Colors.colors[j] + "|" + str.substring(92,97).trim() + "|" + ANSI_RESET);
                            System.out.printf("%-20s", Colors.colors[j] + "|" + str.substring(97,107).trim() + "|" + ANSI_RESET);
                            System.out.printf("%-20s", Colors.colors[j] + "|" + str.substring(107,112).trim() + "|" + ANSI_RESET);
                            System.out.println();
                            j++;
                            System.out.println(ANSI_BLACK_BOLD + "...................................................................................." + ANSI_RESET);
                            x = 1;
                        }
                    }
                }
                return x;

        }catch (Exception a){
            return x;
        }
    }
    public void ReadFlight_Admin() {
        String flightId;
        String b = "";
        try {
            random_Flight.seek(0);
            while (random_Flight.getFilePointer() < random_Flight.length()) {
                String str = random_Flight.readLine();
                flightId = str.substring(0, 15);
                if (flightId.trim().equals(b)){
                    break;
                }
                Flies.setI(Flies.getI() + 1);
            }
        }catch(Exception a){
//            System.out.println(a.getMessage());
            return;
        }
    }
    //****************************///
    public static int getNumber() {
        return number;
    }

    public static void setNumber(int number) {
        Files.number = number;
    }
}

