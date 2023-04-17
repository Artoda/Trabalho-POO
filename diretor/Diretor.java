package diretor;

import funcionario.Funcionario;

public class Diretor extends Funcionario {
    public Diretor(String cpf, String senha) {
        super(cpf, senha, "Diretor");
    }
}