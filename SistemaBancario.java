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
	static List<Cliente> ListaClientes = new ArrayList<>();
	static List<Gerente> listaGerentes = new ArrayList<>();
	static List<Diretor> listaDiretores = new ArrayList<>();
	static List<Presidente> listaPresidentes = new ArrayList<>();
	static List<Funcionario> listaFuncionarios = new ArrayList<Funcionario>();
	static Scanner read = new Scanner(System.in);

	public static void main(String[] args) throws IOException {

		inputDados();

		menu();

	}

	public static void menu() throws IOException {

		int escolha = 0;

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
		int agencia;
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
			System.out.println("2 - Relatório");
			System.out.println("3 - Sair");
			System.out.print("Opção: ");
			escolha = read.nextInt();
			switch (escolha) {
			case 1:
				menuCliente();
				break;
			case 2:
				escritor(
						"C:\\Users\\joaom\\OneDrive\\Desktop\\Curso Serratec\\Orientação a objeto\\Trabalho-POO\\Arquivos\\relatorio-"
								+ agoraFormatado + listaFuncionarios.get(posicao).getAgencia().getIdAgencia() + ".txt",
						"A agencia " + listaFuncionarios.get(posicao).getAgencia().getIdAgencia() + " possuí "
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
		System.out.println("Bem-vindo " + listaFuncionarios.get(posicao).getNome());
		while (escolha != 4) {
			System.out.println("-------------------------   Menu Diretor:  -----------------------------\n");
			System.out.println("1 - Acesso a conta de cliente");
			System.out.println("2 - Relatório Gerente");
			System.out.println("3 - Relatório Diretor");
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
				} else {
					escritor(
							"C:\\Users\\joaom\\OneDrive\\Desktop\\Curso Serratec\\Orientação a objeto\\Trabalho-POO\\Arquivos\\relatorio-"
									+ agoraFormatado + "-" +listaAgencias.get(posAgen).getIdAgencia()
									+ "(Diretor).txt",
							"A agencia " + listaAgencias.get(posAgen).getIdAgencia() + " possuí "
									+ listaAgencias.get(posAgen).getListaContas().size()
									+ " contas.\n");
					System.out.println("Relatório criado com sucesso!");
				}

				break;
			case 3:
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
		System.out.println("Bem-vindo " + listaFuncionarios.get(posicao).getNome());
		while (escolha != 3) {
			System.out.println("-------------------------   Menu Presidente:  -----------------------------\n");
			System.out.println("1 - Acesso a conta de cliente");
			System.out.println("2 - Relatório");
			System.out.println("3 - Sair");
			System.out.print("Opção: ");
			escolha = read.nextInt();
			switch (escolha) {
			case 1:
				menuCliente();
				break;
			case 2:
				escritor(
						"C:\\Users\\joaom\\OneDrive\\Desktop\\Curso Serratec\\Orientação a objeto\\Trabalho-POO\\Arquivos\\relatorio-"
								+ agoraFormatado + listaFuncionarios.get(posicao).getAgencia().getIdAgencia() + ".txt",
						"A agencia " + listaFuncionarios.get(posicao).getAgencia().getIdAgencia() + " possuí "
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
		double soma = 0;
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
						System.out.println("O saque feito por contas corrente tem uma taxa de R$0,10.");
					}
					System.out.println("Qual o valor desejado para o saque: ");
					valor = read.nextDouble();
					listaAgencias.get(posicao1).getListaContas().get(posicao2).Saque(valor);
					if (listaAgencias.get(posicao1).getListaContas().get(posicao2).getTipoConta().name()
							.equals("CORRENTE")) {
						escritor(
								"C:\\Users\\joaom\\OneDrive\\Desktop\\Curso Serratec\\Orientação a objeto\\Trabalho-POO\\Arquivos\\extrato-"
										+ listaAgencias.get(posicao1).getListaContas().get(posicao2)
												.getNumero()
										+ "-" + agoraFormatado + ".txt",
								agoraFormatado1 + ": Saque: R$" + valor + ". Saldo R$" + Math.round(
										listaAgencias.get(posicao1).getListaContas().get(posicao2).getSaldo() * 100.0)
										/ 100.0 + "(taxa de saque R$0.10)");
					} else {
						escritor(
								"C:\\Users\\joaom\\OneDrive\\Desktop\\Curso Serratec\\Orientação a objeto\\Trabalho-POO\\Arquivos\\extrato-"
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
								"C:\\Users\\joaom\\OneDrive\\Desktop\\Curso Serratec\\Orientação a objeto\\Trabalho-POO\\Arquivos\\extrato-"
										+ listaAgencias.get(posicao1).getListaContas().get(posicao2)
												.getNumero()
										+ "-" + agoraFormatado + ".txt",
								agoraFormatado1 + ": Depósito: R$" + valor + ". Saldo R$" + Math.round(
										listaAgencias.get(posicao1).getListaContas().get(posicao2).getSaldo() * 100.0)
										/ 100.0 + "(taxa de depósito R$0.10)");
					} else {
						escritor(
								"C:\\Users\\joaom\\OneDrive\\Desktop\\Curso Serratec\\Orientação a objeto\\Trabalho-POO\\Arquivos\\extrato-"
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
						escritor(
								"C:\\Users\\joaom\\OneDrive\\Desktop\\Curso Serratec\\Orientação a objeto\\Trabalho-POO\\Arquivos\\extrato-"
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
						escritor(
								"C:\\Users\\joaom\\OneDrive\\Desktop\\Curso Serratec\\Orientação a objeto\\Trabalho-POO\\Arquivos\\extrato-"
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
						escritor(
								"C:\\Users\\joaom\\OneDrive\\Desktop\\Curso Serratec\\Orientação a objeto\\Trabalho-POO\\Arquivos\\extrato-"
										+ listaAgencias.get(posicao1).getListaContas().get(posicao2).getNumero() + "-"
										+ agoraFormatado + ".txt",
								agoraFormatado1 + ": Transferência: R$" + valor + " para conta "
										+ listaAgencias.get(posicao3).getListaContas().get(posicao4).getNumero()
										+ " agência " + listaAgencias.get(posicao3).getIdAgencia() + ". Saldo R$"
										+ Math.round(
												listaAgencias.get(posicao1).getListaContas().get(posicao2).getSaldo()
														* 100.0)
												/ 100.0);
						escritor(
								"C:\\Users\\joaom\\OneDrive\\Desktop\\Curso Serratec\\Orientação a objeto\\Trabalho-POO\\Arquivos\\extrato-"
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
						leitor("C:\\Users\\joaom\\OneDrive\\Desktop\\Curso Serratec\\Orientação a objeto\\Trabalho-POO\\Arquivos\\extrato-"
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
						System.out.println("O montante final é de: R$"
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

	public static void LerArquivo() throws IOException {
		BufferedReader arquivoRomulo = new BufferedReader(new FileReader(
				"C:\\Users\\joaom\\OneDrive\\Desktop\\Curso Serratec\\Orientação a objeto\\Trabalho-POO\\Arquivos\\arquivoRomuloCC.txt"));
		BufferedReader arquivoJoao = new BufferedReader(new FileReader(
				"C:\\Users\\joaom\\OneDrive\\Desktop\\Curso Serratec\\Orientação a objeto\\Trabalho-POO\\Arquivos\\arquivoJoaoCP.txt"));
		BufferedReader arquivoRonaldo = new BufferedReader(new FileReader(
				"C:\\Users\\joaom\\OneDrive\\Desktop\\Curso Serratec\\Orientação a objeto\\Trabalho-POO\\Arquivos\\arquivoRonaldoCC.txt"));
		BufferedReader arquivoGabriel = new BufferedReader(new FileReader(
				"C:\\Users\\joaom\\OneDrive\\Desktop\\Curso Serratec\\Orientação a objeto\\Trabalho-POO\\Arquivos\\arquivoGabrielCP.txt"));
		BufferedReader arquivoVictor = new BufferedReader(new FileReader(
				"C:\\Users\\joaom\\OneDrive\\Desktop\\Curso Serratec\\Orientação a objeto\\Trabalho-POO\\Arquivos\\arquivoVictor.txt"));
		BufferedReader arquivoMarcelo = new BufferedReader(new FileReader(
				"C:\\Users\\joaom\\OneDrive\\Desktop\\Curso Serratec\\Orientação a objeto\\Trabalho-POO\\Arquivos\\arquivoMarcelo.txt"));
		BufferedReader arquivoMatheus = new BufferedReader(new FileReader(
				"C:\\Users\\joaom\\OneDrive\\Desktop\\Curso Serratec\\Orientação a objeto\\Trabalho-POO\\Arquivos\\arquivoMatheus.txt"));
		BufferedReader arquivoYan = new BufferedReader(new FileReader(
				"C:\\Users\\joaom\\OneDrive\\Desktop\\Curso Serratec\\Orientação a objeto\\Trabalho-POO\\Arquivos\\arquivoYan.txt"));
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
				ListaClientes.add(new Cliente(nome, cpf, senha));
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
				ListaClientes.add(new Cliente(nome, cpf, senha));
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
				ListaClientes.add(new Cliente(nome, cpf, senha));
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
				ListaClientes.add(new Cliente(nome, cpf, senha));
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

		listaAgencias.get(0).adicionarConta(new ContaCorrente(1234, 2000, ListaClientes.get(0)));
		listaAgencias.get(0).adicionarConta(new ContaPoupanca(1235, 10000, ListaClientes.get(1)));
		listaAgencias.get(1).adicionarConta(new ContaCorrente(4321, 500, ListaClientes.get(2)));
		listaAgencias.get(1).adicionarConta(new ContaPoupanca(5321, 3000, ListaClientes.get(3)));
	}

}