@ECHO OFF

SET WD=%CD%
SET SD=%~dp0
SET PARAMS=%*

cd "%SD%"

call mvn clean install %PARAMS%

cd "%WD%"

PAUSE
