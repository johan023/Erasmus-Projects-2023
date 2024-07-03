/* 1) Print how many students were born in Split */
SELECT COUNT(zip) FROM town, student
WHERE zip = zipbirth AND townname = 'Split'

/* 2) Print names of all courses for which the value of the ECTS points is 6. */
SELECT DISTINCT coursename from course
WHERE ects = 6.0

/* 3) Write a query which will perform a natural join of the relations teacher and orgunit. */
SELECT *
FROM teacher
NATURAL JOIN orgunit;

/* 4) Print how many different teachers have taught the course "Information networks". */
SELECT COUNT (DISTINCT teacherid) FROM coursegroup
NATURAL JOIN course
WHERE coursegroup.courseid = course.courseid AND course.coursename = 'Information networks'

/* 5) Print out the zip codes of the towns that are in the county named 'Zadarska'. */
SELECT zip FROM town 
NATURAL JOIN county
WHERE county.countyid = town.countyid AND county.countyname = 'Zadarska'

/* 6) Set teacher Klementina Lapaine to all course groups that were assigned to teacher Mirko Kasun. */
UPDATE coursegroup
SET teacherid = (SELECT teacherid FROM teacher WHERE firstname = 'Klementina' AND lastname = 'Lapaine')
WHERE teacherid = (SELECT teacherid FROM teacher WHERE firstname = 'Mirko' AND lastname = 'Kasun');

/* 7) Print last name and first name of teachers who are employed in organizational units whose name is shorter than the name of the directly superior organizational unit. In addition to the last name and the first name of the teacher, print also the name of the organizational unit in which he/she is employed. Do not print the tuples for teachers who stopped working (are no longer employed). Sort the records alphabetically by the name of the organizational unit, and by the last and first name of the teacher. */
SELECT lastname, firstname, orgunitname
FROM teacher
NATURAL JOIN orgunit AS ou1
WHERE LENGTH(ou1.orgunitname) < LENGTH((SELECT orgunitname FROM orgunit AS ou2 WHERE ou2.orgunitid = ou1.superorgunitid))
AND teacher.dateemployedto IS NULL
ORDER BY orgunitname, lastname, firstname

/* 8) Display course names that have an even number of characters, for all courses that were enrolled by at least one student in the academic year 2020/2021. */
SELECT coursename FROM course
WHERE LENGTH(coursename)%2 = 0
AND courseid IN (SELECT courseid FROM enrolledcourse WHERE academicyear = 2020)

/* 9) For the given relational schema STUDGPA={firstname, lastname, studentid, totalects} write a command to create the relation studgpa(STUDGPA). Data types should be as follows: 
	firstname, lastname - VARCHAR(25)
	studentid - VARCHAR(10)
	totalects - NUMERIC(4, 1) (the total number of ECTS points achieved by a student in passing the course)
Insert into the studgpa relation students whose total number of ECTS points achieved by passing the exam is strictly greater than 80 (The sum includes only exams that have been passed). */

CREATE TABLE studgpa (
    firstname VARCHAR(25),
    lastname VARCHAR(25),
    studentid VARCHAR(10),
    totalects NUMERIC(4, 1)
);

INSERT INTO studgpa (firstname, lastname, studentid, totalects)
SELECT firstname, lastname, studentid, SUM(CASE WHEN grade>1 THEN course.ects ELSE NULL END) AS totalects
FROM student
NATURAL JOIN exam
NATURAL JOIN course
GROUP BY studentid
HAVING SUM(CASE WHEN grade>1 THEN course.ects ELSE NULL END) > 80


/* 10) For each course and academic year, print out course id, course name, academic year, and the total capacity of the classroom in which that course was held during that academic year (name the column total_capacity). Print out only the records for those courses that weigh 6 ECTS points and for which the total capacity is greater than 200. */
SELECT course.courseid, course.coursename, courseacyear.academicyear, SUM(classroom.capacity) AS total_capacity
FROM course
NATURAL JOIN courseacyear 
NATURAL JOIN coursegroup 
NATURAL JOIN classroom 
WHERE course.ects = 6
GROUP BY course.courseid, courseacyear.academicyear
HAVING SUM(classroom.capacity) > 200


/* 11) For each coursegroup for a course taught in academic year 2021/2022, print out course group id, course name and the number of students in the group (name the column no_of_students). Print only those tuples for which the number of students in the course group for the course is greater than 10. */
SELECT enrolledcourse.studentgroupid, course.coursename, COUNT(studentid) as no_of_students
FROM enrolledcourse
LEFT JOIN course ON enrolledcourse.courseid = course.courseid
WHERE academicyear = 2021
GROUP BY enrolledcourse.studentgroupid, course.coursename, academicyear, course.courseid
HAVING COUNT(studentid) > 10;


/* 12) Add a new organizational unit named "Republic of Croatia", having id 1 and no super org. unit. Set the newly inserted org. unit as the super org. unit to all org. units that had no super org. unit so far (exclude "Republic of Croatia" from this, it has to remain as the root org. unit).*/
-- Insert the new organizational unit
INSERT INTO orgunit (orgunitid, orgunitname, superorgunitid)
VALUES (1, 'Republic of Croatia', NULL);
-- Update all organizational units with no super organizational unit
UPDATE orgunit
SET superorgunitid = 1
WHERE superorgunitid IS NULL AND orgunitid != 1

/* 13) For each course print out the course name, total number of negative grades and the total number of ungraded enrollments in that course. */
SELECT coursename,
(SELECT COUNT(studentid) FROM exam WHERE grade = 1 AND exam.courseid = course.courseid) AS negative_grades, 
(SELECT COUNT(studentid) FROM exam WHERE grade IS NULL AND exam.courseid = course.courseid) AS ungraded_enrollments
FROM course

