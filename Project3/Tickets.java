package Project3;

import java.util.Scanner;

public class Tickets extends Colors {

    //--------------Variable----------------//
    Methods methods = new Methods();
    Files files = new Files();
    private static int p;
    //-----------------Methods--------------//
    public void setTicket(Small_User user,Ticket ticket1){ // Save purchased tickets
        user.ticket.ticket[user.ticket.getI()] = ticket1;
        user.ticket.setI(user.ticket.getI() + 1);
        p++;
    }
    public void Buy_tickets(Small_User users1) {
        int i = 0;
        Scanner scanner = new Scanner(System.in);
        Tickets tickets = new Tickets();
//        Methods.cls();
        int x;
        long num;
        int Price;
        int Seat;
        try
        {
        while (true) {
                tickets.print_flight_list();
                System.out.print("desired number : ");
                x = scanner.nextInt();
                Methods.wait(1);
                Price = Integer.parseInt(Flies.fly[x - 1].getPrice());
                Seat = Integer.parseInt(Flies.fly[x - 1].getSeat());
                if (users1.getCharge() > Price) {
                    if (Seat > 0) {
                        Price = Integer.parseInt(Flies.fly[x - 1].getPrice());
                        Seat = Integer.parseInt(Flies.fly[x - 1].getSeat());
                        Seat--;
                        users1.setCharge(users1.getCharge() - Price);
                        Files.random_user.seek((Users.getJ()+1)*30L+(Users.getJ()*500L));
                        Files.random_user.writeLong(users1.getCharge());
                        if (users1.ticket.getI() > 0){
                        num = ((users1.ticket.getI()) * 83L+38 + (Users.getJ() * 530L));
                            Files.random_user.seek(num);
                        }
                        else
                            Files.random_user.seek((Users.getJ() + 1) * 38L+ (Users.getJ() * 500L));
                        Flies.fly[x - 1].setSeat(String.valueOf(Seat));
                        int ticketid = Methods.Random();
                        String ticketid1 = String.valueOf(ticketid);
                        System.out.println(ANSI_WHITE_BOLD + "Your ticket purchase was successful" + ANSI_RESET);
                        Methods.wait(0 / 5);
                        Ticket ticket = new Ticket(Flies.fly[x - 1].getFlightId(), Flies.fly[x - 1].getOrigin(), Flies.fly[x - 1].getDestination(), Flies.fly[x - 1].getYear(),
                                Flies.fly[x - 1].getMonth(), Flies.fly[x - 1].getDay(), Flies.fly[x - 1].getTime(),Flies.fly[x - 1].getPrice(),ticketid1);
                        tickets.setTicket(users1, ticket);
                        String FlightID = files.setFlightID(Flies.fly[x - 1].getFlightId());
                        String Origin = files.setOrigin(Flies.fly[x - 1].getOrigin());
                        String Destination = files.setDestination(Flies.fly[x - 1].getDestination());
                        String Price1 = files.setPrice(Flies.fly[x - 1].getPrice());
                        String Time = files.setTime(Flies.fly[x - 1].getTime());
                        String Date = files.setDate(Flies.fly[x - 1].getYear()+Flies.fly[x - 1].getMonth()+Flies.fly[x - 1].getDay());
                        ticketid1 += "\n";
                        Files.random_user.writeBytes(FlightID);
                        Files.random_user.writeBytes(Origin);
                        Files.random_user.writeBytes(Destination);
                        Files.random_user.writeBytes(Date);
                        Files.random_user.writeBytes(Time);
                        Files.random_user.writeBytes(Price1);
                        Files.random_user.writeBytes(ticketid1);
                        Files.random_Flight.seek(((x-1)*83L)+78);
                        System.out.println(Files.random_Flight.getFilePointer());
                        Files.random_Flight.writeBytes(files.setSeat(Flies.fly[x-1].getSeat()));
                        System.out.println(Files.random_Flight.getFilePointer());
                        Methods.wait(1);
                        int w = methods.Continue();
                        if (w == 2)
                            break;
                    } else {
                        System.out.println(ANSI_BLACK_BOLD + "!Unfortunately, there is no empty capacity!" + ANSI_RESET);
                        Methods.wait(1);
                        break;
                    }
                } else {
                    System.out.println(ANSI_BLACK_BOLD + "!Your account balance is insufficient!" + ANSI_RESET);
                    Methods.wait(1);
                    break;
                }
            }
        }catch (Exception a){
            Methods.wait(1);
            System.out.println(ANSI_BLACK_BOLD+"! Please try again !"+ANSI_RESET);
            Methods.wait(0/8);
            return;
        }
    }
    public void save_fly() {
        try {
            Files.random_Flight.seek(0);
            Flight flight = new Flight("WX-12", "Yazd", "Tehran", "1402", "12", "10", "12:30", "700000", "51");
//            Flies.setFlies(flight);
            Files.random_Flight.writeBytes(files.setFlightID(flight.getFlightId()));
            Files.random_Flight.writeBytes(files.setOrigin(flight.getOrigin()));
            Files.random_Flight.writeBytes(files.setDestination(flight.getDestination()));
            Files.random_Flight.writeBytes(files.setDate(flight.getYear() + flight.getMonth() + flight.getDay()));
            Files.random_Flight.writeBytes(files.setTime(flight.getTime()));
            Files.random_Flight.writeBytes(files.setPrice(flight.getPrice()));
            Files.random_Flight.writeBytes(files.setSeat(flight.getSeat()));
            Flight flight1 = new Flight("WZ-15", "Mashhad", "Ahvaz", "1402", "10", "27", "13:50", "900000", "245");
//            Flies.setFlies(flight1);
            Files.random_Flight.writeBytes(files.setFlightID(flight1.getFlightId()));
            Files.random_Flight.writeBytes(files.setOrigin(flight1.getOrigin()));
            Files.random_Flight.writeBytes(files.setDestination(flight1.getDestination()));
            Files.random_Flight.writeBytes(files.setDate(flight1.getYear() + flight1.getMonth() + flight1.getDay()));
            Files.random_Flight.writeBytes(files.setTime(flight1.getTime()));
            Files.random_Flight.writeBytes(files.setPrice(flight1.getPrice()));
            Files.random_Flight.writeBytes(files.setSeat(flight1.getSeat()));
            Flight flight2 = new Flight("BG-22", "Shiraz", "Tabriz", "1402", "11", "12", "8:00", "1100000", "12");
//            Flies.setFlies(flight2);
            Files.random_Flight.writeBytes(files.setFlightID(flight2.getFlightId()));
            Files.random_Flight.writeBytes(files.setOrigin(flight2.getOrigin()));
            Files.random_Flight.writeBytes(files.setDestination(flight2.getDestination()));
            Files.random_Flight.writeBytes(files.setDate(flight2.getYear() + flight2.getMonth() + flight2.getDay()));
            Files.random_Flight.writeBytes(files.setTime(flight2.getTime()));
            Files.random_Flight.writeBytes(files.setPrice(flight2.getPrice()));
            Files.random_Flight.writeBytes(files.setSeat(flight2.getSeat()));
//            Flight flight3 = new Flight("WA-64", "Tehran", "Zahedan", "1402", "03", "30", "00:20", "1500000", "20");
////            Flies.setFlies(flight3);
//            Files.random_Flight.writeBytes(files.setFlightID(flight3.getFlightId()));
//            Files.random_Flight.writeBytes(files.setOrigin(flight3.getOrigin()));
//            Files.random_Flight.writeBytes(files.setDestination(flight3.getDestination()));
//            Files.random_Flight.writeBytes(files.setDate(flight3.getYear() + flight3.getMonth() + flight3.getDay()));
//            Files.random_Flight.writeBytes(files.setTime(flight3.getTime()));
//            Files.random_Flight.writeBytes(files.setPrice(flight3.getPrice()));
//            Files.random_Flight.writeBytes(files.setSeat(flight3.getSeat()));
//            Flight flight4 = new Flight("QP-28", "Kerman", "Tehran", "1402", "12", "10", "18:00", "2000000", "5");
////            Flies.setFlies(flight4);
//            Files.random_Flight.writeBytes(files.setFlightID(flight4.getFlightId()));
//            Files.random_Flight.writeBytes(files.setOrigin(flight4.getOrigin()));
//            Files.random_Flight.writeBytes(files.setDestination(flight4.getDestination()));
//            Files.random_Flight.writeBytes(files.setDate(flight4.getYear() + flight4.getMonth() + flight4.getDay()));
//            Files.random_Flight.writeBytes(files.setTime(flight4.getTime()));
//            Files.random_Flight.writeBytes(files.setPrice(flight4.getPrice()));
//            Files.random_Flight.writeBytes(files.setSeat(flight4.getSeat()));
        }catch (Exception a){
            System.out.println(a.getMessage());
        }
    }
    public void print_flight_list() {
        try {
//        Methods.cls();
            System.out.printf("%-20s", ANSI_GREEN + "|FlightId|" + ANSI_RESET);
            System.out.printf("%-20s", ANSI_GREEN + "|Origin|" + ANSI_RESET);
            System.out.printf("%-25s", ANSI_GREEN + "|Destination|" + ANSI_RESET);
            System.out.printf("%-25s", ANSI_GREEN + "|Date|" + ANSI_RESET);
            System.out.printf("%-20s", ANSI_GREEN + "|Time|" + ANSI_RESET);
            System.out.printf("%-20s", ANSI_GREEN + "|Price|" + ANSI_RESET);
            System.out.printf("%-15s", ANSI_GREEN + "|Seat|" + ANSI_RESET);
            System.out.println();
            System.out.println(ANSI_BLACK_BOLD + "...................................................................................." + ANSI_RESET);
            for (int i = 0; i < Flies.getI(); i++) {
                System.out.printf("%-20s", Colors.colors[i] + (i + 1) + "-" + "|" + Flies.fly[i].getFlightId() + "|" + ANSI_RESET);
                System.out.printf("%-20s", Colors.colors[i] + "|" + Flies.fly[i].getOrigin() + "|" + ANSI_RESET);
                System.out.printf("%-25s", Colors.colors[i] + "|" + Flies.fly[i].getDestination() + "|" + ANSI_RESET);
                System.out.printf("%-25s", Colors.colors[i] + "|" + Flies.fly[i].getYear() + "/" + Flies.fly[i].getMonth() + "/" + Flies.fly[i].getDay() + "|" + ANSI_RESET);
                System.out.printf("%-20s", Colors.colors[i] + "|" + Flies.fly[i].getTime() + "|" + ANSI_RESET);
                System.out.printf("%-20s", Colors.colors[i] + "|" + Flies.fly[i].getPrice() + "|" + ANSI_RESET);
                System.out.printf("%-20s", Colors.colors[i] + "|" + Flies.fly[i].getSeat() + "|" + ANSI_RESET);
                System.out.println();
                System.out.println(ANSI_BLACK_BOLD + "...................................................................................." + ANSI_RESET);
                Methods.wait(0 / 5);
            }
            System.out.println();
            Methods.pressEnterToContinue();
        }catch (Exception a){
            System.err.println(a.getMessage());
            return;
        }
    }
    public void Booked_thickets(Small_User users1) {
        try {
//        Methods.cls();
            if (users1.ticket.getI() == 0) {
                System.out.println(ANSI_RED + "* You do not have a purchased ticket *" + ANSI_RESET);
                Methods.wait(1);
                Methods.pressEnterToContinue();
                return;
            }
            Methods.wait(1);
            System.out.printf("%-20s", ANSI_GREEN + "|FlightId|" + ANSI_RESET);
            System.out.printf("%-20s", ANSI_GREEN + "|Origin|" + ANSI_RESET);
            System.out.printf("%-25s", ANSI_GREEN + "|Destination|" + ANSI_RESET);
            System.out.printf("%-25s", ANSI_GREEN + "|Date|" + ANSI_RESET);
            System.out.printf("%-20s", ANSI_GREEN + "|Time|" + ANSI_RESET);
            System.out.printf("%-20s", ANSI_GREEN + "|Price|" + ANSI_RESET);
            System.out.printf("%-15s", ANSI_GREEN + "|TicketId|" + ANSI_RESET);
            System.out.println();
            System.out.println(ANSI_BLACK_BOLD + "...................................................................................." + ANSI_RESET);
            for (int i = 0; i < users1.ticket.getI(); i++) {
                System.out.printf("%-20s", Colors.colors[i] + (i + 1) + "-" + "|" + users1.ticket.ticket[i].getFlightId() + "|" + ANSI_RESET);
                System.out.printf("%-20s", Colors.colors[i] + "|" + users1.ticket.ticket[i].getOrigin() + "|" + ANSI_RESET);
                System.out.printf("%-25s", Colors.colors[i] + "|" + users1.ticket.ticket[i].getDestination() + "|" + ANSI_RESET);
                System.out.printf("%-25s", Colors.colors[i] + "|" + users1.ticket.ticket[i].getYear() + "/" + users1.ticket.ticket[i].getMonth() + "/" + users1.ticket.ticket[i].getDay() + "|" + ANSI_RESET + '\t');
                System.out.printf("%-20s", Colors.colors[i] + "|" + users1.ticket.ticket[i].getTime() + "|" + ANSI_RESET);
                System.out.printf("%-20s", Colors.colors[i] + "|" + users1.ticket.ticket[i].getPrice() + "|" + ANSI_RESET);
                System.out.printf("%-20s", Colors.colors[i] + "|" + users1.ticket.ticket[i].getTicketId() + "|" + ANSI_RESET);
                System.out.println();
                System.out.println(ANSI_BLACK_BOLD + "...................................................................................." + ANSI_RESET);
                Methods.wait(0 / 5);
            }
            System.out.println();
            Methods.pressEnterToContinue();
        }catch (Exception a){
            a.getMessage();
            return;
        }
    }
    public void Search(){
        Scanner scanner = new Scanner(System.in);
        int sum = 0;
        int Flag = 1;
        int j = 1;
        methods.wait(0/8);
        System.out.println(ANSI_BLACK_BOLD + "-----------------------------------------------" + ANSI_RESET);
        System.out.println(ANSI_BLACK_BOLD + "-----------------------------------------------" + ANSI_RESET);
        System.out.println(ANSI_YELLOW + "                    Search" + ANSI_RESET);
        System.out.println(ANSI_BLACK_BOLD + "-----------------------------------------------" + ANSI_RESET);
        System.out.println(ANSI_BLACK_BOLD + "-----------------------------------------------" + ANSI_RESET);
        System.out.println("Select the search type :");
        System.out.println(ANSI_BLUE+"1- Based on the city"+ANSI_RESET);
        System.out.println(ANSI_BLUE+"2- Based on the Price"+ANSI_RESET);
        System.out.println(ANSI_BLUE+"3- Based on the Date"+ANSI_RESET);
        String x = scanner.next();
        if (x.equals("1")){
            System.out.println(ANSI_PURPLE+"Please search for the desired city :"+ANSI_RESET);
            String str = scanner.next();
            str = str.toUpperCase();
            Methods.wait(1);
            for (int i = 0; i < Flies.getI(); i++) {
                if (str.equals(Flies.fly[i].getDestination().toUpperCase()) || str.equals(Flies.fly[i].getOrigin().toUpperCase())) {
                    if (Flag == 1){
                        System.out.printf("%-20s",ANSI_GREEN + "|FlightId|"+ANSI_RESET);
                        System.out.printf("%-20s",ANSI_GREEN + "|Origin|"+ANSI_RESET);
                        System.out.printf("%-25s",ANSI_GREEN + "|Destination|"+ANSI_RESET);
                        System.out.printf("%-25s",ANSI_GREEN + "|Date|"+ANSI_RESET);
                        System.out.printf("%-20s",ANSI_GREEN + "|Time|"+ANSI_RESET);
                        System.out.printf("%-20s",ANSI_GREEN + "|Price|"+ANSI_RESET);
                        System.out.printf("%-15s",ANSI_GREEN + "|Seat|"+ANSI_RESET);
                        System.out.println();
                        System.out.println(ANSI_BLACK_BOLD + "...................................................................................." + ANSI_RESET);
                    }
                    System.out.printf("%-20s",Colors.colors[i] + (j) + "-" + "|" + Flies.fly[i].getFlightId() + "|" + ANSI_RESET);
                    System.out.printf("%-20s",Colors.colors[i] + "|" + Flies.fly[i].getOrigin() + "|" + ANSI_RESET);
                    System.out.printf("%-25s",Colors.colors[i] + "|" + Flies.fly[i].getDestination() + "|" + ANSI_RESET);
                    System.out.printf("%-25s",Colors.colors[i] + "|" + Flies.fly[i].getYear() + "/" + Flies.fly[i].getMonth() + "/" + Flies.fly[i].getDay() + "|" + ANSI_RESET );
                    System.out.printf("%-20s",Colors.colors[i] + "|" + Flies.fly[i].getTime() + "|" + ANSI_RESET);
                    System.out.printf("%-20s",Colors.colors[i] + "|" + Flies.fly[i].getPrice() + "|" + ANSI_RESET);
                    System.out.printf("%-20s",Colors.colors[i] + "|" + Flies.fly[i].getSeat() + "|" + ANSI_RESET);
                    System.out.println();
                    System.out.println(ANSI_BLACK_BOLD + "...................................................................................." + ANSI_RESET);
                    Methods.wait(0 / 5);
                    sum++;
                    j++;
                    Flag = 0;
                }
            }
            if (sum == 0){
                System.out.println(ANSI_BLACK_BOLD+"! No flights were found with this specification !"+ANSI_RESET);
            }
        }
        if (x.equals("2")){
            sum = 0;
            Flag = 1;
            j = 1;
            System.out.println(ANSI_BLUE+"Please enter the Minimum amount"+ANSI_RESET);
            long minimum = scanner.nextInt();
            System.out.println(ANSI_BLUE+"Please enter the Maximum value"+ANSI_RESET);
            long maximum = scanner.nextInt();
            Methods.wait(1);
            for (int i = 0; i < Flies.getI(); i++) {
                int Price = Integer.parseInt(Flies.fly[i].getPrice());
                if (minimum <=  Price && Price <= maximum) {
                    if (Flag == 1){
                        System.out.printf("%-20s",ANSI_GREEN + "|FlightId|"+ANSI_RESET);
                        System.out.printf("%-20s",ANSI_GREEN + "|Origin|"+ANSI_RESET);
                        System.out.printf("%-25s",ANSI_GREEN + "|Destination|"+ANSI_RESET);
                        System.out.printf("%-25s",ANSI_GREEN + "|Date|"+ANSI_RESET);
                        System.out.printf("%-20s",ANSI_GREEN + "|Time|"+ANSI_RESET);
                        System.out.printf("%-20s",ANSI_GREEN + "|Price|"+ANSI_RESET);
                        System.out.printf("%-15s",ANSI_GREEN + "|Seat|"+ANSI_RESET);
                        System.out.println();
                        System.out.println(ANSI_BLACK_BOLD + "...................................................................................." + ANSI_RESET);
                    }
                    System.out.printf("%-20s",Colors.colors[i] + (j) + "-" + "|" + Flies.fly[i].getFlightId() + "|" + ANSI_RESET);
                    System.out.printf("%-20s",Colors.colors[i] + "|" + Flies.fly[i].getOrigin() + "|" + ANSI_RESET);
                    System.out.printf("%-25s",Colors.colors[i] + "|" + Flies.fly[i].getDestination() + "|" + ANSI_RESET);
                    System.out.printf("%-25s",Colors.colors[i] + "|" + Flies.fly[i].getYear() + "/" + Flies.fly[i].getMonth() + "/" + Flies.fly[i].getDay() + "|" + ANSI_RESET );
                    System.out.printf("%-20s",Colors.colors[i] + "|" + Flies.fly[i].getTime() + "|" + ANSI_RESET);
                    System.out.printf("%-20s",Colors.colors[i] + "|" + Flies.fly[i].getPrice() + "|" + ANSI_RESET);
                    System.out.printf("%-20s",Colors.colors[i] + "|" + Flies.fly[i].getSeat() + "|" + ANSI_RESET);
                    System.out.println();
                    System.out.println(ANSI_BLACK_BOLD + "...................................................................................." + ANSI_RESET);
                    Methods.wait(0 / 5);
                    sum++;
                    j++;
                    Flag = 0;
                }
            }
            if (sum == 0){
                System.out.println(ANSI_BLACK_BOLD+"! No flights were found with this specification !"+ANSI_RESET);
            }
        }
        if (x.equals("3")){
            sum = 0;
            Flag = 1;
            j = 1;
            String year;
            String month;
            String day;
            System.out.print(ANSI_RED+"Please enter the Year : "+ANSI_RESET);
            year = scanner.next();
            System.out.print(ANSI_RED+"Please enter the Month : "+ANSI_RESET);
            month = scanner.next();
            System.out.print(ANSI_RED+"Please enter the Day : "+ANSI_RESET);
            day = scanner.next();
            Methods.wait(1);
            for (int i = 0; i < Flies.getI(); i++) {
                if ((year.equals(Flies.fly[i].getYear())) && (month.equals(Flies.fly[i].getMonth())) && (day.equals(Flies.fly[i].getDay()))) {
                    if (Flag == 1){
                        System.out.printf("%-20s",ANSI_GREEN + "|FlightId|"+ANSI_RESET);
                        System.out.printf("%-20s",ANSI_GREEN + "|Origin|"+ANSI_RESET);
                        System.out.printf("%-25s",ANSI_GREEN + "|Destination|"+ANSI_RESET);
                        System.out.printf("%-25s",ANSI_GREEN + "|Date|"+ANSI_RESET);
                        System.out.printf("%-20s",ANSI_GREEN + "|Time|"+ANSI_RESET);
                        System.out.printf("%-20s",ANSI_GREEN + "|Price|"+ANSI_RESET);
                        System.out.printf("%-15s",ANSI_GREEN + "|Seat|"+ANSI_RESET);
                        System.out.println();
                        System.out.println(ANSI_BLACK_BOLD + "...................................................................................." + ANSI_RESET);
                    }
                    System.out.printf("%-20s",Colors.colors[i] + (j) + "-" + "|" + Flies.fly[i].getFlightId() + "|" + ANSI_RESET);
                    System.out.printf("%-20s",Colors.colors[i] + "|" + Flies.fly[i].getOrigin() + "|" + ANSI_RESET);
                    System.out.printf("%-25s",Colors.colors[i] + "|" + Flies.fly[i].getDestination() + "|" + ANSI_RESET);
                    System.out.printf("%-25s",Colors.colors[i] + "|" + Flies.fly[i].getYear() + "/" + Flies.fly[i].getMonth() + "/" + Flies.fly[i].getDay() + "|" + ANSI_RESET );
                    System.out.printf("%-20s",Colors.colors[i] + "|" + Flies.fly[i].getTime() + "|" + ANSI_RESET);
                    System.out.printf("%-20s",Colors.colors[i] + "|" + Flies.fly[i].getPrice() + "|" + ANSI_RESET);
                    System.out.printf("%-20s",Colors.colors[i] + "|" + Flies.fly[i].getSeat() + "|" + ANSI_RESET);
                    System.out.println();
                    System.out.println(ANSI_BLACK_BOLD + "...................................................................................." + ANSI_RESET);
                    Methods.wait(0 / 5);
                    sum++;
                    j++;
                    Flag = 0;
                }
            }
            if (sum == 0){
                System.out.println(ANSI_BLACK_BOLD+"! No flights were found with this specification !"+ANSI_RESET);
            }
        }
        else{
//            System.out.println(ANSI_BLACK_BOLD+"! Please try again !"+ANSI_RESET);
            Methods.wait(0/8);
        }
        System.out.println();
        Methods.pressEnterToContinue();
    }
    //---------------Constructor---------------//

    public Tickets() {
    }
    //--------------Sets && Gets-------------//

    public static int getP() {
        return p;
    }

    public static void setP(int p) {
        Tickets.p = p;
    }
}
