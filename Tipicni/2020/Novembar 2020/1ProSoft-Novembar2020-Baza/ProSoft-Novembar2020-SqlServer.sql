USE [master]
GO
/****** Object:  Database [ProSoft-Novembar2020]    Script Date: 24-Nov-20 21:49:24 ******/
USE master
IF EXISTS(select * from sys.databases where name='ProSoft-Novembar2020')
DROP DATABASE [ProSoft-Novembar2020];
GO
CREATE DATABASE [ProSoft-Novembar2020];
GO
ALTER AUTHORIZATION ON DATABASE::[ProSoft-Novembar2020]TO sa
GO
USE [ProSoft-Novembar2020]
GO
ALTER DATABASE [ProSoft-Novembar2020] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [ProSoft-Novembar2020] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [ProSoft-Novembar2020] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [ProSoft-Novembar2020] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [ProSoft-Novembar2020] SET ARITHABORT OFF 
GO
ALTER DATABASE [ProSoft-Novembar2020] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [ProSoft-Novembar2020] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [ProSoft-Novembar2020] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [ProSoft-Novembar2020] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [ProSoft-Novembar2020] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [ProSoft-Novembar2020] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
GO
ALTER DATABASE [ProSoft-Novembar2020] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [ProSoft-Novembar2020] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [ProSoft-Novembar2020] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [ProSoft-Novembar2020] SET  DISABLE_BROKER 
GO
ALTER DATABASE [ProSoft-Novembar2020] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [ProSoft-Novembar2020] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [ProSoft-Novembar2020] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [ProSoft-Novembar2020] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [ProSoft-Novembar2020] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [ProSoft-Novembar2020] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [ProSoft-Novembar2020] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [ProSoft-Novembar2020] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [ProSoft-Novembar2020] SET  MULTI_USER 
GO
ALTER DATABASE [ProSoft-Novembar2020] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [ProSoft-Novembar2020] SET DB_CHAINING OFF 
GO
ALTER DATABASE [ProSoft-Novembar2020] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [ProSoft-Novembar2020] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [ProSoft-Novembar2020] SET DELAYED_DURABILITY = DISABLED 
GO
ALTER DATABASE [ProSoft-Novembar2020] SET QUERY_STORE = OFF
GO
USE [ProSoft-Novembar2020]
GO
ALTER DATABASE SCOPED CONFIGURATION SET LEGACY_CARDINALITY_ESTIMATION = OFF;
GO
ALTER DATABASE SCOPED CONFIGURATION SET MAXDOP = 0;
GO
ALTER DATABASE SCOPED CONFIGURATION SET PARAMETER_SNIFFING = ON;
GO
ALTER DATABASE SCOPED CONFIGURATION SET QUERY_OPTIMIZER_HOTFIXES = OFF;
GO
USE [ProSoft-Novembar2020]
GO
/****** Object:  Table [dbo].[Dogadjaj]    Script Date: 24-Nov-20 21:49:25 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Dogadjaj](
	[DogadjajID] [int] IDENTITY(1,1) NOT NULL,
	[Naziv] [nvarchar](255) NULL,
	[Opis] [nvarchar](255) NULL,
	[DatumOd] [datetime] NULL,
	[DatumDo] [datetime] NULL,
	[TipDogadjaja] [nvarchar](255) NULL,
	[KorisnikOrganizatorID] [int] NULL,
 CONSTRAINT [Dogadjaj$PrimaryKey] PRIMARY KEY CLUSTERED 
(
	[DogadjajID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Korisnik]    Script Date: 24-Nov-20 21:49:25 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Korisnik](
	[KorisnikID] [int] NOT NULL,
	[Ime] [nvarchar](255) NULL,
	[Prezime] [nvarchar](255) NULL,
	[KorisnickoIme] [nvarchar](255) NULL,
	[Lozinka] [nvarchar](255) NULL,
 CONSTRAINT [Korisnik$PrimaryKey] PRIMARY KEY CLUSTERED 
(
	[KorisnikID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Ucesce]    Script Date: 24-Nov-20 21:49:25 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Ucesce](
	[DogadjajID] [int] NOT NULL,
	[RB] [int] NOT NULL,
	[OpisUcesca] [nvarchar](255) NULL,
	[ObaveznoPrisustvo] [bit] NULL,
	[KorisnikID] [int] NULL,
 CONSTRAINT [Ucesce$PrimaryKey] PRIMARY KEY CLUSTERED 
(
	[DogadjajID] ASC,
	[RB] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET IDENTITY_INSERT [dbo].[Dogadjaj] ON 

INSERT [dbo].[Dogadjaj] ([DogadjajID], [Naziv], [Opis], [DatumOd], [DatumDo], [TipDogadjaja], [KorisnikOrganizatorID]) VALUES (1, N'IT projekat', N'Inicijalni sastanak', CAST(N'2020-11-22T11:00:00.000' AS DateTime), CAST(N'2020-11-22T11:30:00.000' AS DateTime), N'Sastanak', 1)
SET IDENTITY_INSERT [dbo].[Dogadjaj] OFF
INSERT [dbo].[Korisnik] ([KorisnikID], [Ime], [Prezime], [KorisnickoIme], [Lozinka]) VALUES (1, N'Marko', N'Markovic', N'marko', N'marko123')
INSERT [dbo].[Korisnik] ([KorisnikID], [Ime], [Prezime], [KorisnickoIme], [Lozinka]) VALUES (2, N'Ivana', N'Ivanovic', N'ivana', N'ivana123')
INSERT [dbo].[Korisnik] ([KorisnikID], [Ime], [Prezime], [KorisnickoIme], [Lozinka]) VALUES (3, N'Dragan', N'Draganic', N'dragan', N'dragan123')
INSERT [dbo].[Korisnik] ([KorisnikID], [Ime], [Prezime], [KorisnickoIme], [Lozinka]) VALUES (4, N'Petra', N'Petrovic', N'petra', N'petra')
INSERT [dbo].[Korisnik] ([KorisnikID], [Ime], [Prezime], [KorisnickoIme], [Lozinka]) VALUES (5, N'Dusan', N'Dusanic', N'dusan', N'dusan123')
INSERT [dbo].[Korisnik] ([KorisnikID], [Ime], [Prezime], [KorisnickoIme], [Lozinka]) VALUES (6, N'Marija', N'Maric', N'marija', N'marija123')
INSERT [dbo].[Ucesce] ([DogadjajID], [RB], [OpisUcesca], [ObaveznoPrisustvo], [KorisnikID]) VALUES (1, 1, N'Izrada zapisnika', 1, 2)
/****** Object:  Index [Dogadjaj$DogadjajID]    Script Date: 24-Nov-20 21:49:25 ******/
CREATE NONCLUSTERED INDEX [Dogadjaj$DogadjajID] ON [dbo].[Dogadjaj]
(
	[DogadjajID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, DROP_EXISTING = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
/****** Object:  Index [Dogadjaj$KorisnikDogadjaj]    Script Date: 24-Nov-20 21:49:25 ******/
CREATE NONCLUSTERED INDEX [Dogadjaj$KorisnikDogadjaj] ON [dbo].[Dogadjaj]
(
	[KorisnikOrganizatorID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, DROP_EXISTING = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
/****** Object:  Index [Dogadjaj$KorisnikOrganizatorID]    Script Date: 24-Nov-20 21:49:25 ******/
CREATE NONCLUSTERED INDEX [Dogadjaj$KorisnikOrganizatorID] ON [dbo].[Dogadjaj]
(
	[KorisnikOrganizatorID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, DROP_EXISTING = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
/****** Object:  Index [Korisnik$KorisnikID]    Script Date: 24-Nov-20 21:49:25 ******/
CREATE NONCLUSTERED INDEX [Korisnik$KorisnikID] ON [dbo].[Korisnik]
(
	[KorisnikID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, DROP_EXISTING = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
/****** Object:  Index [Ucesce$DogadjajID]    Script Date: 24-Nov-20 21:49:25 ******/
CREATE NONCLUSTERED INDEX [Ucesce$DogadjajID] ON [dbo].[Ucesce]
(
	[DogadjajID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, DROP_EXISTING = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
/****** Object:  Index [Ucesce$DogadjajUcesce]    Script Date: 24-Nov-20 21:49:25 ******/
CREATE NONCLUSTERED INDEX [Ucesce$DogadjajUcesce] ON [dbo].[Ucesce]
(
	[DogadjajID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, DROP_EXISTING = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
/****** Object:  Index [Ucesce$KorisnikID]    Script Date: 24-Nov-20 21:49:25 ******/
CREATE NONCLUSTERED INDEX [Ucesce$KorisnikID] ON [dbo].[Ucesce]
(
	[KorisnikID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, DROP_EXISTING = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
/****** Object:  Index [Ucesce$KorisnikUcesce]    Script Date: 24-Nov-20 21:49:25 ******/
CREATE NONCLUSTERED INDEX [Ucesce$KorisnikUcesce] ON [dbo].[Ucesce]
(
	[KorisnikID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, DROP_EXISTING = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
ALTER TABLE [dbo].[Dogadjaj] ADD  CONSTRAINT [DF__Dogadjaj__Korisn__2A4B4B5E]  DEFAULT ((0)) FOR [KorisnikOrganizatorID]
GO
ALTER TABLE [dbo].[Korisnik] ADD  DEFAULT ((0)) FOR [KorisnikID]
GO
ALTER TABLE [dbo].[Ucesce] ADD  DEFAULT ((0)) FOR [DogadjajID]
GO
ALTER TABLE [dbo].[Ucesce] ADD  DEFAULT ((0)) FOR [RB]
GO
ALTER TABLE [dbo].[Ucesce] ADD  DEFAULT ((0)) FOR [ObaveznoPrisustvo]
GO
ALTER TABLE [dbo].[Ucesce] ADD  DEFAULT ((0)) FOR [KorisnikID]
GO
ALTER TABLE [dbo].[Dogadjaj]  WITH NOCHECK ADD  CONSTRAINT [Dogadjaj$KorisnikDogadjaj] FOREIGN KEY([KorisnikOrganizatorID])
REFERENCES [dbo].[Korisnik] ([KorisnikID])
GO
ALTER TABLE [dbo].[Dogadjaj] CHECK CONSTRAINT [Dogadjaj$KorisnikDogadjaj]
GO
ALTER TABLE [dbo].[Ucesce]  WITH NOCHECK ADD  CONSTRAINT [Ucesce$DogadjajUcesce] FOREIGN KEY([DogadjajID])
REFERENCES [dbo].[Dogadjaj] ([DogadjajID])
GO
ALTER TABLE [dbo].[Ucesce] CHECK CONSTRAINT [Ucesce$DogadjajUcesce]
GO
ALTER TABLE [dbo].[Ucesce]  WITH NOCHECK ADD  CONSTRAINT [Ucesce$KorisnikUcesce] FOREIGN KEY([KorisnikID])
REFERENCES [dbo].[Korisnik] ([KorisnikID])
GO
ALTER TABLE [dbo].[Ucesce] CHECK CONSTRAINT [Ucesce$KorisnikUcesce]
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Novembar2020.[Dogadjaj].[DogadjajID]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'Dogadjaj', @level2type=N'COLUMN',@level2name=N'DogadjajID'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Novembar2020.[Dogadjaj].[Naziv]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'Dogadjaj', @level2type=N'COLUMN',@level2name=N'Naziv'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Novembar2020.[Dogadjaj].[Opis]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'Dogadjaj', @level2type=N'COLUMN',@level2name=N'Opis'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Novembar2020.[Dogadjaj].[DatumOd]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'Dogadjaj', @level2type=N'COLUMN',@level2name=N'DatumOd'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Novembar2020.[Dogadjaj].[DatumDo]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'Dogadjaj', @level2type=N'COLUMN',@level2name=N'DatumDo'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Novembar2020.[Dogadjaj].[TipDogadjaja]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'Dogadjaj', @level2type=N'COLUMN',@level2name=N'TipDogadjaja'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Novembar2020.[Dogadjaj].[KorisnikOrganizatorID]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'Dogadjaj', @level2type=N'COLUMN',@level2name=N'KorisnikOrganizatorID'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Novembar2020.[Dogadjaj].[PrimaryKey]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'Dogadjaj', @level2type=N'CONSTRAINT',@level2name=N'Dogadjaj$PrimaryKey'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Novembar2020.[Dogadjaj].[DogadjajID]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'Dogadjaj', @level2type=N'INDEX',@level2name=N'Dogadjaj$DogadjajID'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Novembar2020.[Dogadjaj].[KorisnikDogadjaj]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'Dogadjaj', @level2type=N'INDEX',@level2name=N'Dogadjaj$KorisnikDogadjaj'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Novembar2020.[Dogadjaj].[KorisnikOrganizatorID]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'Dogadjaj', @level2type=N'INDEX',@level2name=N'Dogadjaj$KorisnikOrganizatorID'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Novembar2020.[Dogadjaj]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'Dogadjaj'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Novembar2020.[Dogadjaj].[KorisnikDogadjaj]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'Dogadjaj', @level2type=N'CONSTRAINT',@level2name=N'Dogadjaj$KorisnikDogadjaj'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Novembar2020.[Korisnik].[KorisnikID]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'Korisnik', @level2type=N'COLUMN',@level2name=N'KorisnikID'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Novembar2020.[Korisnik].[Ime]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'Korisnik', @level2type=N'COLUMN',@level2name=N'Ime'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Novembar2020.[Korisnik].[Prezime]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'Korisnik', @level2type=N'COLUMN',@level2name=N'Prezime'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Novembar2020.[Korisnik].[KorisnickoIme]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'Korisnik', @level2type=N'COLUMN',@level2name=N'KorisnickoIme'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Novembar2020.[Korisnik].[Lozinka]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'Korisnik', @level2type=N'COLUMN',@level2name=N'Lozinka'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Novembar2020.[Korisnik].[PrimaryKey]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'Korisnik', @level2type=N'CONSTRAINT',@level2name=N'Korisnik$PrimaryKey'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Novembar2020.[Korisnik].[KorisnikID]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'Korisnik', @level2type=N'INDEX',@level2name=N'Korisnik$KorisnikID'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Novembar2020.[Korisnik]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'Korisnik'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Novembar2020.[Ucesce].[DogadjajID]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'Ucesce', @level2type=N'COLUMN',@level2name=N'DogadjajID'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Novembar2020.[Ucesce].[RB]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'Ucesce', @level2type=N'COLUMN',@level2name=N'RB'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Novembar2020.[Ucesce].[OpisUcesca]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'Ucesce', @level2type=N'COLUMN',@level2name=N'OpisUcesca'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Novembar2020.[Ucesce].[ObaveznoPrisustvo]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'Ucesce', @level2type=N'COLUMN',@level2name=N'ObaveznoPrisustvo'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Novembar2020.[Ucesce].[KorisnikID]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'Ucesce', @level2type=N'COLUMN',@level2name=N'KorisnikID'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Novembar2020.[Ucesce].[PrimaryKey]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'Ucesce', @level2type=N'CONSTRAINT',@level2name=N'Ucesce$PrimaryKey'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Novembar2020.[Ucesce].[DogadjajID]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'Ucesce', @level2type=N'INDEX',@level2name=N'Ucesce$DogadjajID'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Novembar2020.[Ucesce].[DogadjajUcesce]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'Ucesce', @level2type=N'INDEX',@level2name=N'Ucesce$DogadjajUcesce'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Novembar2020.[Ucesce].[KorisnikID]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'Ucesce', @level2type=N'INDEX',@level2name=N'Ucesce$KorisnikID'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Novembar2020.[Ucesce].[KorisnikUcesce]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'Ucesce', @level2type=N'INDEX',@level2name=N'Ucesce$KorisnikUcesce'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Novembar2020.[Ucesce]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'Ucesce'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Novembar2020.[Ucesce].[DogadjajUcesce]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'Ucesce', @level2type=N'CONSTRAINT',@level2name=N'Ucesce$DogadjajUcesce'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Novembar2020.[Ucesce].[KorisnikUcesce]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'Ucesce', @level2type=N'CONSTRAINT',@level2name=N'Ucesce$KorisnikUcesce'
GO
USE [master]
GO
ALTER DATABASE [ProSoft-Novembar2020] SET  READ_WRITE 
GO
