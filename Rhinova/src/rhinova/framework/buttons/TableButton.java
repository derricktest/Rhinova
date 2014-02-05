package rhinova.framework.buttons;

import java.awt.Image;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

import resoursource.ResourceLoader;



/**
 * @author Derrick
 * Button with added functionality, such as resizing icons
 *
 */
public class TableButton extends JButton {

	private static final long serialVersionUID = 1L;

	Image initialImage = null;

	public void setnItialImage(Image initialImage) {
		this.initialImage = initialImage;
	}

	public Image getInitialImage() {
		return this.initialImage;
	}


	public TableButton() {
		super();
		initComponent();
	}

	public TableButton(String text) {
		super(text);
		initComponent();
	}


	public void initComponent() {
		this.addComponentListener(new ComponentListener(){

			@Override
			public void componentHidden(ComponentEvent arg0) {
				// None
			}

			@Override
			public void componentMoved(ComponentEvent arg0) {
				// None
			}

			@Override
			public void componentResized(ComponentEvent arg0) {
				// None
				resizeIcon();
			}

			@Override
			public void componentShown(ComponentEvent arg0) {
				// None
			}});
	}


	/**
	 * Method to resize the JButton's icon according to the component size
	 */
	public void resizeIcon() {

		// get the old icon and check that it is not null
		ImageIcon oldIcon = (ImageIcon) this.getIcon();
		if (oldIcon == null) {
			return;
		}

		// get the old image and check that it is not null
		Image img = this.getInitialImage();
		if (img == null) {
			return;
		}
		// create a new image which is the old image rescaled
		if (getHeight() != 0 && getWidth() != 0) {
			Image newimg = img.getScaledInstance(getHeight(), getHeight(),  java.awt.Image.SCALE_SMOOTH ) ;  
			oldIcon.setImage(newimg);
		}
	}



	/* (non-Javadoc)
	 * @see javax.swing.AbstractButton#setIcon(javax.swing.Icon)
	 * Overriding this method to add the icon resize functionality to the component
	 */
	@Override
	public void setIcon(Icon defaultIcon) {
		super.setIcon(defaultIcon);
		Image img = ((ImageIcon)defaultIcon).getImage();
		if (img != null) {
			this.initialImage = img;
		}
	}



	

	/**
	 * Method to demonstrate the icon resizing
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		TableButton tableButton = new TableButton("hello");
		tableButton.setIcon(new ImageIcon(ResourceLoader.getIconPath("add.gif")));

		JFrame frm = new JFrame();
		frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frm.add(tableButton);
		frm.setSize(200,200);
		frm.setVisible(true);


	}


}
