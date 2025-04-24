package view;

import model.Docente;
import model.Studente;

import java.util.Formattable;
import java.util.List;

public class StudenteView {

    public void displayStudenti(List<Studente> studenti) {
        if (studenti.isEmpty()) {
            System.out.println("Nessuno studente trovato");
            return;
        }



        System.out.println("Lista Studente: ");
        for (Studente studente:studenti) {
            displayStudente(studente);
        }
    }

    public void displayStudente(Studente studente) {
        System.out.println("ID: " + studente.getId());
        System.out.println("Nome: " + studente.getNome());
        System.out.println("Cognome: " + studente.getCognome());
        System.out.println("matricola: " + studente.getMatricola());
        System.out.println("eta: " + studente.getEta());
        System.out.println("città di residenza: " + studente.getCittàResidenza());

    }

    public void displayInputNuovoStudente() {
        System.out.println("NUOVO STUDENTE: ");
        System.out.println("Inserisci il nome: ");
    }

    public void displayStudenteCreato(Studente studente) {
        System.out.println("Docente creato con successo!");
    }

}
