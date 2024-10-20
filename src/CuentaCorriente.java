
public class CuentaCorriente extends Cuenta {
	
	private float sobregiro = 0;

	public CuentaCorriente(float saldo, float tasaAnual) {
		super(saldo, tasaAnual);
	}
	
	
	public void retirar(float dinero) {
	  float aux = 0;
	  aux = super.saldo;
	  super.saldo -= dinero;
	  if(saldo < 0) {
	    sobregiro = dinero - aux;
	  }
	}
	
	@Override
	public void ingreso(float dinero) {
	  if(sobregiro > 0 && dinero >= sobregiro) {
	    sobregiro = 0;
	    dinero -= sobregiro;
	    super.ingreso(dinero);
	  }else if(sobregiro > 0 && dinero < sobregiro) {
	    sobregiro -= dinero;
	  }else if(sobregiro == 0) {
		super.ingreso(dinero);
	  } 
	}
	
	
	public void extracto() {
	  super.extracto();
	}


	@Override
	public String toString() {
		int transaccionesTotales = numIngresos + numRetiros;
		return "CuentaCorriente [sobregiro=" + sobregiro + ", saldo=" + saldo + ", numero de transacciones realizadas=" + transaccionesTotales + ", comision=" + comision + "]";
	}
	
	
}
