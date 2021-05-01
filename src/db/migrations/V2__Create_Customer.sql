CREATE TABLE Customer(
    Customer_ID int NOT NULL PRIMARY KEY,
    Customer_First_Name VARCHAR(20) NOT NULL,
    Customer_Last_Name VARCHAR(20) NOT NULL,
    Customer_Email VARCHAR(30) NOT NULL,
    Customer_Phone_Number VARCHAR(10) NOT NULL,
    Username VARCHAR(30) NOT NULL,
    FOREIGN KEY (Username) REFERENCES Userdata(Username)
    
);