package operador;

import java.util.HashMap;

import conta.ContasEnum;

public class Cliente extends Pessoa  implements Comparable {

	CargosEnum tipo = CargosEnum.CLIENTE;

	public Cliente() {

	}

	public Cliente(String nome, String cpf, int senha) {
		super(nome, cpf, senha);

	}

	@Override
	public String toString() {
		return "Cliente: Nome=" + nome + ", CPF=" + cpf;
	}

	@Override
	public int compareTo(Object o) {
		if (this.getNome().compareTo(((Pessoa) o).getNome()) < 0) {

			return -1;

		} else if (this.getNome().compareTo(((Pessoa) o).getNome()) > 0) {

			return 1;

		} else {
			return 0;
		}
	}

	
	

}