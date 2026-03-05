import java.util.HashMap;

public class ValidAnagram {
    public static void main(String[] args) {
        String s = "anagram", t = "nagaram";
//        String  s = "rat", t = "car";
//        System.out.println(isAnagram(s,t));
        System.out.println(isAnagramUsingCntArr(s,t));
    }

    private static boolean isAnagramUsingCntArr(String s, String t) {
        if(s.length()!=t.length()) return false;
        int[] cnt=new int[26];

        for(char ch: s.toCharArray())
            cnt[ch-'a']++;
        for(char ch: t.toCharArray()){
            cnt[ch-'a']--;
            if(cnt[ch-'a']<0) return false;
        }
        return true;
    }

    private static boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()) return false;

        HashMap<Character,Integer> map= new HashMap<>();
        for(int i=0;i<s.length();i++){
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
        }

        for(int i=0;i<t.length();i++){
            if(!map.containsKey(t.charAt(i))){
                return false;
            }else {
                if(map.get(t.charAt(i))==0) return false;
                map.put(t.charAt(i),map.get(t.charAt(i))-1);
            }
            }
        return true;
        }
    }
