import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Ajouter un produit");
            System.out.println("2. afficher les Produits");
            System.out.println("3. Modifier un produit");
            System.out.println("4. Supprimer un produit");
            System.out.println("5. Ajouter un mouvement de stock");
            System.out.println("6. Générer un rapport PDF");
            System.out.println("7. Quitter");
            System.out.print("Votre choix : ");

            String choixStr = scanner.nextLine();  // lire comme une chaîne
            int choix;

            try {
                choix = Integer.parseInt(choixStr);  // tenter de convertir en int
            } catch (NumberFormatException e) {
                System.out.println("Entrée invalide. Veuillez entrer un nombre entre 1 et 7.");
                continue;
            }

            switch (choix) {
                case 1:
                    GestionProduit.ajouterProduit();
                    break;
                case 2:
                    GestionProduit.afficherProduit();
                    break;
                case 3:
                    GestionProduit.modifierProduit();
                    break;
                case 4:
                    GestionProduit.supprimerProduit();
                    break;
                case 5:
                    GestionStock.ajouterMouvement();
                    break;
                case 6:
                    RapportStock.genererRapport();
                    break;
                case 7:
                    System.out.println("Fermeture du programme.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Choix invalide !");
            }
        }
    }
}
