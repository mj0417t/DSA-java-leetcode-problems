import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    public static void main(String[] args) {
        int[] candidates={2,3,5};
        int target=8;
        List<List<Integer>> res = combinationSum(candidates,target);
        System.out.println(res);
    }

    private static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> combntn=new ArrayList<>();
        generateCombinations(candidates,target,0,combntn,res);
        return res;
    }

    private static void generateCombinations(int[] candidates, int target, int index, List<Integer> combntn, List<List<Integer>> res) {

        if(index==candidates.length){
            if(target==0)
                res.add(new ArrayList<>(combntn));
            return;
        }
        if(candidates[index]<=target) {
            combntn.add(candidates[index]);
            generateCombinations(candidates, target - candidates[index], index, combntn, res);
            combntn.removeLast();
        }
        generateCombinations(candidates,target,index+1, combntn, res);
    }
}
