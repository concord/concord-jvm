#!/bin/bash --login

#set -ex
set -e

current=$(pwd)
git_root=$(git rev-parse --show-toplevel)
work_dir=$(mktemp -d)

cd $git_root
rm -rf concord_java/target
rm -rf rawapi/target
sbt package make-pom

cd $work_dir
echo "Working directory: $work_dir"
for f in $(find $git_root -iname "*.jar" -o -iname "*.pom"); do
    cp $f $work_dir
done
rm root*
ls ./*.jar
for f in $(ls ./*.jar); do
    # must contain matching .pom file
    filename=$(basename "$f")
    pomxml="${filename%.*}.pom"
    echo $pomxml
    if [ ! -f $pomxml ]; then
        echo "Error: Matching .pom file does not exist for $f"
        exit 1
    fi
    echo "Sending $pomxml with $f to repo@conjars.org"
    scp $pomxml $f repo@conjars.org:
done
cd $current
rm -r $work_dir
