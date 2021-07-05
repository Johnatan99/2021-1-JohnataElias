drop database if exists atividade_telefonia;
create database atividade_telefonia;
use atividade_telefonia;

create table endereco(
	idEndereco Integer not null auto_increment primary key,
	logradouro varchar(500),
	cep varchar(9) not null,
	uf varchar(2) not null,
	cidade varchar(100),
    estado varchar(100),
	numero varchar(5)
);
create table telefone(
	idTelefone Integer not null auto_increment primary key,
    codigoInternacional varchar(2) not null,
	ddd varchar(2) not null,
	numero varchar(10) not null,
    idCliente Integer,
    movel boolean not null,
	ativo boolean not null
);
create table cliente(
	idCliente Integer not null auto_increment primary key,
    nome varchar(150) not null,
    cpf varchar(14) not null,
    fkIdEndereco Integer,
    fkIdTelefone Integer,
    foreign key(fkIdEndereco) references endereco(idEndereco),
    foreign key(fkIdTelefone) references telefone(idTelefone)
);

insert into cliente (nome, cpf, fkIdEndereco, fkIdTelefone) values("José", "000.000.000-00", null, null);
select * from telefone;
select * from endereco;
select * from cliente;