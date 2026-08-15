class Solution {
    public int[] topKFrequent(int[] nums, int k) {
       Map<Integer, Integer> countMap = new HashMap<>();
    for (int num : nums) {
        countMap.put(num, countMap.getOrDefault(num, 0) + 1);
    }

    List<Integer>[] buckets = new List[nums.length + 1];
    for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
        int freq = entry.getValue();
        if (buckets[freq] == null) {
            buckets[freq] = new ArrayList<>();
        }
        buckets[freq].add(entry.getKey());
    }

    int[] result = new int[k];
    int count = 0;

    for (int i = buckets.length - 1; i >= 0 && count < k; i--) {
        if (buckets[i] != null) {
            for (int num : buckets[i]) {
                result[count++] = num;
                if (count == k) break;
            }
        }
    }

    return result;
    }
}
