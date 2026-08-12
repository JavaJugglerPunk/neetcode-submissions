class Solution {
    public boolean hasDuplicate(int[] nums) {
        Set<Integer> ret = new HashSet<>();

        for(int i : nums){
            if(ret.contains(i))
            return true;

            ret.add(i);
        }
        return false;
}
}