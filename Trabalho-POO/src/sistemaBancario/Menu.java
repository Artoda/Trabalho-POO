package sistemaBancario;

import java.util.Scanner;

public class Menu

{
	public int escolha = 0;
	String cpf;
	String senha;

	Scanner read = new Scanner(System.in);

	public void MenuPrincipal()

	{
		System.out.println("------------------------------------------------------------------");
		System.out.println("---------------------   Sistema Banc�rio  ------------------------");
		System.out.println("------------------------------------------------------------------\n");

		System.out.print("Digite seu CPF: ");
		cpf = read.next();

		System.out.print("Digite sua senha: ");
		senha = read.next();

		validarCadastro();
	}

	public void validarCadastro()

	{

		if ((cpf.equals("cliente") && senha.equals("cliente"))) {

			menuCliente();

		} else if ((cpf.equals("gerente") && senha.equals("gerente"))) {

			menuGerente();

		} else if ((cpf.equals("diretor") && senha.equals("diretor"))) {

			menuDiretor();

		} else if ((cpf.equals("presidente") && senha.equals("presidente"))) {

			menuPresidente();
		}

		else {

			System.out.println("CPF ou senha n�o cadastrados!");
			System.out.println("Tente novamente!");

			MenuPrincipal();

		}

	}

	public void menuCliente() {

		do {

			System.out.println("Escolha uma op��o: ");
			System.out.println("1 - Movimenta��es na Conta");
			System.out.println("2 - Relat�rios");
			System.out.println("3 - Sair");
			escolha = read.nextInt();

			switch (escolha) {
			case 1:

				break;
			case 2:

				break;

			case 3:

				System.out.println("Sistema finalizado.");
				break;

			default:

				System.out.println("Op��o inv�lida! \n");
				menuCliente();
				read.next();

			}

		} while (escolha != 3);

	}

	public void menuGerente() {

		do {

			System.out.println("Escolha uma op��o: ");
			System.out.println("1 - Saldo");
			System.out.println("2 - Relat�rios");
			System.out.println("3 - Relat�rio Gerente");
			System.out.println("4 - Sair");
			escolha = read.nextInt();

			switch (escolha) {
			case 1:

				break;
			case 2:

				break;

			case 3:

				break;

			case 4:
				System.out.println("Sistema finalizado.");
				break;

			default:

				System.out.println("Op��o inv�lida! \n ");
				menuGerente();
				read.next();
			}

		} while (escolha != 4);

	}

	public void menuDiretor() {

		System.out.println("Escolha uma op��o: ");
		System.out.println("1 - Saldo");
		System.out.println("2 - Relat�rios");
		System.out.println("3 - Rel�torio Gerente");
		System.out.println("4 - Relat�rio Diretor");
		System.out.println("5 - Sair");
		escolha = read.nextInt();

		switch (escolha) {
		case 1:

			break;
		case 2:

			break;

		case 3:

			break;

		case 4:

		case 5:
			System.out.println("Sistema finalizado.");
			break;

		default:

			System.out.println("Op��o inv�lida! \n");
			menuDiretor();
			read.next();

		}
		while (escolha != 5)
			;

	}

	public void menuPresidente() {

		System.out.println("\n ");
		System.out.println("Escolha uma op��o: \n");
		System.out.println("1 - Saldo");
		System.out.println("2 - Relat�rios");
		System.out.println("3 - Rel�torio Gerente");
		System.out.println("4 - Relat�rio Diretor");
		System.out.println("5 - Relat�rio Presidente");
		System.out.println("6 - Sair");
		escolha = read.nextInt();

		switch (escolha) {
		case 1:

			break;
		case 2:

			break;

		case 3:

			break;

		case 4:

			break;
		case 5:

			break;

		case 6:
			System.out.println("Programa finalizado. \n");
			break;

		default:

			System.out.println("Op��o inv�lida!");
			menuPresidente();

			read.next();

		}
		while (escolha != 6)
			;

	}

}