import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class GestionProduit {
    private static Scanner scanner = new Scanner(System.in);

    // Ajouter un produit
    public static void ajouterProduit() {
        System.out.print("Nom du produit : ");
        String nom = scanner.nextLine();
        System.out.print("Quantité : ");
        int quantite = scanner.nextInt();
        System.out.print("Prix : ");
        double prix = scanner.nextDouble();
        scanner.nextLine(); // Pour consommer le retour à la ligne

        String sql = "INSERT INTO produits (nom, quantite, prix) VALUES (?, ?, ?)";

        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, nom);
            stmt.setInt(2, quantite);
            stmt.setDouble(3, prix);
            stmt.executeUpdate();
            System.out.println("Produit ajouté avec succès !");
        } catch (SQLException e) {
            System.err.println("Erreur lors de l'ajout du produit : " + e.getMessage());
        }
    }

    // Modifier un produit
    public static void modifierProduit() {
        System.out.print("ID du produit à modifier : ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Nouveau nom : ");
        String nom = scanner.nextLine();
        System.out.print("Nouvelle quantité : ");
        int quantite = scanner.nextInt();
        System.out.print("Nouveau prix : ");
        double prix = scanner.nextDouble();

        String sql = "UPDATE produits SET nom = ?, quantite = ?, prix = ? WHERE id = ?";

        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, nom);
            stmt.setInt(2, quantite);
            stmt.setDouble(3, prix);
            stmt.setInt(4, id);
            stmt.executeUpdate();
            System.out.println("Produit modifié avec succès !");
        } catch (SQLException e) {
            System.err.println("Erreur lors de la modification du produit : " + e.getMessage());
        }
    }

    // Supprimer un produit
    public static void supprimerProduit() {
        System.out.print("ID du produit à supprimer : ");
        int id = scanner.nextInt();

        String sql = "DELETE FROM produits WHERE id = ?";

        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("Produit supprimé avec succès !");
        } catch (SQLException e) {
            System.err.println("Erreur lors de la suppression du produit : " + e.getMessage());
        }
    }
}
