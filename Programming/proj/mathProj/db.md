CREATE TABLE public.formulas
(
    id bigint NOT NULL,
    polish text NOT NULL,
    params text NOT NULL,
    PRIMARY KEY (id)
);

ALTER TABLE IF EXISTS public.formulas
    OWNER to root;


insert into public.formulas (id, polish, params) values (1, '+ a b', 'a b');


select * from public.formulas;