package conta;

public class ContaPoupanca extends Conta {
	ContasEnum poupanca = ContasEnum.POUPANCA;
    private final String tipoConta = poupanca.name();
    private final int digito = poupanca.ordinal();
    private double taxarendimento;
	
	public double getTaxarendimento() {
		return taxarendimento;
	}
	public void setTaxarendimento(double taxarendimento) {
		this.taxarendimento = taxarendimento;
	}
	public void SimularRendimento() {
	}

    @Override
    public String getTipoConta() {
        return tipoConta;
    }
}