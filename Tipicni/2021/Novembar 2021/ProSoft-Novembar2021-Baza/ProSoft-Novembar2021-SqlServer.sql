USE [master]
GO
/****** Object:  Database [ProSoft-Novembar2021]    Script Date: 16-Nov-21 0:01:28 ******/
CREATE DATABASE [ProSoft-Novembar2021]
GO
ALTER DATABASE [ProSoft-Novembar2021] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [ProSoft-Novembar2021] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [ProSoft-Novembar2021] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [ProSoft-Novembar2021] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [ProSoft-Novembar2021] SET ARITHABORT OFF 
GO
ALTER DATABASE [ProSoft-Novembar2021] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [ProSoft-Novembar2021] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [ProSoft-Novembar2021] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [ProSoft-Novembar2021] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [ProSoft-Novembar2021] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [ProSoft-Novembar2021] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [ProSoft-Novembar2021] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [ProSoft-Novembar2021] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [ProSoft-Novembar2021] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [ProSoft-Novembar2021] SET  DISABLE_BROKER 
GO
ALTER DATABASE [ProSoft-Novembar2021] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [ProSoft-Novembar2021] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [ProSoft-Novembar2021] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [ProSoft-Novembar2021] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [ProSoft-Novembar2021] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [ProSoft-Novembar2021] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [ProSoft-Novembar2021] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [ProSoft-Novembar2021] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [ProSoft-Novembar2021] SET  MULTI_USER 
GO
ALTER DATABASE [ProSoft-Novembar2021] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [ProSoft-Novembar2021] SET DB_CHAINING OFF 
GO
ALTER DATABASE [ProSoft-Novembar2021] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [ProSoft-Novembar2021] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [ProSoft-Novembar2021] SET DELAYED_DURABILITY = DISABLED 
GO
ALTER DATABASE [ProSoft-Novembar2021] SET QUERY_STORE = OFF
GO
USE [ProSoft-Novembar2021]
GO
ALTER DATABASE SCOPED CONFIGURATION SET LEGACY_CARDINALITY_ESTIMATION = OFF;
GO
ALTER DATABASE SCOPED CONFIGURATION SET MAXDOP = 0;
GO
ALTER DATABASE SCOPED CONFIGURATION SET PARAMETER_SNIFFING = ON;
GO
ALTER DATABASE SCOPED CONFIGURATION SET QUERY_OPTIMIZER_HOTFIXES = OFF;
GO
USE [ProSoft-Novembar2021]
GO
/****** Object:  Table [dbo].[Angazovanje]    Script Date: 16-Nov-21 0:01:28 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Angazovanje](
	[AngazovanjeID] [int] IDENTITY(1,1) NOT NULL,
	[VrstaAngazovanja] [nvarchar](255) NULL,
	[OpisPosla] [nvarchar](255) NULL,
	[BrojSati] [int] NULL,
	[EmisijaID] [int] NULL,
	[RadnikID] [int] NULL,
 CONSTRAINT [Angazovanje$PrimaryKey] PRIMARY KEY CLUSTERED 
(
	[AngazovanjeID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Emisija]    Script Date: 16-Nov-21 0:01:28 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Emisija](
	[EmisijaID] [int] IDENTITY(1,1) NOT NULL,
	[NazivEmisije] [nvarchar](255) NULL,
	[DatumVremePocetka] [datetime] NULL,
	[DatumVremeKraja] [datetime] NULL,
	[NacinEmitovanja] [nvarchar](255) NULL,
	[Producent] [nvarchar](255) NULL,
	[VoditeljRadnikID] [int] NULL,
	[StudioID] [int] NULL,
 CONSTRAINT [Emisija$PrimaryKey] PRIMARY KEY CLUSTERED 
(
	[EmisijaID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Radnik]    Script Date: 16-Nov-21 0:01:28 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Radnik](
	[RadnikID] [int] IDENTITY(1,1) NOT NULL,
	[Ime] [nvarchar](255) NULL,
	[Prezime] [nvarchar](255) NULL,
	[BrojLicence] [int] NULL,
	[StrucnaSprema] [nvarchar](255) NULL,
	[Status] [nvarchar](255) NULL,
 CONSTRAINT [Radnik$PrimaryKey] PRIMARY KEY CLUSTERED 
(
	[RadnikID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Studio]    Script Date: 16-Nov-21 0:01:28 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Studio](
	[StudioID] [int] IDENTITY(1,1) NOT NULL,
	[Naziv] [nvarchar](255) NULL,
	[Lokacija] [nvarchar](255) NULL,
	[Status] [nvarchar](255) NULL,
 CONSTRAINT [Studio$PrimaryKey] PRIMARY KEY CLUSTERED 
(
	[StudioID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET IDENTITY_INSERT [dbo].[Radnik] ON 

INSERT [dbo].[Radnik] ([RadnikID], [Ime], [Prezime], [BrojLicence], [StrucnaSprema], [Status]) VALUES (1, N'Marija', N'Markovic', 1, N'VSS', N'Aktivan')
INSERT [dbo].[Radnik] ([RadnikID], [Ime], [Prezime], [BrojLicence], [StrucnaSprema], [Status]) VALUES (2, N'Dragan', N'Draganic', 2, N'VSS', N'Aktivan')
INSERT [dbo].[Radnik] ([RadnikID], [Ime], [Prezime], [BrojLicence], [StrucnaSprema], [Status]) VALUES (3, N'Ivana', N'Ivanovic', 3, N'SSS', N'Neaktivan')
INSERT [dbo].[Radnik] ([RadnikID], [Ime], [Prezime], [BrojLicence], [StrucnaSprema], [Status]) VALUES (4, N'Petar', N'Petrovic', 4, N'VSS', N'Aktivan')
INSERT [dbo].[Radnik] ([RadnikID], [Ime], [Prezime], [BrojLicence], [StrucnaSprema], [Status]) VALUES (5, N'Jovana', N'Jovanic', 5, N'SSS', N'Aktivan')
INSERT [dbo].[Radnik] ([RadnikID], [Ime], [Prezime], [BrojLicence], [StrucnaSprema], [Status]) VALUES (6, N'Marija', N'Marjanovic', 6, N'VSS', N'Aktivan')
INSERT [dbo].[Radnik] ([RadnikID], [Ime], [Prezime], [BrojLicence], [StrucnaSprema], [Status]) VALUES (7, N'Milos', N'Milosevic', 7, N'SSS', N'Neaktivan')
INSERT [dbo].[Radnik] ([RadnikID], [Ime], [Prezime], [BrojLicence], [StrucnaSprema], [Status]) VALUES (8, N'Jovan', N'Jovic', 8, N'VSS', N'Aktivan')
INSERT [dbo].[Radnik] ([RadnikID], [Ime], [Prezime], [BrojLicence], [StrucnaSprema], [Status]) VALUES (9, N'Ana', N'Anic', 9, N'SSS', N'Aktivan')
INSERT [dbo].[Radnik] ([RadnikID], [Ime], [Prezime], [BrojLicence], [StrucnaSprema], [Status]) VALUES (10, N'Marko', N'Markovic', 10, N'VSS', N'Aktivan')
SET IDENTITY_INSERT [dbo].[Radnik] OFF
GO
SET IDENTITY_INSERT [dbo].[Studio] ON 

INSERT [dbo].[Studio] ([StudioID], [Naziv], [Lokacija], [Status]) VALUES (1, N'Studio 1', N'Takovska 10', N'Aktivan')
INSERT [dbo].[Studio] ([StudioID], [Naziv], [Lokacija], [Status]) VALUES (2, N'Studio 2', N'Takovska 10', N'Aktivan')
INSERT [dbo].[Studio] ([StudioID], [Naziv], [Lokacija], [Status]) VALUES (3, N'Studio 3', N'Kosutnjak 1', N'Aktivan')
INSERT [dbo].[Studio] ([StudioID], [Naziv], [Lokacija], [Status]) VALUES (4, N'Studio 4', N'Kosutnjak 2', N'Aktivan')
INSERT [dbo].[Studio] ([StudioID], [Naziv], [Lokacija], [Status]) VALUES (5, N'Studio 5', N'Kosutnjak 3', N'Neaktivan')
SET IDENTITY_INSERT [dbo].[Studio] OFF
GO
/****** Object:  Index [Angazovanje$AngazovanjeID]    Script Date: 16-Nov-21 0:01:28 ******/
CREATE NONCLUSTERED INDEX [Angazovanje$AngazovanjeID] ON [dbo].[Angazovanje]
(
	[AngazovanjeID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, DROP_EXISTING = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
/****** Object:  Index [Angazovanje$EmisijaID]    Script Date: 16-Nov-21 0:01:28 ******/
CREATE NONCLUSTERED INDEX [Angazovanje$EmisijaID] ON [dbo].[Angazovanje]
(
	[EmisijaID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, DROP_EXISTING = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
/****** Object:  Index [Angazovanje$RadnikID]    Script Date: 16-Nov-21 0:01:28 ******/
CREATE NONCLUSTERED INDEX [Angazovanje$RadnikID] ON [dbo].[Angazovanje]
(
	[RadnikID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, DROP_EXISTING = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
/****** Object:  Index [Emisija$EmisijaID]    Script Date: 16-Nov-21 0:01:28 ******/
CREATE NONCLUSTERED INDEX [Emisija$EmisijaID] ON [dbo].[Emisija]
(
	[EmisijaID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, DROP_EXISTING = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
/****** Object:  Index [Emisija$StudioID]    Script Date: 16-Nov-21 0:01:28 ******/
CREATE NONCLUSTERED INDEX [Emisija$StudioID] ON [dbo].[Emisija]
(
	[StudioID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, DROP_EXISTING = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
/****** Object:  Index [Emisija$VoditeljID]    Script Date: 16-Nov-21 0:01:28 ******/
CREATE NONCLUSTERED INDEX [Emisija$VoditeljID] ON [dbo].[Emisija]
(
	[VoditeljRadnikID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, DROP_EXISTING = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
/****** Object:  Index [Radnik$MedicinskiRadnikID]    Script Date: 16-Nov-21 0:01:28 ******/
CREATE NONCLUSTERED INDEX [Radnik$MedicinskiRadnikID] ON [dbo].[Radnik]
(
	[RadnikID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, DROP_EXISTING = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
/****** Object:  Index [Studio$StudioID]    Script Date: 16-Nov-21 0:01:28 ******/
CREATE NONCLUSTERED INDEX [Studio$StudioID] ON [dbo].[Studio]
(
	[StudioID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, DROP_EXISTING = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
ALTER TABLE [dbo].[Angazovanje] ADD  DEFAULT ((0)) FOR [BrojSati]
GO
ALTER TABLE [dbo].[Angazovanje] ADD  DEFAULT ((0)) FOR [EmisijaID]
GO
ALTER TABLE [dbo].[Angazovanje] ADD  DEFAULT ((0)) FOR [RadnikID]
GO
ALTER TABLE [dbo].[Emisija] ADD  CONSTRAINT [DF__Emisija__Voditel__300424B4]  DEFAULT ((0)) FOR [VoditeljRadnikID]
GO
ALTER TABLE [dbo].[Emisija] ADD  CONSTRAINT [DF__Emisija__StudioI__30F848ED]  DEFAULT ((0)) FOR [StudioID]
GO
ALTER TABLE [dbo].[Radnik] ADD  DEFAULT ((0)) FOR [BrojLicence]
GO
ALTER TABLE [dbo].[Angazovanje]  WITH CHECK ADD  CONSTRAINT [Angazovanje$EmisijaAngazovanje] FOREIGN KEY([EmisijaID])
REFERENCES [dbo].[Emisija] ([EmisijaID])
GO
ALTER TABLE [dbo].[Angazovanje] CHECK CONSTRAINT [Angazovanje$EmisijaAngazovanje]
GO
ALTER TABLE [dbo].[Angazovanje]  WITH CHECK ADD  CONSTRAINT [Angazovanje$RadnikAngazovanje] FOREIGN KEY([RadnikID])
REFERENCES [dbo].[Radnik] ([RadnikID])
GO
ALTER TABLE [dbo].[Angazovanje] CHECK CONSTRAINT [Angazovanje$RadnikAngazovanje]
GO
ALTER TABLE [dbo].[Emisija]  WITH CHECK ADD  CONSTRAINT [Emisija$RadnikEmisija] FOREIGN KEY([VoditeljRadnikID])
REFERENCES [dbo].[Radnik] ([RadnikID])
GO
ALTER TABLE [dbo].[Emisija] CHECK CONSTRAINT [Emisija$RadnikEmisija]
GO
ALTER TABLE [dbo].[Emisija]  WITH CHECK ADD  CONSTRAINT [Emisija$StudioEmisija] FOREIGN KEY([StudioID])
REFERENCES [dbo].[Studio] ([StudioID])
GO
ALTER TABLE [dbo].[Emisija] CHECK CONSTRAINT [Emisija$StudioEmisija]
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Novembar2021.[Angazovanje].[AngazovanjeID]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'Angazovanje', @level2type=N'COLUMN',@level2name=N'AngazovanjeID'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Novembar2021.[Angazovanje].[VrstaAngazovanja]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'Angazovanje', @level2type=N'COLUMN',@level2name=N'VrstaAngazovanja'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Novembar2021.[Angazovanje].[OpisPosla]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'Angazovanje', @level2type=N'COLUMN',@level2name=N'OpisPosla'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Novembar2021.[Angazovanje].[BrojSati]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'Angazovanje', @level2type=N'COLUMN',@level2name=N'BrojSati'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Novembar2021.[Angazovanje].[EmisijaID]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'Angazovanje', @level2type=N'COLUMN',@level2name=N'EmisijaID'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Novembar2021.[Angazovanje].[RadnikID]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'Angazovanje', @level2type=N'COLUMN',@level2name=N'RadnikID'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Novembar2021.[Angazovanje].[PrimaryKey]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'Angazovanje', @level2type=N'CONSTRAINT',@level2name=N'Angazovanje$PrimaryKey'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Novembar2021.[Angazovanje].[AngazovanjeID]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'Angazovanje', @level2type=N'INDEX',@level2name=N'Angazovanje$AngazovanjeID'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Novembar2021.[Angazovanje].[EmisijaID]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'Angazovanje', @level2type=N'INDEX',@level2name=N'Angazovanje$EmisijaID'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Novembar2021.[Angazovanje].[RadnikID]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'Angazovanje', @level2type=N'INDEX',@level2name=N'Angazovanje$RadnikID'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Novembar2021.[Angazovanje]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'Angazovanje'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Novembar2021.[Angazovanje].[EmisijaAngazovanje]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'Angazovanje', @level2type=N'CONSTRAINT',@level2name=N'Angazovanje$EmisijaAngazovanje'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Novembar2021.[Angazovanje].[RadnikAngazovanje]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'Angazovanje', @level2type=N'CONSTRAINT',@level2name=N'Angazovanje$RadnikAngazovanje'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Novembar2021.[Emisija].[EmisijaID]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'Emisija', @level2type=N'COLUMN',@level2name=N'EmisijaID'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Novembar2021.[Emisija].[NazivEmisije]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'Emisija', @level2type=N'COLUMN',@level2name=N'NazivEmisije'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Novembar2021.[Emisija].[DatumVremePocetka]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'Emisija', @level2type=N'COLUMN',@level2name=N'DatumVremePocetka'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Novembar2021.[Emisija].[DatumVremeKraja]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'Emisija', @level2type=N'COLUMN',@level2name=N'DatumVremeKraja'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Novembar2021.[Emisija].[NacinEmitovanja]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'Emisija', @level2type=N'COLUMN',@level2name=N'NacinEmitovanja'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Novembar2021.[Emisija].[Producent]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'Emisija', @level2type=N'COLUMN',@level2name=N'Producent'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Novembar2021.[Emisija].[VoditeljRadnikID]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'Emisija', @level2type=N'COLUMN',@level2name=N'VoditeljRadnikID'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Novembar2021.[Emisija].[StudioID]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'Emisija', @level2type=N'COLUMN',@level2name=N'StudioID'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Novembar2021.[Emisija].[PrimaryKey]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'Emisija', @level2type=N'CONSTRAINT',@level2name=N'Emisija$PrimaryKey'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Novembar2021.[Emisija].[EmisijaID]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'Emisija', @level2type=N'INDEX',@level2name=N'Emisija$EmisijaID'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Novembar2021.[Emisija].[StudioID]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'Emisija', @level2type=N'INDEX',@level2name=N'Emisija$StudioID'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Novembar2021.[Emisija].[VoditeljID]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'Emisija', @level2type=N'INDEX',@level2name=N'Emisija$VoditeljID'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Novembar2021.[Emisija]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'Emisija'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Novembar2021.[Emisija].[RadnikEmisija]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'Emisija', @level2type=N'CONSTRAINT',@level2name=N'Emisija$RadnikEmisija'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Novembar2021.[Emisija].[StudioEmisija]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'Emisija', @level2type=N'CONSTRAINT',@level2name=N'Emisija$StudioEmisija'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Novembar2021.[Radnik].[RadnikID]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'Radnik', @level2type=N'COLUMN',@level2name=N'RadnikID'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Novembar2021.[Radnik].[Ime]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'Radnik', @level2type=N'COLUMN',@level2name=N'Ime'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Novembar2021.[Radnik].[Prezime]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'Radnik', @level2type=N'COLUMN',@level2name=N'Prezime'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Novembar2021.[Radnik].[BrojLicence]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'Radnik', @level2type=N'COLUMN',@level2name=N'BrojLicence'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Novembar2021.[Radnik].[StrucnaSprema]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'Radnik', @level2type=N'COLUMN',@level2name=N'StrucnaSprema'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Novembar2021.[Radnik].[Status]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'Radnik', @level2type=N'COLUMN',@level2name=N'Status'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Novembar2021.[Radnik].[PrimaryKey]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'Radnik', @level2type=N'CONSTRAINT',@level2name=N'Radnik$PrimaryKey'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Novembar2021.[Radnik].[MedicinskiRadnikID]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'Radnik', @level2type=N'INDEX',@level2name=N'Radnik$MedicinskiRadnikID'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Novembar2021.[Radnik]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'Radnik'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Novembar2021.[Studio].[StudioID]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'Studio', @level2type=N'COLUMN',@level2name=N'StudioID'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Novembar2021.[Studio].[Naziv]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'Studio', @level2type=N'COLUMN',@level2name=N'Naziv'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Novembar2021.[Studio].[Lokacija]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'Studio', @level2type=N'COLUMN',@level2name=N'Lokacija'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Novembar2021.[Studio].[Status]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'Studio', @level2type=N'COLUMN',@level2name=N'Status'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Novembar2021.[Studio].[PrimaryKey]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'Studio', @level2type=N'CONSTRAINT',@level2name=N'Studio$PrimaryKey'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Novembar2021.[Studio].[StudioID]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'Studio', @level2type=N'INDEX',@level2name=N'Studio$StudioID'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Novembar2021.[Studio]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'Studio'
GO
USE [master]
GO
ALTER DATABASE [ProSoft-Novembar2021] SET  READ_WRITE 
GO
