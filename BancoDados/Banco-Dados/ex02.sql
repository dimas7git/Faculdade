--tabela um
insert into pessoa values ('222.222.333-44','caio','10/04/2000'),
                          ('333.222.333-44','dimas','10/04/2000'),
                          ('444.222.333-44','junior','10/04/2000'),
                          ('555.222.333-44','lucas','10/04/2000'),
                          ('666.222.333-44','saas','10/04/2000');
                          
                          
                          
create table pessoa(
    cpf varchar(30) not null,
    nome varchar(50) not null,
    datanasc date,
    constraint pk_pessoa primary key(cpf)
 );
    
 
 select * from pessoa;
 
 
 
 --tabela dois
 
 
 create table cliente (
     cpf varchar(13)not null,
     nome varchar (69) not null,
     constraint pk_cliente primary key (cpf)
);

 create table pedido(
      cod_pedido integer not null,
      valor numeric (9,2) not null,
      cpf_cli varchar(13)not null,
     constraint pk_pedido primary key (cod_pedido),
     constraint fk_pedido_cliente foreign key (cpf_cli) references cliente on update cascade
     on delete cascade
 );
 
 insert into cliente values('123.321.44','pedro'),
                            ('312.122.44','carlos'),
                            ('123.423.22','dom'),
                            ('444.223.244','roberto'),
                            ('123.123.44','arthur');
     
select * from cliente;   

insert into pedido values(1,450.30,'123.321.44');

insert into pedido values(2,350.30,'312.122.44'),
                         (3,650.30,'123.423.22'),
                         (4,750.30,'444.223.244'),
                         (5,850.30,'123.123.44');
select * from pedido;





--tabela tres

create table funcionario(
   codfunc serial,
   nome varchar(50) not null,
   constraint pk_funcionario primary key (codfunc)
);

insert into funcionario(nome) values('Rafael Miani');
insert into funcionario(nome) values('Ana Mara');

select * from funcionario;

create table dependente(
  codDepend integer,
  codfunc integer,
  nome varchar(50) not null,
  constraint pk_dependente primary key (codDepend, codfunc),
  constraint fk_func_depend foreign key (codfunc) references funcionario  
);

-- tabela n pra n com a tabela funcionario da tabela tres

create table projeto(
  idProjeto integer,
  nomeProj varchar(50) not null,
  constraint pk_projeto primary key(idProjeto)
);

insert into projeto values (1, 'Teste');

select*from projeto;

-- tabela n pra n que foi criado por causa do relacionamento n pra n
create table trabalha(
   codfunc integer,
   idProj integer,
   constraint pk_trabalha primary key (codfunc, idProj),
   constraint fk_func_trabalha foreign key (codfunc) references funcionario,
   constraint fk_proj_trabalha foreign key (idProj) references projeto
);

insert into trabalha values(2, 1);

select * from trabalha;


-- tarefa

create table curso(
    idCurso integer,
    nome varchar(50),
    constraint pk_curso primary key(idCurso)
);

create table aluno(
     prontuario integer,
     nome varchar(50),
     idCurso integer,
    constraint pk_aluno primary key (prontuario),
    constraint fk_curso foreign key (idCurso) references curso

);

create table disciplina(
    codDisc integer,
    nome varchar(50),
    constraint pk_disciplina primary key(codDisc)
);

create table alunodisc(
    prontuario integer,
    codDisc integer,
    constraint pk_alunodisc primary key (prontuario, codDisc),
    constraint fk_aluno foreign key (prontuario) references aluno,   
    constraint fk_disciplina foreign key (codDisc) references disciplina
);
