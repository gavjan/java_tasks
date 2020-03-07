import java.util.Stack;
class ONP {

    public int policz(String s) throws PustyStos, ZaMaloOperatorow, DzieleniePrzezZero, BlednyZnak {
        if(s.equals(""))
            throw new PustyStos();
        Stack<Integer> stack= new Stack<>();
        int num1;
        int num2;
        for(int i=0;i<s.length();i++) {
            char c=s.charAt(i);
            if(c>='0' && c <='9') {
                stack.push(c-'0');
            }
            else if(c=='+' || c=='-' || c=='*' || c =='/') {
                if(stack.isEmpty()) throw new PustyStos();
                num1=stack.pop();
                if(stack.isEmpty()) throw new PustyStos();
                num2=stack.pop();
                switch(c) {
                    case '+':
                        stack.push(num2+num1);
                        break;
                    case '-':
                        stack.push(num2-num1);
                        break;
                    case '*':
                        stack.push(num2*num1);
                        break;
                    case '/':
                        if(num1==0) throw new DzieleniePrzezZero();
                        stack.push(num2/num1);
                        break;
                }
            }
            else {throw new BlednyZnak();}
        }
        if(stack.isEmpty()) throw new PustyStos();
        int ans=stack.pop();
        if(!stack.isEmpty()) throw new ZaMaloOperatorow();
        return ans;
    }

}
class BlednyZnak extends Exception {
}
class DzieleniePrzezZero extends Exception {
}
class ZaMaloOperatorow extends Exception {
}
class PustyStos extends Exception {
}
