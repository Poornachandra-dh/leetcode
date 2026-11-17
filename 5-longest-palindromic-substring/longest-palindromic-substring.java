class Solution {
    public String longestPalindrome(String s) {
        String ans ="";
        for(int i=0;i<s.length();i++){
            for(int j=i;j<s.length();j++){
                String sub = s.substring(i,j+1);
                    if(palindrome(sub)){
                        if(ans.length()<sub.length()){
                            ans= sub ;
                        }

                    }
                }

            }
            return ans ;
        }
        
        
    
    public boolean palindrome(String s ){
        int low=0;
        int high = s.length()-1;
        while(low<=high){
            if(s.charAt(low)!=s.charAt(high)){
                return false;
            }
            low++;
            high--;
        }
        return true ;
    }
}
