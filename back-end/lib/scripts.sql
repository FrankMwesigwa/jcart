SELECT * FROM BATCH

select * from user_sequences;

DROP SEQUENCE customer_id_seq
CREATE sequence customer_id_seq START WITH 1 INCREMENT BY 1 NOCACHE NOCYCLE; 
