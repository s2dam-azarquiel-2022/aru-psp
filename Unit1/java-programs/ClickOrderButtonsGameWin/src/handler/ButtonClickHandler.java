package handler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.Window;

public class ButtonClickHandler implements ActionListener {
  @Override
  public void actionPerformed(ActionEvent event) {
    Window.shared.checkState(Integer.valueOf(event.getActionCommand()));
  }
}
