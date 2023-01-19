USE [master]
GO
/****** Object:  Database [ProSoft-Februar2021]    Script Date: 06-Feb-21 10:19:57 ******/
CREATE DATABASE [ProSoft-Februar2021-G2]
GO
GO
USE [ProSoft-Februar2021-G2]
GO
/****** Object:  Table [dbo].[Lokacija]    Script Date: 06-Feb-21 10:19:57 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Lokacija](
	[LokacijaID] [int] IDENTITY(1,1) NOT NULL,
	[PttBroj] [int] NULL,
	[Naziv] [nvarchar](255) NULL,
 CONSTRAINT [Lokacija$PrimaryKey] PRIMARY KEY CLUSTERED 
(
	[LokacijaID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Prijava]    Script Date: 06-Feb-21 10:19:57 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Prijava](
	[PrijavaID] [int] IDENTITY(1,1) NOT NULL,
	[JMBG] [nvarchar](255) NOT NULL,
	[Ime] [nvarchar](255) NOT NULL,
	[Prezime] [nvarchar](255) NOT NULL,
	[ElektronskaPosta] [nvarchar](255) NOT NULL,
	[Telefon] [nvarchar](255) NOT NULL,
	[ZdravstvenoOsiguran] [bit] NULL,
	[DatumPrijave] [datetime] NOT NULL,
	[StrucnaSprema] [nvarchar](255) NOT NULL,
	[LokacijaID] [int] NOT NULL,
 CONSTRAINT [Prijava$PrimaryKey] PRIMARY KEY CLUSTERED 
(
	[PrijavaID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[StavkaPrijave]    Script Date: 06-Feb-21 10:19:57 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[StavkaPrijave](
	[PrijavaID] [int] NOT NULL,
	[RB] [int] NOT NULL,
	[VrstaVolontiranja] [nvarchar](255) NULL,
 CONSTRAINT [StavkaPrijave$PrimaryKey] PRIMARY KEY CLUSTERED 
(
	[PrijavaID] ASC,
	[RB] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET IDENTITY_INSERT [dbo].[Lokacija] ON 

INSERT [dbo].[Lokacija] ([LokacijaID], [PttBroj], [Naziv]) VALUES (1, 11000, N'Savski venac')
INSERT [dbo].[Lokacija] ([LokacijaID], [PttBroj], [Naziv]) VALUES (2, 11000, N'Stari grad')
INSERT [dbo].[Lokacija] ([LokacijaID], [PttBroj], [Naziv]) VALUES (3, 11000, N'Vracar')
INSERT [dbo].[Lokacija] ([LokacijaID], [PttBroj], [Naziv]) VALUES (4, 11010, N'Vozdovac')
INSERT [dbo].[Lokacija] ([LokacijaID], [PttBroj], [Naziv]) VALUES (5, 11030, N'Cukarica')
INSERT [dbo].[Lokacija] ([LokacijaID], [PttBroj], [Naziv]) VALUES (6, 11050, N'Zvezdara')
INSERT [dbo].[Lokacija] ([LokacijaID], [PttBroj], [Naziv]) VALUES (7, 11060, N'Palilula')
INSERT [dbo].[Lokacija] ([LokacijaID], [PttBroj], [Naziv]) VALUES (8, 11070, N'Novi Beograd')
INSERT [dbo].[Lokacija] ([LokacijaID], [PttBroj], [Naziv]) VALUES (9, 11080, N'Zemun')
INSERT [dbo].[Lokacija] ([LokacijaID], [PttBroj], [Naziv]) VALUES (10, 11090, N'Rakovica')
INSERT [dbo].[Lokacija] ([LokacijaID], [PttBroj], [Naziv]) VALUES (11, 11460, N'Barajevo')
INSERT [dbo].[Lokacija] ([LokacijaID], [PttBroj], [Naziv]) VALUES (12, 11306, N'Grocka')
INSERT [dbo].[Lokacija] ([LokacijaID], [PttBroj], [Naziv]) VALUES (13, 11550, N'Lazarevac')
INSERT [dbo].[Lokacija] ([LokacijaID], [PttBroj], [Naziv]) VALUES (14, 11400, N'Mladenovac')
INSERT [dbo].[Lokacija] ([LokacijaID], [PttBroj], [Naziv]) VALUES (15, 11500, N'Obrenovac')
INSERT [dbo].[Lokacija] ([LokacijaID], [PttBroj], [Naziv]) VALUES (16, 11450, N'Sopot')
INSERT [dbo].[Lokacija] ([LokacijaID], [PttBroj], [Naziv]) VALUES (17, 11271, N'Surcin')
SET IDENTITY_INSERT [dbo].[Lokacija] OFF
GO
USE [master]
GO
ALTER DATABASE [ProSoft-Februar2021-G2] SET  READ_WRITE 
GO
