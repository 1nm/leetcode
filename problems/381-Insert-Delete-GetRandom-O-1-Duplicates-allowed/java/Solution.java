class RandomizedCollection {

  // position list of the values stored in the numbers list, key is the value
  Map<Integer, Set<Integer>> posMap;

  // list of all numbers that were inserted
  List<Integer> numbers;

  public RandomizedCollection() {
    posMap = new HashMap<>();
    numbers = new ArrayList<>();
  }

  public boolean insert(int val) {
    Set<Integer> posSet = posMap.getOrDefault(val, new LinkedHashSet<>());
    posSet.add(numbers.size());
    numbers.add(val);
    posMap.put(val, posSet);
    return posSet.size() == 1;
  }

  public boolean remove(int val) {
    if (!posMap.containsKey(val))
      return false;
    Set<Integer> valPosSet = posMap.get(val);
    int pos = valPosSet.iterator().next();
    valPosSet.remove(pos);
    if (valPosSet.isEmpty())
      posMap.remove(val);
    int lastPos = numbers.size() - 1;
    int last = numbers.remove(lastPos);
    if (pos < lastPos) {
      numbers.set(pos, last);
      Set<Integer> lastPosSet = posMap.get(last);
      lastPosSet.remove(lastPos);
      lastPosSet.add(pos);
    }
    return true;
  }

  public int getRandom() {
    return numbers.get((int) (Math.random() * numbers.size()));
  }
}

/**
 * Your RandomizedCollection object will be instantiated and called as such: RandomizedCollection
 * obj = new RandomizedCollection(); boolean param_1 = obj.insert(val); boolean param_2 =
 * obj.remove(val); int param_3 = obj.getRandom();
 */
