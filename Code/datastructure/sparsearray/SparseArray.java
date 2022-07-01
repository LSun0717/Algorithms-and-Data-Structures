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
    // 0：无子 1.黑子 2.蓝子
    public static void main(String[] args) {
        //
        int[][] chessBoard = new int[11][11];
        chessBoard[1][2] = 1;
        chessBoard[2][3] = 2;

        for (int[] row : chessBoard) {
            for (int chess : row) {
                System.out.print(chess + " ");
            }
            System.out.println();
        }

        int sum = 0;

        for (int i = 0; i < chessBoard.length; i++) {
            for (int j = 0; j < chessBoard.length; j++) {
                if (chessBoard[i][j] > 0) {
                    sum++;
                }
            }
        }

        System.out.println("棋子数：" + sum);

        int[][] sparseArray = new int[sum + 1][3];

        sparseArray[0][0] = 13;
        sparseArray[0][1] = 13;
        sparseArray[0][2] = sum;

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

        for (int[] row : sparseArray) {
            for (int i : row) {
                System.out.print(i + " ");
            }
            System.out.println();
        }

    }
}