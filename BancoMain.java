package Banco;

import java.util.ArrayList;
import java.util.Scanner;

public class BancoMain {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
//		Banco cuenta0 = new Banco("NOMBRE", DNI, ID, DINERO);
        Banco cuenta1 = new Banco("j", 501, 1, 50);
        Banco cuenta2 = new Banco("m", 502, 2, 50);
//        Banco cuenta3 = new Banco("r", 503, 3, 50);

		ArrayList<Banco> cuentas = new ArrayList<Banco>();

//        cuentas.clear();
        cuentas.add(cuenta1);
        cuentas.add(cuenta2);
//        cuentas.add(cuenta3);

		cliente(cuentas);
//        administrador(cuentas);
	}

	public static void mBienveniada(Banco cuenta) {
		System.out.println("\nBienvenido " + cuenta.nombre + "\n--------\n");
	}

	public static void cliente(ArrayList<Banco> cuentas) {
		int dni;

		System.out.println("Introduce DNI: ");
		dni = sc.nextInt();
		sc.nextLine();

		Banco cuentaux = null;

		for (int i = 0; i < cuentas.size(); i++) {
			if (cuentas.get(i).dni == dni) {
				cuentaux = cuentas.get(i);
			}
		}

		if (cuentaux == null) {
			System.out.println("Tu cuenta no existe");
		} else {
			mBienveniada(cuentaux);
			clienteAceptado(cuentaux, cuentas);
		}
	}

	public static void clienteAceptado(Banco cuentaux, ArrayList<Banco> cuentas) {
		int opcion = 1;

		while (opcion != 0) {
			System.out.println("1. Ver saldo " + "\n" + "2. Ingresar dinero " + "\n" + "3. Retirar dinero" + "\n"
					+ "4. Transferencia");
			opcion = sc.nextInt();sc.nextLine();

			switch (opcion) {
				case 1: {
					System.out.println("\n--------\n" + "VER SALDO");
					System.out.println(cuentaux.mVerDinero());
					System.out.println("\n--------\n");
					break;
				}
	
				case 2: {
					System.out.println("\n--------\n" + "INGRESAR DINERO");
					float dineroIngresado = 0;
	
					System.out.println("¿Cuanto dinero deseas ingresar?");
					dineroIngresado = sc.nextFloat();
					sc.nextLine();
	
					if (dineroIngresado >= 0.01) {
						cuentaux.mIngresarDinero(dineroIngresado);
					} else {
						System.out.println("Operacion no valida");
					}
					System.out.println("\n--------\n");
					break;
				}
	
				case 3: {
					System.out.println("\n--------\n" + "RETIRAR DINERO");
					float dineroRetirado = 0;
	
					System.out.println("¿Cuanto dinero deseas retirar?");
					dineroRetirado = sc.nextFloat();
					sc.nextLine();
					if (dineroRetirado >= 0.01) {
						cuentaux.mRetiraraDinero(dineroRetirado);
	
						if (cuentaux.dinero - dineroRetirado < 0) {
							System.out.println("Operacion no valida, no te puedes quedar en negativo");
						}
					} else {
						System.out.println("Operacion no valida");
					}
					System.out.println("\n--------\n");
					break;
				}
	
				case 4: {
					Banco cuentaTransferencia = null;
	
					float dineroTransferencia = 0;
					int idCuentaTransferencia;
	
					System.out.println("\n--------\n" + "TRANSFERENCIA");
	
					if (cuentas.size() < 2) {
						System.out.println("No se puede realizar la transferencia" + "\n" + "PD: CUENTAS INSUFICIENTES");
					} else {
						System.out.println("Introduce el ID de cuenta al que quieres hacer la transferencia: ");
						idCuentaTransferencia = sc.nextInt();sc.nextLine();
						
						for (int i = 0; i < cuentas.size(); i++) {
							if (cuentas.get(i).idCuenta == idCuentaTransferencia) {
								cuentaTransferencia = cuentas.get(i);
							}
						}

						if (cuentaTransferencia == null) {
							System.out.println("Tu cuenta no existe");
						} else {
							System.out.println("¿Cuanto dinero deseas transferir a la cuenta con DNI: " + idCuentaTransferencia + "?");
						dineroTransferencia = sc.nextFloat();sc.nextLine();
						
//						System.out.println("ANTES TRANSFERENCIA: \n" + cuentaux.nombre + " " + cuentaux.dinero + "€" + "\n" + cuentaTransferencia.nombre + " " + cuentaux.dinero + "€");
						
							if (cuentaux.dinero - dineroTransferencia < 0) {
								System.out.println("Operacion no valida, no te puedes quedar en negativo");
							} else {
								cuentaux.mRetiraraDinero(dineroTransferencia);
								cuentaTransferencia.mIngresarDinero(dineroTransferencia);
								System.out.println("Intercambio de dinero realiado");
							}
//						System.out.println("DESPUES TRANSFERENCIA: \n" + cuentaux.nombre + " " + cuentaux.dinero + "€" + "\n" + cuentaTransferencia.nombre + " " + cuentaTransferencia.dinero + "€");
						}
					}
					System.out.println("\n--------\n");
					break;
				}
			}
		}
	}

	public static void mBorraCuenta(ArrayList<Banco> cuentas) {
		int idCuenta;
		System.out.println("Dime id de cuenta: ");
		idCuenta = sc.nextInt();
		sc.nextLine();
		boolean existe = false;

		for (int i = 0; i < cuentas.size(); i++) {
			if (cuentas.get(i).idCuenta == idCuenta) {
				cuentas.remove(i);
				System.out.println("Cuenta borrada");

				existe = true;
			}

			if (!existe) {
				System.out.println("Cuenta no existe");
			}
		}
	}

	public static void mModificarCuenta(ArrayList<Banco> cuentas) {
		int numIDCuenta;
		boolean existe = false;

		System.out.println("Dime id cuenta:");
		numIDCuenta = sc.nextInt();
		sc.nextLine();

		for (int i = 0; i < cuentas.size(); i++) {
			if (cuentas.get(i).idCuenta == numIDCuenta) {
				System.out.println("Introduce nuevo nombre");
				String nombreNuevo = sc.nextLine();

				existe = true;

				cuentas.get(i).nombre = nombreNuevo;
			}

			if (!existe) { //
				System.out.println("Cuenta no existe");
			}
		}
	}

	public static void mCrearCuenta(ArrayList<Banco> cuentas) {
		Banco cuenta;
		int cuentasCreadas = 0;

		System.out.println("¿Cuantas cuentas nuevas deseas crear?");
		int numCuentas = sc.nextInt();
		sc.nextLine();

		for (int i = 0; i < numCuentas; i++) {
			cuentas.add(cuenta = new Banco("USUARIO", 500 + i, i + 1, 0));
			cuentasCreadas++;
		}

		System.out.println(cuentasCreadas + " cuentas creadas con satisfactoriamentes");
	}

	public static void mVerCuenta(ArrayList<Banco> cuentas) {
		for (int i = 0; i < cuentas.size(); i++) {
			System.out.println(cuentas.get(i) + "\n");
		}
	}

	public static void administrador(ArrayList<Banco> cuentas) {
		int opcion = 1;
		while (opcion != 0) {
			System.out.println("1. Borrar " + "\n" + "2. Modificar Nombre" + "\n" + "3. Crear" + "\n" + "4. Ver Cuentas"
					+ "\n" + "0. Salir");
			opcion = sc.nextInt();
			sc.nextLine();

			switch (opcion) {
			case 1: {
				System.out.println("\n--------\n" + "BORRAR\n");
				mBorraCuenta(cuentas);
				System.out.println("\n--------\n");
				break;
			}
			case 2: {
				System.out.println("\n--------\n" + "MODIFICAR NOMBRE\n");
				mModificarCuenta(cuentas);
				System.out.println("\n--------\n");
				break;
			}
			case 3: {
				System.out.println("\n--------\n" + "CREAR\n");
				mCrearCuenta(cuentas);
				System.out.println("\n--------\n");
				break;
			}
			case 4: {
				System.out.println("\n--------\n" + "VER CUENTAS\n");
				mVerCuenta(cuentas);
				System.out.println("\n--------\n");
				break;
			}
			case 0: {
				break;
			}
			}
		}
	}
}