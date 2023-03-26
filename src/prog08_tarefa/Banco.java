
package prog08_tarefa;

import java.util.HashSet;


public class Banco {
    
    // private CuentaBancaria[] cuentas;
    //private final int MAX_CUENTAS = 100;
   // private int cantidadCuentas;
    HashSet<CuentaBancaria> cuentas = new HashSet<>();

    public Banco() {
    }

   
     
            
    
    //public Banco(){
        //this.cuentas = new CuentaBancaria[this.MAX_CUENTAS];
        //this.cantidadCuentas = 0; 
        
    //}

     private CuentaBancaria buscarCuenta(String IBAN) {
         for (CuentaBancaria cuenta: cuentas){
             if (cuenta.getIBAN().compareTo(IBAN)){
                 return cuenta;
             }
         }
                  
//        for (int i = 0; i < this.cantidadCuentas; i++) {
//            if (this.cuentas[i].getIBAN().equals(IBAN)) {
//                return this.cuentas[i];  
//            }
//        }
        return null;
    }
    
    
    public boolean abrirCuenta(CuentaBancaria cb) {

//        if (this.cantidadCuentas == this.MAX_CUENTAS) {
//            System.out.println("No caben más cuentas"); // si hay 100 o más
//            return false;
//        
//        }
//        
//        CuentaBancaria nuevoIBAN = this.buscarCuenta(cb.getIBAN());
//        if (nuevoIBAN!=null){
//            System.out.println("Ya existe");
//            return false;
//            
//        }
//         this.cuentas[this.cantidadCuentas] = cb;
//        this.cantidadCuentas++;
        return true;
    }  
   

//public String[] ListadoCuentas() {
//    String[]infoCuentas = new String[this.cantidadCuentas];
//    for (int i = 0; i < this.cantidadCuentas; i++) {
//        infoCuentas[i] = this.cuentas[i].devolverInfoString();
//    }
//    return infoCuentas;
//    
//    }
public String informacionCuenta(String IBAN){
    CuentaBancaria cb = this.buscarCuenta(IBAN);
    if (cb != null) {
       return cb.devolverInfoString();
    }
       return null;     
}
public boolean ingresoCuenta(String IBAN, double cantidad) {

        CuentaBancaria c = this.buscarCuenta(IBAN);
        if (c != null) {
            c.setSaldo(c.getSaldo() + cantidad);
            return true;
        }
        return false;
    }

    public boolean retiradaCuenta(String IBAN, double cantidad) {

        CuentaBancaria c = this.buscarCuenta(IBAN);
        if (c != null) {

            boolean sePuedeRetirar = false;

            if (c.getSaldo() - cantidad > 0) {
                sePuedeRetirar = true;
            }else if(c instanceof CuentaCorrienteEmpresa){
                CuentaCorrienteEmpresa aux = (CuentaCorrienteEmpresa)c;
                if(Math.abs(c.getSaldo() - cantidad) < aux.getMaximoDescubierto()){
                    sePuedeRetirar = true;
                }
            }

            if(sePuedeRetirar){
                c.setSaldo(c.getSaldo() - cantidad);
            }

            return sePuedeRetirar;

        }
        return false;
    }

    public double obtenerSaldo(String IBAN) {
        CuentaBancaria c = this.buscarCuenta(IBAN);
        if (c != null) {
            return c.getSaldo();
        }
        return -1;
    }

    
    }

 