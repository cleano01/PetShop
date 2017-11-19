create database bancoPet;


use bancoPet;

create table Cliente (

	cpf int (11),
    idade int(3),
    nome varchar(50),
    email varchar(50),
    telefone varchar(15),
    constraint pk_cliente primary key (cpf)

);

insert into Cliente values(122,20, 'Isidro', 'isidro@isidro.com','123456');
insert into Cliente values(123,21, 'Roberval', 'rob@rob.com', '789012');
insert into Cliente values(124,22,'Cleano', 'cleano@cleano.com', '123666');
insert into Cliente values(125,23,'Maria', 'maria@maria.com', '123678');


select * from Cliente;


create table Animal(
	
	id integer not null auto_increment,
    nome varchar(50),
    tipo varchar(20),
    idade int (2),
    entregue varchar(15),    
    cpf int not null,Animal
    
    constraint pk_animal primary key (id),
    foreign key(cpf) references Cliente(cpf)      
);


insert into Animal(nome,tipo,idade,entregue,cpf)
values('toto','cachorro',2,'nao',122);
select * from Animal
