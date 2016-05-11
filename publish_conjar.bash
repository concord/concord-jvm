#!/bin/bash --login

set -e

ROOT=$(git rev-parse --show-toplevel)
PROJ_ROOT=$ROOT/client/jvm
CURRENT=$(pwd)
WORK_DIR=$(mktemp -d)

# Clean up, then package and create pom's
rm -rf $PROJ_ROOT/concord_java/target
rm -rf $PROJ_ROOT/concord_kafka_consumer/target
rm -rf $PROJ_ROOT/rawapi/target
cd $PROJ_ROOT
sbt package make-pom

# Copy all jars and pom (that don't start with root*) to work dir
find $PROJ_ROOT \( -iname "*.jar" -o -iname "*.pom" \) \
     -a ! -iname "root*" | xargs cp -t $WORK_DIR

# Iterate over each jar-pom tuple and send to conjars
echo $WORK_DIR
for f in $(ls $WORK_DIR/*.jar); do
    NAME=$(basename "$f")
    POM="${NAME%.*}.pom"
    if [ ! -f $WORK_DIR/$POM ]; then
        echo "Error: Matching .pom file does not exist for $f"
        exit 1
    fi
    echo "Sending $POM with $f to repo@conjars.org"
    scp $WORK_DIR/$POM $f repo@conjars.org:
done

cd $CURRENT
rm -rf $WORK_DIR
