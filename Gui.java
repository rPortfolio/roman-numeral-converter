import javax.swing.*;
import java.awt.event.*;

class Gui {
	boolean toRoman = true;
	JTextField textField;
	
	public Gui() {
		JFrame frame = new JFrame("LibreRomanConverter++");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(256, 256);
		Box vbox = Box.createVerticalBox();
		Box hbox = Box.createHorizontalBox();
		JLabel output = new JLabel("Output Here");
		JLabel mode = new JLabel("Arabic to Roman");
		textField = new JTextField("Input Here", 16);
		textField.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent event) {
				output.setText(convert());
	    }
		});
		JButton swapButton = new JButton("↹");
		swapButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				toRoman = !toRoman;
				if (toRoman) {
					mode.setText("Arabic to Roman");
				} else {
					mode.setText("Roman to Arabic");
				}
			}
		});
		hbox.add(textField);
		hbox.add(output);
		vbox.add(hbox);
		vbox.add(mode);
		vbox.add(swapButton);
		frame.getContentPane().add(vbox);
		frame.setVisible(true);
	}

	private String convert() {
		if (toRoman) {
			try {
				return ArabToRoman.convert(Integer.parseInt(textField.getText()));
			} catch (NumberFormatException e) {
				return "Not a Valid Arabic Numeral";
			}
		} else {
			int arab = RomanToArab.convert(textField.getText());
			if (arab != -1) {
				return "" + arab;
			} else {
				return "Not a Valid Roman Numeral";
		}
	}
}
}