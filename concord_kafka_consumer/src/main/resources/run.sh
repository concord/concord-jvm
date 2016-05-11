#!/bin/bash
set -ex
dir=$(pwd)
jar_file=$(find $dir -iname "*assembly*.jar");
if [[ ! -f $jar_file ]]; then
    echo "Cannot find *-assembly-*.jar file file";
    exit 1
fi

declare -a java_args
addJava() { java_args=( "${java_args[@]}" "$1" ); }
addJava "-Djava.library.path=/usr/lib"
addJava "-XX:+UseConcMarkSweepGC -XX:+CMSParallelRemarkEnabled"
echo "Found java executable at: $jar_file"
exec java ${java_args[@]} -cp $jar_file $@
