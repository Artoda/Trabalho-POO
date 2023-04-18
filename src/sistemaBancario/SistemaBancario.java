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
	public static void main(String[] args) {
    	
    	//Scanner read = new Scanner(System.in);
    	
    	Cliente cliente1 = new Cliente("Romulo", "123.456.789-00", 1234);
    	Cliente cliente2 = new Cliente("João", "123.456.789-01", 1234);
    	
    	Agencia agencia = new Agencia(1234);
    	
    	Funcionario gerente = new Gerente("Victor", "123.456.789-02", 1234, agencia);
    	
    	Funcionario diretor = new Diretor("Matheus", "123.456.789-03", 1234);
    	
    	Funcionario presidente = new Presidente("Yan", "123.456.789-04", 1234);
    	
    	Conta corrente = new ContaCorrente(1234, 0.0, cliente1);
    	Conta poupanca = new ContaPoupanca(1234, 0.0, cliente2);
    	
    	agencia.adicionarConta(corrente);
    	agencia.adicionarConta(poupanca);
    	
    	
    	String cpf;
    	int senha;
    	
    	menu();

    }
    
    public static void menu() {
    	Scanner read = new Scanner(System.in);
    	int escolha = 0;
    	
    	System.out.println("------------------------------------------------------------------");
		System.out.println("---------------------   Sistema Bancário  ------------------------");
		System.out.println("------------------------------------------------------------------\n");
				
		while (escolha != 3) {
			System.out.println("1 - Login Cliente\n");
			System.out.println("2 - Login Funcionário\n");
			System.out.println("3 - Encerrar sistema");
			
			
			escolha = read.nextInt();
			
			switch (escolha) {
			case 1:
				//menuCliente();
				System.out.println("Cliente");
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
}