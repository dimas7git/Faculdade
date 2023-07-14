CREATE TABLE EMPREGADO(idEmp integer,
   	    	pNome VARCHAR (20) NOT NULL,
   	    	sNome VARCHAR(20) NOT NULL,
   	    	idade integer,
   	    	salario real NOT NULL,
   	    	cargo VARCHAR(30) NOT NULL,
   	    	CONSTRAINT pk_empregado PRIMARY KEY (idEmp));

--drop table empregado

INSERT INTO empregado VALUES (1,'Carlos','Alberto',24,2500,'Técnico em Segurança');
INSERT INTO empregado VALUES (2,'Pedro','Augusto',32,3500,'Analista de Sistemas');
INSERT INTO empregado VALUES (3,'Mara','Antonia',27,1200,'Secretária');
INSERT INTO empregado VALUES (4,'Derci','Gonçalves',56,6500,'Gerente');
INSERT INTO empregado VALUES (5,'Pedro','Bueno',28,1500,'Estagiário');
INSERT INTO empregado VALUES (6,'Edson','Arantes',60,7500,'Gerente');
INSERT INTO empregado VALUES (7,'Odete','Roitman',54,2000,'Técnico em Segurança');
INSERT INTO empregado VALUES (8,'Antonio','Da Lua',38,2500,'Analista de Sistemas');
INSERT INTO empregado VALUES (9,'Sassa','Mutema',55,3000,'Vendedor');
INSERT INTO empregado VALUES (10,'José','Silvério',42,2800,'Vendedor');
INSERT INTO empregado VALUES (11,'Gabriel','Oliveira',24,2500,'Técnico em Segurança');
INSERT INTO empregado VALUES (12,'Flávia','Camargo',29,4200,'Analista de Sistemas');
INSERT INTO empregado VALUES (13,'Marina','Delbonis',20,1000,'Secretária');
INSERT INTO empregado VALUES (14,'Paulo','Roberto',33,1500,'Vendedor');
INSERT INTO empregado VALUES (15,'José','Carlos da Silva',27,2900,'Analista de Sistemas');
INSERT INTO empregado VALUES (16,'Rúbia','Miranda',29,3500,'Administrador');
INSERT INTO empregado VALUES (17,'Roberto','Andrade Silva',35,3300,'Vendedor');
INSERT INTO empregado VALUES (18,'Ana','Julia',31,2900,'Secretária');
INSERT INTO empregado VALUES (19,'Pedro','Antonio',41,3500,'Administrador');
INSERT INTO empregado VALUES (20,'Ana','Mara',22,2200,'Psicóloga');
INSERT INTO empregado VALUES (21,'João','Augusto',44,5500,'Gerente');

select * from empregado ORDER BY pnome;

select pnome, cargo from empregado;

select pnome, snome, salario from empregado;

select cargo, idade from empregado;

select * from empregado where idade > 32;

select pnome,salario from empregado where salario>3000;

select pnome,salario from empregado where pnome> 'João' order by pnome;

select distinct (pnome) from empregado;

--ex ex ex ex ex ex ex ex ex ex ex ex ex ex ex ex ex ex ex ex ex ex ex ex ex ex ex ex ex ex ex ex ex ex ex ex ex ex ex ex ex ex ex ex  

select pnome, snome from empregado where idade > 30;

select pnome, salario,cargo from empregado where cargo = 'Vendedor';

select distinct cargo from empregado order by cargo;

--- comandos adicioanis

select pnome,cargo from empregado where cargo ='Secretária' or cargo='Gerente';

select pnome, cargo, salario from empregado where cargo='Vendedor' or salario>3000 order by salario;

select pnome,cargo,salario from empregado where cargo='Analista de Sistemas' and salario>4000;

select pnome, cargo from empregado where cargo='Gerente' and pnome='Derci';

--selecionar todos empregados vendedores gerentes o estagiarios

select pnome,cargo from empregado where cargo in('Gerente','Vendedor','Estagiário') order by cargo;

-- igual o or


select pnome,cargo,salario from empregado where cargo in('Analista de Sistema','Técnico em Segurança') and salario>2000;

select pnome, cargo from empregado where cargo not in ('Gerente', 'Vendedor');

--ordem decrescente e mudar o titulo
select pnome as "Primeiro Nome", salario, cargo  from empregado where salario>2500 order by salario desc;
