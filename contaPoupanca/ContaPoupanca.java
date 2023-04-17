package contaPoupanca;

import conta.Conta;

public class ContaPoupanca extends Conta {
    private final String tipoConta = "Conta Poupança";

    public ContaPoupanca(String cpfTitular, int idAgencia) {
        super(cpfTitular, idAgencia);
    }

    @Override
    public String getTipoConta() {
        return tipoConta;
    }
}