class Solution {
    public int evalRPN(String[] tokens) {
        // Set<String> operations = new HashSet<>(List.of("+","-","*","/"));
        String operations = "+-*/";
        Deque<Integer> bucket = new ArrayDeque<>();
        
        for(String token : tokens){
            if(operations.contains(token)){
                Integer prevElement = bucket.pop();
                Integer prevPrevElement = bucket.pop();
                int result = calculate(prevElement, prevPrevElement, token);
                bucket.push(result);
            } else{
                bucket.push(Integer.parseInt(token));
            }
        }
        return bucket.pop();
    }

    public static int calculate(int i, int j, String operation){

        switch(operation){
            case "+":
                return j + i;
                
            case "-":
                return j - i;
                
            case "*":
                return j * i;
                
            case "/":
                return j / i;
                  
        }

        return 0;
    }
}
