# Pizza
Simple game engine for java programs
## **WARNING** 
A good enough knowledge in the java programming language is required in order to use and understand this package!!! If you DO NOT know java, and still want to use this, then you are a total dingus and need to learn java. If you DO know java, welcome to the github bro!
## Getting Started
**Examples are provided in the Intro and Game directories**
- The entire game engine can be started just by simply creating an instance of the `Pizza` class, e.g. `Pizza game = new Pizza();`
  - The background color of the window can be changed by inputting a color from the `java.awt.Color` class into the pizza contructor, e.g. `Pizza game = new Pizza(Color.BLUE);`
- Items can be drawn onto the window by creating a new GameObject and by adding it to the handler
  - GameObject objects require an `update()` and `draw()` method
  - GameObjects can be created solo, like shown in Intro, or can be extended by another class, like shown in Game
  - In order for objects to be updated and drawn, they must be added to the game using `[yourgame].addObject(GameObject object);`
## Update: 2/7/2022
- Added `isReleased()` to `GameObject.java`
- Updated the delete function of the game handler
- Changed default tick speed to 2 (was 10)
- Added new constructors to `Pizza.java` to allow for fullscreen