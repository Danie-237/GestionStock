
#####  Module : Génération de Rapport PDF

Ce module génère un rapport PDF de l’état du stock actuel à partir d’un fichier .jrxml via JasperReports.

### Etape 1: Connection de la base de données MySQL a Intellij

Cette étape consiste a connecter notre base de données MySQL créer ici sous MySQL Workbench a Java.

- Creation d'une classe java nommée DatabaseManager avec les attributs permettant la connection a la base de données.
- Utilisation des bibliothèques java.sql.Connection, java.sql.DriverManager, et java.sql.SQLException. 

### Etape 2: Connection de JasperStudio a MySQL Workbench et generation du rapport

##  Fichier principal

- src/RapportStock.java

##  Fonctionnalités

- Compilation du fichier rapport_stock.jrxml
- Récupération des données via JDBC
- Export au format Etat_Stock.pdf

##  Dépendances

- jasperreports:7.0.2
- mysql-connector-j-9.2.0

 ## Chemin du rapport généré

- src/Etat_Stock.pdf

##  Infos techniques

- Utilisation de JasperCompileManager, JasperFillManager et JasperExportManager
- Connexion gérée via DatabaseManager




