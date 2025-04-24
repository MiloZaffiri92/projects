import controller.DocenteController;
import controller.StudenteController;
import repository.DocenteRepository;
import repository.StudenteRepository;
import service.DBConnection;
import service.DocenteService;
import service.StudenteService;
import view.DocenteView;
import view.StudenteView;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    private DocenteController docenteController;
    private Scanner scanner;



    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        // Inizializzazione repository
        DocenteRepository docenteRepository = new DocenteRepository();
        StudenteRepository studenteRepository = new StudenteRepository();

        //Inizializzazione services
        DocenteService docenteService = new DocenteService(docenteRepository);
        StudenteService studenteService = new StudenteService(studenteRepository);

        //Inizializzazione View
        DocenteView docenteView = new DocenteView();
        StudenteView studenteView = new StudenteView();

        //Inizializzazione Controllers
        DocenteController docenteController = new DocenteController(docenteService,docenteView,scanner);
        StudenteController studenteController = new StudenteController(studenteService,studenteView,scanner);


        try (Connection conn = DBConnection.getConnection()) {
            if (conn != null) {
                System.out.println("Connessione al database riuscita!");
            }
        } catch (SQLException e) {
            System.err.println("Errore di connessione al database:");
            e.printStackTrace();
            return;
        }

        boolean continua = true;

        while (continua) {
            docenteView.mostraMenu();
            int scelta = Integer.parseInt(scanner.nextLine().trim());

            switch (scelta) {
                case 0:
                    continua = false;
                    System.out.println("Chiusura dell'applicazione...");
                    break;
                case 1:
                    docenteController.showAllDocenti();
                    break;
                case 2:
                    docenteController.createDocente();
                    break;

//                case 3:
//                    docenteController.updateDocente();
//                    break;
//                case 4:
//                    docenteController.deleteDocente();
//                    break;
                case 5:
                    studenteController.showAllStudenti();
                    break;
                case 6:
                    studenteController.createStudente();
                    break;
//                case 7:
//                    studenteController.updateStudente();
//                    break;
//                case 8:
//                    studenteController.deleteStudente();
//                    break;
//                case 9:
//                    corsoController.showAllCorsi();
//                    break;
//                case 10:
//                    corsoController.createCorso();
//                    break;
//                case 11:
//                    corsoController.deleteCorso();
//                    break;
//                case 12:
//                    corsoController.updateCorso();
//                    break;
                default:
                    System.out.println("Scelta non valida. Riprova.");
            }
        }
        scanner.close();
    }

    }
