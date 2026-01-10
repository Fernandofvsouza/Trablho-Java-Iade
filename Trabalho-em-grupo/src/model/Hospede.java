package model;

public class Hospede {
    public int idHospede;
    public String nome;
    public String documento;

    private static final int MAX_HOSPEDES = 1000;
    private static final Hospede[] hospedes = new Hospede[MAX_HOSPEDES];
    private static int contadorHospedes = 0;
    private static int proximoIdHospede = 1;

    private Hospede(String nome, String documento) {
        this.idHospede = proximoIdHospede++;
        this.nome = nome;
        this.documento = documento;
    }

    /**
     * Cria hóspede com ID auto-incremental.
     */
    public static boolean criarHospede(String nome, String documento) {
        if (contadorHospedes >= hospedes.length) {
            System.out.println("Não foi possível criar hóspede: limite atingido.");
            return false;
        }
        if (!validarNome(nome) || !validarDocumento(documento)) {
            return false;
        }
        if (procurarHospedePorDocumento(documento) != null) {
            System.out.println("Não foi possível criar hóspede: documento já cadastrado.");
            return false;
        }

        Hospede h = new Hospede(nome.trim(), documento.trim());
        hospedes[contadorHospedes++] = h;
        System.out.println("Hóspede criado com sucesso! ID: " + h.idHospede);
        return true;
    }

    public static void listarHospedes() {
        if (contadorHospedes == 0) {
            System.out.println("Nenhum hóspede cadastrado.");
            return;
        }

        System.out.println("Lista de hóspedes:");
        for (int i = 0; i < contadorHospedes; i++) {
            Hospede h = hospedes[i];
            if (h == null) {
                continue;
            }
            System.out.println(formatarHospedeLinha(h));
        }
    }

    public static Hospede procurarHospedePorDocumento(String documento) {
        if (documento == null) {
            return null;
        }
        String doc = documento.trim();
        if (doc.isBlank()) {
            return null;
        }

        for (int i = 0; i < contadorHospedes; i++) {
            Hospede h = hospedes[i];
            if (h == null) {
                continue;
            }
            if (h.documento != null && h.documento.equalsIgnoreCase(doc)) {
                return h;
            }
        }
        return null;
    }

    /**
     * Edita nome e/ou documento (quando não nulos/não vazios).
     */
    public static boolean editarHospede(int idHospede, String novoNome, String novoDocumento) {
        Hospede h = getHospedePorId(idHospede);
        if (h == null) {
            System.out.println("Hóspede com ID " + idHospede + " não encontrado.");
            return false;
        }

        if (novoNome != null && !novoNome.isBlank()) {
            if (!validarNome(novoNome)) {
                return false;
            }
            h.nome = novoNome.trim();
        }

        if (novoDocumento != null && !novoDocumento.isBlank()) {
            if (!validarDocumento(novoDocumento)) {
                return false;
            }
            Hospede existente = procurarHospedePorDocumento(novoDocumento);
            if (existente != null && existente.idHospede != h.idHospede) {
                System.out.println("Não foi possível editar hóspede: documento já cadastrado em outro hóspede.");
                return false;
            }
            h.documento = novoDocumento.trim();
        }

        System.out.println("Hóspede " + idHospede + " editado com sucesso.");
        return true;
    }

    /**
     * Necessário para Reservas.existeHospede (usado via reflexão).
     */
    public static Hospede getHospedePorId(int idHospede) {
        for (int i = 0; i < contadorHospedes; i++) {
            Hospede h = hospedes[i];
            if (h != null && h.idHospede == idHospede) {
                return h;
            }
        }
        return null;
    }

    // validações/helpers

    private static boolean validarNome(String nome) {
        if (nome == null || nome.trim().isBlank()) {
            System.out.println("Nome inválido: não pode ser vazio.");
            return false;
        }
        return true;
    }

    private static boolean validarDocumento(String documento) {
        if (documento == null || documento.trim().isBlank()) {
            System.out.println("Documento inválido: não pode ser vazio.");
            return false;
        }
        return true;
    }

    private static String formatarHospedeLinha(Hospede h) {
        return "Hóspede ID: " + h.idHospede +
                " | Nome: " + h.nome +
                " | Documento: " + h.documento;
    }
}
