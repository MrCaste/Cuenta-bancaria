
public class Cuenta {

	protected float saldo;
	protected int numIngresos = 0;
	protected int numRetiros = 0;
	protected float tasaAnual;
	protected float comision = 0;
	
	
	public Cuenta(float saldo, float tasaAnual) {
	  this.saldo = saldo;
	  this.tasaAnual = tasaAnual;
	}
	//Metodo para hacer el ingreso
	public void ingreso(float dinero) {
	  saldo += dinero;
	  numIngresos++;
	}
	//Metodo para retirar dinero
	public void retirar(float dinero) {
	  if(dinero > saldo) {
        System.err.println("No se puede realizar esta operacion, saldo insuficiente");
	  }else {
		saldo -= dinero;
	  }
	  numRetiros++;
	}
	//Calculo del interes
	public void interes() {
	  saldo = saldo *(tasaAnual/100);
	}
	//calculo de la comision con el salario
	public void extracto() {
	  saldo -= comision;
	  interes();
	}

	@Override
	public String toString() {
		return "Cuenta [saldo=" + saldo + ", numIngresos=" + numIngresos + ", numRetiros=" + numRetiros + ", tasaAnual="
				+ tasaAnual + ", comision=" + comision + "]";
	}
	
	
}
