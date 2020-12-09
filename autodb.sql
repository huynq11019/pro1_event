USE [PRO1_E2]
GO
/****** Object:  StoredProcedure [dbo].[reportTask]    Script Date: 12/10/2020 2:45:25 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[reportTask]
@idsk int, @idgd int
as 
begin
	if @idgd = -1
	begin
		select NHANVIEN.TENNV,GIADOAN.TENGD,NHIEMVU.TENNVU,NHIEMVU.TRANGTHAI, GIADOAN.IDSK from NHIEMVU inner join PHANCONG on NHIEMVU.IDNVU = PHANCONG.IDNVU inner join NHANVIEN on PHANCONG.IDNVIEN = NHANVIEN.IDNV inner  join GIADOAN on NHIEMVU.IDGIAIDOAN = GIADOAN.IDGIAODOAN 
		where IDSK = @idsk
		order by NHIEMVU.TRANGTHAI desc 
	end
	else
	begin
		 select NHANVIEN.TENNV,GIADOAN.TENGD,NHIEMVU.TENNVU,NHIEMVU.TRANGTHAI, GIADOAN.IDSK from NHIEMVU inner join PHANCONG on NHIEMVU.IDNVU = PHANCONG.IDNVU inner join NHANVIEN on PHANCONG.IDNVIEN = NHANVIEN.IDNV inner  join GIADOAN on NHIEMVU.IDGIAIDOAN = GIADOAN.IDGIAODOAN 
		where IDSK = @idsk and NHIEMVU.IDGIAIDOAN = @idgd
		order by NHIEMVU.TRANGTHAI desc
	end

end
GO
/****** Object:  StoredProcedure [dbo].[selectPC]    Script Date: 12/10/2020 2:45:25 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[selectPC]
@idBan nvarchar(15),@idnvu int
as 
begin 

if @idBan = 'ALL'
	begin
	 select distinct NHANVIEN.IDNV,TENNV+'-'+IDBAN as 'TENNV' ,truyVancon.IDNVU 
	from NHANVIEN left join (select IDNVU,IDNVIEN from PHANCONG where IDNVU=@idnvu ) as truyVancon on NHANVIEN.IDNV = truyVancon.IDNVIEN
	end
ELSE
	begin 
		select distinct NHANVIEN.IDNV,TENNV+'-'+IDBAN as 'TENNV' ,truyVancon.IDNVU 
		from NHANVIEN left join (select IDNVU,IDNVIEN from PHANCONG where IDNVU=@idnvu ) as truyVancon on NHANVIEN.IDNV = truyVancon.IDNVIEN
		where NHANVIEN.IDBAN = @idBan
	end
	
end 
GO
/****** Object:  Table [dbo].[BAN]    Script Date: 12/10/2020 2:45:25 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[BAN](
	[IDBAN] [nvarchar](15) NOT NULL,
	[IDPHONG] [int] NOT NULL,
	[TENBAN] [nvarchar](50) NOT NULL,
	[TRBAN] [int] NULL,
	[delteAT] [date] NULL,
 CONSTRAINT [PK_BAN] PRIMARY KEY CLUSTERED 
(
	[IDBAN] ASC,
	[IDPHONG] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[CHECHLIST]    Script Date: 12/10/2020 2:45:25 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[CHECHLIST](
	[IDCLIST] [int] IDENTITY(1,1) NOT NULL,
	[IDNVU] [int] NOT NULL,
	[NOIDUNGCL] [nvarchar](30) NOT NULL,
	[TRANGTHAI] [bit] NOT NULL,
 CONSTRAINT [PK_CHECKLIST] PRIMARY KEY CLUSTERED 
(
	[IDCLIST] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[CHITIEU]    Script Date: 12/10/2020 2:45:25 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[CHITIEU](
	[IDCTIEU] [int] IDENTITY(1,1) NOT NULL,
	[IDNVU] [int] NOT NULL,
	[SOTIEN] [float] NULL,
	[MOTA] [nvarchar](150) NULL,
	[IDNVIEN] [int] NULL,
	[NGAYCT] [date] NULL,
 CONSTRAINT [PK_CHITIEU] PRIMARY KEY CLUSTERED 
(
	[IDCTIEU] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[COMMENT]    Script Date: 12/10/2020 2:45:25 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[COMMENT](
	[IDCMT] [int] IDENTITY(1,1) NOT NULL,
	[IDNVU] [int] NOT NULL,
	[TENNV] [nvarchar](30) NOT NULL,
	[NOIDUNG] [nvarchar](150) NOT NULL,
	[THOIGIAN] [datetime] NOT NULL,
 CONSTRAINT [PK_COMMENT] PRIMARY KEY CLUSTERED 
(
	[IDCMT] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[GIADOAN]    Script Date: 12/10/2020 2:45:25 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[GIADOAN](
	[IDGIAODOAN] [int] IDENTITY(1,1) NOT NULL,
	[IDSK] [int] NOT NULL,
	[TENGD] [nvarchar](30) NOT NULL,
	[NGAYBATDAU] [date] NULL,
	[DEADLINE] [date] NULL,
	[MOTA] [nvarchar](255) NULL,
	[lockAt] [nvarchar](10) NULL,
 CONSTRAINT [PK_GIADOAN] PRIMARY KEY CLUSTERED 
(
	[IDGIAODOAN] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[HAUCAN]    Script Date: 12/10/2020 2:45:25 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[HAUCAN](
	[IDHAUCAN] [int] IDENTITY(1,1) NOT NULL,
	[TENBP] [nvarchar](30) NOT NULL,
	[TENNGUOILH] [nvarchar](30) NOT NULL,
	[EMAIL] [nvarchar](30) NULL,
	[DTHOAI] [nvarchar](15) NULL,
 CONSTRAINT [PK_HAUCAN] PRIMARY KEY CLUSTERED 
(
	[IDHAUCAN] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[KHACMOI]    Script Date: 12/10/2020 2:45:25 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[KHACMOI](
	[IDKM] [int] IDENTITY(1,1) NOT NULL,
	[TENKM] [nvarchar](150) NOT NULL,
	[EMAIL] [nvarchar](30) NULL,
	[SDT] [nvarchar](15) NULL,
	[GHICHU] [nvarchar](150) NULL,
 CONSTRAINT [PK_KHACHMOI] PRIMARY KEY CLUSTERED 
(
	[IDKM] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[KHACMOITD]    Script Date: 12/10/2020 2:45:25 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[KHACMOITD](
	[IDSK] [int] NOT NULL,
	[IDKM] [int] NOT NULL,
 CONSTRAINT [PK_KHACHMOITD] PRIMARY KEY CLUSTERED 
(
	[IDSK] ASC,
	[IDKM] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[MUCTIEUSK]    Script Date: 12/10/2020 2:45:25 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[MUCTIEUSK](
	[IDMT] [int] IDENTITY(1,1) NOT NULL,
	[IDSK] [int] NOT NULL,
	[MUCTIEU] [nvarchar](150) NOT NULL,
	[TRANGTHAI] [bit] NULL,
 CONSTRAINT [PK_MUCTIEUSK] PRIMARY KEY CLUSTERED 
(
	[IDMT] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[NHANVIEN]    Script Date: 12/10/2020 2:45:25 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[NHANVIEN](
	[IDNV] [int] IDENTITY(1,1) NOT NULL,
	[TENNV] [nvarchar](30) NOT NULL,
	[IDBAN] [nvarchar](15) NULL,
	[EMAIL] [nvarchar](30) NULL,
	[SDT] [nvarchar](15) NOT NULL,
	[CMT] [nvarchar](15) NOT NULL,
	[MATKHAU] [nvarchar](15) NOT NULL,
	[HINH] [nvarchar](30) NULL,
	[QUYEN] [int] NOT NULL,
 CONSTRAINT [PK_NHANVIEN] PRIMARY KEY CLUSTERED 
(
	[IDNV] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[NHIEMVU]    Script Date: 12/10/2020 2:45:25 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[NHIEMVU](
	[IDNVU] [int] IDENTITY(1,1) NOT NULL,
	[IDGIAIDOAN] [int] NOT NULL,
	[TENNVU] [nvarchar](30) NOT NULL,
	[MOTA] [nvarchar](30) NULL,
	[NGAYBATDAU] [date] NULL,
	[DEADLINE] [date] NULL,
	[TRANGTHAI] [bit] NULL,
	[TGHT] [int] NULL,
	[FILEIN] [nvarchar](150) NULL,
 CONSTRAINT [PK_NHIEMVU] PRIMARY KEY CLUSTERED 
(
	[IDNVU] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[PHANCONG]    Script Date: 12/10/2020 2:45:25 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[PHANCONG](
	[IDNVIEN] [int] NOT NULL,
	[IDNVU] [int] NOT NULL,
 CONSTRAINT [PK_PHANCONG] PRIMARY KEY CLUSTERED 
(
	[IDNVIEN] ASC,
	[IDNVU] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[PHONG]    Script Date: 12/10/2020 2:45:25 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[PHONG](
	[IDPHONG] [int] IDENTITY(1,1) NOT NULL,
	[TENPHONG] [nvarchar](50) NOT NULL,
	[IDTRP] [int] NULL,
	[NGANSACH] [float] NULL,
 CONSTRAINT [PK_PHONG] PRIMARY KEY CLUSTERED 
(
	[IDPHONG] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[SUKIEN]    Script Date: 12/10/2020 2:45:25 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[SUKIEN](
	[IDSK] [int] IDENTITY(1,1) NOT NULL,
	[TENSK] [nvarchar](30) NOT NULL,
	[IDPHONG] [int] NOT NULL,
	[NOIDUNG] [nvarchar](255) NOT NULL,
	[NGAYBATDAU] [date] NULL,
	[NGAYKETTHUC] [date] NULL,
	[deleAt] [date] NULL,
 CONSTRAINT [PK_SUKIEN] PRIMARY KEY CLUSTERED 
(
	[IDSK] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
INSERT [dbo].[BAN] ([IDBAN], [IDPHONG], [TENBAN], [TRBAN], [delteAT]) VALUES (N'HC', 1, N'THI CÔNG', NULL, NULL)
INSERT [dbo].[BAN] ([IDBAN], [IDPHONG], [TENBAN], [TRBAN], [delteAT]) VALUES (N'TBAN', 1, N'ABC', NULL, CAST(0xE8410B00 AS Date))
INSERT [dbo].[BAN] ([IDBAN], [IDPHONG], [TENBAN], [TRBAN], [delteAT]) VALUES (N'TC ', 1, N'take care', NULL, NULL)
INSERT [dbo].[BAN] ([IDBAN], [IDPHONG], [TENBAN], [TRBAN], [delteAT]) VALUES (N'TK', 1, N'Thiết kế', NULL, NULL)
INSERT [dbo].[BAN] ([IDBAN], [IDPHONG], [TENBAN], [TRBAN], [delteAT]) VALUES (N'TT', 1, N'Truyền thông ', NULL, NULL)
SET IDENTITY_INSERT [dbo].[CHECHLIST] ON 

INSERT [dbo].[CHECHLIST] ([IDCLIST], [IDNVU], [NOIDUNGCL], [TRANGTHAI]) VALUES (1, 1, N'công việc 1', 1)
INSERT [dbo].[CHECHLIST] ([IDCLIST], [IDNVU], [NOIDUNGCL], [TRANGTHAI]) VALUES (10, 1, N'chào nỉ ma', 1)
INSERT [dbo].[CHECHLIST] ([IDCLIST], [IDNVU], [NOIDUNGCL], [TRANGTHAI]) VALUES (14, 3, N'công việc test 2', 1)
INSERT [dbo].[CHECHLIST] ([IDCLIST], [IDNVU], [NOIDUNGCL], [TRANGTHAI]) VALUES (16, 2, N'yêu cầu 2', 1)
INSERT [dbo].[CHECHLIST] ([IDCLIST], [IDNVU], [NOIDUNGCL], [TRANGTHAI]) VALUES (17, 3, N'chào công việc', 1)
INSERT [dbo].[CHECHLIST] ([IDCLIST], [IDNVU], [NOIDUNGCL], [TRANGTHAI]) VALUES (19, 1, N'công việc mới', 0)
SET IDENTITY_INSERT [dbo].[CHECHLIST] OFF
SET IDENTITY_INSERT [dbo].[CHITIEU] ON 

INSERT [dbo].[CHITIEU] ([IDCTIEU], [IDNVU], [SOTIEN], [MOTA], [IDNVIEN], [NGAYCT]) VALUES (2, 1, 50000, N'kêu gọi khách mời', 3, CAST(0xE5410B00 AS Date))
SET IDENTITY_INSERT [dbo].[CHITIEU] OFF
SET IDENTITY_INSERT [dbo].[COMMENT] ON 

INSERT [dbo].[COMMENT] ([IDCMT], [IDNVU], [TENNV], [NOIDUNG], [THOIGIAN]) VALUES (2, 1, N'huy', N'sbc', CAST(0x0000AC8400000000 AS DateTime))
INSERT [dbo].[COMMENT] ([IDCMT], [IDNVU], [TENNV], [NOIDUNG], [THOIGIAN]) VALUES (3, 2, N'32123', N'3321', CAST(0x0000AC8300000000 AS DateTime))
INSERT [dbo].[COMMENT] ([IDCMT], [IDNVU], [TENNV], [NOIDUNG], [THOIGIAN]) VALUES (4, 1, N'ádhakhj', N'21', CAST(0x0000AB4000000000 AS DateTime))
INSERT [dbo].[COMMENT] ([IDCMT], [IDNVU], [TENNV], [NOIDUNG], [THOIGIAN]) VALUES (5, 1, N'huy đẹp trai', N'chào các bạn', CAST(0x0000AC8500039CF4 AS DateTime))
INSERT [dbo].[COMMENT] ([IDCMT], [IDNVU], [TENNV], [NOIDUNG], [THOIGIAN]) VALUES (6, 1, N'huy   -TC', N'chào nỉ ma', CAST(0x0000AC85000A6A25 AS DateTime))
INSERT [dbo].[COMMENT] ([IDCMT], [IDNVU], [TENNV], [NOIDUNG], [THOIGIAN]) VALUES (7, 1, N'huy   -TC', N'chào', CAST(0x0000AC85000F859E AS DateTime))
INSERT [dbo].[COMMENT] ([IDCMT], [IDNVU], [TENNV], [NOIDUNG], [THOIGIAN]) VALUES (8, 1, N'huy   -TC', N'chào', CAST(0x0000AC85000F9902 AS DateTime))
INSERT [dbo].[COMMENT] ([IDCMT], [IDNVU], [TENNV], [NOIDUNG], [THOIGIAN]) VALUES (9, 1, N'huy   -TC', N'chào', CAST(0x0000AC85000F9A46 AS DateTime))
INSERT [dbo].[COMMENT] ([IDCMT], [IDNVU], [TENNV], [NOIDUNG], [THOIGIAN]) VALUES (10, 1, N'huy   -TC', N'hihi', CAST(0x0000AC8500107063 AS DateTime))
INSERT [dbo].[COMMENT] ([IDCMT], [IDNVU], [TENNV], [NOIDUNG], [THOIGIAN]) VALUES (11, 1, N'huy   -TC', N'ahaha', CAST(0x0000AC85001084C5 AS DateTime))
INSERT [dbo].[COMMENT] ([IDCMT], [IDNVU], [TENNV], [NOIDUNG], [THOIGIAN]) VALUES (12, 2, N'huy   -TC', N'huy đang test', CAST(0x0000AC8500115686 AS DateTime))
INSERT [dbo].[COMMENT] ([IDCMT], [IDNVU], [TENNV], [NOIDUNG], [THOIGIAN]) VALUES (13, 2, N'huy   -TC', N'huy đang test', CAST(0x0000AC85001169F2 AS DateTime))
INSERT [dbo].[COMMENT] ([IDCMT], [IDNVU], [TENNV], [NOIDUNG], [THOIGIAN]) VALUES (14, 3, N'huy   -TC', N'a', CAST(0x0000AC850011ECA4 AS DateTime))
INSERT [dbo].[COMMENT] ([IDCMT], [IDNVU], [TENNV], [NOIDUNG], [THOIGIAN]) VALUES (15, 4, N'huy   -TC', N'123', CAST(0x0000AC850012491C AS DateTime))
INSERT [dbo].[COMMENT] ([IDCMT], [IDNVU], [TENNV], [NOIDUNG], [THOIGIAN]) VALUES (16, 4, N'huy   -TC', N'123', CAST(0x0000AC8500124A89 AS DateTime))
INSERT [dbo].[COMMENT] ([IDCMT], [IDNVU], [TENNV], [NOIDUNG], [THOIGIAN]) VALUES (17, 4, N'huy   -TC', N'cười ghê', CAST(0x0000AC8500138C70 AS DateTime))
INSERT [dbo].[COMMENT] ([IDCMT], [IDNVU], [TENNV], [NOIDUNG], [THOIGIAN]) VALUES (18, 6, N'huy   -TC', N'ahihi', CAST(0x0000AC8500386FDB AS DateTime))
INSERT [dbo].[COMMENT] ([IDCMT], [IDNVU], [TENNV], [NOIDUNG], [THOIGIAN]) VALUES (19, 3, N'huy   -TC', N'hay', CAST(0x0000AC8A00D95017 AS DateTime))
SET IDENTITY_INSERT [dbo].[COMMENT] OFF
SET IDENTITY_INSERT [dbo].[GIADOAN] ON 

INSERT [dbo].[GIADOAN] ([IDGIAODOAN], [IDSK], [TENGD], [NGAYBATDAU], [DEADLINE], [MOTA], [lockAt]) VALUES (1, 1, N'giai đoạn trước sự kiện', CAST(0xD3410B00 AS Date), CAST(0xD7410B00 AS Date), N'giai đoạn chuẩn bị của sự kiện', NULL)
INSERT [dbo].[GIADOAN] ([IDGIAODOAN], [IDSK], [TENGD], [NGAYBATDAU], [DEADLINE], [MOTA], [lockAt]) VALUES (2, 1, N'gaii đoạn 2', CAST(0xC5410B00 AS Date), CAST(0xD4410B00 AS Date), N'123', NULL)
INSERT [dbo].[GIADOAN] ([IDGIAODOAN], [IDSK], [TENGD], [NGAYBATDAU], [DEADLINE], [MOTA], [lockAt]) VALUES (3, 1, N'giai đoạn cuối', CAST(0xC6410B00 AS Date), CAST(0xDA410B00 AS Date), N'123', N'2020-12-10')
INSERT [dbo].[GIADOAN] ([IDGIAODOAN], [IDSK], [TENGD], [NGAYBATDAU], [DEADLINE], [MOTA], [lockAt]) VALUES (6, 1, N'giai đoạn tổng hợp', CAST(0xE8410B00 AS Date), CAST(0xFD410B00 AS Date), N'123', NULL)
INSERT [dbo].[GIADOAN] ([IDGIAODOAN], [IDSK], [TENGD], [NGAYBATDAU], [DEADLINE], [MOTA], [lockAt]) VALUES (7, 3, N'giai đoạn 1', CAST(0xE9410B00 AS Date), CAST(0xF6410B00 AS Date), N'', N'2020-12-08')
INSERT [dbo].[GIADOAN] ([IDGIAODOAN], [IDSK], [TENGD], [NGAYBATDAU], [DEADLINE], [MOTA], [lockAt]) VALUES (8, 3, N'giai đoạn 2', CAST(0xE8410B00 AS Date), CAST(0xFD410B00 AS Date), N'', NULL)
INSERT [dbo].[GIADOAN] ([IDGIAODOAN], [IDSK], [TENGD], [NGAYBATDAU], [DEADLINE], [MOTA], [lockAt]) VALUES (9, 3, N'giai đoạn 4', NULL, NULL, NULL, NULL)
INSERT [dbo].[GIADOAN] ([IDGIAODOAN], [IDSK], [TENGD], [NGAYBATDAU], [DEADLINE], [MOTA], [lockAt]) VALUES (10, 3, N'giai đoạn aw', NULL, NULL, N'', NULL)
SET IDENTITY_INSERT [dbo].[GIADOAN] OFF
SET IDENTITY_INSERT [dbo].[HAUCAN] ON 

INSERT [dbo].[HAUCAN] ([IDHAUCAN], [TENBP], [TENNGUOILH], [EMAIL], [DTHOAI]) VALUES (1, N'MC', N'giáo sư huy', N'huy@huyuy@com', N'0925573154')
INSERT [dbo].[HAUCAN] ([IDHAUCAN], [TENBP], [TENNGUOILH], [EMAIL], [DTHOAI]) VALUES (2, N'setup ', N'Huy thi công', N'huytc@gmail.com', N'0943390338')
INSERT [dbo].[HAUCAN] ([IDHAUCAN], [TENBP], [TENNGUOILH], [EMAIL], [DTHOAI]) VALUES (3, N'dance', N'huy thợ điện', N'huythodien@gmail.com', N'0925573154')
INSERT [dbo].[HAUCAN] ([IDHAUCAN], [TENBP], [TENNGUOILH], [EMAIL], [DTHOAI]) VALUES (4, N'Ca nhạc', N'Nguyễn Khắc Trường', N'truongnkph11082@fpt.edu.vn', N'0369982225')
SET IDENTITY_INSERT [dbo].[HAUCAN] OFF
SET IDENTITY_INSERT [dbo].[KHACMOI] ON 

INSERT [dbo].[KHACMOI] ([IDKM], [TENKM], [EMAIL], [SDT], [GHICHU]) VALUES (1, N'nguyễn văn quyết ', N'quyetnv@gmail.com', N'0374355726', N'CEO của tập đoàn VTI')
INSERT [dbo].[KHACMOI] ([IDKM], [TENKM], [EMAIL], [SDT], [GHICHU]) VALUES (2, N'Nguyễn thị Tiên', N'tienncph11161@fpt.edu.vn', N'01654659546', N'HR của công ty gải pháp bán hàng sapo')
INSERT [dbo].[KHACMOI] ([IDKM], [TENKM], [EMAIL], [SDT], [GHICHU]) VALUES (3, N'CEO HIẾU HD', N'hieuhdph10766@fpt.edu.vn', N'0934589385', N'trưởng phòng nhân sự công ty ')
INSERT [dbo].[KHACMOI] ([IDKM], [TENKM], [EMAIL], [SDT], [GHICHU]) VALUES (4, N'nguyen khac truong', N'truongnkph11082@fpt.edu.vn', N'0984126546', N'Chủ tịch công ty saphoooo')
INSERT [dbo].[KHACMOI] ([IDKM], [TENKM], [EMAIL], [SDT], [GHICHU]) VALUES (5, N'Nguyễn Chí tiến', N'tientvph13637@fpt.edu.vn', N'0374355726', N'aaa')
INSERT [dbo].[KHACMOI] ([IDKM], [TENKM], [EMAIL], [SDT], [GHICHU]) VALUES (6, N'Vũ chí thành', N'thanhvt@gmail.com', N'09834059820', N'hiệu trưởng trường')
SET IDENTITY_INSERT [dbo].[KHACMOI] OFF
INSERT [dbo].[KHACMOITD] ([IDSK], [IDKM]) VALUES (1, 2)
INSERT [dbo].[KHACMOITD] ([IDSK], [IDKM]) VALUES (1, 3)
INSERT [dbo].[KHACMOITD] ([IDSK], [IDKM]) VALUES (1, 4)
INSERT [dbo].[KHACMOITD] ([IDSK], [IDKM]) VALUES (1, 5)
SET IDENTITY_INSERT [dbo].[MUCTIEUSK] ON 

INSERT [dbo].[MUCTIEUSK] ([IDMT], [IDSK], [MUCTIEU], [TRANGTHAI]) VALUES (7, 1, N'tăng tương tác page', 1)
INSERT [dbo].[MUCTIEUSK] ([IDMT], [IDSK], [MUCTIEU], [TRANGTHAI]) VALUES (8, 1, N'kêu gọi được nhiều csv', 1)
INSERT [dbo].[MUCTIEUSK] ([IDMT], [IDSK], [MUCTIEU], [TRANGTHAI]) VALUES (10, 1, N'tạo quan hệ giữa csv nhà trường ', 1)
INSERT [dbo].[MUCTIEUSK] ([IDMT], [IDSK], [MUCTIEU], [TRANGTHAI]) VALUES (11, 1, N'có bao nhiêu sv tham dự', 0)
SET IDENTITY_INSERT [dbo].[MUCTIEUSK] OFF
SET IDENTITY_INSERT [dbo].[NHANVIEN] ON 

INSERT [dbo].[NHANVIEN] ([IDNV], [TENNV], [IDBAN], [EMAIL], [SDT], [CMT], [MATKHAU], [HINH], [QUYEN]) VALUES (1, N'Huyz đẹp trai', N'HC', N'huy@gmail.com', N'0925573154', N'3212311', N'123', NULL, 0)
INSERT [dbo].[NHANVIEN] ([IDNV], [TENNV], [IDBAN], [EMAIL], [SDT], [CMT], [MATKHAU], [HINH], [QUYEN]) VALUES (2, N'tiên', N'TK', N'tientvph13637@gmail.com', N'0925573154', N'3212311', N'123', NULL, 1)
INSERT [dbo].[NHANVIEN] ([IDNV], [TENNV], [IDBAN], [EMAIL], [SDT], [CMT], [MATKHAU], [HINH], [QUYEN]) VALUES (3, N'huy đẹpt rai', N'HC', N'huynqph11019@fpt.edu.vn', N'09255731544', N'3212311', N'123a', NULL, 0)
INSERT [dbo].[NHANVIEN] ([IDNV], [TENNV], [IDBAN], [EMAIL], [SDT], [CMT], [MATKHAU], [HINH], [QUYEN]) VALUES (4, N'huy trần', N'TT', N'huynq1808@gmail.com', N'0943390338', N'3212311', N'huyhuy', NULL, 1)
INSERT [dbo].[NHANVIEN] ([IDNV], [TENNV], [IDBAN], [EMAIL], [SDT], [CMT], [MATKHAU], [HINH], [QUYEN]) VALUES (5, N'Chí Tiến', N'TC ', N'tienncph11161@fpt.edu.vn', N'0925573154', N'3212311', N'alskdflase', NULL, 0)
SET IDENTITY_INSERT [dbo].[NHANVIEN] OFF
SET IDENTITY_INSERT [dbo].[NHIEMVU] ON 

INSERT [dbo].[NHIEMVU] ([IDNVU], [IDGIAIDOAN], [TENNVU], [MOTA], [NGAYBATDAU], [DEADLINE], [TRANGTHAI], [TGHT], [FILEIN]) VALUES (1, 1, N'thiết kế banner ', N'đây là mô tả', CAST(0xE9410B00 AS Date), CAST(0xCB410B00 AS Date), 1, 66, N'https://drive.google.com/drive/u/1/folders/1KoB52UIJKMoGAntva0eRbaWad0ZNpFsb')
INSERT [dbo].[NHIEMVU] ([IDNVU], [IDGIAIDOAN], [TENNVU], [MOTA], [NGAYBATDAU], [DEADLINE], [TRANGTHAI], [TGHT], [FILEIN]) VALUES (2, 1, N'thông báo cho khách mời ', N'gửi thông báo', CAST(0xDF410B00 AS Date), CAST(0xEA410B00 AS Date), 0, 100, NULL)
INSERT [dbo].[NHIEMVU] ([IDNVU], [IDGIAIDOAN], [TENNVU], [MOTA], [NGAYBATDAU], [DEADLINE], [TRANGTHAI], [TGHT], [FILEIN]) VALUES (3, 2, N'nhiệm vụ test', N'vẫn là mô tả', CAST(0xC6410B00 AS Date), CAST(0xFD410B00 AS Date), 1, 100, NULL)
INSERT [dbo].[NHIEMVU] ([IDNVU], [IDGIAIDOAN], [TENNVU], [MOTA], [NGAYBATDAU], [DEADLINE], [TRANGTHAI], [TGHT], [FILEIN]) VALUES (4, 2, N'adfa', N'ádf', CAST(0xE2410B00 AS Date), CAST(0xE9410B00 AS Date), 0, 200, NULL)
INSERT [dbo].[NHIEMVU] ([IDNVU], [IDGIAIDOAN], [TENNVU], [MOTA], [NGAYBATDAU], [DEADLINE], [TRANGTHAI], [TGHT], [FILEIN]) VALUES (5, 2, N'nv3', N'123', CAST(0xE1410B00 AS Date), CAST(0xE8410B00 AS Date), 1, 0, NULL)
INSERT [dbo].[NHIEMVU] ([IDNVU], [IDGIAIDOAN], [TENNVU], [MOTA], [NGAYBATDAU], [DEADLINE], [TRANGTHAI], [TGHT], [FILEIN]) VALUES (6, 3, N'tổng kết', N'tổng kết', CAST(0xE1410B00 AS Date), CAST(0xF6410B00 AS Date), 0, 0, NULL)
INSERT [dbo].[NHIEMVU] ([IDNVU], [IDGIAIDOAN], [TENNVU], [MOTA], [NGAYBATDAU], [DEADLINE], [TRANGTHAI], [TGHT], [FILEIN]) VALUES (7, 2, N'NV4', N'143', CAST(0xE5410B00 AS Date), CAST(0xEF410B00 AS Date), 0, 0, NULL)
INSERT [dbo].[NHIEMVU] ([IDNVU], [IDGIAIDOAN], [TENNVU], [MOTA], [NGAYBATDAU], [DEADLINE], [TRANGTHAI], [TGHT], [FILEIN]) VALUES (8, 2, N'nv5', N'', CAST(0xE2410B00 AS Date), CAST(0xEF410B00 AS Date), 0, 0, NULL)
INSERT [dbo].[NHIEMVU] ([IDNVU], [IDGIAIDOAN], [TENNVU], [MOTA], [NGAYBATDAU], [DEADLINE], [TRANGTHAI], [TGHT], [FILEIN]) VALUES (9, 7, N'nhiệm vụ 1', N'', CAST(0xE8410B00 AS Date), CAST(0xEF410B00 AS Date), 1, 0, NULL)
INSERT [dbo].[NHIEMVU] ([IDNVU], [IDGIAIDOAN], [TENNVU], [MOTA], [NGAYBATDAU], [DEADLINE], [TRANGTHAI], [TGHT], [FILEIN]) VALUES (10, 7, N'nhiệm vụ 2', N'chao nima', CAST(0xE7410B00 AS Date), NULL, 0, 0, NULL)
INSERT [dbo].[NHIEMVU] ([IDNVU], [IDGIAIDOAN], [TENNVU], [MOTA], [NGAYBATDAU], [DEADLINE], [TRANGTHAI], [TGHT], [FILEIN]) VALUES (11, 6, N'lất feedback', N'', CAST(0xE8410B00 AS Date), CAST(0xE9410B00 AS Date), 1, 0, NULL)
SET IDENTITY_INSERT [dbo].[NHIEMVU] OFF
INSERT [dbo].[PHANCONG] ([IDNVIEN], [IDNVU]) VALUES (1, 1)
INSERT [dbo].[PHANCONG] ([IDNVIEN], [IDNVU]) VALUES (1, 2)
INSERT [dbo].[PHANCONG] ([IDNVIEN], [IDNVU]) VALUES (1, 3)
INSERT [dbo].[PHANCONG] ([IDNVIEN], [IDNVU]) VALUES (1, 4)
INSERT [dbo].[PHANCONG] ([IDNVIEN], [IDNVU]) VALUES (1, 9)
INSERT [dbo].[PHANCONG] ([IDNVIEN], [IDNVU]) VALUES (1, 11)
INSERT [dbo].[PHANCONG] ([IDNVIEN], [IDNVU]) VALUES (2, 1)
INSERT [dbo].[PHANCONG] ([IDNVIEN], [IDNVU]) VALUES (2, 2)
INSERT [dbo].[PHANCONG] ([IDNVIEN], [IDNVU]) VALUES (2, 3)
INSERT [dbo].[PHANCONG] ([IDNVIEN], [IDNVU]) VALUES (2, 4)
INSERT [dbo].[PHANCONG] ([IDNVIEN], [IDNVU]) VALUES (2, 5)
INSERT [dbo].[PHANCONG] ([IDNVIEN], [IDNVU]) VALUES (2, 7)
INSERT [dbo].[PHANCONG] ([IDNVIEN], [IDNVU]) VALUES (2, 9)
INSERT [dbo].[PHANCONG] ([IDNVIEN], [IDNVU]) VALUES (2, 11)
INSERT [dbo].[PHANCONG] ([IDNVIEN], [IDNVU]) VALUES (3, 1)
INSERT [dbo].[PHANCONG] ([IDNVIEN], [IDNVU]) VALUES (3, 2)
INSERT [dbo].[PHANCONG] ([IDNVIEN], [IDNVU]) VALUES (3, 9)
INSERT [dbo].[PHANCONG] ([IDNVIEN], [IDNVU]) VALUES (3, 10)
INSERT [dbo].[PHANCONG] ([IDNVIEN], [IDNVU]) VALUES (3, 11)
INSERT [dbo].[PHANCONG] ([IDNVIEN], [IDNVU]) VALUES (4, 1)
INSERT [dbo].[PHANCONG] ([IDNVIEN], [IDNVU]) VALUES (4, 7)
INSERT [dbo].[PHANCONG] ([IDNVIEN], [IDNVU]) VALUES (4, 9)
INSERT [dbo].[PHANCONG] ([IDNVIEN], [IDNVU]) VALUES (4, 11)
INSERT [dbo].[PHANCONG] ([IDNVIEN], [IDNVU]) VALUES (5, 1)
INSERT [dbo].[PHANCONG] ([IDNVIEN], [IDNVU]) VALUES (5, 9)
SET IDENTITY_INSERT [dbo].[PHONG] ON 

INSERT [dbo].[PHONG] ([IDPHONG], [TENPHONG], [IDTRP], [NGANSACH]) VALUES (1, N'PHòng QHDH', NULL, 0)
SET IDENTITY_INSERT [dbo].[PHONG] OFF
SET IDENTITY_INSERT [dbo].[SUKIEN] ON 

INSERT [dbo].[SUKIEN] ([IDSK], [TENSK], [IDPHONG], [NOIDUNG], [NGAYBATDAU], [NGAYKETTHUC], [deleAt]) VALUES (1, N'Home Comming', 1, N'sự kiện dành cho cự sinh viên', CAST(0xC4410B00 AS Date), CAST(0xDD410B00 AS Date), NULL)
INSERT [dbo].[SUKIEN] ([IDSK], [TENSK], [IDPHONG], [NOIDUNG], [NGAYBATDAU], [NGAYKETTHUC], [deleAt]) VALUES (3, N'ĐỊNH HƯỚNG NGHỀ NGHIỆP', 1, N'', CAST(0xC6410B00 AS Date), CAST(0xCD410B00 AS Date), NULL)
INSERT [dbo].[SUKIEN] ([IDSK], [TENSK], [IDPHONG], [NOIDUNG], [NGAYBATDAU], [NGAYKETTHUC], [deleAt]) VALUES (4, N'MTP ', 1, N'Sơn Tùng', CAST(0xDF410B00 AS Date), CAST(0xE8410B00 AS Date), CAST(0xE6410B00 AS Date))
SET IDENTITY_INSERT [dbo].[SUKIEN] OFF
ALTER TABLE [dbo].[BAN]  WITH CHECK ADD  CONSTRAINT [DK_BAN_PHONG] FOREIGN KEY([IDPHONG])
REFERENCES [dbo].[PHONG] ([IDPHONG])
GO
ALTER TABLE [dbo].[BAN] CHECK CONSTRAINT [DK_BAN_PHONG]
GO
ALTER TABLE [dbo].[CHECHLIST]  WITH CHECK ADD  CONSTRAINT [FK_CHECKLIST_NHIEMVU] FOREIGN KEY([IDNVU])
REFERENCES [dbo].[NHIEMVU] ([IDNVU])
GO
ALTER TABLE [dbo].[CHECHLIST] CHECK CONSTRAINT [FK_CHECKLIST_NHIEMVU]
GO
ALTER TABLE [dbo].[CHITIEU]  WITH CHECK ADD  CONSTRAINT [FK_CHITIEU_NHANVIEN] FOREIGN KEY([IDNVIEN])
REFERENCES [dbo].[NHANVIEN] ([IDNV])
GO
ALTER TABLE [dbo].[CHITIEU] CHECK CONSTRAINT [FK_CHITIEU_NHANVIEN]
GO
ALTER TABLE [dbo].[CHITIEU]  WITH CHECK ADD  CONSTRAINT [FK_CHITIEU_NHIEMVU] FOREIGN KEY([IDNVU])
REFERENCES [dbo].[NHIEMVU] ([IDNVU])
GO
ALTER TABLE [dbo].[CHITIEU] CHECK CONSTRAINT [FK_CHITIEU_NHIEMVU]
GO
ALTER TABLE [dbo].[COMMENT]  WITH CHECK ADD  CONSTRAINT [FK_COMMETN_NHIEMVU] FOREIGN KEY([IDNVU])
REFERENCES [dbo].[NHIEMVU] ([IDNVU])
GO
ALTER TABLE [dbo].[COMMENT] CHECK CONSTRAINT [FK_COMMETN_NHIEMVU]
GO
ALTER TABLE [dbo].[GIADOAN]  WITH CHECK ADD  CONSTRAINT [FK_GIAIDOAN] FOREIGN KEY([IDSK])
REFERENCES [dbo].[SUKIEN] ([IDSK])
GO
ALTER TABLE [dbo].[GIADOAN] CHECK CONSTRAINT [FK_GIAIDOAN]
GO
ALTER TABLE [dbo].[KHACMOITD]  WITH CHECK ADD  CONSTRAINT [FK_KHACMOITD_KHACHMOI] FOREIGN KEY([IDKM])
REFERENCES [dbo].[KHACMOI] ([IDKM])
GO
ALTER TABLE [dbo].[KHACMOITD] CHECK CONSTRAINT [FK_KHACMOITD_KHACHMOI]
GO
ALTER TABLE [dbo].[KHACMOITD]  WITH CHECK ADD  CONSTRAINT [FK_KHACMOITD_SUKIEN] FOREIGN KEY([IDSK])
REFERENCES [dbo].[SUKIEN] ([IDSK])
GO
ALTER TABLE [dbo].[KHACMOITD] CHECK CONSTRAINT [FK_KHACMOITD_SUKIEN]
GO
ALTER TABLE [dbo].[MUCTIEUSK]  WITH CHECK ADD  CONSTRAINT [FK_MUCTIEUSK_SUKIEN] FOREIGN KEY([IDSK])
REFERENCES [dbo].[SUKIEN] ([IDSK])
GO
ALTER TABLE [dbo].[MUCTIEUSK] CHECK CONSTRAINT [FK_MUCTIEUSK_SUKIEN]
GO
ALTER TABLE [dbo].[NHIEMVU]  WITH CHECK ADD  CONSTRAINT [FK_NHIEMVU_GIAIDOAN] FOREIGN KEY([IDGIAIDOAN])
REFERENCES [dbo].[GIADOAN] ([IDGIAODOAN])
GO
ALTER TABLE [dbo].[NHIEMVU] CHECK CONSTRAINT [FK_NHIEMVU_GIAIDOAN]
GO
ALTER TABLE [dbo].[PHANCONG]  WITH CHECK ADD  CONSTRAINT [FK_PHANCONG_NHANVIEN] FOREIGN KEY([IDNVIEN])
REFERENCES [dbo].[NHANVIEN] ([IDNV])
GO
ALTER TABLE [dbo].[PHANCONG] CHECK CONSTRAINT [FK_PHANCONG_NHANVIEN]
GO
ALTER TABLE [dbo].[PHANCONG]  WITH CHECK ADD  CONSTRAINT [FK_PHANCONG_NHIEMVU] FOREIGN KEY([IDNVU])
REFERENCES [dbo].[NHIEMVU] ([IDNVU])
GO
ALTER TABLE [dbo].[PHANCONG] CHECK CONSTRAINT [FK_PHANCONG_NHIEMVU]
GO
ALTER TABLE [dbo].[SUKIEN]  WITH CHECK ADD  CONSTRAINT [FK_SUKIEN_PHONG] FOREIGN KEY([IDPHONG])
REFERENCES [dbo].[PHONG] ([IDPHONG])
GO
ALTER TABLE [dbo].[SUKIEN] CHECK CONSTRAINT [FK_SUKIEN_PHONG]
GO
