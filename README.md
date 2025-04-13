
###### Module : Gestion des Produits

# Objectifs:
- Permettre à l’utilisateur de gérer les produits présents dans l’inventaire : ajout, modification, suppression via une interface console.
- Les opérations sont réalisées à l’aide de requêtes SQL via JDBC.

### Fonctionnalités

- Ajouter un produit: Permet à l'utilisateur d'enregistrer un nouveau produit.
- Modifier un produit: Permet de mettre à jour les informations d’un produit existant à partir de son ID.
- Supprimer un produit: Supprime définitivement un produit de la base à partir de son ID.

Les données sont stockées dans la table "produits" de la base "stock_management" crée dans MysqlWorkbench.

### Fichier concerné

- "src/GestionProduit.java"
  

## Aspects techniques

- Connexion à MySQL via DatabaseManager.getConnection()

- Gestion des entrées avec Scanner

- Blocs try-with-resources pour éviter les fuites de ressources

- Affichage des messages de succès/erreur dans la console


##  Interactions avec les autres modules

 - Ce module est appelé depuis Main.java (options 1, 2, 3)

 - Les produits créés ici sont utilisés dans le module de stock (GestionStock)

 - Les mouvements dépendent de l'existence d’un produit (produit_id)

 - Le rapport PDF affiche les produits actuels et leurs quantités (RapportStock.java)


