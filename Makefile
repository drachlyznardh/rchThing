
all: test

install:
	@mvn install

run:
	@mvn exec:java

test:
	@mvn test

clean:
	@mvn clean

.PHONY: install run clean

