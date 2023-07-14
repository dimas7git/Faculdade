create table carro(
    chassi character varying (15),
    placa character varying (7) not null,
    modelo character varying (20) not null,
    montadora character varying (20) not null,
    ano integer not null,
    preco real not null,
    constraint pk_chassi primary key (chassi) 
)

insert into carro values ('123456789123456', '1234567', 'sedan', 'audi', 2010, 1000),
                         ('123456785433456', '4353453', 'rebaixado', 'fiat', 2013, 2000),
                         ('123456213234456', '9384738', 'alto', 'honda', 2015, 3000),
                         ('234256789123456', '1231212', 'pulante', 'susuki', 2010, 4000),
                         ('122356763323456', '4576457', 'teto solar', 'fiat', 2007, 5000),
                         ('123123123123456', '6546542', 'sedan', 'mercedez', 2019, 6000),
                         ('123456783453436', '3523643', 'sedan', 'audi', 2012, 7000),
                         ('123456789123156', '1231252', 'rebaixado', 'audi', 2011, 8000),
                         ('123123123125326', '1264365', 'teto solar', 'mercedez', 2009, 9000),
                         ('123456132131256', '1241241', 'alto', 'honda', 2002, 10010);
                    
                    drop table carro;
                    select * from carro;
--ex 3                    
select * from carro where montadora  = 'fiat' and ano = 2007;                        
--ex 4
select * from carro where preco > 3000 and montadora <> 'audi'; 
--ex 5
select modelo,montadora from carro where ano between 2008 and 2020 and preco > 3000 and preco < 8000;
--ex 6
select modelo, montadora, preco from carro order by preco desc;
--ex 7
select modelo as "Modelo Carro",montadora, ano,preco from carro where ano >= 2007 and ano <= 2010 order by preco;
--ex 8 
select modelo as "Modelo Carro",montadora, ano,preco from carro where ano between 2007 and 2010 order by preco;
--ex 9 
select modelo as "Carros de 2010",montadora,preco from carro order by preco;
-- ex 10
select modelo, max(preco) from carro group by modelo;
--ex 11
select  montadora, count (modelo) from carro group by montadora;
--ex 12
select montadora, count(modelo) from carro group by montadora order by montadora ; 
--ex 13
select sum(preco) as "Soma", avg(preco) as "Media" from carro;
--ex 14
select montadora, ano, max(preco) from carro where montadora = 'audi' group by montadora,ano;
--ex 15
select * from carro where montadora like 'f%' or montadora like '%f';
--ex 16
select * from carro where montadora ilike 'f%' or montadora ilike '%f';
--ex 17
select modelo,montadora,preco from carro where montadora = 'fiat' and modelo like '%i%' order by modelo;
--ex 18
select * from carro where ano between 2008 and 2011 and modelo like '%i%' order by ano desc;
