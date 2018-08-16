--测试数据  
insert into cus_customer(cus_name,cus_addr) values('中国工业集团','北京兴华门32号');
insert into cus_customer(cus_name,cus_addr) values('中国核工业集团','北京兴华门3333号');
insert into cus_customer(cus_name,cus_addr) values('百度集团','北京中关村创业园区');
insert into cus_customer(cus_name,cus_addr) values('阿里巴巴','杭州某某地');
--
insert into sale_product(prod_name,prod_price) values('GPS',3300.0);
insert into sale_product(prod_name,prod_price) values('安全电源',2345);
select * from cus_customer;
select * from sale_product;

  --两个表级联 :sale_order sale_order_line

select odr_id,odr_customer_id,odr_customer_name,odr_deliver_addr,odr_order_date,odr_deliver_date,odr_status 
from sale_order
left join sale_order_line
on sale_order.odr_id=sale_order_line.odl_order_id
where odr_id=1;













