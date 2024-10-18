-- Drop tables if they already exist
DROP TABLE IF EXISTS exchange_stocks;
DROP TABLE IF EXISTS stock;
DROP TABLE IF EXISTS stock_exchange;

-- Create the stock_exchange table
CREATE TABLE stock_exchange (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    description TEXT,
    live_in_market BOOLEAN NOT NULL
);

-- Create the stock table
CREATE TABLE stock (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    description TEXT,
    current_price DECIMAL(15, 2) NOT NULL,
    last_update TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Create the exchange_stocks junction table
CREATE TABLE exchange_stocks (
    exchange_id BIGINT NOT NULL,
    stock_id BIGINT NOT NULL,
    PRIMARY KEY (exchange_id, stock_id),
    FOREIGN KEY (exchange_id) REFERENCES stock_exchange(id) ON DELETE CASCADE,
    FOREIGN KEY (stock_id) REFERENCES stock(id) ON DELETE CASCADE
);
