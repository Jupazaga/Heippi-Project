create table hospital (
    id_hospital varchar(255) not null,
    direccion varchar(255),
    nombre varchar(255),
    servicios_medicos varchar(255),
    primary key (id_hospital)
    );

create table medico (
    direccion varchar(255),
    nombre varchar(255),
    password_changed boolean,
    usuario_identificacion varchar(255) not null,
    id_hospital varchar(255),
    primary key (usuario_identificacion)
);

create table observacion (
    id bigint not null,
    descripcion varchar(255),
    especialidad varchar(255),
    estado_salud varchar(255),
    id_hospital varchar(255),
    id_medico varchar(255),
    id_paciente varchar(255),
    primary key (id)
    );

create table paciente (
    direccion varchar(255),
    fecha_nacimiento date,
    nombre varchar(255),
    usuario_identificacion varchar(255) not null,
    primary key (usuario_identificacion)
    );

create table usuario (
    identificacion varchar(255) not null,
    authority varchar(255),
    email varchar(255),
    password varchar(255),
    telefono varchar(255),
    primary key (identificacion)
    );

create sequence observacion_seq start with 1 increment by 50;

alter table if exists hospital
    add constraint FKks13lu4fr9oiv79rldw0kcg6w
        foreign key (id_hospital)
            references usuario;

alter table if exists medico
    add constraint FKlwnoww59astus5eebbhb150bc
        foreign key (id_hospital)
            references hospital;

alter table if exists medico
    add constraint FKn4pkfdmeskouibxebii3obxkm
        foreign key (usuario_identificacion)
            references usuario;

alter table if exists observacion
    add constraint FKbt322vk44yub3tmo54kisp92w
        foreign key (id_hospital)
            references hospital;

alter table if exists observacion
    add constraint FKso1xrlm7iamrqr397vi5fhpch
        foreign key (id_medico)
            references medico;

alter table if exists observacion
    add constraint FKmbmxxl2wvolycxwn3gtybrrun
        foreign key (id_paciente)
            references paciente;

alter table if exists paciente
    add constraint FK8etovayuiwh7xt3ou7088sh9q
        foreign key (usuario_identificacion)
            references usuario;