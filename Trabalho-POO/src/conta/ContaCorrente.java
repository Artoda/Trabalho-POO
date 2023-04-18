package conta;

import operador.Cliente;
import java.util.Scanner;

public class ContaCorrente extends Conta {

	Scanner sc = new Scanner(System.in);

	ContasEnum corrente = ContasEnum.CORRENTE;
	private String tipo = corrente.name();
	private int digito = corrente.ordinal();
	public static double taxaSaqDep = 0.10;
	public static double taxaTransf = 0.20;

	public ContaCorrente() {
		super();

	}

	public ContaCorrente(int numero, double saldo, Agencia agencia, Cliente cliente) {
		super(numero, saldo, agencia, cliente);

	}

	public void Saque() {
		try {
			System.out.println("Valor desejado do saque: ");
			double valor = sc.nextDouble();
			if (valor <= this.getSaldo() - taxaSaqDep && valor >= 0) {
				this.setSaldo(this.getSaldo() - valor - taxaSaqDep);
			} else {
				System.out.println("Saldo insuficiente.");
			}
		} catch (Exception e) {
			System.out.println("Valor informado inv�lido.");
		}
	}

	public void Deposito() {
		try {
			System.out.println("Valor desejado do dep�sito: ");
			double valor = sc.nextDouble();
			if (valor >= 0) {
				this.setSaldo(this.getSaldo() + valor - taxaSaqDep);
			} else {
				System.out.println("Valor inv�lido para dep�sito.");
			}
		} catch (Exception e) {
			System.out.println("Valor informado inv�lido.");
		}
	}

	public void Transferir(Conta conta) {
		try {
			System.out.println("Valor da tranfer�ncia: ");
			double valor = sc.nextDouble();
			if (valor <= this.getSaldo() - taxaTransf && valor >= 0) {
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