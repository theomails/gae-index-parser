package net.progressit.gaeindexparser.model;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import lombok.Data;

@XmlRootElement(name = "datastore-indexes")
@XmlType(propOrder = { "autoGenerate", "indexes" })
@XmlAccessorType(XmlAccessType.FIELD)
@Data
public class DatastoreIndexes {
	
	@XmlAttribute
	private String autoGenerate;
	
	@XmlElement(name = "datastore-index")
	private List<DatastoreIndex> indexes;
}
