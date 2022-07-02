package datastructure.sparsearray;

/**
 * @ClassName SparseArray
 * @Description TODO 稀疏数组<--->二维数组
 * @Author uncle_longgggggg
 * @Date 7/1/2022 9:34 PM
 * @Version 1.0
 */
public class SparseArray {

    // 原始数组大小：11 * 11
    // 数据：    0 1 2
    public static void main(String[] args) {
        // 创建originalArray
        int[][] originalArray = new int[11][11];
        originalArray[1][2] = 1;
        originalArray[2][3] = 2;

        // 查看originalArray
        for (int[] row : originalArray) {
            for (int i : row) {
                System.out.print(i + " ");
            }
            System.out.println();
        }

        // 统计原始数组数据量
        int sum = 0;

        for (int i = 0; i < originalArray.length; i++) {
            for (int j = 0; j < originalArray.length; j++) {
                if (originalArray[i][j] > 0) {
                    sum++;
                }
            }
        }

        System.out.println("数据量：" + sum);

        // 创建稀疏数组
        int[][] sparseArray = new int[sum + 1][3];
        // 对应原始数组row column 数据数量sum
        sparseArray[0][0] = 11;
        sparseArray[0][1] = 11;
        sparseArray[0][2] = sum;

        // 将原始数组中信息及数据保存至稀疏数组中
        int count = 0;
        for (int i = 0; i < originalArray.length; i++) {
            for (int j = 0; j < originalArray.length; j++) {
                if (originalArray[i][j] > 0 && count < sum ) {
                    count++;
                    sparseArray[count][0] = i;
                    sparseArray[count][1] = j;
                    sparseArray[count][2] = originalArray[i][j];
                }
            }
        }

        // 查看稀疏矩阵
        System.out.println("稀疏数组");
        for (int[] row : sparseArray) {
            for (int i : row) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
        
        // 从sparseArray中获取originalArray的row和column
        int targetArrayRow = sparseArray[0][0];
        int targetArrayColumn = sparseArray[0][1];
        int elementNum = sparseArray[0][2];
        // 创建目标数组
        int[][] targetArray = new int[targetArrayRow][targetArrayColumn];
        // 恢复数据
        for (int i = 1; i < sparseArray.length; i++) {
            targetArray[sparseArray[i][0]][sparseArray[i][1]] = sparseArray[i][2];
        }

        System.out.println("目标数组");
        // 查看恢复后数据
        for (int[] row : targetArray) {
            for (int i : row) {
                System.out.print(i + " ");
            }
            System.out.println();
        }

    }
}