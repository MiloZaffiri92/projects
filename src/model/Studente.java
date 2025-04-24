package model;

public class Studente {
    private int id;
    private String nome;
    private String cognome;
    private int matricola;
    private int eta;
    private String cittàResidenza;

    public Studente() {}


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public int getMatricola() {
        return matricola;
    }

    public void setMatricola(int matricola) {
        this.matricola = matricola;
    }

    public int getEta() {
        return eta;
    }

    public void setEta(int eta) {
        this.eta = eta;
    }

    public String getCittàResidenza() {
        return cittàResidenza;
    }

    public void setCittàResidenza(String cittàResidenza) {
        this.cittàResidenza = cittàResidenza;
    }
}
