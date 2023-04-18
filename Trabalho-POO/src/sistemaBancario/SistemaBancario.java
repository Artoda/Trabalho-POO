package sistemaBancario;

import java.util.HashMap;
import java.util.Scanner;

import conta.ContasEnum;
import operador.Diretor;
import operador.Gerente;
import operador.Presidente;

public class SistemaBancario {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bem-vindo ao sistema banc�rio!");

        //  ler arquivo de texto com dados dos clientes, contas e funcion�rios

        boolean sair = false;
        while (!sair) {
            System.out.println("Por favor, digite seu CPF: ");
            String cpf = scanner.nextLine();
            System.out.println("Digite sua senha: ");
            String senha = scanner.nextLine();
            //public HashMap<String, ContasEnum> listaCliente = new HashMap<String, ContasEnum>();
            // Verifica se � um Cliente
            // implementar a l�gica de verifica��o de Cliente
            // Verifica se � um Gerente
            
            Gerente gerente = verificarGerente(cpf, senha);
            if (gerente != null) {
                System.out.println("Bem-vindo, gerente da ag�ncia " + gerente.agencia);
                // implementar as opera��es dispon�veis para o Gerente
                continue;
            }

            // Verifica se � um Diretor
            Diretor diretor = verificarDiretor(cpf, senha);
            if (diretor != null) {
                System.out.println("Bem-vindo, diretor!");
                // implementar as opera��es dispon�veis para o Diretor
                continue;
            }

            // Verifica se � um Presidente
            Presidente presidente = verificarPresidente(cpf, senha);
            if (presidente != null) {
                System.out.println("Bem-vindo, presidente!");
                // TODO: implementar as opera��es dispon�veis para o Presidente
                continue;
            }

            System.out.println("CPF e/ou senha inv�lidos.");
        }

        // escrever arquivo de texto com dados atualizados dos clientes, contas e funcion�rios
    }

    private static Gerente verificarGerente(String cpf, String senha) {
        // implementar a l�gica de verifica��o de Gerente
        return null;
    }

    private static Diretor verificarDiretor(String cpf, String senha) {
        // implementar a l�gica de verifica��o de Diretor
        return null;
    }

    private static Presidente verificarPresidente(String cpf, String senha) {
        // implementar a l�gica de verifica��o de Presidente
        return null;
    }
}