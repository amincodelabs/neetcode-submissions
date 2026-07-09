class Solution {
   public:
    int calPoints(vector<string>& operations) {
        vector<int> points;

        for (string op : operations) {
            if (op == "+") {
                if (points.size() >= 2) {
                    int a = points.back();
                    int b = points[points.size() - 2];
                    points.push_back(a + b);
                }
            } else if (op == "D") {
                int a = points.back();
                points.push_back(a + a);
            } else if (op == "C") {
                points.pop_back();
            } else {
                int x = stoi(op);
                points.push_back(x);
            }
        }

        int result = 0;
        for (int point : points) {
            result += point;
        }

        return result;
    }
};