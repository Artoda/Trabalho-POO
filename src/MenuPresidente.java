import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Map;
import java.util.Scanner;


public class MenuPresidente extends MenuDiretor{
	
	private static final Scanner entrada = new Scanner(System.in);
	private static final PrintStream saida = System.out;

	public static void menuPresidente(Funcionario funcionario,Map<String, Cliente> mapaContas, Map<String, Funcionario> mapaFuncionario) throws IOException {
			int opcao;
			
			do {
				saida.println("\n\t Six Bank - MENU PRESIDENTE ");
				saida.println("-----------------------------------------");
				saida.println("*** Escolha sua opção: ***");
				saida.println(" 1 - Relátorios: ");
				saida.println(" 2 - Sair\n ");
				saida.println("-----------------------------------------\n");
				opcao = entrada.nextInt();
				
				switch(opcao) {
					case 1: menuRelatoriosPresidente(funcionario, mapaContas, mapaFuncionario);
					break;					
					case 2:
						MenuInicial.menuInicial(mapaContas, mapaFuncionario);
						saida.println("Você está saindo do Sistema!!");
					break;
					
					default: 
						saida.println("Opção inválida!!");		
				}			
			}while(opcao != 3);
		}

		public static void menuRelatoriosPresidente(Funcionario funcionario,Map<String, Cliente> mapaContas, Map<String, Funcionario> mapaFuncionario) throws IOException	{

			int opcao;
			
			do {
				saida.println("\n\t Six Bank - MENU PRESIDENTE - RELATÓRIOS");
		        saida.println("--------------------------------------------------------");
		        saida.println("*** Escolha sua opção: ***");
		        saida.println(" 1 - Saldo: ");
		        saida.println(" 2 - Relátorio de tributação das contas corrente: ");
		        saida.println(" 3 - Simular rendimento da poupança: ");
		        saida.println(" 4 - Relatório de número de contas por agência: ");
		        saida.println(" 5 - Relatório de contas ordenado: ");
		        saida.println(" 6 - Relatório valor total armazenado no banco:  ");
		        saida.println(" 7 - Voltar ");
		        saida.println("--------------------------------------------------------\n");
	        opcao = entrada.nextInt();
			
		        switch (opcao)	{
					case 1:
						relatorioSaldoAgencia(funcionario);
					break;		
					
					case 2:
						relatorioTributacaoPresidente(funcionario,mapaFuncionario);
					break;
					
					case 3:
						calculaRensdimento();
					break;
					
					case 4:
						relatorioNumeroDeContasDiretor(funcionario);
					break;
					
					case 5:
						relatorioInfoClientesOrdenado(mapaContas);
					break;
					
					case 6:
						relatorioCapitalTotalBanco(opcao);
					break;
					
					case 7:
						funcionario.menuFuncionario (funcionario,mapaContas, mapaFuncionario);
					break;
					
					default: System.out.println("Opção inválida!\n"); 
				}
			}while(opcao != 7);
		
		 
		}
		
		public static void relatorioCapitalTotalBanco (int agencia) throws IOException {
			
			//BufferedReader br = new BufferedReader(new FileReader("......."));
			//BufferedReader brGerente = new BufferedReader(new FileReader("......."));
			
			double saldoAgencia = 0;
			
			String linha= "";
			
			while (true)  {	     
				linha = br.readLine();			
				if(linha != null) {
		        String[] lerlinha = linha.split(";"); 
			        	saldoAgencia += Integer.parseInt(lerlinha[4]);
			        	
				}else
					break;
				
			}
			br.close();
			while (true)  {
	            linha = brGerente.readLine();
	            if(linha != null) {
	            String[] lerlinha = linha.split(";"); 
	                if(Integer.parseInt(lerlinha[0]) == 1){
	                    if(agencia == Integer.parseInt(lerlinha[5])){
	                    	saldoAgencia += Integer.parseInt(lerlinha[4]);
	                    }
	                }else
	                    break;
	            } else 
	                break;
	        }
	    brGerente.close();
	    System.out.println("O saldo do seu banco é: R$" + saldoAgencia);
			
		}
		  public static void relatorioTributacaoPresidente(Funcionario funcionario,  Map<String, Funcionario> mapaFuncionario) {
		    	System.out.println("O valores cobrados por operação bancária são respectivamente:");
				System.out.println("R$ 0,10 (dez centavos) para saques,");
				System.out.println("R$ 0,10 (dez centavos) para depósitos,");
				System.out.println("e R$ 0,20 (vinte centavos) para transferencias.\n");
		    	
		  }
	}

}
