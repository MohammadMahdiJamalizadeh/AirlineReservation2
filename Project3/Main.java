package Project3;

import java.util.Scanner;
public class Main extends Colors{
    public static void main(String[] args) throws Exception{
        //------------------input-----------------//
        Scanner scanner = new Scanner(System.in);
        Methods methods = new Methods();
        Tickets tickets = new Tickets();
        Files files = new Files();
        Users users = new Users();
        Admin admin = new Admin();
        //--------------Variable----------------//
        int num;
        int x = 0;
        //--------------------------------------//
        files.Random();
        try {
            Files.random_Flight.seek(0);
            if (Files.random_Flight.readLine().equals(" ")){

            }
        }catch (Exception a){
            tickets.save_fly();
        }
        files.ReadUser();
        files.ReadCharge();
        files.ReadFlight_User();
        files.ReadFlight_Admin();
        while (true) {
                while (true) {
                    try {
                        methods.print_menu_Sign_in_Sign_up();
                        System.out.print(FOREGROUND_WHITE+"Number : ");
                        num = scanner.nextInt();
                        Methods.wait(1);
                        if (num == 0){
                            return;
                        }
//                        methods.cls();
                            else if (num == 1) {
                            x = methods.get_input_username_password_Sign_in();
                            break;
                        }
                            else if (num == 2) {
                            methods.Description_Sign_up();
                            methods.get_input_username_password_Sign_up();
                        }
                    }catch (Exception a){
                        System.out.println(ANSI_BLACK_BOLD+"! Please try again !"+ANSI_RESET);
                        scanner = new Scanner(System.in);
                    }
                }
                //*******************************Passenger*****************************//
                if (x == 1)
                    while (true) {
                        try {
//                        Methods.cls();
                            methods.Passenger_menu_option();// Passenger menu
                            Methods.wait(1);
                            int n = scanner.nextInt();
                            if (n == 0) {
                                Methods.wait(1);
                                break;
                            }
                            switch (n) {
                                case 1:
                                    methods.changePassword(users.users[users.getJ()]);
                                    break;
                                case 2:
                                    tickets.Search();
                                    break;
                                case 3:
                                    tickets.Buy_tickets(users.users[users.getJ()]);
                                    break;
                                case 4:
                                    methods.Ticket_cancellation(users.users[users.getJ()]);
                                    break;
                                case 5:
                                    tickets.Booked_thickets(users.users[users.getJ()]);
                                    break;
                                case 6:
                                    methods.Add_charge(users.users[users.getJ()]);
                                    break;
                                case 7:
//                                    methods.print_info(users.users[users.getJ()]);
                                    break;
                                default:
                                    System.out.println("pleas try again");
                            }
                        }catch (Exception a){
                            System.err.println("Error");
                            break;
                        }
                    }
                //**********************************************************//
                //**************************ADMIN***************************//
                 else if (x == 2) {
                    while (true) {
//                        Methods.cls();
                        methods.print_Admin_menu_option();
                        int n = scanner.nextInt();
                        if (n == 0){
                            Methods.wait(1);
                            break;
                        }
                        switch (n){
                            case 1 :
                                admin.Add_fly();
                                break;
                            case 2 :
                                admin.Update_fly();
                                break;
                            case 3 :
                                admin.Remove_Ticket();
                                break;
                            case 4 :
                                tickets.print_flight_list();
                                break;
                            default:
                                System.out.println("pleas try again");
                        }
                    }
                }
            }
        }
}



