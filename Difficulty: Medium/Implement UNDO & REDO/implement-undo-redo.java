class Solution {
    String str = "";
    Stack<String> s = new Stack<>();
    Stack<String> rev = new Stack<>();
    
    public void append(char x) {
        if(s.isEmpty())s.push(str);
        str += x;
        s.push(str);
    }

    public void undo() {
        rev.push(s.pop());
        str = s.peek();
    }

    public void redo() {
        s.push(rev.pop());
        str = s.peek();
    }

    public String read() {
        if(s.isEmpty())return str;
        return s.peek();
    }
}
