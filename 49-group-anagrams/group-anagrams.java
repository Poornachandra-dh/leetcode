import java.util.*;

class Solution {

    public List<List<String>> groupAnagrams(String[] strs) {

        List<List<String>> ans = new ArrayList<List<String>>();

        HashMap<String, List<String>> map =
            new HashMap<String, List<String>>();

        for (int i = 0; i < strs.length; i++) {

            String word = strs[i];

            char[] chars = word.toCharArray();

            Arrays.sort(chars);

            String key = new String(chars);

            if (!map.containsKey(key)) {

                map.put(key, new ArrayList<String>());
            }

            map.get(key).add(word);
        }

        for (List<String> group : map.values()) {

            ans.add(group);
        }

        return ans;
    }
}