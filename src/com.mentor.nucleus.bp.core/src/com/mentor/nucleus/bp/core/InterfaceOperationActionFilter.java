package com.mentor.nucleus.bp.core;
//====================================================================
//
// File:      com.mentor.nucleus.bp.core.InterfaceOperationActionFilter.java
//
// WARNING: Do not edit this generated file
// Generated by ../MC-Java/java.arc, $Revision: 1.111 $
//
// (c) Copyright 2005-2014 by Mentor Graphics Corp.  All rights reserved.
//
//====================================================================
import org.eclipse.ui.IActionFilter;
import com.mentor.nucleus.bp.core.InterfaceOperation_c;

public class InterfaceOperationActionFilter implements IActionFilter {
	private static InterfaceOperationActionFilter singleton;

	public static InterfaceOperationActionFilter getSingleton() {
		if (singleton == null)
			singleton = new InterfaceOperationActionFilter();
		return singleton;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.ui.IActionFilter#testAttribute(java.lang.Object, java.lang.String, java.lang.String)
	 */
	public boolean testAttribute(Object target, String name, String value) {
		InterfaceOperation_c x = (InterfaceOperation_c) target;
		return x.Actionfilter(name, value);
	}

}
