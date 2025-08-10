package Graphs;

import Graphs.Graph;
import RANDWFiles.RandWFiles;
import SImpleLogin.SimpleLogin;
import Sorts.BubbleSort;
import vogals.Volgals;

import java.util.*;

public class MainGraph {

    public static void main(String[] args){

        Graph graph = new Graph();

        graph.addAdjacentAndVertex("A","B");
        graph.addAdjacentAndVertex("A","E");
        graph.addAdjacentAndVertex("B","C");
        graph.addAdjacentAndVertex("C","D");
        graph.addAdjacentAndVertex("D","T");
        graph.addAdjacentAndVertex("T","D");
        graph.addAdjacentAndVertex("Y","P");
        graph.addAdjacentAndVertex("P","Y");

        System.out.println("A -> D: " + graph.isConnected("A", "D")); // esperado: true
        System.out.println("A -> C: " + graph.isConnected("A", "C")); // esperado: true
        System.out.println("D -> A: " + graph.isConnected("D", "A"));

        while(true){
            Scanner scanner = new Scanner(System.in);
            System.out.println("Do you wanna?");
            System.out.println("1 - Add Adjacent and Vertex");
            System.out.println("2 - Add Adjacent");
            System.out.println("3 - Add Vertex");
            System.out.println("4 - Print Graph");
            System.out.println("5 - DFS");
            int decision = scanner.nextInt();
            if ((decision > 5) || (decision < 1)){
                break;
            }
            switch (decision){
                case 1: {
                    printAdj();
                    String adjacent = scanner.next();
                    printVertex();
                    String vertex = scanner.next();
                    graph.addAdjacentAndVertex(adjacent, vertex);
                    break;
                }
                case 2: {
                    printAdj();
                    String adjacent = scanner.next();
                    graph.addAdjacent(adjacent);
                    break;
                }
                case 3:{
                    printAdj();
                    String adjacent = scanner.next();
                    printVertex();
                    String vertex = scanner.next();
                    graph.addVertex(adjacent, vertex);
                    break;
                }
                case 4: {
                    graph.printGraph();
                    break;
                }
                case 5:{
                    printAdj();
                    String adjacent = scanner.next();
                    printAdj();
                    String adjacent2 = scanner.next();
                    graph.isConnected(adjacent, adjacent2);
                    break;
                }

            }
        }



    }

    public static void printAdj(){
        System.out.println("Adjacent");
    }
    public static void printVertex(){
        System.out.println("Vertex");
    }

}
