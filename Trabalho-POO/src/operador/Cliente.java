package operador;

import java.util.HashMap;

import conta.ContasEnum;

public class Cliente extends Pessoa {
	
	public Cliente(String nome, String cpf, int senha, CargosEnum tipo) {
		super(nome, cpf, senha, tipo);
		
	}

	public HashMap<String, ContasEnum> listaCliente = new HashMap<String, ContasEnum>();

	public HashMap<String, ContasEnum> getListaCliente() {
		return listaCliente;
	}

	public void setListaCliente(HashMap<String, ContasEnum> listaCliente) {
		this.listaCliente = listaCliente;
	}

	@Override
	public String toString() {
		return "Cliente [nome=" + nome + ", cpf=" + cpf + ", senha=" + senha + ", tipo=" + tipo + "]";
	}
	
}