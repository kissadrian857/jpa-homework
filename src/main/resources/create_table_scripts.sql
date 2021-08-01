create table author
(
	id serial not null,
	first_name character varying(255),
	last_name character varying(255),
	username character varying(255),
	 created_date date NOT NULL,
	last_modified_date date not null
)

create table blog_post
(
	id serial not null,
	title character varying(255),
	content character varying(255),
	category character varying(255),
	created_date date not null,
	last_modified_date date not null,
	published_date date not null
)