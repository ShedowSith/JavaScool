package homework_2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class WorkingWithStrings {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        LoadFileToList.loadFile(list, "C:\\Users\\ShadowSith\\IdeaProjects\\JAVASber\\Codewars\\src\\main\\java\\file.txt");
        System.out.println("1 ---------------------------------");
        //Задание 1: Подсчитайте количество различных слов в файле.
        String str = list.stream().collect(Collectors.joining(" "));
        System.out.println("В файле " +countWords(str)+ " различных слов");
        System.out.println("2 ---------------------------------");
        //Задание 2: Выведите на экран список различных слов файла, отсортированный по возрастанию их длины.
        listWords(str).stream().forEach(System.out::println);
        System.out.println("3 ---------------------------------");
        //Задание 3: Подсчитайте и выведите на экран сколько раз каждое слово встречается в файле.

        countWordsRepeat(str).forEach((k, v) -> System.out.println("Слово '" +k+ "' встречается " +v));
        System.out.println("4 ---------------------------------");
        //Задание 4: Выведите на экран все строки файла в обратном порядке.
        ListIterator listIterator = list.listIterator(list.size());
        while (listIterator.hasPrevious()) {
            System.out.println(listIterator.previous());
        }
//        Collections.reverse(list);
//        list.forEach(System.out::println);
        System.out.println("5 ---------------------------------");
        //Задание 5: Реализуйте свой Iterator для обхода списка в обратном порядке.

        IteratorRevers iterator = new IteratorRevers(list);
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
        System.out.println("6 ---------------------------------");
        //Задание 6: Выведите на экран строки, номера которых задаются пользователем в произвольном порядке.
        printStrList(list, Arrays.asList(2,4,5));

    }
    public static void printStrList(List<String> list, List<Integer> numbers){
        for (int i=0; i<numbers.size(); i++){
            System.out.println(list.get(i));
        }
    }
    public static Map<String, Integer> countWordsRepeat(String s) {
        final Matcher matcher = Pattern.compile("[A-Za-zА-Яа-я][A-Za-zА-Яа-я]*").matcher(s.toLowerCase());
        final Map<String, Integer> words = new HashMap<>();

        while (matcher.find()) {
            String elem = matcher.group();
            words.put(elem, words.get(elem)!=null? words.get(elem) + 1:1);
        }
        return words;
    }
    public static int countWords(String s) {
        final Matcher matcher = Pattern.compile("[A-Za-zА-Яа-я][A-Za-zА-Яа-я]*").matcher(s.toLowerCase());
        final Map<String, Integer> words = new HashMap<>();

        while (matcher.find()) {
            String elem = matcher.group();
            words.put(elem, words.get(elem)!=null? words.get(elem) + 1:1);
        }
        return words.size();
    }
    public static List<String> listWords(String s) {
        final Matcher matcher = Pattern.compile("[A-Za-zА-Яа-я][A-Za-zА-Яа-я]*").matcher(s.toLowerCase());
        final Map<String, Integer> words = new HashMap<>();

        while (matcher.find()) {
            String elem = matcher.group();
            words.put(elem, words.get(elem)!=null? words.get(elem) + 1:1);
        }
        return words.entrySet().stream()
                .sorted(Comparator.comparing(Map.Entry::getKey, Comparator.comparing(String::length)))
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

}

class LoadFileToList{
    public static Collection<String> loadFile(Collection<String> lines, String file){
        try {
            FileReader fr = new FileReader(new File(file));
            BufferedReader reader = new BufferedReader(fr);
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }
}