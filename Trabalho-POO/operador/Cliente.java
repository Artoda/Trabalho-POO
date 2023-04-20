package operador;

public class Cliente extends Pessoa {
	
	CargosEnum tipo = CargosEnum.CLIENTE;
	
	public Cliente() {
			
	}
	public Cliente(String nome, String cpf, int senha) {
		super(nome, cpf, senha);
		
	}

	@Override
	public String toString() {
		return "Cliente [nome=" + nome + ", cpf=" + cpf + ", senha=" + senha + ", tipo=" + tipo.name() + "]";
	}
	
}