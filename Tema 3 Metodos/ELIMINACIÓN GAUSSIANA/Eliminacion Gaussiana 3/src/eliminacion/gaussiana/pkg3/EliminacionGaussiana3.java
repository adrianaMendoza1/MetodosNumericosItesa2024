package eliminacion.gaussiana.pkg3;

public class EliminacionGaussiana3 {
    // Función para imprimir una matriz
    public static void printMatrix(double[][] matrix) {
        int rows = matrix.length; // Número de filas
        int cols = matrix[0].length; // Número de columnas
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(matrix[i][j] + "\t"); // Imprimir cada elemento separado por tabulación
            }
            System.out.println(); // Salto de línea al finalizar una fila
        }
    }

    // Función para realizar la eliminación gaussiana
    public static double[] gaussianElimination(double[][] matrix) {
        int n = matrix.length; // Número de ecuaciones (filas)

        // Fase de eliminación
        for (int i = 0; i < n; i++) {
            // Buscar el máximo elemento en la columna actual (pivoteo parcial)
            int maxRowIndex = i;
            for (int k = i + 1; k < n; k++) {
                if (Math.abs(matrix[k][i]) > Math.abs(matrix[maxRowIndex][i])) {
                    maxRowIndex = k; // Actualizar la fila con el valor máximo
                }
            }

            // Intercambiar filas si es necesario
            double[] temp = matrix[i];
            matrix[i] = matrix[maxRowIndex];
            matrix[maxRowIndex] = temp;

            // Hacer ceros por debajo del pivote en la columna actual
            for (int k = i + 1; k < n; k++) {
                double factor = matrix[k][i] / matrix[i][i]; // Calcular el factor de eliminación
                for (int j = i; j < n + 1; j++) {
                    matrix[k][j] -= factor * matrix[i][j]; // Restar el múltiplo de la fila
                }
            }
        }

        // Fase de sustitución regresiva para resolver el sistema triangular superior
        double[] solution = new double[n]; // Arreglo para almacenar la solución
        for (int i = n - 1; i >= 0; i--) {
            solution[i] = matrix[i][n] / matrix[i][i]; // Despejar la incógnita
            for (int k = i - 1; k >= 0; k--) {
                matrix[k][n] -= matrix[k][i] * solution[i]; // Ajustar los términos independientes
            }
        }

        return solution; // Devolver la solución del sistema
    }

    public static void main(String[] args) {
        // Definir la matriz aumentada del sistema de ecuaciones
        double[][] augmentedMatrix = {
            {5, 3, 2.5, 9, 21},   // 5x1 + 3x2 + 2.5x3 + 9x4 = 21
            {-3, 0, 2, 15, 0},    // -3x1 + 0x2 + 2x3 + 15x4 = 0
            {2, 8, 2.2, 9, 10},   // 2x1 + 8x2 + 2.2x3 + 9x4 = 10
            {1, 0, 2, 1, 0},      // 1x1 + 0x2 + 2x3 + 1x4 = 0
        };

        // Resolver el sistema de ecuaciones
        double[] solution = gaussianElimination(augmentedMatrix);

        // Imprimir la solución
        System.out.println("La solucion del sistema de ecuaciones es:");
        for (int i = 0; i < solution.length; i++) {
            System.out.println("x" + (i + 1) + " = " + solution[i]);
        }
    }
}
