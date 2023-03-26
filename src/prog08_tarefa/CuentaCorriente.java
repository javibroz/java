
package prog08_tarefa;


public class CuentaCorriente extends CuentaBancaria{
    
    private String listaEntidades;

   

    public String getListaEntidades() {
        return listaEntidades;
    }

    public void setListaEntidades(String listaEntidades) {
        this.listaEntidades = listaEntidades;
    }

    public CuentaCorriente(String listaEntidades, Persona titular, double saldo, String IBAN) {
        super(titular, saldo, IBAN);
        this.listaEntidades = listaEntidades;
    }
    
     @Override
    public String devolverInfoString() {
        return super.devolverInfoString()+ "CuentaCorriente{" + "listaEntidades=" + listaEntidades + '}';
    }
    
}
