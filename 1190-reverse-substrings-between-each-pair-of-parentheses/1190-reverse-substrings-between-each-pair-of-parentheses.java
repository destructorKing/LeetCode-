class Solution {
    public String reverseParentheses(String s) 
    {
        Deque<Character> stack = new ArrayDeque<>();

        for (char c : s.toCharArray()) {

            if (c != ')') {
                stack.push(c);
            } else {
                StringBuilder temp = new StringBuilder();

                while (stack.peek() != '(') {
                    temp.append(stack.pop());
                }

                stack.pop(); //remove '('

                for (int i = 0; i < temp.length(); i++) {
                    stack.push(temp.charAt(i));
                }
            }
        }

        StringBuilder ans = new StringBuilder();

        while (!stack.isEmpty()) {
            ans.append(stack.removeLast());
        }

        return ans.toString();    
    }
}