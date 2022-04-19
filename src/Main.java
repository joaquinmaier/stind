package stind;

import java.io.IOException;
import stind.STIND;

public class Main {
    final STIND chupame_un_huevo = new STIND(System.in);

    int number = 0;
    try {
        number = chupame_un_huevo.read_int();
        System.out.printf("%d", number);
    } catch(IOException e) {
        throw new RuntimeException(e);
    }
}

