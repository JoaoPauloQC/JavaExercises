package Graphs;

import java.util.*;

public class Graph {

    private Map<String, List<String>> graph = new HashMap<>();

    public void addAdjacentAndVertex(String adjacent, String vertex){
        graph.putIfAbsent(adjacent, new ArrayList<>());
        graph.get(adjacent).add(vertex);
    }

    public void addAdjacent(String adjacent){
        graph.put(adjacent, new ArrayList<>());
    }

    public void addVertex(String adjacent, String vertex){
        graph.get(adjacent).add(vertex);
    }

    public void printGraph(){
        for(var entry : graph.entrySet()){
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }

    public boolean isConnected(String adjacent1, String adjacent2 ){

        if (graph.get(adjacent1).contains(adjacent2) ){
            return true;
        }
        if (graph.get(adjacent2).contains(adjacent1)){
            return true;
        }
        return dfs(adjacent1,adjacent2,new ArrayList<>());


    }

    public boolean dfs (String origin,String neighboor,List<String> visitados){
        visitados.add(origin);
        for (String value : graph.get(origin)){
            System.out.println("I´m in " + origin + " going on " + value);
            if (Objects.equals(value, neighboor)){
                System.out.println("Found it!");
                return true;
            }

                if (!visitados.contains(value)) {
                    if(dfs(value,neighboor,visitados))
                        return true;
                }

        }
        System.out.println("Didnt find it");
        return false;
    }



}
