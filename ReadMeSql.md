1. For Address Table 

----------------------------
   desc address_tbl;
 Name                                      Null?    Type
 ----------------------------------------- -------- ----------------------------
 ADDRESS_ID                                NOT NULL NUMBER(10)
 CITY                                               VARCHAR2(255 CHAR)
 COLONY                                             VARCHAR2(255 CHAR)
 HOUSE_NO                                           VARCHAR2(255 CHAR)
 PINCODE                                   NOT NULL NUMBER(10)
 STATE                                              VARCHAR2(255 CHAR)
 
 a. insert into address_tbl values(11,'Howrah','Birendra','B/1',711,'West Bengal'); / enter / commit;
 b. insert into address_tbl values(12,'Kolkata','Hemanta Chandra','27/B',721,'West Bengal');    commit;
 c.
 --------------------------------------------------------------------------------------------------------------------------
 2. For Customer Table
 ----------------------
  desc customer_tbl;
 Name                                      Null?    Type
 ----------------------------------------- -------- ----------------------------
 CUSTOMER_ID                               NOT NULL NUMBER(10)
 CUSTOMER_EMAIL                                     VARCHAR2(255 CHAR)
 CUSTOMER_NAME                                      VARCHAR2(255 CHAR)
 PASSWORD                                           VARCHAR2(255 CHAR)
 USERNAME                                           VARCHAR2(255 CHAR)
 ADDRESS_ID                                         NUMBER(10)
 
 a. insert into customer_tbl values(101,'Pri@gmail.com','Priyanka','123p','P21D',11);
 b.  insert into customer_tbl values(102,'Labo@gmail.com','Laboni','rb234','A21G',12);
 c.
 
 -----------------------------------------------------------------------------------------------------------------------
 
 Plant :
 ------------------------------------
 
 
 a.insert into plant_info values(401,'June-September','Mango Tree- Mangifera indica','Hard','Mangoes are also loaded with vitamin A, making it a perfect fruit to improve eye sight. It also prevents night blindness and dry eyes.',250.5,'The tree is evergreen, often reaching 15-18 metres (50-60 feet) in height and attaining great age. The simple leaves are lanceolate, up to 30 cm (12 inches) long.',148,'Wide Spreading',50,'24-27C','Tropical tree');
 
 
 b.  insert into plant_info values(402,'September-January','Orange Plant - Citrus x sinensis','Hard','The peel and juice are used to make medicine. Sweet orange is used for high cholesterol, high blood pressure, and stroke prevention. It is also used for the common cold, kidney stones, and other conditions',305.5,'Orange plant (Citrus x sinensis) belongs to the Rutaceae family. It is a flowering tree. Orange tree is grown mostly for its fruits, but also for its flowers and as an ornamental.',35,'Wide Spreading',45,'55-100F','Citrus Fruit Evergreen Plant');
 
 
 
 
 
---------------------------------------------------------------------------------------------- 
 
planter
---------------------------------------

a.  insert into planter_tb values(501,3,121,111,160,'Box',50,15.5);
b.   insert into planter_tb values(502,3,210,112,156,'Box',70,15.5);

----------------------------------------------
Seed
------------------------------------------------------------------------------------
a.
SQL> insert into seed_tbl values(601,'March-April','Zinnia Dahlia ','Hard but moist',230.5,'Seeds may treated with thiram to maintain good germination but seeds are not harmful you can use this seeds for sowing purpose',20,100,'24-27c','Mix GMO-free Seeds','Twice a day');

b.    insert into Seed_Tbl values(602,'2-weeks','Tomato','Hard',211.5,'They are usually red, scarlet, or yellow, though green and purple varieties do exist, and they vary in shape from almost spherical to oval and elongate to pear-shaped.',20,120,'24-27c','Vishal Arka','Twice a day');

-------------------------------------------------
Cart
_________________________________________________
a.  insert into cart values(5001,101,2,1,1,'cart',550.5,401,501,601);
b. insert into cart values(5002,102,2,1,1,'cart',550.5,401,501,601);

------------------------------------------------------------------

Order
--------------------------------------------------------------

a.insert into store_order values(1001,'Kolkata','India',CURRENT_TIMESTAMP,'Shipped','COD',5,'Pri','9871524352','M-23','Near Apolo Hospital',300,201003,101);



