package sistemaBancario;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import conta.Agencia;
import conta.ContaCorrente;
import conta.ContaPoupanca;
import operador.Cliente;
import operador.Diretor;
import operador.Funcionario;
import operador.Gerente;
import operador.Presidente;

public class SistemaBancario {

	static List<Agencia> listaAgencias = new ArrayList<Agencia>();
	static List<Cliente> listaClientes = new ArrayList<>();
	static List<Gerente> listaGerentes = new ArrayList<>();
	static List<Diretor> listaDiretores = new ArrayList<>();
	static List<Presidente> listaPresidentes = new ArrayList<>();
	static List<Funcionario> listaFuncionarios = new ArrayList<Funcionario>();
	static Scanner read = new Scanner(System.in);

	public static void main(String[] args) throws IOException {

//Classe main faz o input de dados nos arquivos,coloca eles em ordem alfabetica, e logo após ele chava o menu principal.

		inputDados();
		Collections.sort(listaClientes);
		menu();

	}

	public static void menu() throws IOException {

		int escolha = 0;

		// O menu principal serve para diferencias os tipos de logins, sendo um
		// exclusivo para clientes e outro para funcionarios.

		System.out.println("------------------------------------------------------------------");
		System.out.println("-------------------------   Six Bank  -----------------------------");
		System.out.println("------------------------------------------------------------------\n");
		while (escolha != 3) {
			System.out.println("1 - Login Cliente\n");
			System.out.println("2 - Login Funcionário\n");
			System.out.println("3 - Encerrar sistema\n");
			System.out.print("Opções: ");

			escolha = read.nextInt();

			switch (escolha) {
			case 1:
				menuCliente();
				break;
			case 2:
				menuFuncionario();
				System.out.println("Funcionário");
				break;
			case 3:
				System.out.println("Sistema encerrado!");
				break;
			default:
				System.out.println("Opção inválida! \n ");
				break;

			}
		}

	}

	public static void menuFuncionario() throws IOException {

		// No menu funcionário ele divide qual tipo de funcionario você é, seja um
		// gerente, diretor ou presidente.
		// As variaveis colocadas aqui servem para verificação, o "-5" é uma escolha
		// aleatoria de uma posição impossivel que serve para preencher os dados e
		// atribuir eles

		String cpf;
		int senha;
		int posicao = -5;
		System.out.println("-------------------------   Menu funcionário:  -----------------------------\n");
		System.out.println("CPF: ");
		cpf = read.next();

		for (int i = 0; i < listaFuncionarios.size(); i++) {
			if (listaFuncionarios.get(i).getCpf().equals(cpf)) {
				posicao = i;
				break;
			}
		}
		if (posicao == -5) {
			System.out.println("CPF inválido!");
		} else {
			System.out.print("Senha: ");
			senha = read.nextInt();
			if (listaFuncionarios.get(posicao).getSenha() == senha) {
				if (listaFuncionarios.get(posicao).getTipo().name().equals("GERENTE")) {
					menuGerente(cpf, posicao);
				} else if (listaFuncionarios.get(posicao).getTipo().name().equals("DIRETOR")) {
					menuDiretor(cpf, posicao);
				} else {
					menuPresidente(cpf, posicao);
				}
			} else {
				System.out.println("Senha inválida!");
			}
		}

	}

	public static void menuGerente(String cpf, int posicao) throws IOException {
		LocalDateTime agora = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		String agoraFormatado = agora.format(formatter);

		int escolha = 0;
		System.out.println("Bem-vindo " + listaFuncionarios.get(posicao).getNome());
		while (escolha != 3) {
			System.out.println("-------------------------   Menu gerente:  -----------------------------\n");
			System.out.println("1 - Acesso a conta de cliente");
			System.out.println("2 - Relatório Gerente");
			System.out.println("3 - Sair");
			System.out.print("Opção: ");
			escolha = read.nextInt();
			switch (escolha) {
			case 1:
				menuCliente();
				break;
			// No caso da construção de relatorios, colocamos um caminho especifico aonde
			// cada relatorio vai ser salvo, sendo assim, caso precise usar em uma maquina
			// diferente, seria necessario alterar o caminho de salvamento
			case 2:
				escritor(
						"C:\\Users\\romul\\Documents\\Serratec\\Eclipse\\Trabalho POO\\Trabalho-POO\\arquivos\\relatorio-"
								+ agoraFormatado + listaFuncionarios.get(posicao).getAgencia().getIdAgencia() + ".txt",
						"A agência " + listaFuncionarios.get(posicao).getAgencia().getIdAgencia() + " possuí­ "
								+ listaFuncionarios.get(posicao).getAgencia().getListaContas().size() + " contas.\n");
				System.out.println("Relatório criado com sucesso!");
				break;
			case 3:
				break;
			default:
				break;
			}
		}

	}

	public static void menuDiretor(String cpf, int posicao) throws IOException {
		LocalDateTime agora = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		String agoraFormatado = agora.format(formatter);
		int escolha = 0;
		int agencia;
		int posAgen = -5;
		System.out.println("Bem-vindo (a) " + listaFuncionarios.get(posicao).getNome());
		while (escolha != 4) {
			System.out.println("-------------------------   Menu Diretor:  -----------------------------\n");
			System.out.println("1 - Acesso a conta de cliente");
			System.out.println("2 - Relatório Gerente");
			System.out.println("3 - Relat[orio Diretor");
			System.out.println("4 - Sair");
			System.out.print("Opção:  ");
			escolha = read.nextInt();
			switch (escolha) {
			case 1:
				menuCliente();
				break;
			case 2:
				System.out.print("Agência: ");
				agencia = read.nextInt();

				for (int i = 0; i < listaAgencias.size(); i++) {
					if (listaAgencias.get(i).getIdAgencia() == agencia) {
						posAgen = i;
						break;
					}
				}
				if (posAgen == -5) {
					System.out.println("Agência não encontrada!");
					
					// No caso da construção de relatorios, colocamos um caminho especifico aonde
					// cada relatorio vai ser salvo, sendo assim, caso precise usar em uma maquina
					// diferente, seria necessario alterar o caminho de salvamento
				} else {
					escritor(
							"C:\\Users\\romul\\Documents\\Serratec\\Eclipse\\Trabalho POO\\Trabalho-POO\\arquivos\\relatorio-"
									+ agoraFormatado + "-" + listaAgencias.get(posAgen).getIdAgencia()
									+ "(Diretor).txt",
							"A agencia " + listaAgencias.get(posAgen).getIdAgencia() + " possuí­ "
									+ listaAgencias.get(posAgen).getListaContas().size() + " contas.\n");
					System.out.println("Relatório criado com sucesso!");
				}

				break;
			case 3:
				for (int i = 0; i < listaClientes.size(); i++) {
					for (int j = 0; j < listaAgencias.size(); j++) {
						for (int k = 0; k < listaAgencias.get(j).getListaContas().size(); k++) {
							if (listaAgencias.get(j).getListaContas().get(k).getCliente().getNome()
									.equals(listaClientes.get(i).getNome())) {
								
								// No caso da construção de relatorios, colocamos um caminho especifico aonde
								// cada relatorio vai ser salvo, sendo assim, caso precise usar em uma maquina
								// diferente, seria necessario alterar o caminho de salvamento
								escritor(
										"C:\\Users\\romul\\Documents\\Serratec\\Eclipse\\Trabalho POO\\Trabalho-POO\\arquivos\\relatorioContas-"
												+ agoraFormatado + ".txt",
										"Agência: " + listaAgencias.get(j).getIdAgencia() + ". Conta: "
												+ listaAgencias.get(j).getListaContas().get(k).getNumero() + ". "
												+ listaClientes.get(i).toString());
							}
						}
					}
				}

				System.out.println("Relatório criado com sucesso!");
				break;
			case 4:
				break;
			default:
				break;
			}
		}

	}

	public static void menuPresidente(String cpf, int posicao) throws IOException {
		LocalDateTime agora = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		String agoraFormatado = agora.format(formatter);
		int escolha = 0;
		int agencia;
		int posAgen = -5;
		double soma = 0;
		System.out.println("Bem-vindo (a) " + listaFuncionarios.get(posicao).getNome());
		while (escolha != 5) {
			System.out.println("-------------------------   Menu Diretor:  -----------------------------\n");
			System.out.println("1 - Acesso a conta de cliente");
			System.out.println("2 - Relatório Gerente");
			System.out.println("3 - Relatório Diretor");
			System.out.println("4 - Relatório Presidente");
			System.out.println("5 - Sair");
			System.out.print("Opção:  ");
			escolha = read.nextInt();
			switch (escolha) {
			case 1:
				menuCliente();
				break;
			case 2:
				System.out.print("Agência: ");
				agencia = read.nextInt();

				for (int i = 0; i < listaAgencias.size(); i++) {
					if (listaAgencias.get(i).getIdAgencia() == agencia) {
						posAgen = i;
						break;
					}
				}
				if (posAgen == -5) {
					System.out.println("Agência não encontrada!");
				} else {
					
					// No caso da construção de relatorios, colocamos um caminho especifico aonde
					// cada relatorio vai ser salvo, sendo assim, caso precise usar em uma maquina
					// diferente, seria necessario alterar o caminho de salvamento
					escritor(
							"C:\\Users\\romul\\Documents\\Serratec\\Eclipse\\Trabalho POO\\Trabalho-POO\\arquivos\\relatorio-"
									+ agoraFormatado + "-" + listaAgencias.get(posAgen).getIdAgencia()
									+ "(Diretor).txt",
							"A agência " + listaAgencias.get(posAgen).getIdAgencia() + " possuí­ "
									+ listaAgencias.get(posAgen).getListaContas().size() + " contas.\n");
					System.out.println("Relatório criado com sucesso!");
				}

				break;
			case 3:
				for (int i = 0; i < listaClientes.size(); i++) {
					for (int j = 0; j < listaAgencias.size(); j++) {
						for (int k = 0; k < listaAgencias.get(j).getListaContas().size(); k++) {
							if (listaAgencias.get(j).getListaContas().get(k).getCliente().getNome()
									.equals(listaClientes.get(i).getNome())) {
								
								// No caso da construção de relatorios, colocamos um caminho especifico aonde
								// cada relatorio vai ser salvo, sendo assim, caso precise usar em uma maquina
								// diferente, seria necessario alterar o caminho de salvamento
								escritor(
										"C:\\Users\\romul\\Documents\\Serratec\\Eclipse\\Trabalho POO\\Trabalho-POO\\arquivos\\relatorioContas-"
												+ agoraFormatado + "(Presidente).txt",
										"Agência: " + listaAgencias.get(j).getIdAgencia() + ". Conta: "
												+ listaAgencias.get(j).getListaContas().get(k).getNumero() + ". "
												+ listaClientes.get(i).toString());
							}
						}
					}
				}

				System.out.println("Relatório criado com sucesso!");
				break;
			case 4:
				for (int i = 0; i < listaAgencias.size(); i++) {
					for (int j = 0; j < listaAgencias.get(i).getListaContas().size(); j++) {
						soma += listaAgencias.get(i).getListaContas().get(j).getSaldo();
					}
				}
				
				// No caso da construção de relatorios, colocamos um caminho especifico aonde
				// cada relatorio vai ser salvo, sendo assim, caso precise usar em uma maquina
				// diferente, seria necessario alterar o caminho de salvamento
				escritor(
						"C:\\Users\\romul\\Documents\\Serratec\\Eclipse\\Trabalho POO\\Trabalho-POO\\arquivos\\relatorioCapital"
								+ agoraFormatado + ".txt",
						"Capital total: R$" + soma);
				System.out.println("Relatório criado com sucesso!");
				break;
			case 5:
				break;
			default:
				break;
			}
		}
	}

	public static void menuCliente() throws IOException {// *
		LocalDateTime agora = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		String agoraFormatado = agora.format(formatter);

		LocalDateTime agora1 = LocalDateTime.now();
		DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("HH:mm:ss");
		formatter1 = DateTimeFormatter.ofPattern("HH:mm:ss");
		String agoraFormatado1 = agora1.format(formatter1);
		System.out.println("-------------------------   Menu do cliente:  -----------------------------\n");
		int agencia;
		int conta;
		int senha;
		int posicao1 = -5;
		int posicao2 = -5;
		int posicao3 = -5;
		int posicao4 = -5;
		double valor = 0;
		int escolha = 0;
		int tempo = 0;
		double deposito = 0;

		System.out.print("Agência: ");
		agencia = read.nextInt();
		for (int i = 0; i < listaAgencias.size(); i++) {
			if (listaAgencias.get(i).idAgencia == agencia) {
				posicao1 = i;
				break;
			}
		}
		if (posicao1 == -5) {
			System.out.print("Agência não encontrada!\n");
		} else {
			System.out.print("Conta: ");
			conta = read.nextInt();
			for (int i = 0; i < listaAgencias.get(posicao1).getListaContas().size(); i++) {
				if (listaAgencias.get(posicao1).getListaContas().get(i).getNumero() == conta) {
					System.out.print("Senha: ");
					senha = read.nextInt();

					if (listaAgencias.get(posicao1).getListaContas().get(i).getCliente().getSenha() == senha) {
						posicao2 = i;
					} else {

					}
					break;
				}
			}
			if (posicao2 == -5) {
				System.out.println("Conta ou senha inválida!");
			}
		}

		if (posicao1 != -5 && posicao2 != -5) {
			System.out.println("Bem-vindo(a) "
					+ listaAgencias.get(posicao1).getListaContas().get(posicao2).getCliente().getNome());
			while (escolha != 6) {
				System.out.println("Operação desejada \n");
				System.out.println("0 - Saldo\n");
				System.out.println("1 - Saque\n");
				System.out.println("2 - Deposito\n");
				System.out.println("3 - Tranferência\n");
				System.out.println("4 - Extrato\n");
				System.out.println("5 - Simulação poupança\n");
				System.out.println("6 - Encerrar\n");
				System.out.print("Opção: ");
				escolha = read.nextInt();

				switch (escolha) {
				case 0:
					System.out.println("Seu saldo é de: R$"
							+ listaAgencias.get(posicao1).getListaContas().get(posicao2).getSaldo());
					break;
				case 1:
					if (listaAgencias.get(posicao1).getListaContas().get(posicao2).getTipoConta().name()
							.equals("CORRENTE")) {
						System.out.println("O saque feito por contas corrente tem uma taxa de R$0.10.");
					}
					System.out.println("Qual o valor desejado para o saque: ");
					valor = read.nextDouble();
					listaAgencias.get(posicao1).getListaContas().get(posicao2).Saque(valor);
					if (listaAgencias.get(posicao1).getListaContas().get(posicao2).getTipoConta().name()
							.equals("CORRENTE")) {
						
						// No caso da construção de relatorios, colocamos um caminho especifico aonde
						// cada relatorio vai ser salvo, sendo assim, caso precise usar em uma maquina
						// diferente, seria necessario alterar o caminho de salvamento
						escritor(
								"C:\\Users\\romul\\Documents\\Serratec\\Eclipse\\Trabalho POO\\Trabalho-POO\\arquivos\\extrato-"
										+ listaAgencias.get(posicao1).getListaContas().get(posicao2)
												.getNumero()
										+ "-" + agoraFormatado + ".txt",
								agoraFormatado1 + ": Saque: R$" + valor + ". Saldo R$" + Math.round(
										listaAgencias.get(posicao1).getListaContas().get(posicao2).getSaldo() * 100.0)
										/ 100.0 + "(taxa de saque R$0.10)");
					} else {
						
						// No caso da construção de relatorios, colocamos um caminho especifico aonde
						// cada relatorio vai ser salvo, sendo assim, caso precise usar em uma maquina
						// diferente, seria necessario alterar o caminho de salvamento
						escritor(
								"C:\\Users\\romul\\Documents\\Serratec\\Eclipse\\Trabalho POO\\Trabalho-POO\\arquivos\\extrato-"
										+ listaAgencias.get(posicao1).getListaContas().get(posicao2).getNumero() + "-"
										+ agoraFormatado + ".txt",
								agoraFormatado1 + ": Saque: R$" + valor + ". Saldo R$" + Math.round(
										listaAgencias.get(posicao1).getListaContas().get(posicao2).getSaldo() * 100.0)
										/ 100.0);
					}
					break;
				case 2:
					if (listaAgencias.get(posicao1).getListaContas().get(posicao2).getTipoConta().name()
							.equals("CORRENTE")) {
						System.out.println("O depósito feito em contas corrente tem uma taxa de R$0,10.");
					}
					System.out.println("Qual o valor desejado para o depósito: ");
					valor = read.nextDouble();
					listaAgencias.get(posicao1).getListaContas().get(posicao2).Deposito(valor);
					if (listaAgencias.get(posicao1).getListaContas().get(posicao2).getTipoConta().name()
							.equals("CORRENTE")) {
						escritor(
								"C:\\Users\\romul\\Documents\\Serratec\\Eclipse\\Trabalho POO\\Trabalho-POO\\arquivos\\extrato-"
										+ listaAgencias.get(posicao1).getListaContas().get(posicao2)
												.getNumero()
										+ "-" + agoraFormatado + ".txt",
								agoraFormatado1 + ": Depósito: R$" + valor + ". Saldo R$" + Math.round(
										listaAgencias.get(posicao1).getListaContas().get(posicao2).getSaldo() * 100.0)
										/ 100.0 + "(taxa de depósito R$0.10)");
					} else {
						escritor(
								"C:\\Users\\romul\\Documents\\Serratec\\Eclipse\\Trabalho POO\\Trabalho-POO\\arquivos\\extrato-"
										+ listaAgencias.get(posicao1).getListaContas().get(posicao2).getNumero() + "-"
										+ agoraFormatado + ".txt",
								agoraFormatado1 + ": Depósito: R$" + valor + ". Saldo R$" + Math.round(
										listaAgencias.get(posicao1).getListaContas().get(posicao2).getSaldo() * 100.0)
										/ 100.0);
					}
					break;
				case 3:
					if (listaAgencias.get(posicao1).getListaContas().get(posicao2).getTipoConta().name()
							.equals("CORRENTE")) {
						System.out.println("A transferência feita por contas corrente tem uma taxa de R$0,20.");
					}
					System.out.print("Agência: ");
					agencia = read.nextInt();
					for (int i = 0; i < listaAgencias.size(); i++) {
						if (listaAgencias.get(i).idAgencia == agencia) {
							posicao3 = i;
							break;
						}
					}
					if (posicao3 == -5) {
						System.out.print("Agência não encontrada!\n");
					} else {
						System.out.print("Conta: ");
						conta = read.nextInt();
						for (int i = 0; i < listaAgencias.get(posicao3).getListaContas().size(); i++) {
							if (listaAgencias.get(posicao3).getListaContas().get(i).getNumero() == conta) {
								posicao4 = i;
								System.out.println("Valor da transferência: ");
								valor = read.nextDouble();
								listaAgencias.get(posicao1).getListaContas().get(posicao2)
										.Transferir(listaAgencias.get(posicao3).getListaContas().get(posicao4), valor);

								break;
							}
						}
						if (posicao4 == -5) {
							System.out.println("Conta ou senha inválida!");
						}
					}
					if (listaAgencias.get(posicao1).getListaContas().get(posicao2).getTipoConta().name()
							.equals("CORRENTE")) {
						
						// No caso da construção de relatorios, colocamos um caminho especifico aonde
						// cada relatorio vai ser salvo, sendo assim, caso precise usar em uma maquina
						// diferente, seria necessario alterar o caminho de salvamento
						escritor(
								"C:\\Users\\romul\\Documents\\Serratec\\Eclipse\\Trabalho POO\\Trabalho-POO\\arquivos\\extrato-"
										+ listaAgencias.get(posicao1).getListaContas().get(posicao2)
												.getNumero()
										+ "-" + agoraFormatado + ".txt",
								agoraFormatado1 + ": Transferência: R$" + valor + " para conta"
										+ listaAgencias.get(posicao3).getListaContas().get(posicao4).getNumero()
										+ " agência " + listaAgencias.get(posicao3).getIdAgencia() + ". Saldo R$"
										+ Math.round(
												listaAgencias.get(posicao1).getListaContas().get(posicao2).getSaldo()
														* 100.0)
												/ 100.0
										+ "(taxa de transferência R$0.20)");
						
						// No caso da construção de relatorios, colocamos um caminho especifico aonde
						// cada relatorio vai ser salvo, sendo assim, caso precise usar em uma maquina
						// diferente, seria necessario alterar o caminho de salvamento
						escritor(
								"C:\\Users\\romul\\Documents\\Serratec\\Eclipse\\Trabalho POO\\Trabalho-POO\\arquivos\\extrato-"
										+ listaAgencias.get(posicao3).getListaContas().get(posicao4).getNumero() + "-"
										+ agoraFormatado + ".txt",
								agoraFormatado1 + ": Transferência recebida: R$" + valor + " da conta "
										+ listaAgencias.get(posicao1).getListaContas().get(posicao2).getNumero()
										+ " agência " + listaAgencias.get(posicao1).getIdAgencia() + ". Saldo R$"
										+ Math.round(
												listaAgencias.get(posicao3).getListaContas().get(posicao4).getSaldo()
														* 100.0)
												/ 100.0);
					} else {
						// No caso da construção de relatorios, colocamos um caminho especifico aonde
						// cada relatorio vai ser salvo, sendo assim, caso precise usar em uma maquina
						// diferente, seria necessario alterar o caminho de salvamento
						escritor(
								"C:\\Users\\romul\\Documents\\Serratec\\Eclipse\\Trabalho POO\\Trabalho-POO\\arquivos\\extrato-"
										+ listaAgencias.get(posicao1).getListaContas().get(posicao2).getNumero() + "-"
										+ agoraFormatado + ".txt",
								agoraFormatado1 + ": Transferência: R$" + valor + " para conta "
										+ listaAgencias.get(posicao3).getListaContas().get(posicao4).getNumero()
										+ " agência " + listaAgencias.get(posicao3).getIdAgencia() + ". Saldo R$"
										+ Math.round(
												listaAgencias.get(posicao1).getListaContas().get(posicao2).getSaldo()
														* 100.0)
												/ 100.0);
						// No caso da construção de relatorios, colocamos um caminho especifico aonde
						// cada relatorio vai ser salvo, sendo assim, caso precise usar em uma maquina
						// diferente, seria necessario alterar o caminho de salvamento
						escritor(
								"C:\\Users\\romul\\Documents\\Serratec\\Eclipse\\Trabalho POO\\Trabalho-POO\\arquivos\\extrato-"
										+ listaAgencias.get(posicao3).getListaContas().get(posicao4).getNumero() + "-"
										+ agoraFormatado + ".txt",
								agoraFormatado1 + ": Transferência recebida: R$" + valor + " de conta "
										+ listaAgencias.get(posicao1).getListaContas().get(posicao2).getNumero()
										+ " agência " + listaAgencias.get(posicao1).getIdAgencia() + ". Saldo R$"
										+ Math.round(
												listaAgencias.get(posicao3).getListaContas().get(posicao4).getSaldo()
														* 100.0)
												/ 100.0);
					}
					break;
				case 4:
					try {
						// No caso da construção de relatorios, colocamos um caminho especifico aonde
						// cada relatorio vai ser salvo, sendo assim, caso precise usar em uma maquina
						// diferente, seria necessario alterar o caminho de salvamento
						leitor("C:\\Users\\romul\\Documents\\Serratec\\Eclipse\\Trabalho POO\\Trabalho-POO\\arquivos\\extrato-"
								+ listaAgencias.get(posicao1).getListaContas().get(posicao2).getNumero() + "-"
								+ agoraFormatado + ".txt");
					} catch (FileNotFoundException e) {
						System.out.println(
								"Saldo: " + listaAgencias.get(posicao1).getListaContas().get(posicao2).getSaldo());
					}
					break;
				case 5:
					if (listaAgencias.get(posicao1).getListaContas().get(posicao2).getTipoConta().name()
							.equals("CORRENTE")) {
						System.out.println("Simulação disponível apenas para contas poupança.");
					} else {
						System.out.println("Valor simulado: ");
						deposito = read.nextDouble();
						System.out.println("Tempo de simulação (meses): ");
						tempo = read.nextInt();
						System.out.println("O montante final ão é de: R$"
								+ Math.round(deposito * Math.pow(1.005, tempo) * 100.0) / 100.0);
					}

					break;
				case 6:
					break;
				default:
					System.out.println("Opção inválida");
					break;
				}
			}

		}

	}
	// No caso da leitura de arquivos, colocamos um caminho especifico aonde
				// cada arquivo sera lido, sendo assim, caso precise usar em uma maquina
				// diferente, seria necessario alterar o caminho de salvamento.
	public static void LerArquivo() throws IOException {
		BufferedReader arquivoRomulo = new BufferedReader(new FileReader(
				"C:\\Users\\romul\\Documents\\Serratec\\Eclipse\\Trabalho POO\\Trabalho-POO\\arquivos\\arquivoRomuloCC.txt"));

		BufferedReader arquivoJoao = new BufferedReader(new FileReader(
				"C:\\Users\\romul\\Documents\\Serratec\\Eclipse\\Trabalho POO\\Trabalho-POO\\arquivos\\arquivoJoaoCP.txt"));

		BufferedReader arquivoRonaldo = new BufferedReader(new FileReader(
				"C:\\Users\\romul\\Documents\\Serratec\\Eclipse\\Trabalho POO\\Trabalho-POO\\arquivos\\arquivoRonaldoCC.txt"));

		BufferedReader arquivoGabriel = new BufferedReader(new FileReader(
				"C:\\Users\\romul\\Documents\\Serratec\\Eclipse\\Trabalho POO\\Trabalho-POO\\arquivos\\arquivoGabrielCP.txt"));

		BufferedReader arquivoVictor = new BufferedReader(new FileReader(
				"C:\\Users\\romul\\Documents\\Serratec\\Eclipse\\Trabalho POO\\Trabalho-POO\\arquivos\\arquivoVictor.txt"));

		BufferedReader arquivoMarcelo = new BufferedReader(new FileReader(
				"C:\\Users\\romul\\Documents\\Serratec\\Eclipse\\Trabalho POO\\Trabalho-POO\\arquivos\\arquivoMarcelo.txt"));

		BufferedReader arquivoMatheus = new BufferedReader(new FileReader(
				"C:\\Users\\romul\\Documents\\Serratec\\Eclipse\\Trabalho POO\\Trabalho-POO\\arquivos\\arquivoMatheus.txt"));

		BufferedReader arquivoYan = new BufferedReader(new FileReader(
				"C:\\Users\\romul\\Documents\\Serratec\\Eclipse\\Trabalho POO\\Trabalho-POO\\arquivos\\arquivoYan.txt"));

		String linha;
		String nome, cpf;
		int senha;

		while (true) {
			linha = arquivoRomulo.readLine();
			String[] arrayStrings;
			if (linha != null) {
				arrayStrings = linha.split(";");
				nome = arrayStrings[0];
				cpf = (arrayStrings[1]);
				senha = Integer.parseInt(arrayStrings[2]);
				listaClientes.add(new Cliente(nome, cpf, senha));
			} else
				break;
		}
		while (true) {
			linha = arquivoJoao.readLine();
			String[] arrayStrings;
			if (linha != null) {
				arrayStrings = linha.split(";");
				nome = arrayStrings[0];
				cpf = (arrayStrings[1]);
				senha = Integer.parseInt(arrayStrings[2]);
				listaClientes.add(new Cliente(nome, cpf, senha));
			} else
				break;
		}
		while (true) {
			linha = arquivoRonaldo.readLine();
			String[] arrayStrings;
			if (linha != null) {
				arrayStrings = linha.split(";");
				nome = arrayStrings[0];
				cpf = (arrayStrings[1]);
				senha = Integer.parseInt(arrayStrings[2]);
				listaClientes.add(new Cliente(nome, cpf, senha));
			} else
				break;
		}
		while (true) {
			linha = arquivoGabriel.readLine();
			String[] arrayStrings;
			if (linha != null) {
				arrayStrings = linha.split(";");
				nome = arrayStrings[0];
				cpf = (arrayStrings[1]);
				senha = Integer.parseInt(arrayStrings[2]);
				listaClientes.add(new Cliente(nome, cpf, senha));
			} else
				break;
		}
		while (true) {
			linha = arquivoVictor.readLine();
			String[] arrayStrings;
			if (linha != null) {
				arrayStrings = linha.split(";");
				nome = arrayStrings[0];
				cpf = (arrayStrings[1]);
				senha = Integer.parseInt(arrayStrings[2]);
				listaGerentes.add(new Gerente(nome, cpf, senha, listaAgencias.get(0)));
			} else
				break;
		}
		while (true) {
			linha = arquivoMarcelo.readLine();
			String[] arrayStrings;
			if (linha != null) {
				arrayStrings = linha.split(";");
				nome = arrayStrings[0];
				cpf = (arrayStrings[1]);
				senha = Integer.parseInt(arrayStrings[2]);
				listaGerentes.add(new Gerente(nome, cpf, senha, listaAgencias.get(1)));
			} else
				break;
		}
		while (true) {
			linha = arquivoMatheus.readLine();
			String[] arrayStrings;
			if (linha != null) {
				arrayStrings = linha.split(";");
				nome = arrayStrings[0];
				cpf = (arrayStrings[1]);
				senha = Integer.parseInt(arrayStrings[2]);
				listaDiretores.add(new Diretor(nome, cpf, senha));
			} else
				break;
		}
		while (true) {
			linha = arquivoYan.readLine();
			String[] arrayStrings;
			if (linha != null) {
				arrayStrings = linha.split(";");
				nome = arrayStrings[0];
				cpf = (arrayStrings[1]);
				senha = Integer.parseInt(arrayStrings[2]);
				listaPresidentes.add(new Presidente(nome, cpf, senha));
			} else
				break;
		}

	}

	public static void escritor(String path, String texto) throws IOException {
		BufferedWriter buffWrite = new BufferedWriter(new FileWriter(path, true));
		String linha = "";
		Scanner in = new Scanner(System.in);
		linha = texto;
		buffWrite.append(linha + "\n");
		buffWrite.close();
	}

	public static void leitor(String path) throws IOException {

		BufferedReader buffRead = new BufferedReader(new FileReader(path));
		String linha = "";

		while (true) {
			linha = buffRead.readLine();
			if (linha != null) {
				System.out.println(linha);
			} else

				break;

		}
		buffRead.close();
	}

	public static void inputDados() throws IOException {

		listaAgencias.add(new Agencia(1234));
		listaAgencias.add(new Agencia(4321));

		try {
			LerArquivo();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

		listaFuncionarios.add(listaGerentes.get(0));
		listaFuncionarios.add(listaGerentes.get(1));
		listaFuncionarios.add(listaDiretores.get(0));
		listaFuncionarios.add(listaPresidentes.get(0));

		listaAgencias.get(0).adicionarConta(new ContaCorrente(1234, 2000, listaClientes.get(0)));
		listaAgencias.get(0).adicionarConta(new ContaPoupanca(1235, 10000, listaClientes.get(1)));
		listaAgencias.get(1).adicionarConta(new ContaCorrente(4321, 500, listaClientes.get(2)));
		listaAgencias.get(1).adicionarConta(new ContaPoupanca(5321, 3000, listaClientes.get(3)));
	}

}