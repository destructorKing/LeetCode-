class Solution {
    public boolean repeatedSubstringPattern(String s) {
        String doubled = s + s;

        String rotated = doubled.substring(1, doubled.length() - 1);

        return rotated.contains(s);
    }
}