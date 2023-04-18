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

	private void Saque() {
		try {
			System.out.println("Valor desejado do saque: ");
			double valor = sc.nextDouble();
			if (valor <= this.getSaldo() && valor >= 0) {
				this.setSaldo(this.getSaldo() - valor);
			} else {
				System.out.println("Saldo insuficiente.");
			}
		} catch (Exception e) {
			System.out.println("Valor informado inv�lido.");
		}
	}

	private void Deposito() {
		try {
			System.out.println("Valor desejado do dep�sito: ");
			double valor = sc.nextDouble();
			if (valor >= 0) {
				this.setSaldo(this.getSaldo() + valor);
			} else {
				System.out.println("Valor inv�lido para dep�sito.");
			}
		} catch (Exception e) {
			System.out.println("Valor informado inv�lido.");
		}
	}

	private void Transferir(Conta conta) {
		try {
			System.out.println("Valor da tranfer�ncia: ");
			double valor = sc.nextDouble();
			if (valor <= this.getSaldo() && valor >= 0) {
				conta.setSaldo(conta.getSaldo() + valor);
				this.setSaldo(this.getSaldo() - valor);
			} else {
				System.out.println("Valor inv�lido");
			}
		} catch (Exception e) {
			System.out.println("Dados ou valores inv�lidos.");
		}
	}

	@Override
	public String getTipoConta() {
		return null;
	}

}