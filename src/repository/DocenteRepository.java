package repository;

import model.Docente;
import service.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class DocenteRepository {

    public List<Docente> findAll() {
        List<Docente> docenti = new ArrayList<>();
        String sql = "SELECT id, nome, cognome, data_di_nascita FROM docente";


        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Docente docente = new Docente();
                docente.setId(rs.getInt("id"));
                docente.setNome(rs.getString("nome"));
                docente.setCognome(rs.getString("cognome"));
                docente.setDataDiNascita(rs.getDate("data_di_nascita"));
                docenti.add(docente);
            }
        } catch (SQLException e) {
            System.err.println("Errore durante il recupero dei docenti: " + e.getMessage());
        }
        return docenti;
    }


    public Docente save(Docente docente) {
        String sql = "INSERT INTO docente (nome, cognome, data_di_nascita) VALUES (?, ?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            pstmt.setString(1, docente.getNome());
            pstmt.setString(2, docente.getCognome());
            pstmt.setDate(3, new java.sql.Date(docente.getDataDiNascita().getTime()));

            int affectedRows = pstmt.executeUpdate();

            if (affectedRows > 0) {
                try (ResultSet generatedKeys = pstmt.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        docente.setId(generatedKeys.getInt(1));
                    }
                }
            }
        } catch (SQLException e) {
            System.err.println("Errore durante il salvataggio del docente: " + e.getMessage());
        }

        return docente;
    }

    public boolean deleteDocenteByName(String nome) {

        String sql = "DELETE FROM docente WHERE nome = ?";

        try (Connection conn = DBConnection.getConnection()) {
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setString(1, nome);
                int rowsAffected = pstmt.executeUpdate();

                return rowsAffected > 0;
            }
        } catch (SQLException e) {
            System.out.println("Errore durante l'eliminazione del docente dal database.");
            e.printStackTrace();
            return false;
        }
    }

    public boolean updateDocente(Docente docente) {
        String sql = "UPDATE docente SET nome = ?, cognome = ?, data_di_nascita = ? WHERE id = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, docente.getNome());
            pstmt.setString(2, docente.getCognome());
            pstmt.setDate(3, new java.sql.Date(docente.getDataDiNascita().getTime()));
            pstmt.setInt(4, docente.getId());

            int affectedRows = pstmt.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            System.err.println("Errore durante l'aggiornamento del docente: " + e.getMessage());
            return false;
        }
    }

    public Optional<Docente> findByName(String nome) {
        String sql = "SELECT id, nome, cognome, data_di_nascita FROM docente WHERE id = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, nome);

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    Docente docente = new Docente();
                    docente.setId(rs.getInt("id"));
                    docente.setNome(rs.getString("nome"));
                    docente.setCognome(rs.getString("cognome"));
                    docente.setDataDiNascita(rs.getDate("data_di_nascita"));
                    return Optional.of(docente);
                }
            }
        } catch (SQLException e) {
            System.err.println("Errore durante il recupero del docente: " + e.getMessage());
        }

        return Optional.empty();
    }
}


