package operador;

import conta.Agencia;

public class Presidente extends Diretor {
	CargosEnum presidente = CargosEnum.PRESIDENTE;
	private final String tipo = presidente.name();
	private final int digito = presidente.ordinal();

	public Presidente() {
	}

	public Presidente(String nome, String cpf, int senha, CargosEnum tipo, Agencia agencia) {
		super(nome, cpf, senha, tipo, agencia);
	}
}