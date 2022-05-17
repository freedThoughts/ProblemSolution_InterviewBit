package problemSet_1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
// https://www.interviewbit.com/problems/anagrams/
public class Anagrams {

    public ArrayList<ArrayList<Integer>> anagrams(final List<String> A) {
        Map<String, ArrayList<Integer>> map = new HashMap<>();
        for(int i = 0; i < A.size(); i++) {
            char[] arr = A.get(i).toCharArray();
            Arrays.sort(arr);
            String str = new String(arr);
            ArrayList<Integer> list = map.get(str);
            if (list == null) list = new ArrayList<>();
            list.add(i+1);
            map.put(str, list);
        }

        return new ArrayList(map.values());
    }
}
