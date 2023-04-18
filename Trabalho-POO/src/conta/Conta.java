package conta;
import operador.Cliente;

public abstract class Conta {
	int numero;
	double saldo;
	Agencia agencia = new Agencia();
	Cliente cliente = new Cliente(null, null, numero, null);
	
	public Conta(int numero, double saldo, Agencia agencia, Cliente cliente) {
		this.numero = numero;
		this.saldo = saldo;
		this.agencia = agencia;
		this.cliente = cliente;
	}

	public Conta() {
		
	}

    public abstract String getTipoConta();

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
    
    
}