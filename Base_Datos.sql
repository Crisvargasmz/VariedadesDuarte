USE master
CREATE DATABASE VariedadesDuarte
GO
USE VariedadesDuarte
CREATE TABLE [Proveedor] (
  [IDProveedor] INTEGER IDENTITY (1,1)PRIMARY KEY,
  [empresa_proveedor] NVARCHAR(30)NOT NULL,
  IDPersona INTEGER UNIQUE

)
GO

CREATE TABLE [Cliente] (
  [IDCliente] INTEGER IDENTITY(1,1) PRIMARY KEY,
  [genero_cliente] CHAR (1) NOT NULL,
  IDPersona INTEGER UNIQUE
 
)
GO

CREATE TABLE [Venta] (
  [IDVenta] INTEGER IDENTITY(1,1) PRIMARY KEY,
  [fecha_venta] DATE,
  [hora_venta] TIME
 
)
GO

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

CREATE TABLE [Categoria] (
  [IDCategoria] INTEGER IDENTITY(1,1) PRIMARY KEY,
  [nombre_categoria] NVARCHAR(15) NOT NULL,
)
GO

CREATE TABLE [Compra] (
  [IDCompra] INTEGER IDENTITY(1,1) PRIMARY KEY,
  [fecha_compra] DATE,
  [hora_compra] TIME

)
GO

CREATE TABLE [IniciodeSesion](
[ID_InicioSesion] INTEGER IDENTITY (1,1) PRIMARY KEY,
usuario_sesion NVARCHAR (20) NOT NULL,
contrasena_sesion NVARCHAR (8) NOT NULL
)
GO

CREATE TABLE [Presentacion](
IDPresentacion INTEGER IDENTITY (1,1) PRIMARY KEY,
nombre_presentacion NVARCHAR (8)

)
GO

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

ALTER TABLE dbo.Venta
ADD IDCliente INT NOT NULL
ALTER TABLE dbo.Venta
ADD CONSTRAINT FK_Clientes_Ventas
FOREIGN KEY (IDCliente)
REFERENCES dbo.Cliente(IDCliente)


ALTER TABLE dbo.Producto
ADD IDCategoria  INT NOT NULL
ALTER TABLE dbo.Producto
ADD CONSTRAINT FK_Categoria_Producto
FOREIGN KEY (IDCategoria)
REFERENCES dbo.Categoria(IDCategoria)

ALTER TABLE dbo.Compra
ADD IDProveedor  INT NOT NULL
ALTER TABLE dbo.Compra
ADD CONSTRAINT FK_Proveedor_Compra
FOREIGN KEY (IDProveedor)
REFERENCES dbo.Proveedor(IDProveedor)


CREATE TABLE [Detalle_Venta] (
  [ID_DVenta] INTEGER IDENTITY(1,1) PRIMARY KEY,
  cantidad_venta INTEGER NOT NULL,
 
)
GO



CREATE TABLE [Detalle_Compra] (
  [ID_DCompra] INTEGER IDENTITY(1,1) PRIMARY KEY,
  cantidad_compra INTEGER NOT NULL,

)
GO

CREATE TABLE [ProductoPresentacion](
 ID_PPresentacion INTEGER IDENTITY (1,1) PRIMARY KEY,
precio_pproducto DECIMAL (12,2)

)
GO


ALTER TABLE dbo.ProductoPresentacion
ADD IDProducto INT  NOT NULL
ALTER TABLE dbo.ProductoPresentacion
ADD CONSTRAINT FK_ProductoPresentacion_Producto
FOREIGN KEY (IDProducto)
REFERENCES dbo.Producto(IDProducto)

ALTER TABLE dbo.ProductoPresentacion
ADD IDPresentacion INT  NOT NULL
ALTER TABLE dbo.ProductoPresentacion
ADD CONSTRAINT FK_Presentacion_Producto
FOREIGN KEY (IDPresentacion)
REFERENCES dbo.Presentacion(IDPresentacion)

ALTER TABLE dbo.Detalle_Venta
ADD IDProducto INT  NOT NULL
ALTER TABLE dbo.Detalle_Venta
ADD CONSTRAINT FK_Detalle_Venta_P
FOREIGN KEY (IDProducto)
REFERENCES dbo.Producto(IDProducto)

  ALTER TABLE dbo.Detalle_Venta
ADD IDVenta INT  NOT NULL
ALTER TABLE dbo.Detalle_Venta
ADD CONSTRAINT FK_Detalle_Venta_V
FOREIGN KEY (IDVenta)
REFERENCES dbo.Venta( IDVenta)



ALTER TABLE dbo.Detalle_Compra
ADD IDProducto INT  NOT NULL
ALTER TABLE dbo.Detalle_Compra
ADD CONSTRAINT FK_Detalle_Compra_Pto
FOREIGN KEY (IDProducto)
REFERENCES dbo.Producto( IDProducto)


ALTER TABLE dbo.Detalle_Compra
ADD IDCompra INT  NOT NULL
ALTER TABLE dbo.Detalle_Compra
ADD CONSTRAINT FK_Detalle_Compra_Pdor
FOREIGN KEY ( IDCompra)
REFERENCES dbo.Compra( IDCompra)
GO


-----------------------------------------------------------------------------------------------------------

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

--INSERTAR LA TABLA PERSONA 
INSERT INTO Persona (nombre1,nombre2,apellido1,apellido2,telefono,direccion)
VALUES (@nombre1,@nombre2,@apellido1,@apellido2,@telefono,@direccion);

--OBTENER EL ULTIMO ID INSERTADO EN LA TABLA PERSONA

SET @IDPersona = SCOPE_IDENTITY();

INSERT INTO Cliente (IDPersona, genero_cliente)
VALUES (@IDPersona,@genero_cliente);


END 

GO

SELECT * FROM Cliente
SELECT * FROM Persona

EXEC InsertarPersonaCliente 'ADF','FD','DFD','DFFD','DFDF','65676787','G'
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

--INSERTAR LA TABLA PERSONA 
INSERT INTO Persona (nombre1,nombre2,apellido1,apellido2,telefono,direccion)
VALUES (@nombre1,@nombre2,@apellido1,@apellido2,@telefono,@direccion);

--OBTENER EL ULTIMO ID INSERTADO EN LA TABLA PERSONA

SET @IDPersona = SCOPE_IDENTITY();

INSERT INTO Proveedor(IDPersona, empresa_proveedor)
VALUES (@IDPersona,@empresa_proveedor);


SELECT * FROM Persona
SELECT * FROM Proveedor
END 

GO

EXEC InsertarPersonaProveedor'ADF','FD','DFD','DFFD','DFDF','65676787','G'
GO

   --PROCEDIMIENTO ALMACENADO INSERTAR PRODUCTO
CREATE PROCEDURE InsertarProducto
  @nombre_producto NVARCHAR(40),
  @cantidad_producto INTEGER ,
  @precio_compra DECIMAL(12,2),
  @precio_venta DECIMAL(12,2) ,
  @descripcion NVARCHAR(200) ,
  @fecha_vencimiento DATETIME

  AS

  INSERT INTO [Producto] ([nombre_producto],[cantidad_producto],[precio_compra],[precio_venta],[descripcion],[fecha_vencimiento])
  VALUES (@nombre_producto,@cantidad_producto,@precio_compra,@precio_venta,@descripcion,@fecha_vencimiento)
  GO

 --PROCEDIMIENTO ALMACENADO INSERTAR CATEGORIA
  CREATE PROCEDURE InsertarCategoria
  @nombre_categoria NVARCHAR (15)

  AS

  INSERT INTO [Categoria] ([nombre_categoria])
  VALUES (@nombre_categoria)
  
  GO

--PROCEDIMIENTO ALMACENADO INSERTAR PRESENTACION 

   CREATE PROCEDURE InsertarPresentacion
   @nombre_presentacion NVARCHAR (8)

   AS

   INSERT INTO [Presentacion] ([nombre_presentacion])
   VALUES (@nombre_presentacion)
 
   GO
-----------------------------------------------------------------------------------------------------
--Procedimiento almacenado para buscar clientes
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


-----------------------------------------------------------------------------------------------------


   --procedimiento almacenado para consultar cliente

CREATE PROCEDURE ConsultarCliente
AS
BEGIN
  SELECT Cliente.IDCliente,nombre1,nombre2,apellido1,
  apellido2,telefono,Cliente.genero_cliente,direccion

  FROM Cliente inner join Persona on Cliente.IDCliente=Persona.IDPersona

END
GO

EXEC ConsultarCliente

--------------------------------------------------------------------------------------------------------

--procedimiento almacenado para Consultar un proveedor
CREATE PROCEDURE ConsultarProveedor
    @nombre_proveedor1 NVARCHAR(15) = NULL,
    @nombre_proveedor2 NVARCHAR(15) = NULL,
    @apellido_proveedor1 NVARCHAR(15) = NULL,
    @apellido_proveedor2 NVARCHAR(15) = NULL,
    @empresa_proveedor NVARCHAR(30) = NULL,
    @telefono_proveedor NVARCHAR(8) = NULL,
    @direccion_proveedor NVARCHAR(150) = NULL
AS
BEGIN
    SELECT *
    FROM Proveedor
    WHERE (nombre_proveedor1 = @nombre_proveedor1 OR @nombre_proveedor1 IS NULL)
        AND (nombre_proveedor2 = @nombre_proveedor2 OR @nombre_proveedor2 IS NULL)
        AND (apellido_proveedor1 = @apellido_proveedor1 OR @apellido_proveedor1 IS NULL)
        AND (apellido_proveedor2 = @apellido_proveedor2 OR @apellido_proveedor2 IS NULL)
        AND (empresa_proveedor = @empresa_proveedor OR @empresa_proveedor IS NULL)
        AND (telefono_proveedor = @telefono_proveedor OR @telefono_proveedor IS NULL)
        AND (direccion_proveedor = @direccion_proveedor OR @direccion_proveedor IS NULL);
END;


  GO

--procedimiento almacenado para consultar un producto
CREATE PROCEDURE ConsultarProducto
    @nombre_producto NVARCHAR(40) = NULL,
    @cantidad_producto INTEGER = NULL,
    @precio_compra DECIMAL(12,2) = NULL,
    @precio_venta DECIMAL(12,2) = NULL,
    @descripcion NVARCHAR(200) = NULL,
    @fecha_vencimiento DATETIME = NULL
AS
BEGIN
    SELECT *
    FROM Producto
    WHERE (nombre_producto = @nombre_producto OR @nombre_producto IS NULL)
        AND (cantidad_producto = @cantidad_producto OR @cantidad_producto IS NULL)
        AND (precio_compra = @precio_compra OR @precio_compra IS NULL)
        AND (precio_venta = @precio_venta OR @precio_venta IS NULL)
        AND (descripcion = @descripcion OR @descripcion IS NULL)
        AND (fecha_vencimiento = @fecha_vencimiento OR @fecha_vencimiento IS NULL);
END;


  GO

   --procedimiento almacenado para consultar una categoria
CREATE PROCEDURE ConsultarCategoria
    @nombre_categoria NVARCHAR(15)
AS
BEGIN
    SELECT *
    FROM Categoria
    WHERE nombre_categoria = @nombre_categoria;
END;


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

EXEC ActualizarPersonaCliente 1,'Cristhian','Cesar','Vargas','Martinez','57867406','M','juigalpa';
GO
SELECT * FROM Cliente
SELECT * FROM Persona
GO



 --Procedimiento almacenado para actualizar proveedor

 CREATE PROCEDURE ActualizarProveedor
    @IDProveedor INTEGER,
    @nombre_proveedor1 NVARCHAR(15),
    @nombre_proveedor2 NVARCHAR(15),
    @apellido_proveedor1 NVARCHAR(15),
    @apellido_proveedor2 NVARCHAR(15),
    @empresa_proveedor NVARCHAR(30),
    @telefono_proveedor NVARCHAR(9),
    @direccion_proveedor NVARCHAR(150)

AS
BEGIN
    UPDATE Proveedor
    SET nombre_proveedor1 = @nombre_proveedor1,
        nombre_proveedor2 = @nombre_proveedor2,
        apellido_proveedor1 = @apellido_proveedor1,
        apellido_proveedor2 = @apellido_proveedor2,
        empresa_proveedor = @empresa_proveedor,
        telefono_proveedor = @telefono_proveedor,
        direccion_proveedor = @direccion_proveedor
    WHERE IDProveedor = @IDProveedor;
END;

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
CREATE PROCEDURE EliminarProveedor
  @IDProveedor INTEGER

  AS

  DELETE Proveedor
  WHERE IDProveedor = @IDProveedor

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


