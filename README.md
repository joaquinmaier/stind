# STIND

_A Scanner That Is Not Dogshit_

A simple class that wraps around `InputStream` and aims to simplify input operations, as well as provide an easy-to-use alternative to `java.util.Scanner`.

## Usage

The following is a simple example of how to read a `String` from the console:

```java
import stind.*;

public class Main
{
    public static void main(String[] args) {
        // Create a STIND object that listens to the standard input
        STIND stind = new STIND(System.in);
        
        String name = stind.read_line().unwrap_or( Throwable::printStackTrace );
        
        System.out.println(name);
    }
}
```

This code will read whatever the user inputs in the console, and in case there is an error, will print the stack trace.