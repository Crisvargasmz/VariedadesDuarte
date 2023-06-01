USE master
CREATE DATABASE VariedadesDuarte
GO

-- Base de datos.
USE VariedadesDuarte
GO

-- Creación de la tabla "Proveedor".
CREATE TABLE [Proveedor] (
  [IDProveedor] INTEGER IDENTITY (1,1)PRIMARY KEY,
  [empresa_proveedor] NVARCHAR(30)NOT NULL,
  IDPersona INTEGER UNIQUE 

)
GO

-- Creación de la tabla "Cliente".
CREATE TABLE [Cliente] (
  [IDCliente] INTEGER IDENTITY(1,1) PRIMARY KEY,
  [genero_cliente] CHAR (1) NOT NULL,
  IDPersona INTEGER UNIQUE 

 
)
GO

-- Creación de la tabla "Venta".
CREATE TABLE [Venta] (
  [IDVenta] INTEGER IDENTITY(1,1) PRIMARY KEY,
  [fecha_venta] DATE,
  [hora_venta] TIME
 
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
  [fecha_vencimiento] DATE,

)
GO

-- Creación de la tabla "Categoria".
CREATE TABLE [Categoria] (
  [IDCategoria] INTEGER IDENTITY(1,1) PRIMARY KEY,
  [nombre_categoria] NVARCHAR(15) NOT NULL,

)
GO

-- Creación de la tabla "Compra".
CREATE TABLE [Compra] (
  [IDCompra] INTEGER IDENTITY(1,1) PRIMARY KEY,
  [fecha_compra] DATE,
  [hora_compra] TIME

)
GO

-- Creación de la tabla "Inicio Sesion".
CREATE TABLE [IniciodeSesion](
[ID_InicioSesion] INTEGER IDENTITY (1,1) PRIMARY KEY,
usuario_sesion NVARCHAR (20) NOT NULL,
contrasena_sesion NVARCHAR (8) NOT NULL
)
GO

-- Creación de la tabla "Presentacion".
CREATE TABLE [Presentacion](
IDPresentacion INTEGER IDENTITY (1,1) PRIMARY KEY,
nombre_presentacion NVARCHAR (8)

)
GO

-- Creación de la tabla "Persona".
CREATE TABLE [Persona](
IDPersona INTEGER IDENTITY (1,1) PRIMARY KEY,
nombre1 NVARCHAR (15),
nombre2 NVARCHAR (15),
apellido1 NVARCHAR (15),
apellido2 NVARCHAR (15),
telefono NVARCHAR (9),
direccion NVARCHAR (150)

)
GO

--Agregar clave foránea IDPersona en la tabla "Proveedores"

ALTER TABLE dbo.Proveedor
ADD CONSTRAINT FK_Persona_Proveedor
FOREIGN KEY (IDPersona)
REFERENCES dbo.Persona(IDPersona)

--Agregar Clave foránea IDPersona en la tabla "Clientes"


ALTER TABLE dbo.Cliente
ADD CONSTRAINT FK_Persona_Cliente
FOREIGN KEY (IDPersona)
REFERENCES dbo.Persona(IDPersona)

-- Agregar clave foránea IDCliente en la tabla "Venta".
ALTER TABLE dbo.Venta
ADD IDCliente INT NOT NULL
ALTER TABLE dbo.Venta
ADD CONSTRAINT FK_Clientes_Ventas
FOREIGN KEY (IDCliente)
REFERENCES dbo.Cliente(IDCliente)

-- Agregar clave foránea IDCategoria en la tabla "Producto".
ALTER TABLE dbo.Producto
ADD IDCategoria  INT NOT NULL
ALTER TABLE dbo.Producto
ADD CONSTRAINT FK_Categoria_Producto
FOREIGN KEY (IDCategoria)
REFERENCES dbo.Categoria(IDCategoria)

-- Agregar clave foránea IDProveedor en la tabla "Compra".
ALTER TABLE dbo.Compra
ADD IDProveedor  INT NOT NULL
ALTER TABLE dbo.Compra
ADD CONSTRAINT FK_Proveedor_Compra
FOREIGN KEY (IDProveedor)
REFERENCES dbo.Proveedor(IDProveedor)

-- Creación de la tabla Intermedia "Detalle_Venta".
CREATE TABLE [Detalle_Venta] (
  [ID_DVenta] INTEGER IDENTITY(1,1) PRIMARY KEY,
  cantidad_venta INTEGER NOT NULL,
 
)
GO

-- Creación de la tabla Intermedia "Detalle_Compra".
CREATE TABLE [Detalle_Compra] (
  [ID_DCompra] INTEGER IDENTITY(1,1) PRIMARY KEY,
  cantidad_compra INTEGER NOT NULL,

)
GO

-- Creación de la tabla Intermedia "ProductoPresentacion".
CREATE TABLE [ProductoPresentacion](
 ID_PPresentacion INTEGER IDENTITY (1,1) PRIMARY KEY,
medida_numerica DECIMAL (12,2)

)
GO

-- Agregar clave foránea IDProducto en la tabla "ProductoPresentacion".
ALTER TABLE dbo.ProductoPresentacion
ADD IDProducto INT  NOT NULL
ALTER TABLE dbo.ProductoPresentacion
ADD CONSTRAINT FK_ProductoPresentacion_Producto
FOREIGN KEY (IDProducto)
REFERENCES dbo.Producto(IDProducto)

-- Agregar clave foránea IDPresentacion en la tabla "ProductoPresentacion".
ALTER TABLE dbo.ProductoPresentacion
ADD IDPresentacion INT  NOT NULL
ALTER TABLE dbo.ProductoPresentacion
ADD CONSTRAINT FK_Presentacion_Producto
FOREIGN KEY (IDPresentacion)
REFERENCES dbo.Presentacion(IDPresentacion)

-- Agregar clave foránea IDProducto en la tabla "Detalle_Venta".
ALTER TABLE dbo.Detalle_Venta
ADD IDProducto INT  NOT NULL
ALTER TABLE dbo.Detalle_Venta
ADD CONSTRAINT FK_Detalle_Venta_P
FOREIGN KEY (IDProducto)
REFERENCES dbo.Producto(IDProducto)

-- Agregar clave foránea IDVenta en la tabla "Detalle_Venta".
ALTER TABLE dbo.Detalle_Venta
ADD IDVenta INT  NOT NULL
ALTER TABLE dbo.Detalle_Venta
ADD CONSTRAINT FK_Detalle_Venta_V
FOREIGN KEY (IDVenta)
REFERENCES dbo.Venta(IDVenta)

-- Agregar clave foránea IDProducto en la tabla "Detalle_Compra".
ALTER TABLE dbo.Detalle_Compra
ADD IDProducto INT  NOT NULL
ALTER TABLE dbo.Detalle_Compra
ADD CONSTRAINT FK_Detalle_Compra_Pto
FOREIGN KEY (IDProducto)
REFERENCES dbo.Producto( IDProducto)

-- Agregar clave foránea IDCompra en la tabla "Detalle_Compra".
ALTER TABLE dbo.Detalle_Compra
ADD IDCompra INT  NOT NULL
ALTER TABLE dbo.Detalle_Compra
ADD CONSTRAINT FK_Detalle_Compra_Pdor
FOREIGN KEY ( IDCompra)
REFERENCES dbo.Compra( IDCompra)
GO




-------------------------------------------------------------------------------------------------
-----PROCEDIMIENTOS ALMACENADOS PARA INSERTAR
-------------------------------------------------------------------------------------------------

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
SET NOCOUNT ON;

DECLARE @IDPersona INTEGER

--INSERTAR LA TABLA PERSONA--

INSERT INTO Persona (nombre1,nombre2,apellido1,apellido2,telefono,direccion)
VALUES (@nombre1,@nombre2,@apellido1,@apellido2,@telefono,@direccion);

--OBTENER EL ULTIMO ID INSERTADO EN LA TABLA PERSONA--

SET @IDPersona = SCOPE_IDENTITY();

INSERT INTO Cliente (IDPersona, genero_cliente)
VALUES (@IDPersona,@genero_cliente);

END 

GO

--SELECT * FROM Cliente
--SELECT * FROM Persona

EXEC InsertarPersonaCliente 'Montiel','Marenco','Vargas','Torrez','Juigalpa','57867406','M'
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
SET NOCOUNT ON;

DECLARE @IDPersona INTEGER

--INSERTAR LA TABLA PERSONA--

INSERT INTO Persona (nombre1,nombre2,apellido1,apellido2,telefono,direccion)
VALUES (@nombre1,@nombre2,@apellido1,@apellido2,@telefono,@direccion);

--OBTENER EL ULTIMO ID INSERTADO EN LA TABLA PERSONA--

SET @IDPersona = SCOPE_IDENTITY();

INSERT INTO Proveedor(IDPersona, empresa_proveedor)
VALUES (@IDPersona,@empresa_proveedor);

END 

GO

SELECT * FROM Persona
SELECT * FROM Proveedor

EXEC InsertarPersonaProveedor'Cristhian','Cesar','Vargas','Martinez','Juigalpa','57867406','Casa Pellas'
GO

 --PROCEDIMIENTO ALMACENADO INSERTAR CATEGORIA

  CREATE PROCEDURE InsertarCategoria
  @nombre_categoria NVARCHAR (15)

  AS

  INSERT INTO [Categoria] ([nombre_categoria])
  VALUES (@nombre_categoria)
  GO

  --EXEC InsertarCategoria @nombre_categoria = 'Gaseosas';
  GO

--PROCEDIMIENTO ALMACENADO INSERTAR PRESENTACION 

   CREATE PROCEDURE InsertarPresentacion
   @nombre_presentacion NVARCHAR (8)

   AS

   INSERT INTO [Presentacion] ([nombre_presentacion])
   VALUES (@nombre_presentacion)
   GO

   --EXEC InsertarPresentacion 'Lt';
   GO

--PROCEDIMIENTO ALMACENADO INSERTAR PRODUCTO

CREATE PROCEDURE InsertarProducto
  @nombre_producto NVARCHAR(40),
  @cantidad_producto INTEGER ,
  @precio_compra DECIMAL(12,2),
  @precio_venta DECIMAL(12,2) ,
  @descripcion NVARCHAR(200) ,
  @fecha_vencimiento DATE,
  @IDCategoria INT,
  @IDPresentacion INT
 

  AS

  INSERT INTO [Producto] ([nombre_producto],[cantidad_producto],[precio_compra],[precio_venta],[descripcion],[fecha_vencimiento],IDCategoria,IDPresentacion)
  VALUES (@nombre_producto,@cantidad_producto,@precio_compra,@precio_venta,@descripcion,@fecha_vencimiento,@IDCategoria,@IDPresentacion)
  GO
CREATE PROCEDURE InsertarProducto2
  @nombre_producto NVARCHAR(40),
  @cantidad_producto INTEGER,
  @precio_compra DECIMAL(12,2),
  @precio_venta DECIMAL(12,2),
  @descripcion NVARCHAR(200),
  @fecha_vencimiento DATE,
  @IDCategoria INT,
  @IDPresentacion INT,
  @ID_PPresentacion INT,
  @precio_pproducto INT
AS
BEGIN
  DECLARE @nombre_presentacion NVARCHAR(8)

  -- Obtener el nombre de la presentación asociada al IDPresentacion
  SELECT @nombre_presentacion = [nombre_presentacion]
  FROM [Presentacion]
  WHERE [IDPresentacion] = @IDPresentacion

  -- Insertar el producto en la tabla "Producto"
  INSERT INTO [Producto] ([nombre_producto], [cantidad_producto], [precio_compra], [precio_venta], [descripcion], [fecha_vencimiento], [IDCategoria])
  VALUES (@nombre_producto, @cantidad_producto, @precio_compra, @precio_venta, @descripcion, @fecha_vencimiento, @IDCategoria)

  -- Obtener el ID del producto recién insertado
  DECLARE @IDProducto INT
  SET @IDProducto = SCOPE_IDENTITY()

  -- Insertar el registro en la tabla "ProductoPresentacion" para establecer la relación
  INSERT INTO ProductoPresentacion ([ID_PPresentacion], [IDProducto], [IDPresentacion], [precio_pproducto])
  VALUES (@ID_PPresentacion, @IDProducto, @IDPresentacion,@precio_pproducto)
END

GO

--INSERTAR PRODUCTO PRESENTACION

   CREATE PROCEDURE InsertarProductoPresentacion
   @medida_numerica DECIMAL (12,2),
   @IDProducto INTEGER,
   @IDPresentacion INTEGER

   AS

   INSERT INTO [ProductoPresentacion] ([precio_pproducto],[IDProducto],[IDPresentacion])
   VALUES (@precio_pproducto, @IDProducto, @IDPresentacion)
   GO

   EXEC InsertarProductoPresentacion @precio_pproducto = 12.00, @IDProducto = 1, @IDPresentacion = 1;
   GO

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

-----------------------------------------------------------------------------------------------------

--procedimiento almacenado para consultar cliente

CREATE PROCEDURE ConsultarCliente
AS
BEGIN
  SELECT Cliente.IDCliente,Persona.nombre1,Persona.nombre2,Persona.apellido1,
  Persona.apellido2,Persona.telefono,Cliente.genero_cliente,Persona.direccion

  FROM Cliente inner join Persona on Cliente.IDPersona=Persona.IDPersona

END
GO

--EXEC ConsultarCliente

GO


--------------------------------------------------------------------------------------------------------

--procedimiento almacenado para Consultar un proveedor
CREATE PROCEDURE ConsultarProveedor
AS
BEGIN
  SELECT Proveedor.IDProveedor,Persona.nombre1,Persona.nombre2,Persona.apellido1,
  Persona.apellido2,Persona.telefono,Proveedor.empresa_proveedor,Persona.direccion

  FROM Proveedor inner join Persona on Proveedor.IDProveedor=Persona.IDPersona

END
GO
--EXEC ConsultarProveedor
--exec ConsultarCliente
--EXEC EliminarClientePersona 4
GO

Select * from Proveedor
select * from Persona





  GO

--procedimiento almacenado para consultar un producto
CREATE PROCEDURE ConsultarProducto
    @nombre_producto NVARCHAR(40) = NULL,
    @cantidad_producto INTEGER = NULL,
    @precio_compra DECIMAL(12,2) = NULL,
    @precio_venta DECIMAL(12,2) = NULL,
    @descripcion NVARCHAR(200) = NULL,
    @fecha_vencimiento DATETIME = NULL,
	@IDCategoria INTEGER = NULL
AS
BEGIN
    SELECT *
    FROM Producto
    WHERE (nombre_producto = @nombre_producto OR @nombre_producto IS NULL)
        AND (cantidad_producto = @cantidad_producto OR @cantidad_producto IS NULL)
        AND (precio_compra = @precio_compra OR @precio_compra IS NULL)
        AND (precio_venta = @precio_venta OR @precio_venta IS NULL)
        AND (descripcion = @descripcion OR @descripcion IS NULL)
        AND (fecha_vencimiento = @fecha_vencimiento OR @fecha_vencimiento IS NULL)
		AND (IDCategoria = @IDCategoria OR @IDCategoria IS NULL);
END;


  GO

   --procedimiento almacenado para consultar una categoria
CREATE PROCEDURE ConsultarCategoria
    @nombre_categoria NVARCHAR(15)
AS
BEGIN
    SELECT nombre_categoria
    FROM Categoria
    WHERE nombre_categoria = @nombre_categoria;
END;


  GO

  --SELECT * FROM Categoria

  GO

  --procedimiento para llenar categorias

  CREATE PROCEDURE LlenarCombo

  AS
  SELECT nombre_categoria FROM Categoria

  GO

  --procedimiento almacenado para consultar una presentacion

CREATE PROCEDURE ConsultarPresentacion
    @nombre_presentacion NVARCHAR(8)
AS
BEGIN
    SELECT *
    FROM Presentacion
    WHERE nombre_presentacion = @nombre_presentacion;
END;


   GO

     --procedimiento para llenar categorias

  CREATE PROCEDURE LlenarCombo2

  AS
  SELECT nombre_presentacion FROM Presentacion

  GO

   
   --------------------------------------------------------------------------------------------------

   
 --Procedimiento almacenado para actualizar cliente

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

--EXEC ActualizarPersonaCliente 1,'Cristhian','Cesar','Vargas','Martinez','57867406','M','juigalpa';
--GO
--SELECT * FROM Cliente
--SELECT * FROM Persona
--GO



 --Procedimiento almacenado para actualizar proveedor

 CREATE PROCEDURE ActualizarPersonaProveedor
    @IDPersona INTEGER,
    @nombre1 NVARCHAR(15),
    @nombre2 NVARCHAR(15),
    @apellido1 NVARCHAR(15),
    @apellido2 NVARCHAR(15),
    @empresa_proveedor NVARCHAR (15),
	@telefono NVARCHAR(9),
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

 --Procedimiento almacenado para actualizar producto

CREATE PROCEDURE ActualizarProducto
    @IDProducto INTEGER,
    @nombre_producto NVARCHAR(40),
    @cantidad_producto INT,
    @precio_compra DECIMAL(12, 2),
    @precio_venta DECIMAL(12, 2),
    @descripcion NVARCHAR(200),
    @fecha_vencimiento DATETIME
   
AS
BEGIN
    UPDATE Producto
    SET nombre_producto = @nombre_producto,
        cantidad_producto = @cantidad_producto,
        precio_compra = @precio_compra,
        precio_venta = @precio_venta,
        descripcion = @descripcion,
        fecha_vencimiento = @fecha_vencimiento
    WHERE IDProducto = @IDProducto;
END;

GO

 --Procedimiento almacenado para actualizar categoria

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

 --Procedimiento almacenado para actualizar presentacion

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
   ---Procedimiento almacenado para eliminar cliente

   CREATE PROCEDURE EliminarClientePersona
  @Dato NVARCHAR (150)

  AS

  DELETE FROM Cliente WHERE IDCliente=@Dato
  DELETE FROM Persona WHERE IDPersona=@Dato


  GO



  --procedimiento almacenado para eliminar un proveedor
 CREATE PROCEDURE EliminarProveedorPersona
  @Dato NVARCHAR (150)

  AS

  DELETE FROM Proveedor WHERE IDProveedor=@Dato
  DELETE FROM Persona WHERE IDPersona=@Dato


  GO

  

  --procedimiento almacenado para eliminar un producto
CREATE PROCEDURE EliminarProducto
 @IDProducto INTEGER

  AS

  DELETE Producto
  WHERE IDProducto = @IDProducto

  GO
--procedimiento almacenado para eliminar una categoria
  CREATE PROCEDURE EliminarCategoria
  @IDCategoria INTEGER

  AS

  DELETE Categoria
  WHERE IDCategoria = @IDCategoria

  GO
--procedimiento almacenado para eliminar una presentacion

CREATE PROCEDURE EliminarPresentacion
@IDPresentacion INTEGER

AS

DELETE Presentacion
WHERE IDPresentacion = @IDPresentacion

GO
--------------------------------------------------------------------------------------------------------------------------------------

