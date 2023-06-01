package Project3;

import java.io.FileNotFoundException;

public class Small_User extends Colors{
    //--------------Variable----------------//
//    private String userName;
//    private String userPassword;
    private String usrepass;
    private long Charge;
    public Ticket ticket = new Ticket();
    //---------------Constructor--------------//

    public Small_User(String usepass) throws FileNotFoundException {
//        this.userName = userName;
//        this.userPassword = userPassword;
        this.usrepass = usepass;
    }

    public Small_User() throws FileNotFoundException {

    }
    //-------------Sets && Gets------------//
//    public String getUserName() {
//        return userName;
//    }

    public String getUsrepass() {
        return usrepass;
    }

    public void setUsrepass(String usrepass) {
        this.usrepass = usrepass;
    }

//    public void setUserName(String userName) {
//        this.userName = userName;
//    }

//    public String getUserPassword() {
//        return userPassword;
//    }

//    public void setUserPassword(String userPassword) {
//        this.userPassword = userPassword;
//    }

    public long getCharge() {
        return Charge;
    }

    public void setCharge(long charge) {
        Charge = charge;
    }


//    public String getCharge() {
//        return Charge;
//    }
//
//    public void setCharge(String charge) {
//        Charge = charge;
//    }
}
