# Welcome to SpigotSteve

### This is a Spigot Minecraft server plugin with a similar basic functionality to [Mega Randomizer](https://www.curseforge.com/minecraft/mc-mods/mega-randomizer), a Minecraft mod I made for Forge.

## Main functionality
SpigotSteve randomizes drops from blocks, mobs, and even players.
The basic way this works in code is:

- Storing a master list of all the game's available drop items.
- Making another list of the same items, but shuffling them into a random order based on the world seed.
- Listening for the drop event when a block is broken or a mob or player dies.
- Checking if that feature's game rule is turned on or off.
- Finding the index of each vanilla drop item in the master list.
- Replacing each vanilla drop item with the item at the same index in the shuffled list.

This project has been a fun way to learn the basics of Spigot plugin development. I hope to add more functionality and make more plugins soon!
