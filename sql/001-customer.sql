DROP TABLE IF EXISTS customer;
CREATE TABLE IF NOT EXISTS customer (
  id SERIAL,
  username VARCHAR(255),
  password VARCHAR(255),
  salt VARCHAR(255),
  email VARCHAR(255),
  first_name VARCHAR(255),
  last_name VARCHAR(255),
  date_of_birth DATE,
  address VARCHAR(255),
  stripe_customer_id VARCHAR(255),
  created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

INSERT INTO customer (username, password, salt, email, first_name, last_name, date_of_birth, address, stripe_customer_id, created_at)
VALUES
  ('alice123', 'hashed_password', 'random_salt', 'alice@example.com', 'Alice', 'Sample', '1990-05-15', '東京都渋谷区道玄坂1-2-3', 'stripe_123', '2023-08-26 10:00:00.5'),
  ('bob456', 'hashed_password', 'random_salt', 'bob@example.com', 'Bob', 'Doe', '1985-10-20', '東京都渋谷区道玄坂4-5-6', 'stripe_456', '2023-08-26 11:30:00.1');
