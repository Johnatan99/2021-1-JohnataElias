drop database if exists atividadeVacinas;
create database atividadeVacinas;
use atividadeVacinas;

create table vacina(
	idVacina int not null auto_increment primary key,
    nomeVacina varchar(50) not null,
	paisOrigem varchar(50) not null,
	estagioPesquisa varchar(30) not null,
	dtInicioPesquisa date not null,
	dtTerminoPesquisa date not null,
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
insert into vacina(nomeVacina,paisOrigem,estagioPesquisa,dtInicioPesquisa,dtTerminoPesquisa,quantidadeDoses) values("Sputnic","Russia","Final", '2020-05-05', '2021-01-05', 200);
insert into aplicacao(fkIdVacina, dtAplicacao, nota) values(1, '2021-02-10', "Bom");
insert into pessoa(nome, sobrenome, dtNascimento, sexo, cpf, fkIdAplicacao) values("Zé", "da coca", '2024-08-09', 'M', "123.456.789-12", 1);
insert into pesquisador(instituicao, fkIdVacinaCriada, fkIdPessoa) values("Apocalipse", 1, 1);

select * from vacina;
select * from pessoa;
select * from aplicacao;
select * from pesquisador;