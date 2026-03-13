import java.util.ArrayList;
import java.util.List;

public class PowerSet {
    public static void main(String[] args) {
        String str="abc";
        printAllSubseq(str);
    }

    private static void printAllSubseq(String str) {
        List<String> strings = new ArrayList<>();
        generateSubSeqs(str,strings,0,"");
        System.out.println(strings);
    }

    private static void generateSubSeqs(String str, List<String> strings, int index, String s) {
        if(index>=str.length()){
            if(!s.isEmpty())
                strings.add(s);
            return;
        }
        generateSubSeqs(str,strings,index+1,s+str.charAt(index));
        generateSubSeqs(str,strings,index+1,s);
    }
}
