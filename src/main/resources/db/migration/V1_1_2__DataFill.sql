INSERT INTO mtsbank.bank_account (id, sum)
VALUES
    (1, 1000),
    (2, 2000),
    (3, 3000);

INSERT INTO mtsbank.bank_user (id, password, username, bank_account_id)
VALUES
    (1, 'password1', 'user1', 1),
    (2, 'password2', 'user2', 2),
    (3, 'password3', 'user3', 3);