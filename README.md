# Pizza
Simple game engine for java programs
## **WARNING** 
A good enough knowledge in the java programming language is required in order to use and understand this package!!! If you DO NOT know java, and still want to use this, then you are a total dingus and need to learn java. If you DO know java, welcome to the github!
## Getting Started
**There are many great examples provided, but Intro and Game are the best to start with**
- The entire game engine can be started just by simply creating an instance of the `Pizza` class, e.g. `Pizza game = new Pizza();`
  - The background color of the window can be changed by inputting a color from the `java.awt.Color` class into the pizza contructor, e.g. `Pizza game = new Pizza(Color.BLUE);`
  - To run in fullscreen, just add a `true` to the end of the arguments in the constructor, e.g. `Pizza game = new Pizza(true)` or `Pizza game = new Pizza(Color.BLUE, true)`
- Items can be drawn onto the window by creating a new GameObject and by adding it to the handler
  - GameObject objects require an `update()` and `draw()` method
  - GameObjects can be created solo, like shown in Intro, or can be extended by another class, like shown in Game
  - In order for objects to be updated and drawn, they must be added to the game using `[yourgame].addObject(GameObject object);`
  - Don't forget to ask any questions that you may have in the discussions!
## Update: 9/14/2022
- The updating and drawing of the game are now both on separate Threads!!!
- The SpriteList class has been created, simplifying the use of sprites in the game!!!
- A simple Star Wars related shooter game has been added to showcase the new SpriteList
- `keyWASD()` has been added to GameObject, allowing for easier set up of the default movements
- The removing of objects by the Handler has been improved
- The Operator class can now wait for a realistic amount of time (miliseconds)
## Older Updates
**9/8/2022**
- `draw()` in GameObject has been updated so that a Graphics object does not need to be passed
- Methods like `fillRect()` have been added to GameObject to simplify drawing
  - All examples have been updated accordingly
- The Graphics object is now statically accessable through `Pizza.getGraphicsObject`
- The Util class has been created
  - `generateBufferedImage()` takes a path as a String and returns a BufferedImage object associated with that path. (used for drawing images)

**9/6/2022**
- Updated collision algorithm
- Added another GameObject to Gravity.java to show improvements
- All data about a GameObject can now be drawn with the `displayData` method
- Updated Javadoc comments

**3/3/2022**
- Added Operators
  - Operators are similar to GameObjects except that they do not have a draw method. Operators can be used to run logic that isn't necessarily connected to one GameObject.
- Added `stop()` to `Pizza.java`
- Changed default tick speed to 1 (was 2)

**2/14/2022**
- Added impact methods (`impactable()` and `notImpactable()`)
  - Methods are implemented similar to `runGravity()` and `draggable()`

**2/8/2022**
- Window height and width can now be accessed statically
- Added `runGravity()` to GameObject
- Added `draggable()` to GameObject
- See Gravity for an example

**2/7/2022**
- Added `isReleased()` to `GameObject.java`
- Updated the delete function of the game handler
- Changed default tick speed to 2 (was 10)
- Added new constructors to `Pizza.java` to allow for fullscreen
