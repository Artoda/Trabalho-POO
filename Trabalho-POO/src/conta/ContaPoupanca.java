package conta;

import java.util.Scanner;

import operador.Cliente;

public class ContaPoupanca extends Conta {

	Scanner sc = new Scanner(System.in);

	ContasEnum poupanca = ContasEnum.POUPANCA;
	private String tipo = poupanca.name();
	private int digito = poupanca.ordinal();
	public static double rendimento = 0.005;

	public ContaPoupanca() {
		super();

	}

	public ContaPoupanca(int numero, double saldo, Agencia agencia, Cliente cliente) {
		super(numero, saldo, agencia, cliente);

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
			System.out.println("Valor informado inválido.");
		}
	}

	private void Deposito() {
		try {
			System.out.println("Valor desejado do depósito: ");
			double valor = sc.nextDouble();
			if (valor >= 0) {
				this.setSaldo(this.getSaldo() + valor);
			} else {
				System.out.println("Valor inválido para depósito.");
			}
		} catch (Exception e) {
			System.out.println("Valor informado inválido.");
		}
	}

	private void Transferir(Conta conta) {
		try {
			System.out.println("Valor da tranferência: ");
			double valor = sc.nextDouble();
			if (valor <= this.getSaldo() && valor >= 0) {
				conta.setSaldo(conta.getSaldo() + valor);
				this.setSaldo(this.getSaldo() - valor);
			} else {
				System.out.println("Valor inválido");
			}
		} catch (Exception e) {
			System.out.println("Dados ou valores inválidos.");
		}
	}

	@Override
	public String getTipoConta() {
		return null;
	}

}