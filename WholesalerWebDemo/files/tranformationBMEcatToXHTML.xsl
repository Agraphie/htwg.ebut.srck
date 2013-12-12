<?xml version="1.0"?>
<xsl:stylesheet version="2.0"  xmlns:xhtml="http://www.w3.org/1999/xhtml" xmlns="http://www.w3.org/1999/xhtml" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:xs="http://www.w3.org/2001/XMLSchema" exclude-result-prefixes="xhtml xsl xs">
<xsl:output method="xml" version="1.0" encoding="UTF-8" doctype-public="-//W3C//DTD XHTML 1.1//EN" doctype-system="http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd" indent="yes"/>

	<xsl:template match="/BMECAT">
		<html>
			<head>
				<title>Produktkatalog -  Nähmaschinen  &amp; Zubehör</title>
			</head>
			<body>
				<h1>Übersicht - Nähmaschinen  &amp; Zubehör</h1>
					<xsl:apply-templates select='HEADER/CATALOG'></xsl:apply-templates>
					<xsl:apply-templates select='HEADER/SUPPLIER'></xsl:apply-templates>
				<ol>
					<xsl:apply-templates select='T_NEW_CATALOG/ARTICLE'></xsl:apply-templates>
				</ol>
			</body>
		</html>
	</xsl:template>
	
	<xsl:template match="CATALOG">
			<xsl:apply-templates select='LANGUAGE'></xsl:apply-templates>
			<xsl:apply-templates select='CATALOG_ID'></xsl:apply-templates>
			<xsl:apply-templates select='CATALOG_VERSION'></xsl:apply-templates>
			<xsl:apply-templates select='CATALOG_NAME'></xsl:apply-templates>
	</xsl:template>
	
	<xsl:template match="SUPPLIER">
			<xsl:apply-templates select='SUPPLIER_NAME'></xsl:apply-templates>
	</xsl:template>
	
	<xsl:template match="LANGUAGE">
		<p>Language: <xsl:value-of select="."></xsl:value-of></p>
	</xsl:template>

	<xsl:template match="CATALOG_ID">
		<p>Catalog-ID: <xsl:value-of select="."></xsl:value-of></p>
	</xsl:template>
	
	<xsl:template match="CATALOG_VERSION">
		<p>Catalog-Version: <xsl:value-of select="."></xsl:value-of></p>
	</xsl:template>
	
	<xsl:template match="CATALOG_NAME">
		<p>Catalog-Name <xsl:value-of select="."></xsl:value-of></p>
	</xsl:template>
	
	<xsl:template match="SUPPLIER_NAME">
		<p>Supplier-Name: <xsl:value-of select="."></xsl:value-of></p>
	</xsl:template>

	<xsl:template match="ARTICLE">
		<li>
			<xsl:apply-templates select='SUPPLIER_AID'></xsl:apply-templates>
			<xsl:apply-templates select='ARTICLE_DETAILS'></xsl:apply-templates>
			<xsl:apply-templates select='ARTICLE_ORDER_DETAILS'></xsl:apply-templates>
			<xsl:apply-templates select='ARTICLE_PRICE_DETAILS'></xsl:apply-templates>			
		</li>
	</xsl:template>

	
	<xsl:template match="SUPPLIER_AID">
		<p>Supplier-AID: <xsl:value-of select="."></xsl:value-of></p>
	</xsl:template>
	
	<xsl:template match="ARTICLE_DETAILS">
			<xsl:apply-templates select='DESCRIPTION_SHORT'></xsl:apply-templates>
			<xsl:apply-templates select='DESCRIPTION_LONG'></xsl:apply-templates>
	</xsl:template>
	
	<xsl:template match="ARTICLE_ORDER_DETAILS">
			<xsl:apply-templates select='ORDER_UNIT'></xsl:apply-templates>
			<xsl:apply-templates select='NO_CU_PER_OU'></xsl:apply-templates>
	</xsl:template>
	
	<xsl:template match="ARTICLE_PRICE_DETAILS">
		<p>Preis(e):</p>
			<ul>
				<xsl:apply-templates select='ARTICLE_PRICE'></xsl:apply-templates>
			</ul>
	</xsl:template>	
	
	<xsl:template match="DESCRIPTION_SHORT">
		<p>Description-Short: <xsl:value-of select="."></xsl:value-of></p>
	</xsl:template>
	
	<xsl:template match="DESCRIPTION_LONG">
		<p>Description-Long: <xsl:value-of select="."></xsl:value-of></p>
	</xsl:template>
	
	<xsl:template match="ORDER_UNIT">
		<p>Order-Unit: <xsl:value-of select="."></xsl:value-of></p>
	</xsl:template>
	
	<xsl:template match="NO_CU_PER_OU">
		<p>No-cu-per-ou: <xsl:value-of select="."></xsl:value-of></p>
	</xsl:template>
	
	<xsl:template match="ARTICLE_PRICE">
		<li>
			<xsl:apply-templates select='PRICE_AMOUNT'></xsl:apply-templates>
			(<xsl:if test="@price_type != ''">Price-Type: <xsl:value-of select='@price_type'/> | </xsl:if>
			<xsl:apply-templates select='PRICE_CURRENCY'></xsl:apply-templates>
			<xsl:apply-templates select='TAX'></xsl:apply-templates>
			<xsl:apply-templates select='TERRITORY'></xsl:apply-templates>
		</li>
	</xsl:template>
	
	<xsl:template match="PRICE_AMOUNT">
		Price amount: <xsl:value-of select="."></xsl:value-of>
	</xsl:template>	
	
	<xsl:template match="PRICE_CURRENCY">
		Price currency: <xsl:value-of select="."></xsl:value-of> | 
	</xsl:template>	
	
	<xsl:template match="TAX">
		Tax: <xsl:value-of select="."></xsl:value-of> | 
	</xsl:template>	
	
	<xsl:template match="TERRITORY">
		Territory: <xsl:value-of select="."></xsl:value-of>)
	</xsl:template>


</xsl:stylesheet>
