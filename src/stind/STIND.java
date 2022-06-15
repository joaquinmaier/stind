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

    public String read_line_throws() throws IOException {
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

    public Result<String, IOException> read_line() {
        boolean reading = true;
        ArrayList<Character> data = new ArrayList<>();

        int read;
        while (reading) {
            try {
                read = INPUT_STREAM.read();
            }
            catch (IOException e) {
                return new Result<String, IOException>(e);
            }
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

        return new Result<String, IOException>(final_string);
    }

    public char[] read_chars_throws() throws IOException {
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

    public Result<char[], IOException> read_chars() {
        boolean reading = true;
        ArrayList<Character> data = new ArrayList<>();

        int read;
        while (reading) {
            try {
                read = INPUT_STREAM.read();
            }
            catch (IOException e) {
                return new Result<>(e);
            }

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

        return new Result<>(final_array);
    }

    public int read_int_throws() throws IOException {
        boolean reading = true;
	    boolean negate = false;
        ArrayList<Integer> data = new ArrayList<>();

        while (reading) {
            int read = INPUT_STREAM.read();
            char value = (char) read;

	    if (value == '-') {
		    negate = !negate;
		    continue;
	    }
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

	if (negate) 	{ return -final_number; }
	else		{ return final_number; }
    }

    public Result<Integer, IOException> read_int() {
        boolean reading = true;
        boolean negate = false;
        ArrayList<Integer> data = new ArrayList<>();

        int read;
        while (reading) {
            try {
                read = INPUT_STREAM.read();
            }
            catch (IOException e) {
                return new Result<>(e);
            }

            char value = (char) read;

            if (value == '-') {
                negate = !negate;
                continue;
            }
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

        if (negate) 	{ return new Result<>(-final_number); }
        else		    { return new Result<>(final_number); }
    }

    public byte read_throws() throws IOException {
        int read = INPUT_STREAM.read();

        return (byte) read;
    }

    public Result<Byte, IOException> read() {
        int read;

        try {
            read = INPUT_STREAM.read();
        }
        catch (IOException e) {
            return new Result<>(e);
        }

        return new Result<>((byte) read);
    }

    public ArrayList<Byte> read_bytes_throws() throws IOException {
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

    public Result<ArrayList<Byte>, IOException> read_bytes() {
        boolean reading = true;
        ArrayList<Byte> bytes = new ArrayList<>();

        int read;
        while (reading) {
            try {
                read = INPUT_STREAM.read();
            }
            catch (IOException e) {
                return new Result<>(e);
            }

            char value = (char) read;

            if (value == '\0' || value == '\n') {
                reading = false;
                continue;

            }

            bytes.add((byte) read);
        }

        return new Result<>(bytes);
    }
}
