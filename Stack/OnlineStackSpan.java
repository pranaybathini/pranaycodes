//https://leetcode.com/problems/online-stock-span/
class StockSpanner {
    
    //Monotonic Stack
    Stack<Pair> st ;
    public StockSpanner() {
        st = new Stack<>();
    }
    
    public int next(int price) {
        int span = 1;
        while(!st.isEmpty() && st.peek().price <= price){
            span += st.pop().span;
        }
        st.push(new Pair(price, span));
        return span;
    }
}

class Pair{
    public int price;
    public int span;
    
    public Pair(int price, int span){
        this.price = price;
        this.span = span;
    }
    
    //do encapsulation yourself, I am too lazy
    
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */
