CREATE TYPE music_genre AS ENUM ('Pop','Rock', 'EDM', 'Country', 'Dance');

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
      image TEXT,
      album_id INTEGER NOT NULL,
      file_id INTEGER NOT NULL,
      meta_data JSON NOT NULL
 );

  CREATE TABLE playlists (
      id SERIAL PRIMARY KEY,
      name VARCHAR (255) NOT NULL,
      username VARCHAR (255) NOT NULL,
      meta_data JSON NOT NULL
 );

 CREATE TABLE albums (
      id SERIAL PRIMARY KEY,
      name VARCHAR(255) NOT NULL,
      author VARCHAR(255) NOT NULL,
      description VARCHAR,
      meta_data JSON NOT NULL
 );

 CREATE TABLE files (
      id SERIAL PRIMARY KEY,
      name VARCHAR (255) NOT NULL,
      type VARCHAR (255) NOT NULL,
      raw_data BYTEA,
      meta_data JSON NOT NULL
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
