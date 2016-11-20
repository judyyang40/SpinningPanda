CP := "dist/*"

all: clean compile 

clean:
	rm -rf build/*
	rm -f dist/app.jar
	find . -name "*.class" -exec rm -rf {} \;

app: compile
	cd build ; jar -cvfe ../dist/app.jar IslandServer .

test: compile app
	java -cp $(CP):dist/app.jar api.IslandServer

compile: 
	javac -cp $(CP) \
	 -d build \
	src/*.java

run:
	echo Starting Service at:  http://localhost:8080
	java -cp build:$(CP) api.IslandServer

loadtest:
	echo Starting Load Test on localhost
	java -cp build:$(CP) RunLoadTest 5

docker-build: app
	docker build -t island .
	docker images

docker-clean:
	docker stop island
	docker rm island
	docker rmi island

docker-run:
	docker run --name island -td island
	docker ps

docker-run-host:
	docker run --name island -td --net=host island
	docker ps

docker-run-bridge:
	docker run --name island -td -p 80:8080 island
	docker ps

docker-network:
	docker network inspect host
	docker network inspect bridge

docker-stop:
	docker stop island
	docker rm island

docker-shell:
	docker exec -it island bash 
	
