USE [master]
GO
/****** Object:  Database [ProSoft-Januar2022]    Script Date: 18-Jan-22 19:31:09 ******/
CREATE DATABASE [ProSoft-Januar2022]
GO
ALTER DATABASE [ProSoft-Januar2022] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [ProSoft-Januar2022] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [ProSoft-Januar2022] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [ProSoft-Januar2022] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [ProSoft-Januar2022] SET ARITHABORT OFF 
GO
ALTER DATABASE [ProSoft-Januar2022] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [ProSoft-Januar2022] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [ProSoft-Januar2022] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [ProSoft-Januar2022] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [ProSoft-Januar2022] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [ProSoft-Januar2022] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [ProSoft-Januar2022] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [ProSoft-Januar2022] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [ProSoft-Januar2022] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [ProSoft-Januar2022] SET  DISABLE_BROKER 
GO
ALTER DATABASE [ProSoft-Januar2022] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [ProSoft-Januar2022] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [ProSoft-Januar2022] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [ProSoft-Januar2022] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [ProSoft-Januar2022] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [ProSoft-Januar2022] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [ProSoft-Januar2022] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [ProSoft-Januar2022] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [ProSoft-Januar2022] SET  MULTI_USER 
GO
ALTER DATABASE [ProSoft-Januar2022] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [ProSoft-Januar2022] SET DB_CHAINING OFF 
GO
ALTER DATABASE [ProSoft-Januar2022] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [ProSoft-Januar2022] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [ProSoft-Januar2022] SET DELAYED_DURABILITY = DISABLED 
GO
ALTER DATABASE [ProSoft-Januar2022] SET QUERY_STORE = OFF
GO
USE [ProSoft-Januar2022]
GO
ALTER DATABASE SCOPED CONFIGURATION SET LEGACY_CARDINALITY_ESTIMATION = OFF;
GO
ALTER DATABASE SCOPED CONFIGURATION SET MAXDOP = 0;
GO
ALTER DATABASE SCOPED CONFIGURATION SET PARAMETER_SNIFFING = ON;
GO
ALTER DATABASE SCOPED CONFIGURATION SET QUERY_OPTIMIZER_HOTFIXES = OFF;
GO
USE [ProSoft-Januar2022]
GO
/****** Object:  Table [dbo].[Dostupnost]    Script Date: 18-Jan-22 19:31:09 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Dostupnost](
	[IgraID] [int] NOT NULL,
	[RB] [int] NOT NULL,
	[Platforma] [nvarchar](255) NOT NULL,
	[DatumObjave] [datetime] NOT NULL,
	[Status] [nvarchar](255) NOT NULL,
 CONSTRAINT [Dostupnost$PrimaryKey] PRIMARY KEY CLUSTERED 
(
	[IgraID] ASC,
	[RB] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Igra]    Script Date: 18-Jan-22 19:31:09 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Igra](
	[IgraID] [int] NOT NULL,
	[Naziv] [nvarchar](255) NOT NULL,
	[Zanr] [nvarchar](255) NOT NULL,
	[Opis] [nvarchar](255) NOT NULL,
	[Korisnik] [nvarchar](255) NOT NULL,
	[IzdavacID] [int] NOT NULL,
 CONSTRAINT [Igra$PrimaryKey] PRIMARY KEY CLUSTERED 
(
	[IgraID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Izdavac]    Script Date: 18-Jan-22 19:31:09 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Izdavac](
	[IzdavacID] [int] IDENTITY(1,1) NOT NULL,
	[Naziv] [nvarchar](255) NOT NULL,
	[Adresa] [nvarchar](255) NOT NULL,
	[URL] [nvarchar](255) NOT NULL,
 CONSTRAINT [Izdavac$PrimaryKey] PRIMARY KEY CLUSTERED 
(
	[IzdavacID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET IDENTITY_INSERT [dbo].[Izdavac] ON 

INSERT [dbo].[Izdavac] ([IzdavacID], [Naziv], [Adresa], [URL]) VALUES (1, N'Ubisoft', N'Adresa 1', N'https://www.ubisoft.com')
INSERT [dbo].[Izdavac] ([IzdavacID], [Naziv], [Adresa], [URL]) VALUES (2, N'Electronic Arts', N'Adresa 2', N'https://www.ea.com')
INSERT [dbo].[Izdavac] ([IzdavacID], [Naziv], [Adresa], [URL]) VALUES (3, N'CD Projekt', N'Adresa 3', N'https://www.cdprojekt.com')
INSERT [dbo].[Izdavac] ([IzdavacID], [Naziv], [Adresa], [URL]) VALUES (4, N'Capcom Company', N'Adresa 4', N'https://www.capcom.com')
INSERT [dbo].[Izdavac] ([IzdavacID], [Naziv], [Adresa], [URL]) VALUES (5, N'Epic Games', N'Adresa 5', N'https://www.epicgames.com')
INSERT [dbo].[Izdavac] ([IzdavacID], [Naziv], [Adresa], [URL]) VALUES (6, N'Take-Two Interactive Software', N'Adresa 6', N'https://www.take2games.com')
INSERT [dbo].[Izdavac] ([IzdavacID], [Naziv], [Adresa], [URL]) VALUES (7, N'Gameloft', N'Adresa 7', N'https://www.gameloft.com')
INSERT [dbo].[Izdavac] ([IzdavacID], [Naziv], [Adresa], [URL]) VALUES (8, N'Blizzard Entertainment', N'Adresa 8', N'https://www.blizzard.com')
INSERT [dbo].[Izdavac] ([IzdavacID], [Naziv], [Adresa], [URL]) VALUES (9, N'Zynga', N'Adresa 9', N'https://www.zynga.com')
INSERT [dbo].[Izdavac] ([IzdavacID], [Naziv], [Adresa], [URL]) VALUES (10, N'Konami Holdings Corporations', N'Adresa 10', N'https://www.konami.com')
SET IDENTITY_INSERT [dbo].[Izdavac] OFF
GO
/****** Object:  Index [Dostupnost$IgraID]    Script Date: 18-Jan-22 19:31:09 ******/
CREATE NONCLUSTERED INDEX [Dostupnost$IgraID] ON [dbo].[Dostupnost]
(
	[IgraID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, DROP_EXISTING = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
/****** Object:  Index [Igra$IgraID]    Script Date: 18-Jan-22 19:31:09 ******/
CREATE NONCLUSTERED INDEX [Igra$IgraID] ON [dbo].[Igra]
(
	[IgraID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, DROP_EXISTING = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
/****** Object:  Index [Igra$IzdavacID]    Script Date: 18-Jan-22 19:31:09 ******/
CREATE NONCLUSTERED INDEX [Igra$IzdavacID] ON [dbo].[Igra]
(
	[IzdavacID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, DROP_EXISTING = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
/****** Object:  Index [Izdavac$IzdavacID]    Script Date: 18-Jan-22 19:31:09 ******/
CREATE NONCLUSTERED INDEX [Izdavac$IzdavacID] ON [dbo].[Izdavac]
(
	[IzdavacID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, DROP_EXISTING = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
ALTER TABLE [dbo].[Dostupnost] ADD  CONSTRAINT [DF__Dostupnos__IgraI__29572725]  DEFAULT ((0)) FOR [IgraID]
GO
ALTER TABLE [dbo].[Dostupnost] ADD  CONSTRAINT [DF__Dostupnost__RB__2A4B4B5E]  DEFAULT ((0)) FOR [RB]
GO
ALTER TABLE [dbo].[Igra] ADD  DEFAULT ((0)) FOR [IgraID]
GO
ALTER TABLE [dbo].[Igra] ADD  DEFAULT ((0)) FOR [IzdavacID]
GO
ALTER TABLE [dbo].[Dostupnost]  WITH CHECK ADD  CONSTRAINT [Dostupnost$IgraDostupnost] FOREIGN KEY([IgraID])
REFERENCES [dbo].[Igra] ([IgraID])
GO
ALTER TABLE [dbo].[Dostupnost] CHECK CONSTRAINT [Dostupnost$IgraDostupnost]
GO
ALTER TABLE [dbo].[Igra]  WITH CHECK ADD  CONSTRAINT [Igra$IzdavacIgra] FOREIGN KEY([IzdavacID])
REFERENCES [dbo].[Izdavac] ([IzdavacID])
GO
ALTER TABLE [dbo].[Igra] CHECK CONSTRAINT [Igra$IzdavacIgra]
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Januar2022.[Dostupnost].[IgraID]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'Dostupnost', @level2type=N'COLUMN',@level2name=N'IgraID'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Januar2022.[Dostupnost].[RB]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'Dostupnost', @level2type=N'COLUMN',@level2name=N'RB'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Januar2022.[Dostupnost].[Platforma]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'Dostupnost', @level2type=N'COLUMN',@level2name=N'Platforma'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Januar2022.[Dostupnost].[DatumObjave]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'Dostupnost', @level2type=N'COLUMN',@level2name=N'DatumObjave'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Januar2022.[Dostupnost].[Status]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'Dostupnost', @level2type=N'COLUMN',@level2name=N'Status'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Januar2022.[Dostupnost].[PrimaryKey]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'Dostupnost', @level2type=N'CONSTRAINT',@level2name=N'Dostupnost$PrimaryKey'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Januar2022.[Dostupnost].[IgraID]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'Dostupnost', @level2type=N'INDEX',@level2name=N'Dostupnost$IgraID'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Januar2022.[Dostupnost]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'Dostupnost'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Januar2022.[Dostupnost].[IgraDostupnost]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'Dostupnost', @level2type=N'CONSTRAINT',@level2name=N'Dostupnost$IgraDostupnost'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Januar2022.[Igra].[IgraID]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'Igra', @level2type=N'COLUMN',@level2name=N'IgraID'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Januar2022.[Igra].[Naziv]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'Igra', @level2type=N'COLUMN',@level2name=N'Naziv'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Januar2022.[Igra].[Zanr]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'Igra', @level2type=N'COLUMN',@level2name=N'Zanr'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Januar2022.[Igra].[Opis]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'Igra', @level2type=N'COLUMN',@level2name=N'Opis'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Januar2022.[Igra].[Korisnik]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'Igra', @level2type=N'COLUMN',@level2name=N'Korisnik'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Januar2022.[Igra].[IzdavacID]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'Igra', @level2type=N'COLUMN',@level2name=N'IzdavacID'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Januar2022.[Igra].[PrimaryKey]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'Igra', @level2type=N'CONSTRAINT',@level2name=N'Igra$PrimaryKey'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Januar2022.[Igra].[IgraID]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'Igra', @level2type=N'INDEX',@level2name=N'Igra$IgraID'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Januar2022.[Igra].[IzdavacID]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'Igra', @level2type=N'INDEX',@level2name=N'Igra$IzdavacID'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Januar2022.[Igra]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'Igra'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Januar2022.[Igra].[IzdavacIgra]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'Igra', @level2type=N'CONSTRAINT',@level2name=N'Igra$IzdavacIgra'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Januar2022.[Izdavac].[IzdavacID]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'Izdavac', @level2type=N'COLUMN',@level2name=N'IzdavacID'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Januar2022.[Izdavac].[Naziv]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'Izdavac', @level2type=N'COLUMN',@level2name=N'Naziv'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Januar2022.[Izdavac].[Adresa]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'Izdavac', @level2type=N'COLUMN',@level2name=N'Adresa'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Januar2022.[Izdavac].[URL]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'Izdavac', @level2type=N'COLUMN',@level2name=N'URL'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Januar2022.[Izdavac].[PrimaryKey]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'Izdavac', @level2type=N'CONSTRAINT',@level2name=N'Izdavac$PrimaryKey'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Januar2022.[Izdavac].[IzdavacID]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'Izdavac', @level2type=N'INDEX',@level2name=N'Izdavac$IzdavacID'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Januar2022.[Izdavac]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'Izdavac'
GO
USE [master]
GO
ALTER DATABASE [ProSoft-Januar2022] SET  READ_WRITE 
GO
