package ejercicio3_1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Supermercado {

    public static void main(String[] args) {

        Ticket nuevo = new Ticket();

        nuevo.cargaProductos();

    }
}


class LineaTicket{

    String nombre;
    double precio;
    int cantidad;
    double subTotal;

    public LineaTicket(String nombre, double precio, int cantidad, double subTotal){

        this.nombre=nombre;
        this.precio=precio;
        this.cantidad=cantidad;
        this.subTotal=subTotal;

    }

}


class Ticket {

    Scanner ingreso = new Scanner(System.in);

    List <LineaTicket> linea = new ArrayList<>();

    double total;

    void cargaProductos(){

        while(true){

            System.out.print("Ingrese el nombre: ");
            String nombre=ingreso.nextLine();

            System.out.print("Ingrese el precio: ");
            double precio=ingreso.nextDouble();

            System.out.print("Ingrese la cantidad: ");
            int cantidad=ingreso.nextInt();

            double subTotal=precio*cantidad;

            linea.add(new LineaTicket(nombre, precio, cantidad, subTotal));

            System.out.println("ingrese '1' si desea continuar o '0' para finalizar");

            int opcion=ingreso.nextInt();
            ingreso.nextLine();
            if(opcion!= 1){
                break;
            }

        }
        total= linea.stream().mapToDouble(x->x.subTotal).sum();

        this.imprimeTicket();
    }

    void imprimeTicket(){
        
        String formato="Producto: %-10s  Cantidad: %3d  Total: %6.2f";

        linea.forEach(linea -> System.out.println(String.format(formato,linea.nombre,linea.cantidad,linea.subTotal)));

        System.out.println(String.format("************* Total de la compra: $%10.2f",total));
    }

}