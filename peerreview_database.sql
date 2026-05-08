CREATE DATABASE PeerReview;
GO

USE PeerReview;
GO

CREATE TABLE Users(

    id INT PRIMARY KEY IDENTITY(1,1),

    nom VARCHAR(100) NOT NULL,

    email VARCHAR(100) UNIQUE NOT NULL,

    motDePasse VARCHAR(100) NOT NULL,

    role VARCHAR(20) NOT NULL
);
GO

CREATE TABLE Assignments(

    id INT PRIMARY KEY IDENTITY(1,1),

    titre VARCHAR(255) NOT NULL,

    description TEXT NOT NULL,

    dateLimite DATE NOT NULL
);
GO

CREATE TABLE Criteres(

    id INT PRIMARY KEY IDENTITY(1,1),

    nom VARCHAR(255) NOT NULL,

    noteMax INT NOT NULL,

    assignment_id INT NOT NULL,

    FOREIGN KEY (assignment_id)
    REFERENCES Assignments(id)
);
GO

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