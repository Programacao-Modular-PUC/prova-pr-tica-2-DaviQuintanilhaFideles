package pm_prova2_m;

public class Carro extends Veiculo implements Avaliavel {

    private int quantidadePortas;
    private int avaliacao;

    public Carro(String placa, String modelo, int anoFabricacao, double valorDiaria,
            double quilometragem, StatusVeiculo status, int quantidadePortas) {
        super(placa, modelo, anoFabricacao, valorDiaria, quilometragem, status);
        this.quantidadePortas = quantidadePortas;
        this.avaliacao = 0;
    }

    public int getQuantidadePortas() {
        return quantidadePortas;
    }

    public void setQuantidadePortas(int quantidadePortas) {
        this.quantidadePortas = quantidadePortas;
    }

    @Override
    public void avaliar(int nota) {
        if (nota >= 1 && nota <= 5) {
            this.avaliacao = nota;
            System.out.println("Carro " + getModelo() + " avaliado com nota " + nota);
        } else {
            System.out.println("Nota inválida. Informe um valor entre 1 e 5.");
        }
    }

    @Override
    public void exibirDetalhes() {
        System.out.println("=== CARRO ===");
        System.out.println("Placa: " + getPlaca());
        System.out.println("Modelo: " + getModelo());
        System.out.println("Ano: " + getAnoFabricacao());
        System.out.println("Valor Diária: R$ " + getValorDiaria());
        System.out.println("Quilometragem: " + getQuilometragem() + " km");
        System.out.println("Status: " + getStatus());
        System.out.println("Portas: " + quantidadePortas);
        System.out.println("Avaliação: " + (avaliacao == 0 ? "Sem avaliação" : avaliacao + "/5"));
    }

    @Override
    public boolean possuiSeguroEspecial() {
        return false;
    }
}
