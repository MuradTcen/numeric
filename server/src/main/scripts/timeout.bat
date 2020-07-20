set /A t= %~1+1
echo "Sleeping for %~1 seconds…"
ping 127.0.0.1 -n %t% > nul
REM TIMEOUT /T %~1 /NOBREAK
REM Здесь два варианта либо через хак "ping 127.0.0.1 -n %t% > nul" либо "REM TIMEOUT /T %~1 /NOBREAK"
echo "Completed"
