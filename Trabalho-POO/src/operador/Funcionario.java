package operador;

public abstract class Funcionario extends Pessoa {
    
	public Funcionario() {
	}
	
	public Funcionario(String nome, String cpf, int senha, CargosEnum tipo) {
		super(nome, cpf, senha, tipo);
	}

}