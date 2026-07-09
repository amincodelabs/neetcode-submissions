#include <queue>
using namespace std;

class MyStack {
   private:
    queue<int> q1;
    queue<int> q2;

   public:
    MyStack() {}

    void push(int x) { 
        q1.push(x); 
    }

    int pop() {
        // Move everything except the last pushed element to q2
        while (q1.size() > 1) {
            q2.push(q1.front());
            q1.pop();
        }

        // The last remaining element is the "top" of the stack
        int result = q1.front();
        q1.pop();

        // Move elements back from q2 to q1
        swap(q1, q2);

        return result;
    }

    int top() {
        // Move everything except the last pushed element to q2
        while (q1.size() > 1) {
            q2.push(q1.front());
            q1.pop();
        }

        // The last remaining element is the top
        int result = q1.front();

        // Put it into q2 too, because top() should not remove it
        q2.push(q1.front());
        q1.pop();

        // Move elements back from q2 to q1
        swap(q1, q2);

        return result;
    }

    bool empty() { 
        return q1.empty();
    }
};