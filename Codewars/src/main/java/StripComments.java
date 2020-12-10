import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StripComments {
    /*
    Complete the solution so that it strips all text that follows any of a set of comment markers passed in.
    Any whitespace at the end of the line should also be stripped out.
     */
    public static void main(String[] args) {
        System.out.println(stripComments( "a #b\nc\nd $e f g", new String[] { "#", "$" } ));
        //System.out.println("a #b\nc\nd $e f g".replaceAll("\\#.*", ""));
    }
    public static String stripComments(String text, String[] commentSymbols) {
        List<String> list = new ArrayList<>();
        for (String s : Arrays.asList(text.split("\n"))) {
            boolean state = false;
            for (String symbol : commentSymbols) {
                if(s.contains(symbol)){
                    String s1 = "$".contains(symbol)?"\\"+symbol: symbol;
                    list.add(s.replaceAll(s1+".*", ""));
                    state = true;
                }
            }
            if (!state)list.add(s);
        }
        return list.stream().map(f -> f.replaceAll("\\s+$", ""))
                .collect(Collectors.joining("\n"));

    }
}
