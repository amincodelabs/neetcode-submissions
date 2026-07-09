class MyQueue {
   private:
    stack<int> s1;
    stack<int> s2;

   public:
    MyQueue() {}

    void push(int x) { s1.push(x); }

    int pop() {
        while (s1.size() > 0) {
            s2.push(s1.top());
            s1.pop();
        }
        int result = s2.top();
        s2.pop();
        while (s2.size() > 0) {
            s1.push(s2.top());
            s2.pop();
        }
        return result;
    }

    int peek() {
        while (s1.size() > 0) {
            s2.push(s1.top());
            s1.pop();
        }
        int result = s2.top();
        while (s2.size() > 0) {
            s1.push(s2.top());
            s2.pop();
        }
        return result;
    }

    bool empty() { return s1.empty(); }
};
