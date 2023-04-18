package operador;

import conta.Agencia;

public class Gerente extends Funcionario {
	CargosEnum tipo = CargosEnum.GERENTE;
	Agencia agencia = new Agencia();

	public Gerente() {
	}

	public Gerente(String nome, String cpf, int senha, Agencia agencia) {
		super(nome, cpf, senha);
		this.agencia = agencia;
	}

}