all: clean build docker

clean:
	gradle clean

build:
	gradle build

docker:
	docker build --tag spring-boot .

run:
	docker run -it -p8080:8080 spring-boot
