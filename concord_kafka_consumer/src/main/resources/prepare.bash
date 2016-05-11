#!/bin/bash --login

dir=$(pwd)
jar_file="../../../target/concord_kafka_consumer-assembly-0.0.3.jar"
if [[ ! -f $jar_file ]]; then
    echo "Cannot find *-assembly-*.jar file file";
    exit 1
fi
build_dir=$dir/build
mkdir -p $build_dir
if [ -e $build_dir/$jar_file ]; then
    rm -rf $build_dir/*
fi
cp $jar_file $build_dir
cp $dir/*.json $build_dir
cp $dir/run.sh $build_dir
