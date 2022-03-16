package stind;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

// Scanner That Is Not Dogshit
public class STIND
{
    private final InputStream INPUT_STREAM;

    public STIND(InputStream is) {
        INPUT_STREAM = is;
    }

    public String read_line() throws IOException {
        boolean reading = true;
        ArrayList<Character> data = new ArrayList<>();

        while (reading) {
            int read = INPUT_STREAM.read();
            char value = (char) read;

            if (value == '\0' || value == '\n') {
                reading = false;
                continue;

            }

            data.add(value);
        }

        String final_string = "";

        for (char character : data) {
            final_string = final_string.concat(String.valueOf(character));
        }

        return final_string;
    }

    public char[] read_chars() throws IOException {
        boolean reading = true;
        ArrayList<Character> data = new ArrayList<>();

        while (reading) {
            int read = INPUT_STREAM.read();
            char value = (char) read;

            if (value == '\0' || value == '\n') {
                reading = false;
                continue;

            }

            data.add(value);
        }

        char[] final_array = new char[data.size()];

        for (int i = 0; i < data.size(); i++) {
            final_array[i] = data.get(i);
        }

        return final_array;

    }

    public int read_int() throws IOException {
        boolean reading = true;
        ArrayList<Integer> data = new ArrayList<>();

        while (reading) {
            int read = INPUT_STREAM.read();
            char value = (char) read;

            if (value == '\0' || value == '\n') {
                reading = false;
                continue;

            }

            data.add(read - 48);
        }

        int final_number = 0;

        for (int i = 0; i < data.size(); i++) {
            //System.out.printf("{ %d: %,.2f }\n", i, Math.pow(10, (data.size()-1) - i));
            final_number = final_number + (int) (data.get(i) * Math.pow(10, (data.size()-1) - i));
        }

        return final_number;
    }

    public byte read() throws IOException {
        int read = INPUT_STREAM.read();

        return (byte) read;
    }

    public ArrayList<Byte> read_bytes() throws IOException {
        boolean reading = true;
        ArrayList<Byte> bytes = new ArrayList<>();

        while (reading) {
            int read = INPUT_STREAM.read();
            char value = (char) read;

            if (value == '\0' || value == '\n') {
                reading = false;
                continue;

            }

            bytes.add((byte) read);
        }

        return bytes;

    }
}
