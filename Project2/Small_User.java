package Project2;

import java.io.FileNotFoundException;

public class Small_User extends Colors{
    //--------------Variable----------------//
//    private String userName;
//    private String userPassword;
    private String usrepass;
    private long Charge;
    //---------------Constructor--------------//
    public Small_User() throws FileNotFoundException {

    }
    //-------------Sets && Gets------------//

    public long getCharge() {
        return Charge;
    }

    public void setCharge(long charge) {
        Charge = charge;
    }


}
