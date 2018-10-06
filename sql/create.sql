CREATE DATABASE foxuniversity ENCODING 'UTF8';

CREATE SCHEMA public;

CREATE TABLE public.subjects
(
   subject_id serial primary key,
   name character varying(70)
);

CREATE TABLE public.groups
(
   group_id serial primary key,
   name character varying(30)
);

CREATE TABLE public.students
(
   student_id serial primary key,
   first_name character varying(30),
   middle_name character varying(30),
   last_name character varying(30),
   group_id integer,
   FOREIGN KEY (group_id) REFERENCES groups (group_id) ON DELETE RESTRICT
);

CREATE TABLE public.teachers
(
   teacher_id serial primary key,
   first_name character varying(30),
   middle_name character varying(30),
   last_name character varying(30)
);


CREATE TABLE public.classrooms
(
   classroom_id serial primary key,
   name character varying(30)
);

CREATE TABLE public.lectures
(
   	subject_id integer NOT NULL,
   	group_id integer NOT NULL,
	teacher_id integer NOT NULL,
	classroom_id integer NOT NULL,

	PRIMARY KEY (subject_id, group_id, teacher_id, classroom_id),

	FOREIGN KEY (subject_id) REFERENCES subjects (subject_id) ON DELETE CASCADE,
   	FOREIGN KEY (group_id) REFERENCES groups (group_id) ON DELETE CASCADE,
	FOREIGN KEY (teacher_id) REFERENCES teachers (teacher_id) ON DELETE CASCADE,
	FOREIGN KEY (classroom_id) REFERENCES classrooms (classroom_id) ON DELETE CASCADE

);
