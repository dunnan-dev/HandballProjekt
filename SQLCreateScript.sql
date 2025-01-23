USE master;

-- Slet databasen, hvis den findes
IF DB_ID('MidtVejsProjekt_V2') IS NOT NULL
BEGIN
    ALTER DATABASE MidtVejsProjekt_V2 SET SINGLE_USER WITH ROLLBACK IMMEDIATE;
    DROP DATABASE MidtVejsProjekt_V2;
END

-- Opret databasen, hvis den ikke eksisterer
IF DB_ID('MidtVejsProjekt_V2') IS NULL
    CREATE DATABASE MidtVejsProjekt_V2;
	GO

-- Skift til den nye database
USE MidtVejsProjekt_V2;

CREATE TABLE Team (
	TeamID int IDENTITY (1,1) PRIMARY KEY NOT NULL,
	[Name] VARCHAR (50) NOT NULL,
	Score INT,
	Wins INT,
	Loss INT,
	Draw INT
	);

CREATE TABLE [Match] (
	MatchID INT IDENTITY (1,1) PRIMARY KEY NOT NULL,
	HomeTeam INT NOT NULL,
	AwayTeam INT NOT NULL,
	FOREIGN KEY (HomeTeam) REFERENCES Team(TeamID),
	FOREIGN KEY (AwayTeam) REFERENCES Team(TeamID)
	);

CREATE TABLE EventType (
	EvenTypeID INT IDENTITY (1,1) PRIMARY KEY NOT NULL,
	[Name] VARCHAR (25) NOT NULL
	);

CREATE TABLE [Event] (
	EventID INT IDENTITY (1,1) PRIMARY KEY NOT NULL,
	MatchID INT NOT NULL,
	EventTypeID INT NOT NULL,
	TeamID INT NOT NULL,
	[Time] TIME,

	FOREIGN KEY (MatchID) REFERENCES [Match](MatchID),
	FOREIGN KEY (EventTypeID) REFERENCES EventType(EventTypeID),
	FOREIGN KEY (TeamID) REFERENCES [Team](TeamID)
	);

INSERT INTO EventType ([Name])
	VALUES ('Goal'),('Suspension');

INSERT INTO Team ([Name], Score, Wins, Loss, Draw)
	VALUES 
	(Norviking, 0, 0, 0, 0),
	(Herning, 0, 0, 0, 0),
	(Karup, 0, 0, 0, 0),
	(Ikast, 0, 0, 0, 0),
	(EAMV, 0, 0, 0, 0),
	(Snejbjerg, 0, 0, 0, 0);

