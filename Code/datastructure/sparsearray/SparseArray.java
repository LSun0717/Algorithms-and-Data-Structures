package datastructure.sparsearray;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName SparseArray
 * @Description TODO 稀疏数组<--->二维数组
 * @Author uncle_longgggggg
 * @Date 7/1/2022 9:34 PM
 * @Version 1.0
 */
public class SparseArray {

    // 存储棋盘残局信息
    // 棋盘大小：11 * 11
    // 0：无子 1.黑子 2.白子
    public static void main(String[] args) {
        // 创建棋盘与初始位置
        int[][] chessBoard = new int[11][11];
        chessBoard[1][2] = 1;
        chessBoard[2][3] = 2;

        // 查看棋盘与棋子
        for (int[] row : chessBoard) {
            for (int chess : row) {
                System.out.print(chess + " ");
            }
            System.out.println();
        }

        // 用于统计黑子与白子数量
        int sum = 0;

        for (int i = 0; i < chessBoard.length; i++) {
            for (int j = 0; j < chessBoard.length; j++) {
                if (chessBoard[i][j] > 0) {
                    sum++;
                }
            }
        }

        System.out.println("棋子数：" + sum);

        // 根据黑白子数量创建稀疏数组
        int[][] sparseArray = new int[sum + 1][3];
        // 首行为棋盘的 长 宽 棋子数量sum
        sparseArray[0][0] = 13;
        sparseArray[0][1] = 13;
        sparseArray[0][2] = sum;

        // 用于记录棋子数据
        int count = 0;
        for (int i = 0; i < chessBoard.length; i++) {
            for (int j = 0; j < chessBoard.length; j++) {
                if (chessBoard[i][j] > 0 && count < sum ) {
                    count++;
                    sparseArray[count][0] = i;
                    sparseArray[count][1] = j;
                    sparseArray[count][2] = chessBoard[i][j];
                }
            }
        }

        // 查看稀疏矩阵
        for (int[] row : sparseArray) {
            for (int i : row) {
                System.out.print(i + " ");
            }
            System.out.println();
        }

    }
}