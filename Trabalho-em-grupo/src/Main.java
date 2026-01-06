import modelo.Hospede;
import modelo.Quarto;


public class Main {
    public static void main(String[] args) {
        Quarto.criarQuartosIniciais();
        Quarto.listarTodosOsQuartos();
        Quarto.listarQuartosDisponiveis();
        Quarto.listarQuartosOcupados();
        Quarto.listarQuartoEspecifico(2);

        //Criação de hóspedes e outras operações podem ser adicionadas aqui
        Hospede hospede1 = new Hospede();
        hospede1.Hospede(1, "João Silva", "12MO34LU");
        Hospede hospede2 = new Hospede();
        hospede2.Hospede(2, "Fernando Souza", "GU45TY89");
        Hospede.listarHospedes();
        //Procura hóspede por documento
        Hospede.procurarHospede("12MO34LU");
        //Procurar hospede que não existe
        Hospede.procurarHospede("XX99ZZ88");

    }
}
