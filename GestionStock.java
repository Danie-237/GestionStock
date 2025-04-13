import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class GestionStock {
    private static Scanner scanner = new Scanner(System.in);

    // Ajouter un mouvement (entrée ou sortie)
    public static void ajouterMouvement() {
        System.out.print("ID du produit : ");
        int produitId = scanner.nextInt();
        System.out.print("Quantité : ");
        int quantite = scanner.nextInt();
        scanner.nextLine(); // Consommer la nouvelle ligne
        System.out.print("Type (ENTREE/SORTIE) : ");
        String type = scanner.nextLine().toUpperCase();

        String sqlMouvement = "INSERT INTO mouvements (produit_id, type, quantite) VALUES (?, ?, ?)";
        String sqlStockUpdate = "UPDATE produits SET quantite = quantite + ? WHERE id = ?";
        String sqlStockCheck = "SELECT quantite FROM produits WHERE id = ?";

        try (Connection conn = DatabaseManager.getConnection()) {
            conn.setAutoCommit(false); // Démarrer une transaction

            // Vérifier le stock actuel pour les sorties
            if (type.equals("SORTIE")) {
                PreparedStatement checkStmt = conn.prepareStatement(sqlStockCheck);
                checkStmt.setInt(1, produitId);
                ResultSet rs = checkStmt.executeQuery();

                if (rs.next()) {
                    int quantiteActuel = rs.getInt("quantite");
                    if (quantiteActuel < quantite) {
                        System.out.println("Erreur : quantité insuffisante !");
                        return;
                    }
                }
            }

            // Ajouter le mouvement
            try (PreparedStatement mouvementStmt = conn.prepareStatement(sqlMouvement)) {
                mouvementStmt.setInt(1, produitId);
                mouvementStmt.setString(2, type);
                mouvementStmt.setInt(3, quantite);
                mouvementStmt.executeUpdate();
            }

            // Mettre à jour le stock
            try (PreparedStatement stockStmt = conn.prepareStatement(sqlStockUpdate)) {
                stockStmt.setInt(1, type.equals("ENTREE") ? quantite : -quantite);
                stockStmt.setInt(2, produitId);
                stockStmt.executeUpdate();
            }

            conn.commit(); // Valider la transaction
            System.out.println("Mouvement ajouté avec succès !");
        } catch (SQLException e) {
            System.err.println("Erreur lors de l'ajout du mouvement : " + e.getMessage());
        }
    }
}