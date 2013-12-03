package de.htwg_konstanz.ebus.wholesaler.main;

import java.util.Collection;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import de.htwg_konstanz.ebus.wholesaler.demo.LoginBean;

public class Exporter {
	
	private Document doc;
	private Collection<?> products;
	private LoginBean loginBean;
	
	
	public Exporter(LoginBean loginBean){
		init(loginBean);
	}

	private void init(LoginBean loginBean) {
		this.loginBean = loginBean;

		try {
			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
			doc = docBuilder.newDocument();
		} catch (ParserConfigurationException pce) {
			pce.printStackTrace();
		}
		
	}

	public void startExport() {
		Element root = createRootElement();
		Element header = createHeader();
		Element tNewCatalog = createTNewCatalog();
		
		root.appendChild(header);
		root.appendChild(tNewCatalog);
	}

	private Element createRootElement() {
		Element root = doc.createElement("BMECAT");
		root.setAttribute("version", "1.2");
		//FIXME Bin mir nicht sicher ob man die Attribute braucht
		root.setAttribute("xmlns:xsi","http://www.w3.org/2001/XMLSchema-instance");
		root.setAttribute("xsi:noNamespaceSchemaLocation", "bmecat_new_catalog_1_2_simple_V0.96.xsd");
		return root;
	}

	private Element createTNewCatalog() {
		//same shit here. über products iterieren und elemente etc erzeugen
		return null;		
	}

	private Element createHeader() {
		Element header = doc.createElement("HEADER");
		Element catalog = doc.createElement("CATALOG");
		Element supplier = doc.createElement("SUPPLIER");
		Element language = doc.createElement("LANGUAGE");
		Element catalogId = doc.createElement("CATALOG_ID");
		Element catalogVersion = doc.createElement("CATALOG_VERSION");
		Element catalogName = doc.createElement("CATALOG_NAME");
		Element supplierName = doc.createElement("SUPPLIER_NAME");

		header.appendChild(catalog);
		header.appendChild(supplier);
		
		catalog.appendChild(language);
		catalog.appendChild(catalogId);
		catalog.appendChild(catalogVersion);
		catalog.appendChild(catalogName);
		
		language.setTextContent("deu");
		catalogId.setTextContent("#cksr-coop");
		catalogVersion.setTextContent("1.0");
		catalogName.setTextContent("Aktuelle Produkte der CKSR Cooperation");
		
		supplierName.setTextContent(SupplierFinderUtil.supplierFinder(loginBean).getCompanyname());
		
		return header;
	}
	
}
