# F3F4Perms

A Minecraft plugin that allows players to use F3+F4 to change their game mode with permissions.

## Features

- **F3+F4 Menu Access** - Players with permission can use the native Minecraft F3+F4 menu to change game modes
- **CMI Integration** - Automatic detection and integration with CMI for gamemode commands
- **LuckPerms Support** - Automatically updates F3+F4 permission when LuckPerms permissions change
- **Game Mode Logging** - Logs all gamemode changes per player in YAML format
- **Folia Compatible** - Full support for Folia servers
- **Configurable** - Toggle CMI integration via config.yml

## Requirements

- **Required**: [PacketEvents](https://github.com/retrooper/packetevents)
- **Optional**: [LuckPerms](https://github.com/LuckPerms/LuckPerms)
- **Optional**: [CMI](https://www.spigotmc.org/resources/cmi.3742/)

## Installation

1. Download the latest release
2. Place in your `plugins/` folder
3. Install PacketEvents if not already installed
4. Restart your server
5. Grant players the `f3f4perms.use` permission

## Permissions

- `f3f4perms.use` - Allows using F3+F4 to change game mode (default: op)
- `f3f4perms.admin` - Allows using admin commands like `/f3f4perms forceupdate` (default: op)

**Note**: Players also need permission to use the gamemode commands themselves (e.g., `/gamemode creative`)

## Commands

- `/f3f4perms forceupdate` - Force update F3+F4 permission for all online players
- Aliases: `/f3f4`

## Configuration

```yaml
# F3F4Perms Configuration

# CMI Integration
# If enabled and CMI is installed, will use CMI's gamemode change system
# If disabled, will use vanilla /gamemode command
useCMI: true
```

## Logging

All gamemode changes are logged in `plugins/F3F4Perms/logs/<player-uuid>.yml`:

```yaml
- timestamp: '2025-12-28 15:30:45'
  player: 'Steve'
  uuid: '123e4567-e89b-12d3-a456-426614174000'
  from: 'survival'
  to: 'creative'
```

## Building

```bash
./gradlew build
```

The compiled JAR will be in `build/libs/`

## Credits

- [F3NPerm](https://github.com/SlimeNexus/F3NPerm) for the original idea and code under MIT license
- Author: Z3r0x