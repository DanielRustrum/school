DROP SCHEMA IF EXISTS paintings;
CREATE SCHEMA IF NOT EXISTS paintings;
USE paintings;

CREATE TABLE gallery (
    id INT(10) NOT NULL UNIQUE, -- AUTO_INCREMENT
    owner VARCHAR(35),
    areacode VARCHAR(3),
    phone VARCHAR(8),
    rate DECIMAL(16 , 5 ),
    PRIMARY KEY (id)
);
INSERT INTO gallery VALUES (5,'L. R. Gilliam','901','123-4456','0.37');
INSERT INTO gallery VALUES ( 6,'G. G. Waters','405','353-2243','0.45');
INSERT INTO gallery VALUES  (7,'T. E. gallery','480','353-2243','0.45');


CREATE TABLE painter (
    id INT(10) NOT NULL UNIQUE,
    last_name VARCHAR(15),
    first_name VARCHAR(15),
    areacode VARCHAR(3),
    phone VARCHAR(8),
    PRIMARY KEY (id)
);
INSERT INTO painter VALUES (123,'Ross','Georgette','901','885-4567');
INSERT INTO painter VALUES (126,'Itero','Julio','901','346-1112');
INSERT INTO painter VALUES (125,'Notalent','Nora','928','346-1112');
INSERT INTO painter VALUES (127,'Geoff','George','615','221-4456');


CREATE TABLE painting (
    id INT(10) NOT NULL UNIQUE,
    title VARCHAR(35),
    price DECIMAL(16 , 4 ),
    painter_id INT(10),
    gallery_id INT(10),
    PRIMARY KEY (id),
    FOREIGN KEY (painter_id)
        REFERENCES painter (id),
    FOREIGN KEY (gallery_id)
        REFERENCES gallery (id)
);
INSERT INTO painting VALUES ('1338','Dawn Thunder','245.5',123,5);
INSERT INTO painting VALUES ('1339','A Faded Rose','6723',123,5);
INSERT INTO painting VALUES ('1340','The Founders','567.99',126,5);
INSERT INTO painting VALUES ('1341','Hasty Pudding Exit','145.5',123,6);
INSERT INTO painting VALUES ('1342','Plastic Paradise','8328.99',126,6);
INSERT INTO painting VALUES ('1343','Roamin''','785',127,6);
INSERT INTO painting VALUES ('1344','Wild Waters','999',127,5);
INSERT INTO painting VALUES ('1345','Stuff ''n Such ''n Some','9800',123,5);


-- convenient view
-- notice: ambiguous attributes in the SELECT need to be qualified (as well as in the join, of course)
CREATE VIEW art AS
( SELECT 
    painter.id AS 'painter_id', last_name, first_name, painting.id AS 'painting_id', title, price, gallery.id AS 'gallery_id'
FROM
    gallery
        INNER JOIN
    painting ON gallery.id = painting.gallery_id
        INNER JOIN
    painter ON painter.id = painting.painter_id
);

SELECT *
FROM art;

SELECT 
    painter.id AS 'painter_id', last_name, first_name, painting.id AS 'painting_id', title, price
FROM
    painting
        RIGHT OUTER JOIN
    painter ON painter.id = painting.painter_id
;