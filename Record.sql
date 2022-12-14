USE [Record]
GO
/****** Object:  Table [dbo].[record_type]    Script Date: 04-Nov-22 11:52:42 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[record_type](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[name] [varchar](255) NOT NULL,
	[column1] [varchar](255) NULL,
	[column2] [varchar](255) NULL,
	[column3] [varchar](255) NULL,
	[column4] [varchar](255) NULL,
	[column5] [varchar](255) NULL,
	[column6] [varchar](255) NULL,
	[column7] [varchar](255) NULL,
	[column8] [varchar](255) NULL,
	[column9] [varchar](255) NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[record_value]    Script Date: 04-Nov-22 11:52:42 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[record_value](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[record_type] [int] NULL,
	[name] [varchar](255) NOT NULL,
	[column1] [varchar](255) NULL,
	[column2] [varchar](255) NULL,
	[column3] [varchar](255) NULL,
	[column4] [varchar](255) NULL,
	[column5] [varchar](255) NULL,
	[column6] [varchar](255) NULL,
	[column7] [varchar](255) NULL,
	[column8] [varchar](255) NULL,
	[column9] [varchar](255) NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[roles]    Script Date: 04-Nov-22 11:52:42 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[roles](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[name] [varchar](20) NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[user_roles]    Script Date: 04-Nov-22 11:52:42 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[user_roles](
	[user_id] [int] NOT NULL,
	[role_id] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[user_id] ASC,
	[role_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[users]    Script Date: 04-Nov-22 11:52:42 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[users](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[username] [varchar](20) NULL,
	[password] [varchar](120) NULL,
	[email] [varchar](50) NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
SET IDENTITY_INSERT [dbo].[record_type] ON 

INSERT [dbo].[record_type] ([id], [name], [column1], [column2], [column3], [column4], [column5], [column6], [column7], [column8], [column9]) VALUES (2, N'Laptop', N'Tip i model', N'Procesor', N'Broj jezgara', N'Hard disk', N'Graficka', N'Ram memorija', NULL, NULL, NULL)
INSERT [dbo].[record_type] ([id], [name], [column1], [column2], [column3], [column4], [column5], [column6], [column7], [column8], [column9]) VALUES (3, N'Desktop', N'Tip i model', N'Procesor', N'Broj jezgara', N'Hard disk', N'Graficka', N'Ram memorija', N'Ekran', N'Tastatura', N'Mis')
INSERT [dbo].[record_type] ([id], [name], [column1], [column2], [column3], [column4], [column5], [column6], [column7], [column8], [column9]) VALUES (4, N'Stampac', N'Tip i model', N'Rezolucija', N'Format papira', NULL, NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[record_type] ([id], [name], [column1], [column2], [column3], [column4], [column5], [column6], [column7], [column8], [column9]) VALUES (5, N'Mobilni telefon', N'Tip i model', N'Baterija', N'Kamera', N'Procesor', N'Memorija', N'Ekran', NULL, NULL, NULL)
SET IDENTITY_INSERT [dbo].[record_type] OFF
SET IDENTITY_INSERT [dbo].[record_value] ON 

INSERT [dbo].[record_value] ([id], [record_type], [name], [column1], [column2], [column3], [column4], [column5], [column6], [column7], [column8], [column9]) VALUES (1, 2, N'Dell Laptop', N'Vostro 3510 NOT18556', N'Intel Core i3-1115G4', N'Dual-Core', N'256 GB M.2 NVMe SSD', N'Integrisana Intel UHD', N'DDR4 - 2666 MHz', NULL, NULL, NULL)
INSERT [dbo].[record_value] ([id], [record_type], [name], [column1], [column2], [column3], [column4], [column5], [column6], [column7], [column8], [column9]) VALUES (2, 2, N'Asus Laptop', N'UX363JA-WB502T', N'Intel Core i5', N'Quad Core', N'512 GB M.2 NVMe PCIe 3.0 N/A', N'Intel Iris Plus', N'8 GB DDR4', NULL, NULL, NULL)
INSERT [dbo].[record_value] ([id], [record_type], [name], [column1], [column2], [column3], [column4], [column5], [column6], [column7], [column8], [column9]) VALUES (3, 2, N'Lenovo Laptop', N'ThinkPad X1 Carbon', N'Intel i5-10210U', N'Quad Core', N'512 GB SSD', N'Intel UHD Graphics', N'8 GB DDR3', NULL, NULL, NULL)
INSERT [dbo].[record_value] ([id], [record_type], [name], [column1], [column2], [column3], [column4], [column5], [column6], [column7], [column8], [column9]) VALUES (4, 3, N'Asus Desktop', N'D300TA-3101001220', N'Intel Core i3', N'Quad Core', N'256 GB SSD + 1 TB HDD', NULL, N'8 GB DDR3', NULL, NULL, NULL)
INSERT [dbo].[record_value] ([id], [record_type], [name], [column1], [column2], [column3], [column4], [column5], [column6], [column7], [column8], [column9]) VALUES (5, 3, N'Lenovo Desktop', N'ThinkCentre neo 50t', N'Intel i5-12400', N'hexa-core', N'512 GB SSD', N'Intel UHD 730', N'16 GB DDR3', N'Samsung 24', N'Logitech K230 US', N'Logitech')
INSERT [dbo].[record_value] ([id], [record_type], [name], [column1], [column2], [column3], [column4], [column5], [column6], [column7], [column8], [column9]) VALUES (6, 3, N'Dell Desktop', N'OptiPlex 3090 SF', N'Intel Core i5-10505', N'Quad Core', N'256 GB SSD', N'Intel UHD Graphics 630', N'8 GB DDR4', NULL, NULL, N'Dell MS116 Optical')
INSERT [dbo].[record_value] ([id], [record_type], [name], [column1], [column2], [column3], [column4], [column5], [column6], [column7], [column8], [column9]) VALUES (7, 2, N'HP Laptop', N'G8 59T76EA', N'Intel i3-1005G1', N'Dual Core', N'256 GB PCIe NVMe SSD', N'Intel UHD', N'256 GB SSD', NULL, NULL, NULL)
INSERT [dbo].[record_value] ([id], [record_type], [name], [column1], [column2], [column3], [column4], [column5], [column6], [column7], [column8], [column9]) VALUES (8, 2, N'Acer Laptop', N'NX.HPMEX.007', N'Intel Core i7', N'Quad Core', N'512 GB SSD', N'Intel UHD Graphics', N' 8 GB DDR4 SDRAM', NULL, NULL, NULL)
INSERT [dbo].[record_value] ([id], [record_type], [name], [column1], [column2], [column3], [column4], [column5], [column6], [column7], [column8], [column9]) VALUES (9, 2, N'HP Laptop', N'G8 32M87EA', N'AMD', N'Dual Core', N'1 TB HDD', N'Integrisana AMD', N'4 GB DDR4 - 2400 MHz', NULL, NULL, NULL)
INSERT [dbo].[record_value] ([id], [record_type], [name], [column1], [column2], [column3], [column4], [column5], [column6], [column7], [column8], [column9]) VALUES (10, 2, N'Lenovo laptop', N'IP 5 82FE00J0YA', N'Intel i7-1165G7', N'Quad Core', N'512 GB SSD', N' Integrisana Intel', N'16 GB DDR4 - 3200 MHz', NULL, NULL, NULL)
INSERT [dbo].[record_value] ([id], [record_type], [name], [column1], [column2], [column3], [column4], [column5], [column6], [column7], [column8], [column9]) VALUES (11, 3, N'HUAWEI Desktop', N'MATESTATION S', N'AMD Ryzen 5 4600G', N'Quad Core', N'256 GB M.2 NVMe SSD', N'Radeon - integrisana', N'8 GB DDR4 - 3200 MHz', N'Tesla Monitor 24MC625BF', NULL, NULL)
INSERT [dbo].[record_value] ([id], [record_type], [name], [column1], [column2], [column3], [column4], [column5], [column6], [column7], [column8], [column9]) VALUES (12, 3, N'HP Desktop', N'290 G4 MT 47M23EA', N'Intel i5-10400', N'hexa-core', N'256 GB SSD', N'Intel UHD', N'8 GB DDR4 -2666 MHz', NULL, N'Logitech K230 US', N'Dell MS116 Optical')
INSERT [dbo].[record_value] ([id], [record_type], [name], [column1], [column2], [column3], [column4], [column5], [column6], [column7], [column8], [column9]) VALUES (13, 4, N'Epson', N'L1250', N'5760 x 1440 dpi', N'A4 (21 cm x 29,7 cm)', NULL, NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[record_value] ([id], [record_type], [name], [column1], [column2], [column3], [column4], [column5], [column6], [column7], [column8], [column9]) VALUES (14, 4, N'HP Laserski', N'107W 4ZB78A', N'1200 x 1200 dpi', N'A4, A5, A5(LEF), B5 (JIS)', NULL, NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[record_value] ([id], [record_type], [name], [column1], [column2], [column3], [column4], [column5], [column6], [column7], [column8], [column9]) VALUES (15, 5, N'Nokia', N'C20', N'3000 mAh', N'16 MP', N'Octa Core', N'32 GB', N'IPS + LCD', NULL, NULL, NULL)
INSERT [dbo].[record_value] ([id], [record_type], [name], [column1], [column2], [column3], [column4], [column5], [column6], [column7], [column8], [column9]) VALUES (16, 5, N'iPhone 11', N'MHDD3SE/A', N'4500 mAh', N'12 MP', N'Octa Core', N'64 GB', N'Liquid Retina HD', NULL, NULL, NULL)
INSERT [dbo].[record_value] ([id], [record_type], [name], [column1], [column2], [column3], [column4], [column5], [column6], [column7], [column8], [column9]) VALUES (17, 5, N'ZTE Blade', N'A71', N'4000 mAh', N'20 MP', N'Octa Core', N'64 GB', N'HD+ Waterdrop', NULL, NULL, NULL)
INSERT [dbo].[record_value] ([id], [record_type], [name], [column1], [column2], [column3], [column4], [column5], [column6], [column7], [column8], [column9]) VALUES (18, 3, N'Phone', N'IdeaPad 3 15ALC6', N'sdfsdfsdf', N'zxfbvzxv', N'16 GB DDR4', N'256 GB SSD + 1 TB HDD', N'128 GB', NULL, NULL, NULL)
SET IDENTITY_INSERT [dbo].[record_value] OFF
SET IDENTITY_INSERT [dbo].[roles] ON 

INSERT [dbo].[roles] ([id], [name]) VALUES (1, N'ROLE_ADMIN')
INSERT [dbo].[roles] ([id], [name]) VALUES (2, N'ROLE_USER')
SET IDENTITY_INSERT [dbo].[roles] OFF
INSERT [dbo].[user_roles] ([user_id], [role_id]) VALUES (1, 1)
INSERT [dbo].[user_roles] ([user_id], [role_id]) VALUES (1, 2)
INSERT [dbo].[user_roles] ([user_id], [role_id]) VALUES (2, 2)
INSERT [dbo].[user_roles] ([user_id], [role_id]) VALUES (3, 2)
INSERT [dbo].[user_roles] ([user_id], [role_id]) VALUES (4, 1)
SET IDENTITY_INSERT [dbo].[users] ON 

INSERT [dbo].[users] ([id], [username], [password], [email]) VALUES (1, N'Admin', N'$2a$10$rEMzVllGDznHFZbUhJH0n.fRIR33o3QXysUTFKzsbKwF5V28GK0XC', N'admin@gmail.com')
INSERT [dbo].[users] ([id], [username], [password], [email]) VALUES (2, N'User', N'$2a$10$Locf9fRBO84ejEc/bQFEROChVsd2ixjv4M2kYX6KSLp74iacK.N3W', N'user@gmail.com')
SET IDENTITY_INSERT [dbo].[users] OFF
SET ANSI_PADDING ON

GO
/****** Object:  Index [UK5go5bwi54dl7876oxqhu7k1es]    Script Date: 04-Nov-22 11:52:42 AM ******/
ALTER TABLE [dbo].[users] ADD  CONSTRAINT [UK5go5bwi54dl7876oxqhu7k1es] UNIQUE NONCLUSTERED 
(
	[email] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
SET ANSI_PADDING ON

GO
/****** Object:  Index [UK8k5d0ggn8tv81t20gjbje6ftw]    Script Date: 04-Nov-22 11:52:42 AM ******/
ALTER TABLE [dbo].[users] ADD  CONSTRAINT [UK8k5d0ggn8tv81t20gjbje6ftw] UNIQUE NONCLUSTERED 
(
	[username] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
ALTER TABLE [dbo].[record_value]  WITH CHECK ADD  CONSTRAINT [FKk0xeb7gunmwbnnap8r1adat6s] FOREIGN KEY([record_type])
REFERENCES [dbo].[record_type] ([id])
GO
ALTER TABLE [dbo].[record_value] CHECK CONSTRAINT [FKk0xeb7gunmwbnnap8r1adat6s]
GO
ALTER TABLE [dbo].[user_roles]  WITH CHECK ADD  CONSTRAINT [FKh8ciramu9cc9q3qcqiv4ue8a6] FOREIGN KEY([role_id])
REFERENCES [dbo].[roles] ([id])
GO
ALTER TABLE [dbo].[user_roles] CHECK CONSTRAINT [FKh8ciramu9cc9q3qcqiv4ue8a6]
GO
