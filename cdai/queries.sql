-- Jason Blackwell
-- Jacob Colstrom
-- Phase 3 Queries

-- 01
SELECT Crit_ID, t.AssessmentID, Sem_Start, AVG(Score) as Average
FROM Takes t, Assessment a
WHERE Crit_ID = 'A2F10C2'
AND t.AssessmentID = a.AssessmentID
AND a.AssessmentID = 'A2F10'
AND Sem_Start = 'F10';

-- 02
SELECT DISTINCT Crit_ID, t.AssessmentID, Sem_Start, (SELECT AVG(score) FROM Takes b WHERE b.Crit_ID = t.Crit_ID)  AS Average
FROM Takes t, Assessment a
WHERE t.AssessmentID = 'A2F10'
AND t.AssessmentID = a.AssessmentID
AND Sem_Start = 'F10';

-- 03
SELECT DISTINCT Crit_ID, AssessmentID, (SELECT AVG(Score) FROM Takes a WHERE a.Crit_ID = t.Crit_ID) AS Average
FROM Takes t
WHERE AssessmentID = 'A2F10';

-- 04
SELECT t.AssessmentID, Sem_Start, AVG(Score) AS Average
FROM Takes t, Assessment a
WHERE a.AssessmentID = 'A2F10'
AND t.AssessmentID = a.AssessmentID
AND Sem_Start = 'F10';

-- 05
SELECT AssessmentID, AVG(Score) as Average
FROM Takes
WHERE AssessmentID = 'A2F10';

-- 06
SELECT AssessmentID, MAX(Average)
FROM (SELECT DISTINCT AssessmentID, (SELECT AVG(Score) From Takes b WHERE a.AssessmentID = b.AssessmentID) as Average FROM Takes a) t;

-- 07
SELECT AssessmentID, MIN(Average)
FROM (SELECT DISTINCT AssessmentID, (SELECT AVG(Score) FROM Takes b WHERE a.AssessmentID = b.AssessmentID) as Average FROM Takes a) t;

-- 08
SELECT Emph, (SELECT AVG(Score) FROM Takes a WHERE t.UniversityID = a.UniversityID) AS Average, (SELECT MIN(Score) FROM Takes a WHERE t.UniversityID = a.UniversityID) AS Lowest, (SELECT MAX(Score) FROM Takes a WHERE t.UniversityID = a.UniversityID) AS Highest
FROM Emphasis e, Takes t
WHERE e.UniversityID = t.UniversityID
GROUP BY Emph;

-- 09 
SELECT F_Name, L_Name, AssessmentID, Crit_ID, Score
FROM Student s, Takes t
WHERE F_Name = 'Darcie'
AND L_Name LIKE '%Randle%'
AND s.UniversityID = t.UniversityID;

-- 10
SELECT F_Name, L_Name, (SELECT AVG(Score) FROM Takes a WHERE s.UniversityID = a.UniversityID) as Average, (SELECT MIN(Score) FROM Takes a WHERE s.UniversityID = a.UniversityID) as Lowest, (SELECT MAX(Score) FROM Takes a WHERE s.UniversityID = a.UniversityID) as Highest, Crit_ID, Score
FROM Student s, Takes t
WHERE F_Name = 'Darcie'
AND L_Name LIKE '%Randle%'
AND s.UniversityID = t.UniversityID;