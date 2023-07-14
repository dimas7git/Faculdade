CREATE TABLE curso(
idcurso varchar(5),
nome varchar(50) NOT NULL,
semestre integer,
constraint pk_curso primary key (idcurso)
);

create table aluno(
prontuario int,
nome varchar(50) NOT NULL,
idade int,
	CONSTRAINT pk_aluno PRIMARY KEY (prontuario)
);

INSERT INTO ALUNO VALUES (52, 'Dimass', 29) , (666, 'Henrique', 39);

drop table aluno;
select * from aluno;
delete  from aluno;
delete from aluno where idade = 18;
update aluno set idade = 22 where prontuario = 123;


-- atividade --

create table aluno(
prontuario varchar(30),
nome varchar(30) not null,
dtanasc date,
sexo char(1),
 CONSTRAINT pk_aluno PRIMARY KEY (prontuario)	
);

create table curso(
idcurso integer,
nomecurso varchar(30) not null,
nrosemestre integer,
dtafundacao date,
CONSTRAINT pk_curso primary key (idcurso)
);

insert into aluno values ('llaa', 'Paulo', '1986-07-01', 'm'),
                          ('llbb', 'Ana', '1990-07-08', 'f'),
						  ('llcc', 'Julio', '1980-05-08', 'm'),
						  ('lldd', 'Carlos', '1983-11-10', 'm'),
						  ('llee', 'Gabriele', '1990-05-08', 'f'),
						  ('llff', 'Antonio', '1955-06-15', 'm'),
						  ('llgg', 'Ana', '1975-12-08', 'f'),
						  ('llhh', 'Mara', '1970-07-07', 'f'),
						  ('llii', 'Roberto', '1956-07-01', 'm'),
						  ('lljj', 'Carmen', '1950-02-03', 'f')
						  
insert into curso values(1, 'Ciencia da computação', 8, '1986-03-01'),                       
						 (2, 'Direito', 8, '1972-12-14'),
						 (3, 'Medicina', 12, '2000-07-05'),
						 (4, 'Egenharia eletrica', 10, '1996-12-10'),
						 (5, 'Biologia', 10, '1993-06-06'),
						 (6, 'Matematica', 8, '1986-07-01')
						 
select * from aluno;

--Q4---Q5--
delete from curso where nomecurso = 'Direito';
--Q6
update curso set idcurso = 10 where nomecurso = 'Medicina';
--Q7--
update aluno set nome = 'Ana Paula' where prontuario = 'llgg';
