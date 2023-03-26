
package prog08_tarefa;


public class CuentaCorrienteEmpresa extends CuentaCorriente {
    private double tipoInteresDescubierto; //solo para cuenta corriente empresa
    private double maximoDescubierto; //solo para cuenta corriente empresa
    private double comisionFijadescubierto;

    public CuentaCorrienteEmpresa(double tipoInteresDescubierto, double maximoDescubierto, double comisionFijadescubierto, String listaEntidades, Persona titular, double saldo, String IBAN) {
        super(listaEntidades, titular, saldo, IBAN);
        this.tipoInteresDescubierto = tipoInteresDescubierto;
        this.maximoDescubierto = maximoDescubierto;
        this.comisionFijadescubierto = comisionFijadescubierto;
    }


    
    

    public double getTipoInteresDescubierto() {
        return tipoInteresDescubierto;
    }

    public void setTipoInteresDescubierto(double tipoInteresDescubierto) {
        this.tipoInteresDescubierto = tipoInteresDescubierto;
    }

    public double getMaximoDescubierto() {
        return maximoDescubierto;
    }

    public void setMaximoDescubierto(double maximoDescubierto) {
        this.maximoDescubierto = maximoDescubierto;
    }

    public double getComisionFijadescubierto() {
        return comisionFijadescubierto;
    }

    public void setComisionFijadescubierto(double comisionFijadescubierto) {
        this.comisionFijadescubierto = comisionFijadescubierto;
    }

    @Override
    public String devolverInfoString() {
        return super.devolverInfoString()+ "CuentaCorrienteEmpresa{" + "tipoInteresDescubierto=" + tipoInteresDescubierto + ", maximoDescubierto=" + maximoDescubierto + ", comisionFijadescubierto=" + comisionFijadescubierto + '}';
    }
    
    
    
    
}
