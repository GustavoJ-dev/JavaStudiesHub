package praticas.readtext;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        printChallenge();
        System.out.println("_".repeat(50));

        printChallenge2();
        System.out.println("_".repeat(50));

        printChallenge3();
        System.out.println("_".repeat(50));

        printChallenge4();



    }

    public static void printChallenge(){

        try(BufferedReader br = new BufferedReader(
                new FileReader("module13-Java-POO-IOFiles/src" +
                        "/praticas/readtext/article.txt"))){

            System.out.printf(" %,d linhas no arquivo%n", br.lines().count());

        }catch (IOException e){
            e.printStackTrace();
        }

    }


    public static void printChallenge2(){

        try(BufferedReader br = new BufferedReader(
                new FileReader("module13-Java-POO-IOFiles/src" +
                        "/praticas/readtext/article.txt"))){

            Pattern pattern = Pattern.compile("\\p{javaWhitespace}+");

            var result = br.lines()
                    .flatMap(pattern::splitAsStream)
                    .map(w -> w.replaceAll("\\p{Punct}", ""))
                    .filter(w -> w.length() > 4)
                    .map(String::toLowerCase)
                    .collect(Collectors.groupingBy(w -> w,
                            Collectors.counting()));

            result.entrySet().stream()
                    .sorted(Comparator.comparing(Map.Entry::getValue,
                            Comparator.reverseOrder()))
                    .limit(10)
                    .forEach(e -> System.out.println(e.getKey() + " _ " +
                            e.getValue() + " Vezes"));


        }catch (IOException e){
            e.printStackTrace();
        }
    }


    public static void printChallenge3(){

        try(BufferedReader br = new BufferedReader(
                new FileReader("module13-Java-POO-IOFiles/src" +
                        "/praticas/readtext/article.txt"))){

            Pattern pattern = Pattern.compile("\\p{javaWhitespace}+");

            List<String> excluded = List.of(
                    "java",
                    "linguagem",
                    "programação",
                    "internet",
                    "projeto",
                    "tecnologia");

            var result = br.lines()
                    .flatMap(pattern::splitAsStream)
                    .map(w -> w.replaceAll("\\p{Punct}", ""))
                    .filter(w -> w.length() > 4)
                    .map(String::toLowerCase)
                    .filter(w -> !excluded.contains(w))
                    .collect(Collectors.groupingBy(w -> w,
                            Collectors.counting()));

            result.entrySet().stream()
                    .sorted(Comparator.comparing(Map.Entry::getValue,
                            Comparator.reverseOrder()))
                    .limit(10)
                    .forEach(e -> System.out.println(e.getKey() + " _ " +
                            e.getValue() + " Vezes"));


        }catch (IOException e){
            e.printStackTrace();
        }

        System.out.println("*".repeat(50));

        String input = null;

        try{
            input = Files.readString(Path.of("module13-Java-POO-IOFiles/src" +
                    "/praticas/readtext/backend.txt"));

            input = input.replaceAll("\\p{Punct}", "");

            Pattern pattern = Pattern.compile("\\w{5,}");
            Matcher matcher = pattern.matcher(input);

            Map<String, Long> results = new HashMap<>();

            while (matcher.find()){

                String word = matcher.group().toLowerCase();
                results.merge(word, 1L,
                        (o, n) -> o += n);
            }

            var sortedEntries = new ArrayList<>(results.entrySet());

            sortedEntries.sort(Comparator.comparing(Map.Entry::getValue,
                    Comparator.reverseOrder()));

            for (int i = 0; i < Math.min(10, sortedEntries.size()); i++){

                var entry = sortedEntries.get(i);
                System.out.println(entry.getKey() + " - " + entry.getValue() + " Vezes");
            }

        }catch (IOException e){
            e.printStackTrace();
        }
    }


    public static void printChallenge4(){

        try(BufferedReader br = new BufferedReader(
                new FileReader("module13-Java-POO-IOFiles/src" +
                        "/praticas/readtext/article.txt"))){

            Pattern pattern = Pattern.compile("\\p{javaWhitespace}+");
            System.out.printf("%,d palavras no arquivo%n",
                    br.lines()
                            .flatMap(pattern::splitAsStream)
                            .count());

        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
