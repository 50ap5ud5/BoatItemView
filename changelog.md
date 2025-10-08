# Version 0.0.7

## Additions
- Added Ukrainian Translation (Thanks Mykytius)
## Changes
- Updated for 1.21.9+
- Both hands' held item will now be shown if each hand holds a different whitelisted item (E.g. Main Hand = `create:wrench` , Offhand = `minecraft:filled_map`)
- Both hands' held item will now be shown when one hand's entire namespace is whitelisted and the other hand's item is selectively whitelisted (E.g. Main Hand = `ad_astra:*` , Offhand = `minecraft:filled_map`)  
- Performance enhancement - held items will be hidden as per vanilla behaviour if the whitelist has no entries and the showHands config option is still set to TRUE