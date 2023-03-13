package pl.mwrobel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class App {

    public static void main(String[] args){

        List<String> names = Arrays.asList("Jakub", "Michał", "Agnieszka", "Kasia");
        String[] namesAsArray = {"Jakub"};


        Greeter greeter = new Greeter();
        greeter.greet("Jakub"); // Hello Jakub

        List<String> ladies = new ArrayList<String>();

        for (String name: names) {
            if (name.endsWith("a")){
                ladies.add(name);

            }
        }

        for (String ladyName: ladies) {
            greeter.greet(ladyName);
        }

        names.stream()
                .filter(name -> name.endsWith("a")) // lambda name: name[-1] == "a"
                .filter(name -> name.startsWith("A"))
                .map(String::toUpperCase)
                .forEach(greeter::greet);


        //greet just ladies
        //Hello Agnieszka
        //Hello Kasia

        System.out.println("Hello World");
    }
}
