CREATE TABLE t_subject (
    id bigserial not null,
    subject_name CHARACTER VARYING(30) CHECK(subject_name !='') UNIQUE NOT NULL,
    CONSTRAINT pk_subject_id PRIMARY KEY (id)
);

CREATE TABLE t_plan (
    id bigserial not null,
    plan_name CHARACTER VARYING(30) CHECK(plan_name !='') UNIQUE NOT NULL,
    CONSTRAINT pk_plan_id PRIMARY KEY (id)
);

CREATE TABLE t_subjects_plan (
    id_plan int8 NOT NULL,
    id_subject int8 NOT NULL,
    CONSTRAINT fk_subjects_plan_p_id FOREIGN KEY (id_plan) REFERENCES t_plan(id) ON DELETE CASCADE,
    CONSTRAINT fk_subjects_plan_s_id FOREIGN KEY (id_subject) REFERENCES t_subject(id),
    UNIQUE(id_plan, id_subject)
);

CREATE TABLE t_group (
    id bigserial not null,
    group_name CHARACTER VARYING(30) CHECK(group_name !='') NOT NULL,
    id_plan int8 NOT NULL,
    CONSTRAINT pk_groups_id PRIMARY KEY (id),
    CONSTRAINT fk_groups_id FOREIGN KEY (id_plan) REFERENCES t_plan(id) ON DELETE CASCADE,
    UNIQUE(group_name, id_plan)
);

CREATE TABLE t_student (
    id bigserial NOT NULL,
    last_name CHARACTER VARYING(30) CHECK(last_name !='') NOT NULL,
    first_name CHARACTER VARYING(30) CHECK(first_name !='') NOT NULL,
    age int4 CHECK(age > 4 AND age < 18) NOT NULL,
    id_group int8,
    CONSTRAINT pk_student_id PRIMARY KEY (id),
    CONSTRAINT fk_student_id FOREIGN KEY (id_group) REFERENCES t_group(id) ON DELETE SET NULL
);

CREATE TABLE t_assessment (
    id_student int8 NOT NULL,
    id_subject int8 NOT NULL,
    assessment int4 CHECK(assessment > 0 AND assessment < 6) NOT NULL,
    CONSTRAINT fk_assessment_std_id FOREIGN KEY (id_student) REFERENCES t_student(id) ON DELETE CASCADE,
    CONSTRAINT fk_assessment_sud_id FOREIGN KEY (id_subject) REFERENCES t_subject(id),
    UNIQUE(id_student, id_subject)
);