#  Module : Gestion des Mouvements de Stock
Ce module permet de gérer les *mouvements de stock* (entrées et sorties) dans le cadre du projet *Gestion de Stock*. 
Il permet de suivre les modifications de quantité pour chaque produit avec mise à jour automatique des quantités sur MYSQL.

##  Fichier principal
- "src/GestionStock.java"

### Objectifs

- Enregistrer les entrées et sorties de stock dans la table mouvements
- Mettre à jour automatiquement la quantité du produit dans la table produits
- Vérifier la disponibilité du stock avant d’autoriser une sortie
- Assurer la cohérence des données avec les *transactions SQL*


#### Fonctionnalités
# 1. Ajouter une *entrée de stock*

- L’utilisateur entre :
  - L’ID du produit concerné
  - La quantité à ajouter
  - Le type de mouvement (ENTREE)
- Le système insère un enregistrement dans mouvements et met à jour la table produits :
  - quantite = quantite + valeur

---

##  2. Ajouter une *sortie de stock*

- Avant d’autoriser une sortie :
- Le programme vérifie que la quantité en stock est suffisante
- Si ce n’est pas le cas, un message d’erreur s’affiche et la transaction est annulée
- Sinon, Reduit la quantité :
- quantite = quantite - valeur

##### 3. MAIN
- Le main nous permets de faire nous différentes requêtes sur notre interface console. 
