package stind;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

/**
 * Simple InputStream wrapper that aims to simplify input operations
 *
 * @version 1.0.0
 * @author Joaquin Maier
 */
public class STIND
{
    private final InputStream INPUT_STREAM;

    public STIND(InputStream is) {
        INPUT_STREAM = is;
    }

    /**
     * A Result-less version of the {@linkplain STIND#read_line() read_line() function}, that opts to throw the exception instead.
     * <b>This function has to be surrounded with try/catch statements.</b>
     *
     * @return                  The String read from the InputStream
     * @throws IOException      I/O Exception that occurred when reading from the InputStream
     * @see STIND#read_line()   Same function that uses Result instead
     */
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

    /**
     * Function that reads a String from the InputStream the class is listening to. It makes use of the {@linkplain Result Result type} in order to avoid having to use try/catch statements.
     *
     * @return                          The result of the operation, with either a <i>String</i> or an <i>Exception</i> contained inside
     * @see STIND#read_line_throws()    Result-less version of the same function
     */
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

    /**
     * A Result-less version of the {@linkplain STIND#read_chars() read_chars() function}, that throws the exception instead.
     * <b>This function has to be surrounded with try/catch statements.</b>
     *
     * @return                  An array of the characters read from the InputStream
     * @throws IOException      I/O Exception that occurred when reading from the InputStream
     * @see STIND#read_chars()  Same function that uses Result instead
     */
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

    /**
     * Function that reads an array of characters from the InputStream the class is listening to. It makes use of the {@linkplain Result Result type} in order to avoid having to use try/catch statments.
     *
     * @return                          The result of the operation, with either a <i>char[]</i> or an <i>Exception</i> contained inside
     * @see STIND#read_chars_throws()   Result-less version of the same function
     */
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

    /**
     * A Result-less version of the {@linkplain STIND#read_int() read_int() function}, that throws the exception instead.
     * <b>This function has to be surrounded with try/catch statements.</b>
     *
     * @return                  The number read from the InputStream
     * @throws IOException      I/O Exception that occurred when reading from the InputStream
     * @see STIND#read_int()    Same function that uses Result instead
     */
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

    /**
     * Function that reads an integer number from the InputStream the class is listening to. It makes use of the {@linkplain Result Result type} in order to avoid having to use try/catch statements.
     *
     * @return                      The result of the operation, with either an <i>Integer</i> or an <i>Exception</i> contained inside
     * @see STIND#read_int_throws() Result-less version of the same function
     */
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

    /**
     * A Result-less version of the {@linkplain STIND#read() read() function}, that throws the exception instead.
     * <b>This function has to be surrounded with try/catch statements.</b>
     *
     * @return              The first byte read from the InputStream.
     * @throws IOException  I/O Exception that occurred when reading from the InputStream
     * @see STIND#read()    Same function that uses Result instead
     */
    public byte read_throws() throws IOException {
        int read = INPUT_STREAM.read();

        return (byte) read;
    }

    /**
     * Function that reads the first byte from the InputStream the class is listening to. It makes use of the {@linkplain Result Result type} in order to avoid having to use try/catch statements.
     *
     * @return                  The result of the operation, with either a <i>Byte</i> or an <i>Exception</i> contained inside
     * @see STIND#read_throws() Result-less version of the same function
     */
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

    /**
     * A Result-less version of the {@linkplain STIND#read_bytes() read_bytes() function}, that throws the exception instead.
     * <b>This function has to be surrounded with try/catch statements.</b>
     *
     * @return                  An <i>ArrayList</i> with the bytes read
     * @throws IOException      I/O Exception that occurred when reading from the InputStream
     * @see STIND#read_bytes()  Same function that uses Result instead
     */
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

    /**
     * Function that reads the bytes from the InputStream the class is listening to. It makes use of the {@linkplain Result Result type} in order to avoid having to use try/catch statements.
     *
     * @return                          The result of the operation, with either an <i>ArrayList</i> of <i>Byte</i>s or an <i>Exception</i> contained inside
     * @see STIND#read_bytes_throws()   Result-less version of the same function
     */
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

    /**
     * Method that reads doubles from the InputStream the class is listening to. It makes use of the {@linkplain Result Result type} in order to avoid having to use try/catch statements.
     *
     * @return                          The result of the operation with either a <i>Double</i> or an <i>Exception</i> contained inside
     * @see STIND#read_double_throws()  Result-less version of the same function
     */
    public Result<Double, IOException> read_double() {
        boolean reading = true;
        boolean negate = false;
        boolean after_period = false;
        ArrayList<Integer> whole_numbers    = new ArrayList<>();
        ArrayList<Integer> fractions        = new ArrayList<>();

        int read;
        while ( reading ) {
            try {
                read = INPUT_STREAM.read();

            } catch ( IOException e ) {
                return new Result<>( e );
            }

            char value = (char) read;

            switch ( value ) {
                case '-':
                    negate = !negate;
                    continue;

                case '\0':
                case '\n':
                    reading = false;
                    continue;

                case '.':
                    after_period = true;
                    continue;
            }

            if ( !after_period ) {
                whole_numbers.add( read - 48 );

            } else {
                fractions.add( read - 48 );

            }

        }

        double final_number = 0.;

        for ( int i = 0; i < whole_numbers.size(); i++ ) {
            final_number = final_number + (int) ( whole_numbers.get( i ) * Math.pow( 10, ( whole_numbers.size() - 1 ) - i ) );

        }

        for ( int j = 0; j < fractions.size(); j++ ) {
            final_number = final_number + ( fractions.get( j ) * Math.pow( 10, -1 - j ) );

        }

        if ( negate )   { return new Result<>( -final_number ); }
        else            { return new Result<>( final_number ); }
    }

    /**
     * A Result-less version of the {@linkplain STIND#read_double() read_double() function} that throws the Exception instead.
     * <b>This method has to be surrounded with try/catch statements or otherwise</b>
     *
     * @return                  The Double read.
     * @throws IOException      I/O Exception that occurred when reading from the InputStream.
     * @see STIND#read_double() Same function that uses {@linkplain Result Result} instead.
     */
    public Double read_double_throws() throws IOException {
        boolean reading = true;
        boolean negate = false;
        boolean after_period = false;
        ArrayList<Integer> whole_numbers    = new ArrayList<>();
        ArrayList<Integer> fractions        = new ArrayList<>();

        int read;
        while ( reading ) {
            read = INPUT_STREAM.read();

            char value = (char) read;

            switch ( value ) {
                case '-':
                    negate = !negate;
                    continue;

                case '\0':
                case '\n':
                    reading = false;
                    continue;

                case '.':
                    after_period = true;
                    continue;
            }

            if ( !after_period ) {
                whole_numbers.add( read - 48 );

            } else {
                fractions.add( read - 48 );

            }

        }

        double final_number = 0.;

        for ( int i = 0; i < whole_numbers.size(); i++ ) {
            final_number = final_number + (int) ( whole_numbers.get( i ) * Math.pow( 10, ( whole_numbers.size() - 1 ) - i ) );

        }

        for ( int j = 0; j < fractions.size(); j++ ) {
            final_number = final_number + ( fractions.get( j ) * Math.pow( 10, -1 - j ) );

        }

        if ( negate )   { return -final_number; }
        else            { return final_number; }
    }


    /**
     * Method that reads floats from the InputStream the class is listening to. It makes use of the {@linkplain Result Result type} in order to avoid having to use try/catch statements.
     *
     * @return                          The Result of the operation with either a <i>Float</i> or an <i>Exception</i> contained inside.
     * @see STIND#read_float_throws()   Result-less version of the same function.
     */
    public Result<Float, IOException> read_float() {
        Result<Double, IOException> result = this.read_double();

        if ( result.is_err() ) {
            return new Result<>( result.unwrap_err() );
        }

        try {
            return new Result<>( result.unwrap().floatValue() );

        } catch ( Exception e ) {
            // We proceed to crash the program because there should have been no error since we checked earlier.
            System.exit( 1 );
        }

        // This will never be reached, but the compiler doesn't seem to notice that, so have a hacky workaround.
        return null;
    }

    /**
     * A Result-less version of the {@linkplain STIND#read_float() read_float() function} that throws the Exception instead.
     * <b>This method has to be surrounded with try/catch statements or otherwise.</b>
     *
     * @return                  The Float read.
     * @throws IOException      I/O Exception that occurred when reading from the InputStream.
     * @see STIND#read_float()  Same function that uses {@linkplain Result Result} instead.
     */
    public Float read_float_throws() throws IOException {
        return this.read_double_throws().floatValue();
    }
}

