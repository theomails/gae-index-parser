package net.progressit.gaeindexparser.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import lombok.Data;

@XmlRootElement(name = "property")
@XmlType(propOrder = { "name", "direction" })
@XmlAccessorType(XmlAccessType.FIELD)
@Data
public class Property {
	@XmlAttribute
	private String name;
	@XmlAttribute
	private String direction;
}
