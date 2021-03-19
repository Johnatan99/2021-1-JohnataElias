drop database if exists atividadeVacinas;
create database atividadeVacinas;
use atividadeVacinas;

create table pessoa(
	idPessoa Integer not null auto_increment primary key,
	nome varchar(50) not null,
    sobrenome varchar(100) not null,
	dtNascimento date not null,
	sexo char(1) not null,
	cpf varchar(14) not null
);
create table pesquisador(
	idPesquisador Integer not null auto_increment primary key,
    fkIdPessoa Integer not null,
    foreign key(fkIdPessoa) references pessoa(idPessoa)
);

create table voluntario(
	idVoluntario Integer not null auto_increment primary key,
    fkIdPessoa Integer not null,
	foreign key(fkIdPessoa) references pessoa(idPessoa)
);
create table publicoGeral(
	idPublicoGeral Integer not null auto_increment primary key,
    fkIdPessoa Integer not null,
    foreign key(fkIdPessoa) references pessoa(idPessoa)
);
create table vacina(
	idVacina Integer not null auto_increment primary key,
    nomeVacina varchar(50) not null,
	paisOrigem varchar(50) not null,
	estagioPesquisa varchar(30) not null,
	dtInicioPesquisa date not null,
	dtTerminoPesquisa date not null,
	quantidadeDoses int not null,
    fkIdPesquisador Integer,
    foreign key (fkIdPesquisador) references pesquisador(idPesquisador)
);

-- insert into vacina(nomeVacina, paisOrigem, estagioPesquisa, dtInicioPesquisa, dtTerminoPesquisa, quantidadeDoses, fkIdPesquisador) values("MorteSúbita", "Desconhecido", "Final", null, null, 200, null);
select * from vacina;
select * from pessoa;