import java.util.ArrayList;
import java.util.List;

public class BinaryStrWithoutCons1s {
    public static void main(String[] args) {
        int n=5;
        printBinaryStrings(n);
    }

    private static void printBinaryStrings(int n) {
        StringBuilder bs = new StringBuilder();
        List<String > binStrs = new ArrayList<>();
        generate(n,bs,binStrs);
        for(String str:binStrs)
            System.out.println(str);
    }

    private static void generate(int n, StringBuilder bs, List<String> binStrs) {
        if(bs.length()==n){
            binStrs.add(bs.toString());
            return;
        }
        generate(n,bs.append('0'), binStrs);
        bs.deleteCharAt(bs.length()-1);

        if(bs.isEmpty()||bs.charAt(bs.length()-1)!='1') {
            generate(n, bs.append('1'), binStrs);
            bs.deleteCharAt(bs.length()-1);
        }

    }
}
