

	    select count(*) from PPODM_TRACKED_ORDER WHERE PPODM_RECORD_UPDATE >= CONVERT(DATETIME,'18/JUN/2017')
       AND PPODM_RECORD_UPDATE <  CONVERT(DATETIME,'19/JUN/2017') 
	AND LAST_ORDER_STATUS != 'CONFIRMED' 
       AND LINE_ITEM_CODE is not null 
	ORDER BY PPODM_RECORD_UPDATE, CTL_ORDER_NUM, 
	    SALES_CODE, ORDER_TYPE, 
	    WTN, LINE_ITEM_CODE;
	  
	    
	    select * from PPODM_TRACKED_ORDER WHERE PPODM_RECORD_UPDATE >= CONVERT(DATETIME,'16/JUN/2017')
       AND PPODM_RECORD_UPDATE <  CONVERT(DATETIME,'19/JUN/2017') 
	AND LAST_ORDER_STATUS != 'CONFIRMED' 
       AND LINE_ITEM_CODE is not null 
	ORDER BY PPODM_RECORD_UPDATE, CTL_ORDER_NUM, 
	    SALES_CODE, ORDER_TYPE, 
	    WTN, LINE_ITEM_CODE;