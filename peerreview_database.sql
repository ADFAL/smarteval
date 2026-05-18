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


INSERT INTO Users (nom, email, motDePasse, role)
VALUES
('John Smith', 'john.smith@gmail.com', '1234', 'etudiant'),
('Emma Johnson', 'emma.johnson@gmail.com', '1234', 'etudiant'),
('Michael Brown', 'michael.brown@gmail.com', '1234', 'etudiant'),
('Sophia Williams', 'sophia.williams@gmail.com', '1234', 'etudiant'),
('Lucas Silva', 'lucas.silva@gmail.com', '1234', 'etudiant'),
('Olivia Taylor', 'olivia.taylor@gmail.com', '1234', 'etudiant'),
('Professor David Miller', 'david.miller@gmail.com', 'admin', 'professeur');
GO


INSERT INTO Assignments (titre, description, dateLimite)
VALUES
(
    'Java OOP Project',
    'Develop a Java application using object-oriented programming concepts.',
    '2026-06-01'
),
(
    'Laravel Web Application',
    'Create a web application using Laravel framework.',
    '2026-06-10'
),
(
    'Database Modeling',
    'Design and implement a relational database project.',
    '2026-06-15'
);
GO

INSERT INTO Criteres (nom, noteMax, assignment_id)
VALUES
('Code Quality', 10, 1),
('OOP Concepts', 10, 1),
('User Interface', 5, 1),

('MVC Architecture', 10, 2),
('Database Integration', 10, 2),
('Responsive Design', 5, 2),

('ER Diagram', 10, 3),
('SQL Queries', 10, 3),
('Normalization', 5, 3);
GO


INSERT INTO Submissions (fichierPDF, dateSubmission, etudiant_id, assignment_id)
VALUES
('john_java_project.pdf', '2026-05-15', 1, 1),
('emma_java_project.pdf', '2026-05-16', 2, 1),
('michael_laravel_project.pdf', '2026-05-17', 3, 2),
('sophia_laravel_project.pdf', '2026-05-18', 4, 2),
('lucas_database_project.pdf', '2026-05-18', 5, 3),
('olivia_database_project.pdf', '2026-05-19', 6, 3);
GO


INSERT INTO ReviewAssignments (evaluateur_id, submission_id, dejaFait)
VALUES
(2, 1, 1),
(1, 2, 0),
(4, 3, 1),
(3, 4, 0),
(6, 5, 1),
(5, 6, 0);
GO


INSERT INTO Evaluations (commentaire, dateEvaluation, evaluateur_id, submission_id)
VALUES
(
    'Excellent project structure and clean code.',
    '2026-05-20',
    2,
    1
),
(
    'Good Laravel implementation but needs better MVC separation.',
    '2026-05-20',
    4,
    3
),
(
    'Very good database design with clear normalization.',
    '2026-05-21',
    6,
    5
);
GO


INSERT INTO EvaluationDetails (note, evaluation_id, critere_id)
VALUES
(9, 1, 1),
(10, 1, 2),
(4, 1, 3),

(7, 2, 4),
(8, 2, 5),
(4, 2, 6),

(9, 3, 7),
(8, 3, 8),
(5, 3, 9);
GO