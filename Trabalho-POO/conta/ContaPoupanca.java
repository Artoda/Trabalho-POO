package conta;

import java.util.Scanner;

import operador.Cliente;

public class ContaPoupanca extends Conta {

	Scanner sc = new Scanner(System.in);

	ContasEnum tipo = ContasEnum.POUPANCA;
	public static double rendimento = 0.005;

	public ContaPoupanca() {
		super();
	}

	public ContaPoupanca(int numero, double saldo, Cliente cliente) {
		super(numero, saldo, cliente);
	}

	public void Saque(double valor) {
		try {
			if (valor <= this.getSaldo() && valor > 0) {
				this.setSaldo(this.getSaldo() - valor);
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
				this.setSaldo(this.getSaldo() + valor);
			} else {
				System.out.println("Valor invalido para dep�sito.");
			}
		} catch (Exception e) {
			System.out.println("Valor informado invalido.");
		}
	}

	public void Transferir(Conta conta, double valor) {
		try {
			if (valor <= this.getSaldo() && valor > 0) {
				conta.setSaldo(conta.getSaldo() + valor);
				this.setSaldo(this.getSaldo() - valor);
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
	public String toString() {
		return "Conta [numero=" + this.getNumero() + ", saldo=" + this.getSaldo() + "]";
	}

}