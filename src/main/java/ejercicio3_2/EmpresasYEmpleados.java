package ejercicio3_2;

import java.util.*;

public class EmpresasYEmpleados {

    public static void main(String[] args) {

        Scanner ingreso = new Scanner(System.in);

        List <Empresa> empresas = new ArrayList<>();

        int comienzo=0;

        while(comienzo==0) {

            System.out.println("Elija una de las siguientes opciones: \n");
            System.out.println("1. Crear nueva empresa.\n" +
                    "2. Añadir empleado a empresa ya existente.\n" +
                    "3. Listado de empresas.\n" +
                    "4. Listado detallado de empresas y empleados.\n" +
                    "5. Salir\n");

            int opcionElegida=ingreso.nextInt();
            ingreso.nextLine();

            if (opcionElegida==1){

                System.out.print("Ingrese el nombre de la nueva empresa: ");
                String nombre = ingreso.nextLine();
                System.out.print("Ingrese el año de su fundación: ");
                String anio = ingreso.nextLine();
                System.out.println(" ");
                empresas.add(new Empresa(nombre,anio));
                System.out.println("Se ha ingresado una nueva empresa\n");
            }

            else if(opcionElegida==2){

                System.out.print("Ingrese el nombre de la empresa: ");
                String nombre = ingreso.nextLine();

                for (Empresa e : empresas){
                    if (e.nombre.equalsIgnoreCase(nombre)) {

                        System.out.print("Ingrese el nombre del empleado: ");
                        String nombre_empleado = ingreso.nextLine();
                        System.out.print("Ingrese el apellido del empleado: ");
                        String apellido_empleado = ingreso.nextLine();
                        System.out.print("Ingrese la fecha de nacimiento del empleado: ");
                        String fecha_nacimiento_empleado = ingreso.nextLine();
                        System.out.print("Ingrese la fecha del contrato del empleado: ");
                        String fecha_contrato_empleado = ingreso.nextLine();

                        Empleado empleado =
                                new Empleado(nombre_empleado, apellido_empleado, fecha_nacimiento_empleado, fecha_contrato_empleado);

                        e.ingresarEmpleado(empleado);
                    }
                }

            }

            else if(opcionElegida==3){

                System.out.println("A continuación se muestran las empresas ingresadas:\n");

                for(Empresa e :empresas){
                    System.out.println("Empresa: "+e.nombre+", año de fundación: "+e.anioFundacion+"\n");
                }
                System.out.println("Ingrese Enter para continuar");
                ingreso.nextLine();
            }

            else if(opcionElegida==4){

                System.out.println("A continuación se muestran las empresas  y sus empleados:\n");

                String formato="%-15s %-15s %-15s %-15s %-20s %-15s";
                System.out.println(String.format(formato,"EMPRESA", "AÑO FUNDACION", "NOMBRE",
                        "APELLIDO", "FECHA NACIMIENTO","FECHA CONTRATO\n"));

                for(Empresa e :empresas){
                    e.empleados.forEach(x-> System.out.println(String.format(formato,e.nombre,e.anioFundacion,
                            x.nombre, x.apellido, x.fechaNacimiento, x.fechaContrato)) );
                }
                System.out.println(" ");
                System.out.println("Ingrese Enter para continuar");
                ingreso.nextLine();
            }

            else if(opcionElegida==5){

                System.out.println("Sesión finalizada\n");
                System.out.println("Ingrese Enter para continuar");
                ingreso.nextLine();

                comienzo=1;
            }

            else{
                System.out.println("Opción incorrecta\n");
                System.out.println("Ingrese Enter para continuar");
                ingreso.nextLine();
            }
        }
    }
}



class Empresa{

    List <Empleado> empleados= new ArrayList<>();
    String nombre;
    String anioFundacion;

    Empresa(String nombre, String anioFundacion){
        this.nombre=nombre;
        this.anioFundacion=anioFundacion;
    }
    void ingresarEmpleado(Empleado empleado){
        empleados.add(empleado);
    }
}


class Empleado{

    String nombre;
    String apellido;
    String fechaNacimiento;
    String fechaContrato;

    Empleado(String nombre, String apellido, String fechaNacimiento, String fechaContrato){
        this.nombre=nombre;
        this.apellido=apellido;
        this.fechaNacimiento=fechaNacimiento;
        this.fechaContrato=fechaContrato;
    }

}