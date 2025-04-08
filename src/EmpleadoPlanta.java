public class EmpleadoPlanta extends Empleado {
    private static double SALARIO_FIJO = 2100000;

    public EmpleadoPlanta(String nombre, int edad) {
        super(nombre, edad);
    }

    @Override
    public double calcularSalario() {
        return SALARIO_FIJO;
    }
}

