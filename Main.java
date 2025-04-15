import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Ajouter un produit");
            System.out.println("2. Modifier un produit");
            System.out.println("3. Supprimer un produit");
            System.out.println("4. Ajouter un mouvement de stock");
            System.out.println("5. Générer un rapport PDF");
            System.out.println("6. Quitter");
            System.out.print("Votre choix : ");
            
            try {
                choix = Integer.parseInt(choixStr);  // tenter de convertir en int
            } catch (NumberFormatException e) {
                System.out.println("Entrée invalide. Veuillez entrer un nombre entre 1 et 6.");
                continue;
            }

            switch (choix) {
                case 1:
                    GestionProduit.ajouterProduit();
                    break;
                case 2:
                    GestionProduit.modifierProduit();
                    break;
                case 3:
                    GestionProduit.supprimerProduit();
                    break;
                case 4:
                    GestionStock.ajouterMouvement();
                    break;
                case 5:
                    RapportStock.genererRapport();
                    break;
                case 6:
                    System.out.println("Fermeture du programme.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Choix invalide !");
            }
        }
    }
}
