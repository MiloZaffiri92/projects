package model;
import java.util.Date;

public class Docente {


    private int id;

    private String nome;

    private String cognome;

    private Date dataDiNascita;



    public void setNome(String nomeInIngresso) {
        this.nome = nomeInIngresso;
    }

    public void setCognome(String cognomeInIngresso) {
        this.cognome = cognomeInIngresso;
    }

    public int getId() {
        return id;
    }

    public Date getDataDiNascita() {
        return dataDiNascita;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return this.nome;
    }

    public String getCognome() {
        return this.cognome;
    }

    public void setDataDiNascita(Date dataDiNascita) {
        this.dataDiNascita = dataDiNascita;
    }

}

