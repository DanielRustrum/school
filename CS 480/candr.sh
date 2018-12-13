#!/bin/sh
# This File Shouldn't be in the same directory of the Simulator
# Change These For Directory Project Is In And The Project Name
ProjectName=PA03
DirectoryName=Simulator

# Compile and Run
echo "Starting Compilation...\n\n\n\n\n"

cd $DirectoryName
make -f $ProjectName-MF.m clean || echo "\n                     Cleaning Failed                 \n"
make -f $ProjectName-MF.m || echo "\n\n\n\n                  Compilation Failed                        \n"
echo "\n      Compilation Completed      \n"

echo "\n     Running File...    \n\n\n\n\n"
./$ProjectName @config.cnf
echo "\n    File Completed    \n"

exit 0