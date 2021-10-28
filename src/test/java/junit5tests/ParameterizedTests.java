package junit5tests;

import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ParameterizedTests {
    @ParameterizedTest(name = "Run: {index} - value: {arguments}")
    @ValueSource(ints = {1,5,6})
    void intValues(int theParam){
        System.out.println("the Param = " + theParam);
    }
    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {"firstString" , "secondString"})
    void stringValues(String theParam){
        System.out.println("the param = " + theParam);
    }
    @ParameterizedTest
    @CsvSource(value = {"steve,rogers", "captain,marvel", "bucky,barnes"})
    void csvSource_StringString(String param1, String param2){
        System.out.println("param1 = " + param1 + ", param2 = " + param2);
    }
    @ParameterizedTest
    @CsvSource(value = {"steve,32,true","captain,21,false","bucky,5,true"})
    void csvSource_StringIntBoolean(String param1, int param2, boolean param3){
        System.out.println("param1 = " + param1 + ", param2 = " + param2 + ", param3 = " + param3);
    }
    @ParameterizedTest
    @CsvSource(value = {"captain america,'steve,rogers'", "winter soldier, 'bucky,barnes'"})
    void csvSource_StringWithComa(String param1, String param2){
        System.out.println("param1 = " + param1 + ", param2 = " + param2);
    }
    @ParameterizedTest
    @CsvSource(value = {"steve?rogers", "bucky?barnes"}, delimiter = '?')
    void csvSource_StringWithDiffDelimeter(String param1 , String param2){
        System.out.println("param1 = " + param1 + ", param2 = " + param2);
    }
    @ParameterizedTest
    @CsvFileSource(files = {"D:\\junit5-tutorial\\src\\test\\resources\\params\\shoppinglist.csv","D:\\junit5-tutorial\\src\\test\\resources\\params\\shoppinglist2.csv"}, numLinesToSkip = 1)
    void csvFileSource_StringDoubleIntString(String name, Double price, int quantity, String uam, String provider){
        System.out.println("name = " + name + ", price = " + price + ", quantity = " + quantity +", uom = " + uam + ", provider = " + provider);
    }
    @ParameterizedTest
    @MethodSource(value = "sourceString")
    void methodSource_String(String param1){

    }
    List<String> sourceString() {
        //processing done here
    return Arrays.asList("tomato", "carrot", "cabbage");
    }
    @ParameterizedTest
    @MethodSource(value = "junit5tests.ParamProvider#sourceStringAsStream")
    void methodSource_StringStream(String param1){

    }
    /*Stream<String> sourceStringAsStream() {
        //processing
        return Stream.of("beetroot", "apple", "pear");
    }*/
    @ParameterizedTest
    @MethodSource(value = "sourceList_StringDouble")
    void methodSource_sourceList_StringDouble(String param1, Double param2){
        System.out.println("param1 = " + param1 + ", param2 = " + param2);
    }
    @ParameterizedTest
    @MethodSource(value = "sourceStream_StringDouble")
    void methodSource_StringDoubleStream(String param1, double param2){
        System.out.println("param1 = " + param1 + ", param2 = " + param2);
    }
    List<Arguments> sourceList_StringDouble() {
        //processing
        return Arrays.asList(arguments("tomato", 2.0), arguments("carrot", 4.5), arguments("cabbage", 7.8));
    }
    Stream<Arguments> sourceStream_StringDouble() {
        return Stream.of(arguments("apple", 8.9, "pear", 9.4));
    }
}
