package service;

import model.Docente;
import repository.DocenteRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public class DocenteService {
    private final DocenteRepository docenteRepository;

    public DocenteService(DocenteRepository docenteRepository) {
        this.docenteRepository = docenteRepository;
    }

    public List<Docente> getAllDocenti() {
        return docenteRepository.findAll();
    }

    public Docente createDocente(String nome, String cognome, Date dataDiNascita) {
        Docente nuovoDocente = new Docente();
        nuovoDocente.setNome(nome);
        nuovoDocente.setCognome(cognome);
        nuovoDocente.setDataDiNascita(dataDiNascita);
        return docenteRepository.save(nuovoDocente);
    }

    public boolean deleteDocente(String nome) {
        return docenteRepository.deleteDocenteByName(nome);

    }

    public boolean updateDocente(String nome, String cognome, Date dataDiNascita) {
        Optional<Docente> optionalDocente = docenteRepository.findByName(nome);

        if (optionalDocente.isPresent()) {
            Docente docente = optionalDocente.get();
            docente.setNome(nome);
            docente.setCognome(cognome);
            docente.setDataDiNascita(dataDiNascita);

            return docenteRepository.update(docente);
        }

        return false;
    }
}
