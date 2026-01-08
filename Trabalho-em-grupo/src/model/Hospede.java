package model;
public class Hospede {
    int idHospede;
    String nome;
    String sobrenome;
    String documentoIdentificacao;
    

    // Construtor
    public Hospede(int idHospede, String nome, String sobrenome, String documentoIdentificacao) {
        this.idHospede = idHospede;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.documentoIdentificacao = documentoIdentificacao;
        

    }

    // Getters
    public int getIdHospede() {
        return idHospede;}

    public String getNome() {
        return nome;
    }
    public String getSobrenome() {
        return sobrenome;
    }
    public String getDocumentoIdentificacao() {
        return documentoIdentificacao;
    }

    
}
