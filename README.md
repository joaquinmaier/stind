# STIND

_A Scanner That Is Not Dog****_

A simple class that wraps around `InputStream` and aims to simplify input operations, as well as provide an easy-to-use alternative to `java.util.Scanner`[^1].

## Quick Start

The following snippet will show you the ropes on how to work with `STIND`:

```java
import stind.*;
import java.util.ArrayList;
import java.io.IOException;

public class Main
{
    public static void main(String[] args) {
        // Create a STIND object that listens to the standard input
        // Any InputStream will work, we just use stdin here for convenience
        STIND stind = new STIND(System.in);
        
        // Read a String from stdin
        String name = stind.read_line().unwrap_or( Throwable::printStackTrace );

        // If you'd rather have it as a character array, you can also do
        char[] cstring = stind.read_chars().unwrap_or( Throwable::printStackTrace );

        // Maybe you want to work at a lower level...
        ArrayList<Byte> bytes = stind.read_bytes().unwrap_or( Throwable::printStackTrace );

        // Or maybe you just want to read some numerical values
        Integer an_int = stind.read_int().unwrap_or( Throwable::printStackTrace );
        Double a_double = stind.read_double().unwrap_or( Throwable::printStackTrace );
        Float a_float = stind.read_float().unwrap_or( Throwable::printStackTrace );

        // You can also use a different handler (instead of `Throwable::printStackTrace`).
        // Just make sure it abides by the `ErrorHandler` interface.

        // Or you could just not use `Result` entirely, and use try/catch...
        try {
            String some_text = stind.read_line_throws();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```

[^1]: Originally created for my Java OOP class, since I got tired of `Scanner`'s clunky interface.
