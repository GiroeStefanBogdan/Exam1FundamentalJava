# Exam1FundamentalJava
Cuprinde Regex, Text Processing and Associative Array
1.Secret Chat
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

2.Mirroe Words