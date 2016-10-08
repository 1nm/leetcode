public class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> edges = new HashMap<Integer, List<Integer>>();
        Set<Integer> vertice = new HashSet<Integer>();
        int[] inDegrees = new int[numCourses];

        // pre-process of vertice and edges
        for (int i = 0 ; i < numCourses; ++ i) {
            vertice.add(i);
        }

        for (int i = 0; i < prerequisites.length; ++ i) {
            int prereq = prerequisites[i][1];
            int course = prerequisites[i][0];
            inDegrees[course]++;
            List<Integer> edgeList = edges.get(prereq);
            if (edgeList == null) {
                edgeList = new ArrayList<Integer>();
            }
            edgeList.add(course);
            edges.put(prereq, edgeList);
        }

        int count = 0;
        int[] order = new int[numCourses];
        while (!vertice.isEmpty()) {
            int course = -1;
            for (int i = 0; i < numCourses; ++ i) { // find zero in degree vertex
                if (inDegrees[i] == 0 && vertice.contains(i)) {
                    course = i;
                    break;
                }
            }
            if (course != -1) {
                order[count++] = course;
                vertice.remove(course);
                List<Integer> edgeList = edges.get(course);
                if (edgeList != null) {
                    for (int next : edgeList) {
                        inDegrees[next] --;
                    }
                }
            } else {
                break;
            }
        }
        if (vertice.isEmpty()) {
            return order;
        } else {
            return new int[0];
        }
    }
}
