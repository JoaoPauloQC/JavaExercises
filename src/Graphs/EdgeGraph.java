package Graphs;

import java.util.*;

public class EdgeGraph {

    private Map<String, List<Edge>> graph = new HashMap<>();

    public Map<String, List<Edge>> getGraph() {
        return graph;
    }

    public void printGraph(){
        for (var entry : graph.entrySet()){
            List<String> edges = new ArrayList<>();
            for(Edge edge : entry.getValue()){
                edges.add(edge.getEdge());
            }
            System.out.println(entry.getKey() + " -> " + edges);
        }
    }

    public boolean isConnected(String adjacent1, String adjacent2 ){


        return dfs(adjacent1,adjacent2,new ArrayList<>());


    }
    public boolean isClosed(String adjacent1 ){

        return dfs(adjacent1,adjacent1,new ArrayList<>(),0);


    }

    public boolean dfs (String origin,String goal,List<String> visitados){
        if (Objects.equals(origin, goal)){
            System.out.println("Found it!");
            return true;
        }

        visitados.add(origin);
        for (Edge neighbour : graph.get(origin)){
            System.out.println("I´m in " + origin + " going on " + neighbour.getEdge());

            if (!visitados.contains(neighbour.getEdge())) {
                if(dfs(neighbour.getEdge(),goal,visitados)){
                    return true;
                }
            }

        }
        visitados.remove(origin);
        System.out.println("Didnt find it");
        return false;
    }
    public boolean dfs (String origin,String goal,List<String> visitados,long time){
        if (time !=0){
            if (Objects.equals(origin, goal)){
                System.out.println("Found it!");
                return true;
            }
        }
        if (time !=0){
            visitados.add(origin);
        }
        for (Edge neighbour : graph.get(origin)){
            System.out.println("I´m in " + origin + " going on " + neighbour.getEdge());

            if (!visitados.contains(neighbour.getEdge())) {
                if(dfs(neighbour.getEdge(),goal,visitados,time+1)){
                    return true;
                }
            }

        }
        visitados.remove(origin);
        System.out.println("Didnt find it");
        return false;
    }

    public long findingBestWay(String origin,String destiny){
        return dfsBestWay(origin,destiny,new ArrayList<>(),0,0);
    }

    public long dfsBestWay (String origin,String goal,List<String> visitados,long bestway,long current_way){
        if (Objects.equals(origin, goal)){
            System.out.println("Found it : " + bestway);
            if (bestway == 0 || bestway > current_way){
                bestway = current_way;
            }
            return bestway;

        }
        visitados.add(origin);
        for (Edge neighbour : graph.get(origin)){

            System.out.println("I´m in " + origin + " going on " + neighbour.getEdge());

            if (!visitados.contains(neighbour.getEdge())) {
                long newBest = dfsBestWay(neighbour.getEdge(),goal,visitados,bestway,current_way + neighbour.getWeight());
                if(newBest > 0 && (newBest < bestway || bestway == 0)) {

                        bestway = newBest;

                    System.out.println(bestway);

                }
            }

        }
        visitados.remove(origin);
        System.out.println("Didnt find it");
        return bestway;
    }

    public void addEdge(String origin, Edge destiny){
        graph.putIfAbsent(origin,new ArrayList<>());
        graph.putIfAbsent(destiny.getEdge(),new ArrayList<>());
        graph.get(origin).add(destiny);

    }

    public static void main(String[] args) {
        EdgeGraph edgeGraph = new EdgeGraph();

        edgeGraph.addEdge("A",new Edge("B",5));
        edgeGraph.addEdge("B",new Edge("C",9));
        edgeGraph.addEdge("C",new Edge("D",15));
        edgeGraph.addEdge("A",new Edge("E",25));
        edgeGraph.addEdge("A",new Edge("C",55));
        edgeGraph.addEdge("C",new Edge("B",35));
        edgeGraph.addEdge("C",new Edge("E",32));
        edgeGraph.addEdge("E",new Edge("C",95));
        edgeGraph.addEdge("B",new Edge("F",65));
        edgeGraph.addEdge("E",new Edge("F",15));
        edgeGraph.addEdge("F",new Edge("D",15));
        edgeGraph.addEdge("D",new Edge("A",15));
        edgeGraph.printGraph();

        edgeGraph.isClosed("A");


        EdgeGraph graph = new EdgeGraph();
        while(true){

            Scanner scanner = new Scanner(System.in);
            System.out.println("Do you wanna?");
            System.out.println("1 - Add Edge");
            System.out.println("2 - Print Graph");
            System.out.println("3 - DFS");
            try{
            int decision = scanner.nextInt();

                if ((decision > 5) || (decision < 1)) {
                    break;
                }
                switch (decision) {

                    case 1: {
                        printAdj();
                        String adjacent = scanner.next();
                        printVertex();
                        String vertex = scanner.next();
                        long weight = scanner.nextLong();
                        graph.addEdge(adjacent, new Edge(vertex, weight));
                        break;
                    }
                    case 2: {
                        graph.printGraph();
                        break;
                    }
                    case 3: {
                        printAdj();
                        String adjacent = scanner.next();
                        printAdj();
                        String adjacent2 = scanner.next();
                        graph.isConnected(adjacent, adjacent2);
                        break;
                    }
                    default:

                }
            }catch (Exception e){
                String error = e.toString();

                if (error.equals("java.util.InputMismatchException")){
                    System.out.println("Digite um número!");
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

