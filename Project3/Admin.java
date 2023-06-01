package Project3;

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
    private  int w = 3;
    //-------------------//
    public  void Add_fly() {
        Scanner scanner = new Scanner(System.in);
        Admin admin = new Admin();
        try {
            if (Flies.getI() > 0) {
                Files.random_Flight.seek(Flies.getI() * 83L);
            }
        }catch (Exception ignored) {
        }
        while (true) {
            try {
                Files.random_Flight.seek(Flies.getI() * 83L);
                System.out.println(Files.random_Flight.getFilePointer());
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
                Flight flight = new Flight(Id, Origin, Destination, Year, Month, Day, Time, Prince, Seat);
                Flies.setFlies(flight);
                System.out.println(Flies.getI());
                Files.random_Flight.writeBytes(files.setFlightID(Id));
                Files.random_Flight.writeBytes(files.setOrigin(Origin));
                Files.random_Flight.writeBytes(files.setDestination(Destination));
                Files.random_Flight.writeBytes(files.setDate(Year+Month+Day));
                Files.random_Flight.writeBytes(files.setTime(Time));
                Files.random_Flight.writeBytes(files.setPrice(Prince));
                Files.random_Flight.writeBytes(files.setSeat(Seat));
                admin.setW(admin.getW() + 1);
                Methods.wait(1);
//            Methods.cls();
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
        Scanner scanner = new Scanner(System.in);
        Tickets tickets = new Tickets();
        while (true) {
            try {
                tickets.print_flight_list();
                System.out.print("Please select the desired number : ");
                int x = scanner.nextInt();
                System.out.println();
                for (int i = 0; i < Users.getQ(); i++) {
                    if (flag == 1) {
                        for (int j = 0; j < Tickets.getP(); j++) {
                            try {
                                if (Flies.fly[x - 1].getFlightId().equals(Users.users[i].ticket.ticket[j].getFlightId())) {
                                    Methods.wait(0 / 8);
                                    System.out.println(ANSI_BLACK_BOLD + "! You cannot Remove because this ticket has been purchased !" + ANSI_RESET);
                                    Methods.pressEnterToContinue();
                                    return;
                                }
                            } catch (Exception v) {
                                flag = 0;
                                break;
                            }
                        }
                    } else
                        break;
                }
                Flies.fly[x - 1] = Flies.fly[x];
                Flies.setI(Flies.getI() - 1);
                for (int i = x; i < Flies.getI(); i++) {
                    Flies.fly[i] = Flies.fly[i + 1];
                }
//            Methods.cls();
                //************Write**********//
                Files.random_Flight.seek(0);
                for (int i = 0; i < Flies.getI(); i++) {
                    Files.random_Flight.writeBytes(files.setFlightID(Flies.fly[i].getFlightId()));
                    Files.random_Flight.writeBytes(files.setOrigin(Flies.fly[i].getOrigin()));
                    Files.random_Flight.writeBytes(files.setDestination(Flies.fly[i].getDestination()));
                    Files.random_Flight.writeBytes(files.setDate(Flies.fly[i].getYear()+Flies.fly[i].getMonth()+Flies.fly[i].getDay()));
                    Files.random_Flight.writeBytes(files.setTime(Flies.fly[i].getTime()));
                    Files.random_Flight.writeBytes(files.setPrice(Flies.fly[i].getPrice()));
                    Files.random_Flight.writeBytes(files.setSeat(Flies.fly[i].getSeat()));
                }
                for (long i = Files.random_Flight.getFilePointer(); i < 83L*(Flies.getI()+1);i++) {
                    Files.random_Flight.seek(i);
                    Files.random_Flight.writeBytes(" ");
                }
                //**************************************//
                Methods.wait(1);
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
    public void Update_fly(){
        Scanner scanner = new Scanner(System.in);
        Tickets tickets = new Tickets();
        while (true) {
            try {
                tickets.print_flight_list();
                System.out.print(ANSI_BLUE + "Please select the desired ticket : " + ANSI_RESET);
                int x = scanner.nextInt();
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
                System.out.println(ANSI_BLACK_BOLD + "...................................................................................." + ANSI_RESET);
                System.out.printf("%-20s", Colors.colors[x - 1] + "1-" + "|" + Flies.fly[x - 1].getFlightId() + "|" + ANSI_RESET);
                System.out.printf("%-20s", Colors.colors[x - 1] + "|" + Flies.fly[x - 1].getOrigin() + "|" + ANSI_RESET);
                System.out.printf("%-25s", Colors.colors[x - 1] + "|" + Flies.fly[x - 1].getDestination() + "|" + ANSI_RESET);
                System.out.printf("%-25s", Colors.colors[x - 1] + "|" + Flies.fly[x - 1].getYear() + "/" + Flies.fly[x - 1].getMonth() + "/" + Flies.fly[x - 1].getDay() + "|" + ANSI_RESET);
                System.out.printf("%-20s", Colors.colors[x - 1] + "|" + Flies.fly[x - 1].getTime() + "|" + ANSI_RESET);
                System.out.printf("%-20s", Colors.colors[x - 1] + "|" + Flies.fly[x - 1].getPrice() + "|" + ANSI_RESET);
                System.out.printf("%-20s", Colors.colors[x - 1] + "|" + Flies.fly[x - 1].getSeat() + "|" + ANSI_RESET);
                System.out.println();
                System.out.println(ANSI_BLACK_BOLD + "...................................................................................." + ANSI_RESET);
                Methods.wait(1);
                System.out.print(ANSI_BLUE + "please Enter the desired part : " + ANSI_RESET);
                String a = scanner.next();
                if (a.equals("FlightId")) {
                    Methods.wait(1);
                    System.out.print(ANSI_RED + "NEW FlightId : " + ANSI_RESET);
                    FlightId = scanner.next();
                    Files.random_Flight.writeBytes(files.setFlightID(FlightId));
                    Flies.fly[x - 1].setFlightId(FlightId);
                } else if (a.equals("Origin")) {
                    Methods.wait(1);
                    System.out.print(ANSI_RED + "NEW Origin : " + ANSI_RESET);
                    Origin = scanner.next();
                    Files.random_Flight.seek(Files.random_Flight.getFilePointer() + 15);
                    System.out.println(Files.random_Flight.getFilePointer());
                    Files.random_Flight.writeBytes(files.setOrigin(Origin));
                    System.out.println(Files.random_Flight.getFilePointer());
                    Flies.fly[x - 1].setOrigin(Origin);
                } else if (a.equals("Destination")) {
                    Methods.wait(1);
                    System.out.print(ANSI_RED + "NEW Destination : " + ANSI_RESET);
                    Destination = scanner.next();
                    Files.random_Flight.seek(Files.random_Flight.getFilePointer() + 35);
                    Files.random_Flight.writeBytes(files.setDestination(Destination));
                    Flies.fly[x - 1].setDestination(Destination);
                } else if (a.equals("Date")) {
                    Methods.wait(1);
                    System.out.println(ANSI_RED + "NEW Date" + ANSI_RESET);
                    System.out.print(ANSI_BLACK_BOLD + "NEW YEAR : " + ANSI_RESET);
                    Year = scanner.next();
                    Flies.fly[x - 1].setYear(Year);
                    System.out.print(ANSI_BLACK_BOLD + "NEW MONTH : " + ANSI_RESET);
                    Month = scanner.next();
                    Flies.fly[x - 1].setMonth(Month);
                    System.out.print(ANSI_BLACK_BOLD + "NEW DAY : " + ANSI_RESET);
                    Files.random_Flight.seek(Files.random_Flight.getFilePointer() + 55);
                    Day = scanner.next();
                    Files.random_Flight.writeBytes(files.setDate(Year+Month+Day));
                    Flies.fly[x - 1].setDay(Day);
                } else if (a.equals("Time")) {
                    Methods.wait(1);
                    System.out.println(ANSI_RED + "NEW TIME : " + ANSI_RESET);
                    Time = scanner.next();
                    Files.random_Flight.seek(Files.random_Flight.getFilePointer() + 63);
                    Files.random_Flight.writeBytes(files.setTime(Time));
                    Flies.fly[x - 1].setTime(Time);
                } else if (a.equals("Price")) {
                    Methods.wait(1);
                    System.out.print(ANSI_RED + "NEW Price : " + ANSI_RESET);
                    Price = scanner.next();
                    Files.random_Flight.seek(Files.random_Flight.getFilePointer() + 68);
                    Files.random_Flight.writeBytes(files.setPrice(Price));
                    Flies.fly[x - 1].setPrice(Price);
                } else if (a.equals("Seats")) {
                    Methods.wait(1);
                    System.out.print(ANSI_RED + "NEW Seats : " + ANSI_RESET);
                    Seat = scanner.next();
                    Files.random_Flight.seek(Files.random_Flight.getFilePointer() + 73);
                    Files.random_Flight.writeBytes(files.setSeat(Seat));
                    Flies.fly[x - 1].setSeat(Seat);
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

//    public long getPrice() {
//        return Price;
//    }
//
//    public void setPrice(long price) {
//        Price = price;
//    }

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

//    public int getSeat() {
//        return Seat;
//    }
//
//    public void setSeat(int seat) {
//        Seat = seat;
//    }


    public String getPrice() {
        return Price;
    }

    public void setPrice(String price) {
        Price = price;
    }

    public int getW() {
        return w;
    }

    public void setW(int w) {
        this.w = w;
    }
}
