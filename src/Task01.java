public class Task01 {

    // Создание единичной (диагональной) матрицы
    public static double[][] createIdentityMatrix(int size) {
        double[][] matrix = new double[size][size];
        for (int i = 0; i < size; i++) {
            matrix[i][i] = 1.0;
        }
        return matrix;
    }

    // Создание нулевой матрицы
    public static double[][] createZeroMatrix(int size) {
        return new double[size][size];
    }

    // Сложение матриц
    public static double[][] addMatrices(double[][] a, double[][] b) {
        int size = a.length;
        double[][] result = new double[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                result[i][j] = a[i][j] + b[i][j];
            }
        }
        return result;
    }

    // Умножение матриц
    public static double[][] multiplyMatrices(double[][] a, double[][] b) {
        int size = a.length;
        double[][] result = new double[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                for (int k = 0; k < size; k++) {
                    result[i][j] += a[i][k] * b[k][j];
                }
            }
        }
        return result;
    }

    // Умножение матрицы на скаляр
    public static double[][] multiplyMatrixByScalar(double[][] matrix, double scalar) {
        int size = matrix.length;
        double[][] result = new double[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                result[i][j] = matrix[i][j] * scalar;
            }
        }
        return result;
    }

    // Определение детерминанта матрицы (рекурсивный метод)
    public static double determinant(double[][] matrix) {
        int size = matrix.length;

        // Базовые случаи
        if (size == 1) {
            return matrix[0][0];
        }
        if (size == 2) {
            return matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0];
        }

        double det = 0;
        for (int j = 0; j < size; j++) {
            double[][] minor = getMinor(matrix, 0, j);
            det += matrix[0][j] * Math.pow(-1, j) * determinant(minor);
        }
        return det;
    }

    // Получение минора матрицы
    private static double[][] getMinor(double[][] matrix, int row, int col) {
        int size = matrix.length;
        double[][] minor = new double[size - 1][size - 1];
        int minorRow = 0;

        for (int i = 0; i < size; i++) {
            if (i == row) continue;
            int minorCol = 0;
            for (int j = 0; j < size; j++) {
                if (j == col) continue;
                minor[minorRow][minorCol] = matrix[i][j];
                minorCol++;
            }
            minorRow++;
        }
        return minor;
    }

    // Вывод матрицы на консоль
    public static void printMatrix(double[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.printf("%8.2f", matrix[i][j]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {

        // Создание и вывод единичной матрицы
        System.out.println("Единичная матрица 3x3:");
        double[][] identity = createIdentityMatrix(3);
        printMatrix(identity);

        // Создание и вывод нулевой матрицы
        System.out.println("\nНулевая матрица 3x3:");
        double[][] zero = createZeroMatrix(3);
        printMatrix(zero);

        // Тестовые матрицы для операций
        double[][] matrixA = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        double[][] matrixB = {
                {9, 8, 7},
                {6, 5, 4},
                {3, 2, 1}
        };

        System.out.println("\nМатрица A:");
        printMatrix(matrixA);

        System.out.println("\nМатрица B:");
        printMatrix(matrixB);

        // Сложение матриц
        System.out.println("\nСложение A + B:");
        double[][] sum = addMatrices(matrixA, matrixB);
        printMatrix(sum);

        // Умножение матриц
        System.out.println("\nУмножение A * B:");
        double[][] product = multiplyMatrices(matrixA, matrixB);
        printMatrix(product);

        // Умножение на скаляр
        System.out.println("\nУмножение A на 2:");
        double[][] scaled = multiplyMatrixByScalar(matrixA, 2);
        printMatrix(scaled);

        // Определитель
        double[][] testDetMatrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 10}
        };
        System.out.println("\nМатрица для определителя:");
        printMatrix(testDetMatrix);
        System.out.printf("Детерминант: %.2f\n", determinant(testDetMatrix));
    }
}