
all: test

install:
	@mvn install

run:
	@mvn spring-boot:run

test:
	@mvn test

clean:
	@mvn clean

.PHONY: install run clean

