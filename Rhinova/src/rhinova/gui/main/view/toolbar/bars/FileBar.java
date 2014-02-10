package rhinova.gui.main.view.toolbar.bars;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;


import rhinova.gui.main.view.toolbar.MainToolBarMenu;
import rhinova.metapopulation.model.components.dao.MetapopulationDao;


public class FileBar extends MainToolBarMenu {

	private static final long serialVersionUID = 1L;	

	MetapopulationDao dao;

	public void setDao(MetapopulationDao dao) {
		this.dao = dao;
	}
	
	public FileBar() {

		super("File");


		addNewAl(new FileOpenAction(), 		"Open");
		addNewAl(new FileSaveAsAction(), 	"Save as");
		addNewAl(new FileSaveAction(), 		"Save");
		addNewAl(new FileCloseAction(), 	"Close");
		addNewAl(new FileExitAction(), 		"Exit");

	}

	@Override
	public int getPlace() {
		return 0;
	}


	public class FileOpenAction implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {

			JFileChooser fc = null;
			try {
				fc = new JFileChooser(new File(dao.getLastFilePath()));
			} catch (Exception e) {
				fc = new JFileChooser();
			}
			int response = fc.showOpenDialog(null);
			if (response == 0)
			{
				try {
					dao.open(fc.getSelectedFile().getPath());
				} catch (NumberFormatException | IOException e) {
					JOptionPane.showMessageDialog(null, "Cannot find the specified file.", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		}
	}

	public class FileSaveAsAction implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {

			JFileChooser fc = new JFileChooser(new File(dao.getLastFilePath()));
			int response = fc.showSaveDialog(null);
			if (response == 0)
			{
				dao.save(fc.getSelectedFile().getPath());
			}
		}
	}
	
	public class FileSaveAction implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			dao.save(dao.getLastFilePath());
		}
		
	}
	
	
	public class FileExitAction implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO
		}
	}
	
	
	public class FileCloseAction implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			dao.close();
		}
		
	}



}
