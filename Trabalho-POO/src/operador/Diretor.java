package operador;

import conta.Agencia;

public class Diretor extends Gerente {
	CargosEnum diretor = CargosEnum.DIRETOR;
	private final String tipo = diretor.name();
    private final int digito = diretor.ordinal();
    
    public Diretor() {
	}
	
	public Diretor(String nome, String cpf, int senha, CargosEnum tipo, Agencia agencia) {
		super(nome, cpf, senha, tipo, agencia);
	}
}