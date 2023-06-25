package Project2;

import java.util.Scanner;

public class Admin extends Colors{
    //------------Input----------//
    Methods methods = new Methods();
    Files files = new Files();
    //------------variable----------//
    private  String Origin;
    private  String Destination;
    private  String FlightId;
    private  String Price;
    private  String Time;
    private  String Year;
    private  String Month;
    private  String Day;
    private  String Seat;
    //-------------------//
    public  void Add_fly() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            try {
                Files.random_Flight.seek(Flies.getI() * 83L);
                System.out.print(ANSI_BLACK_BOLD + "Flight Id : " + ANSI_RESET);
                String Id = scanner.next();
                System.out.print(ANSI_BLACK_BOLD + "Origin : " + ANSI_RESET);
                String Origin = scanner.next();
                System.out.print(ANSI_BLACK_BOLD + "Destination : " + ANSI_RESET);
                String Destination = scanner.next();
                System.out.println(ANSI_BLACK_BOLD + "Date " + ANSI_RESET);
                System.out.println(ANSI_BLUE + "{" + ANSI_RESET);
                System.out.print(ANSI_WHITE_BOLD + " Year : " + ANSI_RESET);
                String Year = scanner.next();
                System.out.print(ANSI_WHITE_BOLD + " Month : " + ANSI_RESET);
                String Month = scanner.next();
                System.out.print(ANSI_WHITE_BOLD + " Day : " + ANSI_RESET);
                String Day = scanner.next();
                System.out.println(ANSI_BLUE + "}" + ANSI_RESET);
                System.out.print(ANSI_BLACK_BOLD + "Time : " + ANSI_RESET);
                String Time = scanner.next();
                System.out.print(ANSI_BLACK_BOLD + "Price : " + ANSI_RESET);
                String Prince = scanner.next();
                System.out.print(ANSI_BLACK_BOLD + "Seats : " + ANSI_RESET);
                String Seat = scanner.next();
                Files.random_Flight.writeBytes(files.setFlightID(Id));
                Files.random_Flight.writeBytes(files.setOrigin(Origin));
                Files.random_Flight.writeBytes(files.setDestination(Destination));
                Files.random_Flight.writeBytes(files.setYear(Year));
                Files.random_Flight.writeBytes(files.setMonth(Month));
                Files.random_Flight.writeBytes(files.setDay(Day));
//                Files.random_Flight.writeBytes(files.setDate(Year+Month+Day));
                Files.random_Flight.writeBytes(files.setTime(Time));
                Files.random_Flight.writeBytes(files.setPrice(Prince));
                Files.random_Flight.writeBytes(files.setSeat(Seat));
                Methods.wait(1);
                Flies.setI(Flies.getI() + 1);
                System.out.println(ANSI_CYAN + "Mission accomplished" + ANSI_RESET);
                int w = methods.Continue();
                if (w == 2)
                    break;
            }catch (Exception a){
                System.err.println("Error");
                Methods.pressEnterToContinue();
                return;
            }
        }
    }
    public void Remove_Ticket() {
        int flag = 1;
        long byt = 0;
        Scanner scanner = new Scanner(System.in);
        Tickets tickets = new Tickets();
        tickets.print_flight_list();
        System.out.print("Please select the desired number : ");
        int x = scanner.nextInt();
        try {
            Files.random_Flight.seek((x-1) * 83L);
            String s = Files.random_Flight.readLine();
            s  = s.substring(0,14).trim();
            Files.random_Ticket.seek(0);
        while (Files.random_Ticket.getFilePointer() < Files.random_Ticket.length()) {
            String s1 = Files.random_Ticket.readLine();
            s1 = s1.substring(29,44).trim();
                if (s.equals(s1)){
                    Methods.wait(0 / 8);
                    System.out.println(ANSI_BLACK_BOLD + "! You cannot Remove because this ticket has been purchased !" + ANSI_RESET);
                    Methods.pressEnterToContinue();
                    return;
                }
            }
        }
        catch (Exception z) {
        }
                //************Write**********//
        try {
                Files.random_Flight.seek((x-1)*83L);
                    for (int i = 0; i < 83; i++) {
                        Files.random_Flight.writeBytes(" ");
                    }
                    Flies.setI(Flies.getI() - 1);
                    while (Files.random_Flight.getFilePointer() < Files.random_Flight.length()){
                        try {
                            String s2 = Files.random_Flight.readLine();
                            if (s2.trim().equals("")){
                                break;
                            }
                            byt = Files.random_Flight.getFilePointer();
                            Files.random_Flight.seek(byt - 166);
                            Files.random_Flight.writeBytes(s2+"\n");
                            byt = Files.random_Flight.getFilePointer();
                            Files.random_Flight.seek(byt + 83);
                        }catch (Exception t){
                            System.out.println(t.getMessage());
                            break;
                        }
                    }
            Files.random_Flight.writeBytes("\n");
            Files.random_Flight.seek(Files.random_Flight.getFilePointer() - 82);
            for (int i = 0; i < 83; i++) {
                    Files.random_Flight.writeBytes(" ");
                }
                //**************************************//
                Methods.wait(1);
                System.out.println(ANSI_CYAN + "Mission accomplished" + ANSI_RESET);
                int w = methods.Continue();
                if (w == 2){
                    return;
                }
            }catch (Exception a){
                System.err.println(a.getMessage());
                Methods.pressEnterToContinue();
                return;
            }
        }
    public void Update_fly(){
        Scanner scanner = new Scanner(System.in);
        Tickets tickets = new Tickets();
        while (true) {
            try {
                tickets.print_flight_list();
                System.out.print(ANSI_BLUE + "Please select the desired ticket : " + ANSI_RESET);
                int x = scanner.nextInt();
                if (x > Flies.getI()){
                    return;
                }
//            Methods.cls();
                Methods.wait(1);
                Files.random_Flight.seek((x-1) * 83L);
                System.out.printf("%-20s", ANSI_GREEN + "|FlightId|" + ANSI_RESET);
                System.out.printf("%-20s", ANSI_GREEN + "|Origin|" + ANSI_RESET);
                System.out.printf("%-25s", ANSI_GREEN + "|Destination|" + ANSI_RESET);
                System.out.printf("%-25s", ANSI_GREEN + "|Date|" + ANSI_RESET);
                System.out.printf("%-20s", ANSI_GREEN + "|Time|" + ANSI_RESET);
                System.out.printf("%-20s", ANSI_GREEN + "|Price|" + ANSI_RESET);
                System.out.printf("%-15s", ANSI_GREEN + "|Seat|" + ANSI_RESET);
                System.out.println();
                Methods.wait(1);
                System.out.print(ANSI_BLUE + "please Enter the desired part : " + ANSI_RESET);
                String a = scanner.next();
                if (a.equals("FlightId")) {
                    Methods.wait(1);
                    System.out.print(ANSI_RED + "NEW FlightId : " + ANSI_RESET);
                    FlightId = scanner.next();
                    Files.random_Flight.writeBytes(files.setFlightID(FlightId));
                } else if (a.equals("Origin")) {
                    Methods.wait(1);
                    System.out.print(ANSI_RED + "NEW Origin : " + ANSI_RESET);
                    Origin = scanner.next();
                    Files.random_Flight.seek(Files.random_Flight.getFilePointer() + 15);
//                    System.out.println(Files.random_Flight.getFilePointer());
                    Files.random_Flight.writeBytes(files.setOrigin(Origin));
//                    System.out.println(Files.random_Flight.getFilePointer());
                } else if (a.equals("Destination")) {
                    Methods.wait(1);
                    System.out.print(ANSI_RED + "NEW Destination : " + ANSI_RESET);
                    Destination = scanner.next();
                    Files.random_Flight.seek(Files.random_Flight.getFilePointer() + 35);
                    Files.random_Flight.writeBytes(files.setDestination(Destination));
                } else if (a.equals("Date")) {
                    Methods.wait(1);
                    System.out.println(ANSI_RED + "NEW Date" + ANSI_RESET);
                    System.out.print(ANSI_BLACK_BOLD + "NEW YEAR : " + ANSI_RESET);
                    Year = scanner.next();
                    System.out.print(ANSI_BLACK_BOLD + "NEW MONTH : " + ANSI_RESET);
                    Month = scanner.next();
                    System.out.print(ANSI_BLACK_BOLD + "NEW DAY : " + ANSI_RESET);
                    Files.random_Flight.seek(Files.random_Flight.getFilePointer() + 55);
                    Day = scanner.next();
                    Files.random_Flight.writeBytes(files.setYear(Year));
                    Files.random_Flight.writeBytes(files.setMonth(Month));
                    Files.random_Flight.writeBytes(files.setDay(Day));
//                    Files.random_Flight.writeBytes(files.setDate(Year+Month+Day));
                } else if (a.equals("Time")) {
                    Methods.wait(1);
                    System.out.print(ANSI_RED + "NEW TIME : " + ANSI_RESET);
                    Time = scanner.next();
                    Files.random_Flight.seek(Files.random_Flight.getFilePointer() + 63);
                    Files.random_Flight.writeBytes(files.setTime(Time));
                } else if (a.equals("Price")) {
                    Methods.wait(1);
                    System.out.print(ANSI_RED + "NEW Price : " + ANSI_RESET);
                    Price = scanner.next();
                    Files.random_Flight.seek(Files.random_Flight.getFilePointer() + 68);
                    Files.random_Flight.writeBytes(files.setPrice(Price));
                } else if (a.equals("Seats")) {
                    Methods.wait(1);
                    System.out.print(ANSI_RED + "NEW Seats : " + ANSI_RESET);
                    Seat = scanner.next();
                    Files.random_Flight.seek(Files.random_Flight.getFilePointer() + 73);
                    Files.random_Flight.writeBytes(files.setSeat(Seat));
                }
                else {
                    return;
                }
                Methods.wait(1);
                System.out.println(ANSI_GREEN + "The operation was successful" + ANSI_RESET);
                int w = methods.Continue();
                if (w == 2)
                    break;
            }catch (Exception a){
                System.err.println("Error");
                return;
            }
        }
    }
    //-----------GETS && SETS----------//
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

    public String getPrice() {
        return Price;
    }

    public void setPrice(String price) {
        Price = price;
    }
}
