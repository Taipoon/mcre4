GRADLEW := ./gradlew


.PHONY: _req_* build run-client clean check

build: clean
	$(GRADLEW) build

check:
	$(GRADLEW) --no-daemon -q classes

clean:
	$(GRADLEW) clean --refresh-dependencies

run: build
	$(GRADLEW) runClient


.PHONY: create

ASSETS_DIR := src/main/resources/assets
ASSETS_TEMPLATES := src/main/templates/assets
ITEM_NAME ?=

create: _req_ITEM_NAME
	sed "s/###ITEM_NAME###/$(ITEM_NAME)/g" $(ASSETS_TEMPLATES)/mcre4_items.json > $(ASSETS_DIR)/mcre4/items/$(ITEM_NAME).json
	sed "s/###ITEM_NAME###/$(ITEM_NAME)/g" $(ASSETS_TEMPLATES)/mcre4_models_item.json > $(ASSETS_DIR)/mcre4/models/item/$(ITEM_NAME).json
	sed "s/###ITEM_NAME###/$(ITEM_NAME)/g" $(ASSETS_TEMPLATES)/mcre4_textures_item.mcmeta > $(ASSETS_DIR)/mcre4/textures/item/$(ITEM_NAME).png.mcmeta

_req_%:
	$(if $($*),,$(error variable required $*=xxx))
