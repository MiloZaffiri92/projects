package view;

import model.Docente;

import java.text.SimpleDateFormat;
import java.util.List;

public class DocenteView {

    private final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    public void displayDocenti(List<Docente> docenti) {
        if (docenti.isEmpty()) {
            System.out.println("Nessun docente trovato.");
            return;
        }

        System.out.println("LISTA DOCENTI: ");
        for (Docente docente : docenti) {
            displayDocente(docente);
            System.out.println("--------------------");
        }
    }

    public static void mostraMenu() {
        System.out.println("\n=== MENU PRINCIPALE ===");
        System.out.println("0: Esci");
        System.out.println("=== DOCENTI ===");
        System.out.println("1: Lista docenti");
        System.out.println("2: Nuovo docente");
        System.out.println("3: Modifica docente");
        System.out.println("4: Elimina docente");
        System.out.println("=== STUDENTI ===");
        System.out.println("5: Lista studenti");
        System.out.println("6: Nuovo studente");
        System.out.println("7: Modifica studente");
        System.out.println("8: Elimina studente");
        System.out.println("=== CORSI ===");


    }

    public void displayDocente(Docente docente) {
        System.out.println("ID: " + docente.getId());
        System.out.println("Nome: " + docente.getNome());
        System.out.println("Cognome: " + docente.getCognome());
        System.out.println("Data di nascita: " + dateFormat.format(docente.getDataDiNascita()));
    }

    public void displayInputNuovoDocente() {
        System.out.println(" NUOVO DOCENTE: ");
        System.out.println("Inserisci il nome:");
    }

    public void displayDocenteCreato(Docente docente) {
        System.out.println("Docente creato con successo!");
        displayDocente(docente);

    }

    public void displayErrore(String errore) {
        System.err.println("ERRORE: "+ errore);
    }



}
