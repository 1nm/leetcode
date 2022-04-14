class StockPrice {
  Map<Integer, Integer> priceMap; // timestamp to price map
  TreeMap<Integer, Set<Integer>> timestampMap; // price to timestamps map
  int latestTimestamp;

  public StockPrice() {
    priceMap = new HashMap<>();
    timestampMap = new TreeMap<>();
  }

  public void update(int timestamp, int price) {
    if (latestTimestamp < timestamp) {
      latestTimestamp = timestamp;
    }
    if (priceMap.containsKey(timestamp)) { // remove the timestamp from the old price
      int oldPrice = priceMap.get(timestamp);
      Set<Integer> timestamps = timestampMap.get(oldPrice);
      timestamps.remove(timestamp);
      if (timestamps.isEmpty()) {
        timestampMap.remove(oldPrice);
      }
    }
    priceMap.put(timestamp, price);
    Set<Integer> timestamps = timestampMap.getOrDefault(price, new HashSet<>());
    timestamps.add(timestamp);
    timestampMap.put(price, timestamps);
  }

  public int current() {
    return priceMap.get(latestTimestamp);
  }

  public int maximum() {
    return timestampMap.lastKey();
  }

  public int minimum() {
    return timestampMap.firstKey();
  }
}

/**
 * Your StockPrice object will be instantiated and called as such: StockPrice obj = new
 * StockPrice(); obj.update(timestamp,price); int param_2 = obj.current(); int param_3 =
 * obj.maximum(); int param_4 = obj.minimum();
 */
