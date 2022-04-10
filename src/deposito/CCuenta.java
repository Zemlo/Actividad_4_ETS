package deposito;

/**
 * <p>Clase CCuenta</p>
 * <p>Esta clase define métodos para operar una cuenta corriente permitiendo ingresos y retiradas
 * de dinero.</p>
 * @author Javier Sánchez Alvarado
 * @version 09/09/2022v1
 */

public class CCuenta {

    private String nombre;
    private String cuenta;
    private double saldo;
    private double tipoInteres;

    /**
     * <p>Constructor por defecto de la clase. Sin parámetros.</p>
     */
    public CCuenta() {
    }

    /**
     * <p>Constructor que permite crear un objeto cuenta a partir del nombre de su titular,
     * número de cuenta, saldo inicial y tipo de interés que se le aplica.</p>
     * @param nom Define el nombre del titular de la cuenta.
     * @param cue Define el número de la cuenta.
     * @param sal Determina el saldo inicial de la cuenta.
     * @param tipo Indica el tipo de interés que le aplica el banco al titular.
     */
    public CCuenta(String nom, String cue, double sal, double tipo) {
        setNombre(nom);
        setCuenta(cue);
        setSaldo(sal);
        setTipoInteres(tipo);
    }

    /**
     * <p>Método que devuelve el nombre del titular de la cuenta.</p>
     * @return El nombre del titular de la cuenta.
     * @since 09/09/2022v1
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * <p>Método que devuelve el número de la cuenta corriente.</p>
     * @return El número de la cuenta corriente.
     * @since 09/09/2022v1
     */
    public String getCuenta() {
        return cuenta;
    }

    /**
     * <p>Método que devuelve el saldo.</p>
     * @return El saldo de la cuenta corriente.
     * @since 09/09/2022v1
     */
    public double getSaldo() {
        return saldo;
    }

    /**
     * <p>Método que devuelve el tipo de interés que da el banco.</p>
     * @return El tipo de interés que aplica la entidiad bancaria.
     * @since 09/09/2022v1
     */
    public double getTipoInteres() {
        return tipoInteres;
    }

    /**
     * <p>Método que permite ponerle un nombre al cliente.</p>
     * @param nombre Nombre del titular de la cuenta.
     * @since 09/09/2022v1
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * <p>Método para darle un valor al atributo cuenta.</p>
     * @param cuenta Número de la cuenta corriente.
     * @since 09/09/2022v1
     */
    public void setCuenta(String cuenta) {
        this.cuenta = cuenta;
    }

    /**
     * <p>Método para darle un valor al atributo saldo.</p>
     * @param saldo Saldo que tiene la cuenta corriente.
     * @since 09/09/2022v1
     */
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    /**
     * <p>Método para darle un valor al atributo tipoInteres.</p>
     * @param tipoInteres Tipo de interés que aplica la entidad bancaria.
     * @since 09/09/2022v1
     */
    public void setTipoInteres(double tipoInteres) {
        this.tipoInteres = tipoInteres;
    }

    /**
     * <p>Método que devuelve el valor del saldo de la cuenta corriente.</p>
     * @return El saldo actualizado de la cuenta corriente.
     * @since 09/09/2022v1
     */
    public double estado() {
        return saldo;
    }

    /**
     * <p>Método que permite ingresar dinero en la cuenta corriente y que comprueba que el valor
     * introducido es un valor positivo y en caso de no serlo genera una excepción.</p>
     * @param cantidad Cantidad de dinero que se ingresa en la cuenta corriente.
     * @throws Exception Genera una excepción si el valor introducido es negativo.
     * @since 09/09/2022v1
     */
    public void ingresar(double cantidad) throws Exception {
        if (cantidad < 0)
            throw new Exception("No se puede ingresar una cantidad negativa");
        setSaldo(getSaldo() + cantidad);
    }

    /**
     * <p>Método que permite sacar dinero de la cuenta corriente y que comprueba que el valor
     * introducido es un valor positivo y que hay suficiente saldo en la cuenta y en caso de no
     * serlo genera una excepción.</p>
     * @param cantidad Cantidad de dinero que se retira de la cuenta corriente.
     * @throws Exception <ul>
     *                     <li>Genera una excepción en el caso de que cantidad &lt;= 0 </li>
     *                     <li>Genera una excepción en el caso de que saldo &lt; cantidad </li>
     *                   </ul>
     * @since 09/09/2022v1
     */
    public void retirar(double cantidad) throws Exception {
        if (cantidad <= 0)
            throw new Exception("No se puede retirar una cantidad negativa");
        if (estado() < cantidad)
            throw new Exception("No se hay suficiente saldo");
        setSaldo(getSaldo() - cantidad);
    }

    /**
     * <p>Método que imprime en la pantalla el saldo y luego llama al método retirar
     * para sacar dinero. Después ejecuta el método ingresar para ingresar dinero en la cuenta
     * corriente.</p>
     * <p>Por último vuelve a imprimir el saldo con el resultado de las operaciones anteriores.
     * Además captura las excepciones generadas en los métodos retirar e ingresar en el caso de
     * que se produzca alguno.</p>
     * <p>No tiene parámetros.</p>
     * @since 09/09/2022v1
     */
    public void operativa_cuenta() {
        float cantidad;

        System.out.println("El saldo actual es: " + estado());

        try {
            cantidad = 2300;
            System.out.println("Retirado de cuenta la cantidad de "+cantidad);
            retirar(cantidad);
        } catch (Exception e) {
            System.out.print("Fallo al retirar");
        }
        try {
            cantidad = 695;
            System.out.println("Ingreso en cuenta de "+cantidad);
            ingresar(cantidad);
        } catch (Exception e) {
            System.out.print("Fallo al ingresar");
        }
        System.out.println("El saldo actual es: " + estado());
    }
}
