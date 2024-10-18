-- Insert data into stock_exchange table
INSERT INTO stock_exchange (name, description, live_in_market) VALUES
('New York Stock Exchange', 'The largest stock exchange in the world by market capitalization.', TRUE),
('NASDAQ', 'A global electronic marketplace for buying and selling securities.', TRUE),
('London Stock Exchange', 'One of the oldest stock exchanges in the world.', TRUE),
('Tokyo Stock Exchange', 'Japan’s largest stock exchange.', TRUE),
('Shanghai Stock Exchange', 'One of the largest stock exchanges in Asia.', TRUE),
('Hong Kong Stock Exchange', 'A leading financial center in Asia.', TRUE),
('Euronext', 'The largest stock exchange in Europe.', TRUE),
('Frankfurt Stock Exchange', 'Germany’s primary stock exchange.', TRUE),
('Toronto Stock Exchange', 'The largest stock exchange in Canada.', TRUE),
('BSE (Bombay Stock Exchange)', 'The oldest stock exchange in Asia.', TRUE),
('NSE (National Stock Exchange)', 'The leading stock exchange in India.', TRUE),
('Australian Securities Exchange', 'Australia’s primary securities exchange.', TRUE),
('Singapore Exchange', 'A leading stock exchange in Southeast Asia.', TRUE),
('Mexican Stock Exchange', 'The main stock exchange in Mexico.', TRUE),
('Korean Exchange', 'The main stock exchange in South Korea.', TRUE),
('Swiss Exchange', 'The main stock exchange in Switzerland.', TRUE),
('Moscow Exchange', 'The largest exchange in Russia.', TRUE),
('Taiwan Stock Exchange', 'The main stock exchange in Taiwan.', TRUE),
('Stockholm Stock Exchange', 'The main stock exchange in Sweden.', TRUE),
('Oslo Stock Exchange', 'Norway’s main stock exchange.', TRUE),
('Copenhagen Stock Exchange', 'The largest stock exchange in Denmark.', TRUE),
('Vienna Stock Exchange', 'The main stock exchange in Austria.', TRUE),
('Istanbul Stock Exchange', 'Turkey’s main stock exchange.', TRUE),
('Philippine Stock Exchange', 'The main stock exchange in the Philippines.', TRUE),
('Johannesburg Stock Exchange', 'The largest stock exchange in Africa.', TRUE),
('Dubai Financial Market', 'The main stock exchange in Dubai.', TRUE),
('Qatar Stock Exchange', 'The main stock exchange in Qatar.', TRUE),
('Bahrain Bourse', 'The main stock exchange in Bahrain.', TRUE),
('Vietnam Stock Exchange', 'The main stock exchange in Vietnam.', TRUE),
('Nairobi Securities Exchange', 'The main stock exchange in Kenya.', TRUE),
('Colombo Stock Exchange', 'The main stock exchange in Sri Lanka.', TRUE);

-- Insert data into stock table
INSERT INTO stock (name, description, current_price, last_update) VALUES
('Apple Inc.', 'Technology company that designs, manufactures, and sells consumer electronics.', 150.25, NOW()),
('Microsoft Corp.', 'Multinational technology company known for software products.', 280.45, NOW()),
('Tesla Inc.', 'Electric vehicle and clean energy company.', 750.55, NOW()),
('Amazon.com Inc.', 'E-commerce and cloud computing giant.', 3400.00, NOW()),
('Alphabet Inc. (Google)', 'Parent company of Google and several other businesses.', 2800.00, NOW()),
('Facebook, Inc.', 'Social media conglomerate.', 350.50, NOW()),
('Berkshire Hathaway Inc.', 'Conglomerate holding company led by Warren Buffett.', 400.00, NOW()),
('Visa Inc.', 'Global payments technology company.', 220.10, NOW()),
('Johnson & Johnson', 'Global healthcare company.', 175.25, NOW()),
('Procter & Gamble Co.', 'Consumer goods corporation.', 135.80, NOW()),
('Walmart Inc.', 'Multinational retail corporation.', 145.20, NOW()),
('UnitedHealth Group Inc.', 'Health insurance and managed healthcare company.', 420.15, NOW()),
('Coca-Cola Co.', 'Beverage corporation known for its soft drinks.', 54.75, NOW()),
('PepsiCo, Inc.', 'Food and beverage corporation.', 149.20, NOW()),
('Intel Corporation', 'Multinational corporation and technology company.', 55.00, NOW()),
('NVIDIA Corporation', 'Technology company known for graphics processing units.', 210.45, NOW()),
('Netflix Inc.', 'Subscription-based streaming service.', 500.10, NOW()),
('Adobe Inc.', 'Multinational software company.', 600.00, NOW()),
('Salesforce.com Inc.', 'Cloud-based software company.', 250.20, NOW()),
('PayPal Holdings, Inc.', 'Online payments system.', 290.00, NOW()),
('Nike, Inc.', 'Multinational corporation that designs, develops, and sells footwear and apparel.', 165.30, NOW()),
('McDonald\'s Corporation', 'Fast-food restaurant chain.', 260.15, NOW()),
('Walt Disney Company', 'Entertainment and media conglomerate.', 185.50, NOW()),
('IBM Corporation', 'Multinational technology and consulting company.', 130.25, NOW()),
('Ford Motor Company', 'Automotive manufacturer.', 12.40, NOW()),
('General Motors Company', 'Automotive manufacturer.', 43.70, NOW()),
('Pfizer Inc.', 'Pharmaceutical corporation.', 44.10, NOW()),
('Tesla Inc.', 'Electric vehicle and clean energy company.', 750.55, NOW()),
('Bristol-Myers Squibb Company', 'Pharmaceutical company.', 65.20, NOW()),
('Chevron Corporation', 'Multinational energy corporation.', 106.50, NOW()),
('Exxon Mobil Corporation', 'Oil and gas corporation.', 61.40, NOW()),
('Starbucks Corporation', 'Coffee company and coffeehouse chain.', 110.75, NOW()),
('eBay Inc.', 'E-commerce corporation.', 55.00, NOW());


INSERT INTO exchange_stocks (exchange_id, stock_id) VALUES
(1, 1),
(1, 2),  -- Microsoft on NYSE
(1, 3),  -- Tesla on NYSE
(2, 1),  -- Apple on NASDAQ
(2, 4),  -- Amazon on NASDAQ
(2, 2),  -- Microsoft on NASDAQ
(3, 5),  -- Alphabet on LSE
(3, 6),  -- Facebook on LSE
(4, 7),  -- Berkshire on TSE
(4, 8),  -- Visa on TSE
(5, 9),  -- Johnson on SSE
(5, 10), -- P&G on SSE
(6, 11), -- Walmart on HKEX
(6, 12), -- UnitedHealth on HKEX
(7, 13), -- Coca-Cola on Euronext
(7, 14), -- Pepsi on Euronext
(8, 15), -- Intel on FSE
(8, 16), -- NVIDIA on FSE
(9, 17), -- Netflix on TSE
(9, 18), -- Adobe on TSE
(10, 19), -- Salesforce on TSX
(10, 20), -- PayPal on TSX
(11, 21), -- Nike on ASX
(11, 22), -- McDonald's on ASX
(12, 23), -- Walt Disney on SGX
(12, 24), -- IBM on SGX
(13, 25), -- Ford on BSE
(13, 26), -- GM on BSE
(14, 27), -- Pfizer on NSE
(14, 28), -- Bristol-Myers on NSE
(15, 29), -- Chevron on ASX
(15, 30); -- Exxon on ASX
