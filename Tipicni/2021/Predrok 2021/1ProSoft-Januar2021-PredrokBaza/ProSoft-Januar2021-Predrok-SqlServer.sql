USE [master]
GO
/****** Object:  Database [ProSoft-Januar2021-Predrok]    Script Date: 11-Jan-21 23:06:48 ******/
CREATE DATABASE [ProSoft-Januar2021-Predrok]
GO
ALTER DATABASE [ProSoft-Januar2021-Predrok] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [ProSoft-Januar2021-Predrok] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [ProSoft-Januar2021-Predrok] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [ProSoft-Januar2021-Predrok] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [ProSoft-Januar2021-Predrok] SET ARITHABORT OFF 
GO
ALTER DATABASE [ProSoft-Januar2021-Predrok] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [ProSoft-Januar2021-Predrok] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [ProSoft-Januar2021-Predrok] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [ProSoft-Januar2021-Predrok] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [ProSoft-Januar2021-Predrok] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [ProSoft-Januar2021-Predrok] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [ProSoft-Januar2021-Predrok] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [ProSoft-Januar2021-Predrok] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [ProSoft-Januar2021-Predrok] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [ProSoft-Januar2021-Predrok] SET  DISABLE_BROKER 
GO
ALTER DATABASE [ProSoft-Januar2021-Predrok] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [ProSoft-Januar2021-Predrok] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [ProSoft-Januar2021-Predrok] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [ProSoft-Januar2021-Predrok] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [ProSoft-Januar2021-Predrok] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [ProSoft-Januar2021-Predrok] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [ProSoft-Januar2021-Predrok] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [ProSoft-Januar2021-Predrok] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [ProSoft-Januar2021-Predrok] SET  MULTI_USER 
GO
ALTER DATABASE [ProSoft-Januar2021-Predrok] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [ProSoft-Januar2021-Predrok] SET DB_CHAINING OFF 
GO
ALTER DATABASE [ProSoft-Januar2021-Predrok] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [ProSoft-Januar2021-Predrok] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [ProSoft-Januar2021-Predrok] SET DELAYED_DURABILITY = DISABLED 
GO
ALTER DATABASE [ProSoft-Januar2021-Predrok] SET QUERY_STORE = OFF
GO
USE [ProSoft-Januar2021-Predrok]
GO
ALTER DATABASE SCOPED CONFIGURATION SET LEGACY_CARDINALITY_ESTIMATION = OFF;
GO
ALTER DATABASE SCOPED CONFIGURATION SET MAXDOP = 0;
GO
ALTER DATABASE SCOPED CONFIGURATION SET PARAMETER_SNIFFING = ON;
GO
ALTER DATABASE SCOPED CONFIGURATION SET QUERY_OPTIMIZER_HOTFIXES = OFF;
GO
USE [ProSoft-Januar2021-Predrok]
GO
/****** Object:  Table [dbo].[Aerodrom]    Script Date: 11-Jan-21 23:06:48 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Aerodrom](
	[AerodromID] [int] IDENTITY(1,1) NOT NULL,
	[Naziv] [nvarchar](255) NULL,
	[Kod] [nvarchar](255) NULL,
	[Adresa] [nvarchar](255) NULL,
	[Drzava] [nvarchar](255) NULL,
 CONSTRAINT [Aerodrom$PrimaryKey] PRIMARY KEY CLUSTERED 
(
	[AerodromID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Interkonekcija]    Script Date: 11-Jan-21 23:06:48 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Interkonekcija](
	[LetID] [int] NOT NULL,
	[RB] [int] NOT NULL,
	[AerodromID] [int] NULL,
	[DatumVremeLeta] [datetime] NULL,
 CONSTRAINT [Interkonekcija$PrimaryKey] PRIMARY KEY CLUSTERED 
(
	[LetID] ASC,
	[RB] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Let]    Script Date: 11-Jan-21 23:06:48 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Let](
	[LetID] [int] IDENTITY(1,1) NOT NULL,
	[DatumVremePocetka] [datetime] NULL,
	[DatumVremeKraja] [datetime] NULL,
	[Opis] [nvarchar](255) NULL,
	[TipAviona] [nvarchar](255) NULL,
	[RedovanLet] [bit] NULL,
	[PocetniAerodromID] [int] NULL,
	[KrajnjiAerodromID] [int] NULL,
 CONSTRAINT [Let$PrimaryKey] PRIMARY KEY CLUSTERED 
(
	[LetID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET IDENTITY_INSERT [dbo].[Aerodrom] ON 

INSERT [dbo].[Aerodrom] ([AerodromID], [Naziv], [Kod], [Adresa], [Drzava]) VALUES (1, N'Nikola Tesla Airport', N'BEG', N'Surcinska BB', N'Serbia')
INSERT [dbo].[Aerodrom] ([AerodromID], [Naziv], [Kod], [Adresa], [Drzava]) VALUES (2, N'Leonardo da Vinci International Airportonal Airport', N'FCO', N'Via dell'' Aeroporto di Fiumicino', N'Italy')
INSERT [dbo].[Aerodrom] ([AerodromID], [Naziv], [Kod], [Adresa], [Drzava]) VALUES (3, N'Henri Coanda International Airport', N'OTP', N'Calea Bucurestilor nr. 224 E', N'Romania')
INSERT [dbo].[Aerodrom] ([AerodromID], [Naziv], [Kod], [Adresa], [Drzava]) VALUES (4, N'Skopje International Airport', N'SKP', N'Aleksandar Makedonski, Petrovec 1043', N'Noth Macedonia')
INSERT [dbo].[Aerodrom] ([AerodromID], [Naziv], [Kod], [Adresa], [Drzava]) VALUES (5, N'Sheremetyevo International Airport', N'SVO', N'Khimki 141400, Moskovskaya oblast', N'Russia')
INSERT [dbo].[Aerodrom] ([AerodromID], [Naziv], [Kod], [Adresa], [Drzava]) VALUES (6, N'Heathrow Airport', N'LHR', N'Longford TW6', N'United Kingdom')
INSERT [dbo].[Aerodrom] ([AerodromID], [Naziv], [Kod], [Adresa], [Drzava]) VALUES (7, N'Frankfurt am Main Airport', N'FRA', N'60547 Frankfurt', N'Germany')
INSERT [dbo].[Aerodrom] ([AerodromID], [Naziv], [Kod], [Adresa], [Drzava]) VALUES (8, N'Sofia International Airport', N'SOF', N'Christopher Columbus 1', N'Bulgaria')
INSERT [dbo].[Aerodrom] ([AerodromID], [Naziv], [Kod], [Adresa], [Drzava]) VALUES (9, N'Sydney Kingsford Smith Airport', N'SYD', N'Sydney NSW 2020', N'Australia')
SET IDENTITY_INSERT [dbo].[Aerodrom] OFF
/****** Object:  Index [Interkonekcija$AerodromInterkonekcija]    Script Date: 11-Jan-21 23:06:48 ******/
CREATE NONCLUSTERED INDEX [Interkonekcija$AerodromInterkonekcija] ON [dbo].[Interkonekcija]
(
	[AerodromID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, DROP_EXISTING = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
/****** Object:  Index [Interkonekcija$InterkonekcijaAerodromID]    Script Date: 11-Jan-21 23:06:48 ******/
CREATE NONCLUSTERED INDEX [Interkonekcija$InterkonekcijaAerodromID] ON [dbo].[Interkonekcija]
(
	[AerodromID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, DROP_EXISTING = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
/****** Object:  Index [Interkonekcija$LetID]    Script Date: 11-Jan-21 23:06:48 ******/
CREATE NONCLUSTERED INDEX [Interkonekcija$LetID] ON [dbo].[Interkonekcija]
(
	[LetID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, DROP_EXISTING = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
/****** Object:  Index [Interkonekcija$LetInterkonekcija]    Script Date: 11-Jan-21 23:06:48 ******/
CREATE NONCLUSTERED INDEX [Interkonekcija$LetInterkonekcija] ON [dbo].[Interkonekcija]
(
	[LetID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, DROP_EXISTING = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
/****** Object:  Index [Let$AerodromLet]    Script Date: 11-Jan-21 23:06:48 ******/
CREATE NONCLUSTERED INDEX [Let$AerodromLet] ON [dbo].[Let]
(
	[PocetniAerodromID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, DROP_EXISTING = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
/****** Object:  Index [Let$AerodromLet2]    Script Date: 11-Jan-21 23:06:48 ******/
CREATE NONCLUSTERED INDEX [Let$AerodromLet2] ON [dbo].[Let]
(
	[KrajnjiAerodromID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, DROP_EXISTING = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
/****** Object:  Index [Let$AerodromLet3]    Script Date: 11-Jan-21 23:06:48 ******/
CREATE NONCLUSTERED INDEX [Let$AerodromLet3] ON [dbo].[Let]
(
	[KrajnjiAerodromID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, DROP_EXISTING = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
/****** Object:  Index [Let$AerodromLet4]    Script Date: 11-Jan-21 23:06:48 ******/
CREATE NONCLUSTERED INDEX [Let$AerodromLet4] ON [dbo].[Let]
(
	[KrajnjiAerodromID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, DROP_EXISTING = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
/****** Object:  Index [Let$KrajnjaStanicaID]    Script Date: 11-Jan-21 23:06:48 ******/
CREATE NONCLUSTERED INDEX [Let$KrajnjaStanicaID] ON [dbo].[Let]
(
	[KrajnjiAerodromID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, DROP_EXISTING = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
/****** Object:  Index [Let$PocetnaStanicaID]    Script Date: 11-Jan-21 23:06:48 ******/
CREATE NONCLUSTERED INDEX [Let$PocetnaStanicaID] ON [dbo].[Let]
(
	[PocetniAerodromID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, DROP_EXISTING = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
ALTER TABLE [dbo].[Interkonekcija] ADD  CONSTRAINT [DF__Interkone__LetID__2D27B809]  DEFAULT ((0)) FOR [LetID]
GO
ALTER TABLE [dbo].[Interkonekcija] ADD  CONSTRAINT [DF__Interkonekci__RB__2E1BDC42]  DEFAULT ((0)) FOR [RB]
GO
ALTER TABLE [dbo].[Interkonekcija] ADD  CONSTRAINT [DF__Interkone__Aerod__2F10007B]  DEFAULT ((0)) FOR [AerodromID]
GO
ALTER TABLE [dbo].[Let] ADD  CONSTRAINT [DF__Let__RedovanLet__300424B4]  DEFAULT ((0)) FOR [RedovanLet]
GO
ALTER TABLE [dbo].[Let] ADD  CONSTRAINT [DF__Let__PocetniAero__30F848ED]  DEFAULT ((0)) FOR [PocetniAerodromID]
GO
ALTER TABLE [dbo].[Let] ADD  CONSTRAINT [DF__Let__KrajnjiAero__31EC6D26]  DEFAULT ((0)) FOR [KrajnjiAerodromID]
GO
ALTER TABLE [dbo].[Interkonekcija]  WITH CHECK ADD  CONSTRAINT [Interkonekcija$AerodromInterkonekcija] FOREIGN KEY([AerodromID])
REFERENCES [dbo].[Aerodrom] ([AerodromID])
GO
ALTER TABLE [dbo].[Interkonekcija] CHECK CONSTRAINT [Interkonekcija$AerodromInterkonekcija]
GO
ALTER TABLE [dbo].[Interkonekcija]  WITH CHECK ADD  CONSTRAINT [Interkonekcija$LetInterkonekcija] FOREIGN KEY([LetID])
REFERENCES [dbo].[Let] ([LetID])
GO
ALTER TABLE [dbo].[Interkonekcija] CHECK CONSTRAINT [Interkonekcija$LetInterkonekcija]
GO
ALTER TABLE [dbo].[Let]  WITH CHECK ADD  CONSTRAINT [Let$AerodromLet] FOREIGN KEY([PocetniAerodromID])
REFERENCES [dbo].[Aerodrom] ([AerodromID])
GO
ALTER TABLE [dbo].[Let] CHECK CONSTRAINT [Let$AerodromLet]
GO
ALTER TABLE [dbo].[Let]  WITH CHECK ADD  CONSTRAINT [Let$AerodromLet2] FOREIGN KEY([KrajnjiAerodromID])
REFERENCES [dbo].[Aerodrom] ([AerodromID])
GO
ALTER TABLE [dbo].[Let] CHECK CONSTRAINT [Let$AerodromLet2]
GO
ALTER TABLE [dbo].[Let]  WITH CHECK ADD  CONSTRAINT [Let$AerodromLet3] FOREIGN KEY([KrajnjiAerodromID])
REFERENCES [dbo].[Aerodrom] ([AerodromID])
GO
ALTER TABLE [dbo].[Let] CHECK CONSTRAINT [Let$AerodromLet3]
GO
ALTER TABLE [dbo].[Let]  WITH CHECK ADD  CONSTRAINT [Let$AerodromLet4] FOREIGN KEY([KrajnjiAerodromID])
REFERENCES [dbo].[Aerodrom] ([AerodromID])
GO
ALTER TABLE [dbo].[Let] CHECK CONSTRAINT [Let$AerodromLet4]
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Januar2021-Predrok.[Aerodrom].[AerodromID]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'Aerodrom', @level2type=N'COLUMN',@level2name=N'AerodromID'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Januar2021-Predrok.[Aerodrom].[Naziv]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'Aerodrom', @level2type=N'COLUMN',@level2name=N'Naziv'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Januar2021-Predrok.[Aerodrom].[Kod]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'Aerodrom', @level2type=N'COLUMN',@level2name=N'Kod'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Januar2021-Predrok.[Aerodrom].[Adresa]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'Aerodrom', @level2type=N'COLUMN',@level2name=N'Adresa'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Januar2021-Predrok.[Aerodrom].[Drzava]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'Aerodrom', @level2type=N'COLUMN',@level2name=N'Drzava'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Januar2021-Predrok.[Aerodrom].[PrimaryKey]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'Aerodrom', @level2type=N'CONSTRAINT',@level2name=N'Aerodrom$PrimaryKey'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Januar2021-Predrok.[Aerodrom]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'Aerodrom'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Januar2021-Predrok.[Interkonekcija].[LetID]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'Interkonekcija', @level2type=N'COLUMN',@level2name=N'LetID'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Januar2021-Predrok.[Interkonekcija].[RB]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'Interkonekcija', @level2type=N'COLUMN',@level2name=N'RB'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Januar2021-Predrok.[Interkonekcija].[AerodromID]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'Interkonekcija', @level2type=N'COLUMN',@level2name=N'AerodromID'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Januar2021-Predrok.[Interkonekcija].[DatumVremeLeta]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'Interkonekcija', @level2type=N'COLUMN',@level2name=N'DatumVremeLeta'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Januar2021-Predrok.[Interkonekcija].[PrimaryKey]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'Interkonekcija', @level2type=N'CONSTRAINT',@level2name=N'Interkonekcija$PrimaryKey'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Januar2021-Predrok.[Interkonekcija].[AerodromInterkonekcija]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'Interkonekcija', @level2type=N'INDEX',@level2name=N'Interkonekcija$AerodromInterkonekcija'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Januar2021-Predrok.[Interkonekcija].[InterkonekcijaAerodromID]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'Interkonekcija', @level2type=N'INDEX',@level2name=N'Interkonekcija$InterkonekcijaAerodromID'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Januar2021-Predrok.[Interkonekcija].[LetID]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'Interkonekcija', @level2type=N'INDEX',@level2name=N'Interkonekcija$LetID'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Januar2021-Predrok.[Interkonekcija].[LetInterkonekcija]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'Interkonekcija', @level2type=N'INDEX',@level2name=N'Interkonekcija$LetInterkonekcija'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Januar2021-Predrok.[Interkonekcija]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'Interkonekcija'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Januar2021-Predrok.[Interkonekcija].[AerodromInterkonekcija]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'Interkonekcija', @level2type=N'CONSTRAINT',@level2name=N'Interkonekcija$AerodromInterkonekcija'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Januar2021-Predrok.[Interkonekcija].[LetInterkonekcija]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'Interkonekcija', @level2type=N'CONSTRAINT',@level2name=N'Interkonekcija$LetInterkonekcija'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Januar2021-Predrok.[Let].[LetID]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'Let', @level2type=N'COLUMN',@level2name=N'LetID'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Januar2021-Predrok.[Let].[DatumVremePocetka]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'Let', @level2type=N'COLUMN',@level2name=N'DatumVremePocetka'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Januar2021-Predrok.[Let].[DatumVremeKraja]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'Let', @level2type=N'COLUMN',@level2name=N'DatumVremeKraja'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Januar2021-Predrok.[Let].[Opis]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'Let', @level2type=N'COLUMN',@level2name=N'Opis'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Januar2021-Predrok.[Let].[TipAviona]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'Let', @level2type=N'COLUMN',@level2name=N'TipAviona'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Januar2021-Predrok.[Let].[RedovanLet]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'Let', @level2type=N'COLUMN',@level2name=N'RedovanLet'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Januar2021-Predrok.[Let].[PocetniAerodromID]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'Let', @level2type=N'COLUMN',@level2name=N'PocetniAerodromID'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Januar2021-Predrok.[Let].[KrajnjiAerodromID]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'Let', @level2type=N'COLUMN',@level2name=N'KrajnjiAerodromID'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Januar2021-Predrok.[Let].[PrimaryKey]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'Let', @level2type=N'CONSTRAINT',@level2name=N'Let$PrimaryKey'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Januar2021-Predrok.[Let].[AerodromLet]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'Let', @level2type=N'INDEX',@level2name=N'Let$AerodromLet'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Januar2021-Predrok.[Let].[AerodromLet2]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'Let', @level2type=N'INDEX',@level2name=N'Let$AerodromLet2'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Januar2021-Predrok.[Let].[AerodromLet3]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'Let', @level2type=N'INDEX',@level2name=N'Let$AerodromLet3'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Januar2021-Predrok.[Let].[AerodromLet4]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'Let', @level2type=N'INDEX',@level2name=N'Let$AerodromLet4'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Januar2021-Predrok.[Let].[KrajnjaStanicaID]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'Let', @level2type=N'INDEX',@level2name=N'Let$KrajnjaStanicaID'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Januar2021-Predrok.[Let].[PocetnaStanicaID]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'Let', @level2type=N'INDEX',@level2name=N'Let$PocetnaStanicaID'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Januar2021-Predrok.[Let]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'Let'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Januar2021-Predrok.[Let].[AerodromLet]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'Let', @level2type=N'CONSTRAINT',@level2name=N'Let$AerodromLet'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Januar2021-Predrok.[Let].[AerodromLet2]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'Let', @level2type=N'CONSTRAINT',@level2name=N'Let$AerodromLet2'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Januar2021-Predrok.[Let].[AerodromLet3]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'Let', @level2type=N'CONSTRAINT',@level2name=N'Let$AerodromLet3'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Januar2021-Predrok.[Let].[AerodromLet4]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'Let', @level2type=N'CONSTRAINT',@level2name=N'Let$AerodromLet4'
GO
USE [master]
GO
ALTER DATABASE [ProSoft-Januar2021-Predrok] SET  READ_WRITE 
GO
