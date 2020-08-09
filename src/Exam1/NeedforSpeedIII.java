//You have just bought the latest and greatest computer game – Need for Seed III. We know that you can`t wait to start playing. Pick your favorite cars and drive them all you want!
//On the first line of the standard input you will receive an integer n – the number of cars that you can obtain. On the next n lines the cars themselves will follow with their mileage and fuel available, separated by "|" in the following format:
//{car}|{mileage}|{fuel}
//Then, you will be receiving different commands, each on a new line, separated by " : ", until the "Stop" command is given:
//Drive : {car} : {distance} : {fuel}
//oYou need to drive the given distance and you will need the given fuel to do that. If the car doesn`t have enough fuel print:
//"Not enough fuel to make that ride"
//oIf the car has the required fuel available in the tank, increase its mileage with the given distance, decrease its fuel with the given fuel and print:
//"{car} driven for {distance} kilometers. {fuel} liters of fuel consumed."
//oYou like driving new cars only, so if the mileage of a car reaches 100 000 km, remove it from the collection(s). Print:
//"Time to sell the {car}!"
//Refuel : {car} : {fuel}
//oRefill the tank of your car.
//oEach tank can hold a maximum of 75 liters of fuel, so if the given amount of fuel is more than you can fit in the tank, take only what is required to fill it up.
//oPrint a message in the following format:
//"{car} refueled with {fuel} liters"
//Revert : {car} : {kilometers}
//oDecrease the mileage of the given car with the given kilometers and print the kilometers you have decreased it with in the following format:
//"{car} mileage decreased by {amount reverted} kilometers"
//oIf the mileage becomes less than 10 000km after it is decreased, just set it to 10 000km and
//DO NOT print anything.
//Upon receiving the "Stop" command you need to print all cars in your possession, sorted by their mileage in decscending order, then by their name in ascending order, in the following format:
//"{car} -> Mileage: {mileage} kms, Fuel in the tank: {fuel} lt."
//Input/Constraints
//The mileage and fuel of the cars will be valid, 32-bit integers and will never be negative.
//The fuel and distance amounts in the commands will never be negative.
//The car names in the commands will always be valid cars in your possession.
//Output
//All the output messages with the appropriate formats are described in the problem description.

//Examples
//Input                                             Output
//3                                                 Audi A6 driven for 543 kilometers. 47 liters of fuel consumed.
//Audi A6|38000|62                                  Mercedes CLS driven for 94 kilometers. 11 liters of fuel consumed.
//Mercedes CLS|11000|35                             Not enough fuel to make that ride
//Volkswagen Passat CC|45678|5                      Audi A6 refueled with 50 liters
//Drive : Audi A6 : 543 : 47                        Mercedes CLS mileage decreased by 500 kilometers
//Drive : Mercedes CLS : 94 : 11                    Volkswagen Passat CC -> Mileage: 45678 kms, Fuel in the tank: 5 lt.
//Drive : Volkswagen Passat CC : 69 : 8             Mercedes CLS -> Mileage: 10594 kms, Fuel in the tank: 24 lt.
//Refuel : Audi A6 : 50                             Audi A6 -> Mileage: 10000 kms, Fuel in the tank: 65 lt.
//Revert : Mercedes CLS : 500
//Revert : Audi A6 : 30000
//Stop

//Comments
//After we receive the cars with their mileage and fuel, we start driving them. When we get to "Drive : Volkswagen Passat CC : 69 : 8" command, our program calculates that there is not enough fuel and we print the appropriate message. Then we refuel the Audi A6 with 50 l of fuel and Revert the Mercedes with 500 kilometers.
//When we receive the "Revert : Audi A6 : 30000", we set its mileage to 10000 km, because if the current mileage of the Audi is 38543 kms and if we subtract 30000 from it, we receive 8543 kms, which is less than 10000 kms.
//After all the commands, we print our current collection of cars with their current mileage and current fuel.

package Exam1;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class NeedforSpeedIII {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());//numberOfCar

        LinkedHashMap<String, ArrayList<Integer>> infoCars = new LinkedHashMap<>();

        for (int i = 0; i <=n-1; i++) {
            String[] tockens = scanner.nextLine().split("\\|");
            String car = tockens[0];
            int mileage = Integer.parseInt(tockens[1]);
            int fuel = Integer.parseInt(tockens[2]);

            ArrayList<Integer> mileageAndFuel = new ArrayList<>();

            mileageAndFuel.add(mileage);
            mileageAndFuel.add(fuel);

            infoCars.put(car, mileageAndFuel);
        }

        String input = scanner.nextLine();
        while (!input.equals("Stop")){
            String[] tockens = input.split(" : ");

            //Drive : {car} : {distance} : {fuel}
            if(tockens[0].equals("Drive")){
                String car = tockens[1];
                int distance = Integer.parseInt(tockens[2]);
                int fuel = Integer.parseInt(tockens[3]);

                if(infoCars.get(car).get(1)<fuel){
                    System.out.println("Not enough fuel to make that ride");
                   // System.out.println();
                }else{
                    ArrayList<Integer> distanceAndFuel = infoCars.get(car);
                    distanceAndFuel.set(0,distanceAndFuel.get(0) + distance);
                    distanceAndFuel.set(1, distanceAndFuel.get(1) - fuel);
                    infoCars.put(car, distanceAndFuel);
                    System.out.printf("%s driven for %d kilometers. %d liters of fuel consumed.%n", car,distance,fuel);

                }

                if(infoCars.get(car).get(0)>=100000){
                    System.out.printf("Time to sell the %s!%n",car);
                    infoCars.remove(car);
                }
            }

            //Refuel : {car} : {fuel}
            int differenceFuel = 0;
            if(tockens[0].equals("Refuel")){
                String car = tockens[1];
                int fuel = Integer.parseInt(tockens[2]);
                ArrayList<Integer> refullTheCar = infoCars.get(car);

                if(refullTheCar.get(1) < 75){
                    //refullTheCar.get(1);//Aici trebuie umplut pana maxim 75
                    //Din fuel

                    int allCombustibilInCar = refullTheCar.get(1) + fuel;

                    if(allCombustibilInCar>75){
                        differenceFuel = fuel - (allCombustibilInCar-75);
                        allCombustibilInCar = allCombustibilInCar - (allCombustibilInCar-75);
                    }else{
                        differenceFuel = fuel;
                    }
                  //  int differenceFuel = allCombustibilInCar - refullTheCar.get(1);
                    ArrayList<Integer> combustibilCar = new ArrayList<>();
                    combustibilCar.add(refullTheCar.get(0));
                    combustibilCar.add(allCombustibilInCar);
                    infoCars.put(car, combustibilCar);
                    System.out.printf("%s refueled with %d liters%n", car, differenceFuel);
                }else{
                    System.out.printf("%s refueled with %d liters%n", car, 0);
                }
            }

            //Revert : {car} : {kilometers}
            if(tockens[0].equals("Revert")){
                String car = tockens[1];
                int kilometer = Integer.parseInt(tockens[2]);

                ArrayList<Integer> mileage = infoCars.get(car);

                mileage.set(0, mileage.get(0) - kilometer);

                if(mileage.get(0)<10000){
                    mileage.set(0, 10000);
                    infoCars.put(car, mileage);
                }else{
                    System.out.printf("%s mileage decreased by %d kilometers%n", car, kilometer);
                }

            }


            input = scanner.nextLine();
        }

        infoCars
                .entrySet()
                .stream()
                .sorted((a,b) ->{
                   int rezult = b.getValue().get(0).compareTo(a.getValue().get(0));
                   if(rezult==0){
                       rezult = a.getKey().compareTo(b.getKey());
                   }
                   return rezult;
                })
                .forEach(e-> System.out.printf("%s -> Mileage: %d kms, Fuel in the tank: %d lt.%n",e.getKey(),e.getValue().get(0), e.getValue().get(1)));




    }
}


