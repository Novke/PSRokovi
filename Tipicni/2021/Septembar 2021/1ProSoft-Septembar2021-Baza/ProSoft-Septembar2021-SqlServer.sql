USE [master]
GO
CREATE DATABASE [ProSoft-Septembar2021];
GO
USE [ProSoft-Septembar2021];
GO
ALTER DATABASE [ProSoft-Septembar2021] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [ProSoft-Septembar2021] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [ProSoft-Septembar2021] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [ProSoft-Septembar2021] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [ProSoft-Septembar2021] SET ARITHABORT OFF 
GO
ALTER DATABASE [ProSoft-Septembar2021] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [ProSoft-Septembar2021] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [ProSoft-Septembar2021] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [ProSoft-Septembar2021] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [ProSoft-Septembar2021] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [ProSoft-Septembar2021] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [ProSoft-Septembar2021] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [ProSoft-Septembar2021] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [ProSoft-Septembar2021] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [ProSoft-Septembar2021] SET  DISABLE_BROKER 
GO
ALTER DATABASE [ProSoft-Septembar2021] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [ProSoft-Septembar2021] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [ProSoft-Septembar2021] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [ProSoft-Septembar2021] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [ProSoft-Septembar2021] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [ProSoft-Septembar2021] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [ProSoft-Septembar2021] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [ProSoft-Septembar2021] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [ProSoft-Septembar2021] SET  MULTI_USER 
GO
ALTER DATABASE [ProSoft-Septembar2021] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [ProSoft-Septembar2021] SET DB_CHAINING OFF 
GO
ALTER DATABASE [ProSoft-Septembar2021] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [ProSoft-Septembar2021] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [ProSoft-Septembar2021] SET DELAYED_DURABILITY = DISABLED 
GO
ALTER DATABASE [ProSoft-Septembar2021] SET QUERY_STORE = OFF
GO
USE [ProSoft-Septembar2021]
GO
ALTER DATABASE SCOPED CONFIGURATION SET LEGACY_CARDINALITY_ESTIMATION = OFF;
GO
ALTER DATABASE SCOPED CONFIGURATION SET MAXDOP = 0;
GO
ALTER DATABASE SCOPED CONFIGURATION SET PARAMETER_SNIFFING = ON;
GO
ALTER DATABASE SCOPED CONFIGURATION SET QUERY_OPTIMIZER_HOTFIXES = OFF;
GO
USE [ProSoft-Septembar2021]
GO
/****** Object:  Table [dbo].[Intervencija]    Script Date: 21-Aug-21 21:09:44 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Intervencija](
	[IntervencijaID] [int] IDENTITY(1,1) NOT NULL,
	[DatumVremePocetka] [datetime] NULL,
	[DatumVremeZavrsetka] [datetime] NULL,
	[Opis] [nvarchar](255) NULL,
	[AngazovanjeIzvodjacaRadova] [bit] NULL,
	[Cena] [float] NULL,
	[Status] [nvarchar](255) NULL,
	[VrstaIntervencijeID] [int] NULL,
	[StambenaZajednicaID] [int] NULL,
	[UpravnikID] [int] NULL,
 CONSTRAINT [Intervencija$PrimaryKey] PRIMARY KEY CLUSTERED 
(
	[IntervencijaID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[StambenaZajednica]    Script Date: 21-Aug-21 21:09:44 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[StambenaZajednica](
	[StambenaZajednicaID] [int] IDENTITY(1,1) NOT NULL,
	[Naziv] [nvarchar](255) NULL,
	[Adresa] [nvarchar](255) NULL,
	[Mesto] [nvarchar](255) NULL,
	[UpravnikID] [int] NULL,
 CONSTRAINT [StambenaZajednica$PrimaryKey] PRIMARY KEY CLUSTERED 
(
	[StambenaZajednicaID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Upravnik]    Script Date: 21-Aug-21 21:09:44 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Upravnik](
	[UpravnikID] [int] IDENTITY(1,1) NOT NULL,
	[Ime] [nvarchar](255) NULL,
	[Prezime] [nvarchar](255) NULL,
	[KorisnickoIme] [nvarchar](255) NULL,
	[Lozinka] [nvarchar](255) NULL,
 CONSTRAINT [Upravnik$PrimaryKey] PRIMARY KEY CLUSTERED 
(
	[UpravnikID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[VrstaIntervencije]    Script Date: 21-Aug-21 21:09:44 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[VrstaIntervencije](
	[VrstaIntervencijeID] [int] IDENTITY(1,1) NOT NULL,
	[NazivVrste] [nvarchar](255) NULL,
 CONSTRAINT [VrstaIntervencije$PrimaryKey] PRIMARY KEY CLUSTERED 
(
	[VrstaIntervencijeID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET IDENTITY_INSERT [dbo].[Intervencija] ON 

INSERT [dbo].[Intervencija] ([IntervencijaID], [DatumVremePocetka], [DatumVremeZavrsetka], [Opis], [AngazovanjeIzvodjacaRadova], [Cena], [Status], [VrstaIntervencijeID], [StambenaZajednicaID], [UpravnikID]) VALUES (1, CAST(N'2021-08-19T09:00:00.000' AS DateTime), NULL, N'Godisnji servis', 1, 12000, N'Ceka', 1, 1, 1)
INSERT [dbo].[Intervencija] ([IntervencijaID], [DatumVremePocetka], [DatumVremeZavrsetka], [Opis], [AngazovanjeIzvodjacaRadova], [Cena], [Status], [VrstaIntervencijeID], [StambenaZajednicaID], [UpravnikID]) VALUES (2, CAST(N'2021-08-20T11:00:00.000' AS DateTime), NULL, N'Ciscenje ulaza zgrade', 1, 10000, N'Aktivna', 5, 2, 1)
INSERT [dbo].[Intervencija] ([IntervencijaID], [DatumVremePocetka], [DatumVremeZavrsetka], [Opis], [AngazovanjeIzvodjacaRadova], [Cena], [Status], [VrstaIntervencijeID], [StambenaZajednicaID], [UpravnikID]) VALUES (3, CAST(N'2021-08-21T11:00:00.000' AS DateTime), CAST(N'2021-08-21T13:00:00.000' AS DateTime), N'Servis lifta (sredjivanje okna)', 0, 20000, N'Zavrsena', 3, 3, 1)
INSERT [dbo].[Intervencija] ([IntervencijaID], [DatumVremePocetka], [DatumVremeZavrsetka], [Opis], [AngazovanjeIzvodjacaRadova], [Cena], [Status], [VrstaIntervencijeID], [StambenaZajednicaID], [UpravnikID]) VALUES (4, CAST(N'2021-08-22T10:00:00.000' AS DateTime), NULL, N'Servis agregata (rezervno napajanje)', 1, 8000, N'Aktivna', 4, 4, 2)
INSERT [dbo].[Intervencija] ([IntervencijaID], [DatumVremePocetka], [DatumVremeZavrsetka], [Opis], [AngazovanjeIzvodjacaRadova], [Cena], [Status], [VrstaIntervencijeID], [StambenaZajednicaID], [UpravnikID]) VALUES (5, CAST(N'2021-08-23T09:00:00.000' AS DateTime), CAST(N'2021-08-23T11:00:00.000' AS DateTime), N'Ciscenje ulaza', 1, 9500, N'Zavrsena', 5, 5, 2)
INSERT [dbo].[Intervencija] ([IntervencijaID], [DatumVremePocetka], [DatumVremeZavrsetka], [Opis], [AngazovanjeIzvodjacaRadova], [Cena], [Status], [VrstaIntervencijeID], [StambenaZajednicaID], [UpravnikID]) VALUES (7, CAST(N'2021-08-24T08:00:00.000' AS DateTime), CAST(N'2021-08-24T11:00:00.000' AS DateTime), N'Zamena LED sijalica u hodniku', 0, 2000, N'Zavrsena', 2, 6, 2)
INSERT [dbo].[Intervencija] ([IntervencijaID], [DatumVremePocetka], [DatumVremeZavrsetka], [Opis], [AngazovanjeIzvodjacaRadova], [Cena], [Status], [VrstaIntervencijeID], [StambenaZajednicaID], [UpravnikID]) VALUES (8, CAST(N'2021-08-01T00:00:00.000' AS DateTime), NULL, N'Avgust - Upravljanje SZ Jove Ilica 154', 0, 30000, N'Aktivna', 6, 1, 1)
INSERT [dbo].[Intervencija] ([IntervencijaID], [DatumVremePocetka], [DatumVremeZavrsetka], [Opis], [AngazovanjeIzvodjacaRadova], [Cena], [Status], [VrstaIntervencijeID], [StambenaZajednicaID], [UpravnikID]) VALUES (9, CAST(N'2021-08-01T00:00:00.000' AS DateTime), NULL, N'Avgust - Upravljanje SZ Maksima Gorkog 21', 0, 30000, N'Aktivna', 6, 2, 1)
INSERT [dbo].[Intervencija] ([IntervencijaID], [DatumVremePocetka], [DatumVremeZavrsetka], [Opis], [AngazovanjeIzvodjacaRadova], [Cena], [Status], [VrstaIntervencijeID], [StambenaZajednicaID], [UpravnikID]) VALUES (10, CAST(N'2021-08-01T00:00:00.000' AS DateTime), NULL, N'Avgust - Upravljanje SZ Takovska 20', 0, 30000, N'Aktivna', 6, 3, 1)
INSERT [dbo].[Intervencija] ([IntervencijaID], [DatumVremePocetka], [DatumVremeZavrsetka], [Opis], [AngazovanjeIzvodjacaRadova], [Cena], [Status], [VrstaIntervencijeID], [StambenaZajednicaID], [UpravnikID]) VALUES (11, CAST(N'2021-08-01T00:00:00.000' AS DateTime), NULL, N'Avgust - Upravljanje SZ Nehruova 11', 0, 25000, N'Aktivna', 6, 4, 2)
INSERT [dbo].[Intervencija] ([IntervencijaID], [DatumVremePocetka], [DatumVremeZavrsetka], [Opis], [AngazovanjeIzvodjacaRadova], [Cena], [Status], [VrstaIntervencijeID], [StambenaZajednicaID], [UpravnikID]) VALUES (12, CAST(N'2021-08-01T00:00:00.000' AS DateTime), NULL, N'Avgust - Upravljanje SZ Jurija Gagarina 10', 0, 25000, N'Aktivna', 6, 5, 2)
INSERT [dbo].[Intervencija] ([IntervencijaID], [DatumVremePocetka], [DatumVremeZavrsetka], [Opis], [AngazovanjeIzvodjacaRadova], [Cena], [Status], [VrstaIntervencijeID], [StambenaZajednicaID], [UpravnikID]) VALUES (13, CAST(N'2021-08-01T00:00:00.000' AS DateTime), NULL, N'Avgust - Upravljanje SZ Milutina Milankovica 37b', 0, 25000, N'Aktivna', 6, 6, 2)
SET IDENTITY_INSERT [dbo].[Intervencija] OFF
GO
SET IDENTITY_INSERT [dbo].[StambenaZajednica] ON 

INSERT [dbo].[StambenaZajednica] ([StambenaZajednicaID], [Naziv], [Adresa], [Mesto], [UpravnikID]) VALUES (1, N'SZ Jove Ilica 154', N'Jove Ilica 154', N'Beograd', 1)
INSERT [dbo].[StambenaZajednica] ([StambenaZajednicaID], [Naziv], [Adresa], [Mesto], [UpravnikID]) VALUES (2, N'SZ Maksima Gorkog 21', N'Maksima Gorkog 21', N'Beograd', 1)
INSERT [dbo].[StambenaZajednica] ([StambenaZajednicaID], [Naziv], [Adresa], [Mesto], [UpravnikID]) VALUES (3, N'SZ Takovska 20', N'Takovska 20', N'Beograd', 1)
INSERT [dbo].[StambenaZajednica] ([StambenaZajednicaID], [Naziv], [Adresa], [Mesto], [UpravnikID]) VALUES (4, N'SZ Nehruova 11', N'Nehruova 11', N'Beograd', 2)
INSERT [dbo].[StambenaZajednica] ([StambenaZajednicaID], [Naziv], [Adresa], [Mesto], [UpravnikID]) VALUES (5, N'SZ Jurija Gagarina 10', N'Jurija Gagarina 10', N'Beograd', 2)
INSERT [dbo].[StambenaZajednica] ([StambenaZajednicaID], [Naziv], [Adresa], [Mesto], [UpravnikID]) VALUES (6, N'SZ Milutina Milankovica 37b', N'Milutina Milankovica 37b', N'Beograd', 2)
SET IDENTITY_INSERT [dbo].[StambenaZajednica] OFF
GO
SET IDENTITY_INSERT [dbo].[Upravnik] ON 

INSERT [dbo].[Upravnik] ([UpravnikID], [Ime], [Prezime], [KorisnickoIme], [Lozinka]) VALUES (1, N'Ana', N'Antic', N'ana', N'ana1')
INSERT [dbo].[Upravnik] ([UpravnikID], [Ime], [Prezime], [KorisnickoIme], [Lozinka]) VALUES (2, N'Marko', N'Markovic', N'marko', N'marko1')
SET IDENTITY_INSERT [dbo].[Upravnik] OFF
GO
SET IDENTITY_INSERT [dbo].[VrstaIntervencije] ON 

INSERT [dbo].[VrstaIntervencije] ([VrstaIntervencijeID], [NazivVrste]) VALUES (1, N'Servis PP aparata i hidranata')
INSERT [dbo].[VrstaIntervencije] ([VrstaIntervencijeID], [NazivVrste]) VALUES (2, N'Popravka  elektro instalacija')
INSERT [dbo].[VrstaIntervencije] ([VrstaIntervencijeID], [NazivVrste]) VALUES (3, N'Odrzavanje lifta')
INSERT [dbo].[VrstaIntervencije] ([VrstaIntervencijeID], [NazivVrste]) VALUES (4, N'Odrzavanje agregata')
INSERT [dbo].[VrstaIntervencije] ([VrstaIntervencijeID], [NazivVrste]) VALUES (5, N'Ciscenje')
INSERT [dbo].[VrstaIntervencije] ([VrstaIntervencijeID], [NazivVrste]) VALUES (6, N'Upravljanje stambenom zajednicom')
SET IDENTITY_INSERT [dbo].[VrstaIntervencije] OFF
GO
/****** Object:  Index [Intervencija$IntervencijaID]    Script Date: 21-Aug-21 21:09:44 ******/
CREATE NONCLUSTERED INDEX [Intervencija$IntervencijaID] ON [dbo].[Intervencija]
(
	[IntervencijaID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, DROP_EXISTING = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
/****** Object:  Index [Intervencija$StambenaZajednicaID]    Script Date: 21-Aug-21 21:09:44 ******/
CREATE NONCLUSTERED INDEX [Intervencija$StambenaZajednicaID] ON [dbo].[Intervencija]
(
	[StambenaZajednicaID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, DROP_EXISTING = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
/****** Object:  Index [Intervencija$UpravnikID]    Script Date: 21-Aug-21 21:09:44 ******/
CREATE NONCLUSTERED INDEX [Intervencija$UpravnikID] ON [dbo].[Intervencija]
(
	[UpravnikID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, DROP_EXISTING = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
/****** Object:  Index [Intervencija$VrstaIntervencijeID]    Script Date: 21-Aug-21 21:09:44 ******/
CREATE NONCLUSTERED INDEX [Intervencija$VrstaIntervencijeID] ON [dbo].[Intervencija]
(
	[VrstaIntervencijeID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, DROP_EXISTING = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
/****** Object:  Index [StambenaZajednica$StambenaZajednicaID]    Script Date: 21-Aug-21 21:09:44 ******/
CREATE NONCLUSTERED INDEX [StambenaZajednica$StambenaZajednicaID] ON [dbo].[StambenaZajednica]
(
	[StambenaZajednicaID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, DROP_EXISTING = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
/****** Object:  Index [StambenaZajednica$UpravnikID]    Script Date: 21-Aug-21 21:09:44 ******/
CREATE NONCLUSTERED INDEX [StambenaZajednica$UpravnikID] ON [dbo].[StambenaZajednica]
(
	[UpravnikID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, DROP_EXISTING = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
/****** Object:  Index [Upravnik$UpravnikID]    Script Date: 21-Aug-21 21:09:44 ******/
CREATE NONCLUSTERED INDEX [Upravnik$UpravnikID] ON [dbo].[Upravnik]
(
	[UpravnikID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, DROP_EXISTING = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
ALTER TABLE [dbo].[Intervencija] ADD  CONSTRAINT [DF__Intervenc__Angaz__2D27B809]  DEFAULT ((0)) FOR [AngazovanjeIzvodjacaRadova]
GO
ALTER TABLE [dbo].[Intervencija] ADD  CONSTRAINT [DF__Intervenci__Cena__2E1BDC42]  DEFAULT ((0)) FOR [Cena]
GO
ALTER TABLE [dbo].[Intervencija] ADD  CONSTRAINT [DF__Intervenc__Vrsta__2F10007B]  DEFAULT ((0)) FOR [VrstaIntervencijeID]
GO
ALTER TABLE [dbo].[Intervencija] ADD  CONSTRAINT [DF__Intervenc__Stamb__300424B4]  DEFAULT ((0)) FOR [StambenaZajednicaID]
GO
ALTER TABLE [dbo].[Intervencija] ADD  CONSTRAINT [DF__Intervenc__Uprav__30F848ED]  DEFAULT ((0)) FOR [UpravnikID]
GO
ALTER TABLE [dbo].[StambenaZajednica] ADD  DEFAULT ((0)) FOR [UpravnikID]
GO
ALTER TABLE [dbo].[Intervencija]  WITH NOCHECK ADD  CONSTRAINT [Intervencija$StambenaZajednicaIntervencija] FOREIGN KEY([StambenaZajednicaID])
REFERENCES [dbo].[StambenaZajednica] ([StambenaZajednicaID])
GO
ALTER TABLE [dbo].[Intervencija] CHECK CONSTRAINT [Intervencija$StambenaZajednicaIntervencija]
GO
ALTER TABLE [dbo].[Intervencija]  WITH NOCHECK ADD  CONSTRAINT [Intervencija$UpravnikIntervencija] FOREIGN KEY([UpravnikID])
REFERENCES [dbo].[Upravnik] ([UpravnikID])
GO
ALTER TABLE [dbo].[Intervencija] CHECK CONSTRAINT [Intervencija$UpravnikIntervencija]
GO
ALTER TABLE [dbo].[Intervencija]  WITH NOCHECK ADD  CONSTRAINT [Intervencija$VrstaIntervencijeIntervencija] FOREIGN KEY([VrstaIntervencijeID])
REFERENCES [dbo].[VrstaIntervencije] ([VrstaIntervencijeID])
GO
ALTER TABLE [dbo].[Intervencija] CHECK CONSTRAINT [Intervencija$VrstaIntervencijeIntervencija]
GO
ALTER TABLE [dbo].[StambenaZajednica]  WITH NOCHECK ADD  CONSTRAINT [StambenaZajednica$UpravnikStambenaZajednica] FOREIGN KEY([UpravnikID])
REFERENCES [dbo].[Upravnik] ([UpravnikID])
GO
ALTER TABLE [dbo].[StambenaZajednica] CHECK CONSTRAINT [StambenaZajednica$UpravnikStambenaZajednica]
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Septembar2021.[Intervencija].[IntervencijaID]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'Intervencija', @level2type=N'COLUMN',@level2name=N'IntervencijaID'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Septembar2021.[Intervencija].[DatumVremePocetka]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'Intervencija', @level2type=N'COLUMN',@level2name=N'DatumVremePocetka'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Septembar2021.[Intervencija].[DatumVremeZavrsetka]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'Intervencija', @level2type=N'COLUMN',@level2name=N'DatumVremeZavrsetka'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Septembar2021.[Intervencija].[Opis]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'Intervencija', @level2type=N'COLUMN',@level2name=N'Opis'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Septembar2021.[Intervencija].[AngazovanjeIzvodjacaRadova]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'Intervencija', @level2type=N'COLUMN',@level2name=N'AngazovanjeIzvodjacaRadova'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Septembar2021.[Intervencija].[Cena]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'Intervencija', @level2type=N'COLUMN',@level2name=N'Cena'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Septembar2021.[Intervencija].[Status]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'Intervencija', @level2type=N'COLUMN',@level2name=N'Status'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Septembar2021.[Intervencija].[VrstaIntervencijeID]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'Intervencija', @level2type=N'COLUMN',@level2name=N'VrstaIntervencijeID'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Septembar2021.[Intervencija].[StambenaZajednicaID]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'Intervencija', @level2type=N'COLUMN',@level2name=N'StambenaZajednicaID'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Septembar2021.[Intervencija].[UpravnikID]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'Intervencija', @level2type=N'COLUMN',@level2name=N'UpravnikID'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Septembar2021.[Intervencija].[PrimaryKey]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'Intervencija', @level2type=N'CONSTRAINT',@level2name=N'Intervencija$PrimaryKey'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Septembar2021.[Intervencija].[IntervencijaID]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'Intervencija', @level2type=N'INDEX',@level2name=N'Intervencija$IntervencijaID'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Septembar2021.[Intervencija].[StambenaZajednicaID]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'Intervencija', @level2type=N'INDEX',@level2name=N'Intervencija$StambenaZajednicaID'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Septembar2021.[Intervencija].[UpravnikID]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'Intervencija', @level2type=N'INDEX',@level2name=N'Intervencija$UpravnikID'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Septembar2021.[Intervencija].[VrstaIntervencijeID]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'Intervencija', @level2type=N'INDEX',@level2name=N'Intervencija$VrstaIntervencijeID'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Septembar2021.[Intervencija]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'Intervencija'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Septembar2021.[Intervencija].[StambenaZajednicaIntervencija]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'Intervencija', @level2type=N'CONSTRAINT',@level2name=N'Intervencija$StambenaZajednicaIntervencija'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Septembar2021.[Intervencija].[UpravnikIntervencija]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'Intervencija', @level2type=N'CONSTRAINT',@level2name=N'Intervencija$UpravnikIntervencija'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Septembar2021.[Intervencija].[VrstaIntervencijeIntervencija]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'Intervencija', @level2type=N'CONSTRAINT',@level2name=N'Intervencija$VrstaIntervencijeIntervencija'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Septembar2021.[StambenaZajednica].[StambenaZajednicaID]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'StambenaZajednica', @level2type=N'COLUMN',@level2name=N'StambenaZajednicaID'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Septembar2021.[StambenaZajednica].[Naziv]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'StambenaZajednica', @level2type=N'COLUMN',@level2name=N'Naziv'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Septembar2021.[StambenaZajednica].[Adresa]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'StambenaZajednica', @level2type=N'COLUMN',@level2name=N'Adresa'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Septembar2021.[StambenaZajednica].[Mesto]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'StambenaZajednica', @level2type=N'COLUMN',@level2name=N'Mesto'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Septembar2021.[StambenaZajednica].[UpravnikID]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'StambenaZajednica', @level2type=N'COLUMN',@level2name=N'UpravnikID'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Septembar2021.[StambenaZajednica].[PrimaryKey]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'StambenaZajednica', @level2type=N'CONSTRAINT',@level2name=N'StambenaZajednica$PrimaryKey'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Septembar2021.[StambenaZajednica].[StambenaZajednicaID]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'StambenaZajednica', @level2type=N'INDEX',@level2name=N'StambenaZajednica$StambenaZajednicaID'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Septembar2021.[StambenaZajednica].[UpravnikID]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'StambenaZajednica', @level2type=N'INDEX',@level2name=N'StambenaZajednica$UpravnikID'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Septembar2021.[StambenaZajednica]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'StambenaZajednica'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Septembar2021.[StambenaZajednica].[UpravnikStambenaZajednica]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'StambenaZajednica', @level2type=N'CONSTRAINT',@level2name=N'StambenaZajednica$UpravnikStambenaZajednica'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Septembar2021.[Upravnik].[UpravnikID]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'Upravnik', @level2type=N'COLUMN',@level2name=N'UpravnikID'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Septembar2021.[Upravnik].[Ime]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'Upravnik', @level2type=N'COLUMN',@level2name=N'Ime'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Septembar2021.[Upravnik].[Prezime]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'Upravnik', @level2type=N'COLUMN',@level2name=N'Prezime'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Septembar2021.[Upravnik].[KorisnickoIme]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'Upravnik', @level2type=N'COLUMN',@level2name=N'KorisnickoIme'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Septembar2021.[Upravnik].[Lozinka]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'Upravnik', @level2type=N'COLUMN',@level2name=N'Lozinka'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Septembar2021.[Upravnik].[PrimaryKey]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'Upravnik', @level2type=N'CONSTRAINT',@level2name=N'Upravnik$PrimaryKey'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Septembar2021.[Upravnik].[UpravnikID]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'Upravnik', @level2type=N'INDEX',@level2name=N'Upravnik$UpravnikID'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Septembar2021.[Upravnik]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'Upravnik'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Septembar2021.[VrstaIntervencije].[VrstaIntervencijeID]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'VrstaIntervencije', @level2type=N'COLUMN',@level2name=N'VrstaIntervencijeID'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Septembar2021.[VrstaIntervencije].[NazivVrste]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'VrstaIntervencije', @level2type=N'COLUMN',@level2name=N'NazivVrste'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Septembar2021.[VrstaIntervencije].[PrimaryKey]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'VrstaIntervencije', @level2type=N'CONSTRAINT',@level2name=N'VrstaIntervencije$PrimaryKey'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Septembar2021.[VrstaIntervencije]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'VrstaIntervencije'
GO
USE [master]
GO
ALTER DATABASE [ProSoft-Septembar2021] SET  READ_WRITE 
GO
