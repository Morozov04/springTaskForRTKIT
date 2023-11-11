INSERT INTO t_subject (id, subject_name)
     VALUES (1, 'physics'),
            (2, 'mathematics'),
            (3, 'russian language'),
            (4, 'literature'),
            (5, 'geometry'),
            (6, 'informatics');

INSERT INTO t_plan (id, plan_name)
     VALUES (1, 'standard');

INSERT INTO t_subjects_plan (id_plan, id_subject)
     VALUES (1, 1),
            (1, 2),
            (1, 3),
            (1, 4),
            (1, 5),
            (1, 6);

INSERT INTO t_groups (id, group_name, id_plan)
     VALUES (1, '1', 1),
            (2, '2', 1),
            (3, '3', 1),
            (4, '4', 1),
            (5, '5', 1),
            (6, '6', 1),
            (7, '7', 1),
            (8, '8', 1),
            (9, '9', 1),
            (10, '10', 1),
            (11, '11', 1),
            (12, '12', 1);