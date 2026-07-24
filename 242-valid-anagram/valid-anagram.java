import java.util.*;

class Solution {
    public boolean isAnagram(String s, String t) {
        boolean flag=true ; 
        if(s.length()!=t.length()){
            return flag=false ; 
        }
        char[]a = s.toCharArray();
        char[]b = t.toCharArray();
        Arrays.sort(a) ; 
        Arrays.sort(b) ; 
        for(int i=0;i<a.length;i++){
            if(a[i]!=b[i]) return flag=false ; 
        }
        return flag ; 
}
}
