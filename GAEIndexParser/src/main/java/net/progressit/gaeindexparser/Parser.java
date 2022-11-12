package net.progressit.gaeindexparser;

import java.io.StringReader;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import com.google.gson.Gson;

import net.progressit.gaeindexparser.model.DatastoreIndex;
import net.progressit.gaeindexparser.model.DatastoreIndexes;
import net.progressit.gaeindexparser.model.Property;

public class Parser {
	public static DatastoreIndexes xmlToObject(String xmlString) throws JAXBException {
		JAXBContext context = JAXBContext.newInstance(DatastoreIndexes.class);
		DatastoreIndexes indexes = (DatastoreIndexes) context.createUnmarshaller()
	      .unmarshal(new StringReader(xmlString));
		
		for(DatastoreIndex index:indexes.getIndexes()) {
			List<Property> properties = index.getProperties();
			properties.sort(new Comparator<Property>() {
				@Override
				public int compare(Property o1, Property o2) {
					return o1.toString().compareTo(o2.toString());
				}
			});
		}
		
		return indexes;
	}
	
	public static String objectToString(DatastoreIndexes object) {
		List<String> strings = new ArrayList<>();
		Gson g = new Gson();
		for(DatastoreIndex index:object.getIndexes()) {
			strings.add( g.toJson(index) );
		}
		Collections.sort(strings);
		
		String res = strings.stream().collect(Collectors.joining("\n"));
		return res;
	}
	
	public static DatastoreIndexes stringToObject(String sortedString) {
		
		List<String> strings = Arrays.asList(sortedString.split("\\n"));
		Gson g = new Gson();
		DatastoreIndexes indexes = new DatastoreIndexes();
		indexes.setIndexes(new ArrayList<>());
		for(String index: strings) {
			indexes.getIndexes().add( g.fromJson(index, DatastoreIndex.class) );
		}

		indexes.setAutoGenerate("true"); //TODO: Hardcoded
		return indexes;
	}
	
	public static String objectToXml(DatastoreIndexes object) throws JAXBException {
		JAXBContext context = JAXBContext.newInstance(DatastoreIndexes.class);
		StringWriter sw = new StringWriter();
		Marshaller m = context.createMarshaller();
		m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
		m.marshal(object, sw);
		
		return sw.toString();
	}
}
