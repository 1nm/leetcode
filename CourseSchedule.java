public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] degrees = new int[numCourses];
        Map<Integer, List<Integer>> edges = new HashMap<Integer, List<Integer>>();
        Set<Integer> vertice = new HashSet<Integer>();

        // process vertice
        for (int i = 0; i < numCourses; ++ i) {
            vertice.add(i);
        }

        // process edges
        for (int i = 0; i < prerequisites.length; ++ i) {
            int prereq = prerequisites[i][1];
            int course = prerequisites[i][0];
            degrees[prerequisites[i][0]]++;
            List<Integer> nextCourses = edges.get(prereq);
            if (nextCourses == null) {
                nextCourses = new ArrayList<Integer>();
            }
            nextCourses.add(course);
            edges.put(prereq, nextCourses);
        }

        boolean flag = true; // true if a vertex with zero in degree is found
        while (flag) {
            flag = false;
            int courseToRemove = -1;
            for (int course : vertice) {
                if (degrees[course] == 0) {
                    flag = true;
                    courseToRemove = course;
                    List<Integer> nextCourses = edges.get(course);
                    if (nextCourses != null) {
                        for (int next : nextCourses) {
                            degrees[next] --;
                        }
                    }
                    break;
                }
            }
            if (flag) {
                vertice.remove(courseToRemove);
            }
        }
        return vertice.isEmpty();
    }
}
