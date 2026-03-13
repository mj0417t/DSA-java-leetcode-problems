import java.util.*;

public class CombinationSumII {
    public static void main(String[] args) {
        int[] candidates={10,1,2,7,6,1,5};
        int target=8;
        List<List<Integer>> res = combinationSum(candidates,target);
        System.out.println(res);
    }

    private static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> combntn=new ArrayList<>();
        Arrays.sort(candidates);
        generateCombinations(candidates,target,0,combntn,res);
        return res;
    }

    private static void generateCombinations(int[] candidates, int target, int index, List<Integer> combntn, List<List<Integer>> res) {

        if(target==0) {
            res.add(new ArrayList<>(combntn));
            return;
            }
//        }
//        if(target<0 || index==candidates.length)
//            return;
//        //include
//        combntn.add(candidates[index]);
//        generateCombinations(candidates, target - candidates[index], index+1, combntn, res);
//        combntn.removeLast();
//        //not include
//        while ((index+1<candidates.length) && (candidates[index]==candidates[index+1]))
//            index++;
//        generateCombinations(candidates,target,index+1, combntn, res);

        for(int i = index; i < candidates.length; i++){

            if(i > index && candidates[i] == candidates[i-1])
                continue;

            if(candidates[i] > target)
                break;

            combntn.add(candidates[i]);

            generateCombinations(candidates,
                    target - candidates[i], i + 1,combntn,res);

            combntn.removeLast();
        }

    }
}
