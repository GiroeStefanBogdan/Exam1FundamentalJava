//Programming Fundamentals Final Exam Retake 10.04.2020
//Problem 2. Mirror words
//
//The SoftUni Spelling Bee competition is here. But it`s not like any other Spelling Bee competition out there, it`s different and a lot more fun! You, of course, are a participant and you are eager to show the competition that you are the best, so go ahead, learn the rules and win!
//On the first line of the input you will be given a text string. In order to win the competition you have to find all hidden word pairs, read them and mark the ones that are mirror images of each other.
//First of all you have to extract the hidden word pairs. Hidden word pairs are:
//Surrounded by "@" or "#" (only one of the two) in the following pattern #wordOne##wordTwo# or @wordOne@@wordTwo@
//At least 3 characters long each (without the surrounding symbols)
//Made up of letters only
//If the second word, spelled backwards is the same as the first word and vice versa (casing matters!), then they are a match and you have to store them somewhere. Examples of mirror words:
//#Part##traP# @leveL@@Level@ #sAw##wAs#
//If you don`t find any valid pairs print: "No word pairs found!"
//If you find valid pairs print their count: "{valid pairs count} word pairs found!"
//If there are no mirror words print: "No mirror words!"
//If there are mirror words print:
//"The mirror words are:
//{wordOne} <=> {wordtwo}, {wordOne} <=> {wordtwo}, {wordOne} <=> {wordtwo}, etc…"
//Input / Constraints
//You will recive a string.
//Output
//Print the proper output messages in the proper cases as described in the problem description.
//If there are pairs of mirror words, print them in the end, each pair separated by ", ".
//Each pair of mirror word must be printed with " <=> " between the words.
//Examples
//Input                                                                                                                                 Output
//@mix#tix3dj#poOl##loOp#wl@@bong&song%4very$long@thong#Part##traP##@@leveL@@Level@##car#rac##tu@pack@@ckap@#rr#sAw##wAs#r#@w1r	        5 word pairs found!

//Input                                                                                 Output
//#po0l##l0op# @bAc##cAB@ @LM@ML@ #xxxXxx##xxxXxx# @aba@@ababa@                         2 word pairs found!

package Exam1;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class MirrorWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String input = scanner.nextLine();
        Map<String,String> palindrom = new LinkedHashMap<>();
        Pattern Compile = Pattern.compile("(@|#)(?<one>[A-Za-z]{3,})\\1\\1(?<two>[A-Za-z]{3,})\\1");

        Matcher matcher = Compile.matcher(input);
        int count = 0;


        while(matcher.find()){
            count++;
            String one = matcher.group("one");
            String two = matcher.group("two");

            two = reverse(two);

            if (one.equals(two)) {
                palindrom.put(matcher.group("one"), matcher.group("two"));
            }

        }
        if (count > 0) {
            System.out.println(count + " word pairs found!");
        }else {
            System.out.println("No word pairs found!");
        }



        if (palindrom.size() > 0) {
            System.out.println("The mirror words are:");
            int[] counter = {1};
            palindrom.forEach((e, v) -> {
                System.out.print(String.format("%s <=> %s", e, v));
                if ( counter[0] < palindrom.size() ) {
                    System.out.print(", ");
                }
                counter[0]++;
            });

        } else {
            System.out.println("No mirror words!");
        }

    }
    private static String reverse(String two) {
        StringBuilder sb = new StringBuilder();
        sb.append(two);
        sb.reverse();
        return sb.toString();
    }
}