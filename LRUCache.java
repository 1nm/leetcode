public class LRUCache {

    int capacity;
    Queue<Node> queue;
    Map<Integer, Node> map;

    static class Node {
        static long counter = 0L;
        int key, value;
        long timestamp;
        public Node(int key, int value) {
            this.key = key;
            this.value = value;
            update();
        }
        public void update() {
            this.timestamp = counter++;
        }
    }

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        this.queue = new PriorityQueue<>(new Comparator<Node>() {
                public int compare(Node n1, Node n2) {
                    return (int) (n1.timestamp - n2.timestamp);
                }
            });
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            queue.remove(node);
            node.update();
            queue.offer(node);
            return node.value;
        }
        else
            return -1;
    }

    public void set(int key, int value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            queue.remove(node);
            node.value = value;
            node.update();
            queue.offer(node);
        } else {
            Node node = new Node(key, value);
            if (queue.size() >= capacity) {
                Node eldest = queue.poll();
                map.remove(eldest.key);
            }
            queue.offer(node);
            map.put(key, node);
        }
    }
}
