
###### Module : Gestion des Produits
Il permet de gérer les produits présents dans l’inventaire : ajout, modification, suppression via une interface console.
Les opérations sont réalisées à l’aide de requêtes SQL via JDBC.

### Fonctionnalités

- Ajouter un produit: Permet à l'utilisateur d'enregistrer un nouveau produit.
- Modifier un produit: Permet de mettre à jour les informations d’un produit existant à partir de son ID.
- Supprimer un produit: Supprime définitivement un produit de la base à partir de son ID.

Les données sont stockées dans la table "produits" de la base "stock_management" crée dans MysqlWorkbench.

### Fichier concerné

- "src/GestionProduit.java"

###  Interactions avec les autres modules

 - Le stock via GestionStock.java utilise les produits ajoutés ici.

 - Les mouvements dépendent de l'existence d’un produit (produit_id)

 - Le rapport PDF affiche les produits actuels et leurs quantités (RapportStock.java)


