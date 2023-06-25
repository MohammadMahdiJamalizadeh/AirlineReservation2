package Project2;

import java.util.Scanner;
public class Main extends Colors{
    public static void main(String[] args) throws Exception{

        //------------------input-----------------//
        Scanner scanner = new Scanner(System.in);
        Methods methods = new Methods();
        Tickets tickets = new Tickets();
        Files files = new Files();
        Admin admin = new Admin();
        //--------------Variable----------------//
        int num;
        int x;
        //--------------------------------------//
        files.Random();
        files.ReadUser1();
        try {
            Files.random_Flight.seek(0);
            if (Files.random_Flight.readLine().equals(" ")){

            }
        }catch (Exception a){
            tickets.save_fly();
        }
//        files.ReadUser();
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
                    System.out.println(a.getMessage());
                    System.out.println(ANSI_BLACK_BOLD+"! Please try again !"+ANSI_RESET);
                    scanner = new Scanner(System.in);
                }
            }
            //*******************************Passenger*****************************//
            if (x == 1)
                while (true) {
                    try {
                        methods.Passenger_menu_option();// Passenger menu
                        Methods.wait(1);
                        int n = scanner.nextInt();
                        if (n == 0) {
                            Methods.wait(1);
                            break;
                        }
                            switch (n) {
                                case 1:
                                    methods.changePassword();
                                    break;
                                case 2:
                                    tickets.Search();
                                    break;
                                case 3:
                                    tickets.Buy_tickets();
                                    break;
                                case 4:
                                    methods.Ticket_cancellation();
                                    break;
                                case 5:
                                    tickets.Booked_thickets();
                                    break;
                                case 6:
                                    methods.Add_charge();
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



