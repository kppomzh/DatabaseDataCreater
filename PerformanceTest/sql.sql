create foreign TABLE public.pgbench_history (
    tid integer primary key,
    bid integer ,
    aid integer ,
    delta integer ,
    mtime timestamp ,
    filler char(22));