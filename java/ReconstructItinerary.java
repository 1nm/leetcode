public class Solution {
    Map<String, PriorityQueue<String>> edges = new HashMap();
    List<String> itinerary = new LinkedList();

    public List<String> findItinerary(String[][] tickets) {
        for (String[] ticket : tickets) {
            edges.computeIfAbsent(ticket[0], k -> new PriorityQueue()).add(ticket[1]);
        }
        dfs("JFK");
        return itinerary;
    }

    void dfs(String airport) {
        while (edges.containsKey(airport) && !edges.get(airport).isEmpty()) {
            dfs(edges.get(airport).poll());
        }
        itinerary.add(0, airport);
    }
}
