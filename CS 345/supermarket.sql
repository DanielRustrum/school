-- -----------------------------------------
-- CUSTOMERS
-- -----------------------------------------
CREATE TABLE customer (
    id INTEGER NOT NULL,
    name VARCHAR(99) NOT NULL,
    billaddr VARCHAR(255) NOT NULL,
    shipaddr VARCHAR(255) NOT NULL DEFAULT 'See billing address.',
    PRIMARY KEY (id)
);

-- -----------------------------------------
-- CARTS
-- -----------------------------------------
CREATE TABLE cart (
    id INTEGER NOT NULL,
    customer_id INTEGER NOT NULL,
    cartdate TIMESTAMP NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (customer_id) REFERENCES customer (id)
);


-- -----------------------------------------
-- ITEMS
-- -----------------------------------------
CREATE TABLE item (
    id INTEGER NOT NULL,
    name VARCHAR(21) NOT NULL,
    type VARCHAR(7) NOT NULL,
    price DECIMAL(16,4) NULL,
    PRIMARY KEY (id)
);


-- -----------------------------------------
-- CARTITEMS
-- -----------------------------------------
CREATE TABLE cartitem (
    cart_id INTEGER NOT NULL,
    item_id INTEGER NOT NULL,
    qty SMALLINT NOT NULL DEFAULT 1 CHECK (qty <= 10),
    price DECIMAL(16,4),
    PRIMARY KEY (cart_id , item_id),
    FOREIGN KEY (cart_id)
        REFERENCES cart (id),
    FOREIGN KEY (item_id)
        REFERENCES item (id)
);



-- ----------------------------------------------------------------------------------
-- DATA
-- ----------------------------------------------------------------------------------

INSERT INTO customer (id, name, billaddr) VALUES (710,'A. Jones','123 Sesame St., Eureka, KS');
INSERT INTO customer (id, name, billaddr) VALUES (730,'B. Smith','456 Sesame St., Eureka, KS');
INSERT INTO customer (id, name, billaddr) VALUES (750,'C. Brown','789 Sesame St., Eureka, KS');
INSERT INTO customer (id, name, billaddr) VALUES (770,'D. White','246 Sesame St., Eureka, KS');
INSERT INTO customer (id, name, billaddr) VALUES (820,'E. Baker','135 Sesame St., Eureka, KS');
INSERT INTO customer (id, name, billaddr) VALUES (840,'F. Black','468 Sesame St., Eureka, KS');
INSERT INTO customer (id, name, billaddr) VALUES (860,'G. Scott','357 Sesame St., Eureka, KS');
INSERT INTO customer (id, name, billaddr) VALUES (999,'G. Scott','357 Sesame St., Eureka, KS');
INSERT INTO customer (id, name, billaddr, shipaddr) VALUES (880,'H. Clark','937 Sesame St., Eureka, KS', 'P.O. Box 9, Toledo, OH' );

INSERT INTO cart (id, customer_id, cartdate) VALUES (2131,710,'2008-09-03 00:00:00');
INSERT INTO cart (id, customer_id, cartdate) VALUES (2461,820,'2008-09-16 00:00:00');
INSERT INTO cart (id, customer_id, cartdate) VALUES (9999,999,'2008-09-16 00:00:00');
INSERT INTO cart (id, customer_id, cartdate) VALUES (2921,730,'2008-09-19 00:00:00');
INSERT INTO cart (id, customer_id, cartdate) VALUES (2937,750,'2008-09-21 00:00:00');
INSERT INTO cart (id, customer_id, cartdate) VALUES (3001,750,'2008-09-23 00:00:00');
INSERT INTO cart (id, customer_id, cartdate) VALUES (3002,730,'2008-10-07 00:00:00');
INSERT INTO cart (id, customer_id, cartdate) VALUES (3081,880,'2008-10-13 00:00:00');
INSERT INTO cart (id, customer_id, cartdate) VALUES (3197,770,'2008-10-14 00:00:00');
INSERT INTO cart (id, customer_id, cartdate) VALUES (3321,860,'2008-10-26 00:00:00');
INSERT INTO cart (id, customer_id, cartdate) VALUES (3937,750,'2008-10-28 00:00:00');

INSERT INTO item VALUES (5021,'thingie'        ,'widgets',  9.37 );
INSERT INTO item VALUES (5022,'gadget'         ,'doodads', 19.37 );
INSERT INTO item VALUES (5023,'dingus'         ,'gizmos' , 29.37 );
INSERT INTO item VALUES (5041,'gewgaw'         ,'widgets',  5.00 );
INSERT INTO item VALUES (5042,'knickknack'     ,'doodads', 10.00 );
INSERT INTO item VALUES (5043,'whatnot'        ,'gizmos' , 15.00 );
INSERT INTO item VALUES (5061,'bric-a-brac'    ,'widgets',  2.00 );
INSERT INTO item VALUES (5062,'folderol'       ,'doodads',  4.00 );
INSERT INTO item VALUES (5063,'jigger'         ,'gizmos' ,  6.00 );
INSERT INTO item VALUES (5901,'doohickey'      ,'widgets', 12.00 );
INSERT INTO item VALUES (5902,'gimmick'        ,'doodads',  9.37 );
INSERT INTO item VALUES (5903,'dingbat'        ,'gizmos' ,  9.37 );
INSERT INTO item VALUES (5911,'thingamajig'    ,'widgets',  NULL );
INSERT INTO item VALUES (5912,'thingamabob'    ,'doodads', 22.22 );
INSERT INTO item VALUES (5913,'thingum'        ,'gizmos' , 22.22 );
INSERT INTO item VALUES (5931,'contraption'    ,'widgets', 49.95 );
INSERT INTO item VALUES (5932,'whatchamacallit','doodads', 59.95 );
INSERT INTO item VALUES (5937,'whatsis'        ,'gizmos' , 93.70 );

INSERT INTO cartitem (cart_id, item_id, qty, price) VALUES (2131,5902,3, 9.37);
INSERT INTO cartitem (cart_id, item_id, qty, price) VALUES (2131,5913,2,22.22);
INSERT INTO cartitem (cart_id, item_id, qty, price) VALUES (2461,5043,3,15.00);
INSERT INTO cartitem (cart_id, item_id, qty, price) VALUES (2461,5901,2,12.00);
INSERT INTO cartitem (cart_id, item_id, qty, price) VALUES (2921,5023,3,29.37);
INSERT INTO cartitem (cart_id, item_id, qty, price) VALUES (2921,5937,2,93.70);
INSERT INTO cartitem (cart_id, item_id, qty, price) VALUES (2937,5913,1,22.22);
INSERT INTO cartitem (cart_id, item_id, qty, price) VALUES (3001,5912,3,22.22);
INSERT INTO cartitem (cart_id, item_id, qty, price) VALUES (3001,5937,2,93.70);
INSERT INTO cartitem (cart_id, item_id, qty, price) VALUES (3002,5901,1,12.00);
INSERT INTO cartitem (cart_id, item_id, qty, price) VALUES (3081,5023,3,29.37);
INSERT INTO cartitem (cart_id, item_id, qty, price) VALUES (3081,5913,2,22.22);
INSERT INTO cartitem (cart_id, item_id, qty, price) VALUES (3197,5932,1,59.95);
INSERT INTO cartitem (cart_id, item_id, qty, price) VALUES (3321,5932,3,59.95);
INSERT INTO cartitem (cart_id, item_id, qty, price) VALUES (3937,5913,3,22.22);
