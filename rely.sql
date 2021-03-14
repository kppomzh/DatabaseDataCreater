create table a
(
    id int
);

create table c
(
    aid  int foreign key references a (id),
    name varchar(4) foreign key references b (name),
);

create table b
(
    aid  int foreign key references a (id),
    name varchar(4)
);
