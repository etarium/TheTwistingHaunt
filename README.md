# TheTwistingHaunt
Codenamed The Twisting Haunt based off of the RPG concept we had, this project seeks to create a combat system meant to be implemented into a larger game system, with a text-based RPG game being the primary target.

Completed Tasks:

  -(Completed)Implement a battlesim where all entities are controlled by a player or players for testing the structure

  -(Completed)Implement a basic client to test the classes

  -(Completed)Implement consumable item objects to be used by entities capable of using them

  -(Completed)Implement "special attack" objects to be contained in a list inside entity

  -(Completed)Implement a "stupid" RNG ai to speed testing and enhance gameplay

  -(Completed)Implement equipable item list for entities to enhance stats ie. armor, weapons

  -(Completed)Implement an Player subclass of entity, implementing a unique PlayerADT
  
  -(Completed)Implement a basic DB to store masterlists


Current Goals:

  -<CONSTANT>Documentation, especially with commonly used interfacing methods
  
  -<WIP>Implement an advanced client to play a short game using the combat project
  
    -Subtasks:
  
      -Testing/Debugging
  
      -Map implentation
  
      -Usables can be used outside of combat
  
      -Save/Load game functional
  
      -Loading GameData from file to reduce DB connects and minimize loading time
      
      -Combat running through GUI
      
      -Triggers for combat upon room entry
      
      -GUI support for different hardware platforms
  
  
  
  


Future Iterations:

  -<COMBAT>Implement other subclasses of Entity ie. creature, undead, humaniod, etc

  -<COMBAT>Implement smarter ai specific to entity type and based off intelligence to give players a greater challenge

  -<COMBAT>Expanding Equipables to allow for dual-wielding, two-handed, and implementation of enitities with arms > 2

  -<GUI>Addition of character/entity artwork done in same style of GUI

  -<GUI>Option menu to change GUI theme (colors, window sizes, etc.)
  
  -<DB>Document store instead of relational model
  
  -<DB>Enhanced descriptions for /commands
  
  -<DB>/inspect triggers, e.g. "/inspect loose brick" to find Dusty Key or "/inspect chest" to launch combat with Chest Mimic
  
  -<LISTENER>Added commands, e.g. /open
  
  -<COMBAT>Modify stats based upon Equipables
  
  -<OVERALL>Battle mode that implements original Combat game
  
  -<DB>Automatic "Time when last updated" field, with purpose of only loading new game data when patches have been applied
  
  -<OVERALL>Implementation of non-Combat and environmental objects, (e.g. "Wooden Door", "Skull", "Puddle", "Well")
  
  
  
  
  -<OVERALL>Blackbox testing with intended audiences
  
  -<OVERALL>Structure follows MVC architecture more closely
  
  -<OVERALL>Further division of game into organizational categories/packages

  
