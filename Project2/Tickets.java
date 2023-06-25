package Project2;

import java.util.Scanner;

public class Tickets extends Colors {

    //--------------Variable----------------//
    Methods methods = new Methods();
    Files files = new Files();
    //-----------------Methods--------------//

    public void Buy_tickets() {

        Scanner scanner = new Scanner(System.in);
        Tickets tickets = new Tickets();
        int x;
        try
        {
            while (true) {
                tickets.print_flight_list();
                System.out.print("desired number : ");
                x = scanner.nextInt();
                Methods.wait(1);
                Files.random_user.seek(((Users.getJ()+1)*38L)-8);
                long charge = Files.random_user.readLong();
                Files.random_Flight.seek(((x-1)*83L));
                String s = Files.random_Flight.readLine();
                String price = s.substring(68,78);
                String seat = s.substring(78,82);
                int a = Integer.parseInt(price.trim());
                int a1 = Integer.parseInt(seat.trim());
                if (charge > a) {
                     if (a1 > 0) {
                        charge -= a;
                        a1--;
                         Files.random_user.seek(((Users.getJ()+1)*38L)-8);
                        Files.random_user.writeLong(charge);
                        Files.random_user.seek((Users.getJ()*38L));
                        String name = Files.random_user.readLine().substring(0,15).trim();
                         for (int i = name.length(); i < 29; i++) {
                             name += " ";
                         }
                        Files.random_Flight.seek(((x-1)*83L)+78);
                        String s2 = String.valueOf(a1);
                        Files.random_Flight.writeBytes(files.setSeat(s2));
                        int ticketid = Methods.Random();
                        String ticketid1 = String.valueOf(ticketid);
                        System.out.println(ANSI_WHITE_BOLD + "Your ticket purchase was successful" + ANSI_RESET);
                        Methods.wait(0 / 5);
                        Files.random_Flight.seek(((x-1)*83L));
                        s = Files.random_Flight.readLine();
                        String FlightID = files.setFlightID(s.substring(0,15));
//                        System.out.println(FlightID);
                        String Origin = files.setOrigin(s.substring(15,35));
//                        System.out.println(Origin);
                        String Destination = files.setDestination(s.substring(35,55));
//                        System.out.println(Destination);
                        String Date = files.setDate(s.substring(55,63));
//                        System.out.println(Date);
                        String Time = files.setTime(s.substring(63,68));
//                        System.out.println(Time);
                        String Price1 = files.setPrice(s.substring(68,78));
//                        System.out.println(Price1);
                        ticketid1 += "\n";
                        Files.random_Ticket.seek((Files.getNumber() * 113L));
                        Files.random_Ticket.writeBytes(name);
                        Files.random_Ticket.writeBytes(FlightID);
                        Files.random_Ticket.writeBytes(Origin);
                        Files.random_Ticket.writeBytes(Destination);
                        Files.random_Ticket.writeBytes(Date);
                        Files.random_Ticket.writeBytes(Time);
                        Files.random_Ticket.writeBytes(Price1);
                        Files.random_Ticket.writeBytes(ticketid1);
                        Files.setNumber(Files.getNumber()+1);
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
            Files.random_Flight.writeBytes(files.setFlightID(flight.getFlightId()));
//            System.out.println(Files.random_Flight.getFilePointer());
            Files.random_Flight.writeBytes(files.setOrigin(flight.getOrigin()));
//            System.out.println(Files.random_Flight.getFilePointer());
            Files.random_Flight.writeBytes(files.setDestination(flight.getDestination()));
//            System.out.println(Files.random_Flight.getFilePointer());
            Files.random_Flight.writeBytes(files.setYear(flight.getYear()));
//            System.out.println(Files.random_Flight.getFilePointer());
            Files.random_Flight.writeBytes(files.setMonth(flight.getMonth()));
//            System.out.println(ANSI_GREEN+Files.random_Flight.getFilePointer()+ANSI_RESET);
            Files.random_Flight.writeBytes(files.setDay(flight.getDay()));
//            System.out.println(ANSI_BLUE+Files.random_Flight.getFilePointer()+ANSI_RESET);
            Files.random_Flight.writeBytes(files.setTime(flight.getTime()));
//            System.out.println(Files.random_Flight.getFilePointer());
            Files.random_Flight.writeBytes(files.setPrice(flight.getPrice()));
//            System.out.println(Files.random_Flight.getFilePointer());
            Files.random_Flight.writeBytes(files.setSeat(flight.getSeat()));
//            System.out.println(Files.random_Flight.getFilePointer());
            Flight flight1 = new Flight("WZ-15", "Mashhad", "Ahvaz", "1402", "10", "27", "13:50", "900000", "245");
            Files.random_Flight.writeBytes(files.setFlightID(flight1.getFlightId()));
            Files.random_Flight.writeBytes(files.setOrigin(flight1.getOrigin()));
            Files.random_Flight.writeBytes(files.setDestination(flight1.getDestination()));
            Files.random_Flight.writeBytes(files.setYear(flight.getYear()));
            Files.random_Flight.writeBytes(files.setMonth(flight.getMonth()));
            Files.random_Flight.writeBytes(files.setDay(flight.getDay()));
            Files.random_Flight.writeBytes(files.setTime(flight1.getTime()));
            Files.random_Flight.writeBytes(files.setPrice(flight1.getPrice()));
            Files.random_Flight.writeBytes(files.setSeat(flight1.getSeat()));
            Flight flight2 = new Flight("BG-22", "Tehran", "Tabriz", "1402", "11", "12", "8:00", "1100000", "12");
            Files.random_Flight.writeBytes(files.setFlightID(flight2.getFlightId()));
            Files.random_Flight.writeBytes(files.setOrigin(flight2.getOrigin()));
            Files.random_Flight.writeBytes(files.setDestination(flight2.getDestination()));
            Files.random_Flight.writeBytes(files.setYear(flight.getYear()));
            Files.random_Flight.writeBytes(files.setMonth(flight.getMonth()));
            Files.random_Flight.writeBytes(files.setDay(flight.getDay()));
            Files.random_Flight.writeBytes(files.setTime(flight2.getTime()));
            Files.random_Flight.writeBytes(files.setPrice(flight2.getPrice()));
            Files.random_Flight.writeBytes(files.setSeat(flight2.getSeat()));
            Flight flight3 = new Flight("WA-64", "Tehran", "Zahedan", "1402", "03", "30", "00:20", "1500000", "20");
//            Flies.setFlies(flight3);
            Files.random_Flight.writeBytes(files.setFlightID(flight3.getFlightId()));
            Files.random_Flight.writeBytes(files.setOrigin(flight3.getOrigin()));
            Files.random_Flight.writeBytes(files.setDestination(flight3.getDestination()));
            Files.random_Flight.writeBytes(files.setDate(flight3.getYear() + flight3.getMonth() + flight3.getDay()));
            Files.random_Flight.writeBytes(files.setTime(flight3.getTime()));
            Files.random_Flight.writeBytes(files.setPrice(flight3.getPrice()));
            Files.random_Flight.writeBytes(files.setSeat(flight3.getSeat()));
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
        int i = 0;
        try {
            System.out.printf("%-20s", ANSI_GREEN + "|FlightId|" + ANSI_RESET);
            System.out.printf("%-20s", ANSI_GREEN + "|Origin|" + ANSI_RESET);
            System.out.printf("%-25s", ANSI_GREEN + "|Destination|" + ANSI_RESET);
            System.out.printf("%-25s", ANSI_GREEN + "|Date|" + ANSI_RESET);
            System.out.printf("%-20s", ANSI_GREEN + "|Time|" + ANSI_RESET);
            System.out.printf("%-20s", ANSI_GREEN + "|Price|" + ANSI_RESET);
            System.out.printf("%-15s", ANSI_GREEN + "|Seat|" + ANSI_RESET);
            System.out.println();
            System.out.println(ANSI_BLACK_BOLD + "...................................................................................." + ANSI_RESET);
            Files.random_Flight.seek(0);
            for (int j = 0; j < Flies.getI(); j++) {
                String s = Files.random_Flight.readLine();
                System.out.printf("%-20s", Colors.colors[i] + (i + 1) + "-" + "|" + s.substring(0,15).trim() + "|" + ANSI_RESET);
                System.out.printf("%-20s", Colors.colors[i] + "|" + s.substring(15,35).trim()+ "|" + ANSI_RESET);
                System.out.printf("%-25s", Colors.colors[i] + "|" + s.substring(35,55).trim() + "|" + ANSI_RESET);
                System.out.printf("%-25s", Colors.colors[i] + "|" + s.substring(55,59).trim() + "/" + s.substring(59,61).trim() + "/" + s.substring(61,63).trim() + "|" + ANSI_RESET);
                System.out.printf("%-20s", Colors.colors[i] + "|" + s.substring(63,68).trim() + "|" + ANSI_RESET);
                System.out.printf("%-20s", Colors.colors[i] + "|" + s.substring(68,78).trim() + "|" + ANSI_RESET);
                System.out.printf("%-20s", Colors.colors[i] + "|" + s.substring(78,81).trim() + "|" + ANSI_RESET);
                System.out.println();
                System.out.println(ANSI_BLACK_BOLD + "...................................................................................." + ANSI_RESET);
                Methods.wait(0 / 5);
                i++;
            }
            System.out.println();
            Methods.pressEnterToContinue();
        }catch (Exception a){
            System.err.println(a.getMessage());
            return;
        }
    }
    public int Booked_thickets() {
        try {
            Files.random_user.seek(Users.getJ() * 38L);
            String s1 = Files.random_user.readLine();
            int x1  = files.ReadFlight_User1(s1);
            if (x1 == 0){
                System.out.println(ANSI_RED + "* You do not have a purchased ticket *" + ANSI_RESET);
                Methods.wait(1);
                Methods.pressEnterToContinue();
                return 1;
            }
            Methods.pressEnterToContinue();
        }catch (Exception a){
            return 2;
        }
        return 2;
    }
    public void Search(){
        Scanner scanner = new Scanner(System.in);
        int sum = 0;
        int Flag = 1;
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
            int i = 0;
            System.out.println(ANSI_PURPLE+"Please search for the desired city :"+ANSI_RESET);
            String str = scanner.next();
            str = str.toUpperCase();
            Methods.wait(1);
            try {
                Files.random_Flight.seek(0);
                while (Files.random_Flight.getFilePointer() < Files.random_Flight.length()) {
                    String s = Files.random_Flight.readLine();
                    String s1 = s.substring(15,35).trim();
                    String s2 = s.substring(35,55).trim();
                    if (str.equals(s1.toUpperCase()) || str.equals(s2.toUpperCase())) {
                        if (Flag == 1) {
                            System.out.printf("%-20s", ANSI_GREEN + "|FlightId|" + ANSI_RESET);
                            System.out.printf("%-20s", ANSI_GREEN + "|Origin|" + ANSI_RESET);
                            System.out.printf("%-25s", ANSI_GREEN + "|Destination|" + ANSI_RESET);
                            System.out.printf("%-25s", ANSI_GREEN + "|Date|" + ANSI_RESET);
                            System.out.printf("%-20s", ANSI_GREEN + "|Time|" + ANSI_RESET);
                            System.out.printf("%-20s", ANSI_GREEN + "|Price|" + ANSI_RESET);
                            System.out.printf("%-15s", ANSI_GREEN + "|Seat|" + ANSI_RESET);
                            System.out.println();
                            System.out.println(ANSI_BLACK_BOLD + "...................................................................................." + ANSI_RESET);
                        }
                        System.out.printf("%-20s", Colors.colors[i] + (i + 1) + "-" + "|" + s.substring(0,15).trim() + "|" + ANSI_RESET);
                        System.out.printf("%-20s", Colors.colors[i] + "|" + s.substring(15,35).trim()+ "|" + ANSI_RESET);
                        System.out.printf("%-25s", Colors.colors[i] + "|" + s.substring(35,55).trim() + "|" + ANSI_RESET);
                        System.out.printf("%-25s", Colors.colors[i] + "|" + s.substring(55,59).trim() + "/" + s.substring(59,61).trim() + "/" + s.substring(61,63).trim() + "|" + ANSI_RESET);
                        System.out.printf("%-20s", Colors.colors[i] + "|" + s.substring(63,68).trim() + "|" + ANSI_RESET);
                        System.out.printf("%-20s", Colors.colors[i] + "|" + s.substring(68,78).trim() + "|" + ANSI_RESET);
                        System.out.printf("%-20s", Colors.colors[i] + "|" + s.substring(78,81).trim() + "|" + ANSI_RESET);
                        System.out.println();
                        System.out.println(ANSI_BLACK_BOLD + "...................................................................................." + ANSI_RESET);
                        Methods.wait(0 / 5);
                        sum++;
                        i++;
                        Flag = 0;
                    }
                }
            }catch (Exception a){

            }
            if (sum == 0){
                System.out.println(ANSI_BLACK_BOLD+"! No flights were found with this specification !"+ANSI_RESET);
            }
        }
        if (x.equals("2")){
            int i = 0;
            sum = 0;
            Flag = 1;
            System.out.println(ANSI_BLUE+"Please enter the Minimum amount"+ANSI_RESET);
            long minimum = scanner.nextLong();
            System.out.println(ANSI_BLUE+"Please enter the Maximum value"+ANSI_RESET);
            long maximum = scanner.nextLong();
            Methods.wait(1);
            try {
                Files.random_Flight.seek(0);
                while (Files.random_Flight.getFilePointer() < Files.random_Flight.length()) {
                    String s = Files.random_Flight.readLine();
                    int Price = Integer.parseInt(s.substring(68,78).trim());
                    if (minimum <= Price && Price <= maximum) {
                        if (Flag == 1) {
                            System.out.printf("%-20s", ANSI_GREEN + "|FlightId|" + ANSI_RESET);
                            System.out.printf("%-20s", ANSI_GREEN + "|Origin|" + ANSI_RESET);
                            System.out.printf("%-25s", ANSI_GREEN + "|Destination|" + ANSI_RESET);
                            System.out.printf("%-25s", ANSI_GREEN + "|Date|" + ANSI_RESET);
                            System.out.printf("%-20s", ANSI_GREEN + "|Time|" + ANSI_RESET);
                            System.out.printf("%-20s", ANSI_GREEN + "|Price|" + ANSI_RESET);
                            System.out.printf("%-15s", ANSI_GREEN + "|Seat|" + ANSI_RESET);
                            System.out.println();
                            System.out.println(ANSI_BLACK_BOLD + "...................................................................................." + ANSI_RESET);
                        }
                        System.out.printf("%-20s", Colors.colors[i] + (i + 1) + "-" + "|" + s.substring(0,15).trim() + "|" + ANSI_RESET);
                        System.out.printf("%-20s", Colors.colors[i] + "|" + s.substring(15,35).trim()+ "|" + ANSI_RESET);
                        System.out.printf("%-25s", Colors.colors[i] + "|" + s.substring(35,55).trim() + "|" + ANSI_RESET);
                        System.out.printf("%-25s", Colors.colors[i] + "|" + s.substring(55,59).trim() + "/" + s.substring(59,61).trim() + "/" + s.substring(61,63).trim() + "|" + ANSI_RESET);
                        System.out.printf("%-20s", Colors.colors[i] + "|" + s.substring(63,68).trim() + "|" + ANSI_RESET);
                        System.out.printf("%-20s", Colors.colors[i] + "|" + s.substring(68,78).trim() + "|" + ANSI_RESET);
                        System.out.printf("%-20s", Colors.colors[i] + "|" + s.substring(78,81).trim() + "|" + ANSI_RESET);
                        System.out.println();
                        System.out.println(ANSI_BLACK_BOLD + "...................................................................................." + ANSI_RESET);
                        Methods.wait(0 / 5);
                        sum++;
                        i++;
                        Flag = 0;
                    }
                }
            }catch (Exception a){
//                System.out.println(a.getMessage());
            }
            if (sum == 0){
                System.out.println(ANSI_BLACK_BOLD+"! No flights were found with this specification !"+ANSI_RESET);
            }
        }
        if (x.equals("3")) {
            int i = 0;
            sum = 0;
            Flag = 1;
            String year;
            String month;
            String day;
            System.out.print(ANSI_RED + "Please enter the Year : " + ANSI_RESET);
            year = scanner.next();
            System.out.print(ANSI_RED + "Please enter the Month : " + ANSI_RESET);
            month = scanner.next();
            System.out.print(ANSI_RED + "Please enter the Day : " + ANSI_RESET);
            day = scanner.next();
            Methods.wait(1);
            try {
                Files.random_Flight.seek(0);
                while (Files.random_Flight.getFilePointer() < Files.random_Flight.length()) {
                    String s = Files.random_Flight.readLine();
                    if ((year.equals(s.substring(55,59).trim())) && (month.equals(s.substring(59,61).trim())) && (day.equals(s.substring(61,63).trim()))) {
                        if (Flag == 1) {
                            System.out.printf("%-20s", ANSI_GREEN + "|FlightId|" + ANSI_RESET);
                            System.out.printf("%-20s", ANSI_GREEN + "|Origin|" + ANSI_RESET);
                            System.out.printf("%-25s", ANSI_GREEN + "|Destination|" + ANSI_RESET);
                            System.out.printf("%-25s", ANSI_GREEN + "|Date|" + ANSI_RESET);
                            System.out.printf("%-20s", ANSI_GREEN + "|Time|" + ANSI_RESET);
                            System.out.printf("%-20s", ANSI_GREEN + "|Price|" + ANSI_RESET);
                            System.out.printf("%-15s", ANSI_GREEN + "|Seat|" + ANSI_RESET);
                            System.out.println();
                            System.out.println(ANSI_BLACK_BOLD + "...................................................................................." + ANSI_RESET);
                        }
                        System.out.printf("%-20s", Colors.colors[i] + (i + 1) + "-" + "|" + s.substring(0,15).trim() + "|" + ANSI_RESET);
                        System.out.printf("%-20s", Colors.colors[i] + "|" + s.substring(15,35).trim()+ "|" + ANSI_RESET);
                        System.out.printf("%-25s", Colors.colors[i] + "|" + s.substring(35,55).trim() + "|" + ANSI_RESET);
                        System.out.printf("%-25s", Colors.colors[i] + "|" + s.substring(55,59).trim() + "/" + s.substring(59,61).trim() + "/" + s.substring(61,63).trim() + "|" + ANSI_RESET);
                        System.out.printf("%-20s", Colors.colors[i] + "|" + s.substring(63,68).trim() + "|" + ANSI_RESET);
                        System.out.printf("%-20s", Colors.colors[i] + "|" + s.substring(68,78).trim() + "|" + ANSI_RESET);
                        System.out.printf("%-20s", Colors.colors[i] + "|" + s.substring(78,81).trim() + "|" + ANSI_RESET);
                        System.out.println();
                        System.out.println(ANSI_BLACK_BOLD + "...................................................................................." + ANSI_RESET);
                        Methods.wait(0 / 5);
                        sum++;
                        i++;
                        Flag = 0;
                    }
                }
                if (sum == 0) {
                    System.out.println(ANSI_BLACK_BOLD + "! No flights were found with this specification !" + ANSI_RESET);
                }
            }catch (Exception a){
            }
        }
        System.out.println();
        Methods.pressEnterToContinue();
    }
    //---------------Constructor---------------//

    public Tickets() {
    }
}
