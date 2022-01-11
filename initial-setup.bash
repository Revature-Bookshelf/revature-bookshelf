
cd revature-bookshelf-frontend
npm i
npm run build

cd ..

cd revature-bookshelf-backend

mvn package

cd ..

docker-compose build

docker-compose up