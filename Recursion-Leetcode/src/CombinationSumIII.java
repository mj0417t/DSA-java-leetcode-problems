import java.util.ArrayList;
import java.util.List;

public class CombinationSumIII {
    public static void main(String[] args) {
        int k=3,n=9;

        List<List<Integer>> res = combinationSum3(k,n);
        System.out.println(res);
    }
    private static List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> combntn=new ArrayList<>();
        generateCombinations(k,n,1,combntn,res);
        return res;
    }

    private static void generateCombinations(int length, int target, int start, List<Integer> combntn, List<List<Integer>> res) {
        if(target==0 && combntn.size()==length) {
            res.add(new ArrayList<>(combntn));
            return;
        }

        if (combntn.size()>length)
            return;

        for(int i = start; i <=9; i++){
            if(i > target)
                break;
            combntn.add(i);
            generateCombinations(length,target-i,i+1, combntn,  res);
            combntn.removeLast();
        }
    }
}
