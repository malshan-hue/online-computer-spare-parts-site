select * from user;

insert into user (userId, userName, email,password,mobileNo, userRole)
value ('U1001','Ravindu','ravindu@gmail.com', 'Rav@1234', '0784521547', 'admin');

alter table user drop profileImg;
alter table user add userRole varchar(50);

alter table user add profileImg varchar(50);

select * from product;

select * from product where productID = 'P1001';

delete from product;
drop table product;

alter table product add foreign key(productCat) references category(catID);

create table category(
	catID varchar(10),
    catName varchar(30),
    primary key (catID)
)



select * from category;
drop table category;

insert into category(catID,catName)
values ('cat001','Motherboards'),
		('cat002','CPUs'),
        ('cat003','RAM'),
        ('cat004','Graphic Cards'),
        ('cat005','Power Supplies'),
        ('cat006','Hard Drives'),
        ('cat007','SSDs'),
        ('cat008','Cooling Systems'),
        ('cat009','IO Devices'),
        ('cat010','Networking');
        
delete from product where productID = 'P1005';

update product set image = 'keyboard.jpg' where productID = 'P1001';

update product set productDesc = 'VENGEANCE RGB PRO 16GB (2 x 8GB) DDR4 DRAM 3200MHz C16 Memory Kit' where productID = 'P1001';

CREATE TABLE category(
				catID varchar(50),
				catName varchar(50),
				catDesc varchar(200),
				catCreatedDate DATE,
				catUpdatedDate DATE, 
				PRIMARY KEY (catID)
			);
            
SELECT * FROM category;

drop table category;

select * from brand;

delete from category where catID = 'CAT1003';

select * from cart;

select * from orders;

















select * from product;

select * from user;

select * from category;

select * from brand;

select * from cart;


            
