#!/bin/sh
# This File Shouldn't be in the same directory of the Simulator
# Change These For Directory Project Is In And The Project Name
DirectoryName=Simulator
ProjectName=PA02

#Compress File
echo "\n    Starting Cleaning...  \n"
cd $DirectoryName
make -f $ProjectName-MF.m clean || echo "\n                     Cleaning Failed                 \n"
rm -f @config.cnf
rm -f @metadata.mdf
echo "\n    Cleaning Finished!  \n"


echo "\n    Starting Compression...  \n"
cd ../
tar -zcvf $DirectoryName.tar.gz $DirectoryName || exit 0
echo "\n    Compression Finished!  \n"

exit 0