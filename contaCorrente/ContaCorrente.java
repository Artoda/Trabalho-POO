package contaCorrente;

import conta.Conta;

public class ContaCorrente extends Conta {
    private final String tipoConta = "Conta Corrente";

    public ContaCorrente(String cpfTitular, int idAgencia) {
        super(cpfTitular, idAgencia);
    }

    @Override
    public String getTipoConta() {
        return tipoConta;
    }

	public double calcularTributacao() {
		// metodo para calcular tributação
		return 0;
	}
}