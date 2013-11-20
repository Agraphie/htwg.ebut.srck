package de.htwg_konstanz.ebus.framework.wholesaler.vo.util;

import java.math.BigDecimal;
import java.math.RoundingMode;

import de.htwg_konstanz.ebus.framework.wholesaler.api.bo.IBOPrice;

public class PriceUtil
{
   public static BigDecimal calcGrossPrice(IBOPrice price)
   {
      return price.getAmount().multiply(price.getTaxrate()).setScale(2,RoundingMode.HALF_UP);   
   }
}
