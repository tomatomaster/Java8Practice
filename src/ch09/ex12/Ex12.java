package ch09.ex12;

import java.applet.Applet;
import java.awt.Button;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import ch09.ex11.Ex11;

public class Ex12 extends Applet implements ActionListener {

  private static final long serialVersionUID = 1L;
  private final Ex11 ex = new Ex11();

  @Override
  public void paint(Graphics g) {
    Button b = new Button("Start");
    b.addActionListener(this);
    add(b);
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    try {
      ex.writeCardInfo();
    } catch (IOException e1) {
      e1.printStackTrace();
    }
  }
}
