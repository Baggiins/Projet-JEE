CREATE TABLE Semestre(
id_semestre INT NOT NULL,
nom_semestre VARCHAR (25),
date_depart_semestre DATE,
date_fin_semestre DATE,
CONSTRAINT PK_Semestre PRIMARY KEY (id_semestre)
);

CREATE TABLE Etudiant(
id_etudiant INT NOT NULL,
prenom_etudiant VARCHAR(50),
nom_etudiant VARCHAR(50),
CONSTRAINT PK_Etudiant PRIMARY KEY (id_etudiant)
);

CREATE TABLE Examen(
id_exam INT NOT NULL,
id_semestre INT NOT NULL,
date_exam DATE,
CONSTRAINT PK_Examen PRIMARY KEY (id_exam),
CONSTRAINT FK_Examen FOREIGN KEY (id_semestre) REFERENCES Semestre (id_semestre) ON DELETE CASCADE
);

CREATE TABLE Categorie_resultat(
res_cat_code INT NOT NULL,
res_note_basse INT,
res_note_haute INT,
res_pass_echec VARCHAR (25),
CONSTRAINT PK_Categorie_resultat PRIMARY KEY (res_cat_code)
);

CREATE TABLE Examen_Resultat(
id_exam INT NOT NULL,
id_etudiant INT NOT NULL,
classe VARCHAR (50),
res_cat_code INT NOT NULL,
CONSTRAINT PK_Examen_Result PRIMARY KEY (id_exam,id_etudiant),
CONSTRAINT FK_Examen_Result_code FOREIGN KEY (res_cat_code) REFERENCES Categorie_resultat (res_cat_code) ON DELETE CASCADE,
CONSTRAINT FK_Examen_Result_exam FOREIGN KEY (id_exam) REFERENCES Examen (id_exam) ON DELETE CASCADE,
CONSTRAINT FK_Examen_Result_et FOREIGN KEY (id_etudiant) REFERENCES Etudiant (id_etudiant) ON DELETE CASCADE
);

CREATE TABLE Calendrier(
nbr_jour INT NOT NULL,
date_jour DATE,
CONSTRAINT PK_Calendrier PRIMARY KEY (nbr_jour)
);

CREATE TABLE Presence_etudiant(
nbr_jour INT NOT NULL,
id_etudiant INT NOT NULL,
present_on CHAR (3),
CONSTRAINT PK_Examen_Result PRIMARY KEY (nbr_jour,id_etudiant),
CONSTRAINT FK_Examen_Result_nbr_jour FOREIGN KEY (nbr_jour) REFERENCES Calendrier (nbr_jour) ON DELETE CASCADE,
CONSTRAINT FK_Examen_Result_et FOREIGN KEY (id_etudiant) REFERENCES Etudiant (id_etudiant) ON DELETE CASCADE
);
