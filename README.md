# Nickname

A plugin that lets you change the displayed name of a player and also hilight it with color.

## Commands

**/nickname**

- The command accepts one or two arguments

- One argument: **/nickname \<nickname\>**     - Changes your own name

- Two arguments: **/nickname \<nickname\> \<player\>**    - Changes the name of player 

## Configuration

NOTE: reload the server after making changes to the config file!

Everytime a new player joins the server an entry in the Nickname/nicknames.yml file gets generated like in this image:

![alt text](https://github.com/kfc-manager/Nickname/blob/main/Screenshot%202022-10-21%20at%2000.54.36.png?raw=true)

You can set the nickname of the player by changing the **Nickname** line of the player. The color can be set by changing the **Color** line. The following keys of colors are available:

- AQUA
- BLACK
- BLUE
- DARK_AQUA
- DARK_BLUE
- DARK_GRAY
- DARK_GREEN
- DARK_PURPLE
- DARK_RED
- GOLD
- GRAY
- GREEN
- LIGHT_PURPLE
- RED
- WHITE
- YELLOW

Make sure that there's no typo in the key, otherwise the color will be set to default, which is WHITE.

The UUID works as identifier for the plugin. It is recommended to **not** make changes to any other line besides the Nickname and Color line, since the plugin might not be able to identify the right player to apply his nickname. To change the nickname of a player the player must have joined the server once while the plugin was active, otherwise there is no entry in the nickname.yml file for said player.
