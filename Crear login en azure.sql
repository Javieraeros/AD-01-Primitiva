CREATE LOGIN prueba with password='pr23ueba234.'
--Cambiar a base de datos donde queremos crear el user
CREATE USER prueba FOR LOGIN prueba
GRANT EXECUTE, INSERT, UPDATE, DELETE, SELECT TO prueba