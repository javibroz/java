
package prog08_tarefa;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;




public class Principal {

    
    
    public static void main(String[] args) {
        
               String nombreTitular, apellidosTitular, DNITitular;
        String IBAN = "";
        String listaAutorizadas, infoCuenta;
        String[] listaCuentas;
       // ArrayList<CuentaBancaria> cuenta = new ArrayList<>();
        Persona titular = null;
        double saldo = 0;
        double tipoInteres, comisionMantenimiento, tipoInteresDescubierto, maxDescubierto, comisionDescubierto, cantidad;
        boolean salir = false;
        Banco banco = new Banco();
        CuentaBancaria cuenta = null;
        int tipoCuenta;

        Scanner sc = new Scanner(System.in);
        //int opcion = 0;
        
        do {
            
        try {
            System.out.println("*******************************************");
            System.out.println("  OPCIONES:");
            System.out.println("1. Abrir una nueva cuenta");
            System.out.println("2. Ver un listado de las cuentas disponibles");
            System.out.println("3. Obtener los datos de una cuenta concreta");
            System.out.println("4. Realizar un ingreso en una cuenta");
            System.out.println("5. Retirar efectivo de una cuenta");
            System.out.println("6. Consultar el saldo actual de una cuenta");
            System.out.println("7. Eliminar cuenta");
            System.out.println("8. Salir de la aplicacion");
            System.out.println(" ");
            System.out.print("Introduce una opcion: ");
            
            
             int   opcion = sc.nextInt();
                sc.nextLine();
               
                switch(opcion) {
                    case 1:
                        System.out.println("Nombre: ");
                        nombreTitular = sc.next();
                        System.out.println("Apellidos: ");
                        apellidosTitular= sc.next();
                                
                        System.out.println("DNI: ");
                        DNITitular= sc.next();
                        if (!DNITitular.matches("^[0-9]{8}[A-Z]$")){
                        throw new Exception(" DNI incorrecto");
                    }
                         titular = new Persona(nombreTitular,apellidosTitular,DNITitular);
                         
                        System.out.println("IBAN: ");
                        IBAN= sc.next();
                        if (!IBAN.matches("^ES[0-9]{20}$")) {
                        throw new Exception(" IBAN incorrecto");
                        } 
                        
                        System.out.println("Saldo inicial: ");  
                        saldo= sc.nextDouble();
                        System.out.println("Tipo de cuenta: ");
                        System.out.println("1. Cuenta ahorro");
                        System.out.println("2. Cuenta corriente personal");
                        System.out.println("3. Cuenta corriente empresa");
                        tipoCuenta = sc.nextInt();
                        
                        switch (tipoCuenta) {
                        
                        case 1:
                                System.out.println("Tipo de interés: ");
                                tipoInteres = sc.nextDouble();
                                cuenta= new CuentaAhorro(tipoInteres, titular,saldo,IBAN);
                               System.out.println(" Se creó la cuenta: "+ cuenta.devolverInfoString());
                                break;                   
                                                             
                        case 2:
                        System.out.println("Lista de entidades autorizadas:");
                                listaAutorizadas = sc.next();
                                System.out.println(" Comision de mantenimiento:");
                                comisionMantenimiento = sc.nextDouble();
                                cuenta = new CuentaCorrientePersonal(comisionMantenimiento, listaAutorizadas, titular, saldo, IBAN);
                                break;
                        case 3:
                                System.out.println("Lista de entidades autorizadas:");
                                listaAutorizadas = sc.next();
                                System.out.println(" Tipo de interes por descubierto:");
                                tipoInteresDescubierto = sc.nextDouble();
                                System.out.println("Máximo descubierto permitido: ");
                                maxDescubierto = sc.nextDouble();
                                System.out.println("Comisión  por descubierto");
                                comisionDescubierto = sc.nextDouble();
                                cuenta = new CuentaCorrienteEmpresa(maxDescubierto, tipoInteresDescubierto, comisionDescubierto, listaAutorizadas, titular, saldo, IBAN);
                                break;
                         default:
                                throw new Exception(" Elige un tipo de cuenta");
                        }

                        if (banco.abrirCuenta(cuenta)) {
                            System.out.println("Cuenta creada.");
                           
                        } else {
                            System.out.println("No se ha creado la cuenta.");
                        }

                        break;
                    case 2:
                         listaCuentas = banco.listadoCuentas();
                        for (int i = 0; i < listaCuentas.length; i++) {
                            System.out.println(listaCuentas[i]);
                        }
                        break;
                        
                        
                        
                    case 3:
                        System.out.println("Introduce el IBAN");
                        IBAN = sc.next();

                        infoCuenta = banco.informacionCuenta(IBAN);
                        if (infoCuenta != null) {
                            System.out.println(infoCuenta);
                        } else {
                            System.out.println("La cuenta no existe");
                        }

                        break;
                    case 4:
                        System.out.println("Introduce el IBAN");
                        IBAN = sc.next();

                        System.out.println("Introduce una cantidad");
                        cantidad = sc.nextDouble();

                        if (banco.ingresoCuenta(IBAN, cantidad)) {
                            System.out.println("El ingreso se hizo correctamente");
                        } else {
                            System.out.println("El ingreso no se hizo correctamente");
                        }
                        break;
                    case 5:
                        System.out.println("Introduce el IBAN");
                        IBAN = sc.next();

                        System.out.println("Introduce una cantidad");
                        cantidad = sc.nextDouble();

                        if (banco.retiradaCuenta(IBAN, cantidad)) {
                            System.out.println("La retirada se hizo correctamente");
                        } else {
                            System.out.println("La retirada no se hizo correctamente");
                        }
                        break;
                    case 6:
                        System.out.println("Introduce el IBAN");
                        IBAN = sc.next();

                        saldo = banco.obtenerSaldo(IBAN);
                        if (saldo != -1) {
                            System.out.println("El saldo es: " + saldo);
                        } else {
                            System.out.println("La cuenta no existe");
                        }
                        break;
                        case 7:
                        System.out.println("Introduce el IBAN de la cuenta a eliminar:");
                        IBAN = sc.next();

                        if (banco.eliminarCuenta(IBAN)){
                            System.out.println("Se eliminó");
                        }else{
                            System.out.println("No se eliminó");
                        }
                        
                        
                        break;
                        case 8:
                        salir = true;
                        break;
                   
                }
                
            } catch (InputMismatchException e) {
                sc.next();
            } catch (Exception e) {
                System.out.println("Error" + e.getMessage());
            }
            }
        
         while (salir == false); 
        
        }
         
        
       
    }
    
 
        
      
   
