import java.util.*;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toMap;

public class TopWords {
    public static void main(String[] args) {
        System.out.println(top3("e e e e DDD ddd DdD: ddd ddd aa aA Aa, bb cc cC e e e"));
    }
    public static List<String> top3(String s) {
        final Matcher matcher = Pattern.compile("[A-Za-z][A-Za-z']*").matcher(s.toLowerCase());
        final Map<String, Integer> words = new HashMap<>();

        while (matcher.find()) {
            String elem = matcher.group();
            words.put(elem, words.get(elem)!=null? words.get(elem) + 1:1);
        }
        return words.entrySet().stream()
                .sorted(Comparator.comparing(Map.Entry::getValue, Comparator.reverseOrder()))
                .limit(3)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }


}
