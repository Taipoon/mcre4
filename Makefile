GRADLEW := ./gradlew


.PHONY: build run-client clean check

build: clean
	$(GRADLEW) build

check:
	$(GRADLEW) --no-daemon -q classes

clean:
	$(GRADLEW) clean --refresh-dependencies

run: build
	$(GRADLEW) runClient
