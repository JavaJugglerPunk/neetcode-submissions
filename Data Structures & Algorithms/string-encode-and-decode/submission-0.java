class Solution {
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String s : strs) {
            sb.append(s.length()).append('#').append(s);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> result = new ArrayList<>();
        int i = 0;
        while (i < str.length()) {
            int hashIdx = str.indexOf('#', i);
            int len = Integer.parseInt(str.substring(i, hashIdx));
            String toret = str.substring(hashIdx + 1, hashIdx + 1 + len);
            result.add(toret);
            i = hashIdx + 1 + len;
        }
        return result;
    }
}