class LongestCommPrefix{
	public static void main(String args[]){
		String[] strs = new String []{"flower","flow","flip"};
		if(strs.length == 0)
			System.out.println("");
        String prefix=strs[0];
        for(int i=1;i<strs.length;i++)
            while(strs[i].indexOf(prefix)!=0)
                prefix=prefix.substring(0,prefix.length()-1);
        System.out.println(prefix);
	}
}