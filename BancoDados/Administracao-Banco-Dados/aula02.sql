create sequence sid_obra;

insert into obra values (nextval('sid_obra'), '2', 'bom dia a todos');
insert into obra values (nextval('sid_obra'), '4', 'fé deus') returning id_obra;

select * from obra;

create sequence sid_maquina;

insert into maquina values (nextval('sid_maquina'), '69', '3 listra');
insert into maquina values (nextval('sid_maquina'), '24', 'jacare');

select * from maquina;


create table obraMaq(
	id_obra serial,
	codigo varchar(30) unique,
	descricao varchar(30),
	
)

create sequence sid_usa;


create table usa (
    id_usa bigint,
    id_obra bigint,
    id_maquina bigint,
    data_uso date,
    constraint pk_usa PRIMARY KEY (id_usa),
    constraint fk_usa_obra foreign key (id_obra)
                    REFERENCES obra,
    constraint maquina foreign key (id_maquina)
                    REFERENCES maquina
);


insert into usa values (nextval('sid_usa'), (select id_obra from obra where codigo='2'),(select id_maquina from maquina where codigo='69'),'25/07/2019');
insert into usa values (nextval('sid_usa'), (select id_obra from obra where codigo='2'),(select id_maquina from maquina where codigo='24'),'25/07/2000');

insert into usa values (nextval('sid_usa'), (select id_obra from obra where codigo='3'),(select id_maquina from maquina where codigo='69'),'25/07/2019');
insert into usa values (nextval('sid_usa'), (select id_obra from obra where codigo='3'),(select id_maquina from maquina where codigo='24'),'25/07/2000');

select * from usa



--union
--union reune sem as repetidas
--union all reune com as repetidas, traz todos os registros sem eliminar nenhum 
select inst_nome as Nome, inst_telefone from instrutor
union 
select alu_nome as Nome, alu_tel from aluno;


--ordenar com uniao
with pessoas as(
	select inst_nome as Nome, inst_telefone as telefone from instrutor
	union
	select alu_nome as Nome, alu_tel as telefone from aluno
)
	select Nome,telefone from pessoas order by 1


--intersect mostra os que nas duas tabelas
select inst_nome as Nome from instrutor
intersect 
select alu_nome as Nome from aluno;

--except -> diferença entre os conjuntos A e B (A - B), ou seja, os elementos que pertencem a A e não a B
select inst_nome as Nome from instrutor
except 
select alu_nome as Nome from aluno;



--pagina 20 
--ex1
select nome_cliente as nome, codigo_cliente as codigo from cliente
union 
select nome_vendedor, codigo_vendedor from vendedor
order by 1

--ex2
select*from pedido
select descricao  from produto where codigo_produto in (select codigo_produto from produto intersect select codigo_produto from item_pedido);


--VIEW

--view tabela virtual que fica armazenada dentro do banco de dados
create view v_aluno_votuporanga
as
select *from alunov
where cidade = 'Votuporanga';

select*from v_aluno_votuporanga;
--pode se utilizar qualquer outros comandos, exemplo
select*from v_aluno_votuporanga order by nome;

--ex 2
create view v_cliente_pedido as select nome_cliente, count(num_pedido)from cliente cli, pedido ped where cli.codigo_cliente = ped.codigo_cliente
group by 1 order by 2 desc;

select*from v_cliente_pedido;
