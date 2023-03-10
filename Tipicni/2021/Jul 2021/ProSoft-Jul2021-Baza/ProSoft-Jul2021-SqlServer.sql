USE [master]
GO
/****** Object:  Database [ProSoft-Jul2021]    Script Date: 27-Jun-21 22:56:21 ******/
CREATE DATABASE [ProSoft-Jul2021]
 GO
ALTER DATABASE [ProSoft-Jul2021] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [ProSoft-Jul2021] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [ProSoft-Jul2021] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [ProSoft-Jul2021] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [ProSoft-Jul2021] SET ARITHABORT OFF 
GO
ALTER DATABASE [ProSoft-Jul2021] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [ProSoft-Jul2021] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [ProSoft-Jul2021] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [ProSoft-Jul2021] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [ProSoft-Jul2021] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [ProSoft-Jul2021] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [ProSoft-Jul2021] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [ProSoft-Jul2021] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [ProSoft-Jul2021] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [ProSoft-Jul2021] SET  DISABLE_BROKER 
GO
ALTER DATABASE [ProSoft-Jul2021] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [ProSoft-Jul2021] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [ProSoft-Jul2021] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [ProSoft-Jul2021] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [ProSoft-Jul2021] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [ProSoft-Jul2021] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [ProSoft-Jul2021] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [ProSoft-Jul2021] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [ProSoft-Jul2021] SET  MULTI_USER 
GO
ALTER DATABASE [ProSoft-Jul2021] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [ProSoft-Jul2021] SET DB_CHAINING OFF 
GO
ALTER DATABASE [ProSoft-Jul2021] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [ProSoft-Jul2021] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [ProSoft-Jul2021] SET DELAYED_DURABILITY = DISABLED 
GO
ALTER DATABASE [ProSoft-Jul2021] SET QUERY_STORE = OFF
GO
USE [ProSoft-Jul2021]
GO
ALTER DATABASE SCOPED CONFIGURATION SET LEGACY_CARDINALITY_ESTIMATION = OFF;
GO
ALTER DATABASE SCOPED CONFIGURATION SET MAXDOP = 0;
GO
ALTER DATABASE SCOPED CONFIGURATION SET PARAMETER_SNIFFING = ON;
GO
ALTER DATABASE SCOPED CONFIGURATION SET QUERY_OPTIMIZER_HOTFIXES = OFF;
GO
USE [ProSoft-Jul2021]
GO
/****** Object:  Table [dbo].[Organizator]    Script Date: 27-Jun-21 22:56:22 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Organizator](
	[OrganizatorID] [int] IDENTITY(1,1) NOT NULL,
	[Ime] [nvarchar](255) NULL,
	[Prezime] [nvarchar](255) NULL,
	[KorisnickoIme] [nvarchar](255) NULL,
	[Lozinka] [nvarchar](255) NULL,
 CONSTRAINT [Organizator$PrimaryKey] PRIMARY KEY CLUSTERED 
(
	[OrganizatorID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Takmicar]    Script Date: 27-Jun-21 22:56:22 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Takmicar](
	[TakmicarID] [int] IDENTITY(1,1) NOT NULL,
	[Ime] [nvarchar](255) NULL,
	[Prezime] [nvarchar](255) NULL,
	[Pol] [nvarchar](255) NULL,
	[Kontakt] [nvarchar](255) NULL,
 CONSTRAINT [Takmicar$PrimaryKey] PRIMARY KEY CLUSTERED 
(
	[TakmicarID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Takmicenje]    Script Date: 27-Jun-21 22:56:22 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Takmicenje](
	[TakmicenjeID] [int] IDENTITY(1,1) NOT NULL,
	[NazivTakmicenja] [nvarchar](255) NULL,
	[VrstaTrke] [nvarchar](255) NULL,
	[Opis] [nvarchar](255) NULL,
	[Datum] [datetime] NULL,
 CONSTRAINT [Takmicenje$PrimaryKey] PRIMARY KEY CLUSTERED 
(
	[TakmicenjeID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Ucesce]    Script Date: 27-Jun-21 22:56:22 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Ucesce](
	[UcesceID] [int] IDENTITY(1,1) NOT NULL,
	[VrstaTrke] [nvarchar](255) NULL,
	[DatumVremePocetka] [datetime] NULL,
	[DatumVremeZavrsetka] [datetime] NULL,
	[TakmicenjeID] [int] NULL,
	[TakmicarID] [int] NULL,
	[OrganizatorID] [int] NULL,
 CONSTRAINT [Ucesce$PrimaryKey] PRIMARY KEY CLUSTERED 
(
	[UcesceID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET IDENTITY_INSERT [dbo].[Organizator] ON 

INSERT [dbo].[Organizator] ([OrganizatorID], [Ime], [Prezime], [KorisnickoIme], [Lozinka]) VALUES (1, N'Ana', N'Anic', N'ana', N'ana1')
INSERT [dbo].[Organizator] ([OrganizatorID], [Ime], [Prezime], [KorisnickoIme], [Lozinka]) VALUES (2, N'Dragan', N'Draganic', N'dragan', N'dragan1')
INSERT [dbo].[Organizator] ([OrganizatorID], [Ime], [Prezime], [KorisnickoIme], [Lozinka]) VALUES (3, N'Marko', N'Markovic', N'marko', N'marko1')
SET IDENTITY_INSERT [dbo].[Organizator] OFF
GO
SET IDENTITY_INSERT [dbo].[Takmicar] ON 

INSERT [dbo].[Takmicar] ([TakmicarID], [Ime], [Prezime], [Pol], [Kontakt]) VALUES (1, N'Dragan', N'Petrovic', N'M', N'011-111-111')
INSERT [dbo].[Takmicar] ([TakmicarID], [Ime], [Prezime], [Pol], [Kontakt]) VALUES (2, N'Ivana', N'Ivkovic', N'Z', N'011-222-222')
INSERT [dbo].[Takmicar] ([TakmicarID], [Ime], [Prezime], [Pol], [Kontakt]) VALUES (3, N'Marko', N'Mitrovic', N'M', N'011-333-333')
INSERT [dbo].[Takmicar] ([TakmicarID], [Ime], [Prezime], [Pol], [Kontakt]) VALUES (4, N'Pavle', N'Petrovic', N'M', N'011-444-444')
INSERT [dbo].[Takmicar] ([TakmicarID], [Ime], [Prezime], [Pol], [Kontakt]) VALUES (5, N'Dusan', N'Jovic', N'M', N'011-555-555')
INSERT [dbo].[Takmicar] ([TakmicarID], [Ime], [Prezime], [Pol], [Kontakt]) VALUES (6, N'Jelena', N'Mitrovic', N'Z', N'011-666-666')
INSERT [dbo].[Takmicar] ([TakmicarID], [Ime], [Prezime], [Pol], [Kontakt]) VALUES (7, N'Marija', N'Markovic', N'Z', N'011-777-777')
INSERT [dbo].[Takmicar] ([TakmicarID], [Ime], [Prezime], [Pol], [Kontakt]) VALUES (8, N'Miljan', N'Matic', N'M', N'011-888-888')
INSERT [dbo].[Takmicar] ([TakmicarID], [Ime], [Prezime], [Pol], [Kontakt]) VALUES (9, N'Milica', N'Pavlovic', N'Z', N'011-999-999')
SET IDENTITY_INSERT [dbo].[Takmicar] OFF
GO
SET IDENTITY_INSERT [dbo].[Takmicenje] ON 

INSERT [dbo].[Takmicenje] ([TakmicenjeID], [NazivTakmicenja], [VrstaTrke], [Opis], [Datum]) VALUES (1, N'BG maraton 21 - polumaraton (Z)', N'Polumaraton', N'Polumaraton 21km, zene', CAST(N'2021-06-06T09:00:00.000' AS DateTime))
INSERT [dbo].[Takmicenje] ([TakmicenjeID], [NazivTakmicenja], [VrstaTrke], [Opis], [Datum]) VALUES (2, N'BG maraton 21 - maraton (Z)', N'Maraton', N'Maraton 42km, zene', CAST(N'2021-06-06T10:00:00.000' AS DateTime))
INSERT [dbo].[Takmicenje] ([TakmicenjeID], [NazivTakmicenja], [VrstaTrke], [Opis], [Datum]) VALUES (3, N'BG maraton 21 - polumaraton (M)', N'Polumaraton', N'Polumaraton 21km, muskarci', CAST(N'2021-06-07T09:00:00.000' AS DateTime))
INSERT [dbo].[Takmicenje] ([TakmicenjeID], [NazivTakmicenja], [VrstaTrke], [Opis], [Datum]) VALUES (4, N'BG maraton 21 - maraton (M)', N'Maraton', N'Maraton 42km, muskarci', CAST(N'2021-06-07T10:00:00.000' AS DateTime))
SET IDENTITY_INSERT [dbo].[Takmicenje] OFF
GO
/****** Object:  Index [Organizator$OrganizatorID]    Script Date: 27-Jun-21 22:56:22 ******/
CREATE NONCLUSTERED INDEX [Organizator$OrganizatorID] ON [dbo].[Organizator]
(
	[OrganizatorID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, DROP_EXISTING = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
/****** Object:  Index [Takmicar$TakmicarID]    Script Date: 27-Jun-21 22:56:22 ******/
CREATE NONCLUSTERED INDEX [Takmicar$TakmicarID] ON [dbo].[Takmicar]
(
	[TakmicarID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, DROP_EXISTING = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
/****** Object:  Index [Takmicenje$UcesceID]    Script Date: 27-Jun-21 22:56:22 ******/
CREATE NONCLUSTERED INDEX [Takmicenje$UcesceID] ON [dbo].[Takmicenje]
(
	[TakmicenjeID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, DROP_EXISTING = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
/****** Object:  Index [Ucesce$OrganizatorID]    Script Date: 27-Jun-21 22:56:22 ******/
CREATE NONCLUSTERED INDEX [Ucesce$OrganizatorID] ON [dbo].[Ucesce]
(
	[OrganizatorID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, DROP_EXISTING = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
/****** Object:  Index [Ucesce$TakmicarID]    Script Date: 27-Jun-21 22:56:22 ******/
CREATE NONCLUSTERED INDEX [Ucesce$TakmicarID] ON [dbo].[Ucesce]
(
	[TakmicarID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, DROP_EXISTING = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
/****** Object:  Index [Ucesce$TakmicenjeID]    Script Date: 27-Jun-21 22:56:22 ******/
CREATE NONCLUSTERED INDEX [Ucesce$TakmicenjeID] ON [dbo].[Ucesce]
(
	[TakmicenjeID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, DROP_EXISTING = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
/****** Object:  Index [Ucesce$UcesceID]    Script Date: 27-Jun-21 22:56:22 ******/
CREATE NONCLUSTERED INDEX [Ucesce$UcesceID] ON [dbo].[Ucesce]
(
	[UcesceID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, DROP_EXISTING = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
ALTER TABLE [dbo].[Ucesce] ADD  CONSTRAINT [DF__Ucesce__Takmicen__2C3393D0]  DEFAULT ((0)) FOR [TakmicenjeID]
GO
ALTER TABLE [dbo].[Ucesce] ADD  CONSTRAINT [DF__Ucesce__Takmicar__2D27B809]  DEFAULT ((0)) FOR [TakmicarID]
GO
ALTER TABLE [dbo].[Ucesce] ADD  CONSTRAINT [DF__Ucesce__Organiza__2E1BDC42]  DEFAULT ((0)) FOR [OrganizatorID]
GO
ALTER TABLE [dbo].[Ucesce]  WITH CHECK ADD  CONSTRAINT [Ucesce$OrganizatorUcesce] FOREIGN KEY([OrganizatorID])
REFERENCES [dbo].[Organizator] ([OrganizatorID])
GO
ALTER TABLE [dbo].[Ucesce] CHECK CONSTRAINT [Ucesce$OrganizatorUcesce]
GO
ALTER TABLE [dbo].[Ucesce]  WITH CHECK ADD  CONSTRAINT [Ucesce$TakmicarUcesce] FOREIGN KEY([TakmicarID])
REFERENCES [dbo].[Takmicar] ([TakmicarID])
GO
ALTER TABLE [dbo].[Ucesce] CHECK CONSTRAINT [Ucesce$TakmicarUcesce]
GO
ALTER TABLE [dbo].[Ucesce]  WITH CHECK ADD  CONSTRAINT [Ucesce$TakmicenjeUcesce] FOREIGN KEY([TakmicenjeID])
REFERENCES [dbo].[Takmicenje] ([TakmicenjeID])
GO
ALTER TABLE [dbo].[Ucesce] CHECK CONSTRAINT [Ucesce$TakmicenjeUcesce]
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Jul2021.[Organizator].[OrganizatorID]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'Organizator', @level2type=N'COLUMN',@level2name=N'OrganizatorID'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Jul2021.[Organizator].[Ime]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'Organizator', @level2type=N'COLUMN',@level2name=N'Ime'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Jul2021.[Organizator].[Prezime]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'Organizator', @level2type=N'COLUMN',@level2name=N'Prezime'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Jul2021.[Organizator].[KorisnickoIme]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'Organizator', @level2type=N'COLUMN',@level2name=N'KorisnickoIme'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Jul2021.[Organizator].[Lozinka]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'Organizator', @level2type=N'COLUMN',@level2name=N'Lozinka'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Jul2021.[Organizator].[PrimaryKey]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'Organizator', @level2type=N'CONSTRAINT',@level2name=N'Organizator$PrimaryKey'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Jul2021.[Organizator].[OrganizatorID]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'Organizator', @level2type=N'INDEX',@level2name=N'Organizator$OrganizatorID'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Jul2021.[Organizator]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'Organizator'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Jul2021.[Takmicar].[TakmicarID]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'Takmicar', @level2type=N'COLUMN',@level2name=N'TakmicarID'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Jul2021.[Takmicar].[Ime]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'Takmicar', @level2type=N'COLUMN',@level2name=N'Ime'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Jul2021.[Takmicar].[Prezime]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'Takmicar', @level2type=N'COLUMN',@level2name=N'Prezime'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Jul2021.[Takmicar].[Pol]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'Takmicar', @level2type=N'COLUMN',@level2name=N'Pol'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Jul2021.[Takmicar].[Kontakt]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'Takmicar', @level2type=N'COLUMN',@level2name=N'Kontakt'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Jul2021.[Takmicar].[PrimaryKey]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'Takmicar', @level2type=N'CONSTRAINT',@level2name=N'Takmicar$PrimaryKey'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Jul2021.[Takmicar].[TakmicarID]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'Takmicar', @level2type=N'INDEX',@level2name=N'Takmicar$TakmicarID'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Jul2021.[Takmicar]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'Takmicar'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Jul2021.[Takmicenje].[TakmicenjeID]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'Takmicenje', @level2type=N'COLUMN',@level2name=N'TakmicenjeID'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Jul2021.[Takmicenje].[NazivTakmicenja]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'Takmicenje', @level2type=N'COLUMN',@level2name=N'NazivTakmicenja'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Jul2021.[Takmicenje].[VrstaTrke]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'Takmicenje', @level2type=N'COLUMN',@level2name=N'VrstaTrke'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Jul2021.[Takmicenje].[Opis]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'Takmicenje', @level2type=N'COLUMN',@level2name=N'Opis'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Jul2021.[Takmicenje].[Datum]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'Takmicenje', @level2type=N'COLUMN',@level2name=N'Datum'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Jul2021.[Takmicenje].[PrimaryKey]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'Takmicenje', @level2type=N'CONSTRAINT',@level2name=N'Takmicenje$PrimaryKey'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Jul2021.[Takmicenje].[UcesceID]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'Takmicenje', @level2type=N'INDEX',@level2name=N'Takmicenje$UcesceID'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Jul2021.[Takmicenje]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'Takmicenje'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Jul2021.[Ucesce].[UcesceID]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'Ucesce', @level2type=N'COLUMN',@level2name=N'UcesceID'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Jul2021.[Ucesce].[VrstaTrke]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'Ucesce', @level2type=N'COLUMN',@level2name=N'VrstaTrke'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Jul2021.[Ucesce].[DatumVremePocetka]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'Ucesce', @level2type=N'COLUMN',@level2name=N'DatumVremePocetka'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Jul2021.[Ucesce].[DatumVremeZavrsetka]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'Ucesce', @level2type=N'COLUMN',@level2name=N'DatumVremeZavrsetka'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Jul2021.[Ucesce].[TakmicenjeID]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'Ucesce', @level2type=N'COLUMN',@level2name=N'TakmicenjeID'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Jul2021.[Ucesce].[TakmicarID]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'Ucesce', @level2type=N'COLUMN',@level2name=N'TakmicarID'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Jul2021.[Ucesce].[OrganizatorID]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'Ucesce', @level2type=N'COLUMN',@level2name=N'OrganizatorID'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Jul2021.[Ucesce].[PrimaryKey]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'Ucesce', @level2type=N'CONSTRAINT',@level2name=N'Ucesce$PrimaryKey'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Jul2021.[Ucesce].[OrganizatorID]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'Ucesce', @level2type=N'INDEX',@level2name=N'Ucesce$OrganizatorID'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Jul2021.[Ucesce].[TakmicarID]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'Ucesce', @level2type=N'INDEX',@level2name=N'Ucesce$TakmicarID'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Jul2021.[Ucesce].[TakmicenjeID]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'Ucesce', @level2type=N'INDEX',@level2name=N'Ucesce$TakmicenjeID'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Jul2021.[Ucesce].[UcesceID]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'Ucesce', @level2type=N'INDEX',@level2name=N'Ucesce$UcesceID'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Jul2021.[Ucesce]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'Ucesce'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Jul2021.[Ucesce].[OrganizatorUcesce]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'Ucesce', @level2type=N'CONSTRAINT',@level2name=N'Ucesce$OrganizatorUcesce'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Jul2021.[Ucesce].[TakmicarUcesce]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'Ucesce', @level2type=N'CONSTRAINT',@level2name=N'Ucesce$TakmicarUcesce'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Jul2021.[Ucesce].[TakmicenjeUcesce]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'Ucesce', @level2type=N'CONSTRAINT',@level2name=N'Ucesce$TakmicenjeUcesce'
GO
USE [master]
GO
ALTER DATABASE [ProSoft-Jul2021] SET  READ_WRITE 
GO
