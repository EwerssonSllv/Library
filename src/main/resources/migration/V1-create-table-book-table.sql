CREATE TABLE book (
    id TEXT PRIMARY KEY UNIQUE NOT NULL,
    title TEXT NOT NULL,
    author TEXT NOT NULL,
    description TEXT NOT NULL,
    image TEXT NOT NULL,
    gender TEXT NOT NULL,
    releaseyear TEXT NOT NULL
);