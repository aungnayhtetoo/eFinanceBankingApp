CREATE TABLE Loan(
    Loan_ID int NOT NULL PRIMARY KEY,
    Customer_ID int NOT NULL,
    Loan_Type VARCHAR(20) NOT NULL,
    Loan_Amount FLOAT(10) NOT NULL,
    Principal FLOAT(10) NOT NULL,
    Interest_Rate FLOAT(5) NOT NULL,
    Loan_Term int NOT NULL,
    Fee FLOAT(10) NOT NULL,
    Secured boolean NOT NULL,
    Approved boolean NOT NULL,
    FOREIGN KEY (Customer_ID) REFERENCES Customer(Customer_ID)
    
);