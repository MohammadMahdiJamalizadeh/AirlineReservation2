package Project3;
public class Flies extends Colors{
    public static Flight[] fly = new Flight[50];
    private static int i;
    //----------------Constructor---------------//
    public static void setFlies(Flight flies1) {//Save tickets
        try {
            fly[i] = flies1;
            i++;
        }catch (Exception a){
            System.err.println(a.getMessage());
        }
    }
    //---------------Methods-------------//

    //--------------SETS && GETS------------//

    public static int getI() {
        return i;
    }

    public static void setI(int i) {
        Flies.i = i;
    }
}

