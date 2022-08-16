CREATE TABLE Orders
(
    id UUID NOT NULL DEFAULT uuid_generate_v4() PRIMARY KEY ,
    name CHARACTER VARYING(180),
    adress CHARACTER VARYING(254),
    contents jsonb

);


drop table Orders

select * from Orders