package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.MovingButton;

public class ButtonClickHandler implements ActionListener {
	@Override
	public void actionPerformed(ActionEvent event) {
		MovingButton.config.checkState(Integer.valueOf(event.getActionCommand()));
	}
}
