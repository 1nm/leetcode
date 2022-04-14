# 2034. Stock Price Fluctuation
- Difficulty: Medium
- Acceptance: 46.5% (as of 2022-03-14)

## Solutions
1. Two heaps, TLE
   * Keep a min heap and a map heap of prices
1. TreeMap
   * Keep a timestamp to price map and a sorted map from price to a set of timestamps
   * When there is an update, update the timestamp-to-price map, search in the sorted map, if there is an old price at the timestamp, remove the timestamp from the old price.
