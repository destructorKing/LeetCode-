class Solution {
    public String decodeMessage(String key, String message) {
       
        char[] map = new char[26];
        boolean[] seen = new boolean[26];

        char decodedChar = 'a';

        for (char c : key.toCharArray()) {
            if (c == ' ') {
                continue;
            }

            int index = c - 'a';

            if (!seen[index]) {
                map[index] = decodedChar++;
                seen[index] = true;
            }
        }

        StringBuilder result = new StringBuilder();

        for (char c : message.toCharArray()) {
            if (c == ' ') {
                result.append(' ');
            } else {
                result.append(map[c - 'a']);
            }
        }

        return result.toString();
    }
}