CREATE TABLE users (
    id SERIAL PRIMARY KEY,
    login TEXT NOT NULL UNIQUE,
    password TEXT NOT NULL,
    role TEXT NOT NULL
);

CREATE TABLE personal_collection (
    user_id INTEGER NOT NULL,
    book_id INTEGER NOT NULL,
    PRIMARY KEY (user_id, book_id),
    FOREIGN KEY (user_id) REFERENCES users(id)
);
