Drop database if exists DBRepuestosAutomotriz_in5cm;
create database DBRepuestosAutomotriz_in5cm;
use DBRepuestosAutomotriz_in5cm;

-- -----------------------------------------------------------------------------------ENTIDADES
create table Proveedores(
 id_proveedor int auto_increment not null,
 nombre_proveedor varchar(60) not null,
 telefono_proveedor int not null,
 direccion varchar(100) not null,
 email_proveedor varchar(100) not null,
 primary key PK_id_proveedor(id_proveedor)
);

create table Empleados(
id_empleado int auto_increment not null,
 nombre_empleado varchar(60) not null,
 apellido_empleado varchar(60) not null,
 puesto_empleado varchar(20) null,
 email_empleado varchar(100) not null,
 primary key PK_id_empleado(id_empleado)
);
create table Repuestos(
id_repuesto int auto_increment not null,
 nombre_repuesto varchar(60) not null,
 categoria_repuesto varchar(60) not null,
 precio_compra double not null,
 precio_venta double not null,
 id_proveedor int not null,
 primary key PK_id_repuesto(id_repuesto),
 constraint FK_repuesto_proveedor foreign key (id_proveedor)
references proveedores(id_proveedor) on delete cascade
);

create table Ventas(
id_venta int auto_increment not null,
 fecha_venta date not null,
 cantidad int not null,
 total double not null,
id_empleado int not null,
 id_repuesto int not null,
 primary key PK_id_venta(id_venta),
 constraint FK_ventas_empleado foreign key (id_empleado)
references Empleados(id_empleado) on delete cascade,
 constraint FK_ventas_repuestos foreign key (id_repuesto)
references Repuestos(id_repuesto) on delete cascade
);

-- -----------------------------------------------------------------------------------PROCEDIMIENTOS ALMACENADOS PROVEEDORES
delimiter $$
	create procedure sp_AgregarProveedores(
        in nombre_proveedor1 varchar(60),
        in telefono_proveedor1 int,
        in direccion1 varchar(100),
        in email_proveedor1 varchar(100)
    )
    begin
		insert into Proveedores (nombre_proveedor, telefono_proveedor, direccion, email_proveedor)
			values(nombre_proveedor1, telefono_proveedor1, direccion1, email_proveedor1);
    end $$
delimiter ;

delimiter $$
	create procedure sp_SelectProveedores()
    begin
		select * from Proveedores;
    end $$
delimiter ;

delimiter $$
	create procedure sp_BuscarProveedores(in id int)
    begin 
		select * from Proveedores where id_proveedor = id;
    end $$
delimiter ;

delimiter $$
	create procedure sp_EliminarProveedores (in id int)
    begin
		delete from Proveedores where id_proveedor = id;
    end $$
delimiter ;

delimiter $$
	create procedure sp_EditarProveedores(
		in id_proveedor1 int,
		in nombre_proveedor1 varchar(60),
        in telefono_proveedor1 int,
        in direccion1 varchar(100),
        in email_proveedor1 varchar(100)
    )
    begin
		update Proveedores set
			nombre_proveedor = nombre_proveedor1,
            telefono_proveedor = telefono_proveedor1,
            direccion = direccion1,
            email_proveedor = email_proveedor1
		where id_proveedor = id_proveedor1;
    end $$
delimiter ;

-- -----------------------------------------------------------------------------------PROCEDIMIENTOS ALMACENADOS EMPLEADOS
delimiter $$
	create procedure sp_AgregarEmpleados(
        in nombre_empleado1 varchar(60),
		in apellido_empleado1 varchar(60), 
		in puesto_empleado1 varchar(20), 
		in email_empleado1 varchar(100)
    )
    begin
		insert into Empleados(nombre_empleado, apellido_empleado, puesto_empleado, email_empleado)
			values (nombre_empleado1,apellido_empleado1, puesto_empleado1, email_empleado1);
    end $$
delimiter ;

delimiter $$
	create procedure sp_SelectEmpleados()
    begin
		select * from Empleados;
    end $$
delimiter ;

delimiter $$
	create procedure sp_BuscarEmpleados(in id int)
    begin 
		select * from Empleados where id_empleado = id;
    end $$
delimiter ;

delimiter $$
	create procedure sp_EliminarEmpleados (in id int)
    begin
		delete from Empleados where id_empleado = id;
    end $$
delimiter ;

delimiter $$
	create procedure sp_EditarEmpleados(
		in id_empleado1 int, 
		in nombre_empleado1 varchar(60),
		in apellido_empleado1 varchar(60), 
		in puesto_empleado1 varchar(20), 
		in email_empleado1 varchar(100)
    )
    begin
		update Empleados set
			nombre_empleado = nombre_empleado1,
            apellido_empleado = apellido_empleado1,
            puesto_empleado = puesto_empleado1,
            email_empleado = email_empleado1
		where id_empleado = id_empleado1;
    end $$
delimiter ;

-- -----------------------------------------------------------------------------------PROCEDIMIENTOS ALMACENADOS REPUESTOS
delimiter $$
	create procedure sp_AgregarRepuestos(
        in nombre_repuesto1 varchar(60),
		in categoria_repuesto1 varchar(60),
		in precio_compra1 double,
		in precio_venta1 double,
		in id_proveedor1 int
    )
    begin
		insert into Repuestos(nombre_repuesto, categoria_repuesto, precio_compra, precio_venta, id_proveedor)
			values (nombre_repuesto1, categoria_repuesto1, precio_compra1, precio_venta1, id_proveedor1);
    end $$
delimiter ;

delimiter $$
	create procedure sp_SelectRepuestos()
    begin
		select * from Repuestos;
    end $$
delimiter ;

delimiter $$
	create procedure sp_BuscarRepuestos(in id int)
    begin 
		select * from Repuestos where id_repuesto = id;
    end $$
delimiter ;

delimiter $$
	create procedure sp_EliminarRepuestos (in id int)
    begin
		delete from Repuestos where id_repuesto = id;
    end $$
delimiter ;

delimiter $$
	create procedure sp_EditarRepuestos(
		in id_repuesto1 int,
		in nombre_repuesto1 varchar(60),
		in categoria_repuesto1 varchar(60),
		in precio_compra1 double,
		in precio_venta1 double,
		in id_proveedor1 int
    )
    begin
		update Repuestos set
			nombre_repuesto = nombre_repuesto1,
            categoria_repuesto = categoria_repuesto1.
            precio_compra = precio_compra1,
            precio_venta = precio_venta1,
            id_proveedor = id_proveedor1
		where id_repuesto = id_repuesto1;
    end $$
delimiter ;

-- -----------------------------------------------------------------------------------PROCEDIMIENTOS ALMACENADOS VENTAS
delimiter $$
	create procedure sp_AgregarVentas(
        in fecha_venta1 date, 
		in cantidad1 int, 
		in total1 double, 
		in id_empleado1 int, 
		in id_repuesto1 int
    )
    begin
		insert into Ventas(fecha_venta, cantidad, total, id_empleado, id_repuesto)
			values (fecha_venta1, cantidad1, total1, id_empleado1, id_repuesto1);
    end $$
delimiter ;

delimiter $$
	create procedure sp_SelectVentas()
    begin
		select * from Ventas;
    end $$
delimiter ;

delimiter $$
	create procedure sp_BuscarVentas(in id int)
    begin 
		select * from Ventas where id_venta = id;
    end $$
delimiter ;

delimiter $$
	create procedure sp_EliminarVentas (in id int)
    begin
		delete from Ventas where id_venta = id;
    end $$
delimiter ;

delimiter $$
	create procedure sp_EditarVentas(
		in id_venta1 int,
		in fecha_venta1 date, 
		in cantidad1 int, 
		in total1 double, 
		in id_empleado1 int, 
		in id_repuesto1 int
    )
    begin
		update Ventas set
			fecha_venta = fecha_venta1,
            cantidad = cantidad1,
            total = total1,
            id_empleado = id_empleado1,
            id_repuesto = id_repuesto1
		where id_venta = id_venta1;
    end $$
delimiter ;

-- -- -----------------------------------------------------------------------------------INSERCION DE REGISTROS
-- ----------------PROVEEDORES
call sp_AgregarProveedores('Repuestos El Águila', 42123456, 'Zona 1, Ciudad', 'contacto@gmail.com');
call sp_AgregarProveedores('AutoPartes Central', 43112233, 'Zona 4, Ciudad', 'ventas@gmail.com');
call sp_AgregarProveedores('Motores del Norte', 44114455, 'Zona 7, Ciudad', 'info@gmail.com');
call sp_AgregarProveedores('Distribuidora La Rueda', 45223344, 'Zona 11, Ciudad', 'larueda@gmail.com');
call sp_AgregarProveedores('Frenos y Más', 46334455, 'Zona 9, Ciudad', 'frenosymas@gmail.com');
call sp_AgregarProveedores('Autopartes Premium', 47445566, 'Zona 14, Ciudad', 'premium@outlook.com');
call sp_AgregarProveedores('Repuestos San José', 48556677, 'Zona 3, Ciudad', 'sanjose@outlook.com');
call sp_AgregarProveedores('Importadora Torque', 49667788, 'Zona 12, Ciudad', 'torque@outlook.com');
call sp_AgregarProveedores('AutoMoto Supply', 40778899, 'Zona 10, Ciudad', 'ventas@yahoo.com');
call sp_AgregarProveedores('Partes Express', 41889900, 'Zona 5, Ciudad', 'express@yahoo.com');

-- ----------------EMPLEADOS
call sp_AgregarEmpleados('Carlos', 'Méndez', 'Vendedor', 'carlos.mendez@gmail.com');
call sp_AgregarEmpleados('Ana', 'López', 'Vendedor', 'ana.lopez@gmail.com');
call sp_AgregarEmpleados('Luis', 'Ramírez', 'Cajero', 'luis.ramirez@gmail.com');
call sp_AgregarEmpleados('María', 'Gómez', 'Gerente', 'maria.gomez@gmail.com');
call sp_AgregarEmpleados('Pedro', 'Hernández', 'Vendedor', 'pedro.hernandez@yahoo.com');
call sp_AgregarEmpleados('Sofía', 'Castillo', 'Cajero', 'sofia.castillo@yahoo.com');
call sp_AgregarEmpleados('Jorge', 'Pérez', 'Supervisor', 'jorge.perez@yahoo.com');
call sp_AgregarEmpleados('Daniela', 'Morales', 'Vendedor', 'daniela.morales@outlook.com');
call sp_AgregarEmpleados('Miguel', 'Rojas', 'Bodega', 'miguel.rojas@outlook.com');
call sp_AgregarEmpleados('Lucía', 'Flores', 'Administración', 'lucia.flores@outlook.com');

-- ----------------RESPUESTOS
call sp_AgregarRepuestos('Filtro de Aceite', 'Motor', 45.00, 75.00, 1);
call sp_AgregarRepuestos('Pastillas de Freno', 'Frenos', 120.00, 180.00, 5);
call sp_AgregarRepuestos('Bujías', 'Motor', 30.00, 55.00, 3);
call sp_AgregarRepuestos('Amortiguador', 'Suspensión', 220.00, 320.00, 4);
call sp_AgregarRepuestos('Radiador', 'Enfriamiento', 450.00, 650.00, 2);
call sp_AgregarRepuestos('Batería 12V', 'Eléctrico', 380.00, 550.00, 6);
call sp_AgregarRepuestos('Correa de Tiempo', 'Motor', 95.00, 150.00, 7);
call sp_AgregarRepuestos('Disco de Freno', 'Frenos', 160.00, 240.00, 5);
call sp_AgregarRepuestos('Alternador', 'Eléctrico', 520.00, 750.00, 8);
call sp_AgregarRepuestos('Filtro de Aire', 'Motor', 35.00, 65.00, 9);

-- ----------------VENTAS
call sp_AgregarVentas('2025-05-01', 2, 150.00, 1, 1);
call sp_AgregarVentas('2025-05-02', 1, 180.00, 2, 2);
call sp_AgregarVentas('2025-05-03', 4, 220.00, 3, 3);
call sp_AgregarVentas('2025-05-04', 1, 320.00, 4, 4);
call sp_AgregarVentas('2025-05-05', 1, 650.00, 5, 5);
call sp_AgregarVentas('2025-05-06', 2, 1100.00, 6, 6);
call sp_AgregarVentas('2025-05-07', 3, 450.00, 7, 7);
call sp_AgregarVentas('2025-05-08', 2, 480.00, 8, 8);
call sp_AgregarVentas('2025-05-09', 1, 750.00, 9, 9);
call sp_AgregarVentas('2025-05-10', 5, 325.00, 10, 10);









