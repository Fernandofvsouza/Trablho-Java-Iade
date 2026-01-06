package modelo;
/*
o que é necessario para representar um hóspede?
atributos:
-id
-nome
-documento


métodos:
-listar hospedes()
-procurar hospede por documento()
-editar hospede() (nome, documento)
*/

public class Hospede {
    int idHospede;
    String nomeHospede;
    String documentoHospede;
    private static int contadorId = 1;

    private static Hospede[] hospedes = new Hospede[26];
    private static int contadorHospedes = 0;

    //metodo construtor
    public Hospede(String nomeHospede, String documentoHospede){
        this.idHospede = contadorId++;
        this.nomeHospede = nomeHospede;
        this.documentoHospede = documentoHospede;

        //Adiciona o hóspede ao array ao ser criado
        if (contadorHospedes < hospedes.length){
            hospedes[contadorHospedes] = this;
            contadorHospedes++;
        }else{
            System.out.println("Capacidade máxima de hóspedes atingida.");}

    }

    //métodos de listagem de hóspedes
    public static void listarHospedes(){
       if (contadorHospedes == 0){
        System.out.println("Nenhum hóspede cadastrado.");
        return;
       }else{
            System.err.println("Lista de hóspedes cadastrados: ");
            for (int i = 0; i < contadorHospedes; i++){
                Hospede hospede = hospedes[i];
                System.out.println("ID: " + hospede.idHospede + ", Nome: " + hospede.nomeHospede + ", Documento: " + hospede.documentoHospede);
            }
       }
    }

    }

    }
