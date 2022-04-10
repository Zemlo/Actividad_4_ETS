package deposito;

/**
 * Clase que engloba los métodos de inicio del programa.
 */
public class Main {

    /**
     * Los argumentos de la línea de comandos que normalmente se pasarían al programa javac como
     * se describe en la página man.
     * @param args Argumentos de línea de comandos.
     */
    public static void main(String[] args) {

        CCuenta cuenta1;

        cuenta1 = new CCuenta("Antonio López", "1000-2365-85-1230456789", 2500, 0);

        cuenta1.operativa_cuenta();

    }
}
