CREATE TABLE EMPREGADO(idEmp integer PRIMARY KEY, pNome character varying (20) NOT NULL, sNome character varying(20) NOT NULL, idade integer, salario real NOT NULL, cargo character varying(30) NOT NULL);

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

select * from empregado;

select * from empregado where idade between 27 and 32 order by idade;

select * from empregado where idade > 26 and idade < 33;


-- usando between
select pnome,idade from empregado where pNome between 'Carlos' and 'Rúbia' and idade > 35 ;
--usando and
select * from empregado where pNome > 'Carlos' and pNome < 'Rúbia' and idade > 35;

-- usando between
select pnome, idade,salario from empregado  where salario between 1800 and 4000 and  idade between 25 and 40 order by salario asc, idade desc;

-- usando and
select pnome, idade, salario from empregado where salario > 1800 and salario < 4000 and idade > 25 and idade < 40 order by salario asc, idade desc;


-- like like

select * from empregado where pnome like 'A%';

select pnome, cargo from empregado where pnome like '%a%';

-- ex like

select * from empregado where pnome like '_e%' or pnome like '%i_';]

select pnome from empregado where pnome like '%a%s%' ;

-- utilizando ilike nao diferencia minusculo de maisculo
select pnome from empregado where pnome ilike '_e%' or pnome ilike '%i_';

select pnome from empregado where pnome ilike '%a%s%';


-- funcoes agregradas 
-- avg media
select avg(salario) as "Média Salarial" from empregado;

-- agrupar
select cargo, avg(idade) from empregado group by cargo;

--max pega o maior valor
select max (idade) from empregado;
select max(salario) from empregado;
select max (pnome) from empregado;

select cargo, avg(salario) from empregado group by cargo;

-- menor e maior
select cargo, max(salario), min(salario) from empregado group by cargo;

--count conta quanto registr tem na tabela
select count (pnome) from empregado;
select cargo, count(pnome) from empregado group by cargo; 

--sum é pra somar
select sum(salario) from empregado;
select cargo, sum(salario) from empregado group by cargo;

-- having restringir 
select cargo, sum(salario) from empregado group by cargo order by sum(salario);
select cargo, sum(salario) from empregado group by cargo having sum(salario)>10000 order by sum(salario);
select cargo, sum(salario) from empregado where cargo <> 'Gerente' group by cargo having sum(salario)>10000 order by sum(salario);
select cargo, max(salario), min(salario) from empregado where cargo <> 'Gerente' and salario > 2000 and salario < 2500 group by cargo;
select cargo, max(salario), min(salario) from empregado where cargo <> 'Gerente 'group by cargo having min(salario) < 2500 and max(salario) > 2000;
