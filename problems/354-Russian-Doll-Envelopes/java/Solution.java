public class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        if (envelopes.length == 0) return 0;
        List<int[]> dolls = new ArrayList<>();
        Arrays.sort(envelopes, (e1, e2) -> e1[0] == e2[0] ? e2[1] - e1[1] : e1[0] - e2[0]);
        for (int i = 0; i < envelopes.length; ++ i) {
            int index = Collections.binarySearch(dolls, envelopes[i], (e1, e2) -> e1[1] - e2[1]);
            index = index < 0 ? - index - 1 : index;
            if (dolls.size() == 0 || index == dolls.size())
                dolls.add(envelopes[i]);
            else 
                dolls.set(index, envelopes[i]);
        }
        return dolls.size();
    }
}