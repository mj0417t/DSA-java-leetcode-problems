import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LetterCombinationsOfPhoneNum {
    public static void main(String[] args) {
        String digits="23";
        List<String> res=letterCombinations(digits);
        System.out.println(res);
    }

    private static List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        StringBuilder str = new StringBuilder();
        HashMap<Character, ArrayList<Character>> map = new HashMap<>();
        for(int i=0;i<digits.length();i++){
            switch(digits.charAt(i)){
                case '2'-> map.put('2',new ArrayList<>(List.of('a','b','c')));
                case '3'-> map.put('3',new ArrayList<>(List.of('d','e','f')));
                case '4'-> map.put('4',new ArrayList<>(List.of('g','h','i')));
                case '5'-> map.put('5',new ArrayList<>(List.of('j','k','l')));
                case '6'-> map.put('6',new ArrayList<>(List.of('m','n','o')));
                case '7'-> map.put('7',new ArrayList<>(List.of('p','q','r','s')));
                case '8'-> map.put('8',new ArrayList<>(List.of('t','u','v')));
                case '9'-> map.put('9',new ArrayList<>(List.of('w','x','y','z')));
            }
        }
        if(!digits.isEmpty())
            generateCombination(digits,map,res,0,str);
        return res;
    }

    private static void generateCombination(String digits, HashMap<Character, ArrayList<Character>> map, List<String> res, int index, StringBuilder currStr) {
        if(currStr.length()==digits.length()){
            res.add(currStr.toString());
            return;
        }
        for (Character c: map.get(digits.charAt(index))) {
            generateCombination(digits,map,res,index+1,currStr.append(c));
            currStr.deleteCharAt(currStr.length()-1);
        }
        }
    }
