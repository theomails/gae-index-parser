package net.progressit.gaeindexparser.model;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import lombok.Data;

@XmlRootElement(name = "datastore-index")
@XmlType(propOrder = { "kind", "ancestor", "source", "properties" })
@XmlAccessorType(XmlAccessType.FIELD)
@Data
public class DatastoreIndex {
	
	@XmlAttribute
	private String kind;
	@XmlAttribute
	private String ancestor;
	@XmlAttribute
	private String source;
	@XmlElement(name = "property")
	private List<Property> properties; 
}
