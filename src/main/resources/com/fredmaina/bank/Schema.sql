USE JavaBank;
CREATE TABLE users (
    id INT PRIMARY KEY AUTO_INCREMENT,  -- User's unique identifier
    username VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    role VARCHAR(50) DEFAULT 'user',  -- Role could be 'user' or 'admin'
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Define the accounts table
CREATE TABLE accounts (
    id INT PRIMARY KEY AUTO_INCREMENT,  -- Account's unique identifier
    user_id INT,  -- Foreign key to the users table
    account_number INT UNIQUE NOT NULL,
    account_balance INT DEFAULT 0,
    account_holder VARCHAR(255),
    account_type VARCHAR(50) DEFAULT 'normal',  -- Type of account (e.g., 'normal', 'fixed')
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT fk_user_id FOREIGN KEY (user_id) REFERENCES users(id)
);

-- Define the fixed deposit account table, which is a special type of account
CREATE TABLE fixed_deposit_accounts (
    id INT PRIMARY KEY AUTO_INCREMENT,  -- Fixed deposit account's unique identifier
    account_id INT,  -- Foreign key to the accounts table
    months_to_lock INT,  -- Number of months the deposit is locked
    maturity_date TIMESTAMP,  -- Date when the account matures and funds can be withdrawn
    interest_rate DECIMAL(5,2) DEFAULT 12.5,  -- Annual interest rate for the deposit
    CONSTRAINT fk_account_id FOREIGN KEY (account_id) REFERENCES accounts(id)
);

-- Define the transactions table to store deposit and withdrawal history
CREATE TABLE transactions (
    id INT PRIMARY KEY AUTO_INCREMENT,  -- Transaction unique identifier
    account_id INT,  -- Foreign key to the accounts table
    transaction_type VARCHAR(50) CHECK (transaction_type IN ('deposit', 'withdrawal')),  -- 'deposit' or 'withdrawal'
    amount INT,  -- Amount involved in the transaction
    transaction_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    description VARCHAR(255),  -- Optional field for extra information
    CONSTRAINT fk_transaction_account FOREIGN KEY (account_id) REFERENCES accounts(id)
);

-- Additional relationships (optional)
-- One user can have many accounts
-- A fixed deposit account is linked to an account
-- Transactions are linked to accounts
