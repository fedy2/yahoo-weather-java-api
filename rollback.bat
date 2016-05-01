@ECHO OFF

SET WD=%CD%
SET SD=%~dp0
SET PARAMS=%*

cd "%SD%"

call mvn release:rollback -Prelease %PARAMS%

cd "%WD%"

PAUSE
