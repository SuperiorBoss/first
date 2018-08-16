create database saleSys;
       
--创建客户信息表
create table cus_customer
(
    cus_id int primary key auto_increment,
    cus_name varchar(100) not null,     
    cus_addr varchar(500) not null     
);
drop table cus_customer
select * from cus_customer;

--创建产品信息表
create table sale_product(
   prod_id int primary key auto_increment,
   prod_name varchar(100) not null,        
   prod_price double not null         
);
drop table sale_product
select * from sale_product;

--创建订单表
create table sale_order(
     odr_id int  primary key auto_increment,
     odr_customer_id int not null,           
     odr_customer_name varchar(100) not null,        
     odr_deliver_addr varchar(500) not null,         
     odr_order_date date not null,                    
     odr_deliver_date date not null,                  
     odr_status varchar(50)                           
);
drop table sale_order



--创建订单详细表
create table sale_order_line
(
   odl_id  int  primary key auto_increment,
   odl_order_id  int not null,              
   odl_product_name varchar(50),                   
   odl_product_price double  not null,           
   odl_product_count int not null                
);

select odr_id,odr_customer_id,odr_customer_name,odr_deliver_addr,odr_order_date,odr_deliver_date,odr_status,
       odl_id, odl_order_id,odl_product_name,odl_product_price,odl_product_count
from sale_order
left join sale_order_line
on sale_order.odr_id=sale_order_line.odl_order_id
where sale_order.odr_id=1

select * from sale_order;
select * from sale_order_line;



--订单表与订单详细表的主外键关系
alter table sale_order_line
   add constraint FK_sale_order_line_id
      foreign key(odl_order_id) references sale_order(odr_id);
      
      
