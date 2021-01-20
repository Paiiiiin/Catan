# Catan
Hot seat version of "Catan" board game, developed as web app

This game is being developed for 2-4 players, you can specify the numebr by yourself in the beginning of the game from the given range
Data is being saved every playe turn to the database, by the end of each turn you can stop the game and load the state from the database at a later date whenever you and your friends want!

Game consists of phases:
1. (/play) now you can specify the number of players
2. (/check) it is time for automated dice rolls. App will do it for you and then players will be sorted in order (12 -> 9 -> 7 -> 5), if any roll will be same as any other, game will do reroll
3. (/start) time for board initialization, fields are randomized, but numbers will always be the same
4. (/showmap) now you can see the map! It is time to build your cities and gather first resources. Order is 1, 2, 3, 4, 4, 3, 2, ,1
5. Gameloop is starting right now, it can be stopped in each player turn, or will stop automatically if someone win.
__________________________________________________
In each turn player can build something, trade with the others or with the bank and use 'card of development'. Resources are gathered automatically after every dice roll. Full game description will be provided at the end of development or when the game will become playable.
__________________________________________________
For now, most of basic funcionalities is implemented

To Do:
-roads
-cards of development
-victory points
-some other mechanica like 'thief'
____________________________________________________
Catan board game was originally developed by Klaus Teuber. It is really great and funny board game, if you haven't played or bought one, you should definitely do it ASAP!!!
