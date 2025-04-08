import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Empleado> empleados = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int opcion;
        int edadPlanta;
        int edadHoras;
        int horas;

        do {
            System.out.println("\n--- Menú ---");
            System.out.println("1. Registrar empleado de planta");
            System.out.println("2. Registrar empleado por horas");
            System.out.println("3. Mostrar empleados");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer

            switch (opcion) {
                case 1:
                    System.out.print("Nombre: ");
                    String nombrePlanta = scanner.nextLine();
                    System.out.print("Edad: ");
                    edadPlanta = scanner.nextInt();
                    empleados.add(new EmpleadoPlanta(nombrePlanta, edadPlanta));
                    System.out.println("Empleado de planta registrado.");
                    break;

                case 2:
                    System.out.print("Nombre: ");
                    String nombreHoras = scanner.nextLine();
                    System.out.print("Edad: ");
                    edadHoras = scanner.nextInt();
                    System.out.print("Pago por hora: ");
                    double pagoPorHora = scanner.nextDouble();
                    System.out.print("Horas trabajadas: ");
                    horas = scanner.nextInt();
                    empleados.add(new EmpleadoPorHoras(nombreHoras, edadHoras, pagoPorHora, horas));
                    System.out.println("Empleado por horas registrado.");
                    break;


                case 3:
                    System.out.println("\n--- Lista de Empleados ---");
                    for (Empleado e : empleados) {
                        // Mostrar tipo de empleado
                        if (e instanceof EmpleadoPlanta) {
                            System.out.println("Tipo: Empleado de Planta");
                        } else if (e instanceof EmpleadoPorHoras) {
                            System.out.println("Tipo: Empleado por Horas");
                            EmpleadoPorHoras ep = (EmpleadoPorHoras) e; // Cast para acceder a horas
                            System.out.println("Horas trabajadas: " + ep.getHorasTrabajadas());
                        }

                        // Mostrar datos comunes
                        System.out.println("Nombre: " + e.getNombre());
                        System.out.println("Edad: " + e.getEdad());
                        System.out.println("Salario calculado: $" + e.calcularSalario());
                        System.out.println("--------------------------");
                    }



                case 4:
                    System.out.println("Saliendo del sistema...");
                    break;

                default:
                    System.out.println("Opción inválida.");
            }
        } while (opcion != 4);

        scanner.close();
    }
}
