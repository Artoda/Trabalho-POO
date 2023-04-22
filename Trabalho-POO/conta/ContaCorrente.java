package conta;

import operador.Cliente;
import java.util.Scanner;

public class ContaCorrente extends Conta implements Comparable {

	Scanner sc = new Scanner(System.in);

	ContasEnum tipo = ContasEnum.CORRENTE;
	public static double taxaSaqDep = 0.10;
	public static double taxaTransf = 0.20;

	public ContaCorrente() {
		super();

	}

	public ContaCorrente(int numero, double saldo, Cliente cliente) {
		super(numero, saldo, cliente);

	}

	public void Saque(double valor) {
		try {
			if (valor <= this.getSaldo() - taxaSaqDep && valor > 0) {
				this.setSaldo(this.getSaldo() - valor - taxaSaqDep);
			} else {
				System.out.println("Saldo insuficiente.");
			}
		} catch (Exception e) {
			System.out.println("Valor informado invalido.");
		}

	}

	public void Deposito(double valor) {
		try {
			if (valor > 0) {
				this.setSaldo(this.getSaldo() + valor - taxaSaqDep);
			} else {
				System.out.println("Valor invalido para deposito.");
			}
		} catch (Exception e) {
			System.out.println("Valor informado invalido.");
		}
	}

	public void Transferir(Conta conta, double valor) {
		try {
			if (valor <= this.getSaldo() - taxaTransf && valor > 0) {
				conta.setSaldo(conta.getSaldo() + valor);
				this.setSaldo(this.getSaldo() - valor - taxaTransf);
			} else {
				System.out.println("Valor invalido");
			}
		} catch (Exception e) {
			System.out.println("Dados ou valores invalidos.");
		}
	}

	@Override
	public ContasEnum getTipoConta() {
		return tipo;
	}

	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String toString() {
		return "Conta [numero=" + this.getNumero() + ", saldo=" + this.getSaldo() + "]";
	}

}