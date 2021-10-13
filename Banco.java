package Banco;

public class Banco {
	
	String nombre;
	int dni;
	float dinero;
	int nCuenta;
	
	public Banco(String iNombre, int iDNI, int iNCuenta, float fDinero) {
		this.nombre = iNombre;
		this.dni = iDNI;
		this.nCuenta = iNCuenta;
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
		return "Banco [nombre=" + nombre + ", dni=" + dni + ", dinero=" + dinero + ", nCuenta=" + nCuenta + "]";
	}
}
