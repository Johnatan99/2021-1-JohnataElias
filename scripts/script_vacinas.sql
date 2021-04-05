drop database if exists atividadeVacinas;
create database atividadeVacinas;
use atividadeVacinas;

create table vacina(
	idVacina int not null auto_increment primary key,
    nome varchar(50) not null,
	paisOrigem varchar(50) not null,
	estagioPesquisa varchar(30),
	dtInicioPesquisa date not null,
	dtTerminoPesquisa date,
	quantidadeDoses int not null
);
create table aplicacao(
	idAplicacao int not null auto_increment primary key,
    fkIdVacina int not null,
    dtAplicacao date not null,
    nota varchar(10),
    foreign key(fkIdVacina) references vacina(idVacina)
);
create table pessoa(
	idPessoa int not null auto_increment primary key,
	nome varchar(50) not null,
    sobrenome varchar(100) not null,
	dtNascimento date not null,
	sexo char(1) not null,
	cpf varchar(14) not null,
    fkIdAplicacao int not null,
    foreign key(fkIdAplicacao) references aplicacao(idAplicacao)
);
create table pesquisador(
	idPesquisador int not null auto_increment primary key,
    instituicao varchar(100) not null,
    fkIdVacinaCriada int,
    fkIdPessoa int not null,
    foreign key(fkIdPessoa) references pessoa(idPessoa),
    foreign key(fkIdVacinaCriada) references vacina(idVacina)
);
create table voluntario(
	idVoluntario int not null auto_increment primary key,
    fkIdPessoa int not null,
	foreign key(fkIdPessoa) references pessoa(idPessoa)
);
create table publicoGeral(
	idPublicoGeral int not null auto_increment primary key,
    fkIdPessoa int not null,
    foreign key(fkIdPessoa) references pessoa(idPessoa)
);
insert into vacina(nome,paisOrigem,estagioPesquisa,dtInicioPesquisa,dtTerminoPesquisa,quantidadeDoses) values("Sputnic","Russia","Final", '2020-05-05', '2021-01-05', 200);
insert into aplicacao(fkIdVacina, dtAplicacao, nota) values(1, '2021-02-10', "Bom");
insert into pessoa(nome, sobrenome, dtNascimento, sexo, cpf, fkIdAplicacao) values("Zé", "1", '2000-09-09', 'M', "111.111.111-11", 1);
insert into pessoa(nome, sobrenome, dtNascimento, sexo, cpf, fkIdAplicacao) values("Zé", "2", '1998-10-10', 'F', "222.222.222-22", 1);
insert into pessoa(nome, sobrenome, dtNascimento, sexo, cpf, fkIdAplicacao) values("Zé", "3", '1991-11-11', 'F', "333.333.333-33", 1);
insert into pesquisador(instituicao, fkIdVacinaCriada, fkIdPessoa) values("Apocalipse", 1, 1);
insert into publicoGeral(fkIdPessoa) values(2);
insert into voluntario(fkIdPessoa) values(3);

select * from vacina;
select * from aplicacao;
select * from pessoa;
select * from pesquisador;
select * from publicoGeral;
select * from voluntario;