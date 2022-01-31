package pizza;

import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;

public class Mouse extends MouseAdapter {

  private static String mouseState = "";
  private static int x, y;
  private static boolean released = true;

  public Mouse() {
    //System.out.println("Mouse Object Made!");
  }

  @Override
  public void mouseClicked(MouseEvent e) {
    mouseState = "Clicked";
    released = true;
    x = e.getX();
    y = e.getY();
  }

  @Override
  public void mousePressed(MouseEvent e) {
    mouseState = "Pressed";
    released = false;
    x = e.getX();
    y = e.getY();
  }

  @Override
  public void mouseDragged(MouseEvent e) {
    mouseState = "Dragged";
    released = false;
    x = e.getX();
    y = e.getY();
  }

  @Override
  public void mouseReleased(MouseEvent e) {
    mouseState = "Released";
    released = true;
    x = e.getX();
    y = e.getY();
  }

  @Override
  public void mouseMoved(MouseEvent e) {
    mouseState = "Moved";
    x = e.getX();
    y = e.getY();
  }

  /**
   * Gets the current mouse state.
   * Possible states: "Clicked", "Pressed", "Dragged", "Released", "Moved"
   * @return String mouseState
   */
  public static String getMouseState() {
    return mouseState;
  }

  /**
   * @return int mouseX
   */
  public static int getX() {
    return x;
  }

  /**
   * @return int mouse y
   */
  public static int getY() {
    return y;
  }

  /**
   * Returns a boolean based on if the mouse is currently released
   * @return boolean released
   */
  public static boolean isReleased() {
    return released;
  }

}