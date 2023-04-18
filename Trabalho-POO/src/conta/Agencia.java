package conta;

import java.util.ArrayList;
import java.util.List;

public class Agencia {
	public int idAgencia;
	List<Conta> listaContas = new ArrayList<Conta>();

	public Agencia() {

	}

	public Agencia(int idAgencia, List<Conta> listaContas) {
		this.idAgencia = idAgencia;
		this.listaContas = listaContas;
	}

}