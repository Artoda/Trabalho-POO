package cargo;

public class Diretor extends Gerente {
	CargosEnum diretor = CargosEnum.DIRETOR;
	private final String cargo = diretor.name();
    private final int digito = diretor.ordinal();
    
    public Diretor() {
	}
	
	public Diretor(String nome, int cpf, int senha) {
		super(nome, cpf, senha);
	}
}