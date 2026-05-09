# Projet 1 — Programme Java de Peer Review pour Travaux Académiques

## 📌 Description du Projet

Ce projet consiste à développer une application Java Console permettant aux étudiants de :

- Soumettre leurs travaux académiques
- Corriger les travaux d'autres étudiants
- Recevoir des évaluations anonymes

L’enseignant supervise tout le processus :
- Création des devoirs
- Attribution des évaluations
- Consultation des résultats
- Publication des notes finales

Le projet applique plusieurs concepts importants :
- Programmation Orientée Objet (POO)
- Architecture MVC
- DAO Pattern
- JDBC
- SQL Server

---

# 🎯 Fonctionnalités Principales

## 👨‍🏫 Enseignant

- Créer des devoirs (Assignments)
- Ajouter des critères d’évaluation
- Attribuer automatiquement les évaluations
- Consulter les évaluations reçues
- Calculer et publier les notes finales

---

## 👨‍🎓 Étudiant

- Consulter les devoirs disponibles
- Soumettre un fichier PDF
- Évaluer 2 travaux anonymes
- Ajouter des notes par critères
- Ajouter un commentaire obligatoire
- Consulter les résultats finaux

---

# 🛠️ Technologies Utilisées

| Technologie | Rôle |
|---|---|
| Java | Logique du programme |
| SQL Server | Base de données |
| JDBC | Connexion Java ↔ SQL Server |
| MVC | Architecture du projet |
| DAO Pattern | Gestion accès base de données |
| IntelliJ IDEA | IDE de développement |

---

# 🏗️ Architecture du Projet

Le projet suit une architecture MVC avec séparation des responsabilités.

```text
src
└───peerreview
    │   Main.java
    │
    ├───controller
    │       AssignmentController.java
    │       AuthController.java
    │       CritereController.java
    │       EvaluationController.java
    │       EvaluationDetailController.java
    │       ReviewAssignmentController.java
    │       SubmissionController.java
    │
    ├───dao
    │       AssignmentDAO.java
    │       AssignmentDAOImpl.java
    │       CritereDAO.java
    │       CritereDAOImpl.java
    │       EvaluationDAO.java
    │       EvaluationDAOImpl.java
    │       EvaluationDetailDAO.java
    │       EvaluationDetailDAOImpl.java
    │       ReviewAssignmentDAO.java
    │       ReviewAssignmentDAOImpl.java
    │       SubmissionDAO.java
    │       SubmissionDAOImpl.java
    │       UserDAO.java
    │       UserDAOImpl.java
    │
    ├───database
    │       ConnectionDatabase.java
    │
    ├───model
    │       Assignment.java
    │       Critere.java
    │       Evaluation.java
    │       EvaluationDetail.java
    │       ReviewAssignment.java
    │       Submission.java
    │       User.java
    │
    ├───service
    │       AssignmentService.java
    │       AuthService.java
    │       CritereService.java
    │       EvaluationDetailService.java
    │       EvaluationService.java
    │       ReviewAssignmentService.java
    │       SubmissionService.java
    │
    ├───util
    │       InputHelper.java
    │
    └───vue
            Menu.java
```
---

# 🌳 Visualisation Interactive de l’Architecture

Le projet contient également une visualisation HTML interactive permettant de comprendre :

* les relations entre les packages,
* la communication entre les fichiers Java,
* l’architecture MVC,
* DAO ↔ DAOImpl,
* le flow complet du système.

---

## 📂 Fichier HTML

```text id="sx8m1v"
peerreview_project_tree_visualization.html
```

---

## 🔗 Ouvrir la Visualisation

[🌳 Open Project Visualization](peerreview_project_tree_visualization.html)

---

## 🔄 Exemple de Communication

```text id="7s8j1o"
Menu.java
↓
AssignmentController.java
↓
AssignmentService.java
↓
AssignmentDAO.java
↓
AssignmentDAOImpl.java
↓
ConnectionDatabase.java
↓
SQL Server
```

---

---

# 📚 Explication des Packages

## 📦 Main.java

### Rôle

Point d’entrée principal du programme.

### Fonction

- Démarre l’application
- Affiche le menu principal
- Initialise la navigation du système

### Exemple

```java
public class Main {
    public static void main(String[] args) {
        Menu.start();
    }
}
```

---

# 📦 Package model

Le package `model` contient les objets métier du système.

Chaque classe représente une table SQL.

---

## Classes du package model

| Classe | Rôle |
|---|---|
| User.java | Représente un utilisateur |
| Assignment.java | Représente un devoir |
| Critere.java | Représente un critère d’évaluation |
| Submission.java | Représente un travail soumis |
| ReviewAssignment.java | Attribution des corrections |
| Evaluation.java | Correction réalisée |
| EvaluationDetail.java | Notes par critère |

---

## Exemple : User.java

```java
public class User {

    private int id;
    private String nom;
    private String email;
    private String motDePasse;
    private String role;

}
```

---

# 📦 Package dao

DAO signifie :

```text
Data Access Object
```

Ce package gère :
- les requêtes SQL,
- les opérations CRUD,
- la communication avec SQL Server.

---

## Interfaces DAO

| Interface | Rôle |
|---|---|
| UserDAO.java | Gestion utilisateurs |
| AssignmentDAO.java | Gestion devoirs |
| CritereDAO.java | Gestion critères |
| SubmissionDAO.java | Gestion soumissions |
| ReviewAssignmentDAO.java | Gestion attributions |
| EvaluationDAO.java | Gestion évaluations |
| EvaluationDetailDAO.java | Gestion notes critères |

---

## Implémentations DAO

| Classe | Rôle |
|---|---|
| UserDAOImpl.java | SQL utilisateurs |
| AssignmentDAOImpl.java | SQL devoirs |
| CritereDAOImpl.java | SQL critères |
| SubmissionDAOImpl.java | SQL soumissions |
| ReviewAssignmentDAOImpl.java | SQL attributions |
| EvaluationDAOImpl.java | SQL évaluations |
| EvaluationDetailDAOImpl.java | SQL détails évaluations |

---

## Exemple DAO

```java
public interface UserDAO {

    void ajouter(User user);

}
```

---

## Exemple Implémentation DAO

```java
public class UserDAOImpl implements UserDAO {

    @Override
    public void ajouter(User user) {

        String sql = "INSERT INTO Users VALUES (?, ?, ?, ?)";

    }

}
```

---

# 📦 Package service

Le package `service` contient toute la logique métier.

---

## Services disponibles

| Service | Rôle |
|---|---|
| AuthService.java | Authentification |
| AssignmentService.java | Gestion assignments |
| CritereService.java | Gestion critères |
| SubmissionService.java | Gestion soumissions |
| ReviewAssignmentService.java | Attribution corrections |
| EvaluationService.java | Gestion évaluations |
| EvaluationDetailService.java | Gestion notes critères |

---

## Exemple logique métier

### ReviewAssignmentService

Responsable de :
- attribution aléatoire,
- empêcher auto-correction,
- gestion des reviewers.

---

### EvaluationService

Responsable de :
- validation commentaire,
- calcul moyenne,
- gestion notes finales.

---

# 📦 Package controller

Le controller fait la liaison entre :
- la vue,
- les services.

---

## Controllers disponibles

| Controller | Rôle |
|---|---|
| AuthController.java | Login / Register |
| AssignmentController.java | Gestion devoirs |
| CritereController.java | Gestion critères |
| SubmissionController.java | Gestion soumissions |
| ReviewAssignmentController.java | Attribution corrections |
| EvaluationController.java | Gestion évaluations |
| EvaluationDetailController.java | Gestion notes critères |

---

## Exemple MVC

```text
Vue
↓
Controller
↓
Service
↓
DAO
↓
Database
```

---

# 📦 Package vue

Le package `vue` contient l’interface console.

---

## Menu.java

Responsable :
- affichage menus,
- navigation utilisateur,
- lecture choix utilisateur.

---

## Exemple Menu

```text
1. Login
2. Register
3. Quitter
```

---

# 📦 Package database

## ConnectionDatabase.java

Cette classe centralise :
- la connexion JDBC,
- l’accès SQL Server.

---

## Exemple

```java
Connection connection =
DriverManager.getConnection(url, user, password);
```

---

# 📦 Package util

## InputHelper.java

Classe utilitaire permettant :
- lecture Scanner,
- validation des entrées,
- éviter répétition code.

---

# 🧠 Architecture MVC

```text
Vue
↓
Controller
↓
Service
↓
DAO
↓
Database
```

---

# 🗄️ Base de Données SQL Server

## Tables Principales

| Table | Description |
|---|---|
| Users | Utilisateurs |
| Assignments | Devoirs |
| Criteres | Critères d’évaluation |
| Submissions | Travaux soumis |
| ReviewAssignments | Attributions corrections |
| Evaluations | Corrections |
| EvaluationDetails | Notes par critères |

---

# 🔗 Relations Principales

## Users

Contient :
- étudiants,
- enseignants.

---

## Assignments

Contient les devoirs créés par enseignant.

---

## Criteres

Chaque assignment possède plusieurs critères.

```text
Assignment 1 → N Critères
```

---

## Submissions

Travaux envoyés par étudiants.

```text
User 1 → N Submissions
Assignment 1 → N Submissions
```

---

## ReviewAssignments

Détermine :
Qui corrige quel travail.

---

## Evaluations

Contient :
- commentaires,
- notes,
- corrections.

---

## EvaluationDetails

Contient les notes données pour chaque critère.

---

# ⚙️ Script SQL

## Création de la Base de Données

```sql
CREATE DATABASE PeerReview;
GO

USE PeerReview;
GO
```

---

## Table Users

```sql
CREATE TABLE Users(

    id INT PRIMARY KEY IDENTITY(1,1),

    nom VARCHAR(100) NOT NULL,

    email VARCHAR(100) UNIQUE NOT NULL,

    motDePasse VARCHAR(100) NOT NULL,

    role VARCHAR(20) NOT NULL
);
GO
```

---

## Table Assignments

```sql
CREATE TABLE Assignments(

    id INT PRIMARY KEY IDENTITY(1,1),

    titre VARCHAR(255) NOT NULL,

    description TEXT NOT NULL,

    dateLimite DATE NOT NULL
);
GO
```

---

## Table Criteres

```sql
CREATE TABLE Criteres(

    id INT PRIMARY KEY IDENTITY(1,1),

    nom VARCHAR(255) NOT NULL,

    noteMax INT NOT NULL,

    assignment_id INT NOT NULL,

    FOREIGN KEY (assignment_id)
    REFERENCES Assignments(id)
);
GO
```

---

## Table Submissions

```sql
CREATE TABLE Submissions(

    id INT PRIMARY KEY IDENTITY(1,1),

    fichierPDF VARCHAR(255) NOT NULL,

    dateSubmission DATE DEFAULT GETDATE(),

    etudiant_id INT NOT NULL,

    assignment_id INT NOT NULL,

    FOREIGN KEY (etudiant_id)
    REFERENCES Users(id),

    FOREIGN KEY (assignment_id)
    REFERENCES Assignments(id)
);
GO
```

---

## Table ReviewAssignments

```sql
CREATE TABLE ReviewAssignments(

    id INT PRIMARY KEY IDENTITY(1,1),

    evaluateur_id INT NOT NULL,

    submission_id INT NOT NULL,

    dejaFait BIT DEFAULT 0,

    FOREIGN KEY (evaluateur_id)
    REFERENCES Users(id),

    FOREIGN KEY (submission_id)
    REFERENCES Submissions(id)
);
GO
```

---

## Table Evaluations

```sql
CREATE TABLE Evaluations(

    id INT PRIMARY KEY IDENTITY(1,1),

    commentaire TEXT NOT NULL,

    dateEvaluation DATE DEFAULT GETDATE(),

    evaluateur_id INT NOT NULL,

    submission_id INT NOT NULL,

    FOREIGN KEY (evaluateur_id)
    REFERENCES Users(id),

    FOREIGN KEY (submission_id)
    REFERENCES Submissions(id)
);
GO
```

---

## Table EvaluationDetails

```sql
CREATE TABLE EvaluationDetails(

    id INT PRIMARY KEY IDENTITY(1,1),

    note INT NOT NULL,

    evaluation_id INT NOT NULL,

    critere_id INT NOT NULL,

    FOREIGN KEY (evaluation_id)
    REFERENCES Evaluations(id),

    FOREIGN KEY (critere_id)
    REFERENCES Criteres(id)
);
GO
```

---

# 🔄 Flow Complet du Système

## Étape 1

L’enseignant crée un assignment :
- titre,
- description,
- date limite,
- critères,
- notes maximales.

---

## Étape 2

Les étudiants soumettent leurs fichiers PDF.

---

## Étape 3

Le système attribue automatiquement :
- 2 corrections par étudiant,
- attribution aléatoire,
- aucune auto-correction.

---

## Étape 4

Les étudiants :
- téléchargent les PDF,
- donnent des notes,
- ajoutent commentaires.

---

## Étape 5

Le système :
- calcule les moyennes,
- affiche les évaluations.

---

## Étape 6

L’enseignant :
- valide les notes,
- publie les résultats.

---

# 💡 Exemple Réel

## Assignment

```text
Projet Java POO
```

---

## Critères

| Critère | Note |
|---|---|
| POO | /10 |
| Structure | /5 |
| Documentation | /5 |

---

## Étudiants

- Ali
- Sara
- Omar

---

## Submissions

| Étudiant | PDF |
|---|---|
| Ali | ali.pdf |
| Sara | sara.pdf |
| Omar | omar.pdf |

---

## Review Assignments

| Évaluateur | Travail |
|---|---|
| Ali | sara.pdf |
| Sara | omar.pdf |
| Omar | ali.pdf |

---

# 🚀 Installation et Exécution

## 1. Cloner le projet

```bash
git clone <repository-url>
```

---

## 2. Ouvrir le projet

Ouvrir le dossier :

```text
PeerReview
```

dans IntelliJ IDEA.

---

## 3. Configurer SQL Server

Modifier :
- URL,
- username,
- password

dans :

```java
ConnectionDatabase.java
```

---

## 4. Exécuter SQLQuery.sql

Créer la base de données avec SQL Server Management Studio.

---

## 5. Lancer le projet

Exécuter :

```text
Main.java
```

---

# 🧠 Concepts Java Utilisés

- Classes et Objets
- Encapsulation
- Getters / Setters
- Constructeurs
- Interfaces
- Héritage
- Polymorphisme
- Architecture MVC
- DAO Pattern
- JDBC

---

# 🧮 Concepts SQL Utilisés

| Concept | Description |
|---|---|
| PRIMARY KEY | Identifiant unique |
| FOREIGN KEY | Relation tables |
| INSERT | Ajouter données |
| SELECT | Lire données |
| UPDATE | Modifier |
| DELETE | Supprimer |

---

# ❓ Questions Possibles en Soutenance

## Pourquoi MVC ?

MVC permet de séparer :
- données,
- interface utilisateur,
- logique métier.

Cela améliore :
- organisation,
- maintenance,
- évolutivité.

---

## Pourquoi DAO ?

DAO permet de séparer :
- SQL,
- logique Java.

Cela facilite :
- maintenance,
- réutilisation,
- changement futur de base de données.

---

## Pourquoi Service Layer ?

Pour centraliser :
- règles métier,
- validations,
- calculs.

---

## Pourquoi Encapsulation ?

Pour protéger les données des objets.

---

## Pourquoi ReviewAssignment ?

Pour gérer :
- attribution des corrections,
- relation reviewer ↔ submission.

---

## Pourquoi EvaluationDetail séparé ?

Parce qu’une évaluation contient plusieurs notes par critères.

---

# ✅ Résultat Final

Le système permet :

✅ Gestion des devoirs  
✅ Soumission PDF  
✅ Attribution automatique  
✅ Évaluations anonymes  
✅ Notes par critères  
✅ Publication résultats  
✅ Gestion complète Peer Review académique  

---

# 👨‍💻 Auteur

Projet réalisé dans le cadre d’un projet académique Java POO avec architecture MVC, DAO Pattern et SQL Server.
