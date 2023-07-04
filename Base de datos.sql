USE master
CREATE DATABASE VariedadesDuarte
GO

-- Base de datos.
USE VariedadesDuarte
GO
-- Creación de la tabla "Persona".
CREATE TABLE [Persona](
IDPersona INTEGER IDENTITY (1,1) PRIMARY KEY,
nombre1 NVARCHAR (15)NOT NULL,
nombre2 NVARCHAR (15)NULL,
apellido1 NVARCHAR (15)NOT NULL,
apellido2 NVARCHAR (15)NULL,
telefono NVARCHAR (9)NOT NULL,
direccion NVARCHAR (200)NOT NULL

)
GO

-- Creación de la tabla "Proveedor".
CREATE TABLE [Proveedor] (
  [IDProveedor] INTEGER IDENTITY (1,1)PRIMARY KEY,
  [empresa_proveedor] NVARCHAR(150)NOT NULL,
  IDPersona INTEGER UNIQUE,
  CONSTRAINT FK_Proveedor_Persona1 FOREIGN KEY (IDPersona) REFERENCES Persona (IDPersona)
  

)
GO
-- Creación de la tabla "Cliente".
CREATE TABLE [Cliente] (
  [IDCliente] INTEGER IDENTITY(1,1) PRIMARY KEY,
  [genero_cliente] CHAR (1) NOT NULL,
  IDPersona INTEGER UNIQUE,
  CONSTRAINT FK_Cliente_Persona FOREIGN KEY (IDPersona) REFERENCES Persona (IDPersona)
  
)
GO
-- Creación de la tabla "Categoria".
CREATE TABLE [Categoria] (
  [IDCategoria] INTEGER IDENTITY(1,1) PRIMARY KEY,
  [nombre_categoria] NVARCHAR(30) NOT NULL,

)
GO
-- Creación de la tabla "Producto".
CREATE TABLE [Producto] (
  [IDProducto] INTEGER IDENTITY(1,1) PRIMARY KEY,
  [nombre_producto] NVARCHAR(50)NOT NULL,
  [cantidad_producto] INTEGER NOT NULL,
  [precio_compra] DECIMAL(12,2) NOT NULL,
  [precio_venta] DECIMAL(12,2) NOT NULL,
  [descripcion] NVARCHAR(200) NOT NULL,
  [fecha_vencimiento] DATE NOT NULL,
  IDCategoria INT,
  IDProveedor INT,
  CONSTRAINT FK_Producto_Categoria FOREIGN KEY (IDCategoria) REFERENCES Categoria (IDCategoria),
  CONSTRAINT FK_Producto_Proveedor FOREIGN KEY (IDProveedor) REFERENCES Proveedor (IDProveedor)
 
)
GO
-- Creación de la tabla "Presentacion".
CREATE TABLE [Presentacion](
IDPresentacion INTEGER IDENTITY (1,1) PRIMARY KEY,
nombre_presentacion NVARCHAR (20) NOT NULL

)
GO
-- Creación de la tabla "Venta".
CREATE TABLE [Venta] (
  [IDVenta] INTEGER IDENTITY(1,1) PRIMARY KEY,
  [fecha_venta] DATE NOT NULL,
  [hora_venta] TIME NOT NULL,
  IDCliente INT,
  CONSTRAINT FK_Venta_Cliente FOREIGN KEY (IDCliente) REFERENCES Cliente (IDCliente)
 
)
GO
-- Creación de la tabla "Compra".
CREATE TABLE [Compra] (
  [IDCompra] INTEGER IDENTITY(1,1) PRIMARY KEY,
  [fecha_compra] DATE NOT NULL,
  [hora_compra] TIME NOT NULL,


)
GO
-- Creación de la tabla "Inicio Sesion".
CREATE TABLE [IniciodeSesion](
[ID_InicioSesion] INTEGER IDENTITY (1,1) PRIMARY KEY,
usuario_sesion NVARCHAR (20) NOT NULL,
contrasena_sesion NVARCHAR (10) NOT NULL

)

GO
-- Creación de la tabla Intermedia "Detalle_Venta".
CREATE TABLE [Detalle_Venta] (
  [ID_DVenta] INTEGER IDENTITY(1,1) PRIMARY KEY,
  cantidad_venta INTEGER NOT NULL,
  IDVenta INT,
  CONSTRAINT FK_DetalleV_Venta FOREIGN KEY (IDVenta) REFERENCES Venta (IDVenta),
  IDProducto INT,
  CONSTRAINT FK_DetalleVenta_Producto FOREIGN KEY (IDProducto) REFERENCES Producto (IDProducto)
 
)
GO
--Creacion de la tabla Intermedia "ProductoCompra".
CREATE TABLE ProductoCompra (
IDPCompra INTEGER IDENTITY (1,1) PRIMARY KEY,
cantidad_compra INTEGER  NOT NULL,
IDCompra INT,
CONSTRAINT FK_ProductoC_Compra FOREIGN KEY (IDCompra) REFERENCES Compra (IDCompra),
IDProducto INT,
CONSTRAINT FK_ProductoC1_Producto FOREIGN KEY (IDProducto) REFERENCES Producto (IDProducto)


)
GO
-- Creación de la tabla Intermedia "ProductoPresentacion".
CREATE TABLE [ProductoPresentacion](
 ID_PPresentacion INTEGER IDENTITY (1,1) PRIMARY KEY,
medida_numerica DECIMAL (12,2) NOT NULL,
  IDProducto INT,
  CONSTRAINT FK_PPresentacion_Producto FOREIGN KEY (IDProducto) REFERENCES Producto (IDProducto),
  IDPresentacion INT,
  CONSTRAINT FK_PPresentacion_Presentacion FOREIGN KEY (IDPresentacion) REFERENCES Presentacion (IDPresentacion)

)
GO
-------------------------------------------------------------------------------------------------
-----PROCEDIMIENTOS ALMACENADOS PARA INSERTAR
-------------------------------------------------------------------------------------------------
--Insertando usuarios.
Insert Into IniciodeSesion (usuario_sesion, contrasena_sesion)
Values('Administrador', '@1234567'),
	  ('UsuarioUno', '@vendedor');

GO
--PROCEDIMIENTO ALMACENADO INSERTAR CLIENTE
CREATE PROCEDURE InsertarPersonaCliente
@nombre1 NVARCHAR (15),
@nombre2 NVARCHAR (15),
@apellido1 NVARCHAR (15),
@apellido2 NVARCHAR (15),
@direccion NVARCHAR (200),
@telefono NVARCHAR (9),
@genero_cliente CHAR (1)
AS
BEGIN
  INSERT INTO Persona (nombre1,nombre2,apellido1,apellido2,telefono,direccion)
  VALUES (@nombre1,@nombre2,@apellido1,@apellido2,@telefono,@direccion);
  INSERT INTO Cliente (IDPersona, genero_cliente)
  VALUES (SCOPE_IDENTITY(),@genero_cliente);
END 
GO
EXEC InsertarPersonaCliente 'Montiel','Marenco','Vargas','Torrez','Calle Principal, Barrio El Centro, Ciudad Managua, Managua','5786-7406','M'
EXEC InsertarPersonaCliente 'John', 'Doe', 'Smith', 'Johnson', 'De la Estación de Policía, 1 cuadra al sur, Barrio San Judas, Ciudad León, León', '8123-4567', 'M'
EXEC InsertarPersonaCliente 'Jane', 'Doe', 'Taylor', 'Anderson', 'Costado Este del Parque Central, Barrio El Rosario, Ciudad Granada, Granada', '8345-6712', 'F'
EXEC InsertarPersonaCliente 'Michael', 'Brown', 'Wilson', 'Davis', 'Carretera Masaya, Kilómetro 6, Barrio Monimbó, Ciudad Masaya, Masaya', '8567-8123', 'M'
EXEC InsertarPersonaCliente 'Emily', 'Johnson', 'Martinez', 'Garcia', 'Del Mercado Central, 2 cuadras al norte, Barrio El Calvario, Ciudad Estelí, Estelí', '7891-2345', 'F'
EXEC InsertarPersonaCliente 'Daniel', 'Smith', 'Lopez', 'Thomas', 'Del Estadio Nacional, 2 cuadras al oeste, Barrio Sutiaba, Ciudad Chinandega, Chinandega', '8789-1234', 'M'
EXEC InsertarPersonaCliente 'Sophia', 'Garcia', 'Lee', 'Perez', 'Avenida de Bolívar a Chávez, Contiguo a la Catedral, Barrio San Sebastián, Ciudad Matagalpa, Matagalpa', '8901-2345', 'F'
EXEC InsertarPersonaCliente 'Matthew', 'Johnson', 'Miller', 'Smith', 'Del Parque Central, 3 cuadras al este, Barrio La Recoleta, Ciudad Jinotega, Jinotega', '8126-5437', 'M'
EXEC InsertarPersonaCliente 'Olivia', 'Brown', 'Wilson', 'Davis', 'Carretera Panamericana, Kilómetro 10, Barrio Las Colinas, Ciudad Tipitapa, Managua', '7890-6543', 'F'
EXEC InsertarPersonaCliente 'William', 'Anderson', 'Clark', 'Taylor', 'De la Iglesia La Merced, 1 cuadra al sur, Barrio San Felipe, Ciudad Rivas, Rivas', '8970-2314', 'M'

GO
--PROCEDIMIENTO ALMECENADO INSERTAR PROVEEDOR
CREATE PROCEDURE InsertarPersonaProveedor
@nombre1 NVARCHAR (15),
@nombre2 NVARCHAR (15),
@apellido1 NVARCHAR (15),
@apellido2 NVARCHAR (15),
@direccion NVARCHAR (200),
@telefono NVARCHAR (9),
@empresa_proveedor NVARCHAR (150)
AS
BEGIN
  INSERT INTO Persona (nombre1,nombre2,apellido1,apellido2,telefono,direccion)
  VALUES (@nombre1,@nombre2,@apellido1,@apellido2,@telefono,@direccion);
  INSERT INTO Proveedor(IDPersona, empresa_proveedor)
  VALUES (SCOPE_IDENTITY(),@empresa_proveedor);
END 
GO
EXEC InsertarPersonaProveedor'Cristhian','Cesar','Vargas','Martinez','Juigalpa','5786-7406','Distribuidora Morales'
EXEC InsertarPersonaProveedor 'Gabriel', 'Cordero', 'Ramírez', 'López', 'Managua', '5829-7408', 'Mayorista Los Pinos'
EXEC InsertarPersonaProveedor 'Isabella', 'Torres', 'Guzmán', 'Sánchez', 'León', '8032-0045', 'Distribuidora La Economía'
EXEC InsertarPersonaProveedor 'Sebastián', 'Rojas', 'Flores', 'Pérez', 'Granada', '8021-0067', 'Mayorista San Judas'
EXEC InsertarPersonaProveedor 'Valentina', 'Gutierrez', 'Herrera', 'Ortiz', 'Matagalpa', '7891-2345', 'Distribuidora Mercantil'
EXEC InsertarPersonaProveedor 'Mateo', 'Navarro', 'Silva', 'Gómez', 'Chinandega', '7298-0003', 'Mayorista El Trébol'
EXEC InsertarPersonaProveedor 'Lucía', 'Ortega', 'Díaz', 'Lara', 'Estelí', '8021-0067', 'Distribuidora El Sol'
EXEC InsertarPersonaProveedor 'Emilio', 'Mendoza', 'Castro', 'Ramón', 'Rivas', '8294-0087', 'Mayorista El Progreso'
EXEC InsertarPersonaProveedor 'Valeria', 'Cabrera', 'Fuentes', 'Soto', 'Masaya', '7682-0006', 'Distribuidora Comercial Mayor'
EXEC InsertarPersonaProveedor 'Matías', 'Chávez', 'Ríos', 'Núñez', 'Puerto Cabezas', '7124-0009', 'Mayorista La Unión'

GO

 --PROCEDIMIENTO ALMACENADO INSERTAR CATEGORIA

  CREATE PROCEDURE InsertarCategoria
  @nombre_categoria NVARCHAR (30)
AS
  INSERT INTO [Categoria] ([nombre_categoria])
  VALUES (@nombre_categoria)
GO

EXEC InsertarCategoria 'Lacteos';
EXEC InsertarCategoria 'Frutas';
EXEC InsertarCategoria 'Electrodomésticos';
EXEC InsertarCategoria 'Ropa';
EXEC InsertarCategoria 'Bebidas';
EXEC InsertarCategoria 'Hogar y Jardín';
EXEC InsertarCategoria 'Juguetes';
EXEC InsertarCategoria 'Cosméticos';
EXEC InsertarCategoria 'Electrodomésticos';
EXEC InsertarCategoria 'Productos de belleza';
EXEC InsertarCategoria 'Artículos deportivos';
EXEC InsertarCategoria 'Instrumentos musicales';
EXEC InsertarCategoria 'Comida preparada';
GO
--PROCEDIMIENTO ALMACENADO INSERTAR PRESENTACION 
CREATE PROCEDURE InsertarPresentacion
@nombre_presentacion NVARCHAR (20)
AS
   INSERT INTO [Presentacion] ([nombre_presentacion])
   VALUES (@nombre_presentacion)
GO
EXEC InsertarPresentacion 'Libra';
EXEC InsertarPresentacion 'Kilogramo';
EXEC InsertarPresentacion 'Litro';
EXEC InsertarPresentacion 'Metro';
EXEC InsertarPresentacion 'Unidad';
EXEC InsertarPresentacion 'Gramo';
EXEC InsertarPresentacion 'Onza';
EXEC InsertarPresentacion 'Litro';
EXEC InsertarPresentacion 'Galón';
EXEC InsertarPresentacion 'Pieza';
EXEC InsertarPresentacion 'Metro cuadrado';
EXEC InsertarPresentacion 'Centímetro cúbico';
EXEC InsertarPresentacion 'Caja';
EXEC InsertarPresentacion 'Botella';
EXEC InsertarPresentacion 'Paquete'; 
GO

--PROCEDIMIENTO ALMACENADO INSERTAR PRODUCTO
CREATE PROCEDURE InsertarProducto
    @nombre_producto NVARCHAR(40),
    @cantidad_producto INTEGER,
    @precio_compra DECIMAL(12,2),
    @precio_venta DECIMAL(12,2),
    @descripcion NVARCHAR(200),
    @fecha_vencimiento DATE,
    @IDCategoria INTEGER,
    @IDPresentacion INTEGER,
    @medida_numerica DECIMAL(12,2),
	@IDProveedor INTEGER
AS
BEGIN
    DECLARE @IDProducto INT
    -- Insertar en la tabla principal "Producto" con el IDCategoria correspondiente
    INSERT INTO Producto (nombre_producto, cantidad_producto, 
	precio_compra, precio_venta,descripcion,fecha_vencimiento,IDCategoria,IDProveedor)
    VALUES (@nombre_producto, @cantidad_producto, 
	@precio_compra, @precio_venta, @descripcion, @fecha_vencimiento,@IDCategoria,@IDProveedor)
	
	-- Obtener el ID generado para el nuevo producto
    SET @IDProducto = SCOPE_IDENTITY()

    -- Insertar en la tabla intermedia "ProductoPresentacion"
    INSERT INTO ProductoPresentacion (IDProducto, 
	IDPresentacion, medida_numerica)
    VALUES (@IDProducto, @IDPresentacion, @medida_numerica)
END
GO
EXEC InsertarProducto 'Leche', 10, 100.00, 150.00, 'Leche de vaca', '2023-01-01', 1, 1, 1.5, 1;
EXEC InsertarProducto 'Pan', 20, 50.00, 80.00, 'Pan artesanal', '2023-02-01', 2, 2, 1, 2;
EXEC InsertarProducto 'Manzanas', 15, 80.00, 120.00, 'Manzanas frescas', '2023-03-01', 2, 2, 2.5, 3;
EXEC InsertarProducto 'Azúcar', 5, 20.00, 35.00, 'Azúcar refinada', '2023-04-01', 4, 4, 500.0, 4;
EXEC InsertarProducto 'Atún', 12, 15.00, 25.00, 'Atún en lata', '2023-05-01', 5, 5, 160.0, 5;
EXEC InsertarProducto 'Papas', 8, 30.00, 50.00, 'Papas fritas', '2023-06-01', 6, 6, 200.0, 6;
GO
--Procedimiento almacenado para Insertar venta
CREATE PROCEDURE InsertarVenta
   @fecha_venta DATE,
   @hora_venta TIME,
   @IDCliente INT
AS

   INSERT INTO [Venta] ([fecha_venta],[hora_venta],IDCliente)
   VALUES (@fecha_venta,@hora_venta,@IDCliente)
GO
--Procedimiento almacenado para insertar detalle venta
CREATE PROCEDURE Insertardetalle
   @cantidad_venta INT,
   @IDVenta INT,
   @IDProducto INT
AS
BEGIN
   INSERT INTO [Detalle_Venta] ([cantidad_venta], [IDVenta], [IDProducto])
   VALUES (@cantidad_venta, @IDVenta, @IDProducto)

   -- Actualizar cantidad de producto
   BEGIN TRANSACTION;
    
   UPDATE Producto
   SET cantidad_producto = cantidad_producto - @cantidad_venta
   WHERE IDProducto = @IDProducto;

   COMMIT;
END

GO
--PROCEDIMIENTO ALMACENADO INSERTAR COMPRA
CREATE PROCEDURE InsertarCompraProducto
   @cantidad_compra INT,
   @IDProducto INT
AS
BEGIN
   DECLARE @fecha_compra DATE = GETDATE();
   DECLARE @hora_compra TIME = GETDATE();

   INSERT INTO [Compra] ([fecha_compra],[hora_compra])
   VALUES (@fecha_compra, @hora_compra);

   DECLARE @IDCompra INT = SCOPE_IDENTITY();

   INSERT INTO ProductoCompra (cantidad_compra, IDCompra, IDProducto)
   VALUES (@cantidad_compra, @IDCompra, @IDProducto);

   BEGIN TRANSACTION;

   UPDATE Producto
   SET cantidad_producto = cantidad_producto + @cantidad_compra
   WHERE IDProducto = @IDProducto;

   COMMIT TRANSACTION;
END
GO
-------------------------------------------------------------------------------------------------
-------------------------------------------------------------------------------------------------
-----PROCEDIMIENTOS ALMACENADOS PARA BUSCAR
-------------------------------------------------------------------------------------------------
--PROCEDIMIENTO ALMACENADO PARA BUCAR CLIENTE
CREATE PROCEDURE BuscarCliente
 @Dato NVARCHAR (50)
AS
BEGIN
    SELECT  Persona.IDPersona,Cliente.IDCliente,nombre1,nombre2,apellido1,apellido2,telefono,Cliente.genero_cliente,
	direccion
    FROM Cliente inner join Persona
	ON Cliente.IDCliente = Persona.IDPersona
  WHERE nombre1 LIKE '%' + RTRIM(@Dato) + '%' OR nombre2 LIKE '%' + RTRIM(@Dato) + '%'
    OR apellido1 LIKE '%' + RTRIM(@Dato) + '%' OR apellido2 LIKE '%' + RTRIM(@Dato) + '%'
    OR telefono LIKE '%' + RTRIM(@Dato) + '%'
END
GO
CREATE PROCEDURE BuscarClienteCombo
 @Dato NVARCHAR (50)
AS
BEGIN
    SELECT  Cliente.IDCliente,nombre1,nombre2,apellido1,apellido2
    FROM Cliente inner join Persona
	ON Cliente.IDCliente = Persona.IDPersona
  WHERE nombre1 LIKE '%' + RTRIM(@Dato) + '%' OR nombre2 LIKE '%' + RTRIM(@Dato) + '%'
    OR apellido1 LIKE '%' + RTRIM(@Dato) + '%' OR apellido2 LIKE '%' + RTRIM(@Dato) + '%'

END

GO
--procedimiento almacenado para buscar proveedores
CREATE PROCEDURE BuscarProveedor
 @Dato NVARCHAR (50)
AS
BEGIN
  SELECT  Persona.IDPersona,Proveedor.IDProveedor,nombre1,nombre2,apellido1,apellido2,telefono,Proveedor.empresa_proveedor,
	direccion
  FROM Proveedor inner join Persona
  ON Proveedor.IDProveedor = Persona.IDPersona
  WHERE nombre1 LIKE '%' + RTRIM(@Dato) + '%' OR nombre2 LIKE '%' + RTRIM(@Dato) + '%'
    OR apellido1 LIKE '%' + RTRIM(@Dato) + '%' OR apellido2 LIKE '%' + RTRIM(@Dato) + '%'
    OR telefono LIKE '%' + RTRIM(@Dato) + '%'
END
GO
--Procedimiento almacenado para buscar productos
CREATE PROCEDURE BuscarProducto
@Dato NVARCHAR(50)
AS
BEGIN
	SELECT p.IDProducto,p.nombre_producto,p.cantidad_producto,p.precio_compra,p.precio_venta, p.descripcion,
	p.fecha_vencimiento,Cate.IDCategoria,Cate.nombre_categoria,pp.ID_PPresentacion,pp.medida_numerica,
	presen.IDPresentacion,presen.nombre_presentacion,
	provee.IDProveedor,provee.empresa_proveedor
	FROM   Producto p
	INNER JOIN ProductoPresentacion pp ON p.IDProducto = pp.IDProducto
    INNER JOIN Presentacion presen ON pp.IDPresentacion = presen.IDPresentacion
    INNER JOIN Categoria cate ON p.IDCategoria = cate.IDCategoria
	INNER JOIN Proveedor provee ON p.IDProveedor = provee.IDProveedor

	WHERE nombre_producto LIKE '%' + RTRIM (@Dato)+'%'
	OR empresa_proveedor LIKE '%' + RTRIM (@Dato)+ '%'
	OR nombre_categoria LIKE '%' + RTRIM (@Dato) + '%'
	OR nombre_presentacion LIKE '%' + RTRIM (@Dato + '%')
	END
	GO
-----------------------------------------------------------------------------------------------------
-----------------------------------------------------------------------------------------------------
--PROCEDIMIENTOS ALMACENADOS PARA CONSULTAR 
-----------------------------------------------------------------------------------------------------
--PROCEDIMIENTO ALMACENADO PARA MOSTRAR VENTAS DEL DIA
CREATE PROCEDURE MostrarVentasDelDia
AS
BEGIN
	DECLARE @dia DATE;
		SET @dia = CAST(GETDATE() AS DATE);
			SELECT Venta.IDVenta,Persona.nombre1,Persona.apellido1,Producto.nombre_producto,Venta.fecha_venta,Venta.hora_venta
		    FROM Venta
			INNER JOIN Persona ON Venta.IDVenta = Persona.IDPersona
			INNER JOIN Producto ON Venta.IDVenta = Producto.IDProducto
			WHERE CAST (fecha_venta AS DATE)= @dia;
END
GO
--PROCEDIMIENTO ALMACENADO PARA CONSULTAR UNA VENTA FINALIZADA
CREATE PROCEDURE ConsultarClienteVentaDetalleVenta
AS
BEGIN
    SELECT
        p.nombre1 AS nombre1,
        p.nombre2 AS nombre2,
        p.apellido1 AS apellido1,
        p.apellido2 AS apellido2,
        v.fecha_venta AS fecha_venta,
        v.hora_venta AS hora_venta,
        dv.IDProducto,
        pr.nombre_producto AS nombre_producto,
        dv.cantidad_venta,
        pr.precio_venta
    FROM
        Persona p
        INNER JOIN cliente c ON p.IDPersona= c.IDPersona
        INNER JOIN venta v ON c.IDCliente = v.IDCliente
        INNER JOIN detalle_venta dv ON v.IDVenta = dv.IDVenta
        INNER JOIN producto pr ON dv.IDProducto = pr.IDProducto;
END
GO
--PROCEDIMIENTO ALMACENADO PARA CONSULTAR CLIENTE
CREATE PROCEDURE ConsultarCliente
AS
BEGIN
  SELECT Persona.IDPersona,Cliente.IDCliente,Persona.nombre1,Persona.nombre2,Persona.apellido1,
  Persona.apellido2,Persona.telefono,Cliente.genero_cliente,Persona.direccion

  FROM Cliente inner join Persona on Cliente.IDPersona=Persona.IDPersona
END
GO
--Consultar Cliente en combo
CREATE PROCEDURE ConsultarClienteCombo
AS
BEGIN
  SELECT Persona.IDPersona,Cliente.IDCliente,Persona.nombre1,Persona.nombre2,Persona.apellido1,
  Persona.apellido2

  FROM Cliente inner join Persona on Cliente.IDPersona=Persona.IDPersona
END
GO
--PROCEDIMIENTO ALMACENADO PARA CONSULTAR PROVEEDOR
CREATE PROCEDURE ConsultarProveedor
AS
BEGIN
  SELECT Persona.IDPersona,Proveedor.IDProveedor,Persona.nombre1,Persona.nombre2,Persona.apellido1,
  Persona.apellido2,Persona.telefono,Proveedor.empresa_proveedor,Persona.direccion

  FROM Proveedor inner join Persona on Proveedor.IDPersona=Persona.IDPersona
END
GO
--PROCEDIMIENTO ALMACENADO PARA CONSULTAR PRODUCTO
CREATE PROCEDURE ConsultarProducto
AS
BEGIN 
    SELECT p.IDProducto, p.nombre_producto,p.cantidad_producto,p.precio_compra,p.precio_venta,p.descripcion,
    p.fecha_vencimiento,c.IDCategoria ,c.nombre_categoria,pp.ID_PPresentacion ,pp.medida_numerica,
    presen.IDPresentacion,presen.nombre_presentacion,
	p.IDProveedor,provee.empresa_proveedor
    FROM Producto p
    INNER JOIN ProductoPresentacion pp ON p.IDProducto = pp.IDProducto
    INNER JOIN Presentacion presen ON pp.IDPresentacion = presen.IDPresentacion
    INNER JOIN Categoria c ON p.IDCategoria = c.IDCategoria
	INNER JOIN Proveedor provee ON p.IDProveedor = provee.IDProveedor
END
GO
CREATE PROCEDURE VerificarProducto
@Dato NVARCHAR (50)
AS
BEGIN
    SELECT Producto.nombre_producto
    FROM Producto
    WHERE nombre_producto LIKE '%' + RTRIM (@Dato)+'%'
END
GO

--VALIDAR NUMERO DE TELEFONO EXISTENTE INGRESADO
CREATE PROCEDURE VerificarTelefonoExistente
    @DatoTelefono NVARCHAR(9)
AS
BEGIN
    SELECT Persona.telefono
    FROM Persona
    WHERE telefono LIKE '%' + RTRIM(@DatoTelefono) + '%'
END
GO

--VALIDAR NUMERO DE TELEFONO EXISTENTE PARA ACTUALIZAR
CREATE PROCEDURE VerificarTelefonoActualizado
    @IDPersona INT,
    @DatoTelefono NVARCHAR(9)
    
AS
BEGIN
    SELECT Persona.telefono
    FROM Persona
    WHERE telefono LIKE '%' + RTRIM(@DatoTelefono) + '%'
    AND IDPersona != @IDPersona;
END
GO

--PROCEDIMIENTO ALMACEADO PARA CONSULTAR CATEGORIA
CREATE PROCEDURE ConsultarCategoria
@nombre_categoria NVARCHAR(30)
AS
BEGIN
    SELECT nombre_categoria
    FROM Categoria
    WHERE nombre_categoria = @nombre_categoria;
END;
GO
--PROCEDIMINETO PARA LLENAR COMBOBOX
CREATE PROCEDURE LlenarCategoria
AS
  SELECT IDCategoria,nombre_categoria FROM Categoria
GO
--PROCEDIMINETO PARA LLENAR COMBOBOX
CREATE PROCEDURE LlenarPresentacion
AS
  SELECT IDPresentacion,nombre_presentacion FROM Presentacion
GO
--PROCEDIMINETO PARA LLENARCOMBOBOX
CREATE PROCEDURE LlenarProveedor
AS
  SELECT IDProveedor,empresa_proveedor FROM Proveedor
GO
  ------------------------------------------------------------------------------------------------
--------------------------------------------------------------------------------------------------
--PROCEDIMIENTO PARA ALMACENADO PARA ACTUALIZAR
--------------------------------------------------------------------------------------------------
--PROCEDIMIENTO PARA ACTUALIZAR CLIENTE
CREATE PROCEDURE ActualizarPersonaCliente
    @IDPersona INTEGER,
	@IDCliente INTEGER,
    @nombre1 NVARCHAR(15),
    @nombre2 NVARCHAR(15),
    @apellido1 NVARCHAR(15),
    @apellido2 NVARCHAR(15),
    @telefono NVARCHAR(9),
    @genero_cliente CHAR(1),
    @direccion NVARCHAR(150)
AS
BEGIN
    UPDATE Cliente
    SET genero_cliente= @genero_cliente
    WHERE IDCliente = @IDCliente;

	UPDATE Persona
	SET nombre1=@nombre1,nombre2=@nombre2,apellido1=@apellido1,apellido2=@apellido2,telefono=@telefono,direccion=@direccion
	WHERE IDPersona = @IDPersona
END
GO
--PROCEDIMIENTO ALMACENADO PARA ACTUALIZAR PROVEEDOR
CREATE PROCEDURE ActualizarPersonaProveedor
    @IDPersona INTEGER,
	@IDProveedor INTEGER,
    @nombre1 NVARCHAR(15),
    @nombre2 NVARCHAR(15),
    @apellido1 NVARCHAR(15),
    @apellido2 NVARCHAR(15),
	@telefono NVARCHAR(9),
    @empresa_proveedor NVARCHAR (15),
	@direccion NVARCHAR(150)
AS
BEGIN
    UPDATE Proveedor
    SET empresa_proveedor= @empresa_proveedor
    WHERE IDProveedor = @IDProveedor;

	UPDATE Persona
	SET nombre1=@nombre1,nombre2=@nombre2,apellido1=@apellido1,apellido2=@apellido2,telefono=@telefono,direccion=@direccion
	WHERE IDPersona = @IDPersona
END
GO
--PROCEDIMIENTO ALMACENADO PARA ACTUALIZAR PRODUCTO
CREATE PROCEDURE ActualizarProducto
    @IDProducto INT,
    @nombre_producto NVARCHAR(40),
    @cantidad_producto INTEGER,
    @precio_compra DECIMAL(12,2),
    @precio_venta DECIMAL(12,2),
    @descripcion NVARCHAR(200),
    @fecha_vencimiento DATE,
    @IDCategoria INTEGER,
    @IDPresentacion INTEGER,
    @medida_numerica DECIMAL(12,2),
	@IDProveedor INTEGER
AS
BEGIN
    -- Actualizar la tabla principal "Producto"
    UPDATE Producto
    SET
        nombre_producto = @nombre_producto,
        cantidad_producto = @cantidad_producto,
        precio_compra = @precio_compra,
        precio_venta = @precio_venta,
        descripcion = @descripcion,
        fecha_vencimiento = @fecha_vencimiento,
        IDCategoria = @IDCategoria,
		IDProveedor=@IDProveedor
    WHERE IDProducto = @IDProducto

    -- Actualizar la tabla intermedia "ProductoPresentacion"
    UPDATE ProductoPresentacion
    SET
        IDPresentacion = @IDPresentacion,
        medida_numerica = @medida_numerica
    WHERE IDProducto = @IDProducto
END
GO
--PROCEDIMIENTO ALMACENADO PARA ACTUALIZAR CATEGORIA
CREATE PROCEDURE ActualizarCategoria
    @IDCategoria INTEGER,
    @nombre_categoria NVARCHAR(15)
    
AS
BEGIN
    UPDATE Categoria
    SET nombre_categoria = @nombre_categoria
    WHERE IDCategoria = @IDCategoria;
END;
GO
--PROCEDIMIENTO ALMACENADO PARA ACTUALIZAR PRESENTACION
CREATE PROCEDURE ActualizarPresentacion
@IDPresentacion INTEGER,
@nombre_presentacion NVARCHAR (8)
AS
BEGIN
     UPDATE Presentacion
	 SET nombre_presentacion = @nombre_presentacion
	 WHERE IDPresentacion=@IDPresentacion;
END;
GO
--------------------------------------------------------------------------------------------------
---PROCEDIMIENTO ALMACENADO PARA ELIMINAR 
--------------------------------------------------------------------------------------------------
--------------------------------------------------------------------------------------------------
 --PROCEDIMIENTO ALMACENADO PARA ELIMINAR CLIENTE
CREATE PROCEDURE EliminarClienteVenta
@IDCliente INT
AS
BEGIN
      -- Verificar si el cliente tiene ventas asociadas
      IF EXISTS (SELECT 1 FROM Venta WHERE IDCliente = @IDCliente)
BEGIN
      -- Eliminar los detalles de venta relacionados con el cliente
      DELETE FROM Detalle_Venta WHERE IDVenta IN (SELECT IDVenta FROM Venta WHERE IDCliente = @IDCliente);

      -- Eliminar las ventas del cliente
      DELETE FROM Venta WHERE IDCliente = @IDCliente;
END

     -- Eliminar el cliente de la tabla Cliente
     DELETE FROM Cliente WHERE IDCliente = @IDCliente;

     -- Eliminar el cliente de la tabla Persona
     DELETE FROM Persona WHERE IDPersona = @IDCliente;
END
GO
--PROCEDIMINETO ALMACENADO PARA ELIMINAR PROVEEDOR
CREATE PROCEDURE EliminarProveedorPersona
@IDProveedor INT,
@IDPersona INT
AS
BEGIN
   BEGIN TRANSACTION;
   
   -- Deshabilitar la restricción de clave foránea
   ALTER TABLE Cliente NOCHECK CONSTRAINT FK_Cliente_Persona;
   
   -- Eliminar el proveedor en la tabla Proveedor
   DELETE FROM Proveedor 
   WHERE IDProveedor = @IDProveedor;

   -- Eliminar el registro en la tabla Persona
   DELETE FROM Persona
   WHERE IDPersona = @IDPersona;

   -- Habilitar nuevamente la restricción de clave foránea
   ALTER TABLE Cliente CHECK CONSTRAINT FK_Cliente_Persona;
   
   COMMIT;
END
GO
--PROCEDIMIENTO ALMACENDADO PARA ELIMINAR PRODUCTO
CREATE PROCEDURE EliminarProducto
    @Dato NVARCHAR (50)
AS
BEGIN
    -- Eliminar registros de la tabla intermedia "ProductoPresentacion" relacionados con el producto
    DELETE FROM ProductoPresentacion
    WHERE IDProducto = @Dato

    -- Eliminar el producto de la tabla principal "Producto"
    DELETE FROM Producto
    WHERE IDProducto = @Dato
END
GO
--PROCEDIMIENTO ALMACENADO PARA ELIMINAR CATEGORIA
CREATE PROCEDURE EliminarCategoria
@IDCategoria INTEGER
AS
  DELETE Categoria
  WHERE IDCategoria = @IDCategoria
GO
--PROCEDIMIENTO ALMACENADO PARA ELIMINAR PRESENTACION
CREATE PROCEDURE EliminarPresentacion
@IDPresentacion INTEGER
AS
  DELETE Presentacion
  WHERE IDPresentacion = @IDPresentacion
GO
--------------------------------------------------------------------------------------------------------------------------------------
--VISTAS O VIEW
--------------------------------------------------------------------------------------------------------------------------------------
-- VISTA VENTA: Vista_venta
CREATE VIEW Vista_venta AS
SELECT  v.IDVenta,
		v.fecha_venta,
		v.hora_venta,
		c.IDCliente,
		ps.nombre1,
		ps.nombre2,
		ps.apellido1,
		ps.apellido2,
		dv.cantidad_venta,
		pv.IDProducto,
		pv.nombre_producto
FROM Venta v
JOIN Cliente c ON v.IDCliente = c.IDCliente
JOIN Persona ps ON c.IDPersona = ps.IDPersona
JOIN Detalle_Venta dv ON v.IDVenta = dv.ID_DVenta
JOIN Producto pv ON dv.IDProducto = pv.IDProducto
GO
--Ejecutando Vista_producto
SELECT * FROM Vista_venta
GO
-- VISTA PRODUCTO: Producto
CREATE VIEW Vista_producto AS
SELECT  p.IDProducto, 
	    p.nombre_producto, 
		p.cantidad_producto, 
		p.precio_compra, 
		p.precio_venta, 
		p.descripcion, 
		p.fecha_vencimiento,
		pp.medida_numerica,
		pt.nombre_presentacion,
		ct.nombre_categoria,
		pv.empresa_proveedor
FROM Producto p
JOIN ProductoPresentacion pp ON p.IDProducto= pp.ID_PPresentacion
JOIN Presentacion pt ON p.IDProducto= pt.IDPresentacion
JOIN Categoria ct ON p.IDProducto= ct.IDCategoria
JOIN Proveedor pv ON p.IDProducto = pv.IDProveedor
GO

--Ejecutando Vista_producto
SELECT * FROM Vista_producto
GO

-- VISTA PERSONA CON CLIENTE: Cliente
CREATE VIEW Vista_cliente AS
SELECT c.IDCliente, p.nombre1, p.nombre2, p.apellido1, p.apellido2, p.telefono, p.direccion, c.genero_cliente
FROM Persona p
JOIN Cliente c ON p.IDPersona = c.IDPersona
GO
--Ejecutando Vista_cliente
SELECT * FROM Vista_cliente
GO

-- VISTA PERSONA CON PROVEEDOR: Proveedor
CREATE VIEW Vista_proveedor AS
SELECT pd.IDProveedor, p.nombre1, p.nombre2, p.apellido1, p.apellido2, p.telefono, p.direccion, pd.empresa_proveedor
FROM Persona p
JOIN Proveedor pd ON p.IDPersona = pd.IDPersona
GO

--Ejecutando Vista_proveedor
Select * from Vista_proveedor
GO
--Vista Venta Mensual
CREATE VIEW vista_ventas_mensuales AS
SELECT MONTH(V.fecha_venta) AS mes, YEAR(V.fecha_venta) AS año, SUM(D.cantidad_venta * P.precio_venta) AS total_ventas
FROM Venta V
INNER JOIN Detalle_Venta D ON V.IDVenta = D.IDVenta
INNER JOIN Producto P ON D.IDProducto = P.IDProducto
GROUP BY MONTH(V.fecha_venta), YEAR(V.fecha_venta);
GO

--Ejecutando Vista
SELECT * FROM vista_ventas_mensuales
GO

