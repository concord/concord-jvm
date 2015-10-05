#! /bin/bash --login
dir=$(dir)
echo "Directory: $dir"
path=()
for f in $(find $dir -iname "*.jar"); do
    path+=($f)
done

foo=$(IFS=: ; echo "${path[*]}")
echo "Hello world: $foo"
# exec java -jar getting-started-java-assembly-1.0.jar
