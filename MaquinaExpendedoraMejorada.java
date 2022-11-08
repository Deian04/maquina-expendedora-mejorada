public class MaquinaExpendedoraMejorada {
    
    // El precio del billete
    private int precioBillete;
    // La cantidad de dinero que lleva metida el cliente actual
    private int balanceClienteActual;
    // El total de dinero almacenado en la maquina desde su ultimo vaciado
    private int totalDineroAcumulado;
    // El origen del billete
    private String estacionOrigen;
    // El destino del billete
    private String estacionDestino;
    
    private int numeroBilletesVendidos;
    
    private boolean maquinaConPremio;
    
    private int maximoBilletesEnVenta;
    
    /**
     * Crea una maquina expendedora de billetes de tren con el 
     * precio del billete y el origen y destino dados. Se asume que el precio
     * del billete que se recibe es mayor que 0.
     */
    public MaquinaExpendedoraMejorada(int precioDelBillete, String origen, String destino, boolean premios, int billetesmax) {
        precioBillete = precioDelBillete;
        balanceClienteActual = 0;
        totalDineroAcumulado = 0;
        estacionOrigen = origen;
        estacionDestino = destino;
        maquinaConPremio = premios;
        maximoBilletesEnVenta = billetesmax;
    }
    
    public MaquinaExpendedoraMejorada(boolean premios, int billetesmax) {
        precioBillete = 30;
        balanceClienteActual = 0;
        totalDineroAcumulado = 0;
        estacionOrigen = "Leon";
        estacionDestino = "Madrid";
        maquinaConPremio = premios;
        maximoBilletesEnVenta = billetesmax;
    }

    /**
     * Devuelve el precio del billete
     */
    public int getPrecioBillete() {
        return precioBillete;
    }

    /**
     * Devuelve la cantidad de dinero que el cliente actual lleva introducida
     */
    public int getBalanceClienteActual() {
        return balanceClienteActual;
    }

    /**
     * Simula la introduccion de dinero por parte del cliente actual
     */
    public void introducirDinero(int cantidadIntroducida) {
        if (numeroBilletesVendidos != maximoBilletesEnVenta){
            if (cantidadIntroducida > 0) {
                balanceClienteActual = balanceClienteActual + cantidadIntroducida;
            }
            else {
                System.out.println(cantidadIntroducida + " no es una cantidad de dinero valida.");
            }
        }
        else {
            System.out.println("Error, ya se han vendido todos los billetes");
        }
    }
    
    public int vaciarDineroDeLaMaquina() {
        int sumaRetirada = balanceClienteActual + totalDineroAcumulado;
        if (balanceClienteActual == 0){
            totalDineroAcumulado = 0;
        }
        else{
            sumaRetirada = -1;
            System.out.println("Hay una operacion en proceso por lo que no se puede retirar el dinero ahora mismo");
        }
        return sumaRetirada;
    }
    
    /**
     * Imprime un billete para el cliente actual
     */
    public void imprimirBillete() {
        int cantidadDeDineroQueFalta = precioBillete - balanceClienteActual;
        if (numeroBilletesVendidos != maximoBilletesEnVenta){
            if (cantidadDeDineroQueFalta<= 0) {        
                // Simula la impresion de un billete
                System.out.println("##################");
                System.out.println("# Billete de tren:");
                System.out.println("# De " + estacionOrigen + " a " + estacionDestino);
                System.out.println("# " + precioBillete + " euros.");
                System.out.println("##################");
                System.out.println();         
                numeroBilletesVendidos += 1;
                if (numeroBilletesVendidos % 4 == 0 ){
                    if (numeroBilletesVendidos != 0){
                        if (maquinaConPremio == true){
                            double descuento = precioBillete * 0.25;
                            System.out.println("Has recibido un premio de " + descuento + " euros.");
                        }
                    }
                }    
                // Actualiza el total de dinero acumulado en la maquina
                totalDineroAcumulado = totalDineroAcumulado + precioBillete;
                // Reduce el balance del cliente actual dejandole seguir utilizando la maquina
                balanceClienteActual = balanceClienteActual - precioBillete;
                
            }
            else {
                System.out.println("Necesitas introducir " + (cantidadDeDineroQueFalta) + " euros mas!");
                    
            }
        }
        else{
            System.out.println("Error, ya no quedan billetes a la venta en la maquina");
        }
    }
    
    public int getNumeroBilletesVendidos(){
        return numeroBilletesVendidos;
    }
    
    public void imprimirNumeroBilletesVendidos(){
        System.out.println("Se han vendido "+ numeroBilletesVendidos + " billetes.");
    }
    /**
     * Cancela la operacion de compra del cliente actual y le
     * devuelve al cliente el dinero que ha introducido hasta el momento
     */
    public int cancelarOperacionYDevolverDinero() {
        int cantidadDeDineroADevolver;
        cantidadDeDineroADevolver = balanceClienteActual;
        balanceClienteActual = 0;
        return cantidadDeDineroADevolver;
    } 
}
