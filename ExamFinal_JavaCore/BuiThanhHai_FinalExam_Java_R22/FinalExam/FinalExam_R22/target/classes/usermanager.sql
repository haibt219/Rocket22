/*============================== CREATE DATABASE =======================================*/
DROP DATABASE IF EXISTS UserManager;
CREATE DATABASE UserManager;
USE UserManager;

/*============================== CREATE TABLE =======================================*/
CREATE TABLE `User`(
	UserID 		TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
	FullName 	VARCHAR(50) NOT NULL,
    Email 		VARCHAR(50) UNIQUE KEY NOT NULL,
    `Password`	VARCHAR(50) NOT NULL CHECK(length(`Password`) >= 6),
    `Role`		ENUM('Employee', 'Manager'),
    ExpInYear	TINYINT,
    ProjectID	TINYINT,
    ProSkill	VARCHAR(50)
);


/*============================== INSERT DATABASE =======================================*/
INSERT INTO `User`  (FullName				, 	Email					,	`Password`	,		ExpInYear	,		ProSkill	,	ProjectID	,	`Role`			) 
VALUES		        ('Bui Thanh Hai'		,	'haivti@gmail.com'		, 	'Haivti'	,		5			,		NULL		,		1		,	'Manager'		),
					('Bui Thanh Huyen'		,	'huyenvti@gmail.com'	, 	'Huyenvti'	,		NULL		,		'Test'		,		1		,	'Employee'		),
                    ('Nguyen The Dung'		,	'dungvti@gmail.com'		, 	'Dungvti'	,		NULL		,		'Test'		,		1		,	'Employee'		),
                    ('Ba Ngoc Khoi'			,	'khoivti@gmail.com'		, 	'Khoivti'	,		3			,		'Dev'		,		2		,	'Manager'		),
                    ('The Hung Chung'		,	'chungvti@gmail.com'	, 	'Chungvti'	,		NULL		,		'Dev'		,		2		,	'Employee'		),
                    ('Nguyen Tien Thang'	,	'thangvti@gmail.com'	, 	'Thangvti'	,		NULL		,		'Test'		,		2		,	'Employee'		);
                    
                    
                    
                    