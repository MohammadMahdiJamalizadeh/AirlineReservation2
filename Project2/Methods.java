package Project2;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;
public class Methods  extends Colors {
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
    public int Continue(){
        int x;
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
                Files.random_user.seek((Users.getNum_User()*38L));
                files.Fix_UserName(username);
                files.Fix_Password(password);
                Users.setNum_User(Users.getNum_User()+1);
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

    public int check(String username2, String password2) {
        Files files = new Files();
        String username, password,userpass1,userpass2;
        username = username2;
        password = password2;
        userpass1 = username2+password2;
        try {
            for (int i = 0; i < Users.getNum_User(); i++) {
                Files.random_user.seek((i * 38L));
                userpass2 = files.ReadUser();
                if (userpass1.trim().equals(userpass2.trim())) {
                    System.out.println(ANSI_CYAN + "                WELCOME " + ANSI_RESET);
                    Users.setJ(i);
                    return 1;
                }
            }
        }catch (Exception a){
            System.out.println(ANSI_BLACK_BOLD + "-----------------------------------------------" + ANSI_RESET);
            System.out.println(ANSI_BLACK_BOLD + "          The desired user was not found!" + ANSI_RESET);
            System.out.println(ANSI_BLACK_BOLD + "-----------------------------------------------" + ANSI_RESET);
            wait(1);
            return 5;
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
    public static void wait(int sec) {
        try {
            Thread.currentThread().sleep(sec * 1000l);
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
        System.out.println(ANSI_BLACK_BOLD + "***************************************" + ANSI_RESET);
        System.out.print("Number : ");
    }
    public static void Date() {
        Date dNow = new Date();
        SimpleDateFormat ft = new SimpleDateFormat("E yyyy.MM.dd 'at' hh:mm:ss");
        System.out.println(ANSI_CYAN_BOLD+"Current Date:" + ft.format(dNow)+ANSI_RESET);
    }
    public static void pressEnterToContinue() {
        wait(0/8);
        System.out.println("Press Enter key to continue...");    try    {
        System.in.read();
        }
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
    public void changePassword() {
        try {
            Scanner scanner = new Scanner(System.in);
            String password;
            System.out.println(ANSI_BLACK_BOLD + "-----------------------------------------------" + ANSI_RESET);
            System.out.println(ANSI_BLACK_BOLD + "-----------------------------------------------" + ANSI_RESET);
            System.out.println(ANSI_YELLOW + "               Change Password" + ANSI_RESET);
            System.out.println(ANSI_BLACK_BOLD + "-----------------------------------------------" + ANSI_RESET);
            System.out.println(ANSI_BLACK_BOLD + "-----------------------------------------------" + ANSI_RESET);
            Methods.wait(1);
            System.out.print(ANSI_CYAN_BOLD + "NEW PASSWORD : " + ANSI_RESET);
            password = scanner.next();
            password = files.Fix_Password(password);
            Files.random_user.seek(((Users.getJ()+1)*38L)-23);
            Files.random_user.writeBytes(password);
            Methods.wait(0 / 5);
            System.out.println(ANSI_GREEN + "The password was changed" + ANSI_RESET);
            Methods.pressEnterToContinue();
        }catch (Exception a){
            System.err.println(a.getMessage());
            return;
        }
    }
    public void Add_charge() throws IOException {
//        Methods.cls();
        long charge;
        long c;
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                Files.random_user.seek(((Users.getJ()+1)*38L)-8);
                try {
                    c = Files.random_user.readLong();
                }catch (Exception a){
                    c = 0;
                }
                Files.random_user.seek(((Users.getJ()+1)*38L)-8);
                System.out.print(ANSI_BLACK_BOLD + "Your current account balance : " + ANSI_RESET);
                System.out.printf("%,d%n", c);
                Methods.pressEnterToContinue();
                System.out.print("Please enter the desired amount(Toman) : ");
                charge = scanner.nextLong();
                charge += c;
                Files.random_user.writeLong(charge);
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
    public void Ticket_cancellation() {
        Tickets tickets = new Tickets();
        int flag = 0;
        String s;
        int e;
        long byt;
        int x = tickets.Booked_thickets();
        if (x == 1){
            return;
        }
        try
        {
            System.out.print(ANSI_CYAN + "Please enter the desired TicketId : " + ANSI_RESET);
            int number = scanner.nextInt();
            Files.random_Ticket.seek(0);
            while (Files.random_Ticket.getFilePointer() < Files.random_Ticket.length()) {
                String st = Files.random_Ticket.readLine();
                String s1 = st;
                String s2 = st;
                byt = Files.random_Ticket.getFilePointer();
                st = st.substring(107, 112);
                e = Integer.parseInt(st.trim());
                if (e == number) {
                    Files.random_user.seek(((Users.getJ() + 1) * 38L) - 8);
                    long n = Files.random_user.readLong();
                    Files.random_user.seek(((Users.getJ() + 1) * 38L) - 8);
                    int x1 = Integer.parseInt(s1.substring(97, 107).trim());
                    Files.random_user.writeLong(x1 + n);
                    Files.random_Ticket.seek(byt - 113);
                    Files.random_Flight.seek(0);
//                    while (Files.random_Flight.getFilePointer() < Files.random_Flight.length()){
//                        String v = Files.random_Flight.readLine();
//                        String v1 = v;
//                        v1 = v1.substring(78,81);
//                        v = v.substring(0,15).trim();
//                        if (v.equals(s2.substring(29,44).trim())){
//                            int m = Integer.parseInt(v1);
//                            m++;
//                            v1 = String.valueOf(m);
//                            Files.random_Flight.seek(Files.random_Flight.getFilePointer() - 3);
////                            Files.random_Flight.writeBytes(files.setSeat(v1));
////                            System.out.println(Files.random_Flight.getFilePointer());
//                            break;
//                        }
//                    }
                    for (int i = 0; i < 113; i++) {
                        Files.random_Ticket.writeBytes(" ");
                    }
                    flag = 1;
                    Files.setNumber(Files.getNumber() - 1);
                    break;
                }
            }
                    while (Files.random_Ticket.getFilePointer() < Files.random_Ticket.length()) {
                        try {
                            s = Files.random_Ticket.readLine();
                            if (s.equals("")) {
                                break;
                            }
                            byt = Files.random_Ticket.getFilePointer();
                            Files.random_Ticket.seek(byt - 226);
                            Files.random_Ticket.writeBytes(s+"\n");
                            byt = Files.random_Ticket.getFilePointer();
                            Files.random_Ticket.seek(byt + 113);
                        } catch (Exception q) {
                            break;
                        }
                    }
                    try {
                        Files.random_Ticket.seek(Files.random_Ticket.getFilePointer() - 113);
                        for (int i = 0; i < 113; i++) {
                            Files.random_Ticket.writeBytes(" ");
                        }
                    }catch (Exception r){
                        return;
                    }
            if (flag == 0){
                wait(1);
                System.out.println(ANSI_BLUE + "!The desired ID was not found!" + ANSI_RESET);
                Methods.pressEnterToContinue();
            }
            else {
                    wait(0 / 8);
                    System.out.println(ANSI_BLACK_BOLD + "Your ticket has been cancelled" + ANSI_RESET);
                    Methods.pressEnterToContinue();
            }

        }catch (Exception a){
            System.out.println(a.getMessage());
            Methods.wait(0/8);
            return;
        }
    }
}


