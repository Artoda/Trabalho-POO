package conta;

import java.util.ArrayList;
import java.util.List;

public class Agencia {
	public int idAgencia;
	List<Conta> listaContas = new ArrayList<Conta>();

	public Agencia() {

	}

	public Agencia(int idAgencia) {
		this.idAgencia = idAgencia;
	}
	
	public void adicionarConta(Conta conta) {
		listaContas.add(conta);
	}

	public int getIdAgencia() {
		return idAgencia;
	}

	public void setIdAgencia(int idAgencia) {
		this.idAgencia = idAgencia;
	}

	public List<Conta> getListaContas() {
		return listaContas;
	}
	
	

}