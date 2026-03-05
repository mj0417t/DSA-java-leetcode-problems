class ReverseWordsInString{
    public static String reverseWords(String s){
        StringBuilder res = new StringBuilder();
        StringBuilder temp = new StringBuilder();

        s=s.trim();
        System.out.println(s);
        char prev='\u0000';
        char[] ch = s.toCharArray();
        for(int i=(ch.length -1);i>=0;i--){

            if(ch[i] !='\s'){
                temp.append(ch[i]);
                prev = ch[i];
            }else{
                if(prev!='\s'){
                    temp.reverse();
                    res.append(temp);
                    res.append('\s');
                    temp.setLength(0);
                    prev = ch[i];
                }else{
                    prev = ch[i];
                }

            }


        }
        if(temp.length()!=0){
            temp.reverse();
            res.append(temp);
        }



        return res.toString();
    }
    public static void main(String args[]){
        String s=" ";
        s=reverseWords(s);
        System.out.println(s);
    }
}