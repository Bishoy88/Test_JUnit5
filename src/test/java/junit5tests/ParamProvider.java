package junit5tests;

import java.util.stream.Stream;

public class ParamProvider {
    static Stream<String> sourceStringAsStream() {
        //processing
        return Stream.of("beetroot", "apple", "pear");
    }
}
