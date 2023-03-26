CREATE TABLE songs (
    id SERIAL PRIMARY KEY
    , `name` VARCHAR(255) NOT NULL
    , genre VARCHAR(255) NOT NULL -- enum type
    , author VARCHAR(255) NOT NULL
    , release_year DATE NOT NULL
    , singer VARCHAR(255) NOT NULL
    , vote INT NOT NULL
    , lyric TEXT NOT NULL

    , created_at
    , updated_at
    , created_by
    , updated_by
);

CREATE TABLE playlists (
    id SERIAL PRIMARY KEY
    , `name` VARCHAR(255) NOT NULL
    , username VARCHAR(255) NOT NULL

    , created_at
    , updated_at
    , created_by
    , updated_by
);

CREATE TABLE albums (
    id SERIAL PRIMARY KEY
    , `name` VARCHAR(255) NOT NULL
    , author VARCHAR(255) NOT NULL
    , `description` VARCHAR NOT NULL

    , created_at
    , updated_at
    , created_by
    , updated_by
);

CREATE TABLE files (
    id SERIAL PRIMARY KEY
    , `name` VARCHAR(255) NOT NULL
    , `type` VARCHAR(255) NOT NULL
    , raw_data -- how to store binary data (blob clob)

    , created_at
    , updated_at
    , created_by
    , updated_by
);

-- TODO
-- created_at: date, default now
-- updated_at: date, default created_at
-- created_by: string, hard-code 'xxx'
-- updated_by: string, default created_by

-- albums - songs: 1 - n
-- playlists - songs: m - n

-- data validation
