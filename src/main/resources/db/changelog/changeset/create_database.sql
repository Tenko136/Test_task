CREATE TABLE IF NOT EXISTS client_account (
id INT NOT NULL AUTO_INCREMENT,
num VARCHAR(10),
currency VARCHAR(5),
PRIMARY KEY(id),
UNIQUE (num)
);

CREATE TABLE IF NOT EXISTS client_limit (
id INT NOT NULL AUTO_INCREMENT,
client_account_id INT,
date_time TIMESTAMP,
amount DECIMAL(9,2) DEFAULT '1000.00',
category VARCHAR (10),
rest DECIMAL(9,2),
currency VARCHAR(3) DEFAULT 'USD',
PRIMARY KEY(id),
FOREIGN KEY (client_account_id) REFERENCES client_account(id)
);

CREATE TABLE IF NOT EXISTS client_transaction (
id INT NOT NULL AUTO_INCREMENT,
client_account_id INT NOT NULL,
target_acc_num INT(10),
purchase_amount DECIMAL(9,2),
category VARCHAR(10),
date_time TIMESTAMP,
currency VARCHAR(5),
is_limit_exceed BOOLEAN NOT NULL,
PRIMARY KEY(id),
FOREIGN KEY (client_account_id) REFERENCES client_account(id)
);

CREATE TABLE IF NOT EXISTS currency_rate (
id INT NOT NULL AUTO_INCREMENT,
date_rate DATE,
rate_USD_KZ DECIMAL(9,2),
rate_USD_RU DECIMAL(9,2),
PRIMARY KEY(id)
);