class Solution {

    public String longestCommonPrefix(String[] strs) {
        int n = strs.length ; 
        String first = strs[0] ; 
        if(n==0 || strs==null){
            return " " ; 
        }
        for(int i=0;i<first.length();i++){
            char ch = first.charAt(i) ; 
            for(int j=1;j<strs.length ; j++){
                if(i>=strs[j].length() || ch!=strs[j].charAt(i)){
                    return first.substring(0,i);
                }
            }
        }
        return first ; 


    
    }
}