package ejercicio3lineal;
import java.util.Scanner;

public class Ejercicio3lineal {

    //Formula
    public static double interpolar(double x, double x0, double y0, double x1, double y1) {
        return y0 + (x - x0) * (y1 - y0) / (x1 - x0);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Solicitar al usuario que ingrese los valores de los puntos
        System.out.println("Ingrese las coordenadas del primer punto (x0 y0):");
        double x0 = scanner.nextDouble();
        double y0 = scanner.nextDouble();
        
        System.out.println("Ingrese las coordenadas del segundo punto (x1 y1):");
        double x1 = scanner.nextDouble();
        double y1 = scanner.nextDouble();

        // Valor de x para interpolar
        System.out.println("Ingrese el valor de x para interpolar:");
        double x = scanner.nextDouble();

        // Calcular el valor interpolado
        double resultado = interpolar(x, x0, y0, x1, y1);

        // Imprimir el resultado
        System.out.println("El valor interpolado para x = " + x + " es y = " + resultado);
        
        // Cerrar el scanner
        scanner.close();
    }
}
/*
Imput
run:
Ingrese las coordenadas del primer punto (x0 y0):
10
20
Ingrese las coordenadas del segundo punto (x1 y1):
21
30
Ingrese el valor de x para interpolar:
15

Ouput
El valor interpolado para x = 15.0 es y = 24.545454545454547
*/