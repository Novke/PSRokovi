USE [master]
GO
/****** Object:  Database [ProSoft-Mart2022]    Script Date: 31-Mar-22 21:29:44 ******/
CREATE DATABASE [ProSoft-Mart2022]
GO
ALTER DATABASE [ProSoft-Mart2022] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [ProSoft-Mart2022] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [ProSoft-Mart2022] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [ProSoft-Mart2022] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [ProSoft-Mart2022] SET ARITHABORT OFF 
GO
ALTER DATABASE [ProSoft-Mart2022] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [ProSoft-Mart2022] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [ProSoft-Mart2022] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [ProSoft-Mart2022] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [ProSoft-Mart2022] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [ProSoft-Mart2022] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [ProSoft-Mart2022] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [ProSoft-Mart2022] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [ProSoft-Mart2022] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [ProSoft-Mart2022] SET  DISABLE_BROKER 
GO
ALTER DATABASE [ProSoft-Mart2022] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [ProSoft-Mart2022] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [ProSoft-Mart2022] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [ProSoft-Mart2022] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [ProSoft-Mart2022] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [ProSoft-Mart2022] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [ProSoft-Mart2022] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [ProSoft-Mart2022] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [ProSoft-Mart2022] SET  MULTI_USER 
GO
ALTER DATABASE [ProSoft-Mart2022] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [ProSoft-Mart2022] SET DB_CHAINING OFF 
GO
ALTER DATABASE [ProSoft-Mart2022] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [ProSoft-Mart2022] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [ProSoft-Mart2022] SET DELAYED_DURABILITY = DISABLED 
GO
ALTER DATABASE [ProSoft-Mart2022] SET QUERY_STORE = OFF
GO
USE [ProSoft-Mart2022]
GO
ALTER DATABASE SCOPED CONFIGURATION SET LEGACY_CARDINALITY_ESTIMATION = OFF;
GO
ALTER DATABASE SCOPED CONFIGURATION SET MAXDOP = 0;
GO
ALTER DATABASE SCOPED CONFIGURATION SET PARAMETER_SNIFFING = ON;
GO
ALTER DATABASE SCOPED CONFIGURATION SET QUERY_OPTIMIZER_HOTFIXES = OFF;
GO
USE [ProSoft-Mart2022]
GO
/****** Object:  Table [dbo].[Delo]    Script Date: 31-Mar-22 21:29:44 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Delo](
	[DeloID] [int] IDENTITY(1,1) NOT NULL,
	[Naziv] [nvarchar](255) NULL,
 CONSTRAINT [Delo$PrimaryKey] PRIMARY KEY CLUSTERED 
(
	[DeloID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Festival]    Script Date: 31-Mar-22 21:29:44 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Festival](
	[FestivalID] [int] NOT NULL,
	[Naziv] [nvarchar](255) NULL,
	[DatumOd] [datetime] NULL,
	[DatumDo] [datetime] NULL,
	[Opis] [nvarchar](255) NULL,
	[Korisnik] [nvarchar](255) NULL,
 CONSTRAINT [Festival$PrimaryKey] PRIMARY KEY CLUSTERED 
(
	[FestivalID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Izvodjenje]    Script Date: 31-Mar-22 21:29:44 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Izvodjenje](
	[FestivalID] [int] NOT NULL,
	[DeloID] [int] NOT NULL,
	[DatumVremePocetka] [datetime] NULL,
	[DatumVremeKraja] [datetime] NULL,
	[Sala] [nvarchar](255) NULL,
 CONSTRAINT [Izvodjenje$PrimaryKey] PRIMARY KEY CLUSTERED 
(
	[FestivalID] ASC,
	[DeloID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Koncert]    Script Date: 31-Mar-22 21:29:44 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Koncert](
	[DeloID] [int] NOT NULL,
	[Izvodjac] [nvarchar](255) NULL,
	[Program] [nvarchar](255) NULL,
 CONSTRAINT [Koncert$PrimaryKey] PRIMARY KEY CLUSTERED 
(
	[DeloID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Predstava]    Script Date: 31-Mar-22 21:29:44 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Predstava](
	[DeloID] [int] NOT NULL,
	[Reditelj] [nvarchar](255) NULL,
	[Podela] [nvarchar](255) NULL,
	[Size] [nvarchar](255) NULL,
 CONSTRAINT [Predstava$PrimaryKey] PRIMARY KEY CLUSTERED 
(
	[DeloID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET IDENTITY_INSERT [dbo].[Delo] ON 

INSERT [dbo].[Delo] ([DeloID], [Naziv]) VALUES (1, N'Klasici')
INSERT [dbo].[Delo] ([DeloID], [Naziv]) VALUES (2, N'BEMUS podijum mladih')
INSERT [dbo].[Delo] ([DeloID], [Naziv]) VALUES (3, N'Dečja soba')
INSERT [dbo].[Delo] ([DeloID], [Naziv]) VALUES (4, N'Antigona')
INSERT [dbo].[Delo] ([DeloID], [Naziv]) VALUES (5, N'Legenda o hrabrosti')
INSERT [dbo].[Delo] ([DeloID], [Naziv]) VALUES (6, N'S ove strane muzike')
INSERT [dbo].[Delo] ([DeloID], [Naziv]) VALUES (7, N'Kao da sam te sanjao')
INSERT [dbo].[Delo] ([DeloID], [Naziv]) VALUES (8, N'Crvenkapa')
SET IDENTITY_INSERT [dbo].[Delo] OFF
GO
INSERT [dbo].[Festival] ([FestivalID], [Naziv], [DatumOd], [DatumDo], [Opis], [Korisnik]) VALUES (1, N'BELEF 2022', CAST(N'2022-07-01T00:00:00.000' AS DateTime), CAST(N'2022-07-11T00:00:00.000' AS DateTime), N'Beogradski letnji festival', NULL)
INSERT [dbo].[Festival] ([FestivalID], [Naziv], [DatumOd], [DatumDo], [Opis], [Korisnik]) VALUES (2, N'BEMUS 2022', CAST(N'2022-11-01T00:00:00.000' AS DateTime), CAST(N'2022-11-11T00:00:00.000' AS DateTime), N'Beogradske muzičke svečanosti', NULL)
INSERT [dbo].[Festival] ([FestivalID], [Naziv], [DatumOd], [DatumDo], [Opis], [Korisnik]) VALUES (3, N'BEKUS 2022', CAST(N'2022-03-31T00:00:00.000' AS DateTime), CAST(N'2022-04-07T00:00:00.000' AS DateTime), N'Beogradske kulturne svečanosti', NULL)
GO
INSERT [dbo].[Koncert] ([DeloID], [Izvodjac], [Program]) VALUES (1, N'Nemanja Radulović', N'Glinka, Prokofjev, Rahmanjinov')
INSERT [dbo].[Koncert] ([DeloID], [Izvodjac], [Program]) VALUES (2, N'Petar Pejčić, Natalija Mladenović', N'Šubert, Kasado, Pjacola')
INSERT [dbo].[Koncert] ([DeloID], [Izvodjac], [Program]) VALUES (3, N'Muzičko opersko teatarska organizacija MOTO', N'Opera Dečja soba Milenka Živkovića')
GO
INSERT [dbo].[Predstava] ([DeloID], [Reditelj], [Podela], [Size]) VALUES (4, N'Lenka Udovički', N'Antigona - Maja Izetbegović, Izmena - Dženana Džanić, Kreont - Rade Šerbedžija', N'Predstava scenski ispituje mitsku priču iz Sofokleovog komada')
INSERT [dbo].[Predstava] ([DeloID], [Reditelj], [Podela], [Size]) VALUES (5, N'Mateja Popović', N'Krungla - Vaja Dujović, Nemezi - Anđela Jovanović, Gljinko Alkrah - Ivan Mihajlović', N'U sebičnoj i nesebičnoj poteri protagonista i antagonista za onim za čime žude obrađena je ideja morala i pravih vrednosti')
INSERT [dbo].[Predstava] ([DeloID], [Reditelj], [Podela], [Size]) VALUES (6, N'Nevena Ivanović', N'Hor Dečjeg kulturnog centra u Beogradu', N'Muzička predstava približava tonove i odnose među njima deci')
INSERT [dbo].[Predstava] ([DeloID], [Reditelj], [Podela], [Size]) VALUES (7, N'Dragana Draganić', N'Vladan Savić, Kristina Savić, Uroš Ranković', N'Predstava je zamišljena kao muzičko-poetsko veče, protagonosti u formi monologa govore i pevaju stihove poznatih srpskih i svetskih pesnika')
INSERT [dbo].[Predstava] ([DeloID], [Reditelj], [Podela], [Size]) VALUES (8, N'Sonja Knežević', N'Crvenkapa - Zlatija Ivanović-Ocokoljić, Baka i mama - Sonja Knežević, Vuk - Dejan Stojaković', N'Priča o poverenju i prijateljstvu')
GO
/****** Object:  Index [Delo$DeloID]    Script Date: 31-Mar-22 21:29:44 ******/
CREATE NONCLUSTERED INDEX [Delo$DeloID] ON [dbo].[Delo]
(
	[DeloID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, DROP_EXISTING = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
/****** Object:  Index [Festival$FestivalID]    Script Date: 31-Mar-22 21:29:44 ******/
CREATE NONCLUSTERED INDEX [Festival$FestivalID] ON [dbo].[Festival]
(
	[FestivalID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, DROP_EXISTING = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
/****** Object:  Index [Izvodjenje$DeloID]    Script Date: 31-Mar-22 21:29:44 ******/
CREATE NONCLUSTERED INDEX [Izvodjenje$DeloID] ON [dbo].[Izvodjenje]
(
	[DeloID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, DROP_EXISTING = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
/****** Object:  Index [Izvodjenje$FestivalID]    Script Date: 31-Mar-22 21:29:44 ******/
CREATE NONCLUSTERED INDEX [Izvodjenje$FestivalID] ON [dbo].[Izvodjenje]
(
	[FestivalID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, DROP_EXISTING = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
/****** Object:  Index [Koncert$DeloID]    Script Date: 31-Mar-22 21:29:44 ******/
CREATE NONCLUSTERED INDEX [Koncert$DeloID] ON [dbo].[Koncert]
(
	[DeloID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, DROP_EXISTING = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
/****** Object:  Index [Koncert$DeloKoncert]    Script Date: 31-Mar-22 21:29:44 ******/
CREATE UNIQUE NONCLUSTERED INDEX [Koncert$DeloKoncert] ON [dbo].[Koncert]
(
	[DeloID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, DROP_EXISTING = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
/****** Object:  Index [Predstava$DeloPredstava]    Script Date: 31-Mar-22 21:29:44 ******/
CREATE UNIQUE NONCLUSTERED INDEX [Predstava$DeloPredstava] ON [dbo].[Predstava]
(
	[DeloID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, DROP_EXISTING = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
ALTER TABLE [dbo].[Festival] ADD  CONSTRAINT [DF__Festival__Festiv__2F10007B]  DEFAULT ((0)) FOR [FestivalID]
GO
ALTER TABLE [dbo].[Izvodjenje] ADD  CONSTRAINT [DF__Izvodjenj__Festi__300424B4]  DEFAULT ((0)) FOR [FestivalID]
GO
ALTER TABLE [dbo].[Izvodjenje] ADD  CONSTRAINT [DF__Izvodjenj__DeloI__30F848ED]  DEFAULT ((0)) FOR [DeloID]
GO
ALTER TABLE [dbo].[Koncert] ADD  DEFAULT ((0)) FOR [DeloID]
GO
ALTER TABLE [dbo].[Predstava] ADD  DEFAULT ((0)) FOR [DeloID]
GO
ALTER TABLE [dbo].[Izvodjenje]  WITH CHECK ADD  CONSTRAINT [Izvodjenje$DeloIzvodjenje] FOREIGN KEY([DeloID])
REFERENCES [dbo].[Delo] ([DeloID])
GO
ALTER TABLE [dbo].[Izvodjenje] CHECK CONSTRAINT [Izvodjenje$DeloIzvodjenje]
GO
ALTER TABLE [dbo].[Izvodjenje]  WITH CHECK ADD  CONSTRAINT [Izvodjenje$FestivalIzvodjenje] FOREIGN KEY([FestivalID])
REFERENCES [dbo].[Festival] ([FestivalID])
GO
ALTER TABLE [dbo].[Izvodjenje] CHECK CONSTRAINT [Izvodjenje$FestivalIzvodjenje]
GO
ALTER TABLE [dbo].[Koncert]  WITH NOCHECK ADD  CONSTRAINT [Koncert$DeloKoncert] FOREIGN KEY([DeloID])
REFERENCES [dbo].[Delo] ([DeloID])
GO
ALTER TABLE [dbo].[Koncert] CHECK CONSTRAINT [Koncert$DeloKoncert]
GO
ALTER TABLE [dbo].[Predstava]  WITH NOCHECK ADD  CONSTRAINT [Predstava$DeloPredstava] FOREIGN KEY([DeloID])
REFERENCES [dbo].[Delo] ([DeloID])
GO
ALTER TABLE [dbo].[Predstava] CHECK CONSTRAINT [Predstava$DeloPredstava]
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Mart2022.[Delo].[DeloID]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'Delo', @level2type=N'COLUMN',@level2name=N'DeloID'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Mart2022.[Delo].[Naziv]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'Delo', @level2type=N'COLUMN',@level2name=N'Naziv'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Mart2022.[Delo].[PrimaryKey]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'Delo', @level2type=N'CONSTRAINT',@level2name=N'Delo$PrimaryKey'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Mart2022.[Delo].[DeloID]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'Delo', @level2type=N'INDEX',@level2name=N'Delo$DeloID'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Mart2022.[Delo]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'Delo'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Mart2022.[Festival].[FestivalID]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'Festival', @level2type=N'COLUMN',@level2name=N'FestivalID'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Mart2022.[Festival].[Naziv]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'Festival', @level2type=N'COLUMN',@level2name=N'Naziv'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Mart2022.[Festival].[DatumOd]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'Festival', @level2type=N'COLUMN',@level2name=N'DatumOd'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Mart2022.[Festival].[DatumDo]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'Festival', @level2type=N'COLUMN',@level2name=N'DatumDo'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Mart2022.[Festival].[Opis]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'Festival', @level2type=N'COLUMN',@level2name=N'Opis'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Mart2022.[Festival].[Korisnik]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'Festival', @level2type=N'COLUMN',@level2name=N'Korisnik'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Mart2022.[Festival].[PrimaryKey]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'Festival', @level2type=N'CONSTRAINT',@level2name=N'Festival$PrimaryKey'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Mart2022.[Festival].[FestivalID]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'Festival', @level2type=N'INDEX',@level2name=N'Festival$FestivalID'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Mart2022.[Festival]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'Festival'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Mart2022.[Izvodjenje].[FestivalID]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'Izvodjenje', @level2type=N'COLUMN',@level2name=N'FestivalID'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Mart2022.[Izvodjenje].[DeloID]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'Izvodjenje', @level2type=N'COLUMN',@level2name=N'DeloID'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Mart2022.[Izvodjenje].[DatumVremePocetka]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'Izvodjenje', @level2type=N'COLUMN',@level2name=N'DatumVremePocetka'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Mart2022.[Izvodjenje].[DatumVremeKraja]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'Izvodjenje', @level2type=N'COLUMN',@level2name=N'DatumVremeKraja'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Mart2022.[Izvodjenje].[Sala]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'Izvodjenje', @level2type=N'COLUMN',@level2name=N'Sala'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Mart2022.[Izvodjenje].[PrimaryKey]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'Izvodjenje', @level2type=N'CONSTRAINT',@level2name=N'Izvodjenje$PrimaryKey'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Mart2022.[Izvodjenje].[DeloID]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'Izvodjenje', @level2type=N'INDEX',@level2name=N'Izvodjenje$DeloID'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Mart2022.[Izvodjenje].[FestivalID]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'Izvodjenje', @level2type=N'INDEX',@level2name=N'Izvodjenje$FestivalID'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Mart2022.[Izvodjenje]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'Izvodjenje'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Mart2022.[Izvodjenje].[DeloIzvodjenje]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'Izvodjenje', @level2type=N'CONSTRAINT',@level2name=N'Izvodjenje$DeloIzvodjenje'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Mart2022.[Izvodjenje].[FestivalIzvodjenje]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'Izvodjenje', @level2type=N'CONSTRAINT',@level2name=N'Izvodjenje$FestivalIzvodjenje'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Mart2022.[Koncert].[DeloID]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'Koncert', @level2type=N'COLUMN',@level2name=N'DeloID'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Mart2022.[Koncert].[Izvodjac]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'Koncert', @level2type=N'COLUMN',@level2name=N'Izvodjac'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Mart2022.[Koncert].[Program]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'Koncert', @level2type=N'COLUMN',@level2name=N'Program'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Mart2022.[Koncert].[PrimaryKey]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'Koncert', @level2type=N'CONSTRAINT',@level2name=N'Koncert$PrimaryKey'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Mart2022.[Koncert].[DeloID]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'Koncert', @level2type=N'INDEX',@level2name=N'Koncert$DeloID'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Mart2022.[Koncert].[DeloKoncert]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'Koncert', @level2type=N'INDEX',@level2name=N'Koncert$DeloKoncert'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Mart2022.[Koncert]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'Koncert'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Mart2022.[Koncert].[DeloKoncert]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'Koncert', @level2type=N'CONSTRAINT',@level2name=N'Koncert$DeloKoncert'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Mart2022.[Predstava].[DeloID]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'Predstava', @level2type=N'COLUMN',@level2name=N'DeloID'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Mart2022.[Predstava].[Reditelj]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'Predstava', @level2type=N'COLUMN',@level2name=N'Reditelj'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Mart2022.[Predstava].[Podela]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'Predstava', @level2type=N'COLUMN',@level2name=N'Podela'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Mart2022.[Predstava].[Size]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'Predstava', @level2type=N'COLUMN',@level2name=N'Size'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Mart2022.[Predstava].[PrimaryKey]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'Predstava', @level2type=N'CONSTRAINT',@level2name=N'Predstava$PrimaryKey'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Mart2022.[Predstava].[DeloPredstava]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'Predstava', @level2type=N'INDEX',@level2name=N'Predstava$DeloPredstava'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Mart2022.[Predstava]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'Predstava'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Mart2022.[Predstava].[DeloPredstava]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'Predstava', @level2type=N'CONSTRAINT',@level2name=N'Predstava$DeloPredstava'
GO
USE [master]
GO
ALTER DATABASE [ProSoft-Mart2022] SET  READ_WRITE 
GO
