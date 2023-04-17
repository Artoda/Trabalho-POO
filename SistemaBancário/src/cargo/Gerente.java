package cargo;

public class Gerente extends Funcionario {
    CargosEnum gerente = CargosEnum.GERENTE;
	private int idAgencia;
    private final String cargo = gerente.name();
    private final int digito = gerente.ordinal();

    public Gerente() {
	}
	
	public Gerente(String nome, int cpf, int senha) {
		super(nome, cpf, senha);
	}

	@Override
	public String getTipo() {
		return cargo;
	}
	
}