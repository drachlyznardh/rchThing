
install:
	@mvn install

run:
	@mvn exec:java

clean:
	@mvn clean

.PHONY: install run clean

