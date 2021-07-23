package tag刷题.C01_数组.剑指Offer29_顺时针打印矩阵;


import java.util.Arrays;

public class Solution {

    public int[] spiralOrder(int[][] matrix) {
        // 输入空列，返回空数组
        if (matrix.length == 0) {
            return new int[0];
        }
        // 初始化左上角、右下角坐标
        int tR = 0, tC = 0;
        int dR = matrix.length - 1, dC = matrix[0].length - 1;
        // 结果二维数组大小=原始数组大小
        int[] res = new int[matrix.length * matrix[0].length];
        // 数组遍历坐标
        int index = 0;
        while (tR <= dR && tC <= dC) {
            index = spiralMatrix(matrix, index, res, tR++, tC++, dR--, dC--);
        }
        return res;
    }

    private int spiralMatrix(int[][] matrix, int index, int[] res, int tR, int tC, int dR, int dC) {
        if (tR == dR) {// 子矩阵只有一行,就复制列
            for (int i = tC; i <= dC; i++) {
                res[index++] = matrix[tR][i];
            }
        } else if (tC == dC) {// 子矩阵只有一列,就复制行
            for (int i = tR; i <= dR; i++) {
                res[index++] = matrix[i][tC];
            }
        } else {// 一般情况
            for (int i = tC; i < dC; i++) {
                res[index++] = (matrix[tR][i]);
            }
            for (int i = tR; i < dR; i++) {
                res[index++] = (matrix[i][dC]);
            }
            for (int i = dC; i > tC; i--) {
                res[index++] = (matrix[dR][i]);
            }
            for (int i = dR; i > tR; i--) {
                res[index++] = (matrix[i][tC]);
            }
        }
        return index;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] m = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        int[] res = solution.spiralOrder(m);
        // 正确：[1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10]
        System.out.println(Arrays.toString(res));
    }
}
