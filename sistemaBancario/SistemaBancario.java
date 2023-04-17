package sistemaBancario;

import java.util.Scanner;

import diretor.Diretor;
import gerente.Gerente;
import presidente.Presidente;

public class SistemaBancario {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bem-vindo ao sistema bancário!");

        //  ler arquivo de texto com dados dos clientes, contas e funcionários

        boolean sair = false;
        while (!sair) {
            System.out.println("Por favor, digite seu CPF: ");
            String cpf = scanner.nextLine();
            System.out.println("Digite sua senha: ");
            String senha = scanner.nextLine();

            // Verifica se é um Cliente
            // implementar a lógica de verificação de Cliente
            // Verifica se é um Gerente
            
            Gerente gerente = verificarGerente(cpf, senha);
            if (gerente != null) {
                System.out.println("Bem-vindo, gerente da agência " + gerente.getIdAgencia());
                // implementar as operações disponíveis para o Gerente
                continue;
            }

            // Verifica se é um Diretor
            Diretor diretor = verificarDiretor(cpf, senha);
            if (diretor != null) {
                System.out.println("Bem-vindo, diretor!");
                // implementar as operações disponíveis para o Diretor
                continue;
            }

            // Verifica se é um Presidente
            Presidente presidente = verificarPresidente(cpf, senha);
            if (presidente != null) {
                System.out.println("Bem-vindo, presidente!");
                // TODO: implementar as operações disponíveis para o Presidente
                continue;
            }

            System.out.println("CPF e/ou senha inválidos.");
        }

        // escrever arquivo de texto com dados atualizados dos clientes, contas e funcionários
    }

    private static Gerente verificarGerente(String cpf, String senha) {
        // implementar a lógica de verificação de Gerente
        return null;
    }

    private static Diretor verificarDiretor(String cpf, String senha) {
        // implementar a lógica de verificação de Diretor
        return null;
    }

    private static Presidente verificarPresidente(String cpf, String senha) {
        // implementar a lógica de verificação de Presidente
        return null;
    }
}