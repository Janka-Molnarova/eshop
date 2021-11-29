CREATE TABLE items
(
    id         LONG         NOT NULL AUTO_INCREMENT,
    name       VARCHAR(128) NOT NULL,
    price      DOUBLE       NOT NULL,
    item_count INT          NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE orders
(
    id          LONG          NOT NULL AUTO_INCREMENT,
    order_id    VARCHAR(64)   NOT NULL,
    customer_id VARCHAR(64)   NOT NULL,
    items       VARCHAR(1024) NOT NULL,
    price       DOUBLE        NOT NULL,
    PRIMARY KEY (id)
)