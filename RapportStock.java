import net.sf.jasperreports.engine.*;

import java.awt.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.io.File;
import java.io.IOException;

public class RapportStock {
    public static void genererRapport() {
        Connection conn = null;
        try {
            // Connexion à la base de données
            conn = DatabaseManager.getConnection();

            // Charger le fichier JRXML
            JasperReport jasperReport = JasperCompileManager.compileReport("src/rapport_stock.jrxml");

            // Remplir le rapport avec les données de la base
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null, conn);

            // Exporter le rapport en PDF
            String pdfFilePath = "src/Etat_Stock.pdf";
            JasperExportManager.exportReportToPdfFile(jasperPrint, pdfFilePath);

            System.out.println("Rapport généré avec succès : " + pdfFilePath);

            // Ouvrir le PDF avec le lecteur de PDF par défaut
            openPdf(pdfFilePath);
        } catch (JRException e) {
            System.err.println("Erreur lors de la génération du rapport : " + e.getMessage());
        } catch (SQLException e) {
            System.err.println("Erreur de connexion à la base de données : " + e.getMessage());
        } finally {
            // Fermer la connexion à la base de données
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    System.err.println("Erreur lors de la fermeture de la connexion : " + e.getMessage());
                }
            }
        }
    }

    // Méthode pour ouvrir le fichier PDF
    private static void openPdf(String pdfFilePath) {
        try {
            File pdfFile = new File(pdfFilePath);
            if (pdfFile.exists()) {
                // Ouvrir le fichier PDF avec le lecteur par défaut
                if (Desktop.isDesktopSupported()) {
                    Desktop.getDesktop().open(pdfFile);
                } else {
                    System.err.println("Le bureau n'est pas supporté sur cette plateforme.");
                }
            } else {
                System.err.println("Le fichier PDF n'existe pas : " + pdfFilePath);
            }
        } catch (IOException e) {
            System.err.println("Erreur lors de l'ouverture du PDF : " + e.getMessage());
        }
    }
}


