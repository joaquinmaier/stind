import stind.ErrorHandler;
import stind.STIND;

public class Main {
    public static void main(String[] args) {
        STIND stind = new STIND(System.in);

        String lectura = stind.read_line().unwrap_or( Throwable::printStackTrace );

        System.out.println(lectura);
    }
}
