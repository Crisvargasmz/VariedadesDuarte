USE master
CREATE DATABASE VariedadesDuarte
USE VariedadesDuarte
CREATE TABLE [Proveedor] (
  [IDProveedor] INTEGER IDENTITY (1,1)PRIMARY KEY,
  [nombre_proveedor1] NVARCHAR(15) NOT NULL,
  [nombre_proveedor2] NVARCHAR(15)NULL,
  [apellido_proveedor1] NVARCHAR(15)NOT NULL,
  [apellido_proveedor2] NVARCHAR(15)NULL,
  [empresa_proveedor] NVARCHAR(30)NOT NULL,
  [telefono_proveedor]NVARCHAR(8)NOT NULL,
  [direccion_proveedor] NVARCHAR (150) NOT NULL
)
GO

CREATE TABLE [Cliente] (
  [IDCliente] INTEGER IDENTITY(1,1) PRIMARY KEY,
  [nombre_cliente1] NVARCHAR(15)NOT NULL,
  [nombre_cliente2] NVARCHAR(15)NULL,
  [apellido_cliente1] NVARCHAR(15)NOT NULL,
  [apellido_cliente2] NVARCHAR(15)NULL,
  [telefono_cliente] NVARCHAR(8)NOT NULL,
  [genero_cliente] CHAR (1) NOT NULL,
  [direccion_cliente] NVARCHAR(150) NOT NULL
)
GO

CREATE TABLE [Venta] (
  [IDVenta] INTEGER IDENTITY(1,1) PRIMARY KEY,
  [fecha_venta] DATETIME,
 
)
GO

CREATE TABLE [Producto] (
  [IDProducto] INTEGER IDENTITY(1,1) PRIMARY KEY,
  [nombre_producto] NVARCHAR(40)NOT NULL,
  [cantidad_producto] INTEGER NOT NULL,
  [precio_compra] DECIMAL(12,2) NOT NULL,
  [precio_venta] DECIMAL(12,2) NOT NULL,
  [descripcion] NVARCHAR(200) NOT NULL,
  [fecha_vencimiento] DATETIME,

)
GO

CREATE TABLE [Categoria] (
  [IDCategoria] INTEGER IDENTITY(1,1) PRIMARY KEY,
  [nombre_categoria] NVARCHAR(15) NOT NULL,
)
GO

CREATE TABLE [Compra] (
  [IDCompra] INTEGER IDENTITY(1,1) PRIMARY KEY,
  fecha_compra DATETIME,

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

--ALTER TABLE dbo.Producto
--ADD IDPresentacion INT NOT NULL
--ALTER TABLE dbo.Producto
--ADD CONSTRAINT FK_UnidadMedida_Producto
--FOREIGN KEY (IDPresentacion)
--REFERENCES dbo.Presentacion(IDPresentacion)


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

--procedimiento almacenado para ingresar un cliente
CREATE PROCEDURE InsertarCliente
  @nombre_cliente1 nvarchar(15),
  @nombre_cliente2 nvarchar(15),
  @apellido_cliente1 nvarchar(15),
  @apellido_cliente2 nvarchar(15),
  @telefono_cliente nvarchar(8),
  @genero_cliente char (1) ,
  @direccion_cliente nvarchar(150) 

  AS
  INSERT INTO [Cliente] ([nombre_cliente1],[nombre_cliente2],[apellido_cliente1],[apellido_cliente2],[telefono_cliente],[genero_cliente],[direccion_cliente])
  VALUES (@nombre_cliente1, @nombre_cliente2,@apellido_cliente1,@apellido_cliente2,@telefono_cliente,@genero_cliente,@direccion_cliente)
  GO

  --procedimiento almacenado para ingresar un proveedor
CREATE PROCEDURE InsertarProveedor
  @nombre_proveedor1 NVARCHAR(15),
  @nombre_proveedor2 NVARCHAR(15),
  @apellido_proveedor1 NVARCHAR(15),
  @apellido_proveedor2 NVARCHAR(15),
  @empresa_proveedor NVARCHAR(30),
  @telefono_proveedor NVARCHAR(8),
  @direccion_proveedor NVARCHAR (150)

  AS

  INSERT INTO [Proveedor] ([nombre_proveedor1],[nombre_proveedor2],[apellido_proveedor1],[apellido_proveedor2],[empresa_proveedor],[telefono_proveedor],[direccion_proveedor])
  VALUES (@nombre_proveedor1, @nombre_proveedor2,@apellido_proveedor1,@apellido_proveedor2,@empresa_proveedor,@telefono_proveedor,@direccion_proveedor)
  GO

   --procedimiento almacenado para ingresar un producto
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

 --procedimiento almacenado para ingresar una categoria
  CREATE PROCEDURE InsertarCategoria
  @nombre_categoria NVARCHAR (15)

  AS

  INSERT INTO [Categoria] ([nombre_categoria])
  VALUES (@nombre_categoria)
  
  GO

   --procedimiento almacenado para ingresar una presentacion

   CREATE PROCEDURE InsertarPresentacion
   @nombre_presentacion NVARCHAR (8)

   AS

   INSERT INTO [Presentacion] ([nombre_presentacion])
   VALUES (@nombre_presentacion)
 
   GO
-----------------------------------------------------------------------------------------------------

   --procedimiento almacenado para consultar cliente

CREATE PROCEDURE ConsultarCliente
    @nombre_cliente1 NVARCHAR(15) = NULL,
    @nombre_cliente2 NVARCHAR(15) = NULL,
    @apellido_cliente1 NVARCHAR(15) = NULL,
    @apellido_cliente2 NVARCHAR(15) = NULL,
    @telefono_cliente NVARCHAR(8) = NULL,
    @genero_cliente CHAR(1) = NULL,
    @direccion_cliente NVARCHAR(150) = NULL
AS
BEGIN
    SELECT *
    FROM Cliente
    WHERE (nombre_cliente1 = @nombre_cliente1 OR @nombre_cliente1 IS NULL)
        AND (nombre_cliente2 = @nombre_cliente2 OR @nombre_cliente2 IS NULL)
        AND (apellido_cliente1 = @apellido_cliente1 OR @apellido_cliente1 IS NULL)
        AND (apellido_cliente2 = @apellido_cliente2 OR @apellido_cliente2 IS NULL)
        AND (telefono_cliente = @telefono_cliente OR @telefono_cliente IS NULL)
        AND (genero_cliente = @genero_cliente OR @genero_cliente IS NULL)
        AND (direccion_cliente = @direccion_cliente OR @direccion_cliente IS NULL);
END;


GO

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

 CREATE PROCEDURE ActualizarCliente
    @IDCliente INTEGER,
    @nombre_cliente1 NVARCHAR(15),
    @nombre_cliente2 NVARCHAR(15),
    @apellido_cliente1 NVARCHAR(15),
    @apellido_cliente2 NVARCHAR(15),
    @telefono_cliente NVARCHAR(8),
    @genero_cliente CHAR(1),
    @direccion_cliente NVARCHAR(150)
AS
BEGIN
    UPDATE Cliente
    SET nombre_cliente1 = @nombre_cliente1,
        nombre_cliente2 = @nombre_cliente2,
        apellido_cliente1 = @apellido_cliente1,
        apellido_cliente2 = @apellido_cliente2,
        telefono_cliente = @telefono_cliente,
        genero_cliente = @genero_cliente,
        direccion_cliente = @direccion_cliente
    WHERE IDCliente = @IDCliente;
END;

GO

 --Procedimiento almacenado para actualizar proveedor

 CREATE PROCEDURE ActualizarProveedor
    @IDProveedor INTEGER,
    @nombre_proveedor1 NVARCHAR(15),
    @nombre_proveedor2 NVARCHAR(15),
    @apellido_proveedor1 NVARCHAR(15),
    @apellido_proveedor2 NVARCHAR(15),
    @empresa_proveedor NVARCHAR(30),
    @telefono_proveedor NVARCHAR(8),
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

   CREATE PROCEDURE EliminarCliente
  @IDCliente INTEGER

  AS

  DELETE Cliente
  WHERE IDCliente = @IDCliente

  GO

  --procedimiento almacenado para eliminar un proveedor
CREATE PROCEDURE EliminarProveedor
  @IDProveedor INTEGER

  AS

  DELETE Proveedor
  WHERE IDProveedor = @IDProveedor

  Go

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



