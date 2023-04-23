-- Creation datbase automation
SELECT 'CREATE DATABASE automation'
WHERE NOT EXISTS (SELECT FROM pg_database WHERE datname = 'automation')

-- Creation of automation launch table
CREATE TABLE IF NOT EXISTS automation_launch (
  automation_id SERIAL PRIMARY KEY,
  launch_status_failed INT NOT NULL,
  launch_status_broken INT NOT NULL,
  launch_status_passed INT NOT NULL,
  launch_status_skipped INT NOT NULL,
  launch_status_unknown INT NOT NULL,
  launch_time_duration INT NOT NULL,
  launch_time_min_duration INT NOT NULL,
  launch_time_max_duration INT NOT NULL,
  launch_time_sum_duration INT NOT NULL,
  launch_retries_retries INT NOT NULL,
  launch_retries_run INT NOT NULL,
);

-- Creation of automation suites table
CREATE TABLE IF NOT EXISTS automation_suites (
  suite_id SERIAL PRIMARY KEY,
  status varchar(250) NOT NULL,
  start_time varchar(250) NOT NULL,
  stop_time varchar(250) NOT NULL,
  duration_in_ms varchar(250) NOT NULL,
  parent_suite varchar(250) NULL,
  suite varchar(250) NOT NULL,
  sub_suite varchar(250) NULL,
  test_class varchar(250) NULL,
  test_method varchar(250) NULL,
  name varchar(250) NULL,
  description varchar(250) NULL
);
