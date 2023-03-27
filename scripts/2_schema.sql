CREATE TYPE music_genre AS ENUM ('Pop','Rock', 'EDM', 'Country', 'Dance');

CREATE TABLE songs (
     id SERIAL PRIMARY KEY,
     name VARCHAR (255) NOT NULL,
     genre music_genre NOT NULL,
     author VARCHAR (255) NOT NULL,
     release_year INTEGER CHECK (release_year > 0),
     singer VARCHAR (255) NOT NULL,
     vote INTEGER CHECK (vote >= 0) DEFAULT 0,
     lyric TEXT,
     album_id INTEGER NOT NULL,
     file_id INTEGER NOT NULL,
     create_at DATE DEFAULT CURRENT_DATE,
     update_at DATE GENERATED ALWAYS AS (create_at) STORED,
     create_by VARCHAR (100) NOT NULL,
     update_by VARCHAR (100) GENERATED ALWAYS AS (create_by) STORED
 );

  CREATE TABLE playlists (
     id SERIAL PRIMARY KEY,
     name VARCHAR (255) NOT NULL,
     username VARCHAR (255) NOT NULL,
     create_at DATE DEFAULT CURRENT_DATE,
     update_at DATE GENERATED ALWAYS AS (create_at) STORED,
     create_by VARCHAR (100) NOT NULL,
     update_by VARCHAR (100) GENERATED ALWAYS AS (create_by) STORED
 );

 CREATE TABLE albums (
     id SERIAL PRIMARY KEY,
     name VARCHAR(255) NOT NULL,
     author VARCHAR(255) NOT NULL,
     description VARCHAR,
     create_at DATE DEFAULT CURRENT_DATE,
     update_at DATE GENERATED ALWAYS AS (create_at) STORED,
     create_by VARCHAR (100) NOT NULL,
     update_by VARCHAR (100) GENERATED ALWAYS AS (create_by) STORED
 );

 CREATE TABLE files (
     id SERIAL PRIMARY KEY,
     name VARCHAR (255) NOT NULL,
     type VARCHAR (255) NOT NULL,
     raw_data BYTEA,
     create_at DATE DEFAULT CURRENT_DATE,
     update_at DATE GENERATED ALWAYS AS (create_at) STORED,
     create_by VARCHAR (100) NOT NULL,
     update_by VARCHAR (100) GENERATED ALWAYS AS (create_by) STORED
 );

ALTER TABLE songs
ADD CONSTRAINT fk_songs_files
FOREIGN KEY (file_id)
REFERENCES files (id);

ALTER TABLE songs
ADD CONSTRAINT fk_songs_albums
FOREIGN KEY (album_id)
REFERENCES albums (id);

 CREATE TABLE songs_playlists (
     song_id INTEGER REFERENCES songs(id),
     playlist_id INTEGER REFERENCES playlists(id),
     PRIMARY KEY (song_id, playlist_id)
 );