all: clean build docker

clean:

build:

docker:
	docker build --tag docker-logging .

run:
	docker run -it --user root \
	           --volume /var/lib/docker/containers:/var/lib/docker/containers \
	           --volume /var/run/docker.sock:/var/run/docker.sock \
	           --network=stackdocker_stack \
	       docker-logging
