class Solution {
public:
    void setZeroes(vector<vector<int>>& matrix) {
        int R = matrix.size();
        int C = matrix[0].size();
        vector<vector<int>> mark = matrix;

        for(int i = 0; i < R; i++) {
            for(int j = 0; j < C; j++) {
                if(matrix[i][j] == 0) {
                    for(int k = 0; k < C; k++) {
                        mark[i][k] = 0;
                    }
                    for(int k = 0; k < R; k++) {
                        mark[k][j] = 0;
                    }
                }
            }
        }

        for(int i = 0; i < R; i++) {
            for(int j = 0; j < C; j++) {
                matrix[i][j] = mark[i][j];
            }
        }
        
    }
};