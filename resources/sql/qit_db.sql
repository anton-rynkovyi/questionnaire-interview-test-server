DROP TABLE IF EXISTS users CASCADE;
DROP TABLE IF EXISTS user_roles CASCADE;
DROP TABLE IF EXISTS user_details CASCADE;
DROP TABLE IF EXISTS user_bans CASCADE;
DROP TABLE IF EXISTS quizzes CASCADE;
DROP TABLE IF EXISTS questionnaires CASCADE;
DROP TABLE IF EXISTS interviews CASCADE;
DROP TABLE IF EXISTS tests CASCADE;
DROP TABLE IF EXISTS questions CASCADE;
DROP TABLE IF EXISTS answers_variants CASCADE;
DROP TABLE IF EXISTS answers CASCADE;
DROP TABLE IF EXISTS quizzes_users CASCADE;

DROP SEQUENCE IF EXISTS user_role_seq CASCADE;
DROP SEQUENCE IF EXISTS user_details_seq CASCADE;
DROP SEQUENCE IF EXISTS user_bans_seq CASCADE;
DROP SEQUENCE IF EXISTS quizzes_seq CASCADE;
DROP SEQUENCE IF EXISTS questionnaires_seq CASCADE;
DROP SEQUENCE IF EXISTS interviews_seq CASCADE;
DROP SEQUENCE IF EXISTS tests_seq CASCADE;
DROP SEQUENCE IF EXISTS questions_seq CASCADE;
DROP SEQUENCE IF EXISTS answers_variants_seq CASCADE;
DROP SEQUENCE IF EXISTS answers_seq CASCADE;


CREATE TABLE users(
  username   VARCHAR(100),
  password   VARCHAR(100) NOT NULL,
   enabled   BOOLEAN DEFAULT TRUE,
  PRIMARY KEY(username)
);

CREATE SEQUENCE user_role_seq;
CREATE TABLE user_roles(
  user_role_id   BIGINT NOT NULL DEFAULT nextval('user_role_seq'),
      username   VARCHAR(100),
          role   VARCHAR(30),
  PRIMARY KEY(user_role_id),
  FOREIGN KEY(username) REFERENCES users(username)
);

CREATE SEQUENCE user_details_seq;
CREATE TABLE user_details(
  user_details_id   BIGINT NOT NULL DEFAULT nextval('user_details_seq'),
         username   VARCHAR(100),
       first_name   VARCHAR(100),
        last_name   VARCHAR(100),
            email   VARCHAR(100) UNIQUE,
     phone_number	  VARCHAR(40) UNIQUE,
           gender   BOOLEAN,
      birth_date	  DATE,
  additional_info   TEXT,
  PRIMARY KEY(user_details_id),
  FOREIGN KEY(username) REFERENCES users(username)
);


CREATE SEQUENCE user_bans_seq;
CREATE TABLE user_bans(
           user_ban_id   BIGINT NOT NULL DEFAULT nextval('user_bans_seq'),
    ban_owner_username   VARCHAR(100),
  banned_user_username 	 VARCHAR(100),
            start_date   TIMESTAMP NOT NULL,
              end_date   TIMESTAMP,
  PRIMARY KEY(user_ban_id)
);


CREATE SEQUENCE quizzes_seq;
CREATE TABLE quizzes(
   quiz_id   BIGINT NOT NULL DEFAULT nextval('quizzes_seq'),
  username   VARCHAR(100),
     title   VARCHAR(300) NOT NULL,
     topic   VARCHAR(300) NOT NULL,
  PRIMARY KEY(quiz_id),
  FOREIGN KEY(username) REFERENCES users(username)
);


CREATE SEQUENCE questionnaires_seq;
CREATE TABLE questionnaires(
        quest_id   BIGINT NOT NULL DEFAULT nextval('questionnaires_seq'),
         quiz_id   BIGINT,
      start_date   TIMESTAMP NOT NULL,
        end_date   TIMESTAMP,
   answers_limit   INTEGER,
        password   VARCHAR(30),
            vote   BOOLEAN DEFAULT FALSE,
       anonymity   BOOLEAN DEFAULT FALSE,
  res_visibility   BOOLEAN DEFAULT FALSE,
  PRIMARY KEY(quest_id),
  FOREIGN KEY(quiz_id) REFERENCES quizzes(quiz_id)
);


CREATE SEQUENCE interviews_seq;
CREATE TABLE interviews(
    interview_id   BIGINT NOT NULL DEFAULT nextval('interviews_seq'),
         quiz_id   BIGINT,
   members_limit   INTEGER,
        password   VARCHAR(30),
  res_visibility   BOOLEAN DEFAULT FALSE,
  PRIMARY KEY(interview_id),
  FOREIGN KEY(quiz_id) REFERENCES quizzes(quiz_id)
);


CREATE SEQUENCE tests_seq;
CREATE TABLE tests(
  test_id   BIGINT NOT NULL DEFAULT nextval('tests_seq'),
  quiz_id   BIGINT,
  PRIMARY KEY(test_id),
  FOREIGN KEY(quiz_id) REFERENCES quizzes(quiz_id)
);


CREATE SEQUENCE questions_seq;
CREATE TABLE questions(
  question_id   BIGINT NOT NULL DEFAULT nextval('questions_seq'),
      quiz_id   BIGINT,
      summary   VARCHAR(100) NOT NULL,
     sequence   INTEGER NOT NULL,
  PRIMARY KEY(question_id),
  FOREIGN KEY(quiz_id) REFERENCES quizzes(quiz_id),
  CONSTRAINT sequence_more_than_zero_const CHECK(sequence < 0)
);


CREATE SEQUENCE answers_variants_seq;
CREATE TABLE answers_variants(
  answer_variant_id   BIGINT NOT NULL DEFAULT nextval('answers_variants_seq'),
        question_id   BIGINT,
             answer   VARCHAR(300) NOT NULL,
  PRIMARY KEY(answer_variant_id),
  FOREIGN KEY(question_id) REFERENCES questions(question_id)
);


CREATE SEQUENCE answers_seq;
CREATE TABLE answers(
            answer_id   BIGINT NOT NULL DEFAULT nextval('answers_seq'),
          question_id   BIGINT,
  respondent_username   VARCHAR(100),
               answer   TEXT NOT NULL,
  PRIMARY KEY(answer_id),
  FOREIGN KEY(question_id) REFERENCES questions(question_id)
);


CREATE TABLE quizzes_users(
  username   VARCHAR(100),
   quiz_id   BIGINT,
  FOREIGN KEY(username) REFERENCES users(username),
  FOREIGN KEY(quiz_id) REFERENCES quizzes(quiz_id)
);












































