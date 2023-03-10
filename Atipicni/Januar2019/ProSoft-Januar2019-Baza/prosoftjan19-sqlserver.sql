USE master
IF EXISTS(select * from sys.databases where name='Jan2019Rok')
DROP DATABASE [Jan2019Rok];
GO
CREATE DATABASE [Jan2019Rok];
GO
ALTER AUTHORIZATION ON DATABASE::[Jan2019Rok] TO sa
GO
USE [Jan2019Rok]
GO
/****** Object:  Table [dbo].[Kviz]    Script Date: 16-Jan-19 10:47:41 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Kviz](
	[KvizID] [int] NOT NULL,
	[Naziv] [nvarchar](255) NULL,
	[DatumVremePocetka] [datetime] NULL,
	[DatumVremeKraja] [datetime] NULL,
	[Pobednik] [nvarchar](255) NULL,
 CONSTRAINT [PK_Kviz] PRIMARY KEY CLUSTERED 
(
	[KvizID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Pitanje]    Script Date: 16-Jan-19 10:47:41 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Pitanje](
	[PitanjeID] [int] NOT NULL,
	[Pitanje] [nvarchar](255) NULL,
	[TacanOdgovor] [nvarchar](255) NULL,
	[BrojPoena] [int] NULL,
	[KvizID] [int] NULL,
 CONSTRAINT [PK_Pitanje] PRIMARY KEY CLUSTERED 
(
	[PitanjeID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
INSERT [dbo].[Kviz] ([KvizID], [Naziv], [DatumVremePocetka], [DatumVremeKraja], [Pobednik]) VALUES (1, N'Kviz1', NULL, NULL, NULL)
INSERT [dbo].[Kviz] ([KvizID], [Naziv], [DatumVremePocetka], [DatumVremeKraja], [Pobednik]) VALUES (2, N'Kviz2', NULL, NULL, NULL)
INSERT [dbo].[Kviz] ([KvizID], [Naziv], [DatumVremePocetka], [DatumVremeKraja], [Pobednik]) VALUES (3, N'Kviz3', NULL, NULL, NULL)
INSERT [dbo].[Kviz] ([KvizID], [Naziv], [DatumVremePocetka], [DatumVremeKraja], [Pobednik]) VALUES (4, N'Kviz4', NULL, NULL, NULL)
INSERT [dbo].[Pitanje] ([PitanjeID], [Pitanje], [TacanOdgovor], [BrojPoena], [KvizID]) VALUES (1, N'Pitanje kviz1p1?', N'k1p1', 5, 1)
INSERT [dbo].[Pitanje] ([PitanjeID], [Pitanje], [TacanOdgovor], [BrojPoena], [KvizID]) VALUES (2, N'Pitanje kviz1p2?', N'k1p2', 4, 1)
INSERT [dbo].[Pitanje] ([PitanjeID], [Pitanje], [TacanOdgovor], [BrojPoena], [KvizID]) VALUES (3, N'Pitanje kviz1p3?', N'k1p3', 5, 1)
INSERT [dbo].[Pitanje] ([PitanjeID], [Pitanje], [TacanOdgovor], [BrojPoena], [KvizID]) VALUES (4, N'Pitanje kviz1p4?', N'k1p4', 6, 1)
INSERT [dbo].[Pitanje] ([PitanjeID], [Pitanje], [TacanOdgovor], [BrojPoena], [KvizID]) VALUES (5, N'Pitanje kviz1p5?', N'k1p5', 5, 1)
INSERT [dbo].[Pitanje] ([PitanjeID], [Pitanje], [TacanOdgovor], [BrojPoena], [KvizID]) VALUES (6, N'Pitanje kviz1p6?', N'k1p6', 5, 1)
INSERT [dbo].[Pitanje] ([PitanjeID], [Pitanje], [TacanOdgovor], [BrojPoena], [KvizID]) VALUES (7, N'Pitanje kviz1p7?', N'k1p7', 5, 1)
INSERT [dbo].[Pitanje] ([PitanjeID], [Pitanje], [TacanOdgovor], [BrojPoena], [KvizID]) VALUES (8, N'Pitanje kviz1p8?', N'k1p8', 5, 1)
INSERT [dbo].[Pitanje] ([PitanjeID], [Pitanje], [TacanOdgovor], [BrojPoena], [KvizID]) VALUES (9, N'Pitanje kviz1p9?', N'k1p9', 5, 1)
INSERT [dbo].[Pitanje] ([PitanjeID], [Pitanje], [TacanOdgovor], [BrojPoena], [KvizID]) VALUES (10, N'Pitanje kviz1p10?', N'k1p10', 5, 1)
INSERT [dbo].[Pitanje] ([PitanjeID], [Pitanje], [TacanOdgovor], [BrojPoena], [KvizID]) VALUES (11, N'Pitanje kviz2p1?', N'k2p1', 5, 2)
INSERT [dbo].[Pitanje] ([PitanjeID], [Pitanje], [TacanOdgovor], [BrojPoena], [KvizID]) VALUES (12, N'Pitanje kviz2p2?', N'k2p2', 4, 2)
INSERT [dbo].[Pitanje] ([PitanjeID], [Pitanje], [TacanOdgovor], [BrojPoena], [KvizID]) VALUES (13, N'Pitanje kviz2p3?', N'k2p3', 5, 2)
INSERT [dbo].[Pitanje] ([PitanjeID], [Pitanje], [TacanOdgovor], [BrojPoena], [KvizID]) VALUES (14, N'Pitanje kviz2p4?', N'k2p4', 6, 2)
INSERT [dbo].[Pitanje] ([PitanjeID], [Pitanje], [TacanOdgovor], [BrojPoena], [KvizID]) VALUES (15, N'Pitanje kviz2p5?', N'k2p5', 5, 2)
INSERT [dbo].[Pitanje] ([PitanjeID], [Pitanje], [TacanOdgovor], [BrojPoena], [KvizID]) VALUES (16, N'Pitanje kviz2p6?', N'k2p6', 5, 2)
INSERT [dbo].[Pitanje] ([PitanjeID], [Pitanje], [TacanOdgovor], [BrojPoena], [KvizID]) VALUES (17, N'Pitanje kviz2p7?', N'k2p7', 5, 2)
INSERT [dbo].[Pitanje] ([PitanjeID], [Pitanje], [TacanOdgovor], [BrojPoena], [KvizID]) VALUES (18, N'Pitanje kviz2p8?', N'k2p8', 5, 2)
INSERT [dbo].[Pitanje] ([PitanjeID], [Pitanje], [TacanOdgovor], [BrojPoena], [KvizID]) VALUES (19, N'Pitanje kviz2p9?', N'k2p9', 5, 2)
INSERT [dbo].[Pitanje] ([PitanjeID], [Pitanje], [TacanOdgovor], [BrojPoena], [KvizID]) VALUES (20, N'Pitanje kviz2p10?', N'k2p10', 5, 2)
INSERT [dbo].[Pitanje] ([PitanjeID], [Pitanje], [TacanOdgovor], [BrojPoena], [KvizID]) VALUES (21, N'Pitanje kviz3p1?', N'k3p1', 5, 3)
INSERT [dbo].[Pitanje] ([PitanjeID], [Pitanje], [TacanOdgovor], [BrojPoena], [KvizID]) VALUES (22, N'Pitanje kviz3p2?', N'k3p2', 5, 3)
INSERT [dbo].[Pitanje] ([PitanjeID], [Pitanje], [TacanOdgovor], [BrojPoena], [KvizID]) VALUES (23, N'Pitanje kviz3p3?', N'k3p3', 4, 3)
INSERT [dbo].[Pitanje] ([PitanjeID], [Pitanje], [TacanOdgovor], [BrojPoena], [KvizID]) VALUES (24, N'Pitanje kviz3p4?', N'k3p4', 5, 3)
INSERT [dbo].[Pitanje] ([PitanjeID], [Pitanje], [TacanOdgovor], [BrojPoena], [KvizID]) VALUES (25, N'Pitanje kviz3p5?', N'k3p5', 7, 3)
INSERT [dbo].[Pitanje] ([PitanjeID], [Pitanje], [TacanOdgovor], [BrojPoena], [KvizID]) VALUES (26, N'Pitanje kviz3p6?', N'k3p6', 5, 3)
INSERT [dbo].[Pitanje] ([PitanjeID], [Pitanje], [TacanOdgovor], [BrojPoena], [KvizID]) VALUES (27, N'Pitanje kviz3p7?', N'k3p7', 4, 3)
INSERT [dbo].[Pitanje] ([PitanjeID], [Pitanje], [TacanOdgovor], [BrojPoena], [KvizID]) VALUES (28, N'Pitanje kviz3p8?', N'k3p8', 6, 3)
INSERT [dbo].[Pitanje] ([PitanjeID], [Pitanje], [TacanOdgovor], [BrojPoena], [KvizID]) VALUES (29, N'Pitanje kviz3p9?', N'k3p9', 7, 3)
INSERT [dbo].[Pitanje] ([PitanjeID], [Pitanje], [TacanOdgovor], [BrojPoena], [KvizID]) VALUES (30, N'Pitanje kviz3p10?', N'k3p10', 5, 3)
INSERT [dbo].[Pitanje] ([PitanjeID], [Pitanje], [TacanOdgovor], [BrojPoena], [KvizID]) VALUES (31, N'Pitanje kviz4p1?', N'k4p1', 5, 4)
INSERT [dbo].[Pitanje] ([PitanjeID], [Pitanje], [TacanOdgovor], [BrojPoena], [KvizID]) VALUES (32, N'Pitanje kviz4p2?', N'k4p2', 4, 4)
INSERT [dbo].[Pitanje] ([PitanjeID], [Pitanje], [TacanOdgovor], [BrojPoena], [KvizID]) VALUES (33, N'Pitanje kviz4p3?', N'k4p3', 6, 4)
INSERT [dbo].[Pitanje] ([PitanjeID], [Pitanje], [TacanOdgovor], [BrojPoena], [KvizID]) VALUES (34, N'Pitanje kviz4p4?', N'k4p4', 3, 4)
INSERT [dbo].[Pitanje] ([PitanjeID], [Pitanje], [TacanOdgovor], [BrojPoena], [KvizID]) VALUES (35, N'Pitanje kviz4p5?', N'k4p5', 5, 4)
INSERT [dbo].[Pitanje] ([PitanjeID], [Pitanje], [TacanOdgovor], [BrojPoena], [KvizID]) VALUES (36, N'Pitanje kviz4p6?', N'k4p6', 4, 4)
INSERT [dbo].[Pitanje] ([PitanjeID], [Pitanje], [TacanOdgovor], [BrojPoena], [KvizID]) VALUES (37, N'Pitanje kviz4p7?', N'k4p7', 7, 4)
INSERT [dbo].[Pitanje] ([PitanjeID], [Pitanje], [TacanOdgovor], [BrojPoena], [KvizID]) VALUES (38, N'Pitanje kviz4p8?', N'k4p8', 8, 4)
INSERT [dbo].[Pitanje] ([PitanjeID], [Pitanje], [TacanOdgovor], [BrojPoena], [KvizID]) VALUES (39, N'Pitanje kviz4p9?', N'k4p9', 5, 4)
INSERT [dbo].[Pitanje] ([PitanjeID], [Pitanje], [TacanOdgovor], [BrojPoena], [KvizID]) VALUES (40, N'Pitanje kviz4p10?', N'k4p10', 4, 4)
ALTER TABLE [dbo].[Pitanje]  WITH CHECK ADD  CONSTRAINT [FK_Pitanje_Kviz] FOREIGN KEY([KvizID])
REFERENCES [dbo].[Kviz] ([KvizID])
GO
ALTER TABLE [dbo].[Pitanje] CHECK CONSTRAINT [FK_Pitanje_Kviz]
GO
USE [master]
GO
ALTER DATABASE [Jan2019Rok] SET  READ_WRITE 
GO
