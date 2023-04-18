package operador;

import conta.Agencia;

public class Gerente extends Funcionario {
	CargosEnum gerente = CargosEnum.GERENTE;
	private final String tipo = gerente.name();
	private final int digito = gerente.ordinal();
	Agencia agencia = new Agencia();

	public Gerente() {
	}

	public Gerente(String nome, String cpf, int senha, CargosEnum tipo, Agencia agencia) {
		super(nome, cpf, senha, tipo);
		this.agencia = agencia;
	}

}