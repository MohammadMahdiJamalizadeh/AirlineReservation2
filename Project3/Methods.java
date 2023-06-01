package Project3;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;
public class Methods  extends Colors {
    //-------------------------------------//
//    private static int i;
    //--------------------------input--------------------//
    Scanner scanner = new Scanner(System.in);
    Users users = new Users();
    Files files = new Files();
    //----------------------METHODS-----------------------//
    public void print_menu_Sign_in_Sign_up()  {
        System.out.println(FOREGROUND_BRIGHT_MAGENTA + "*******************" + ANSI_RED);
        System.out.print(FOREGROUND_BRIGHT_MAGENTA + "*" + '\t' + ANSI_RED + "1- Sign in" + ANSI_RESET + FOREGROUND_BRIGHT_MAGENTA + "    *" + '\n');
        System.out.print(FOREGROUND_BRIGHT_MAGENTA + "*" + '\t' + ANSI_BLUE + "2- Sign up" + ANSI_RESET + FOREGROUND_BRIGHT_MAGENTA + "    *" + '\n');
        System.out.print(FOREGROUND_BRIGHT_MAGENTA + "*" + '\t' + ANSI_BLACK_BOLD + "0- Exit" + ANSI_RESET + FOREGROUND_BRIGHT_MAGENTA + "       *" + '\n');
        System.out.println(FOREGROUND_BRIGHT_MAGENTA + "*******************" + ANSI_RESET);
    }

//    public static void cls() {
//        try {
//            if (System.getProperty("os.name").contains("Windows")) {
//                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
//            } else {
//                System.out.print("\033\143");
//            }
//        } catch (IOException | InterruptedException ex) {
//        }
//    }
    public int Continue(){
        int x = 0;
        while (true) {
            try {
                System.out.println(ANSI_RED + "Do you want to continue ?" + ANSI_RESET);
                System.out.println(ANSI_CYAN + "1-YES            2-NO" + ANSI_RESET);
                x = scanner.nextInt();
                if (x == 2) {
                    return 2;
                }
                else if (x == 1)
                    return 1;
            }catch (Exception a){
                System.out.println(ANSI_GREEN + "Please try again:" + ANSI_RESET);
                scanner = new Scanner(System.in);
            }
        }
    }
    public void get_input_username_password_Sign_up() throws Exception{
        String username, password,userpass;
        int x;
        Scanner scanner = new Scanner(System.in);

            while (true) {
                try {
                System.out.println(ANSI_WHITE_BOLD + "Please enter your username and password :" + ANSI_RESET);
                System.out.print(ANSI_WHITE_BOLD + "USERNAME : " + ANSI_RESET);
                username = scanner.next();
                System.out.print(ANSI_WHITE_BOLD + "PASSWORD : " + ANSI_RESET);
                password = scanner.next();
                userpass = files.File_User(username,password);
                Small_User small_user = new Small_User(userpass);
                users.setUsers(small_user);

//            cls();
                System.out.println(ANSI_BLACK_BOLD + "-----------------------------------------------" + ANSI_RESET);
                System.out.println(ANSI_BLACK_BOLD + "          Account successfully created :)" + ANSI_RESET);
                System.out.println(ANSI_BLACK_BOLD + "-----------------------------------------------" + ANSI_RESET);
                Methods.wait(1);
                int w = Continue();
                if (w == 2){
                    break;
                }
            }catch (Exception a){
                    System.err.println("Error");
                    Methods.wait(0/8);
                    return;
                }
            }
        }
    public void Description_Sign_up() {
        System.out.println("--------------------------------------------------------------------------");
        System.out.println(ANSI_YELLOW + "Dear user, please note that your username must contain English letters and" + ANSI_RESET + '\n' +
                "            " + ANSI_YELLOW + "your password must contain at least 6 numbers" + ANSI_RESET);
        System.out.println("--------------------------------------------------------------------------");
    }
    public static int Random(){
        Random random = new Random();
        int a = random.nextInt(10000)+50000;
        return a;
    }

    public int get_input_username_password_Sign_in() throws Exception{
        String username, password;
//        cls();
        System.out.println(ANSI_WHITE_BOLD + "Please enter your username and password :" + ANSI_RESET);
        System.out.print(ANSI_BLACK_BOLD + "USERNAME : " + ANSI_RESET);
        username = scanner.next();
        System.out.print(ANSI_BLACK_BOLD + "PASSWORD : " + ANSI_RESET);
        password = scanner.next();
        int x = check(username, password);
        return x;
    }

    public int check(String username2, String password2) throws Exception{
//        cls();
        String username, password,userpass;
        username = username2;
        password = password2;
        userpass = username2+password2;
        while (true) {
            for (int i = 0; i < users.getQ(); i++) {
                if (userpass.trim().equals(users.users[i].getUsrepass().trim())){
//                    cls();
                    Files.random_user.seek((i+1)*30+(i*500));
                    System.out.println(Files.random_user.getFilePointer());
                    System.out.println(ANSI_CYAN + "                WELCOME " + ANSI_RESET);
                    users.setJ(i);
                    return 1;
                }
            }
            if ((password.equals("Admin")) && (username.equals("Admin"))) {
                System.out.println(ANSI_CYAN + "             WELCOME Admin" + ANSI_RESET);
                wait(1);
                return 2;
            } else {
                System.out.println(ANSI_BLACK_BOLD + "-----------------------------------------------" + ANSI_RESET);
                System.out.println(ANSI_BLACK_BOLD + "          The desired user was not found!" + ANSI_RESET);
                System.out.println(ANSI_BLACK_BOLD + "-----------------------------------------------" + ANSI_RESET);
                wait(1);
            }

            return 3;
        }
    }
    public static void wait(int sec) {
        try {
            Thread.currentThread().sleep(sec * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void Passenger_menu_option(){
        System.out.println(ANSI_BLACK_BOLD + "***************************************" + ANSI_RESET);
        System.out.println(ANSI_BLACK_BOLD+"*****"+ANSI_WHITE_BOLD+"    PASSENGER MENU OPTION"+ANSI_BLACK_BOLD+'\t'+" ******"+ANSI_RESET);
        System.out.println(ANSI_BLACK_BOLD + "***************************************" + ANSI_RESET);
        Date();
        System.out.println(ANSI_PURPLE+"1- Change password"+ANSI_RESET);
        System.out.println(ANSI_PURPLE+"2- Search flight tickets"+ANSI_RESET+ANSI_RESET);
        System.out.println(ANSI_PURPLE+"3- Booking ticket"+ANSI_RESET+ANSI_RESET);
        System.out.println(ANSI_PURPLE+"4- Ticket cancellation"+ANSI_RESET+ANSI_RESET);
        System.out.println(ANSI_PURPLE+"5- Booked tickets"+ANSI_RESET+ANSI_RESET);
        System.out.println(ANSI_PURPLE+"6- Add charge"+ANSI_RESET+ANSI_RESET);
        System.out.println(ANSI_PURPLE+"0- sign out"+ANSI_RESET+ANSI_RESET);
//        System.out.println(ANSI_PURPLE+"7- Info"+ANSI_RESET+ANSI_RESET);
        System.out.println(ANSI_BLACK_BOLD + "***************************************" + ANSI_RESET);

        System.out.print("Number : ");
    }
    public static void Date() {
        Date dNow = new Date();
        SimpleDateFormat ft = new SimpleDateFormat("E yyyy.MM.dd 'at' hh:mm:ss");
        System.out.println(ANSI_CYAN_BOLD+"Current Date:" + ft.format(dNow)+ANSI_RESET);
    }
    public static void pressEnterToContinue()
    {
        wait(0/8);
        System.out.println("Press Enter key to continue...");    try    {
        System.in.read();    }
    catch(Exception e){
    }
    }
    public void print_Admin_menu_option(){
        System.out.println(ANSI_BLACK_BOLD + "***************************************" + ANSI_RESET);
        System.out.println(ANSI_BLACK_BOLD+"*****"+ANSI_WHITE_BOLD+"      ADMIN MENU OPTION"+ANSI_BLACK_BOLD+'\t'+" ******"+ANSI_RESET);
        System.out.println(ANSI_BLACK_BOLD + "***************************************" + ANSI_RESET);
        Date();
        System.out.println(ANSI_BLUE+"1- Add"+ANSI_RESET);
        System.out.println(ANSI_BLUE+"2- Update"+ANSI_RESET);
        System.out.println(ANSI_BLUE+"3- Remove"+ANSI_RESET);
        System.out.println(ANSI_BLUE+"4- Flight schedules"+ANSI_RESET);
        System.out.println(ANSI_BLUE+"0- sign out"+ANSI_RESET);
        System.out.println(ANSI_BLACK_BOLD + "***************************************" + ANSI_RESET);

        System.out.print("Number : ");
    }
    public void changePassword(Small_User user1) {
        try {
            long byt = (Users.getJ()*30) + (Users.getJ()*500);
            Files.random_user.seek(byt);
            Scanner scanner = new Scanner(System.in);
            String password, username, userpass;
//        Methods.cls();
            System.out.println(ANSI_BLACK_BOLD + "-----------------------------------------------" + ANSI_RESET);
            System.out.println(ANSI_BLACK_BOLD + "-----------------------------------------------" + ANSI_RESET);
            System.out.println(ANSI_YELLOW + "               Change Password" + ANSI_RESET);
            System.out.println(ANSI_BLACK_BOLD + "-----------------------------------------------" + ANSI_RESET);
            System.out.println(ANSI_BLACK_BOLD + "-----------------------------------------------" + ANSI_RESET);
            Methods.wait(1);
            System.out.print(ANSI_CYAN_BOLD + "NEW USERNAME : " + ANSI_RESET);
            username = scanner.next();
//            user1.setUserName(username);
            System.out.print(ANSI_CYAN_BOLD + "NEW PASSWORD : " + ANSI_RESET);
            password = scanner.next();
            userpass = username + password;
            for (int i = userpass.length(); i < 29; i++) {
                userpass += " ";
            }
            userpass += "\n";
            System.out.println(Files.random_user.getFilePointer());
            Files.random_user.writeBytes(userpass);
            System.out.println(Files.random_user.getFilePointer());
            user1.setUsrepass(userpass.trim());
//            user1.setUserPassword(password);
            Methods.wait(0 / 5);
            System.out.println(ANSI_GREEN + "The password was changed" + ANSI_RESET);
            Methods.pressEnterToContinue();
        }catch (Exception a){
            System.err.println(a.getMessage());
            return;
        }
    }
    public void Add_charge(Small_User user1) throws IOException {
//        Methods.cls();
        long charge;
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                Files.random_user.seek((Users.getJ()+1)*30+(Users.getJ()*500));
                System.out.print(ANSI_BLACK_BOLD + "Your current account balance : " + ANSI_RESET);
                System.out.printf("%,d%n", user1.getCharge());
                Methods.pressEnterToContinue();
                System.out.print("Please enter the desired amount(Toman) : ");
                charge = scanner.nextLong();
                Users.users[Users.getJ()].setCharge(charge + Users.users[Users.getJ()].getCharge());
                Files.random_user.writeLong(Users.users[Users.getJ()].getCharge());
//                Methods.cls();
                Methods.wait(1);
                System.out.println(ANSI_GREEN + "Charging was done successfully" + ANSI_RESET);
                int w = Continue();
                if (w == 2)
                    break;
            }catch (Exception a){
                System.out.println(ANSI_BLACK_BOLD+"! Please try again !"+ANSI_RESET);
                Methods.wait(0/8);
                return;
            }
        }
    }
//    public void print_info(Small_User users){
////        Methods.cls();
//        System.out.println(ANSI_CYAN+"YOUR USERNAME : "+ANSI_RESET+ANSI_CYAN+users.getUserName()+ANSI_RESET);
//        System.out.println(ANSI_CYAN+"YOUR PASSWORD : "+ANSI_RESET+ANSI_CYAN+users.getUserPassword()+ANSI_RESET);
//        System.out.print(ANSI_BLACK_BOLD+"Your current account balance : "+ANSI_RESET);
//        System.out.printf("%,d%n",users.getCharge());
//        Methods.pressEnterToContinue();
//    }
    public void Ticket_cancellation(Small_User user) {
//        Methods.cls();
        Tickets tickets = new Tickets();
        tickets.Booked_thickets(user);
        if (user.ticket.getI() == 0) {
            return;
        }
        try
        {
        if (user.ticket.getI() > 0){
           long num = ((Users.getJ()+1) * 30+8 + (Users.getJ() * 500));
            Files.random_user.seek(num);
        }
            System.out.print(ANSI_CYAN + "Please enter the desired TicketId : " + ANSI_RESET);
            int str = scanner.nextInt();
            for (int j = 0; j < user.ticket.getI(); j++) {
                if (str == user.ticket.ticket[j].getTicketId()) {
                    user.setCharge(user.getCharge() + user.ticket.ticket[j].getPrice());
                    for (int w = 0; w < Flies.getI(); w++) {
                        if (user.ticket.ticket[j].getFlightId().equals(Flies.fly[w].getFlightId())){
                            Flies.fly[w].setSeat(Flies.fly[w].getSeat() + 1);
                        }
                    }
                    for (int k = j; k < user.ticket.getI(); k++) {
                        user.ticket.ticket[k] = user.ticket.ticket[k + 1];
                    }
                    wait(0/8);
                    System.out.println(ANSI_BLACK_BOLD + "Your ticket has been cancelled" + ANSI_RESET);
                    user.ticket.setI(user.ticket.getI() - 1);
                    Methods.pressEnterToContinue();
                    files.SetTicket(Users.getJ());
                    for (long i = Files.random_user.getFilePointer(); i < (((Users.getJ()+1) * 30L)+((Users.getJ()+1) * 500L)); i++) {
                        Files.random_user.seek(i);
                        Files.random_user.writeBytes(" ");
                    }
                    return;
                }
//                System.out.println(user.ticket.ticket[user.ticket.getI()]);
            }
            wait(1);
            System.out.println(ANSI_BLUE + "!The desired ID was not found!" + ANSI_RESET);
            Methods.pressEnterToContinue();
        }catch (Exception a){
            System.out.println(ANSI_BLACK_BOLD+"! Please try again !"+ANSI_RESET);
            Methods.wait(0/8);
            return;
        }
    }
}


