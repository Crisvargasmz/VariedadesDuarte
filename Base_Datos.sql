USE master
CREATE DATABASE VariedadesDuarte
USE VariedadesDuarte
CREATE TABLE [Proveedor] (
  [IDProveedor] INTEGER IDENTITY (1,1)PRIMARY KEY,
  [nombre_proveedor1] nvarchar(15) NOT NULL,
  [nombre_proveedor2] nvarchar(15)NULL,
  [apellido_proveedor1] nvarchar(15)NOT NULL,
  [apellido_proveedor2] nvarchar(15)NULL,
  [empresa_proveedor] nvarchar(30)NOT NULL,
  [telefono_proveedor] nvarchar(8)NOT NULL,
  [direccion_proveedor] nvarchar (100) NOT NULL
)
GO

CREATE TABLE [Cliente] (
  [IDCliente] INTEGER IDENTITY(1,1) PRIMARY KEY,
  [nombre_cliente1] nvarchar(15)NOT NULL,
  [nombre_cliente2] nvarchar(15)NULL,
  [apellido_cliente1] nvarchar(15)NOT NULL,
  [apellido_cliente2] nvarchar(15)NULL,
  [telefono_cliente] nvarchar(8)NOT NULL,
  [sexo_cliente] char (1) NOT NULL,
  [direccion_cliente] nvarchar(100) NOT NULL
)
GO

CREATE TABLE [Venta] (
  [IDVenta] INTEGER IDENTITY(1,1) PRIMARY KEY,
  [fecha_venta] datetime,
 
)
GO

CREATE TABLE [Producto] (
  [IDProducto] INTEGER IDENTITY(1,1) PRIMARY KEY,
  [nombre_producto] nvarchar(40)NOT NULL,
  [cantidad_producto] integer NOT NULL,
  [precio_compra] decimal(12,2) NOT NULL,
  [precio_venta] decimal(12,2) NOT NULL,
  [descripcion] nvarchar(200) NOT NULL,
  [fecha_vencimiento] datetime,

)
GO

CREATE TABLE [Categoria] (
  [IDCategaria] INTEGER IDENTITY(1,1) PRIMARY KEY,
  [nombre_categoria] nvarchar(15) NOT NULL,
)
GO

CREATE TABLE [Compra] (
  [IDCompra] INTEGER IDENTITY(1,1) PRIMARY KEY,
  fecha_compra datetime,

)
GO

  ALTER TABLE dbo.Venta
ADD IDCliente INT NOT NULL
ALTER TABLE dbo.Venta
ADD CONSTRAINT FK_Clientes_Ventas
FOREIGN KEY (IDCliente)
REFERENCES dbo.Cliente(IDCliente)


ALTER TABLE dbo.Producto
ADD IDCategaria  INT NOT NULL
ALTER TABLE dbo.Producto
ADD CONSTRAINT FK_Categoria_Producto
FOREIGN KEY (IDCategaria)
REFERENCES dbo.Categoria(IDCategaria)

ALTER TABLE dbo.Compra
ADD IDProveedor  INT NOT NULL
ALTER TABLE dbo.Compra
ADD CONSTRAINT FK_Proveedor_Compra
FOREIGN KEY (IDProveedor)
REFERENCES dbo.Proveedor(IDProveedor)


CREATE TABLE [Detalle_Venta] (
  [ID_DVenta] INTEGER IDENTITY(1,1) PRIMARY KEY,
  cantidad_venta integer NOT NULL,
 
)
GO



CREATE TABLE [Detalle_Compra] (
  [ID_DCompra] INTEGER IDENTITY(1,1) PRIMARY KEY,
  cantidad_compra integer NOT NULL,

)
GO

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
ADD IDProveedor INT  NOT NULL
ALTER TABLE dbo.Detalle_Compra
ADD CONSTRAINT FK_Detalle_Compra_Pdor
FOREIGN KEY ( IDProveedor)
REFERENCES dbo.Proveedor( IDProveedor)



