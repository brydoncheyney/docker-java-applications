clean:
	mvn clean

build:
	mvn dependency:resolve package

docker:
	docker build --tag spark .

run:
	docker run -it -p4567:4567 spark
