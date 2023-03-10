USE [master]
GO
/****** Object:  Database [ProSoft-Mart-2021]    Script Date: 25-Mar-21 23:18:23 ******/
CREATE DATABASE [ProSoft-Mart-2021]
GO
ALTER DATABASE [ProSoft-Mart-2021] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [ProSoft-Mart-2021] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [ProSoft-Mart-2021] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [ProSoft-Mart-2021] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [ProSoft-Mart-2021] SET ARITHABORT OFF 
GO
ALTER DATABASE [ProSoft-Mart-2021] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [ProSoft-Mart-2021] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [ProSoft-Mart-2021] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [ProSoft-Mart-2021] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [ProSoft-Mart-2021] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [ProSoft-Mart-2021] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [ProSoft-Mart-2021] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [ProSoft-Mart-2021] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [ProSoft-Mart-2021] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [ProSoft-Mart-2021] SET  DISABLE_BROKER 
GO
ALTER DATABASE [ProSoft-Mart-2021] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [ProSoft-Mart-2021] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [ProSoft-Mart-2021] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [ProSoft-Mart-2021] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [ProSoft-Mart-2021] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [ProSoft-Mart-2021] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [ProSoft-Mart-2021] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [ProSoft-Mart-2021] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [ProSoft-Mart-2021] SET  MULTI_USER 
GO
ALTER DATABASE [ProSoft-Mart-2021] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [ProSoft-Mart-2021] SET DB_CHAINING OFF 
GO
ALTER DATABASE [ProSoft-Mart-2021] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [ProSoft-Mart-2021] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [ProSoft-Mart-2021] SET DELAYED_DURABILITY = DISABLED 
GO
ALTER DATABASE [ProSoft-Mart-2021] SET QUERY_STORE = OFF
GO
USE [ProSoft-Mart-2021]
GO
ALTER DATABASE SCOPED CONFIGURATION SET LEGACY_CARDINALITY_ESTIMATION = OFF;
GO
ALTER DATABASE SCOPED CONFIGURATION SET MAXDOP = 0;
GO
ALTER DATABASE SCOPED CONFIGURATION SET PARAMETER_SNIFFING = ON;
GO
ALTER DATABASE SCOPED CONFIGURATION SET QUERY_OPTIMIZER_HOTFIXES = OFF;
GO
USE [ProSoft-Mart-2021]
GO
/****** Object:  Table [dbo].[Reprezentacija]    Script Date: 25-Mar-21 23:18:23 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Reprezentacija](
	[ReprezentacijaID] [int] NOT NULL,
	[Naziv] [nvarchar](255) NULL,
 CONSTRAINT [Reprezentacija$PrimaryKey] PRIMARY KEY CLUSTERED 
(
	[ReprezentacijaID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Utakmica]    Script Date: 25-Mar-21 23:18:23 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Utakmica](
	[UtakmicaID] [int] NOT NULL,
	[Grupa] [nvarchar](255) NULL,
	[DomacinID] [int] NULL,
	[GostID] [int] NULL,
	[GolovaDomacin] [int] NULL,
	[GolovaGost] [int] NULL,
 CONSTRAINT [Utakmica$PrimaryKey] PRIMARY KEY CLUSTERED 
(
	[UtakmicaID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
INSERT [dbo].[Reprezentacija] ([ReprezentacijaID], [Naziv]) VALUES (1, N'Italija')
INSERT [dbo].[Reprezentacija] ([ReprezentacijaID], [Naziv]) VALUES (2, N'Belgija')
INSERT [dbo].[Reprezentacija] ([ReprezentacijaID], [Naziv]) VALUES (3, N'Irska')
INSERT [dbo].[Reprezentacija] ([ReprezentacijaID], [Naziv]) VALUES (4, N'Svedska')
INSERT [dbo].[Reprezentacija] ([ReprezentacijaID], [Naziv]) VALUES (5, N'Madjarska')
INSERT [dbo].[Reprezentacija] ([ReprezentacijaID], [Naziv]) VALUES (6, N'Island')
INSERT [dbo].[Reprezentacija] ([ReprezentacijaID], [Naziv]) VALUES (7, N'Portugal')
INSERT [dbo].[Reprezentacija] ([ReprezentacijaID], [Naziv]) VALUES (8, N'Austrija')
GO
INSERT [dbo].[Utakmica] ([UtakmicaID], [Grupa], [DomacinID], [GostID], [GolovaDomacin], [GolovaGost]) VALUES (1, N'E', 3, 4, NULL, NULL)
INSERT [dbo].[Utakmica] ([UtakmicaID], [Grupa], [DomacinID], [GostID], [GolovaDomacin], [GolovaGost]) VALUES (2, N'E', 2, 1, NULL, NULL)
INSERT [dbo].[Utakmica] ([UtakmicaID], [Grupa], [DomacinID], [GostID], [GolovaDomacin], [GolovaGost]) VALUES (3, N'E', 1, 4, NULL, NULL)
INSERT [dbo].[Utakmica] ([UtakmicaID], [Grupa], [DomacinID], [GostID], [GolovaDomacin], [GolovaGost]) VALUES (4, N'E', 2, 3, NULL, NULL)
INSERT [dbo].[Utakmica] ([UtakmicaID], [Grupa], [DomacinID], [GostID], [GolovaDomacin], [GolovaGost]) VALUES (5, N'E', 1, 2, NULL, NULL)
INSERT [dbo].[Utakmica] ([UtakmicaID], [Grupa], [DomacinID], [GostID], [GolovaDomacin], [GolovaGost]) VALUES (6, N'E', 4, 2, NULL, NULL)
INSERT [dbo].[Utakmica] ([UtakmicaID], [Grupa], [DomacinID], [GostID], [GolovaDomacin], [GolovaGost]) VALUES (7, N'F', 8, 5, NULL, NULL)
INSERT [dbo].[Utakmica] ([UtakmicaID], [Grupa], [DomacinID], [GostID], [GolovaDomacin], [GolovaGost]) VALUES (8, N'F', 7, 6, NULL, NULL)
INSERT [dbo].[Utakmica] ([UtakmicaID], [Grupa], [DomacinID], [GostID], [GolovaDomacin], [GolovaGost]) VALUES (9, N'F', 6, 5, NULL, NULL)
INSERT [dbo].[Utakmica] ([UtakmicaID], [Grupa], [DomacinID], [GostID], [GolovaDomacin], [GolovaGost]) VALUES (10, N'F', 7, 8, NULL, NULL)
INSERT [dbo].[Utakmica] ([UtakmicaID], [Grupa], [DomacinID], [GostID], [GolovaDomacin], [GolovaGost]) VALUES (11, N'F', 6, 8, NULL, NULL)
INSERT [dbo].[Utakmica] ([UtakmicaID], [Grupa], [DomacinID], [GostID], [GolovaDomacin], [GolovaGost]) VALUES (12, N'F', 5, 7, NULL, NULL)
GO
/****** Object:  Index [Reprezentacija$ReprezentacijaID]    Script Date: 25-Mar-21 23:18:23 ******/
CREATE NONCLUSTERED INDEX [Reprezentacija$ReprezentacijaID] ON [dbo].[Reprezentacija]
(
	[ReprezentacijaID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, DROP_EXISTING = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
/****** Object:  Index [Utakmica$GostID]    Script Date: 25-Mar-21 23:18:23 ******/
CREATE NONCLUSTERED INDEX [Utakmica$GostID] ON [dbo].[Utakmica]
(
	[GostID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, DROP_EXISTING = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
/****** Object:  Index [Utakmica$UtakmicaID]    Script Date: 25-Mar-21 23:18:23 ******/
CREATE NONCLUSTERED INDEX [Utakmica$UtakmicaID] ON [dbo].[Utakmica]
(
	[UtakmicaID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, DROP_EXISTING = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
ALTER TABLE [dbo].[Reprezentacija] ADD  DEFAULT ((0)) FOR [ReprezentacijaID]
GO
ALTER TABLE [dbo].[Utakmica] ADD  DEFAULT ((0)) FOR [UtakmicaID]
GO
ALTER TABLE [dbo].[Utakmica] ADD  DEFAULT ((0)) FOR [DomacinID]
GO
ALTER TABLE [dbo].[Utakmica] ADD  DEFAULT ((0)) FOR [GostID]
GO
ALTER TABLE [dbo].[Utakmica] ADD  DEFAULT ((0)) FOR [GolovaDomacin]
GO
ALTER TABLE [dbo].[Utakmica] ADD  DEFAULT ((0)) FOR [GolovaGost]
GO
ALTER TABLE [dbo].[Utakmica]  WITH NOCHECK ADD  CONSTRAINT [Utakmica$ReprezentacijaUtakmica] FOREIGN KEY([DomacinID])
REFERENCES [dbo].[Reprezentacija] ([ReprezentacijaID])
GO
ALTER TABLE [dbo].[Utakmica] CHECK CONSTRAINT [Utakmica$ReprezentacijaUtakmica]
GO
ALTER TABLE [dbo].[Utakmica]  WITH NOCHECK ADD  CONSTRAINT [Utakmica$ReprezentacijaUtakmica1] FOREIGN KEY([GostID])
REFERENCES [dbo].[Reprezentacija] ([ReprezentacijaID])
GO
ALTER TABLE [dbo].[Utakmica] CHECK CONSTRAINT [Utakmica$ReprezentacijaUtakmica1]
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Mart2021.[Reprezentacija].[ReprezentacijaID]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'Reprezentacija', @level2type=N'COLUMN',@level2name=N'ReprezentacijaID'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Mart2021.[Reprezentacija].[Naziv]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'Reprezentacija', @level2type=N'COLUMN',@level2name=N'Naziv'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Mart2021.[Reprezentacija].[PrimaryKey]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'Reprezentacija', @level2type=N'CONSTRAINT',@level2name=N'Reprezentacija$PrimaryKey'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Mart2021.[Reprezentacija].[ReprezentacijaID]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'Reprezentacija', @level2type=N'INDEX',@level2name=N'Reprezentacija$ReprezentacijaID'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Mart2021.[Reprezentacija]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'Reprezentacija'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Mart2021.[Utakmica].[UtakmicaID]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'Utakmica', @level2type=N'COLUMN',@level2name=N'UtakmicaID'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Mart2021.[Utakmica].[Grupa]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'Utakmica', @level2type=N'COLUMN',@level2name=N'Grupa'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Mart2021.[Utakmica].[DomacinID]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'Utakmica', @level2type=N'COLUMN',@level2name=N'DomacinID'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Mart2021.[Utakmica].[GostID]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'Utakmica', @level2type=N'COLUMN',@level2name=N'GostID'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Mart2021.[Utakmica].[GolovaDomacin]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'Utakmica', @level2type=N'COLUMN',@level2name=N'GolovaDomacin'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Mart2021.[Utakmica].[GolovaGost]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'Utakmica', @level2type=N'COLUMN',@level2name=N'GolovaGost'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Mart2021.[Utakmica].[PrimaryKey]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'Utakmica', @level2type=N'CONSTRAINT',@level2name=N'Utakmica$PrimaryKey'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Mart2021.[Utakmica].[GostID]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'Utakmica', @level2type=N'INDEX',@level2name=N'Utakmica$GostID'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Mart2021.[Utakmica].[UtakmicaID]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'Utakmica', @level2type=N'INDEX',@level2name=N'Utakmica$UtakmicaID'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Mart2021.[Utakmica]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'Utakmica'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Mart2021.[Utakmica].[ReprezentacijaUtakmica]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'Utakmica', @level2type=N'CONSTRAINT',@level2name=N'Utakmica$ReprezentacijaUtakmica'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'ProSoft-Mart2021.[Utakmica].[ReprezentacijaUtakmica1]' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'Utakmica', @level2type=N'CONSTRAINT',@level2name=N'Utakmica$ReprezentacijaUtakmica1'
GO
USE [master]
GO
ALTER DATABASE [ProSoft-Mart-2021] SET  READ_WRITE 
GO
