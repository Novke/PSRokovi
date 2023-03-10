USE [master]
GO
/****** Object:  Database [ProSoft-Jun2021]    Script Date: 14-Jun-21 16:35:46 ******/
CREATE DATABASE [ProSoft-Jun2021]
GO
ALTER DATABASE [ProSoft-Jun2021] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [ProSoft-Jun2021] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [ProSoft-Jun2021] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [ProSoft-Jun2021] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [ProSoft-Jun2021] SET ARITHABORT OFF 
GO
ALTER DATABASE [ProSoft-Jun2021] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [ProSoft-Jun2021] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [ProSoft-Jun2021] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [ProSoft-Jun2021] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [ProSoft-Jun2021] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [ProSoft-Jun2021] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [ProSoft-Jun2021] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [ProSoft-Jun2021] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [ProSoft-Jun2021] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [ProSoft-Jun2021] SET  DISABLE_BROKER 
GO
ALTER DATABASE [ProSoft-Jun2021] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [ProSoft-Jun2021] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [ProSoft-Jun2021] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [ProSoft-Jun2021] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [ProSoft-Jun2021] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [ProSoft-Jun2021] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [ProSoft-Jun2021] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [ProSoft-Jun2021] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [ProSoft-Jun2021] SET  MULTI_USER 
GO
ALTER DATABASE [ProSoft-Jun2021] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [ProSoft-Jun2021] SET DB_CHAINING OFF 
GO
ALTER DATABASE [ProSoft-Jun2021] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [ProSoft-Jun2021] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [ProSoft-Jun2021] SET DELAYED_DURABILITY = DISABLED 
GO
ALTER DATABASE [ProSoft-Jun2021] SET QUERY_STORE = OFF
GO
USE [ProSoft-Jun2021]
GO
ALTER DATABASE SCOPED CONFIGURATION SET LEGACY_CARDINALITY_ESTIMATION = OFF;
GO
ALTER DATABASE SCOPED CONFIGURATION SET MAXDOP = 0;
GO
ALTER DATABASE SCOPED CONFIGURATION SET PARAMETER_SNIFFING = ON;
GO
ALTER DATABASE SCOPED CONFIGURATION SET QUERY_OPTIMIZER_HOTFIXES = OFF;
GO
USE [ProSoft-Jun2021]
GO
/****** Object:  Table [dbo].[PoreskaPrijava]    Script Date: 14-Jun-21 16:35:46 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[PoreskaPrijava](
	[PoreskaPrijavaID] [int] IDENTITY(1,1) NOT NULL,
	[Adresa] [nvarchar](255) NULL,
	[MestoNepokretnosti] [nvarchar](255) NULL,
	[MestoPrebivalista] [bit] NULL,
	[BrojListaNepokretnosti] [int] NULL,
	[GodinaIzgradnje] [int] NULL,
	[DatumPocetkaKoriscenja] [datetime] NULL,
	[Povrsina] [float] NULL,
	[DatumPodnosenjaPrijave] [datetime] NULL,
	[PoreskiObveznikID] [int] NULL,
	[VrstaNepokretnostiID] [int] NULL,
 CONSTRAINT [PoreskaPrijava$PrimaryKey] PRIMARY KEY CLUSTERED 
(
	[PoreskaPrijavaID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[PoreskiObveznik]    Script Date: 14-Jun-21 16:35:46 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[PoreskiObveznik](
	[PoreskiObveznikID] [int] IDENTITY(1,1) NOT NULL,
	[Ime] [nvarchar](255) NULL,
	[Prezime] [nvarchar](255) NULL,
	[JMBG] [nvarchar](255) NULL,
	[KorisnickoIme] [nvarchar](255) NULL,
	[Lozinka] [nvarchar](255) NULL,
	[Telefon] [nvarchar](255) NULL,
 CONSTRAINT [PoreskiObveznik$PrimaryKey] PRIMARY KEY CLUSTERED 
(
	[PoreskiObveznikID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[VrstaNepokretnosti]    Script Date: 14-Jun-21 16:35:46 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[VrstaNepokretnosti](
	[VrstaNepokretnostiID] [int] IDENTITY(1,1) NOT NULL,
	[NazivVrsteNepokretnosti] [nvarchar](255) NULL,
	[PoreskaGrupa] [nvarchar](255) NULL,
 CONSTRAINT [VrstaNepokretnosti$PrimaryKey] PRIMARY KEY CLUSTERED 
(
	[VrstaNepokretnostiID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET IDENTITY_INSERT [dbo].[PoreskiObveznik] ON 

INSERT [dbo].[PoreskiObveznik] ([PoreskiObveznikID], [Ime], [Prezime], [JMBG], [KorisnickoIme], [Lozinka], [Telefon]) VALUES (1, N'Ana', N'Anic', N'111199911111', N'ana', N'ana1', N'011-111-111')
INSERT [dbo].[PoreskiObveznik] ([PoreskiObveznikID], [Ime], [Prezime], [JMBG], [KorisnickoIme], [Lozinka], [Telefon]) VALUES (2, N'Ivan', N'Ivic', N'121299922222', N'ivan', N'ivan1', N'011-222-222')
INSERT [dbo].[PoreskiObveznik] ([PoreskiObveznikID], [Ime], [Prezime], [JMBG], [KorisnickoIme], [Lozinka], [Telefon]) VALUES (3, N'Dragana', N'Dragic', N'131299933333', N'dragana', N'dragana1', N'011-333-333')
INSERT [dbo].[PoreskiObveznik] ([PoreskiObveznikID], [Ime], [Prezime], [JMBG], [KorisnickoIme], [Lozinka], [Telefon]) VALUES (4, N'Marko', N'Markovic', N'141299944444', N'marko', N'marko1', N'011-444-444')
SET IDENTITY_INSERT [dbo].[PoreskiObveznik] OFF
GO
SET IDENTITY_INSERT [dbo].[VrstaNepokretnosti] ON 

INSERT [dbo].[VrstaNepokretnosti] ([VrstaNepokretnostiID], [NazivVrsteNepokretnosti], [PoreskaGrupa]) VALUES (1, N'Stan', N'G1')
INSERT [dbo].[VrstaNepokretnosti] ([VrstaNepokretnostiID], [NazivVrsteNepokretnosti], [PoreskaGrupa]) VALUES (2, N'Kuca za stanovanje', N'G2')
INSERT [dbo].[VrstaNepokretnosti] ([VrstaNepokretnostiID], [NazivVrsteNepokretnosti], [PoreskaGrupa]) VALUES (3, N'Poslovna zgrada ili objekat za obavljanje delatnosti', N'G3')
INSERT [dbo].[VrstaNepokretnosti] ([VrstaNepokretnostiID], [NazivVrsteNepokretnosti], [PoreskaGrupa]) VALUES (4, N'Garaza', N'G4')
INSERT [dbo].[VrstaNepokretnosti] ([VrstaNepokretnostiID], [NazivVrsteNepokretnosti], [PoreskaGrupa]) VALUES (5, N'Garazno mesto', N'G5')
SET IDENTITY_INSERT [dbo].[VrstaNepokretnosti] OFF
GO
/****** Object:  Index [PoreskaPrijava$PoreskaPrijavaID]    Script Date: 14-Jun-21 16:35:46 ******/
CREATE NONCLUSTERED INDEX [PoreskaPrijava$PoreskaPrijavaID] ON [dbo].[PoreskaPrijava]
(
	[PoreskaPrijavaID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, DROP_EXISTING = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
/****** Object:  Index [PoreskaPrijava$PoreskiObveznikID]    Script Date: 14-Jun-21 16:35:46 ******/
CREATE NONCLUSTERED INDEX [PoreskaPrijava$PoreskiObveznikID] ON [dbo].[PoreskaPrijava]
(
	[PoreskiObveznikID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, DROP_EXISTING = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
/****** Object:  Index [PoreskaPrijava$VrstaNepokretnostiID]    Script Date: 14-Jun-21 16:35:46 ******/
CREATE NONCLUSTERED INDEX [PoreskaPrijava$VrstaNepokretnostiID] ON [dbo].[PoreskaPrijava]
(
	[VrstaNepokretnostiID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, DROP_EXISTING = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
/****** Object:  Index [PoreskiObveznik$PoreskiObveznikID]    Script Date: 14-Jun-21 16:35:46 ******/
CREATE NONCLUSTERED INDEX [PoreskiObveznik$PoreskiObveznikID] ON [dbo].[PoreskiObveznik]
(
	[PoreskiObveznikID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, DROP_EXISTING = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
/****** Object:  Index [VrstaNepokretnosti$VrstaNepokretnostiID]    Script Date: 14-Jun-21 16:35:46 ******/
CREATE NONCLUSTERED INDEX [VrstaNepokretnosti$VrstaNepokretnostiID] ON [dbo].[VrstaNepokretnosti]
(
	[VrstaNepokretnostiID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, DROP_EXISTING = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
ALTER TABLE [dbo].[PoreskaPrijava] ADD  CONSTRAINT [DF__PoreskaPr__Mesto__29572725]  DEFAULT ((0)) FOR [MestoPrebivalista]
GO
ALTER TABLE [dbo].[PoreskaPrijava] ADD  CONSTRAINT [DF__PoreskaPr__BrojL__2A4B4B5E]  DEFAULT ((0)) FOR [BrojListaNepokretnosti]
GO
ALTER TABLE [dbo].[PoreskaPrijava] ADD  CONSTRAINT [DF__PoreskaPr__Godin__2B3F6F97]  DEFAULT ((0)) FOR [GodinaIzgradnje]
GO
ALTER TABLE [dbo].[PoreskaPrijava] ADD  CONSTRAINT [DF__PoreskaPr__Povrs__2C3393D0]  DEFAULT ((0)) FOR [Povrsina]
GO
ALTER TABLE [dbo].[PoreskaPrijava] ADD  CONSTRAINT [DF__PoreskaPr__Pores__2D27B809]  DEFAULT ((0)) FOR [PoreskiObveznikID]
GO
ALTER TABLE [dbo].[PoreskaPrijava] ADD  CONSTRAINT [DF__PoreskaPr__Vrsta__2E1BDC42]  DEFAULT ((0)) FOR [VrstaNepokretnostiID]
GO
ALTER TABLE [dbo].[PoreskaPrijava]  WITH CHECK ADD  CONSTRAINT [PoreskaPrijava$PoreskiObveznikPoreskaPrijava] FOREIGN KEY([PoreskiObveznikID])
REFERENCES [dbo].[PoreskiObveznik] ([PoreskiObveznikID])
GO
ALTER TABLE [dbo].[PoreskaPrijava] CHECK CONSTRAINT [PoreskaPrijava$PoreskiObveznikPoreskaPrijava]
GO
ALTER TABLE [dbo].[PoreskaPrijava]  WITH CHECK ADD  CONSTRAINT [PoreskaPrijava$VrstaNepokretnostiPoreskaPrijava] FOREIGN KEY([VrstaNepokretnostiID])
REFERENCES [dbo].[VrstaNepokretnosti] ([VrstaNepokretnostiID])
GO
ALTER TABLE [dbo].[PoreskaPrijava] CHECK CONSTRAINT [PoreskaPrijava$VrstaNepokretnostiPoreskaPrijava]
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Jun2021.[PoreskaPrijava].[PoreskaPrijavaID]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'PoreskaPrijava', @level2type=N'COLUMN',@level2name=N'PoreskaPrijavaID'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Jun2021.[PoreskaPrijava].[Adresa]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'PoreskaPrijava', @level2type=N'COLUMN',@level2name=N'Adresa'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Jun2021.[PoreskaPrijava].[MestoNepokretnosti]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'PoreskaPrijava', @level2type=N'COLUMN',@level2name=N'MestoNepokretnosti'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Jun2021.[PoreskaPrijava].[MestoPrebivalista]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'PoreskaPrijava', @level2type=N'COLUMN',@level2name=N'MestoPrebivalista'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Jun2021.[PoreskaPrijava].[BrojListaNepokretnosti]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'PoreskaPrijava', @level2type=N'COLUMN',@level2name=N'BrojListaNepokretnosti'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Jun2021.[PoreskaPrijava].[GodinaIzgradnje]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'PoreskaPrijava', @level2type=N'COLUMN',@level2name=N'GodinaIzgradnje'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Jun2021.[PoreskaPrijava].[DatumPocetkaKoriscenja]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'PoreskaPrijava', @level2type=N'COLUMN',@level2name=N'DatumPocetkaKoriscenja'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Jun2021.[PoreskaPrijava].[Povrsina]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'PoreskaPrijava', @level2type=N'COLUMN',@level2name=N'Povrsina'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Jun2021.[PoreskaPrijava].[DatumPodnosenjaPrijave]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'PoreskaPrijava', @level2type=N'COLUMN',@level2name=N'DatumPodnosenjaPrijave'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Jun2021.[PoreskaPrijava].[PoreskiObveznikID]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'PoreskaPrijava', @level2type=N'COLUMN',@level2name=N'PoreskiObveznikID'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Jun2021.[PoreskaPrijava].[VrstaNepokretnostiID]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'PoreskaPrijava', @level2type=N'COLUMN',@level2name=N'VrstaNepokretnostiID'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Jun2021.[PoreskaPrijava].[PrimaryKey]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'PoreskaPrijava', @level2type=N'CONSTRAINT',@level2name=N'PoreskaPrijava$PrimaryKey'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Jun2021.[PoreskaPrijava].[PoreskaPrijavaID]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'PoreskaPrijava', @level2type=N'INDEX',@level2name=N'PoreskaPrijava$PoreskaPrijavaID'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Jun2021.[PoreskaPrijava].[PoreskiObveznikID]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'PoreskaPrijava', @level2type=N'INDEX',@level2name=N'PoreskaPrijava$PoreskiObveznikID'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Jun2021.[PoreskaPrijava].[VrstaNepokretnostiID]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'PoreskaPrijava', @level2type=N'INDEX',@level2name=N'PoreskaPrijava$VrstaNepokretnostiID'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Jun2021.[PoreskaPrijava]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'PoreskaPrijava'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Jun2021.[PoreskaPrijava].[PoreskiObveznikPoreskaPrijava]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'PoreskaPrijava', @level2type=N'CONSTRAINT',@level2name=N'PoreskaPrijava$PoreskiObveznikPoreskaPrijava'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Jun2021.[PoreskaPrijava].[VrstaNepokretnostiPoreskaPrijava]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'PoreskaPrijava', @level2type=N'CONSTRAINT',@level2name=N'PoreskaPrijava$VrstaNepokretnostiPoreskaPrijava'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Jun2021.[PoreskiObveznik].[PoreskiObveznikID]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'PoreskiObveznik', @level2type=N'COLUMN',@level2name=N'PoreskiObveznikID'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Jun2021.[PoreskiObveznik].[Ime]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'PoreskiObveznik', @level2type=N'COLUMN',@level2name=N'Ime'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Jun2021.[PoreskiObveznik].[Prezime]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'PoreskiObveznik', @level2type=N'COLUMN',@level2name=N'Prezime'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Jun2021.[PoreskiObveznik].[JMBG]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'PoreskiObveznik', @level2type=N'COLUMN',@level2name=N'JMBG'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Jun2021.[PoreskiObveznik].[KorisnickoIme]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'PoreskiObveznik', @level2type=N'COLUMN',@level2name=N'KorisnickoIme'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Jun2021.[PoreskiObveznik].[Lozinka]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'PoreskiObveznik', @level2type=N'COLUMN',@level2name=N'Lozinka'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Jun2021.[PoreskiObveznik].[Telefon]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'PoreskiObveznik', @level2type=N'COLUMN',@level2name=N'Telefon'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Jun2021.[PoreskiObveznik].[PrimaryKey]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'PoreskiObveznik', @level2type=N'CONSTRAINT',@level2name=N'PoreskiObveznik$PrimaryKey'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Jun2021.[PoreskiObveznik].[PoreskiObveznikID]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'PoreskiObveznik', @level2type=N'INDEX',@level2name=N'PoreskiObveznik$PoreskiObveznikID'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Jun2021.[PoreskiObveznik]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'PoreskiObveznik'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Jun2021.[VrstaNepokretnosti].[VrstaNepokretnostiID]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'VrstaNepokretnosti', @level2type=N'COLUMN',@level2name=N'VrstaNepokretnostiID'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Jun2021.[VrstaNepokretnosti].[NazivVrsteNepokretnosti]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'VrstaNepokretnosti', @level2type=N'COLUMN',@level2name=N'NazivVrsteNepokretnosti'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Jun2021.[VrstaNepokretnosti].[PoreskaGrupa]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'VrstaNepokretnosti', @level2type=N'COLUMN',@level2name=N'PoreskaGrupa'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Jun2021.[VrstaNepokretnosti].[PrimaryKey]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'VrstaNepokretnosti', @level2type=N'CONSTRAINT',@level2name=N'VrstaNepokretnosti$PrimaryKey'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Jun2021.[VrstaNepokretnosti].[VrstaNepokretnostiID]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'VrstaNepokretnosti', @level2type=N'INDEX',@level2name=N'VrstaNepokretnosti$VrstaNepokretnostiID'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Jun2021.[VrstaNepokretnosti]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'VrstaNepokretnosti'
GO
USE [master]
GO
ALTER DATABASE [ProSoft-Jun2021] SET  READ_WRITE 
GO
