Admin

a.insert into admin_tbl values(2021,'Priyanka Dutta','p123pd','pd21d');


{
        "id": 2021,
        "username": "pd21d",
        "password": "p123pd",
        "adminname": "Priyanka Dutta"
    }
1.For updating Admin info:

http://localhost:9091/updateadmin/2021

2.For retrieving Admin info

 http://localhost:9091/getadmins
 
3. For adding Admin

http://localhost:9091/addAdmin

4. For deleting admin

http://localhost:9091/deleteadmin/2022

For Admin Login

http://localhost:9091/loginbyAdmin/pd21dJus/p123pd





For Customer Login

  http://localhost:9091/login/P21D/123p
  
  



customer
---------------------------------
1.

For Retrieving All customer records:

url : http://localhost:9091/getallcustomers

For getting a particular customer information:

url: http://localhost:9091/getcustomer/101

For Deleting a specific customer id information:

url: http://localhost:9091/customer/102

For adding a specific customer

http://localhost:9091/addCustomer

For Updating Customer Information:

http://localhost:9091/updatecustomer/107






Output:
{
        "customerId": 101,
        "customerName": "Priyanka",
        "customerEmail": "Pri@gmail.com",
        "username": "P21D",
        "password": "123p",
        "address": {
            "addressId": 11,
            "houseNo": "B/1",
            "colony": "Birendra",
            "city": "Howrah",
            "state": "West Bengal",
            "pincode": 711
        }
    },
    {
        "customerId": 102,
        "customerName": "Laboni",
        "customerEmail": "Labo@gmail.com",
        "username": "A21G",
        "password": "rb234",
        "address": {
            "addressId": 12,
            "houseNo": "27/B",
            "colony": "Hemanta Chandra",
            "city": "Kolkata",
            "state": "West Bengal",
            "pincode": 721
        }
    }
    
    
    
    
                              For Plant The Controller Will be:
 
 
 
 For viewing a plant of specific id:
 
 url: http://localhost:9091/Plantinfo/PlantViewbyid/401
 
 
 For Viewing All plants:
 
 http://localhost:9091/Plantinfo/PlantViewAll
 
 For viewing plant with common name:
 
 http://localhost:9091/Plantinfo/PlantViewbyname/Orange Plant - Citrus x sinensis
 
 
 For Updating plant :
 
 http://localhost:9091/Plantinfo/UpdatePlant/402
 
 
 For deleting plant:
 
 http://localhost:9091/Plantinfo/DeletePlant/402
 
 
 For adding plant:
 
 http://localhost:9091/Plantinfo/PlantAddition
 
 1..... {
    "plantId": 401,
    "plantHeight": 148,
    "plantSpread": "Wide Spreading",
    "commonName": "Mango Tree- Mangifera indica",
    "bloomTime": "June-September",
    "medicinalOrCulinaryUse": "Mangoes are also loaded with vitamin A, making it a perfect fruit to improve eye sight. It also prevents night blindness and dry eyes.",
    "difficultyLevel": "Hard",
    "temparature": "24-27C",
    "typeOfPlant": "Tropical tree",
    "plantDescription": "The tree is evergreen, often reaching 15-18 metres (50-60 feet) in height and attaining great age. The simple leaves are lanceolate, up to 30 cm (12 inches) long.",
    "plantsStock": 50,
    "plantCost": 250.5
}
                              
   
   
   2......
   {
        "plantId": 401,
        "plantHeight": 148,
        "plantSpread": "Wide Spreading",
        "commonName": "Mango Tree- Mangifera indica",
        "bloomTime": "June-September",
        "medicinalOrCulinaryUse": "Mangoes are also loaded with vitamin A, making it a perfect fruit to improve eye sight. It also prevents night blindness and dry eyes.",
        "difficultyLevel": "Hard",
        "temparature": "24-27C",
        "typeOfPlant": "Tropical tree",
        "plantDescription": "The tree is evergreen, often reaching 15-18 metres (50-60 feet) in height and attaining great age. The simple leaves are lanceolate, up to 30 cm (12 inches) long.",
        "plantsStock": 50,
        "plantCost": 250.5
    },
    {
        "plantId": 402,
        "plantHeight": 35,
        "plantSpread": "Wide Spreading",
        "commonName": "Orange Plant - Citrus x sinensis",
        "bloomTime": "September-January",
        "medicinalOrCulinaryUse": "The peel and juice are used to make medicine. Sweet orange is used for high cholesterol, high blood pressure, and stroke prevention. It is also used for the common cold, kidney stones, and other conditions",
        "difficultyLevel": "Hard",
        "temparature": "55-100F",
        "typeOfPlant": "Citrus Fruit Evergreen Plant",
        "plantDescription": "Orange plant (Citrus x sinensis) belongs to the Rutaceae family. It is a flowering tree. Orange tree is grown mostly for its fruits, but also for its flowers and as an ornamental.",
        "plantsStock": 45,
        "plantCost": 305.5
    }   
    
    
    
    
    
                         PLANTER
                 
 
 1. To retrieve all values of planter
 
  http://localhost:9091/Planter_tb/planterViewAllvalue
  
 2. To retrieve all values into a range of planter
 
 http://localhost:9091/Planter_tb/PlanterViewAll/150/160
 
 3. For updating a planter 
 
  http://localhost:9091/Planter_tb/update/502
  
 4.For getting a planter of particular shape
 
 http://localhost:9091/Planter_tb/PlanterViewbyshape/Box
 
5. For deleting a specific planter

 http://localhost:9091/Planter_tb/DeletePlanter/502
 
6. For adding a particular planter
 http://localhost:9091/Planter_tb/PlanterAddition
 
 
  {
        "planterId": 501,
        "planterheight": 15.5,
        "planterCapacity": 121,
        "drinageHoles": 3,
        "planterColor": 111,
        "planterShape": "Box",
        "planterStock": 50,
        "planterCost": 160
    },
    {
        "planterId": 502,
        "planterheight": 15.5,
        "planterCapacity": 210,
        "drinageHoles": 3,
        "planterColor": 112,
        "planterShape": "Box",
        "planterStock": 70,
        "planterCost": 156
    } 
    
    
    
    
                                 For Seed
    
    
1.View Seed By Id
 url:  http://localhost:9091/viewseedbyid/601
 
2. View Seed By name

 http://localhost:9091/viewseedbyname/Tomato
 
3. View Seed by type of seeds

 http://localhost:9091/viewseedbytype/Vishal Arka
 
 4. update seed 
 http://localhost:9091/updateseed/601
 
 5. Delete seed by id 
  http://localhost:9091/deleteseed/602
  
 6. Add a seed
 
  http://localhost:9091/addseed
 
 






POSTMAN
{
    "seedId": 601,
    "commonName": "Zinnia Dahlia ",
    "bloomTime": "March-April",
    "watering": "Twice a day",
    "difficultyLevel": "Hard but moist",
    "temparature": "24-27c",
    "typeOfSeeds": "Mix GMO-free Seeds",
    "seedsDescription": "Seeds may treated with thiram to maintain good germination but seeds are not harmful you can use this seeds for sowing purpose",
    "seedsStock": 100,
    "seedsCost": 230.5,
    "seedsPerPacket": 20
}
    
               
               
 {
        "seedId": 602,
        "commonName": "Tomato",
        "bloomTime": "2-weeks",
        "watering": "Twice a day",
        "difficultyLevel": "Hard",
        "temparature": "24-27c",
        "typeOfSeeds": "Vishal Arka",
        "seedsDescription": "They are usually red, scarlet, or yellow, though green and purple varieties do exist, and they vary in shape from almost spherical to oval and elongate to pear-shaped.",
        "seedsStock": 120,
        "seedsCost": 211.5,
        "seedsPerPacket": 20
    }             
    
    
    
    
    
    
    
    
                          CART 
                          
1. To view the cart of particular customer

 http://localhost:9091/viewcartbycustomerid/101
 
2. To delete item throgh cart id

 http://localhost:9091/removecartitem/5002
 
 
3. To add item

 http://localhost:9091/addbooktocart/601/401/501/102/2/1/1/cart

4. To remove cart item by customer id

 http://localhost:9091/clearcartbycustomerid/102


{
        "cartId": 5001,
        "customerId": 101,
        "seedQuantity": 1,
        "plantQuantity": 2,
        "planterQuantity": 1,
        "status": "cart",
        "subtotal": 550.5,
        "seed": {
            "seedId": 601,
            "commonName": "Zinnia Dahlia ",
            "bloomTime": "March-April",
            "watering": "Twice a day",
            "difficultyLevel": "Hard but moist",
            "temparature": "24-27c",
            "typeOfSeeds": "Mix GMO-free Seeds",
            "seedsDescription": "Seeds may treated with thiram to maintain good germination but seeds are not harmful you can use this seeds for sowing purpose",
            "seedsStock": 100,
            "seedsCost": 270.5,
            "seedsPerPacket": 20
        },
        "plant": {
            "plantId": 401,
            "plantHeight": 148,
            "plantSpread": "Wide Spreading",
            "commonName": "Mango Tree- Mangifera indica",
            "bloomTime": "June-September",
            "medicinalOrCulinaryUse": "Mangoes are also loaded with vitamin A, making it a perfect fruit to improve eye sight. It also prevents night blindness and dry eyes.",
            "difficultyLevel": "Hard",
            "temparature": "24-27C",
            "typeOfPlant": "Tropical tree",
            "plantDescription": "The tree is evergreen, often reaching 15-18 metres (50-60 feet) in height and attaining great age. The simple leaves are lanceolate, up to 30 cm (12 inches) long.",
            "plantsStock": 50,
            "plantCost": 250.5
        },
        "planter": {
            "planterId": 501,
            "planterheight": 15.5,
            "planterCapacity": 121,
            "drinageHoles": 3,
            "planterColor": 111,
            "planterShape": "Box",
            "planterStock": 50,
            "planterCost": 160
        }
    }
    
    
    
    
                         Order module 
                         
                         
 1. To view all order
  http://localhost:9091/viewAllOrder
  
2. To view Order of particular order id

 http://localhost:9091/searchOrder/1001
 
3. To search order of a particular customer through customer id

 http://localhost:9091/viewOrderByCustomerId/101
 
4. To add a particular order

 http://localhost:9091/addOrder
 
 
 
 
 
 
 
 
 
 
 POSTMAN
 
 
 
 {
        "orderId": 1001,
        "recipientName": "Pri",
        "recipientPhoneNumber": "9871524352",
        "streetAddress": "Near Apolo Hospital",
        "city": "Kolkata",
        "zipCode": 201003,
        "country": "India",
        "shippingAddress": "M-23",
        "quantity": 5,
        "totalPrice": 300.0,
        "orderStatus": "Shipped",
        "paymentMethod": "COD",
        "orderDate": "2021-05-17",
        "cart": [
            {
                "cartId": 5001,
                "customerId": 101,
                "seedQuantity": 1,
                "plantQuantity": 2,
                "planterQuantity": 1,
                "status": "cart",
                "subtotal": 550.5,
                "seed": {
                    "seedId": 601,
                    "commonName": "Zinnia Dahlia ",
                    "bloomTime": "March-April",
                    "watering": "Twice a day",
                    "difficultyLevel": "Hard but moist",
                    "temparature": "24-27c",
                    "typeOfSeeds": "Mix GMO-free Seeds",
                    "seedsDescription": "Seeds may treated with thiram to maintain good germination but seeds are not harmful you can use this seeds for sowing purpose",
                    "seedsStock": 100,
                    "seedsCost": 270.5,
                    "seedsPerPacket": 20
                },
                "plant": {
                    "plantId": 401,
                    "plantHeight": 148,
                    "plantSpread": "Wide Spreading",
                    "commonName": "Mango Tree- Mangifera indica",
                    "bloomTime": "June-September",
                    "medicinalOrCulinaryUse": "Mangoes are also loaded with vitamin A, making it a perfect fruit to improve eye sight. It also prevents night blindness and dry eyes.",
                    "difficultyLevel": "Hard",
                    "temparature": "24-27C",
                    "typeOfPlant": "Tropical tree",
                    "plantDescription": "The tree is evergreen, often reaching 15-18 metres (50-60 feet) in height and attaining great age. The simple leaves are lanceolate, up to 30 cm (12 inches) long.",
                    "plantsStock": 50,
                    "plantCost": 250.5
                },
                "planter": {
                    "planterId": 501,
                    "planterheight": 15.5,
                    "planterCapacity": 121,
                    "drinageHoles": 3,
                    "planterColor": 111,
                    "planterShape": "Box",
                    "planterStock": 50,
                    "planterCost": 160
                }
            }
        ],
        "customer": {
            "customerId": 101,
            "customerName": "Priyanka",
            "customerEmail": "Pri@gmail.com",
            "username": "P21D",
            "password": "123p",
            "address": {
                "addressId": 11,
                "houseNo": "B/1",
                "colony": "Birendra",
                "city": "Howrah",
                "state": "West Bengal",
                "pincode": 711
            }
        }
    }


    
    
    
    