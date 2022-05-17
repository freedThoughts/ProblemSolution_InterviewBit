package problemSet_1;

import java.util.List;

public class GasStation {

    public int canCompleteCircuit(final List<Integer> A, final List<Integer> B) {
        int i = 0;
        int j = i;
        int bal = 0;
        while (i < A.size()) {
            for (; j >= i && bal >= 0; ) {
                bal += (A.get(getVal(j, A.size())) - B.get(getVal(j, A.size())));
                if (bal < 0) break;
                j++;
            }

            if (j > i && bal >= 0) return i;

            while (bal < 0 && i < j) {
                bal -= (A.get(i) - B.get(i));
                i++;
            }

            if (bal >= 0 && i != j) {
                j++;
                continue;
            }

            while (A.get(i) - B.get(i) < 0)
                i++;

            j = i;
            bal = 0;
        }

        return -1;
    }

    int getVal(int j, int size){
        return j == 0 ? j : j/size;
    }
}
