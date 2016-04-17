@ECHO OFF

SET WD=%CD%
SET SD=%~dp0
SET PARAMS=%*

cd "%SD%"

call mvn release:clean release:prepare -Prelease %PARAMS%
call mvn release:perform -Prelease %PARAMS%

cd "%WD%"

PAUSE
