//Programming Fundamentals Final Exam Retake 10.04.2020
//Problem 1. Secret Chat
//You have plenty of free time, so you decide to write a program that conceals and reveals your received messages. Go ahead and type it in!
//On the first line of the input you will receive the concealed message. After that, until the "Reveal" command is given, you will be receiving strings with instructions for different operations that need to be performed upon the concealed message in order to interpret it and reveal its true content. There are several types of instructions, split by ":|:"
//InsertSpace:|:{index}
//oInserts a single empty space at the given index. The given index will always be valid.
//Reverse:|:{substring}
//oIf the message contains the given substring, cut it out, reverse it and add it at the end of the message.
//oIf not, print "error".
//oThis operation should replace only the first occurrence of the given substring if there are more than one such occurrences.
//ChangeAll:|:{substring}:|:{replacement}
//oChanges all occurrences of the given substring with the replacement text.
//Input / Constraints
//On the first line, you will receive a string with message.
//On the next lines, you will be receiving commands, split by ":|:".
//Output
//After each set of instructions, print the resulting string.
//After the "Reveal" command is received, print this message:
//"You have a new text message: {message}"
//Examples

//Input                                     Output
//heVVodar!gniV                             hellodar!gnil
//ChangeAll:|:V:|:l                         hellodarling!
//Reverse:|:!gnil                           hello darling!
//InsertSpace:|:5                           You have a new text message: hello darling!
//Reveal

//Coments
//ChangeAll:|:V:|:l
//heVVodar!gniV -> hellodar!gnil (We replace all occurrences of "V" with "l")
//Reverse:|:!gnil
//hellodar!gnil -> !gnil -> ling! -> hellodarling! (We reverse !gnil to ling! And put it in the end of the string)
//InsertSpace:|:5
//hellodarling! -> hello.darling! (We insert a space at index 5)
//Finally, after receiving the "Reveal" command, we print the resulting message.

//Input                                     Output
//Hiware?uiy                                Howare?uoy
//ChangeAll:|:i:|:o                         Howareyou?
//Reverse:|:?uoy                            error
//Reverse:|:jd                              How areyou?
//InsertSpace:|:3                           How are you?
//InsertSpace:|:7                           You have a new text message: How are you?
//Reveal

//Comments
//ChangeAll:|:V:|:l
//heVVodar!gniV -> hellodar!gnil (We replace all occurrences of "V" with "l")
//Reverse:|:!gnil
//hellodar!gnil -> !gnil -> ling! -> hellodarling! (We reverse !gnil to ling! And put it in the end of the string)
//InsertSpace:|:5
//hellodarling! -> hello.darling! (We insert a space at index 5)
//Finally, after receiving the "Reveal" command, we print the resulting message.
package Exam1;

import java.util.Scanner;

public class secretChat {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String codedMassage = scanner.nextLine();

        String input = scanner.nextLine();

        while (!input.equals("Reveal")){
            String[] tockens = input.split(":\\|:");

            if (tockens[0].equals("InsertSpace") && Integer.parseInt(tockens[1])>=0){
                String sirInceput = codedMassage.substring(0, Integer.parseInt(tockens[1]) );
                String strMidel = sirInceput + " ";
                String strFinal = strMidel + codedMassage.substring(Integer.parseInt(tockens[1]));
                System.out.println(strFinal);
                codedMassage = strFinal;
            }

            //Reverse:|:{substring}
            if(tockens[0].equals("Reverse")){
                if (codedMassage.contains(tockens[1])){
                    int lungimeSir = tockens[1].length();
                    int beginPosition = codedMassage.indexOf(tockens[1]);
                    String sir = "";

                    sir = tockens[1];

                    StringBuilder text = new StringBuilder(codedMassage);
                    text = text.replace(beginPosition, beginPosition + tockens[1].length(),"");
                    codedMassage = text.toString();


                    StringBuilder builder = new StringBuilder();

                    for (int i = sir.length()-1; i >=0; i--) {
                        builder.append(sir.charAt(i));
                    }
                    codedMassage = codedMassage + builder.toString();
                    System.out.println(codedMassage);
                }else{
                    System.out.println("error");
                }


            }
            //ChangeAll:|:{substring}:|:{replacement}
            if(tockens[0].equals("ChangeAll")){
                if(codedMassage.contains(tockens[1])){
                    codedMassage = codedMassage.replace(tockens[1], tockens[2]);
                    System.out.println(codedMassage);
                }

            }


            input = scanner.nextLine();
        }
        System.out.printf("You have a new text message: %s", codedMassage);

    }
}
