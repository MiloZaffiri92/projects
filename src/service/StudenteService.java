package service;

import model.Studente;
import repository.StudenteRepository;

import java.util.List;

public class StudenteService {
    private final StudenteRepository studenteRepository;

    public StudenteService(StudenteRepository studenteRepository) {
        this.studenteRepository = studenteRepository;
    }

    public List<Studente> getAllStudenti() {
        return studenteRepository.findAll();
    }

    public Studente createStudente(String nome, String cognome, int matricola, int eta, String cittaResidenza) {
        Studente nuovoStudente = new Studente();
        nuovoStudente.setNome(nome);
        nuovoStudente.setCognome(cognome);
        nuovoStudente.setMatricola(matricola);
        nuovoStudente.setEta(eta);
        nuovoStudente.setCittàResidenza(cittaResidenza);
        return studenteRepository.save(nuovoStudente);
    }
}
