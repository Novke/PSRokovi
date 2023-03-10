USE [master]
GO
/****** Object:  Database [ProSoft-Jul2022]    Script Date: 05-Jul-22 0:09:38 ******/
CREATE DATABASE [ProSoft-Jul2022]
 GO
ALTER DATABASE [ProSoft-Jul2022] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [ProSoft-Jul2022] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [ProSoft-Jul2022] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [ProSoft-Jul2022] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [ProSoft-Jul2022] SET ARITHABORT OFF 
GO
ALTER DATABASE [ProSoft-Jul2022] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [ProSoft-Jul2022] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [ProSoft-Jul2022] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [ProSoft-Jul2022] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [ProSoft-Jul2022] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [ProSoft-Jul2022] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [ProSoft-Jul2022] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [ProSoft-Jul2022] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [ProSoft-Jul2022] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [ProSoft-Jul2022] SET  DISABLE_BROKER 
GO
ALTER DATABASE [ProSoft-Jul2022] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [ProSoft-Jul2022] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [ProSoft-Jul2022] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [ProSoft-Jul2022] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [ProSoft-Jul2022] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [ProSoft-Jul2022] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [ProSoft-Jul2022] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [ProSoft-Jul2022] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [ProSoft-Jul2022] SET  MULTI_USER 
GO
ALTER DATABASE [ProSoft-Jul2022] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [ProSoft-Jul2022] SET DB_CHAINING OFF 
GO
ALTER DATABASE [ProSoft-Jul2022] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [ProSoft-Jul2022] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [ProSoft-Jul2022] SET DELAYED_DURABILITY = DISABLED 
GO
ALTER DATABASE [ProSoft-Jul2022] SET QUERY_STORE = OFF
GO
USE [ProSoft-Jul2022]
GO
ALTER DATABASE SCOPED CONFIGURATION SET LEGACY_CARDINALITY_ESTIMATION = OFF;
GO
ALTER DATABASE SCOPED CONFIGURATION SET MAXDOP = 0;
GO
ALTER DATABASE SCOPED CONFIGURATION SET PARAMETER_SNIFFING = ON;
GO
ALTER DATABASE SCOPED CONFIGURATION SET QUERY_OPTIMIZER_HOTFIXES = OFF;
GO
USE [ProSoft-Jul2022]
GO
/****** Object:  Table [dbo].[ProgramskiVodic]    Script Date: 05-Jul-22 0:09:38 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ProgramskiVodic](
	[ProgramskiVodicID] [int] IDENTITY(1,1) NOT NULL,
	[Dan] [datetime] NOT NULL,
	[Opis] [nvarchar](255) NOT NULL,
	[Urednik] [nvarchar](255) NOT NULL,
 CONSTRAINT [ProgramskiVodic$PrimaryKey] PRIMARY KEY CLUSTERED 
(
	[ProgramskiVodicID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Stanica]    Script Date: 05-Jul-22 0:09:38 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Stanica](
	[StanicaID] [int] IDENTITY(1,1) NOT NULL,
	[Naziv] [nvarchar](255) NULL,
	[Tip] [nvarchar](255) NULL,
	[Kontakt] [nvarchar](255) NULL,
 CONSTRAINT [Stanica$PrimaryKey] PRIMARY KEY CLUSTERED 
(
	[StanicaID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[StavkaProgramskogVodica]    Script Date: 05-Jul-22 0:09:38 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[StavkaProgramskogVodica](
	[ProgramskiVodicID] [int] NOT NULL,
	[RB] [int] NOT NULL,
	[NazivEmisije] [nvarchar](255) NOT NULL,
	[DatumVremeOd] [datetime] NOT NULL,
	[DatumVremeDo] [datetime] NOT NULL,
	[StanicaID] [int] NOT NULL,
	[TipEmisijeID] [int] NOT NULL,
 CONSTRAINT [StavkaProgramskogVodica$PrimaryKey] PRIMARY KEY CLUSTERED 
(
	[ProgramskiVodicID] ASC,
	[RB] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[TipEmisije]    Script Date: 05-Jul-22 0:09:38 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[TipEmisije](
	[TipEmisijeID] [int] IDENTITY(1,1) NOT NULL,
	[Naziv] [nvarchar](255) NULL,
	[NadtipEmisijeID] [int] NULL,
 CONSTRAINT [TipEmisije$PrimaryKey] PRIMARY KEY CLUSTERED 
(
	[TipEmisijeID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET IDENTITY_INSERT [dbo].[Stanica] ON 

INSERT [dbo].[Stanica] ([StanicaID], [Naziv], [Tip], [Kontakt]) VALUES (1, N'RTS1', N'TV', N'rts1@rts.rs')
INSERT [dbo].[Stanica] ([StanicaID], [Naziv], [Tip], [Kontakt]) VALUES (2, N'RTS2', N'TV', N'rts2@rts.rs')
INSERT [dbo].[Stanica] ([StanicaID], [Naziv], [Tip], [Kontakt]) VALUES (3, N'RTS3', N'TV', N'rts3@rts.rs')
INSERT [dbo].[Stanica] ([StanicaID], [Naziv], [Tip], [Kontakt]) VALUES (4, N'Radio 202', N'Radio', N'radio202@rts.rs')
INSERT [dbo].[Stanica] ([StanicaID], [Naziv], [Tip], [Kontakt]) VALUES (5, N'Radio N', N'Radio', N'kontakt@n.net')
INSERT [dbo].[Stanica] ([StanicaID], [Naziv], [Tip], [Kontakt]) VALUES (6, N'FOX', N'TV', N'kontakt@fox.net')
INSERT [dbo].[Stanica] ([StanicaID], [Naziv], [Tip], [Kontakt]) VALUES (7, N'Svitel', N'TV', N'kontakt@svitel.net')
SET IDENTITY_INSERT [dbo].[Stanica] OFF
GO
SET IDENTITY_INSERT [dbo].[TipEmisije] ON 

INSERT [dbo].[TipEmisije] ([TipEmisijeID], [Naziv], [NadtipEmisijeID]) VALUES (1, N'Informativni', NULL)
INSERT [dbo].[TipEmisije] ([TipEmisijeID], [Naziv], [NadtipEmisijeID]) VALUES (2, N'Vesti', 1)
INSERT [dbo].[TipEmisije] ([TipEmisijeID], [Naziv], [NadtipEmisijeID]) VALUES (3, N'IT', 1)
INSERT [dbo].[TipEmisije] ([TipEmisijeID], [Naziv], [NadtipEmisijeID]) VALUES (4, N'Talk Show', 1)
INSERT [dbo].[TipEmisije] ([TipEmisijeID], [Naziv], [NadtipEmisijeID]) VALUES (5, N'Magazin', 1)
INSERT [dbo].[TipEmisije] ([TipEmisijeID], [Naziv], [NadtipEmisijeID]) VALUES (6, N'Sportski', NULL)
INSERT [dbo].[TipEmisije] ([TipEmisijeID], [Naziv], [NadtipEmisijeID]) VALUES (7, N'Fudbal', 6)
INSERT [dbo].[TipEmisije] ([TipEmisijeID], [Naziv], [NadtipEmisijeID]) VALUES (8, N'Kosarka', 6)
INSERT [dbo].[TipEmisije] ([TipEmisijeID], [Naziv], [NadtipEmisijeID]) VALUES (9, N'Odbojka', 6)
INSERT [dbo].[TipEmisije] ([TipEmisijeID], [Naziv], [NadtipEmisijeID]) VALUES (10, N'Rukomet', 6)
INSERT [dbo].[TipEmisije] ([TipEmisijeID], [Naziv], [NadtipEmisijeID]) VALUES (11, N'Tenis', 6)
INSERT [dbo].[TipEmisije] ([TipEmisijeID], [Naziv], [NadtipEmisijeID]) VALUES (12, N'Atletika', 6)
INSERT [dbo].[TipEmisije] ([TipEmisijeID], [Naziv], [NadtipEmisijeID]) VALUES (13, N'Veterpolo', 6)
INSERT [dbo].[TipEmisije] ([TipEmisijeID], [Naziv], [NadtipEmisijeID]) VALUES (14, N'Zabava', NULL)
INSERT [dbo].[TipEmisije] ([TipEmisijeID], [Naziv], [NadtipEmisijeID]) VALUES (15, N'Muzika', 14)
INSERT [dbo].[TipEmisije] ([TipEmisijeID], [Naziv], [NadtipEmisijeID]) VALUES (16, N'Film', 14)
INSERT [dbo].[TipEmisije] ([TipEmisijeID], [Naziv], [NadtipEmisijeID]) VALUES (17, N'Kviz', 14)
INSERT [dbo].[TipEmisije] ([TipEmisijeID], [Naziv], [NadtipEmisijeID]) VALUES (18, N'Evrosong', 14)
SET IDENTITY_INSERT [dbo].[TipEmisije] OFF
GO
/****** Object:  Index [Stanica$EmiterID]    Script Date: 05-Jul-22 0:09:38 ******/
CREATE NONCLUSTERED INDEX [Stanica$EmiterID] ON [dbo].[Stanica]
(
	[StanicaID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, DROP_EXISTING = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
/****** Object:  Index [StavkaProgramskogVodica$RasporedID]    Script Date: 05-Jul-22 0:09:38 ******/
CREATE NONCLUSTERED INDEX [StavkaProgramskogVodica$RasporedID] ON [dbo].[StavkaProgramskogVodica]
(
	[ProgramskiVodicID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, DROP_EXISTING = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
/****** Object:  Index [StavkaProgramskogVodica$StanicaID]    Script Date: 05-Jul-22 0:09:38 ******/
CREATE NONCLUSTERED INDEX [StavkaProgramskogVodica$StanicaID] ON [dbo].[StavkaProgramskogVodica]
(
	[StanicaID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, DROP_EXISTING = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
/****** Object:  Index [StavkaProgramskogVodica$TipEmisijeID]    Script Date: 05-Jul-22 0:09:38 ******/
CREATE NONCLUSTERED INDEX [StavkaProgramskogVodica$TipEmisijeID] ON [dbo].[StavkaProgramskogVodica]
(
	[TipEmisijeID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, DROP_EXISTING = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
/****** Object:  Index [TipEmisije$NadtipEmisijeID]    Script Date: 05-Jul-22 0:09:38 ******/
CREATE NONCLUSTERED INDEX [TipEmisije$NadtipEmisijeID] ON [dbo].[TipEmisije]
(
	[NadtipEmisijeID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, DROP_EXISTING = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
/****** Object:  Index [TipEmisije$TipEmisijeID]    Script Date: 05-Jul-22 0:09:38 ******/
CREATE NONCLUSTERED INDEX [TipEmisije$TipEmisijeID] ON [dbo].[TipEmisije]
(
	[TipEmisijeID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, DROP_EXISTING = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
ALTER TABLE [dbo].[StavkaProgramskogVodica] ADD  CONSTRAINT [DF__StavkaPro__Progr__2D27B809]  DEFAULT ((0)) FOR [ProgramskiVodicID]
GO
ALTER TABLE [dbo].[StavkaProgramskogVodica] ADD  CONSTRAINT [DF__StavkaProgra__RB__2E1BDC42]  DEFAULT ((0)) FOR [RB]
GO
ALTER TABLE [dbo].[StavkaProgramskogVodica] ADD  CONSTRAINT [DF__StavkaPro__Stani__2F10007B]  DEFAULT ((0)) FOR [StanicaID]
GO
ALTER TABLE [dbo].[StavkaProgramskogVodica] ADD  CONSTRAINT [DF__StavkaPro__TipEm__300424B4]  DEFAULT ((0)) FOR [TipEmisijeID]
GO
ALTER TABLE [dbo].[TipEmisije] ADD  DEFAULT ((0)) FOR [NadtipEmisijeID]
GO
ALTER TABLE [dbo].[StavkaProgramskogVodica]  WITH CHECK ADD  CONSTRAINT [StavkaProgramskogVodica$ProgramskiVodicStavkaProgramskogVodica] FOREIGN KEY([ProgramskiVodicID])
REFERENCES [dbo].[ProgramskiVodic] ([ProgramskiVodicID])
GO
ALTER TABLE [dbo].[StavkaProgramskogVodica] CHECK CONSTRAINT [StavkaProgramskogVodica$ProgramskiVodicStavkaProgramskogVodica]
GO
ALTER TABLE [dbo].[StavkaProgramskogVodica]  WITH CHECK ADD  CONSTRAINT [StavkaProgramskogVodica$StanicaStavkaProgramskogVodica] FOREIGN KEY([StanicaID])
REFERENCES [dbo].[Stanica] ([StanicaID])
GO
ALTER TABLE [dbo].[StavkaProgramskogVodica] CHECK CONSTRAINT [StavkaProgramskogVodica$StanicaStavkaProgramskogVodica]
GO
ALTER TABLE [dbo].[StavkaProgramskogVodica]  WITH CHECK ADD  CONSTRAINT [StavkaProgramskogVodica$TipEmisijeStavkaProgramskogVodica] FOREIGN KEY([TipEmisijeID])
REFERENCES [dbo].[TipEmisije] ([TipEmisijeID])
GO
ALTER TABLE [dbo].[StavkaProgramskogVodica] CHECK CONSTRAINT [StavkaProgramskogVodica$TipEmisijeStavkaProgramskogVodica]
GO
ALTER TABLE [dbo].[TipEmisije]  WITH NOCHECK ADD  CONSTRAINT [TipEmisije$TipEmisijeTipEmisije] FOREIGN KEY([NadtipEmisijeID])
REFERENCES [dbo].[TipEmisije] ([TipEmisijeID])
GO
ALTER TABLE [dbo].[TipEmisije] CHECK CONSTRAINT [TipEmisije$TipEmisijeTipEmisije]
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Jul2022.[ProgramskiVodic].[ProgramskiVodicID]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'ProgramskiVodic', @level2type=N'COLUMN',@level2name=N'ProgramskiVodicID'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Jul2022.[ProgramskiVodic].[Dan]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'ProgramskiVodic', @level2type=N'COLUMN',@level2name=N'Dan'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Jul2022.[ProgramskiVodic].[Opis]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'ProgramskiVodic', @level2type=N'COLUMN',@level2name=N'Opis'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Jul2022.[ProgramskiVodic].[Urednik]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'ProgramskiVodic', @level2type=N'COLUMN',@level2name=N'Urednik'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Jul2022.[ProgramskiVodic].[PrimaryKey]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'ProgramskiVodic', @level2type=N'CONSTRAINT',@level2name=N'ProgramskiVodic$PrimaryKey'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Jul2022.[ProgramskiVodic]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'ProgramskiVodic'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Jul2022.[Stanica].[StanicaID]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'Stanica', @level2type=N'COLUMN',@level2name=N'StanicaID'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Jul2022.[Stanica].[Naziv]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'Stanica', @level2type=N'COLUMN',@level2name=N'Naziv'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Jul2022.[Stanica].[Tip]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'Stanica', @level2type=N'COLUMN',@level2name=N'Tip'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Jul2022.[Stanica].[Kontakt]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'Stanica', @level2type=N'COLUMN',@level2name=N'Kontakt'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Jul2022.[Stanica].[PrimaryKey]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'Stanica', @level2type=N'CONSTRAINT',@level2name=N'Stanica$PrimaryKey'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Jul2022.[Stanica].[EmiterID]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'Stanica', @level2type=N'INDEX',@level2name=N'Stanica$EmiterID'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Jul2022.[Stanica]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'Stanica'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Jul2022.[StavkaProgramskogVodica].[ProgramskiVodicID]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'StavkaProgramskogVodica', @level2type=N'COLUMN',@level2name=N'ProgramskiVodicID'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Jul2022.[StavkaProgramskogVodica].[RB]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'StavkaProgramskogVodica', @level2type=N'COLUMN',@level2name=N'RB'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Jul2022.[StavkaProgramskogVodica].[NazivEmisije]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'StavkaProgramskogVodica', @level2type=N'COLUMN',@level2name=N'NazivEmisije'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Jul2022.[StavkaProgramskogVodica].[DatumVremeOd]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'StavkaProgramskogVodica', @level2type=N'COLUMN',@level2name=N'DatumVremeOd'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Jul2022.[StavkaProgramskogVodica].[DatumVremeDo]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'StavkaProgramskogVodica', @level2type=N'COLUMN',@level2name=N'DatumVremeDo'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Jul2022.[StavkaProgramskogVodica].[StanicaID]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'StavkaProgramskogVodica', @level2type=N'COLUMN',@level2name=N'StanicaID'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Jul2022.[StavkaProgramskogVodica].[TipEmisijeID]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'StavkaProgramskogVodica', @level2type=N'COLUMN',@level2name=N'TipEmisijeID'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Jul2022.[StavkaProgramskogVodica].[PrimaryKey]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'StavkaProgramskogVodica', @level2type=N'CONSTRAINT',@level2name=N'StavkaProgramskogVodica$PrimaryKey'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Jul2022.[StavkaProgramskogVodica].[RasporedID]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'StavkaProgramskogVodica', @level2type=N'INDEX',@level2name=N'StavkaProgramskogVodica$RasporedID'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Jul2022.[StavkaProgramskogVodica].[StanicaID]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'StavkaProgramskogVodica', @level2type=N'INDEX',@level2name=N'StavkaProgramskogVodica$StanicaID'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Jul2022.[StavkaProgramskogVodica].[TipEmisijeID]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'StavkaProgramskogVodica', @level2type=N'INDEX',@level2name=N'StavkaProgramskogVodica$TipEmisijeID'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Jul2022.[StavkaProgramskogVodica]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'StavkaProgramskogVodica'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Jul2022.[StavkaProgramskogVodica].[ProgramskiVodicStavkaProgramskogVodica]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'StavkaProgramskogVodica', @level2type=N'CONSTRAINT',@level2name=N'StavkaProgramskogVodica$ProgramskiVodicStavkaProgramskogVodica'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Jul2022.[StavkaProgramskogVodica].[StanicaStavkaProgramskogVodica]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'StavkaProgramskogVodica', @level2type=N'CONSTRAINT',@level2name=N'StavkaProgramskogVodica$StanicaStavkaProgramskogVodica'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Jul2022.[StavkaProgramskogVodica].[TipEmisijeStavkaProgramskogVodica]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'StavkaProgramskogVodica', @level2type=N'CONSTRAINT',@level2name=N'StavkaProgramskogVodica$TipEmisijeStavkaProgramskogVodica'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Jul2022.[TipEmisije].[TipEmisijeID]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'TipEmisije', @level2type=N'COLUMN',@level2name=N'TipEmisijeID'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Jul2022.[TipEmisije].[Naziv]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'TipEmisije', @level2type=N'COLUMN',@level2name=N'Naziv'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Jul2022.[TipEmisije].[NadtipEmisijeID]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'TipEmisije', @level2type=N'COLUMN',@level2name=N'NadtipEmisijeID'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Jul2022.[TipEmisije].[PrimaryKey]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'TipEmisije', @level2type=N'CONSTRAINT',@level2name=N'TipEmisije$PrimaryKey'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Jul2022.[TipEmisije].[NadtipEmisijeID]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'TipEmisije', @level2type=N'INDEX',@level2name=N'TipEmisije$NadtipEmisijeID'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Jul2022.[TipEmisije].[TipEmisijeID]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'TipEmisije', @level2type=N'INDEX',@level2name=N'TipEmisije$TipEmisijeID'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Jul2022.[TipEmisije]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'TipEmisije'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Jul2022.[TipEmisije].[TipEmisijeTipEmisije]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'TipEmisije', @level2type=N'CONSTRAINT',@level2name=N'TipEmisije$TipEmisijeTipEmisije'
GO
USE [master]
GO
ALTER DATABASE [ProSoft-Jul2022] SET  READ_WRITE 
GO
