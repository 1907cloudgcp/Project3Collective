#!/usr/bin/env bash
#cd Pet-insurance-Angular/
#npm install
#npm run build
#cd ../
#rm -r node_modules
#gsutil cp -r dist gs://www.alexandernkingsburyprojects.com/Pet-insurance-Angular

# move into the spring code folder
cd RevaturePetInsurance/
# compiles the code
mvn package
# move back out of the folder
cd ../

#go into the folder
cd Pet-insurance-Angular/
#sometimes npm doesn't work unless it is freshly installed
npm install
#run the anglar
npm run build
#put the contents of the anglar into the bucket
gsutil cp -r dist/class-example/* gs://www.alexandernkingsburyprojects.com
