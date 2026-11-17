class Solution {
    public int countSubstrings(String s) {
        int n = s.length();
        int count=0;
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                String sub = s.substring(i,j+1);
                if(palindrome(sub)){
                    count++;
                }
            }
        }
        return count;
        
    }
    public boolean palindrome(String s){
        int l=0;
        int r=s.length()-1;
        while(l<r){
            if(s.charAt(l)!=s.charAt(r)){
                return false;
            }
            l++;
            r--;
        }
        return true ;
    }
}