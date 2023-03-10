USE [master]
GO
/****** Object:  Database [ProSoft-Jun2022]    Script Date: 14-Jun-22 23:52:47 ******/
CREATE DATABASE [ProSoft-Jun2022]
GO
ALTER DATABASE [ProSoft-Jun2022] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [ProSoft-Jun2022] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [ProSoft-Jun2022] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [ProSoft-Jun2022] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [ProSoft-Jun2022] SET ARITHABORT OFF 
GO
ALTER DATABASE [ProSoft-Jun2022] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [ProSoft-Jun2022] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [ProSoft-Jun2022] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [ProSoft-Jun2022] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [ProSoft-Jun2022] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [ProSoft-Jun2022] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [ProSoft-Jun2022] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [ProSoft-Jun2022] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [ProSoft-Jun2022] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [ProSoft-Jun2022] SET  DISABLE_BROKER 
GO
ALTER DATABASE [ProSoft-Jun2022] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [ProSoft-Jun2022] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [ProSoft-Jun2022] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [ProSoft-Jun2022] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [ProSoft-Jun2022] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [ProSoft-Jun2022] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [ProSoft-Jun2022] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [ProSoft-Jun2022] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [ProSoft-Jun2022] SET  MULTI_USER 
GO
ALTER DATABASE [ProSoft-Jun2022] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [ProSoft-Jun2022] SET DB_CHAINING OFF 
GO
ALTER DATABASE [ProSoft-Jun2022] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [ProSoft-Jun2022] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [ProSoft-Jun2022] SET DELAYED_DURABILITY = DISABLED 
GO
ALTER DATABASE [ProSoft-Jun2022] SET QUERY_STORE = OFF
GO
USE [ProSoft-Jun2022]
GO
ALTER DATABASE SCOPED CONFIGURATION SET LEGACY_CARDINALITY_ESTIMATION = OFF;
GO
ALTER DATABASE SCOPED CONFIGURATION SET MAXDOP = 0;
GO
ALTER DATABASE SCOPED CONFIGURATION SET PARAMETER_SNIFFING = ON;
GO
ALTER DATABASE SCOPED CONFIGURATION SET QUERY_OPTIMIZER_HOTFIXES = OFF;
GO
USE [ProSoft-Jun2022]
GO
/****** Object:  Table [dbo].[Kategorija]    Script Date: 14-Jun-22 23:52:47 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Kategorija](
	[KategorijaID] [int] IDENTITY(1,1) NOT NULL,
	[Naziv] [nvarchar](255) NULL,
	[NadredjenaKategorijaID] [int] NULL,
 CONSTRAINT [Kategorija$PrimaryKey] PRIMARY KEY CLUSTERED 
(
	[KategorijaID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Rad]    Script Date: 14-Jun-22 23:52:47 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Rad](
	[RadID] [int] IDENTITY(1,1) NOT NULL,
	[Naziv] [nvarchar](255) NULL,
	[Autor1] [nvarchar](255) NULL,
	[Autor2] [nvarchar](255) NULL,
	[Autor3] [nvarchar](255) NULL,
 CONSTRAINT [Rad$PrimaryKey] PRIMARY KEY CLUSTERED 
(
	[RadID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[RasporedSekcije]    Script Date: 14-Jun-22 23:52:47 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[RasporedSekcije](
	[SekcijaID] [int] NOT NULL,
	[RB] [int] NOT NULL,
	[Status] [nvarchar](255) NULL,
	[RadID] [int] NULL,
 CONSTRAINT [RasporedSekcije$PrimaryKey] PRIMARY KEY CLUSTERED 
(
	[SekcijaID] ASC,
	[RB] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Sekcija]    Script Date: 14-Jun-22 23:52:47 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Sekcija](
	[SekcijaID] [int] IDENTITY(1,1) NOT NULL,
	[Naziv] [nvarchar](255) NULL,
	[DatumVremeOd] [datetime] NULL,
	[DatumVremeDo] [datetime] NULL,
	[Sala] [nvarchar](255) NULL,
	[Moderator] [nvarchar](255) NULL,
	[KategorijaID] [int] NULL,
 CONSTRAINT [Sekcija$PrimaryKey] PRIMARY KEY CLUSTERED 
(
	[SekcijaID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET IDENTITY_INSERT [dbo].[Kategorija] ON 

INSERT [dbo].[Kategorija] ([KategorijaID], [Naziv], [NadredjenaKategorijaID]) VALUES (1, N'ISiT', NULL)
INSERT [dbo].[Kategorija] ([KategorijaID], [Naziv], [NadredjenaKategorijaID]) VALUES (2, N'Informacioni sistemi', 1)
INSERT [dbo].[Kategorija] ([KategorijaID], [Naziv], [NadredjenaKategorijaID]) VALUES (3, N'Informacione tehnologije', 1)
INSERT [dbo].[Kategorija] ([KategorijaID], [Naziv], [NadredjenaKategorijaID]) VALUES (4, N'Elektronsko poslovanje', 1)
INSERT [dbo].[Kategorija] ([KategorijaID], [Naziv], [NadredjenaKategorijaID]) VALUES (5, N'Softversko inzenjerstvo', 1)
INSERT [dbo].[Kategorija] ([KategorijaID], [Naziv], [NadredjenaKategorijaID]) VALUES (6, N'Menadzment i organizacija', NULL)
INSERT [dbo].[Kategorija] ([KategorijaID], [Naziv], [NadredjenaKategorijaID]) VALUES (7, N'Menadzment', 6)
INSERT [dbo].[Kategorija] ([KategorijaID], [Naziv], [NadredjenaKategorijaID]) VALUES (8, N'Operacioni menadzment', 6)
INSERT [dbo].[Kategorija] ([KategorijaID], [Naziv], [NadredjenaKategorijaID]) VALUES (9, N'Menadzment kvaliteta i standardizacija', 6)
INSERT [dbo].[Kategorija] ([KategorijaID], [Naziv], [NadredjenaKategorijaID]) VALUES (10, N'Upravljanje sistemima', 6)
INSERT [dbo].[Kategorija] ([KategorijaID], [Naziv], [NadredjenaKategorijaID]) VALUES (11, N'Matematika', NULL)
INSERT [dbo].[Kategorija] ([KategorijaID], [Naziv], [NadredjenaKategorijaID]) VALUES (12, N'Matematicke metode u menadzmentu', 11)
INSERT [dbo].[Kategorija] ([KategorijaID], [Naziv], [NadredjenaKategorijaID]) VALUES (13, N'Matematicke metode u informatici', 11)
INSERT [dbo].[Kategorija] ([KategorijaID], [Naziv], [NadredjenaKategorijaID]) VALUES (14, N'Numericka analiza', 11)
INSERT [dbo].[Kategorija] ([KategorijaID], [Naziv], [NadredjenaKategorijaID]) VALUES (15, N'Diskretne matematicke strukture', 11)
INSERT [dbo].[Kategorija] ([KategorijaID], [Naziv], [NadredjenaKategorijaID]) VALUES (16, N'Algebra', 11)
INSERT [dbo].[Kategorija] ([KategorijaID], [Naziv], [NadredjenaKategorijaID]) VALUES (18, N'Geometrija', 11)
INSERT [dbo].[Kategorija] ([KategorijaID], [Naziv], [NadredjenaKategorijaID]) VALUES (19, N'Kategorija 4', NULL)
INSERT [dbo].[Kategorija] ([KategorijaID], [Naziv], [NadredjenaKategorijaID]) VALUES (20, N'Kategorija 4.1', 19)
INSERT [dbo].[Kategorija] ([KategorijaID], [Naziv], [NadredjenaKategorijaID]) VALUES (21, N'Kategorija 4.2', 19)
INSERT [dbo].[Kategorija] ([KategorijaID], [Naziv], [NadredjenaKategorijaID]) VALUES (22, N'Kategorija 4.3', 19)
SET IDENTITY_INSERT [dbo].[Kategorija] OFF
GO
SET IDENTITY_INSERT [dbo].[Rad] ON 

INSERT [dbo].[Rad] ([RadID], [Naziv], [Autor1], [Autor2], [Autor3]) VALUES (1, N'Rad 1', N'Ana Anic', NULL, NULL)
INSERT [dbo].[Rad] ([RadID], [Naziv], [Autor1], [Autor2], [Autor3]) VALUES (2, N'Rad 2', N'Petar Petrovic', N'Dragan Draganic', N'Ivan Ivanic')
INSERT [dbo].[Rad] ([RadID], [Naziv], [Autor1], [Autor2], [Autor3]) VALUES (3, N'Rad 3', N'Jovana Jovic', N'Ivan Ivkovic', NULL)
INSERT [dbo].[Rad] ([RadID], [Naziv], [Autor1], [Autor2], [Autor3]) VALUES (4, N'Rad 4', N'Pavle Pavlovic', NULL, NULL)
INSERT [dbo].[Rad] ([RadID], [Naziv], [Autor1], [Autor2], [Autor3]) VALUES (5, N'Rad 5', N'Dusan Dusanic', N'Jelena Jovic', N'Marko Markovic')
INSERT [dbo].[Rad] ([RadID], [Naziv], [Autor1], [Autor2], [Autor3]) VALUES (6, N'Rad 6', N'Marija Mitrovic', N'Slavisa Slavic', NULL)
INSERT [dbo].[Rad] ([RadID], [Naziv], [Autor1], [Autor2], [Autor3]) VALUES (7, N'Rad 7', N'Jovan Pavlovic', N'Ana Markovic', N'Mirko Mirkovic')
INSERT [dbo].[Rad] ([RadID], [Naziv], [Autor1], [Autor2], [Autor3]) VALUES (8, N'Rad 8', N'Nenad Nenadic', N'Marija Markovic', N'Ivan Ivic')
INSERT [dbo].[Rad] ([RadID], [Naziv], [Autor1], [Autor2], [Autor3]) VALUES (9, N'Rad 9', N'Dragana Panic', NULL, NULL)
INSERT [dbo].[Rad] ([RadID], [Naziv], [Autor1], [Autor2], [Autor3]) VALUES (10, N'Rad 10', N'Dejana Dejanic', N'Sava Savic', N'Vladimir Vladimirovic')
SET IDENTITY_INSERT [dbo].[Rad] OFF
GO
/****** Object:  Index [Kategorija$KategorijaID]    Script Date: 14-Jun-22 23:52:47 ******/
CREATE NONCLUSTERED INDEX [Kategorija$KategorijaID] ON [dbo].[Kategorija]
(
	[KategorijaID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, DROP_EXISTING = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
/****** Object:  Index [Kategorija$NadredjenaKategorijaID]    Script Date: 14-Jun-22 23:52:47 ******/
CREATE NONCLUSTERED INDEX [Kategorija$NadredjenaKategorijaID] ON [dbo].[Kategorija]
(
	[NadredjenaKategorijaID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, DROP_EXISTING = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
/****** Object:  Index [Rad$RadID]    Script Date: 14-Jun-22 23:52:47 ******/
CREATE NONCLUSTERED INDEX [Rad$RadID] ON [dbo].[Rad]
(
	[RadID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, DROP_EXISTING = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
/****** Object:  Index [RasporedSekcije$RadID]    Script Date: 14-Jun-22 23:52:47 ******/
CREATE NONCLUSTERED INDEX [RasporedSekcije$RadID] ON [dbo].[RasporedSekcije]
(
	[RadID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, DROP_EXISTING = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
/****** Object:  Index [RasporedSekcije$SekcijaID]    Script Date: 14-Jun-22 23:52:47 ******/
CREATE NONCLUSTERED INDEX [RasporedSekcije$SekcijaID] ON [dbo].[RasporedSekcije]
(
	[SekcijaID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, DROP_EXISTING = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
/****** Object:  Index [Sekcija$KategorijaID1]    Script Date: 14-Jun-22 23:52:47 ******/
CREATE NONCLUSTERED INDEX [Sekcija$KategorijaID1] ON [dbo].[Sekcija]
(
	[KategorijaID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, DROP_EXISTING = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
/****** Object:  Index [Sekcija$SekcijaID]    Script Date: 14-Jun-22 23:52:47 ******/
CREATE NONCLUSTERED INDEX [Sekcija$SekcijaID] ON [dbo].[Sekcija]
(
	[SekcijaID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, DROP_EXISTING = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
ALTER TABLE [dbo].[Kategorija] ADD  DEFAULT ((0)) FOR [NadredjenaKategorijaID]
GO
ALTER TABLE [dbo].[RasporedSekcije] ADD  DEFAULT ((0)) FOR [SekcijaID]
GO
ALTER TABLE [dbo].[RasporedSekcije] ADD  DEFAULT ((0)) FOR [RB]
GO
ALTER TABLE [dbo].[RasporedSekcije] ADD  DEFAULT ((0)) FOR [RadID]
GO
ALTER TABLE [dbo].[Sekcija] ADD  CONSTRAINT [DF__Sekcija__Kategor__30F848ED]  DEFAULT ((0)) FOR [KategorijaID]
GO
ALTER TABLE [dbo].[Kategorija]  WITH NOCHECK ADD  CONSTRAINT [Kategorija$KategorijaKategorija] FOREIGN KEY([NadredjenaKategorijaID])
REFERENCES [dbo].[Kategorija] ([KategorijaID])
GO
ALTER TABLE [dbo].[Kategorija] CHECK CONSTRAINT [Kategorija$KategorijaKategorija]
GO
ALTER TABLE [dbo].[RasporedSekcije]  WITH CHECK ADD  CONSTRAINT [RasporedSekcije$RadRasporedSekcije] FOREIGN KEY([RadID])
REFERENCES [dbo].[Rad] ([RadID])
GO
ALTER TABLE [dbo].[RasporedSekcije] CHECK CONSTRAINT [RasporedSekcije$RadRasporedSekcije]
GO
ALTER TABLE [dbo].[RasporedSekcije]  WITH CHECK ADD  CONSTRAINT [RasporedSekcije$SekcijaRasporedSekcije] FOREIGN KEY([SekcijaID])
REFERENCES [dbo].[Sekcija] ([SekcijaID])
GO
ALTER TABLE [dbo].[RasporedSekcije] CHECK CONSTRAINT [RasporedSekcije$SekcijaRasporedSekcije]
GO
ALTER TABLE [dbo].[Sekcija]  WITH CHECK ADD  CONSTRAINT [Sekcija$KategorijaSekcija] FOREIGN KEY([KategorijaID])
REFERENCES [dbo].[Kategorija] ([KategorijaID])
GO
ALTER TABLE [dbo].[Sekcija] CHECK CONSTRAINT [Sekcija$KategorijaSekcija]
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Jun2022.[Kategorija].[KategorijaID]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'Kategorija', @level2type=N'COLUMN',@level2name=N'KategorijaID'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Jun2022.[Kategorija].[Naziv]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'Kategorija', @level2type=N'COLUMN',@level2name=N'Naziv'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Jun2022.[Kategorija].[NadredjenaKategorijaID]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'Kategorija', @level2type=N'COLUMN',@level2name=N'NadredjenaKategorijaID'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Jun2022.[Kategorija].[PrimaryKey]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'Kategorija', @level2type=N'CONSTRAINT',@level2name=N'Kategorija$PrimaryKey'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Jun2022.[Kategorija].[KategorijaID]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'Kategorija', @level2type=N'INDEX',@level2name=N'Kategorija$KategorijaID'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Jun2022.[Kategorija].[NadredjenaKategorijaID]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'Kategorija', @level2type=N'INDEX',@level2name=N'Kategorija$NadredjenaKategorijaID'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Jun2022.[Kategorija]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'Kategorija'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Jun2022.[Kategorija].[KategorijaKategorija]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'Kategorija', @level2type=N'CONSTRAINT',@level2name=N'Kategorija$KategorijaKategorija'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Jun2022.[Rad].[RadID]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'Rad', @level2type=N'COLUMN',@level2name=N'RadID'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Jun2022.[Rad].[Naziv]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'Rad', @level2type=N'COLUMN',@level2name=N'Naziv'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Jun2022.[Rad].[Autor1]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'Rad', @level2type=N'COLUMN',@level2name=N'Autor1'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Jun2022.[Rad].[Autor2]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'Rad', @level2type=N'COLUMN',@level2name=N'Autor2'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Jun2022.[Rad].[Autor3]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'Rad', @level2type=N'COLUMN',@level2name=N'Autor3'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Jun2022.[Rad].[PrimaryKey]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'Rad', @level2type=N'CONSTRAINT',@level2name=N'Rad$PrimaryKey'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Jun2022.[Rad].[RadID]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'Rad', @level2type=N'INDEX',@level2name=N'Rad$RadID'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Jun2022.[Rad]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'Rad'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Jun2022.[RasporedSekcije].[SekcijaID]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'RasporedSekcije', @level2type=N'COLUMN',@level2name=N'SekcijaID'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Jun2022.[RasporedSekcije].[RB]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'RasporedSekcije', @level2type=N'COLUMN',@level2name=N'RB'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Jun2022.[RasporedSekcije].[Status]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'RasporedSekcije', @level2type=N'COLUMN',@level2name=N'Status'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Jun2022.[RasporedSekcije].[RadID]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'RasporedSekcije', @level2type=N'COLUMN',@level2name=N'RadID'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Jun2022.[RasporedSekcije].[PrimaryKey]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'RasporedSekcije', @level2type=N'CONSTRAINT',@level2name=N'RasporedSekcije$PrimaryKey'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Jun2022.[RasporedSekcije].[RadID]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'RasporedSekcije', @level2type=N'INDEX',@level2name=N'RasporedSekcije$RadID'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Jun2022.[RasporedSekcije].[SekcijaID]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'RasporedSekcije', @level2type=N'INDEX',@level2name=N'RasporedSekcije$SekcijaID'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Jun2022.[RasporedSekcije]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'RasporedSekcije'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Jun2022.[RasporedSekcije].[RadRasporedSekcije]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'RasporedSekcije', @level2type=N'CONSTRAINT',@level2name=N'RasporedSekcije$RadRasporedSekcije'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Jun2022.[RasporedSekcije].[SekcijaRasporedSekcije]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'RasporedSekcije', @level2type=N'CONSTRAINT',@level2name=N'RasporedSekcije$SekcijaRasporedSekcije'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Jun2022.[Sekcija].[SekcijaID]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'Sekcija', @level2type=N'COLUMN',@level2name=N'SekcijaID'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Jun2022.[Sekcija].[Naziv]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'Sekcija', @level2type=N'COLUMN',@level2name=N'Naziv'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Jun2022.[Sekcija].[DatumVremeOd]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'Sekcija', @level2type=N'COLUMN',@level2name=N'DatumVremeOd'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Jun2022.[Sekcija].[DatumVremeDo]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'Sekcija', @level2type=N'COLUMN',@level2name=N'DatumVremeDo'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Jun2022.[Sekcija].[Sala]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'Sekcija', @level2type=N'COLUMN',@level2name=N'Sala'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Jun2022.[Sekcija].[Moderator]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'Sekcija', @level2type=N'COLUMN',@level2name=N'Moderator'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Jun2022.[Sekcija].[KategorijaID]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'Sekcija', @level2type=N'COLUMN',@level2name=N'KategorijaID'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Jun2022.[Sekcija].[PrimaryKey]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'Sekcija', @level2type=N'CONSTRAINT',@level2name=N'Sekcija$PrimaryKey'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Jun2022.[Sekcija].[KategorijaID1]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'Sekcija', @level2type=N'INDEX',@level2name=N'Sekcija$KategorijaID1'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Jun2022.[Sekcija].[SekcijaID]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'Sekcija', @level2type=N'INDEX',@level2name=N'Sekcija$SekcijaID'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Jun2022.[Sekcija]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'Sekcija'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Jun2022.[Sekcija].[KategorijaSekcija]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'Sekcija', @level2type=N'CONSTRAINT',@level2name=N'Sekcija$KategorijaSekcija'
GO
USE [master]
GO
ALTER DATABASE [ProSoft-Jun2022] SET  READ_WRITE 
GO
