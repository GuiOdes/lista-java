package guiodes.lista.aeroporto;

public class Aviao {
    private String nome;
    private int identificador;
    private StatusAviao status;

    public Aviao(String nome, int identificador) {
        this.nome = nome;
        this.identificador = identificador;
        this.status = StatusAviao.EM_ESPERA;
    }

    public String getNome() {
        return nome;
    }

    public int getIdentificador() {
        return identificador;
    }

    public StatusAviao getStatus() {
        return status;
    }

    public void setStatus(StatusAviao status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Aviao{" +
                "modelo='" + nome + '\'' +
                ", identificador='" + identificador + '\'' +
                ", status=" + status +
                '}';
    }
}
