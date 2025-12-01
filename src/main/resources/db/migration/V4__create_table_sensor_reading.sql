--create table
CREATE TABLE IF NOT EXISTS sensor_reading(
id BIGINT PRIMARY KEY default nextval('sensor_reading_sequence'),
temperature DOUBLE PRECISION,
humidity DOUBLE PRECISION,
local_date_time TIMESTAMP,
device_id BIGINT,
FOREIGN KEY (device_id) REFERENCES sensor_device(id) ON DELETE CASCADE
);


