package sistemaBancario;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import operador.CargosEnum;
import operador.Pessoa;
import operador.Funcionario;
import operador.Diretor;
import operador.Gerente;
import operador.Presidente;
import operador.Cliente;
import conta.ContasEnum;
import conta.Conta;
import conta.Agencia;
import conta.ContaCorrente;
import conta.ContaPoupanca;

public class SistemaBancario {

	static List<Agencia> listaAgencias = new ArrayList<Agencia>();
	static List<Cliente> ListaClientes = new ArrayList<>();
	static List<Gerente> listaGerentes = new ArrayList<>();
	static List<Diretor> listaDiretores = new ArrayList<>();
	static List<Presidente> listaPresidentes = new ArrayList<>();
	static List<Funcionario> listaFuncionarios = new ArrayList<Funcionario>();
	static Scanner read = new Scanner(System.in);

	public static void main(String[] args) {

		ListaClientes.add(new Cliente("Romulo", "123.456.789-00", 1234));
		ListaClientes.add(new Cliente("João", "123.456.789-01", 1235));
		listaAgencias.add(new Agencia(1234));
		listaGerentes.add(new Gerente("Victor", "123.456.789-02", 1234, listaAgencias.get(0)));
		listaDiretores.add(new Diretor("Matheus", "123.456.789-03", 1234));
		listaPresidentes.add(new Presidente("Yan", "123.456.789-04", 1234));
		listaFuncionarios.add(listaGerentes.get(0));
		listaFuncionarios.add(listaDiretores.get(0));
		listaFuncionarios.add(listaPresidentes.get(0));

		listaAgencias.get(0).adicionarConta(new ContaCorrente(1234, 1000, ListaClientes.get(0)));
		listaAgencias.get(0).adicionarConta(new ContaPoupanca(1235, 1000, ListaClientes.get(1)));

		menu();

	}

	public static void menu() {

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

	public static void menuFuncionario() {
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
			if (listaFuncionarios.get(posicao).getTipo().name().equals("GERENTE")) {
				menuGerente(cpf);
			} else if (listaFuncionarios.get(posicao).getTipo().name().equals("DIRETOR")) {
				menuDiretor(cpf);
			} else {
				menuPresidente(cpf);
			}
		}

	}

	public static void menuGerente(String cpf) {
		int escolha = 0;

		while (escolha != 3) {
			System.out.println("-------------------------   Menu gerente:  -----------------------------\n");
			System.out.println("1 - Acesso a conta de cliente");
			System.out.println("2 - Relatórios");
			System.out.println("3 - Sair");
			System.out.print("Opção: ");
			escolha = read.nextInt();
			switch (escolha) {
			case 1:
				break;
			case 2:
				break;
			case 3:
				break;
			}
		}

	}

	public static void menuDiretor(String cpf) {
		int escolha = 0;

		while (escolha != 3) {
			System.out.println("-------------------------   Menu Diretor:  -----------------------------\n");
			System.out.println("1 - Acesso a conta de cliente");
			System.out.println("2 - Relatórios");
			System.out.println("3 - Sair");
			System.out.print("Opção: ");
			escolha = read.nextInt();
			switch (escolha) {
			case 1:
				break;
			case 2:
				break;
			case 3:
				break;
			}
		}

	}

	public static void menuPresidente(String cpf) {
		int escolha = 0;

		while (escolha != 3) {
			System.out.println("-------------------------   Menu Presidente:  -----------------------------\n");
			System.out.println("1 - Acesso a conta de cliente");
			System.out.println("2 - Relatórios");
			System.out.println("3 - Sair");
			System.out.print("Opção: ");
			escolha = read.nextInt();
			switch (escolha) {
			case 1:
				break;
			case 2:
				break;
			case 3:
				break;
			}
		}

	}

	public static void menuCliente() {

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
			while (escolha != 6) {
				System.out.println("Operação desejada \n");
				System.out.println("1 - Saque\n");
				System.out.println("2 - Deposito\n");
				System.out.println("3 - Tranferência\n");
				System.out.println("4 - Extrato\n");
				System.out.println("5 - Simulação poupança\n");
				System.out.println("6 - Encerrar\n");
				System.out.print("Opção: ");
				escolha = read.nextInt();

				switch (escolha) {
				case 1:
					if (listaAgencias.get(posicao1).getListaContas().get(posicao2).getTipoConta().name()
							.equals("CORRENTE")) {
						System.out.println("O saque feito por contas corrente tem uma taxa de R$0,10.");
					}
					System.out.println("Qual o valor desejado para o saque: ");
					valor = read.nextDouble();
					listaAgencias.get(posicao1).getListaContas().get(posicao2).Saque(valor);
					break;
				case 2:
					if (listaAgencias.get(posicao1).getListaContas().get(posicao2).getTipoConta().name()
							.equals("CORRENTE")) {
						System.out.println("O depósito feito em contas corrente tem uma taxa de R$0,10.");
					}
					System.out.println("Qual o valor desejado para o depósito: ");
					valor = read.nextDouble();
					listaAgencias.get(posicao1).getListaContas().get(posicao2).Deposito(valor);
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
								System.out.print("Senha: ");
								senha = read.nextInt();

								if (listaAgencias.get(posicao3).getListaContas().get(i).getCliente()
										.getSenha() == senha) {
									posicao4 = i;
									System.out.println("Valor da transferência: ");
									valor = read.nextDouble();
									listaAgencias.get(posicao1).getListaContas().get(posicao2).Transferir(
											listaAgencias.get(posicao3).getListaContas().get(posicao4), valor);
								} else {

								}
								break;
							}
						}
						if (posicao4 == -5) {
							System.out.println("Conta ou senha inválida!");
						}
					}
					break;
				case 4:
					System.out.println(listaAgencias.get(posicao1).getListaContas().get(posicao2).toString());
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

}