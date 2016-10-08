public class RandomizedSet {

    final Map<Integer, Integer> map;
    final List<Integer> list;
    /** Initialize your data structure here. */
    public RandomizedSet() {
        map = new HashMap<>();
        list = new ArrayList<>();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (map.keySet().contains(val)) return false;
        map.put(val, list.size());
        list.add(val);
        return true;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (!map.keySet().contains(val)) return false;
        int pos = map.remove(val);
        int last = list.remove(list.size() - 1);
        if (val != last) {
            list.set(pos, last);
            map.put(last, pos);
        }
        return true;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        return list.get((int) (Math.random() * list.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */