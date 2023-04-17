package cargo;

public class Presidente extends Diretor {
	CargosEnum presidente = CargosEnum.PRESIDENTE;
    private final String cargo = presidente.name();
    private final int digito = presidente.ordinal();

    public Presidente() {
	}
		
	public Presidente(String nome, int cpf, int senha) {
		super(nome, cpf, senha);
	}
}