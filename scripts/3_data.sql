CREATE TABLE songs(
       song_id SERIAL primary key,
       song_name varchar (255) not null,
       genre varchar (255) not null,
       author varchar (255) not null,
       release_year date not null,
       singer varchar (255) not null,
       vote int not null
);

 CREATE TABLE playlists(
     playlist_id SERIAL primary key,
     playlist_name varchar (255) not null,
     date_created date not null,
     song_id integer not null,
     foreign key (song_id)
     references songs (song_id)
 );

 CREATE TABLE albums(
     album_id SERIAL primary key,
     album_name varchar (255) not null,
     album_author varchar (255) not null,
     description varchar not null
 );