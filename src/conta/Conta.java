package conta;
import operador.Cliente;

public abstract class Conta {
	
	int numero;
	double saldo;
	//Tipo Enum
	int agencia;
	Cliente cliente = new Cliente();
	
	 public Conta(int numero, double saldo, Cliente cliente) {
		this.numero = numero;
		this.saldo = saldo;
		this.cliente = cliente;
	} 
	 
	 public Conta() {
	 }
	
	 

}

	
