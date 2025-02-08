class Solution {
    public boolean isValid(String s) {
        Stack<Character> n=new Stack<>();
                for(char c:s.toCharArray()){
                    if(c=='}' && !n.isEmpty() && n.peek()=='{'){
                        n.pop();

                    }
                    else if(c==')' && !n.isEmpty() && n.peek()=='('){
                            n.pop();

                     }
                    else if(c==']' && !n.isEmpty() && n.peek()=='['){
                                n.pop();
                    }
                    else{
                        n.push(c);
                    }

                }
                return n.isEmpty();

        }
    
    }

