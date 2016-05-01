@ECHO OFF

SET WD=%CD%
SET SD=%~dp0
SET PARAMS=%*

cd "%SD%"

call mvn clean deploy -Prelease %PARAMS%

cd "%WD%"
