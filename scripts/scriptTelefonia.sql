drop database if exists telefonia;
create database telefonia;
use telefonia;

create table endereco(
	idEndereco integer not null auto_increment primary key,
	logradouro varchar(500),
	cep varchar(9) not null,
	uf varchar(2) not null,
	cidade varchar(100),
	numero varchar(5)
);
create table telefone(
	idTelefone integer not null auto_increment primary key,
	ddd varchar(2) not null,
    codigoInternacional varchar(2) not null,
	numero varchar(10) not null,
	ativo boolean not null,
	movel boolean not null
);
create table pessoa(
	idPessoa integer not null auto_increment primary key,
    nome varchar(150) not null,
    fkIdEndereco int not null,
    fkIdTelefone int not null,
    foreign key(fkIdEndereco) references endereco(idEndereco),
    foreign key(fkIdTelefone) references telefone(idTelefone)
);
select * from endereco;