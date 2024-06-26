package ejercicio1lagrange;
import java.util.Scanner;

public class Ejercicio1lagrange {

    // Función para calcular el polinomio base de Lagrange Li(x)
    private static double calcularPolinomioBaseLagrange(double[] x, int i, double valorX) {
        double producto = 1.0;
        for (int j = 0; j < x.length; j++) {
            if (j != i) {
                producto *= (valorX - x[j]) / (x[i] - x[j]);
            }
        }
        return producto;
    }
    
    // Función para realizar la interpolación de Lagrange
    public static double interpolarLagrange(double[] x, double[] y, double valorX) {
        double interpolacion = 0.0;
        for (int i = 0; i < y.length; i++) {
            interpolacion += y[i] * calcularPolinomioBaseLagrange(x, i, valorX);
        }
        return interpolacion;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Pedir al usuario el número de puntos
        System.out.print("Ingrese el numero de puntos conocidos: ");
        int numPuntos = scanner.nextInt();
        
        // Pedir al usuario los puntos conocidos
        double[] x = new double[numPuntos];
        double[] y = new double[numPuntos];
        for (int i = 0; i < numPuntos; i++) {
            System.out.print("Ingrese el valor de x[" + i + "]: ");
            x[i] = scanner.nextDouble();
            System.out.print("Ingrese el valor de y[" + i + "]: ");
            y[i] = scanner.nextDouble();
        }
        
        // Pedir al usuario el valor de x donde desea interpolar
        System.out.print("Ingrese el valor de x donde desea interpolar: ");
        double valorX = scanner.nextDouble();
        
        // Realizar interpolación de Lagrange
        double valorY = interpolarLagrange(x, y, valorX);
        
        // Mostrar resultado
        System.out.println("El valor interpolado de y en x = " + valorX + " es: " + valorY);
        
        scanner.close();
    }
}
/*
Imput
Ingrese el numero de puntos conocidos: 4
Ingrese el valor de x[0]: 7
Ingrese el valor de y[0]: 14
Ingrese el valor de x[1]: 10
Ingrese el valor de y[1]: 21
Ingrese el valor de x[2]: 13
Ingrese el valor de y[2]: 27
Ingrese el valor de x[3]: 16
Ingrese el valor de y[3]: 33
Ingrese el valor de x donde desea interpolar: 9

Ouput
El valor interpolado de y en x = 9.0 es: 18.827160493827158
*/