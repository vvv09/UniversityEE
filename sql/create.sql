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
    lecture_id serial NOT NULL,
    subject_id integer NOT NULL,
    group_id integer NOT NULL,
    teacher_id integer NOT NULL,
    classroom_id integer NOT NULL,

    CONSTRAINT unq_lectures_lecture_id UNIQUE (lecture_id),
    PRIMARY KEY (subject_id, group_id, teacher_id, classroom_id),

    FOREIGN KEY (subject_id) REFERENCES subjects (subject_id) ON DELETE CASCADE,
    FOREIGN KEY (group_id) REFERENCES groups (group_id) ON DELETE CASCADE,
    FOREIGN KEY (teacher_id) REFERENCES teachers (teacher_id) ON DELETE CASCADE,
    FOREIGN KEY (classroom_id) REFERENCES classrooms (classroom_id) ON DELETE CASCADE
);

CREATE TABLE public.lectures_sets
(
    lectures_set_id serial NOT NULL,
    name varchar(10) NOT NULL,

    PRIMARY KEY (lectures_set_id)
);

CREATE TABLE public.lectures_sets_lectures
(
    lectures_set_id integer NOT NULL,
    lecture_id integer NOT NULL,

    PRIMARY KEY (lectures_set_id, Lecture_id),
    FOREIGN KEY (lectures_set_id) REFERENCES lectures_sets(lectures_set_id) ON DELETE RESTRICT,
    FOREIGN KEY (lecture_id) REFERENCES lectures(lecture_id) ON DELETE RESTRICT
);

CREATE TABLE public.parity
(
    parity_id serial NOT NULL,
    name varchar(10),

    --CONSTRAINT pk_parity_parity_id
    PRIMARY KEY (parity_id)
);

CREATE TABLE public.day_of_week
(
    day_of_week_id serial NOT NULL,
    name varchar(15),

    --CONSTRAINT pk_day_of_week_day_of_week_id
    PRIMARY KEY (day_of_week_id)
);

CREATE TABLE public.lessons
(
    lesson_id serial NOT NULL,
    name varchar(10),

    --CONSTRAINT pk_lessons_lesson_id
    PRIMARY KEY (lesson_id)

);

CREATE TABLE public.schedule
(
    day_of_week_id integer NOT NULL,
    parity_id integer NOT NULL,
    lesson_id integer NOT NULL,
    lecture_set_id integer NOT NULL,

    --CONSTRAINT pk_schedule_schedule_id
    PRIMARY KEY (day_of_week_id, parity_id, lesson_id),

    FOREIGN KEY (day_of_week_id) REFERENCES day_of_week (day_of_week_id) ON DELETE RESTRICT,
    FOREIGN KEY (parity_id) REFERENCES parity (parity_id) ON DELETE RESTRICT,
    FOREIGN KEY (lesson_id) REFERENCES lessons (lesson_id) ON DELETE RESTRICT,
    FOREIGN KEY (lecture_set_id) REFERENCES lectures_sets (lectures_set_id) ON DELETE RESTRICT
);
