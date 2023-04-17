package presidente;

import funcionario.Funcionario;

public class Presidente extends Funcionario {
    public Presidente(String cpf, String senha) {
        super(cpf, senha, "Presidente");
    }
}