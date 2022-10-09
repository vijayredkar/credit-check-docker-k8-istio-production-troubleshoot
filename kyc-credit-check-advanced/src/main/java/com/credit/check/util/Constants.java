package com.credit.check.util;

import java.util.HashMap;
import java.util.Map;

public class Constants {
		
	//--Errors section
	public static final String ERROR_MSG_KYC_CREDIT_CHECK_PROCESSING_OPER_FAILED = "error occurred when processing KYC credit check" ;
	public static final String ERROR_MSG_KYC_CREDIT_CHECK_MONGO_OPER_FAILED = "error occurred when processing KYC Mongo operation" ;
	public static final String ERROR_CODE_KYC_CREDIT_CHECK_PROCESSING = "KYC-CRD-CHK-10001" ;
	public static final String ERROR_TYPE_KYC_CREDIT_CHECK_PROCESSING = "KYC_CREDIT_CHECK" ;
	
	
	
	public static final Map<String, String> GLOBAL_STATIC_HEAP_STORAGE_MAP = new HashMap<String, String>() ;	
}
