import java.util.*;

public class SortByFreq {
    public static void main(String[] args) {
        String s = "treeAabb";
        System.out.println(frequencySort(s));
    }

    public static String frequencySort(String s) {

        HashMap<Character,Integer> map = new HashMap<>();
        for(char ch: s.toCharArray())
            map.put(ch,map.getOrDefault(ch,0)+1);

//        List<Map.Entry<Character, Integer>> list = new ArrayList<>(map.entrySet());
//        list.sort(((a,b)->b.getValue().compareTo(a.getValue())));
//
//        StringBuilder res= new StringBuilder();
//        for(Map.Entry<Character,Integer> entry: list){
//            char ch = entry.getKey();
//            int cnt= entry.getValue();
//            for(int i=0;i<cnt;i++)
//                res.append(ch);
//
//        }


        //using priority queue
        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>((a,b)->b.getValue()- a.getValue());
        pq.addAll(map.entrySet());
        StringBuilder res = new StringBuilder();

        while (!pq.isEmpty()){
            Map.Entry<Character,Integer> entry = pq.poll();
            res.append(String.valueOf(entry.getKey()).repeat(entry.getValue()));
        }
        return res.toString();
    }
}
