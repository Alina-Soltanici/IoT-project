CREATE TABLE IF NOT EXISTS sensor_device(
id BIGINT PRIMARY KEY default nextval('device_sequence'),
sensor_name VARCHAR(255),
location VARCHAR(255)
);