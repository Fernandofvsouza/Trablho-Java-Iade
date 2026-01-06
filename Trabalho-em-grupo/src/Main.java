import modelo.Quarto;



public class Main {
    public static void main(String[] args) {
        Quarto.criarQuartosIniciais();
        Quarto.listarTodosOsQuartos();
        Quarto.listarQuartosDisponiveis();
        Quarto.listarQuartosOcupados();
        Quarto.listarQuartoEspecifico(2);
    }
}
