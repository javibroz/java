
package prog08_tarefa;

import java.util.ArrayList;


public class Banco {
   
    private ArrayList<CuentaBancaria> cuentas;
     public Banco() {
        this.cuentas = new ArrayList<>();
    }
    
// buscaCuenta: Recibe un IBAN y busca la cuenta correspondiente.    
    
    
    public CuentaBancaria buscaCuenta(String IBAN) {
         
         for (CuentaBancaria cuenta: this.cuentas){
             if (cuenta.getIBAN().equalsIgnoreCase(IBAN)){
                 return cuenta;
             }
         }
          return null;        
        }

    //abrirCuenta: recibe por parámetro un objeto CuentaBancaria
    //y lo almacena en la estructura. 
    //Devuelve true o false indicando si la operación se realizó con éxito.  
        
    public boolean abrirCuenta(CuentaBancaria cuenta) {
        
         CuentaBancaria encontrada = this.buscaCuenta(cuenta.getIBAN());
         if (encontrada!= null){
             System.out.println("Ya existe.");
             return false;
         }
        this.cuentas.add(cuenta);
        //System.out.println("Cuenta creada");
        return true;
    }  
   
//listadoCuentas: no recibe parámetro y devuelve un array 
//donde cada elemento es una cadena que representa la información de una cuenta.
public String[] ListadoCuentas() {
    
    String[] infoCuenta = new String[this.cuentas.size()];
        for (int i = 0; i < infoCuenta.length; i++) {
            infoCuenta[i] = this.cuentas.get(i).devolverInfoString();
        }
        return infoCuenta;
}
//informacionCuenta: recibe un iban por parámetro y 
//devuelve una cadena con la información de la cuenta o null si la cuenta no existe.
public String informacionCuenta(String IBAN){
    CuentaBancaria cuenta = this.buscaCuenta(IBAN);
    if (cuenta != null) {
       return cuenta.devolverInfoString();
    }
       return null;     
}

//ingresoCuenta: recibe un iban por parámetro y una cantidad
//e ingresa la cantidad en la cuenta. Devuelve true o false indicando
//si la operación se realizó con éxito.
public boolean ingresoCuenta(String IBAN, double cantidad) {

        CuentaBancaria c = this.buscaCuenta(IBAN);
        if (c != null) {
            c.setSaldo(c.getSaldo() + cantidad);
            return true;
        }
        return false;
    }
 //retiradaCuenta: recibe un iban por parámetro y una cantidad y trata de 
//retirar la cantidad de la cuenta. Devuelve true o false indicando
//si la operación se realizó con éxito.
    public boolean retiradaCuenta(String IBAN, double cantidad) {

        CuentaBancaria cuenta = this.buscaCuenta(IBAN);
        if (cuenta != null) {

            boolean puedeHacerse = false;

            if (cuenta.getSaldo() - cantidad >= 0) {
                puedeHacerse = true;
            }else if(cuenta instanceof CuentaCorrienteEmpresa){
                CuentaCorrienteEmpresa aux = (CuentaCorrienteEmpresa)cuenta;
                if(Math.abs(cuenta.getSaldo() - cantidad) < aux.getMaximoDescubierto()){
                    puedeHacerse = true;
                }
            }

            if(puedeHacerse){
                cuenta.setSaldo(cuenta.getSaldo() - cantidad);
            }

            return puedeHacerse;

        }
        return false;
    }
//obtenerSaldo: Recibe un iban por parámetro y devuelve el saldo
//de la cuenta si existe. En caso contrario devuelve -1.
    public double obtenerSaldo(String IBAN) {
        CuentaBancaria cuenta = this.buscaCuenta(IBAN);
        if (cuenta != null) {
            return cuenta.getSaldo();
        }
        return -1;
    }
//"Eliminar Cuenta Bancaria". A través de esta opción se pedirá el IBAN
//de una cuenta bancaria y se eliminará de la estructura siempre que existe y su saldo sea 0.
    //No se podrán eliminar cuentas con saldo superior a 0.
    
   

    public boolean eliminarCuenta(String IBAN){
        CuentaBancaria cuenta = this.buscaCuenta(IBAN);
        if (cuenta!= null){
            for (CuentaBancaria cuentaElim: this.cuentas){
                if (cuentaElim.getIBAN().equalsIgnoreCase(IBAN) && cuentaElim.getSaldo()==0){
                    this.cuentas.remove(cuenta);
                    return true;
                }
                
            }
        }
        return false;
        
    }
    
    }

 