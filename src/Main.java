import java.util.Scanner;

public class Main {
	
	Scanner scanner;
	CuentaAhorros cuenta;

	public static void main(String[] args) {
	  Main main = new Main();
	  main.scanner = new Scanner(System.in);
	  boolean exit = false;
	  int opcion = 0;
	  main.inicioCuenta();
	  System.out.println("\nQue desea hacer acontinuacion?");
	  do {
	   System.out.println("\n-----Menu-----\n");
	   System.out.println("Opcion 1: Ingresar");
	   System.out.println("Opcion 2: Retirar");
	   System.out.println("Opcion 3: Extracto");
	   System.out.println("Opcion 4: Salir");
	   opcion = main.scanner.nextInt();
	   
	   switch (opcion) {
	case 1:
		main.ingreso();
		break;
	case 2:
		main.retiro();
		break;
	case 3:
		main.extracto();
		break;
	case 4:
		exit = true;
		System.out.println("Saliendo...");
		break;

	default:
		System.err.println("Opcion incorrecta");
		break;
	}
	} while (!exit);

	}
	//Se inicializa la cuenta con una cantidad inicial y se determina su actividad
	public void inicioCuenta() {
	  float saldo;
	  float tasaAnual = 5;
	  scanner = new Scanner(System.in);
	  System.out.println("Con cuanto saldo desea empezar en su nueva cuenta?");
	  saldo = scanner.nextFloat();
	  cuenta = new CuentaAhorros(saldo,tasaAnual);
	  cuenta.actividad();
	}
	//Metodo para realizar el ingreso
	public void ingreso() {
	  float dinero = 0;
	  System.out.print("Ingrese la cantidad deseada: ");
	  dinero = scanner.nextFloat();
	  cuenta.ingreso(dinero);
	  System.out.println(cuenta.toString());
	}
	//Metodo para realizar el retiro
	public void retiro() {
	  float dinero = 0;
	  System.out.print("Retire la cantidad deseada: ");
	  dinero = scanner.nextFloat();
	  cuenta.retirar(dinero);
	  System.out.println(cuenta.toString());
	}
	//Metodo para realizar el extracto he imprimir la comision
	public void extracto() {
	  cuenta.extracto();
	  System.out.println(cuenta.toString());
	}
}
