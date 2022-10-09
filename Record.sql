USE [Record]
GO
/****** Object:  Table [dbo].[record_type]    Script Date: 9/29/2022 9:29:44 PM ******/
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
/****** Object:  Table [dbo].[record_value]    Script Date: 9/29/2022 9:29:44 PM ******/
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
/****** Object:  Table [dbo].[roles]    Script Date: 9/29/2022 9:29:44 PM ******/
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
/****** Object:  Table [dbo].[user_roles]    Script Date: 9/29/2022 9:29:44 PM ******/
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
/****** Object:  Table [dbo].[users]    Script Date: 9/29/2022 9:29:44 PM ******/
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


SET IDENTITY_INSERT [dbo].[roles] ON 

GO
INSERT [dbo].[roles] ([id], [name]) VALUES (1, N'ROLE_ADMIN')
GO
INSERT [dbo].[roles] ([id], [name]) VALUES (2, N'ROLE_USER')
GO
SET IDENTITY_INSERT [dbo].[roles] OFF
GO
INSERT [dbo].[user_roles] ([user_id], [role_id]) VALUES (1, 1)
GO
INSERT [dbo].[user_roles] ([user_id], [role_id]) VALUES (1, 2)
GO
INSERT [dbo].[user_roles] ([user_id], [role_id]) VALUES (2, 2)
GO
SET IDENTITY_INSERT [dbo].[users] ON 

GO
INSERT [dbo].[users] ([id], [email], [password], [username]) VALUES (1, N'admin@gmail.com', N'$2a$10$rEMzVllGDznHFZbUhJH0n.fRIR33o3QXysUTFKzsbKwF5V28GK0XC', N'Admin')
GO
INSERT [dbo].[users] ([id], [email], [password], [username]) VALUES (2, N'user@gmail.com', N'$2a$10$Locf9fRBO84ejEc/bQFEROChVsd2ixjv4M2kYX6KSLp74iacK.N3W', N'User')
GO
SET IDENTITY_INSERT [dbo].[users] OFF
GO
SET ANSI_PADDING ON

GO
/****** Object:  Index [UK5go5bwi54dl7876oxqhu7k1es]    Script Date: 9/29/2022 9:29:44 PM ******/
ALTER TABLE [dbo].[users] ADD  CONSTRAINT [UK5go5bwi54dl7876oxqhu7k1es] UNIQUE NONCLUSTERED 
(
	[email] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
SET ANSI_PADDING ON

GO
/****** Object:  Index [UK8k5d0ggn8tv81t20gjbje6ftw]    Script Date: 9/29/2022 9:29:44 PM ******/
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
ALTER TABLE [dbo].[user_roles]  WITH CHECK ADD  CONSTRAINT [FKf7ns43r7j7nqn2u44obq60eik] FOREIGN KEY([user_id])
REFERENCES [dbo].[users] ([id])
GO
ALTER TABLE [dbo].[user_roles] CHECK CONSTRAINT [FKf7ns43r7j7nqn2u44obq60eik]
GO
ALTER TABLE [dbo].[user_roles]  WITH CHECK ADD  CONSTRAINT [FKh8ciramu9cc9q3qcqiv4ue8a6] FOREIGN KEY([role_id])
REFERENCES [dbo].[roles] ([id])
GO
ALTER TABLE [dbo].[user_roles] CHECK CONSTRAINT [FKh8ciramu9cc9q3qcqiv4ue8a6]
GO
