create table a3
(
    id int
);

create table a2
(
    aid  int foreign key references a3 (id),
    name varchar(4) foreign key references a1 (name)
);

create table a1
(
    aid  int foreign key references a3 (id),
    name varchar(4)
);
