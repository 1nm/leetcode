public class Solution {
    public String getHint(String secret, String guess) {
        char[] sarray = secret.toCharArray();
        char[] garray = guess.toCharArray();
        boolean[] visited = new boolean[sarray.length];
        int a = 0;
        int b = 0;
        for (int i = 0; i < garray.length; ++ i) {
            if (garray[i] == sarray[i]) {
                a ++;
                visited[i] = true;
            }
        }
        
        for (int i = 0; i < garray.length; ++ i) {
            if (garray[i] != sarray[i]) {
                for (int j = 0; j < sarray.length; ++ j) {
                    if (!visited[j] && sarray[j] == garray[i]) {
                        b ++;
                        visited[j] = true;
                        break;
                    }
                }
            }
        }
        return a + "A" + b + "B";
    }
}