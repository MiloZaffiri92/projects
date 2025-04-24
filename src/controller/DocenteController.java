package controller;

import model.Docente;
import service.DocenteService;
import view.DocenteView;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class DocenteController {
    private final DocenteService docenteService;
    private final DocenteView docenteView;
    private final Scanner scanner;

    public DocenteController(DocenteService docenteService, DocenteView docenteView, Scanner scanner) {
        this.docenteService = docenteService;
        this.docenteView = docenteView;
        this.scanner = scanner;
    }

    public void showAllDocenti() {
        List<Docente> docenti = docenteService.getAllDocenti();
        docenteView.displayDocenti(docenti);
    }

    public void createDocente() {
        docenteView.displayInputNuovoDocente();

        String nome = scanner.nextLine().trim();
        System.out.println("Inserisci il cognome:");
        String cognome = scanner.nextLine().trim();
        System.out.println("Inserisci la data di nascita (formato yyyy-MM-dd):");
        String dataInput = scanner.nextLine().trim();

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date dataNascita = format.parse(dataInput);
            Docente docente = docenteService.createDocente(nome, cognome, dataNascita);
            docenteView.displayDocenteCreato(docente);
        } catch (ParseException e) {
            docenteView.displayErrore("Formato data non valido. Usa yyyy-MM-dd");
        }
    }
}
