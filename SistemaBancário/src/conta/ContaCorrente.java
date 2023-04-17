package conta;

public class ContaCorrente extends Conta {
	ContasEnum corrente = ContasEnum.CORRENTE;
    private final String tipoConta = corrente.name();
    private final int digito = corrente.ordinal();

    private double taxas;

	public double getTaxas() {
		return taxas;
	}

	public void setTaxas(double taxas) {
		this.taxas = taxas;
	}

	@Override
	public String getTipoConta() {
		return tipoConta;
	}
	
}