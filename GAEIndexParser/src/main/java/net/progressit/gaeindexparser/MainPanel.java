package net.progressit.gaeindexparser;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.xml.bind.JAXBException;

import org.fife.ui.rsyntaxtextarea.RSyntaxTextArea;

import net.miginfocom.swing.MigLayout;
import net.progressit.gaeindexparser.model.DatastoreIndexes;

public class MainPanel extends JPanel{
	private static final long serialVersionUID = 1L;

	private RSyntaxTextArea taXml = new RSyntaxTextArea();
	private JScrollPane spXml = new JScrollPane(taXml);
	private RSyntaxTextArea taString = new RSyntaxTextArea();
	private JScrollPane spString = new JScrollPane(taString);
	private JButton btnXmlToString = new JButton("XML to String >>");
	private JButton btnStringToXml = new JButton("<< String to XML");
	public void init() {
		setLayout(new MigLayout("","[700::, grow, fill]20[700::, grow, fill]","[fill][800::, grow, fill][fill]"));
		
		add(new JLabel("Indexes XML"));
		add(new JLabel("Indexes Summary"), "wrap");
		add(spXml);
		add(spString, "wrap");
		add(btnXmlToString);
		add(btnStringToXml);
		
		taXml.setSyntaxEditingStyle(RSyntaxTextArea.SYNTAX_STYLE_XML);
		taXml.setSyntaxEditingStyle(RSyntaxTextArea.SYNTAX_STYLE_PROPERTIES_FILE);
		
		btnXmlToString.addActionListener( (e)->{
			try {
				DatastoreIndexes indexes = Parser.xmlToObject(taXml.getText());
				String str = Parser.objectToString(indexes);
				
				taString.setText(str);
			} catch (JAXBException e1) {
				throw new RuntimeException(e1);
			}
		} );
		
		btnStringToXml.addActionListener( (e)->{
			try {
				DatastoreIndexes indexes = Parser.stringToObject(taString.getText());
				String str = Parser.objectToXml(indexes);
				
				taXml.setText(str);
			} catch (JAXBException e1) {
				throw new RuntimeException(e1);
			}
		} );
	}
	
	
}
