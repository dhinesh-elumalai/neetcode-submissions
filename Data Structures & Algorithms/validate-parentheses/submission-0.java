class Solution {
    public boolean isValid(String s) {
        // char[] brackets = {'(', ')', '{', '}', '[', ']'};
        Stack<Character> stack = new Stack<>();


        //([]{})
        // stack = ['(']
        // stack = ['}' ,']',')']
        for (char bracket : s.toCharArray()) {
            switch (bracket) {
                case '(':
                    stack.push(')');
                    break;
                case ')':
                    if (stack.isEmpty())
                        return false;
                    if (stack.pop() != ')')
                        return false;
                    break;
                case '{':
                    stack.push('}');
                    break;
                case '}':
                    if (stack.isEmpty())
                        return false;
                    if (stack.pop() != '}')
                        return false;
                    break;
                case '[':
                    stack.push(']');
                    break;
                case ']':
                    if (stack.isEmpty())
                        return false;
                    if (stack.pop() != ']')
                        return false;
                    break;
                default:
                    return false;
            }
        }
        if(stack.isEmpty()) return true;
        return false;
    }
}
