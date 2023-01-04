#/bin/bash
count=0
url=http://localhost:9080/$1/hello
while :
do
  echo -ne "request #$((count=$count+1)): $(curl --silent --show-error --fail $url)\033[0K\r"
done