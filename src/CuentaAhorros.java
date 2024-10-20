
public class CuentaAhorros extends Cuenta {

	private boolean isActiva = false;
	
	public CuentaAhorros(float saldo, float tasaAnual) {
	  super(saldo, tasaAnual);
	}
	//Se inicializa la actividad de la cuenta en base al saldo
	public void actividad() {
	  if(saldo >= 100) {
	    isActiva = true;
	  }else {
		isActiva = false;
		  }
	}
	//Metodo para ingresar segun la actividad
	@Override
	public void ingreso(float dinero) {
	  if(isActiva == true) {
	    super.ingreso(dinero);
	    System.out.println("La operacion se ha completado satisfactoriamente");
	  }else {
		System.err.println("La cuenta esta inactiva");
	  }
	}
	//Metodo para retirar segun la actividad
	@Override
	public void retirar(float dinero) {
	  if(isActiva == true && dinero < saldo) {
        super.retirar(dinero);
	    System.out.println("La operacion se ha completado satisfactoriamente");
	  }else if(isActiva == true && dinero > saldo) {
	    super.retirar(dinero);
	  }else if(isActiva == false) {
		System.err.println("La cuenta esta inactiva");
	  }
	  if(saldo > 100) {
	    isActiva = true;
	  }else {
	    isActiva = false;
	  }
	}
	//Metodo para calcular la comision y el saldo
	@Override
	public void extracto() {
	  if(isActiva == true && numRetiros > 4) {
		comision =(float) 1.5;
		saldo -= (comision * (numRetiros - 4));
	  }
	  if(saldo > 100) {
		isActiva = true;
	    System.out.println("La cuenta sigue activa");
	  }else {
		isActiva = false;
		System.err.println("La cuenta esta inactiva");
	  }
	}
	

	@Override
	public String toString() {
		int transaccionesTotales = numIngresos + numRetiros;
		return "CuentaAhorros [saldo=" + saldo + ", numero de transacciones realizadas=" + transaccionesTotales + ", comision=" + comision + "]";
	}
	
	
	
}
