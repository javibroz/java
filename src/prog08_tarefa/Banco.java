
package prog08_tarefa;

import java.util.HashSet;


public class Banco {
   
    HashSet<CuentaBancaria> cuentas = new HashSet<>();
    
    private CuentaBancaria buscarCuenta(String IBAN) {
         //CuentaBancaria cuenta =null;
         for (CuentaBancaria cuenta: this.cuentas){
             if (cuenta.getIBAN().equalsIgnoreCase(IBAN)){
                 return cuenta;
             }
         }
          return null;        
        }

        
        
    public boolean abrirCuenta(CuentaBancaria cb) {

      
        this.cuentas.add(cb);
        System.out.println("Cuenta creada");
        return true;
    }  
   

public void ListadoCuentas() {
    
    for (CuentaBancaria cb: this.cuentas){
        System.out.println(cb.devolverInfoString());
    }
}

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
        CuentaBancaria cuenta = this.buscarCuenta(IBAN);
        if (cuenta != null) {
            return cuenta.getSaldo();
        }
        return -1;
    }

    
    }

 