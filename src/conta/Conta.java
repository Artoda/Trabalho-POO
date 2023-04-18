package conta;
import operador.Cliente;

public abstract class Conta {
	int numero;
	double saldo;
	Cliente cliente = new Cliente();
	
	public Conta(int numero, double saldo, Cliente cliente) {
		this.numero = numero;
		this.saldo = saldo;
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