package main;

import RANDWFiles.RandWFiles;
import SImpleLogin.SimpleLogin;
import Sorts.BubbleSort;
import vogals.Volgals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Main {

    public static void main(String[] args){

        String myString = "Abacate";
        System.out.println(Volgals.checkingNum(myString));

        List<Double> myDoubleArray = new ArrayList<>(Arrays.asList(5.0,4.0,2.0,3.0,1.0));
        System.out.println(BubbleSort.BubbleSort(myDoubleArray));

        SimpleLogin simpleLogin = new SimpleLogin(new HashMap<String,String>());

        simpleLogin.addingUser("pedro");
        simpleLogin.addingUser("joao","massa");
        simpleLogin.puttingPassword("pedro","234");
        simpleLogin.printLoginMap();
        System.out.println(simpleLogin.authentication("joao","daora"));
        System.out.println(simpleLogin.authentication("joao","massa"));
        RandWFiles.writingLoginFile(simpleLogin);
    }

}
