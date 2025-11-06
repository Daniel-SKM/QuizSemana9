/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quizsemana9;

import java.util.Random;
import javax.swing.JOptionPane;

/**
 *
 * @author dani1
 */
public class tienda {

    private static final int DIAS = 7;
    private final String[] DIAS_SEMANA = {"Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado", "Domingo"};

    private String[] nombresProductos;

    private int[][] ventasSemanales;

    public tienda() {

        this.nombresProductos = new String[]{"Arroz", "Azúcar", "Leche", "Frijoles"};

        int nProductos = nombresProductos.length;
        this.ventasSemanales = new int[DIAS][nProductos];

        generarVentasAleatorias();
    }

    private void generarVentasAleatorias() {
        Random random = new Random();
        for (int i = 0; i < DIAS; i++) {
            for (int j = 0; j < nombresProductos.length; j++) {
                this.ventasSemanales[i][j] = random.nextInt(10);
            }
        }
    }

    public void calcularTotalVentasPorProducto() {
        JOptionPane.showMessageDialog(null, "\n*** 1. Total de Ventas por Producto ***");

        for (int j = 0; j < nombresProductos.length; j++) {
            int totalVentasProducto = 0;
            for (int i = 0; i < DIAS; i++) {
                totalVentasProducto += ventasSemanales[i][j];
            }
            JOptionPane.showMessageDialog(null, nombresProductos[j] + ": " + totalVentasProducto);
        }
    }

    public void determinarDiaConMayoresVentas() {
        int maxVentasDia = -1;
        String diaMaxVentas = "";

        for (int i = 0; i < DIAS; i++) {
            int totalVentasDia = 0;
            for (int j = 0; j < nombresProductos.length; j++) {
                totalVentasDia += ventasSemanales[i][j];
            }

            if (totalVentasDia > maxVentasDia) {
                maxVentasDia = totalVentasDia;
                diaMaxVentas = DIAS_SEMANA[i];
            }
        }

        JOptionPane.showMessageDialog(null, "\n*** 2. Día con Mayores Ventas Totales ***");
        JOptionPane.showMessageDialog(null, "El día con mayores ventas es: **" + diaMaxVentas + "** (Total: " + maxVentasDia + " ventas).");
    }

    public void encontrarProductoMasVendido() {
        int maxVentasProducto = -1;
        String nombreProductoMasVendido = "";

        for (int j = 0; j < nombresProductos.length; j++) {
            int totalVentasProducto = 0;
            for (int i = 0; i < DIAS; i++) {
                totalVentasProducto += ventasSemanales[i][j];
            }
            if (totalVentasProducto > maxVentasProducto) {
                maxVentasProducto = totalVentasProducto;
                nombreProductoMasVendido = nombresProductos[j];
            }
        }

        JOptionPane.showMessageDialog(null, "\n*** 3. Producto Más Vendido de la Semana ***");
        JOptionPane.showMessageDialog(null, "El producto más vendido es: **" + nombreProductoMasVendido + "**, con " + maxVentasProducto + " unidades.");
    }

    public void mostrarMatriz() {
        JOptionPane.showMessageDialog(null, "--- Matriz de Ventas Generada ---");

        JOptionPane.showMessageDialog(null, "Día\t\t");
        for (String producto : nombresProductos) {
            JOptionPane.showMessageDialog(null, producto + "\t");
        }
        JOptionPane.showMessageDialog(null, this);

        for (int i = 0; i < DIAS; i++) {
            System.out.print(DIAS_SEMANA[i] + "\t");
            for (int j = 0; j < nombresProductos.length; j++) {
                JOptionPane.showMessageDialog(null, ventasSemanales[i][j] + "\t\t");
            }
            JOptionPane.showMessageDialog(null, this);
        }
        JOptionPane.showMessageDialog(null, "-------------------------------------------------");
    }
}
    
