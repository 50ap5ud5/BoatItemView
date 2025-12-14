# Version 0.0.8

## Changes
- **[All Mod Loaders]** Updated for Minecraft 1.21.11
- **[Fabric]** Moved config file name from the config folder to a dedicated "boatiview" folder. i.e. ".minecraft/config/client.toml" to ".minecraft/config/boatiview/client.toml"
- **[Fabric]** Removed dependency on Fabric API. This means if you do not wish to use Mod Menu (which requires Fabric API) to access its config GUI, you can do so with a simpler setup. Without Mod Menu, changes made to the config after the game has launched will not be applied until the game is closed and restarted.