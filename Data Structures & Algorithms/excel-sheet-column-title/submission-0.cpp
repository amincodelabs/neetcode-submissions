class Solution {
   public:
    string convertToTitle(int columnNumber) {
        string title;

        while (columnNumber > 0) {
            columnNumber--;  // Shift from 1-indexed to 0-indexed

            int remainder = columnNumber % 26;
            char letter = 'A' + remainder;

            title.push_back(letter);

            columnNumber /= 26;
        }

        reverse(title.begin(), title.end());
        return title;
    }
};