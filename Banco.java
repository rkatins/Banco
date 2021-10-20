package Banco;

public class Banco {

    String nombre;
    int dni;
    float dinero;
    int idCuenta;

    public Banco(String iNombre, int iDNI, int iidCuenta, float fDinero) {
        this.nombre = iNombre;
        this.dni = iDNI;
        this.idCuenta = iidCuenta;
        this.dinero = fDinero;
    }

    public float mVerDinero() {
        return dinero;
    }

    public float mIngresarDinero(float IngresarDinero) {
        return dinero += IngresarDinero;
    }

    public float mRetiraraDinero(float RetiraraDinero) {
        return dinero -= RetiraraDinero;
    }

    public boolean mSalir() {
        return false;
    }

    @Override
    public String toString() {
        return "Banco [nombre=" + nombre + ", dni=" + dni + ", dinero=" + dinero + ", idCuenta=" + idCuenta + "]";
    }
}
