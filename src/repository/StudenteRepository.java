package repository;

import model.Studente;
import service.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudenteRepository {
    public List<Studente> findAll() {
        List<Studente> studenti = new ArrayList<>();
        String sql = "SELECT id, nome, cognome, matricola, eta, citta_residenza FROM studente";

        try (Connection connection = DBConnection.getConnection();
             Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Studente studente = new Studente();
                studente.setId(rs.getInt("id"));
                studente.setNome(rs.getString("nome"));
                studente.setCognome(rs.getString("cognome"));
                studente.setMatricola(rs.getInt("matricola"));
                studente.setEta(rs.getInt("eta"));
                studente.setCittàResidenza(rs.getString("citta_residenza"));
                studenti.add(studente);
            }

        } catch (SQLException e) {
            System.out.println("Errore durante il recupero degli Studenti" + e.getMessage());
            e.printStackTrace();
        }
        return studenti;
    }

    public Studente save(Studente studente) {
        String sql = "INSERT INTO studente (nome, cognome, matricola, eta, citta_residenza) VALUES (?,?,?,?,?)";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            pstmt.setString(1,studente.getNome());
            pstmt.setString(2,studente.getCognome());
            pstmt.setInt(3,studente.getMatricola());
            pstmt.setInt(4,studente.getEta());
            pstmt.setString(5,studente.getCittàResidenza());

            int affectedRows = pstmt.executeUpdate();

            if (affectedRows > 0) {
                try (ResultSet generatedKeys = pstmt.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        studente.setId(generatedKeys.getInt(1));
                    }
                }
            }

        }catch ( SQLException e) {
            System.out.println("Errore durante il salvataggio dello studente" + e.getMessage());
            e.printStackTrace();
        }
        return studente;
    }
}
