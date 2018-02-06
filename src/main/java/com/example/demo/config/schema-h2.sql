-- drop the sequences
drop sequence company_product_id_seq;
drop sequence customer_id_seq;
-- unique/primary keys in table referenced by enabled foreign keys
-- and drop the table with  foriegn key first
ALTER TABLE  COMPANY_CUSTOMERS disable  constraint fk_product_pk;

--Drop the tables
drop table   COMPANY_CUSTOMERS;
drop table   COMPANY_RELATION_MANAGEMENT;
drop table   COMPANY_PRODUCTS;

-- Create the tables
 create table  COMPANY_PRODUCTS
(  
	 company_product_id  	 	  NUMBER (32) not null, 
	 customer_product_name 		VARCHAR2 (64) not null,
	  created_date				Date,
	 CONSTRAINT products_pk PRIMARY KEY (company_product_id)
);

create table  COMPANY_CUSTOMERS
(
	 customer_id 			NUMBER (16) not null,
	 customer_name 			VARCHAR2 (32) not null,
	 company_product_id  	NUMBER (32) not null,
	 phone 					VARCHAR2 (32) ,
	 notes 					VARCHAR2 (32) ,
	 company_name 			VARCHAR2 (32) not null,
	 demography 			VARCHAR2 (32) ,
	 email 					VARCHAR2 (32) not null,
	 created_date			Date,
	 CONSTRAINT customers_pk PRIMARY KEY (customer_id),
	 CONSTRAINT fk_product_pk
	    FOREIGN KEY (company_product_id)
	    REFERENCES COMPANY_PRODUCTS(company_product_id)
);  
 
create table  COMPANY_RELATION_MANAGEMENT  
(  
	 customer_id  	 	NUMBER (16) not null, 
	 company_product_id NUMBER (32) not null,
	CONSTRAINT relation_management_pk PRIMARY KEY (customer_id,company_product_id)
 );
 
-- create sequences 
create sequence company_product_id_seq increment by 1 start with 1;
create sequence customer_id_seq increment by 1 start with 1;

-- insert test record 1
insert into COMPANY_PRODUCTS values(company_product_id_seq.nextval,'Burger Buns', sysdate);
insert into COMPANY_CUSTOMERS values(customer_id_seq.nextval,'Michael Somers',
(select cp.company_product_id from  COMPANY_PRODUCTS cp where  trim(cp. customer_product_name) = 'Burger Buns'), '911-223-0000','I Love it','My Company','ASIAN','me@yahoo.com', sysdate);
-- corelate the reocords
insert into COMPANY_RELATION_MANAGEMENT  
values(
(
select cc.customer_id from  COMPANY_CUSTOMERS cc, COMPANY_PRODUCTS cp  where trim(cp. customer_product_name) = 'Burger Buns'   and cc.phone='911-223-0000'
),

(select cp.company_product_id from  COMPANY_PRODUCTS cp where  trim(cp. customer_product_name) = 'Burger Buns' )
);


-- insert test record 2
insert into COMPANY_PRODUCTS values(company_product_id_seq.nextval,'Cheese Rolls', sysdate-1);
insert into COMPANY_CUSTOMERS values(customer_id_seq.nextval,'Donold Foobart',
(select cp.company_product_id from  COMPANY_PRODUCTS cp where  trim(cp. customer_product_name) = 'Cheese Rolls'), '415-223-6000','I Love it yep','Your Company Inc','WHITE','meandyou@hotmail.com', sysdate);
-- corelate the reocords
insert into COMPANY_RELATION_MANAGEMENT  
values(
(
select cc.customer_id from  COMPANY_CUSTOMERS cc, COMPANY_PRODUCTS cp  where trim(cp. customer_product_name) = 'Cheese Rolls'   and cc.phone='415-223-6000'
),

(select cp.company_product_id from  COMPANY_PRODUCTS cp where  trim(cp. customer_product_name) = 'Cheese Rolls' )
);

