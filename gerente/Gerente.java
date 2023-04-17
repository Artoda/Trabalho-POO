package gerente;

import funcionario.Funcionario;

public class Gerente extends Funcionario {
    private int idAgencia;

    public Gerente(String cpf, String senha, int idAgencia) {
        super(cpf, senha, "Gerente");
        this.idAgencia = idAgencia;
    }

    public int getIdAgencia() {
        return idAgencia;
    }
}