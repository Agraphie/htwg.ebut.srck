package de.htwg_konstanz.ebus.wholesaler.demo.util;

public class Constants {
	// XML schemata files
	public static final String XML_SCHEMA_BMECAT = "bmecat_new_catalog_1_2_simple_eps_V0.96.xsd";
	public static final String XML_SCHEMA_OPENTRANS = "openTRANS_1_0.xsd";

	public static final String ACTION_SHOW_ORDER_CUSTOMER_REQUEST_XML = "showOrderCustomerRequestXml";
	public static final String ACTION_SHOW_ORDER_CUSTOMER_RESPONSE_XML = "showOrderCustomerResponseXml";
	public static final String ACTION_SHOW_ORDER_PURCHASE_REQUEST_XML = "showOrderPurchaseRequestXml";
	public static final String ACTION_SHOW_ORDER_PURCHASE_RESPONSE_XML = "showOrderPurchaseResponseXml";

	public static final String ACTION_SHOW_ORDER_CUSTOMER_DETAIL = "showOrderCustomerDetail";
	public static final String ACTION_SHOW_ORDER_PURCHASE_DETAIL = "showOrderPurchaseDetail";

	public static final String ACTION_DELETE_ORDER_CUSTOMER = "deleteOrderCustomer";
	public static final String ACTION_DELETE_ORDER_PURCHASE = "deleteOrderPurchase";

	public static final String ACTION_SPLIT_CUSTOMER_ORDER = "splitCustomerOrder";
	public static final String ACTION_PURCHASE_ORDER = "purchaseOrder";

	public static final String ACTION_LOGIN = "login";
	public static final String ACTION_LOGOUT = "logout";

	public static final String ACTION_READ_WS_SETTINGS = "readWsSettings";
	public static final String ACTION_UPDATE_WS_SETTINGS = "updateWsSettings";

	public static final String PARAM_SUPPLIER = "supplier";
	public static final String PARAM_CUSTOMER = "customer";

	public static final String PARAM_SUPPLIER_ID = "supplierId";
	public static final String PARAM_CUSTOMER_ID = "customerId";

	public static final String PARAM_NAME_WS_USERNAME = "wsUsername";
	public static final String PARAM_NAME_WS_PASSWORD = "wsPassword";
	public static final String PARAM_NAME_WS_ENDPOINT_1 = "wsEndpoint1";
	public static final String PARAM_NAME_WS_ENDPOINT_2 = "wsEndpoint2";

	public static final String PARAM_NAME_USERNAME = "username";
	public static final String PARAM_NAME_PASSWD = "password";
	public static final String PARAM_NAME_ROLE = "role";

	public static final String ACTION_SHOW_ORDER_LIST = "showOrderList";
	public static final String PARAM_ORDER_CUSTOMER_LIST = "orderCustomerList";
	public static final String PARAM_ORDER_PURCHASE_LIST = "orderPurchaseList";

	public static final String PARAM_LOGIN_BEAN = "loginBean";
	public static final String PARAM_NAME_ORDER_ID = "orderId";
	public static final String PARAM_ORDER = "order";
	public static final String PARAM_ORDER_ITEM_LIST = "itemList";

	public static final String PARAM_NAME_MATERIAL_NUMBER = "materialNumber";
	public static final String PARAM_NAME_ORDER_NUMBER = "orderNumber";

	public static final String PARAM_NAME_ORDER_CUSTOMER = "orderCustomer";
	public static final String PARAM_NAME_ORDER_PURCHASE = "orderPurchase";

	public static final String PARAM_XML_TEXT = "xmlText";
	public static final String PARAM_NAME_ACTION = "action";
	public static final String PARAM_ERROR_LIST = "errorList";

	public static final int USER_INTERNAL = 1;
	public static final int USER_CUSTOMER = 2;
	public static final int USER_SUPPLIER = 3;

	// new constants
	
	//importAction
	public static final String ACTION_HANDLER_IMPORT_SUPPLIER_PRODUCTS = "importSupplierProductsHandler";
	public static final String ACTION_IMPORT_SUPPLIER_PRODUCTS = "importSupplierProducts";
	
	public static final String ACTION_EXPORT_CUSTOMER_PRODUCTS = "exportCustomerProducts";
	
	public static final String ARTICLE = "ARTICLE";
	//childnodes of article
	public static final String ARTICLE_SUPPLIER_AID = "SUPPLIER_AID";
	public static final String ARTICLE_ARTICLE_DETAILS = "ARTICLE_DETAILS";
	public static final String ARTICLE_ARTICLE_ORDER_DETAILS = "ARTICLE_ORDER_DETAILS";
	public static final String ARTICLE_ARTICLE_PRICE_DETAILS = "ARTICLE_PRICE_DETAILS";
	public static final String ARTICLE_ARTICLE_REFERENCE = "ARTICLE_REFERENCE";
	
	//childnodes  of ARTICLE_CHILD_ARTICLE_DETAILS
	public static final String ARTICLE_ARTICLE_DETAILS_DESCRIPTION_SHORT = "DESCRIPTION_SHORT";
	public static final String ARTICLE_ARTICLE_DETAILS_DESCRIPTION_LONG = "DESCRIPTION_LONG";
	public static final String ARTICLE_ARTICLE_DETAILS_EAN = "EAN";
	
	//childnodes of ARTICLE_ORDER_DETAILS
	public static final String ARTICLE_ARTICLE_ORDER_DETAILS_ORDER_UNIT = "ORDER_UNIT";
	public static final String ARTICLE_ARTICLE_ORDER_DETAILS_NO_CU_PER_OUT = "NO_CU_PER_OU";
	
	//childnodes of ARTICLE_PRICE_DETAILS
	public static final String ARTICLE_ARTICLE_PRICE_DETAILS_ARTICLE_PRICE = "ARTICLE_PRICE";
	//childnodes of ARTICLE_PRICE
	public static final String ARTICLE_ARTICLE_PRICE_DETAILS_ARTICLE_PRICE_PRICE_AMOUNT = "PRICE_AMOUNT";
	public static final String ARTICLE_ARTICLE_PRICE_DETAILS_ARTICLE_PRICE_PRICE_CURRENCY = "PRICE_CURRENCY";
	public static final String ARTICLE_ARTICLE_PRICE_DETAILS_ARTICLE_PRICE_TAX = "TAX";
	public static final String ARTICLE_ARTICLE_PRICE_DETAILS_ARTICLE_PRICE_TERRITORY = "TERRITORY";
	//chilnodes of ARTICLE_REFERENCE
	public static final String ARTICLE_ARTICLE_REFERENCE_ART_ID_TO = "ART_ID_TO";






			
}
