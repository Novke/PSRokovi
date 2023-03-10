USE [master]
GO
/****** Object:  Database [ProSoft-Februar2022]    Script Date: 08-Feb-22 20:53:32 ******/
CREATE DATABASE [ProSoft-Februar2022]
GO
ALTER DATABASE [ProSoft-Februar2022] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [ProSoft-Februar2022] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [ProSoft-Februar2022] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [ProSoft-Februar2022] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [ProSoft-Februar2022] SET ARITHABORT OFF 
GO
ALTER DATABASE [ProSoft-Februar2022] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [ProSoft-Februar2022] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [ProSoft-Februar2022] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [ProSoft-Februar2022] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [ProSoft-Februar2022] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [ProSoft-Februar2022] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [ProSoft-Februar2022] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [ProSoft-Februar2022] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [ProSoft-Februar2022] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [ProSoft-Februar2022] SET  DISABLE_BROKER 
GO
ALTER DATABASE [ProSoft-Februar2022] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [ProSoft-Februar2022] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [ProSoft-Februar2022] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [ProSoft-Februar2022] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [ProSoft-Februar2022] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [ProSoft-Februar2022] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [ProSoft-Februar2022] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [ProSoft-Februar2022] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [ProSoft-Februar2022] SET  MULTI_USER 
GO
ALTER DATABASE [ProSoft-Februar2022] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [ProSoft-Februar2022] SET DB_CHAINING OFF 
GO
ALTER DATABASE [ProSoft-Februar2022] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [ProSoft-Februar2022] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [ProSoft-Februar2022] SET DELAYED_DURABILITY = DISABLED 
GO
ALTER DATABASE [ProSoft-Februar2022] SET QUERY_STORE = OFF
GO
USE [ProSoft-Februar2022]
GO
ALTER DATABASE SCOPED CONFIGURATION SET LEGACY_CARDINALITY_ESTIMATION = OFF;
GO
ALTER DATABASE SCOPED CONFIGURATION SET MAXDOP = 0;
GO
ALTER DATABASE SCOPED CONFIGURATION SET PARAMETER_SNIFFING = ON;
GO
ALTER DATABASE SCOPED CONFIGURATION SET QUERY_OPTIMIZER_HOTFIXES = OFF;
GO
USE [ProSoft-Februar2022]
GO
/****** Object:  Table [dbo].[DnevnaProizvodnjaIzvestaj]    Script Date: 08-Feb-22 20:53:32 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[DnevnaProizvodnjaIzvestaj](
	[DnevnaProizvodnjaIzvestajID] [int] IDENTITY(1,1) NOT NULL,
	[Datum] [datetime] NOT NULL,
	[Opis] [nvarchar](255) NULL,
	[ProizvodjacID] [int] NOT NULL,
 CONSTRAINT [DnevnaProizvodnjaIzvestaj$PrimaryKey] PRIMARY KEY CLUSTERED 
(
	[DnevnaProizvodnjaIzvestajID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[DnevnaProizvodnjaStavkaIzvestaja]    Script Date: 08-Feb-22 20:53:32 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[DnevnaProizvodnjaStavkaIzvestaja](
	[DnevnaProizvodnjaIzvestajID] [int] NOT NULL,
	[RB] [int] NOT NULL,
	[VrstaKapaciteta] [nvarchar](255) NOT NULL,
	[Kolicina] [float] NOT NULL,
	[JedinicaMere] [nvarchar](255) NOT NULL,
	[Napomena] [nvarchar](255) NOT NULL,
 CONSTRAINT [DnevnaProizvodnjaStavkaIzvestaja$PrimaryKey] PRIMARY KEY CLUSTERED 
(
	[DnevnaProizvodnjaIzvestajID] ASC,
	[RB] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Proizvodjac]    Script Date: 08-Feb-22 20:53:32 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Proizvodjac](
	[ProizvodjacID] [int] IDENTITY(1,1) NOT NULL,
	[Naziv] [nvarchar](255) NULL,
	[Adresa] [nvarchar](255) NULL,
	[KorisnickoIme] [nvarchar](255) NULL,
	[Lozinka] [nvarchar](255) NULL,
 CONSTRAINT [Proizvodjac$PrimaryKey] PRIMARY KEY CLUSTERED 
(
	[ProizvodjacID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET IDENTITY_INSERT [dbo].[Proizvodjac] ON 

INSERT [dbo].[Proizvodjac] ([ProizvodjacID], [Naziv], [Adresa], [KorisnickoIme], [Lozinka]) VALUES (1, N'Elektroprivreda Srbije', N'Balkanska 13', N'eps', N'eps1')
INSERT [dbo].[Proizvodjac] ([ProizvodjacID], [Naziv], [Adresa], [KorisnickoIme], [Lozinka]) VALUES (2, N'Proizvodjac 1', N'Adresa 1', N'p1', N'p1')
INSERT [dbo].[Proizvodjac] ([ProizvodjacID], [Naziv], [Adresa], [KorisnickoIme], [Lozinka]) VALUES (3, N'Proizvodjac 2', N'Adresa 2', N'p2', N'p2')
INSERT [dbo].[Proizvodjac] ([ProizvodjacID], [Naziv], [Adresa], [KorisnickoIme], [Lozinka]) VALUES (4, N'Proizvodjac 3', N'Adresa 3', N'p3', N'p3')
INSERT [dbo].[Proizvodjac] ([ProizvodjacID], [Naziv], [Adresa], [KorisnickoIme], [Lozinka]) VALUES (5, N'Proizvodjac 4', N'Adresa 4', N'p4', N'p4')
INSERT [dbo].[Proizvodjac] ([ProizvodjacID], [Naziv], [Adresa], [KorisnickoIme], [Lozinka]) VALUES (6, N'Proizvodjac 5', N'Adresa 5', N'p5', N'p5')
SET IDENTITY_INSERT [dbo].[Proizvodjac] OFF
GO
/****** Object:  Index [DnevnaProizvodnjaIzvestaj$DnevnaProizvodnjaIzvestajID]    Script Date: 08-Feb-22 20:53:32 ******/
CREATE NONCLUSTERED INDEX [DnevnaProizvodnjaIzvestaj$DnevnaProizvodnjaIzvestajID] ON [dbo].[DnevnaProizvodnjaIzvestaj]
(
	[DnevnaProizvodnjaIzvestajID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, DROP_EXISTING = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
/****** Object:  Index [DnevnaProizvodnjaIzvestaj$ProizvodjacID]    Script Date: 08-Feb-22 20:53:32 ******/
CREATE NONCLUSTERED INDEX [DnevnaProizvodnjaIzvestaj$ProizvodjacID] ON [dbo].[DnevnaProizvodnjaIzvestaj]
(
	[ProizvodjacID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, DROP_EXISTING = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
/****** Object:  Index [DnevnaProizvodnjaStavkaIzvestaja$DnevnaProizvodnjaIzvestajID]    Script Date: 08-Feb-22 20:53:32 ******/
CREATE NONCLUSTERED INDEX [DnevnaProizvodnjaStavkaIzvestaja$DnevnaProizvodnjaIzvestajID] ON [dbo].[DnevnaProizvodnjaStavkaIzvestaja]
(
	[DnevnaProizvodnjaIzvestajID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, DROP_EXISTING = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
/****** Object:  Index [Proizvodjac$ProizvodjacID]    Script Date: 08-Feb-22 20:53:32 ******/
CREATE NONCLUSTERED INDEX [Proizvodjac$ProizvodjacID] ON [dbo].[Proizvodjac]
(
	[ProizvodjacID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, DROP_EXISTING = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
ALTER TABLE [dbo].[DnevnaProizvodnjaIzvestaj] ADD  CONSTRAINT [DF__DnevnaPro__Proiz__29572725]  DEFAULT ((0)) FOR [ProizvodjacID]
GO
ALTER TABLE [dbo].[DnevnaProizvodnjaStavkaIzvestaja] ADD  DEFAULT ((0)) FOR [DnevnaProizvodnjaIzvestajID]
GO
ALTER TABLE [dbo].[DnevnaProizvodnjaStavkaIzvestaja] ADD  DEFAULT ((0)) FOR [RB]
GO
ALTER TABLE [dbo].[DnevnaProizvodnjaStavkaIzvestaja] ADD  DEFAULT ((0)) FOR [Kolicina]
GO
ALTER TABLE [dbo].[DnevnaProizvodnjaIzvestaj]  WITH CHECK ADD  CONSTRAINT [DnevnaProizvodnjaIzvestaj$ProizvodjacDnevnaProizvodnjaIzvestaj] FOREIGN KEY([ProizvodjacID])
REFERENCES [dbo].[Proizvodjac] ([ProizvodjacID])
GO
ALTER TABLE [dbo].[DnevnaProizvodnjaIzvestaj] CHECK CONSTRAINT [DnevnaProizvodnjaIzvestaj$ProizvodjacDnevnaProizvodnjaIzvestaj]
GO
ALTER TABLE [dbo].[DnevnaProizvodnjaStavkaIzvestaja]  WITH CHECK ADD  CONSTRAINT [DnevnaProizvodnjaStavkaIzvestaja$DnevnaProizvodnjaIzvestajDnevnaProizvodnjaStavkaIzvestaja] FOREIGN KEY([DnevnaProizvodnjaIzvestajID])
REFERENCES [dbo].[DnevnaProizvodnjaIzvestaj] ([DnevnaProizvodnjaIzvestajID])
GO
ALTER TABLE [dbo].[DnevnaProizvodnjaStavkaIzvestaja] CHECK CONSTRAINT [DnevnaProizvodnjaStavkaIzvestaja$DnevnaProizvodnjaIzvestajDnevnaProizvodnjaStavkaIzvestaja]
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Februar2022.[DnevnaProizvodnjaIzvestaj].[DnevnaProizvodnjaIzvestajID]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'DnevnaProizvodnjaIzvestaj', @level2type=N'COLUMN',@level2name=N'DnevnaProizvodnjaIzvestajID'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Februar2022.[DnevnaProizvodnjaIzvestaj].[Datum]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'DnevnaProizvodnjaIzvestaj', @level2type=N'COLUMN',@level2name=N'Datum'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Februar2022.[DnevnaProizvodnjaIzvestaj].[Opis]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'DnevnaProizvodnjaIzvestaj', @level2type=N'COLUMN',@level2name=N'Opis'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Februar2022.[DnevnaProizvodnjaIzvestaj].[ProizvodjacID]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'DnevnaProizvodnjaIzvestaj', @level2type=N'COLUMN',@level2name=N'ProizvodjacID'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Februar2022.[DnevnaProizvodnjaIzvestaj].[PrimaryKey]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'DnevnaProizvodnjaIzvestaj', @level2type=N'CONSTRAINT',@level2name=N'DnevnaProizvodnjaIzvestaj$PrimaryKey'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Februar2022.[DnevnaProizvodnjaIzvestaj].[DnevnaProizvodnjaIzvestajID]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'DnevnaProizvodnjaIzvestaj', @level2type=N'INDEX',@level2name=N'DnevnaProizvodnjaIzvestaj$DnevnaProizvodnjaIzvestajID'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Februar2022.[DnevnaProizvodnjaIzvestaj].[ProizvodjacID]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'DnevnaProizvodnjaIzvestaj', @level2type=N'INDEX',@level2name=N'DnevnaProizvodnjaIzvestaj$ProizvodjacID'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Februar2022.[DnevnaProizvodnjaIzvestaj]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'DnevnaProizvodnjaIzvestaj'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Februar2022.[DnevnaProizvodnjaIzvestaj].[ProizvodjacDnevnaProizvodnjaIzvestaj]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'DnevnaProizvodnjaIzvestaj', @level2type=N'CONSTRAINT',@level2name=N'DnevnaProizvodnjaIzvestaj$ProizvodjacDnevnaProizvodnjaIzvestaj'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Februar2022.[DnevnaProizvodnjaStavkaIzvestaja].[DnevnaProizvodnjaIzvestajID]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'DnevnaProizvodnjaStavkaIzvestaja', @level2type=N'COLUMN',@level2name=N'DnevnaProizvodnjaIzvestajID'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Februar2022.[DnevnaProizvodnjaStavkaIzvestaja].[RB]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'DnevnaProizvodnjaStavkaIzvestaja', @level2type=N'COLUMN',@level2name=N'RB'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Februar2022.[DnevnaProizvodnjaStavkaIzvestaja].[VrstaKapaciteta]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'DnevnaProizvodnjaStavkaIzvestaja', @level2type=N'COLUMN',@level2name=N'VrstaKapaciteta'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Februar2022.[DnevnaProizvodnjaStavkaIzvestaja].[Kolicina]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'DnevnaProizvodnjaStavkaIzvestaja', @level2type=N'COLUMN',@level2name=N'Kolicina'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Februar2022.[DnevnaProizvodnjaStavkaIzvestaja].[JedinicaMere]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'DnevnaProizvodnjaStavkaIzvestaja', @level2type=N'COLUMN',@level2name=N'JedinicaMere'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Februar2022.[DnevnaProizvodnjaStavkaIzvestaja].[Napomena]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'DnevnaProizvodnjaStavkaIzvestaja', @level2type=N'COLUMN',@level2name=N'Napomena'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Februar2022.[DnevnaProizvodnjaStavkaIzvestaja].[PrimaryKey]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'DnevnaProizvodnjaStavkaIzvestaja', @level2type=N'CONSTRAINT',@level2name=N'DnevnaProizvodnjaStavkaIzvestaja$PrimaryKey'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Februar2022.[DnevnaProizvodnjaStavkaIzvestaja].[DnevnaProizvodnjaIzvestajID]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'DnevnaProizvodnjaStavkaIzvestaja', @level2type=N'INDEX',@level2name=N'DnevnaProizvodnjaStavkaIzvestaja$DnevnaProizvodnjaIzvestajID'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Februar2022.[DnevnaProizvodnjaStavkaIzvestaja]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'DnevnaProizvodnjaStavkaIzvestaja'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Februar2022.[DnevnaProizvodnjaStavkaIzvestaja].[DnevnaProizvodnjaIzvestajDnevnaProizvodnjaStavkaIzvestaja]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'DnevnaProizvodnjaStavkaIzvestaja', @level2type=N'CONSTRAINT',@level2name=N'DnevnaProizvodnjaStavkaIzvestaja$DnevnaProizvodnjaIzvestajDnevnaProizvodnjaStavkaIzvestaja'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Februar2022.[Proizvodjac].[ProizvodjacID]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'Proizvodjac', @level2type=N'COLUMN',@level2name=N'ProizvodjacID'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Februar2022.[Proizvodjac].[Naziv]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'Proizvodjac', @level2type=N'COLUMN',@level2name=N'Naziv'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Februar2022.[Proizvodjac].[Adresa]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'Proizvodjac', @level2type=N'COLUMN',@level2name=N'Adresa'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Februar2022.[Proizvodjac].[KorisnickoIme]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'Proizvodjac', @level2type=N'COLUMN',@level2name=N'KorisnickoIme'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Februar2022.[Proizvodjac].[Lozinka]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'Proizvodjac', @level2type=N'COLUMN',@level2name=N'Lozinka'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Februar2022.[Proizvodjac].[PrimaryKey]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'Proizvodjac', @level2type=N'CONSTRAINT',@level2name=N'Proizvodjac$PrimaryKey'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Februar2022.[Proizvodjac].[ProizvodjacID]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'Proizvodjac', @level2type=N'INDEX',@level2name=N'Proizvodjac$ProizvodjacID'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Februar2022.[Proizvodjac]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'Proizvodjac'
GO
USE [master]
GO
ALTER DATABASE [ProSoft-Februar2022] SET  READ_WRITE 
GO
