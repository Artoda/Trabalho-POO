package sistemaBancario;

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
	
	static Cliente cliente1 = new Cliente("Romulo", "123.456.789-00", 1234);
	static Cliente cliente2 = new Cliente("João", "123.456.789-01", 1235);
	static Agencia agencia = new Agencia(1234);
	Funcionario gerente = new Gerente("Victor", "123.456.789-02", 1234, agencia);
	Funcionario diretor = new Diretor("Matheus", "123.456.789-03", 1234);
	Funcionario presidente = new Presidente("Yan", "123.456.789-04", 1234);
	static Conta corrente = new ContaCorrente(1234, 1000, cliente1);
	static Conta poupanca = new ContaPoupanca(1235, 1000, cliente2);
	static List<Agencia> listaAgencias = new ArrayList<Agencia>();
	static Scanner read = new Scanner(System.in);
	
	
	
	public static void main(String[] args) {
    	
    	listaAgencias.add(agencia);
    	agencia.adicionarConta(corrente);
    	agencia.adicionarConta(poupanca);
    	
    	
    	
    	
    	
    	String cpf;
    	int senha;
    	
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
            System.out.print("Opção: ");
            escolha = read.nextInt();
            switch (escolha) {
            case 1:
                menuCliente();
                break;
            case 2:
                //menuFuncionario();
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
    	
    	if(posicao1 != -5 && posicao2 != -5) {
    		while (escolha != 5) {
    		 	System.out.println("Operação desejada \n");
    		 	System.out.println("1 - Saque\n");
    		 	System.out.println("2 - Depósito\n");
    		 	System.out.println("3 - Tranferência\n");
    		 	System.out.println("4 - Extrato\n");
    		 	System.out.println("5 - Encerrar\n");
    		 	System.out.print("Opção: ");
    		 	escolha = read.nextInt();
    		 
    		 	switch (escolha) {
    				case 1 :
    					if (listaAgencias.get(posicao1).getListaContas().get(posicao2).getTipoConta().name().equals("CORRENTE")) {
    						System.out.println("O saque feito por contas corrente tem uma taxa de R$0,10.");
    					}
    					System.out.println("Qual o valor desejado para o saque: ");
    					valor = read.nextDouble();
    					listaAgencias.get(posicao1).getListaContas().get(posicao2).Saque(valor);
    					//relatorio();
    					break;
    				case 2 :
    					if (listaAgencias.get(posicao1).getListaContas().get(posicao2).getTipoConta().name().equals("CORRENTE")) {
    						System.out.println("O depósito feito em contas corrente tem uma taxa de R$0,10.");
    					}
    					System.out.println("Qual o valor desejado para o depósito: ");
    					valor = read.nextDouble();
    					listaAgencias.get(posicao1).getListaContas().get(posicao2).Deposito(valor);
    					//relatorio();
    					break;
    				case 3 :
    					if (listaAgencias.get(posicao1).getListaContas().get(posicao2).getTipoConta().name().equals("CORRENTE")) {
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
    			    	    		
    			    	    		if (listaAgencias.get(posicao3).getListaContas().get(i).getCliente().getSenha() == senha) {
    			    	    			posicao4 = i;
    			    	    			System.out.println("Valor da transferência: ");
    			    	    			valor = read.nextDouble();
    			    	    			listaAgencias.get(posicao1).getListaContas().get(posicao2).Transferir(listaAgencias.get(posicao3).getListaContas().get(posicao4), valor);
    			    	    		} else {
    			    	    			
    			    	    		}
    			    	    		break;
    			    			}
    			    		}
    			    		if (posicao4 == -5) {
    			    			System.out.println("Conta ou senha inválida!");
    			    		}
    			    	}
    					//relatorio();
    					break;
    				case 4 :
    					System.out.println(listaAgencias.get(posicao1).getListaContas().get(posicao2).toString());
    					break;
    				case 5 :
    					break;
    				default:
    					System.out.println("Opção inválida");
    					break;
    		 	}		
    		}
    		 
    	}	
    	
    }

    
}