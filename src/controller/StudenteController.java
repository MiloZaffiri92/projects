package controller;

import model.Docente;
import model.Studente;
import service.StudenteService;
import view.StudenteView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class StudenteController {

    private final StudenteService studenteService;
    private final StudenteView studenteView;
    private final Scanner scanner;

    public StudenteController(StudenteService studenteService, StudenteView studenteView, Scanner scanner) {
        this.studenteService = studenteService;
        this.studenteView = studenteView;
        this.scanner = scanner;
    }

    public void showAllStudenti() {
        List<Studente> studenti = studenteService.getAllStudenti();
        studenteView.displayStudenti(studenti);
    }

    public void createStudente() {

        studenteView.displayInputNuovoStudente();

        String nome = scanner.nextLine().trim();
        System.out.println("Inserisci il cognome:");
        String cognome = scanner.nextLine().trim();
        System.out.println("Inserisci Matricola: ");
        Integer matricola = scanner.nextInt();
        System.out.println("Inserisci età: ");
        Integer eta = scanner.nextInt();
        System.out.println("Inserisci città di residenza: ");
        String cittaResidenza = scanner.nextLine();
        scanner.nextLine();

        Studente studente = studenteService.createStudente(nome, cognome, matricola, eta, cittaResidenza);
        studenteView.displayStudenteCreato(studente);


    }
}
