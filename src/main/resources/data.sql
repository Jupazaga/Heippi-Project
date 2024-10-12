insert into usuario values ('1', 'HOSPITAL', 'email@hospital1.com', '$2a$10$So01P0WU7hwePtFEc/dnLOWVbj2DG8unRpxe5hxdPJAJXuDj/w7cC', 'telefono');
insert into hospital values ('1', 'direccion', 'señor hospital', 'servicios medicos');
insert into usuario values ('2', 'PACIENTE', 'email@paciente1.com', '$2a$10$So01P0WU7hwePtFEc/dnLOWVbj2DG8unRpxe5hxdPJAJXuDj/w7cC', 'telefono');
insert into paciente values ('direccion', '2004-04-04', 'paciente', '2');
insert into usuario values ('3', 'MEDICO', 'email@medico1.com', '$2a$10$So01P0WU7hwePtFEc/dnLOWVbj2DG8unRpxe5hxdPJAJXuDj/w7cC', 'telefono');
insert into medico values ('direccion', 'MEDICO', false, '3', '1');
insert into observacion values ('1', 'observacion', 'especialidad', 'bien', '1', '3', '2');

insert into usuario values ('4', 'HOSPITAL', 'email@hospital2.com', '$2a$10$So01P0WU7hwePtFEc/dnLOWVbj2DG8unRpxe5hxdPJAJXuDj/w7cC', 'telefono');
insert into hospital values ('4', 'direccion', 'señor hospital', 'servicios medicos');
insert into usuario values ('5', 'PACIENTE', 'email@paciente2.com', '$2a$10$So01P0WU7hwePtFEc/dnLOWVbj2DG8unRpxe5hxdPJAJXuDj/w7cC', 'telefono');
insert into paciente values ('direccion', '2004-04-04', 'paciente', '5');
insert into usuario values ('6', 'MEDICO', 'email@medico2.com', '$2a$10$So01P0WU7hwePtFEc/dnLOWVbj2DG8unRpxe5hxdPJAJXuDj/w7cC', 'telefono');
insert into medico values ('direccion', 'MEDICO', false, '6', '4');
insert into observacion values ('2', 'observacion', 'especialidad', 'bien', '4', '6', '5');
