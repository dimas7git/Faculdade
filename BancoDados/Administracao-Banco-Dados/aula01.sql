create table correntista (
    cpf varchar(11),
    nome varchar(20),
    data_nasc date,
    cidade varchar(20),
    uf char(2),
    constraint pk_correntista primary key(cpf),
    constraint ck_idade check(cast((current_date - data_nasc)/360 as integer) >= 18));
	
insert into correntista
values ('123', 'joao', '30/12/2000','Votuporanga', 'SP');


  create table conta_corrente (
    num_conta integer,
    cpf  varchar(11),
    saldo numeric(7,2),
    constraint pkcontacorrente primary key(num_conta),
    constraint fkcontacorrente foreign key(cpf) references correntista,
    constraint ck_saldo check(saldo >= 500));
	
	insert into conta_corrente
	values (1,'123', 40);



insert into seq_funcionario values (nextval('sid_func'), '1234', 'joao', 'rua a', 'votuporanga', 5989);

insert into seq_salario_registro values(nextval('sid_salreg'),(select id_func from seq_funcionario where cpf = '1234'),6000, current_date);

create sequence sid_func;


