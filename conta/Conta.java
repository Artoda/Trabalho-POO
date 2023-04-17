package conta;

public abstract class Conta {
    private String cpfTitular;
    private double saldo;
    private int idAgencia;

    public Conta(String cpfTitular, int idAgencia) {
        this.cpfTitular = cpfTitular;
        this.idAgencia = idAgencia;
        this.saldo = 0.0;
    }

    public String getCpfTitular() {
        return cpfTitular;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public int getIdAgencia() {
        return idAgencia;
    }

    public abstract String getTipoConta();
}
