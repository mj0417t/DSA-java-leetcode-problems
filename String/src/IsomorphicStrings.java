import java.util.Arrays;
import java.util.HashMap;

public class IsomorphicStrings {
    public static void main(String[] args) {
//        String s = "paper", t = "title";
        String s = "badc", t = "baba";
//        if(checkIsomorphic(s,t))
        if(checkIsomorphicOpt(s,t))
            System.out.printf("The strings %s, %s are isomorphic",s,t);
        else
            System.out.printf("The strings %s, %s are not isomorphic",s,t);
    }

    private static boolean checkIsomorphicOpt(String s, String t) {
        int[] sTot = new int[256];
        int[] tTos = new int[256];
        Arrays.fill(sTot,-1);
        Arrays.fill(tTos,-1);
        for (int i=0;i<s.length();i++){
            char ss=s.charAt(i);
            char tt=t.charAt(i);
            if (sTot[ss]==-1 && tTos[tt]==-1){
                sTot[ss]=tt;
                tTos[tt]=ss;
            } else if (sTot[ss]!=tt || tTos[tt]!=ss) {
                return false;
            }
        }
        return true;
    }

    private static boolean checkIsomorphic(String s, String t) {

        HashMap<Character,Character> mapStoT = new HashMap<>();
        HashMap<Character,Character> mapTtoS = new HashMap<>();

        for(int i=0;i<s.length();i++){
            if (mapStoT.containsKey(s.charAt(i))){
                if(mapStoT.get(s.charAt(i))!=t.charAt(i))
                    return false;
            } else if (mapTtoS.containsKey(t.charAt(i))) {
                if(mapTtoS.get(t.charAt(i))!=s.charAt(i))
                    return false;
            } else{
                mapStoT.put(s.charAt(i),t.charAt(i));
                mapTtoS.put(t.charAt(i), s.charAt(i));
            }

        }
        return true;
    }
}
