

ALTER TABLE ONLY mtsbank.bank_user
    ADD CONSTRAINT bank_user_pkey PRIMARY KEY (id);

ALTER TABLE ONLY mtsbank.contribution_contribution_type
    ADD CONSTRAINT contribution_contribution_type_pkey PRIMARY KEY (id_contribution);


ALTER TABLE ONLY mtsbank.bank_operation
    ADD CONSTRAINT fk5qfduok45x8vdw78cro32kfx6 FOREIGN KEY (bank_account) REFERENCES mtsbank.bank_account(id);


ALTER TABLE ONLY mtsbank.bank_user
    ADD CONSTRAINT fkk8bqfnu39o2oi8wiiocbmbo2o FOREIGN KEY (bank_account_id) REFERENCES mtsbank.bank_account(id);


ALTER TABLE ONLY mtsbank.bank_contribution
    ADD CONSTRAINT fkmhw4f1utd4xxxjqh1m14rn6ev FOREIGN KEY (bank_user) REFERENCES mtsbank.bank_user(id);


ALTER TABLE ONLY mtsbank.contribution_contribution_type
    ADD CONSTRAINT fkspykq1mcd4algaf4jtals39aq FOREIGN KEY (id_contribution) REFERENCES mtsbank.bank_contribution(id);

ALTER TABLE ONLY mtsbank.contribution_contribution_type
    ADD CONSTRAINT fkt1mogtwm956lj3xhx8yxk9mvw FOREIGN KEY (id_contribution_type) REFERENCES mtsbank.contribution_type(id);

