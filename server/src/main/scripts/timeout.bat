echo "Sleeping for %~1 seconds…"
set /A t= %~1+1
ping 127.0.0.1 -n %t% > nul
echo "Completed"
