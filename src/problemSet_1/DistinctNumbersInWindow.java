package problemSet_1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DistinctNumbersInWindow {
    public ArrayList<Integer> dNums(ArrayList<Integer> A, int B) {
        ArrayList<Integer> ans = new ArrayList<>(A.size()-B+1);
        if (B > A.size()) return ans;

        Map<Integer, Integer> map = new HashMap<>(B * 4/3 +1);
        for (int i = 0; i < B; i++){
            if (map.containsKey(A.get(i))) {
                map.put(A.get(i), map.get(A.get(i))+1);
            } else map.put(A.get(i), 1);
        }

        ans.add(map.size());

        for (int i = B; i < A.size(); i++) {
            int m = i-B;
            if (map.get(A.get(m)) > 1) {
                map.put(A.get(m), map.get(A.get(m)-1));
            } else map.remove(A.get(m));

            if (map.containsKey(A.get(i))) {
                map.put(A.get(i), map.get(A.get(i))+1);
            } else map.put(A.get(i), 1);

            ans.add(map.size());
        }
        return ans;
    }
}
