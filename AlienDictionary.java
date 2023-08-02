import java.util.*;
public class AlienDictionary {
    public static char[] getAlienLanguage(int n, String[] dictionary) {
        Map<Integer, Integer> map = new HashMap<>();
        Queue<Integer> qrec = new LinkedList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<dictionary[i].length();j++){
                map.put((Integer)(dictionary[i].charAt(j)-97), 0);
            }
        }
        int nodes = map.keySet().size();
        char[] res = new char[nodes];
        int incoming[] = new int[nodes]; 
        Graph g = new Graph(nodes);
        for(int i=0;i<n-1;i++){
            int pointer = 0;
            String s1= dictionary[i];
            String s2 = dictionary[i+1];
            while(pointer<s1.length() && pointer<s2.length() && s1.charAt(pointer)==s2.charAt(pointer)){
                pointer++;
            }
            if(pointer==s1.length() || pointer==s2.length()){
                continue;
            }
            g.adj.get((Integer)(s1.charAt(pointer)-97)).add((Integer)(s2.charAt(pointer)-97));
        }
        for(int u=0;u<nodes;u++){
            for(Integer v:g.adj.get(u)){
                incoming[v]+=1;
            }
        }
        for(int i=0;i<incoming.length;i++){
            if(incoming[i]==0){
                qrec.add(i);
            }
        }
        int visitedNodes = 0;
        while(!qrec.isEmpty()){
            int topEle = qrec.remove();
            res[visitedNodes++] = (char)(topEle+97);
            for(Integer v:g.adj.get(topEle)){
                incoming[v] -=1;
                if(incoming[v]==0){
                    qrec.add(v);
                }
            }
        }
        if(visitedNodes!=nodes){
            return new char[0];
        }
        return res;
    }
}

class Graph{
    List<List<Integer>> adj;
    public Graph(int n){
        adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
    }
}