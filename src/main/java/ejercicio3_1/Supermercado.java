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

    Scanner ingreso= new Scanner(System.in);

    String nombre;
    double precio;
    int cantidad;
    double subTotal;

    void nombre(){
        nombre=ingreso.nextLine();
    }
    void precio(){
        precio=ingreso.nextDouble();
    }
    void cantidad(){
        cantidad=ingreso.nextInt();
    }
    void subTotal(){
        subTotal = precio * cantidad;
    }

}


class Ticket extends LineaTicket{

    List<LineaTicket> lineas = new ArrayList<>();
    double total;

    void cargaProductos(){

        while(true){

            LineaTicket linea = new LineaTicket();

            System.out.print("Ingrese el nombre: ");
            linea.nombre();

            System.out.print("Ingrese el precio: ");
            linea.precio();

            System.out.print("Ingrese la cantidad: ");
            linea.cantidad();

            linea.subTotal();

            lineas.add(linea);

            System.out.println("ingrese '1' si desea continuar o '0' para finalizar");
            int opcion=ingreso.nextInt();
            if(opcion!= 1){
                break;
            }

        }
        total= lineas.stream().mapToDouble(x->x.subTotal).sum();
        this.imprimeTicket();
    }

    void imprimeTicket(){
        String formato="Producto: %-10s  Cantidad: %3d  Total: %6.2f";
        lineas.forEach(linea -> System.out.println(String.format(formato,linea.nombre,linea.cantidad,linea.subTotal)));
        System.out.println(String.format("************* Total de la compra: $%10.2f",total));
    }

}