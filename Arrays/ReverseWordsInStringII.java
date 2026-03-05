class ReverseWordsInStringII{
    public static String reverseWords(String s){
     /*   StringBuilder res = new StringBuilder();
        StringBuilder temp = new StringBuilder();

        char[] ch = s.toCharArray();
        for(int i=0;i<ch.length;i++){

            if(ch[i] !='\s'){
                temp.append(ch[i]);
            }else{
                    temp.reverse();
                    res.append(temp);
                    res.append('\s');
                    temp.setLength(0);
                }

            }



        if(temp.length()!=0){
            temp.reverse();
            res.append(temp);
        }



        return res.toString();
		*/
		
		//Approach -2
        String[] str = s.split("\\s");
        for(int i=0;i<str.length;i++){
            String reversed = new StringBuilder(str[i]).reverse().toString();
            str[i]=reversed;
        }

        return String.join(" ", str);
    }
    public static void main(String args[]){
        String s1="Let's take Leetcode contest";
        s1=reverseWords(s1);
        System.out.println(s1);
		
		String s2="Mr Ding Ding";
        s2=reverseWords(s2);
        System.out.println(s2);
		
    }
}