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
direccion NVARCHAR (150)NOT NULL

)
GO

-- Creación de la tabla "Proveedor".
CREATE TABLE [Proveedor] (
  [IDProveedor] INTEGER IDENTITY (1,1)PRIMARY KEY,
  [empresa_proveedor] NVARCHAR(30)NOT NULL,
  IDPersona INTEGER UNIQUE,
  CONSTRAINT FK_Proveedor_Persona FOREIGN KEY (IDPersona) REFERENCES Persona (IDPersona)
  

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
  [nombre_producto] NVARCHAR(40)NOT NULL,
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
@direccion NVARCHAR (150),
@telefono NVARCHAR (9),
@genero_cliente CHAR (1)

AS
BEGIN
--SET NOCOUNT ON;

--DECLARE @IDPersona INTEGER

--INSERTAR LA TABLA PERSONA--

INSERT INTO Persona (nombre1,nombre2,apellido1,apellido2,telefono,direccion)
VALUES (@nombre1,@nombre2,@apellido1,@apellido2,@telefono,@direccion);

--OBTENER EL ULTIMO ID INSERTADO EN LA TABLA PERSONA--

--SET @IDPersona = SCOPE_IDENTITY();

INSERT INTO Cliente (IDPersona, genero_cliente)
VALUES (SCOPE_IDENTITY(),@genero_cliente);

END 

GO

SELECT * FROM Cliente
SELECT * FROM Persona

EXEC InsertarPersonaCliente 'Montiel','Marenco','Vargas','Torrez','Juigalpa','5786-7406','M'
EXEC InsertarPersonaCliente 'John', 'Doe', 'Smith', 'Johnson', 'New York', '1234-5678', 'M'
EXEC InsertarPersonaCliente 'Jane', 'Doe', 'Taylor', 'Anderson', 'Los Angeles', '9876-5432', 'F'
EXEC InsertarPersonaCliente 'Michael', 'Brown', 'Wilson', 'Davis', 'Chicago', '4567-8912', 'M'
EXEC InsertarPersonaCliente 'Emily', 'Johnson', 'Martinez', 'Garcia', 'Miami', '7891-2345', 'F'
EXEC InsertarPersonaCliente 'Daniel', 'Smith', 'Lopez', 'Thomas', 'Houston', '6543-2199', 'M'
EXEC InsertarPersonaCliente 'Sophia', 'Garcia', 'Lee', 'Perez', 'San Francisco', '9876-5432', 'F'
EXEC InsertarPersonaCliente 'Matthew', 'Johnson', 'Miller', 'Smith', 'Seattle', '5432-1098', 'M'
EXEC InsertarPersonaCliente 'Olivia', 'Brown', 'Wilson', 'Davis', 'Boston', '7890-6543', 'F'
EXEC InsertarPersonaCliente 'William', 'Anderson', 'Clark', 'Taylor', 'Dallas', '3210-9876', 'M'
EXEC InsertarPersonaCliente 'Isabella', 'Thomas', 'White', 'Jones', 'Phoenix', '8765-4321', 'F'
EXEC InsertarPersonaCliente 'Liam', 'Hernandez', 'Adams', 'Wang', 'San Diego', '1234-5098', 'M'
EXEC InsertarPersonaCliente 'Emma', 'Gonzalez', 'Harris', 'Lopez', 'Denver', '9087-6123', 'F'
EXEC InsertarPersonaCliente 'Noah', 'Rivera', 'Robinson', 'Scott', 'Austin', '6789-0543', 'M'
EXEC InsertarPersonaCliente 'Ava', 'Martinez', 'Turner', 'Morales', 'Orlando', '5432-1789', 'F'
EXEC InsertarPersonaCliente 'James', 'Lee', 'Cooper', 'Mitchell', 'Atlanta', '9876501234', 'M'

GO


--PROCEDIMIENTO ALMECENADO INSERTAR PROVEEDOR

CREATE PROCEDURE InsertarPersonaProveedor
@nombre1 NVARCHAR (15),
@nombre2 NVARCHAR (15),
@apellido1 NVARCHAR (15),
@apellido2 NVARCHAR (15),
@direccion NVARCHAR (150),
@telefono NVARCHAR (9),
@empresa_proveedor NVARCHAR (15)

AS
BEGIN
--SET NOCOUNT ON;

--DECLARE @IDPersona INTEGER

--INSERTAR LA TABLA PERSONA--

INSERT INTO Persona (nombre1,nombre2,apellido1,apellido2,telefono,direccion)
VALUES (@nombre1,@nombre2,@apellido1,@apellido2,@telefono,@direccion);

--OBTENER EL ULTIMO ID INSERTADO EN LA TABLA PERSONA--

--SET @IDPersona = SCOPE_IDENTITY();

INSERT INTO Proveedor(IDPersona, empresa_proveedor)
VALUES (SCOPE_IDENTITY(),@empresa_proveedor);

END 

GO

SELECT * FROM Persona
SELECT * FROM Proveedor

EXEC InsertarPersonaProveedor'Cristhian','Cesar','Vargas','Martinez','Juigalpa','5786-7406','Casa Pellas'
EXEC InsertarPersonaProveedor 'Gabriel', 'Cordero', 'Ramírez', 'López', 'Managua', '1234-5678', 'Empresa X'
EXEC InsertarPersonaProveedor 'Isabella', 'Torres', 'Guzmán', 'Sánchez', 'León', '9876-5432', 'Empresa Y'
EXEC InsertarPersonaProveedor 'Sebastián', 'Rojas', 'Flores', 'Pérez', 'Granada', '4567-8912', 'Empresa Z'
EXEC InsertarPersonaProveedor 'Valentina', 'Gutierrez', 'Herrera', 'Ortiz', 'Matagalpa', '7891-2345', 'Empresa A'
EXEC InsertarPersonaProveedor 'Mateo', 'Navarro', 'Silva', 'Gómez', 'Chinandega', '6543-2198', 'Empresa B'
EXEC InsertarPersonaProveedor 'Lucía', 'Ortega', 'Díaz', 'Lara', 'Estelí', '9876-5019', 'Empresa C'
EXEC InsertarPersonaProveedor 'Emilio', 'Mendoza', 'Castro', 'Ramón', 'Rivas', '1234-5098', 'Empresa D'
EXEC InsertarPersonaProveedor 'Valeria', 'Cabrera', 'Fuentes', 'Soto', 'Masaya', '9087-6123', 'Empresa E'
EXEC InsertarPersonaProveedor 'Matías', 'Chávez', 'Ríos', 'Núñez', 'Puerto Cabezas', '6789-0543', 'Empresa F'
EXEC InsertarPersonaProveedor 'Amelia', 'Suárez', 'Santana', 'Vega', 'Jinotega', '5432-1789', 'Empresa G'
EXEC InsertarPersonaProveedor 'Elena', 'Castillo', 'Morales', 'Fuentes', 'Boaco', '4567-8901', 'Empresa H'
EXEC InsertarPersonaProveedor 'Gabriel', 'Méndez', 'Cortez', 'López', 'Somoto', '8901-2345', 'Empresa I'
EXEC InsertarPersonaProveedor 'Valentina', 'Guerrero', 'Romero', 'Pérez', 'Puerto Cabezas', '5678-9012', 'Empresa J'
EXEC InsertarPersonaProveedor 'Joaquín', 'Rivas', 'Santos', 'Gómez', 'Jinotega', '9012-3456', 'Empresa K'
EXEC InsertarPersonaProveedor 'Carolina', 'Mendoza', 'Aguilar', 'Vega', 'Chinandega', '6789-0123', 'Empresa L'

GO

 --PROCEDIMIENTO ALMACENADO INSERTAR CATEGORIA

  CREATE PROCEDURE InsertarCategoria
  @nombre_categoria NVARCHAR (30)

  AS

  INSERT INTO [Categoria] ([nombre_categoria])
  VALUES (@nombre_categoria)
  GO

 EXEC InsertarCategoria @nombre_categoria = 'Lacteos';
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

SELECT * FROM Categoria

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



   SELECT * FROM Presentacion

   

   

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
    INSERT INTO Producto (nombre_producto, cantidad_producto, precio_compra, precio_venta, descripcion,fecha_vencimiento,IDCategoria,IDProveedor)
    VALUES (@nombre_producto, @cantidad_producto, @precio_compra, @precio_venta, @descripcion, @fecha_vencimiento,@IDCategoria,@IDProveedor)

    -- Obtener el ID generado para el nuevo producto
    SET @IDProducto = SCOPE_IDENTITY()


-- Insertar en la tabla intermedia "ProductoPresentacion"
    INSERT INTO ProductoPresentacion (IDProducto, IDPresentacion, medida_numerica)
    VALUES (@IDProducto, @IDPresentacion, @medida_numerica)
END
GO
SELECT * FROM Producto



    EXEC InsertarProducto
    @nombre_producto = 'Leche',
    @cantidad_producto = 10,
    @precio_compra = 100.00,
    @precio_venta = 150.00,
    @descripcion = 'Leche de vaca',
    @fecha_vencimiento = '2023-01-01',
    @IDCategoria = 1,
    @IDPresentacion = 1,
    @medida_numerica = 1.5,
	@IDProveedor=1;

	EXEC InsertarProducto
    @nombre_producto = 'Pan',
    @cantidad_producto = 20,
    @precio_compra = 50.00,
    @precio_venta = 80.00,
    @descripcion = 'Pan artesanal',
    @fecha_vencimiento = '2023-02-01',
    @IDCategoria = 2,
    @IDPresentacion = 2,
    @medida_numerica = 1,
	@IDProveedor=2;

	EXEC InsertarProducto
    @nombre_producto = 'Manzanas',
    @cantidad_producto = 15,
    @precio_compra = 80.00,
    @precio_venta = 120.00,
    @descripcion = 'Manzanas frescas',
    @fecha_vencimiento = '2023-03-01',
    @IDCategoria = 2,
    @IDPresentacion = 2,
    @medida_numerica = 2.5,
	@IDProveedor=3;


	EXEC InsertarProducto
    @nombre_producto = 'Azúcar',
    @cantidad_producto = 5,
    @precio_compra = 20.00,
    @precio_venta = 35.00,
    @descripcion = 'Azúcar refinada',
    @fecha_vencimiento = '2023-04-01',
    @IDCategoria = 4,
    @IDPresentacion = 4,
    @medida_numerica = 500.0,
	@IDProveedor=4;

	EXEC InsertarProducto
    @nombre_producto = 'Atún',
    @cantidad_producto = 12,
    @precio_compra = 15.00,
    @precio_venta = 25.00,
    @descripcion = 'Atún en lata',
    @fecha_vencimiento = '2023-05-01',
    @IDCategoria = 5,
    @IDPresentacion = 5,
    @medida_numerica = 160.0,
	@IDProveedor=5;

	EXEC InsertarProducto
    @nombre_producto = 'Papas',
    @cantidad_producto = 8,
    @precio_compra = 30.00,
    @precio_venta = 50.00,
    @descripcion = 'Papas fritas',
    @fecha_vencimiento = '2023-06-01',
    @IDCategoria = 6,
    @IDPresentacion = 6,
    @medida_numerica = 200.0,
	@IDProveedor=6;

    SELECT * FROM Producto
	SELECT * FROM Categoria
	SELECT * FROM Presentacion
	SELECT * FROM ProductoPresentacion


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

   Select * from Cliente
   Select * from Venta
   Select * from Detalle_Venta
   Select * from Producto
   GO

      --PROCEDIMIENTO ALMACENADO PARA INSERTAR COMPRA
  CREATE PROCEDURE InsertarCompra
AS
BEGIN
   DECLARE @fecha_compra DATE = GETDATE();
   DECLARE @hora_compra TIME = GETDATE();

   INSERT INTO [Compra] ([fecha_compra],[hora_compra])
   VALUES (@fecha_compra,@hora_compra);

END
GO

   --PROCEDIMIENTO ALMACENADO PARA INSERTAR PRODUCTO COMPRA
   CREATE PROCEDURE ProductoCompra
   @cantidad_compra INT,
   @IDCompra INT,
   @IDProducto INT

   AS
   BEGIN

   INSERT INTO ProductoCompra (cantidad_compra)
   VALUES (@cantidad_compra);

   BEGIN TRANSACTION;

   UPDATE Producto
   SET cantidad_producto = cantidad_producto + @cantidad_compra
   WHERE IDProducto = @IDProducto

   COMMIT TRANSACTION;
   END
   GO




SELECT * FROM Compra
SELECT * FROM Producto	
--------------------------------------------------------------------------------------------------------------------------------













-------------------------------------------------------------------------------------------------
-----PROCEDIMIENTOS ALMACENADOS PARA BUSCAR
-------------------------------------------------------------------------------------------------

--PROCEDIMIENTO ALMACENADO PARA BUCAR CLIENTE

CREATE PROCEDURE BuscarCliente
 @Dato NVARCHAR (50)
AS
BEGIN
    SELECT  Cliente.IDCliente,nombre1,nombre2,apellido1,apellido2,telefono,Cliente.genero_cliente,
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

Exec BuscarClienteCombo @Dato = 'Emma';

GO

--procedimiento almacenado para buscar proveedores
CREATE PROCEDURE BuscarProveedor
 @Dato NVARCHAR (50)
AS
BEGIN
    SELECT  Proveedor.IDProveedor,nombre1,nombre2,apellido1,apellido2,telefono,Proveedor.empresa_proveedor,
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
	SELECT Producto.IDProducto,nombre_producto, cantidad_producto, precio_compra, precio_venta, descripcion,fecha_vencimiento,Categoria.IDCategoria,
	Categoria.nombre_categoria, ProductoPresentacion.ID_PPresentacion, ProductoPresentacion.medida_numerica, Presentacion.IDPresentacion, Presentacion.nombre_presentacion,
	Proveedor.IDProveedor,Proveedor.empresa_proveedor
	FROM   Producto 
	INNER JOIN ProductoPresentacion ON Producto.IDProducto = ProductoPresentacion.IDProducto
    INNER JOIN Presentacion ON ProductoPresentacion.IDPresentacion = Presentacion.IDPresentacion
    INNER JOIN Categoria ON Producto.IDCategoria = Categoria.IDCategoria
	INNER JOIN Proveedor ON Producto.IDProveedor = Proveedor.IDProveedor

	WHERE nombre_producto LIKE '%' + RTRIM (@Dato)+'%'
	OR empresa_proveedor LIKE '%' + RTRIM (@Dato)+ '%'
	OR nombre_categoria LIKE '%' + RTRIM (@Dato) + '%'
	OR nombre_presentacion LIKE '%' + RTRIM (@Dato + '%')
	END
	GO

	EXEC BuscarProducto @Dato= 'Cafe'

	GO
-----------------------------------------------------------------------------------------------------------------------------




















-----------------------------------------------------------------------------------------------------
--PROCEDIMIENTOS ALMACENADOS PARA CONSULTAR 
-----------------------------------------------------------------------------------------------------
--PROCEDIMIENTO ALMACENADO PARA CONSULTAR UN COMPRA FINALIZADA
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

EXEC ConsultarClienteVentaDetalleVenta;
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

EXEC ConsultarCliente

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
EXEC ConsultarProveedor

GO

Select * from Proveedor
select * from Persona
GO

--PROCEDIMIENTO ALMACENADO PARA CONSULTAR PRODUCTO

CREATE PROCEDURE ConsultarProducto
AS
BEGIN 
    SELECT Producto.IDProducto, Producto.nombre_producto,Producto.cantidad_producto,Producto.precio_compra, Producto.precio_venta, Producto.descripcion,
    Producto.fecha_vencimiento,Categoria.IDCategoria ,Categoria.nombre_categoria, ProductoPresentacion.ID_PPresentacion ,ProductoPresentacion.medida_numerica ,Presentacion.IDPresentacion,Presentacion.nombre_presentacion,
	Producto.IDProveedor,Proveedor.empresa_proveedor
    FROM Producto 
    INNER JOIN ProductoPresentacion ON Producto.IDProducto = ProductoPresentacion.IDProducto
    INNER JOIN Presentacion ON ProductoPresentacion.IDPresentacion = Presentacion.IDPresentacion
    INNER JOIN Categoria ON Producto.IDCategoria = Categoria.IDCategoria
	INNER JOIN Proveedor ON Producto.IDProveedor = Proveedor.IDProveedor

END

GO
SELECT * FROM Producto
SELECT * FROM Presentacion
SELECT * FROM Categoria
SELECT * FROM ProductoPresentacion

EXEC ConsultarProducto

GO

CREATE PROCEDURE VerificarProducto
@Dato NVARCHAR (50)
AS
BEGIN
SELECT Producto.nombre_producto

FROM Producto
    --INNER JOIN ProductoPresentacion ON Producto.IDProducto = ProductoPresentacion.IDProducto
    --INNER JOIN Presentacion ON ProductoPresentacion.IDPresentacion = Presentacion.IDPresentacion
    --INNER JOIN Categoria ON Producto.IDCategoria = Categoria.IDCategoria

	WHERE nombre_producto LIKE '%' + RTRIM (@Dato)+'%'
	
END

GO

CREATE PROCEDURE VerificarTelefono
@DatoTelefono NVARCHAR (9)
AS
BEGIN
SELECT Persona.telefono

FROM Persona
	WHERE telefono LIKE '%' + RTRIM (@DatoTelefono)+'%'
	
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

  SELECT * FROM Categoria

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
  -------------------------------------------------------------------------------------------------------









   










--------------------------------------------------------------------------------------------------
--PROCEDIMIENTO PARA ALMACENADO PARA ACTUALIZAR
--------------------------------------------------------------------------------------------------


--PROCEDIMIENTO PARA ACTUALIZAR CLIENTE

 CREATE PROCEDURE ActualizarPersonaCliente
    @IDPersona INTEGER,
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
    WHERE IDPersona = @IDPersona;

	UPDATE Persona
	SET nombre1=@nombre1,nombre2=@nombre2,apellido1=@apellido1,apellido2=@apellido2,telefono=@telefono,direccion=@direccion
	WHERE IDPersona = @IDPersona
END



GO


--PROCEDIMIENTO ALMACENADO PARA ACTUALIZAR PROVEEDOR

 CREATE PROCEDURE ActualizarPersonaProveedor
    @IDPersona INTEGER,
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
    WHERE IDPersona = @IDPersona;

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

    SELECT * FROM Producto
    SELECT * FROM ProductoPresentacion

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

  Select * from Cliente
  Select * from Venta
  Select * from Detalle_Venta
  EXEC EliminarClienteVenta @IDCliente = 3;
GO


  --PROCEDIMINETO ALMACENADO PARA ELIMINAR PROVEEDOR
 CREATE PROCEDURE EliminarProveedorPersona
  @Dato NVARCHAR (150)

  AS

  DELETE FROM Proveedor WHERE IDProveedor=@Dato
  DELETE FROM Persona WHERE IDPersona=@Dato


  GO

  SELECT * FROM Cliente
  SELECT* FROM Proveedor
  SELECT * FROM Persona

  EXEC EliminarProveedorPersona @Dato = 1

  GO
 
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

--EXEC EliminarProducto @Dato = 2

--    SELECT * FROM Producto
--    SELECT * FROM ProductoPresentacion

--	SELECT * FROM Categoria

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

