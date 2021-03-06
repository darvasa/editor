package com.mentor.nucleus.bp.core.sorter;

//======================================================================
//
//File: src/com/mentor/nucleus/bp/core/sorter/MetadataSortingManager.java
//
//WARNING:      Do not edit this generated file
//Generated by: arc/create_metadata_elements_sorters.arc; create_sortering_manager
//Version:      $Revision: 1.12.88.2 $
//
//(c) Copyright 2004-2014 by Mentor Graphics Corp.  All rights reserved.
//
//======================================================================

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import com.mentor.nucleus.bp.core.*;
import com.mentor.nucleus.bp.core.common.ModelElement;
import com.mentor.nucleus.bp.core.common.NonRootModelElement;

public class MetadataSortingManager {
	private Map sorterMap = new HashMap();
	private ISorterFactory defaultSorterFactory = null;

	public void setTypeSorter(Class type, ISorterFactory sorterFactory) {
		sorterMap.put(type, sorterFactory);
	}

	public void setDefaultTypeSorter(ISorterFactory sorterFactory) {
		defaultSorterFactory = sorterFactory;
	}

	public void sort(Object[] elements) {
		if (elements == null || elements.length <= 0) {
			return;
		}

		ISorterFactory sorterFactory = (ISorterFactory) sorterMap
				.get(elements[0].getClass());

		if (sorterFactory != null) {
			try {
				ISorter sorter = sorterFactory.createSorter(elements);
				sorter.sort(elements);
			} catch (SorterFactoryException e) {
				CorePlugin.logError("Could not create sorter",
						(Exception) e.getCause());
			}
		} else if (defaultSorterFactory != null) {
			try {
				ISorter sorter = defaultSorterFactory.createSorter(elements);
				if (sorter.canSort(elements)) {
					sorter.sort(elements);
				}
			} catch (SorterFactoryException e) {
				CorePlugin.logError("Could not create sorter",
						(Exception) e.getCause());
			}
		}
	}

	public static ISorterFactory createDefaultSorterFactory(String className) {
		return new DefaultSorterFactory(className);
	}

	public static MetadataSortingManager createDefault() {
		MetadataSortingManager sortingManager = new MetadataSortingManager();
		sortingManager
				.setTypeSorter(
						FunctionParameter_c.class,
						MetadataSortingManager
								.createDefaultSorterFactory("com.mentor.nucleus.bp.core.sorter.FunctionParameter_cSorter")); //$NON-NLS-1$
		sortingManager
				.setTypeSorter(
						Operation_c.class,
						MetadataSortingManager
								.createDefaultSorterFactory("com.mentor.nucleus.bp.core.sorter.Operation_cSorter")); //$NON-NLS-1$
		sortingManager
				.setTypeSorter(
						OperationParameter_c.class,
						MetadataSortingManager
								.createDefaultSorterFactory("com.mentor.nucleus.bp.core.sorter.OperationParameter_cSorter")); //$NON-NLS-1$
		sortingManager
				.setTypeSorter(
						StateMachineEventDataItem_c.class,
						MetadataSortingManager
								.createDefaultSorterFactory("com.mentor.nucleus.bp.core.sorter.StateMachineEventDataItem_cSorter")); //$NON-NLS-1$
		sortingManager
				.setTypeSorter(
						Attribute_c.class,
						MetadataSortingManager
								.createDefaultSorterFactory("com.mentor.nucleus.bp.core.sorter.Attribute_cSorter")); //$NON-NLS-1$
		sortingManager
				.setTypeSorter(
						Enumerator_c.class,
						MetadataSortingManager
								.createDefaultSorterFactory("com.mentor.nucleus.bp.core.sorter.Enumerator_cSorter")); //$NON-NLS-1$
		sortingManager
				.setTypeSorter(
						BridgeParameter_c.class,
						MetadataSortingManager
								.createDefaultSorterFactory("com.mentor.nucleus.bp.core.sorter.BridgeParameter_cSorter")); //$NON-NLS-1$
		sortingManager
				.setTypeSorter(
						InterfaceSignal_c.class,
						MetadataSortingManager
								.createDefaultSorterFactory("com.mentor.nucleus.bp.core.sorter.InterfaceSignal_cSorter")); //$NON-NLS-1$
		sortingManager
				.setTypeSorter(
						InterfaceOperation_c.class,
						MetadataSortingManager
								.createDefaultSorterFactory("com.mentor.nucleus.bp.core.sorter.InterfaceOperation_cSorter")); //$NON-NLS-1$
		sortingManager
				.setTypeSorter(
						PropertyParameter_c.class,
						MetadataSortingManager
								.createDefaultSorterFactory("com.mentor.nucleus.bp.core.sorter.PropertyParameter_cSorter")); //$NON-NLS-1$
		sortingManager
				.setTypeSorter(
						StructureMember_c.class,
						MetadataSortingManager
								.createDefaultSorterFactory("com.mentor.nucleus.bp.core.sorter.StructureMember_cSorter")); //$NON-NLS-1$

		return sortingManager;
	}

	public static interface ISorter {
		boolean canSort(Object[] elements);
		void sort(Object[] elements);
	}

	public static interface ISorterFactory {
		ISorter createSorter(Object[] elements) throws SorterFactoryException;
	}

	public static class SorterFactoryException extends Exception {
		public SorterFactoryException(String message, Throwable rootCause) {
			super(message, rootCause);
		}
	}

	static class DefaultSorterFactory implements ISorterFactory {
		Class sorterClass;
		List sorters = new Vector();

		DefaultSorterFactory(String className) {
			try {
				sorterClass = Class.forName(className);
				if (!ISorter.class.isAssignableFrom(sorterClass)) {
					throw new IllegalArgumentException(
							"Class not of type MetadataSortingManager.ISorter");
				}
			} catch (ClassNotFoundException e) {
				throw new IllegalArgumentException(
						"Could not create sorter class: " + e.getMessage());
			}
		}

		public ISorter createSorter(Object[] elements)
				throws SorterFactoryException {
			ISorter sorter = null;
			for (int i = 0; i < sorters.size(); i++) {
				sorter = (ISorter) sorters.get(i);
				if (sorter.canSort(elements)) {
					return sorter;
				}
			}

			try {
				sorter = (ISorter) sorterClass.newInstance();
				sorters.add(sorter);
				return sorter;
			} catch (InstantiationException e) {
				throw new SorterFactoryException("Could not create sorter", e);
			} catch (IllegalAccessException e) {
				throw new SorterFactoryException("Could not create sorter", e);
			}

		}

	}

	public static boolean isOrderedElement(Object element) {
		if (element.getClass() == FunctionParameter_c.class) {
			return true;
		}
		if (element.getClass() == Operation_c.class) {
			return true;
		}
		if (element.getClass() == OperationParameter_c.class) {
			return true;
		}
		if (element.getClass() == StateMachineEventDataItem_c.class) {
			return true;
		}
		if (element.getClass() == Attribute_c.class) {
			return true;
		}
		if (element.getClass() == Enumerator_c.class) {
			return true;
		}
		if (element.getClass() == BridgeParameter_c.class) {
			return true;
		}
		if (element.getClass() == InterfaceSignal_c.class) {
			return true;
		}
		if (element.getClass() == InterfaceOperation_c.class) {
			return true;
		}
		if (element.getClass() == PropertyParameter_c.class) {
			return true;
		}
		if (element.getClass() == StructureMember_c.class) {
			return true;
		}
		return false;
	}

	public static ModelElement getPreviousElement(NonRootModelElement next) {
		if (next.getClass() == FunctionParameter_c.class) {
			return FunctionParameter_c
					.getOneS_SPARMOnR54Succeeds((FunctionParameter_c) next);
		}
		if (next.getClass() == Operation_c.class) {
			return Operation_c.getOneO_TFROnR125Succeeds((Operation_c) next);
		}
		if (next.getClass() == OperationParameter_c.class) {
			return OperationParameter_c
					.getOneO_TPARMOnR124Succeeds((OperationParameter_c) next);
		}
		if (next.getClass() == StateMachineEventDataItem_c.class) {
			return StateMachineEventDataItem_c
					.getOneSM_EVTDIOnR533Succeeds((StateMachineEventDataItem_c) next);
		}
		if (next.getClass() == Attribute_c.class) {
			return Attribute_c.getOneO_ATTROnR103Succeeds((Attribute_c) next);
		}
		if (next.getClass() == Enumerator_c.class) {
			return Enumerator_c.getOneS_ENUMOnR56Succeeds((Enumerator_c) next);
		}
		if (next.getClass() == BridgeParameter_c.class) {
			return BridgeParameter_c
					.getOneS_BPARMOnR55Succeeds((BridgeParameter_c) next);
		}
		if (next.getClass() == InterfaceSignal_c.class) {
			return InterfaceSignal_c
					.getOneC_ASOnR4020Succeeds((InterfaceSignal_c) next);
		}
		if (next.getClass() == InterfaceOperation_c.class) {
			return InterfaceOperation_c
					.getOneC_IOOnR4019Succeeds((InterfaceOperation_c) next);
		}
		if (next.getClass() == PropertyParameter_c.class) {
			return PropertyParameter_c
					.getOneC_PPOnR4021Succeeds((PropertyParameter_c) next);
		}
		if (next.getClass() == StructureMember_c.class) {
			return StructureMember_c
					.getOneS_MBROnR46Succeeds((StructureMember_c) next);
		}
		return null;
	}

	public static ModelElement getNextElement(NonRootModelElement previous) {
		if (previous.getClass() == FunctionParameter_c.class) {
			return FunctionParameter_c
					.getOneS_SPARMOnR54Precedes((FunctionParameter_c) previous);
		}
		if (previous.getClass() == Operation_c.class) {
			return Operation_c
					.getOneO_TFROnR125Precedes((Operation_c) previous);
		}
		if (previous.getClass() == OperationParameter_c.class) {
			return OperationParameter_c
					.getOneO_TPARMOnR124Precedes((OperationParameter_c) previous);
		}
		if (previous.getClass() == StateMachineEventDataItem_c.class) {
			return StateMachineEventDataItem_c
					.getOneSM_EVTDIOnR533Precedes((StateMachineEventDataItem_c) previous);
		}
		if (previous.getClass() == Attribute_c.class) {
			return Attribute_c
					.getOneO_ATTROnR103Precedes((Attribute_c) previous);
		}
		if (previous.getClass() == Enumerator_c.class) {
			return Enumerator_c
					.getOneS_ENUMOnR56Precedes((Enumerator_c) previous);
		}
		if (previous.getClass() == BridgeParameter_c.class) {
			return BridgeParameter_c
					.getOneS_BPARMOnR55Precedes((BridgeParameter_c) previous);
		}
		if (previous.getClass() == InterfaceSignal_c.class) {
			return InterfaceSignal_c
					.getOneC_ASOnR4020Precedes((InterfaceSignal_c) previous);
		}
		if (previous.getClass() == InterfaceOperation_c.class) {
			return InterfaceOperation_c
					.getOneC_IOOnR4019Precedes((InterfaceOperation_c) previous);
		}
		if (previous.getClass() == PropertyParameter_c.class) {
			return PropertyParameter_c
					.getOneC_PPOnR4021Precedes((PropertyParameter_c) previous);
		}
		if (previous.getClass() == StructureMember_c.class) {
			return StructureMember_c
					.getOneS_MBROnR46Precedes((StructureMember_c) previous);
		}
		return null;
	}

	public static String getAssociationNumber(Object element) {
		if (element.getClass() == FunctionParameter_c.class) {
			return "54";
		}
		if (element.getClass() == Operation_c.class) {
			return "125";
		}
		if (element.getClass() == OperationParameter_c.class) {
			return "124";
		}
		if (element.getClass() == StateMachineEventDataItem_c.class) {
			return "533";
		}
		if (element.getClass() == Attribute_c.class) {
			return "103";
		}
		if (element.getClass() == Enumerator_c.class) {
			return "56";
		}
		if (element.getClass() == BridgeParameter_c.class) {
			return "55";
		}
		if (element.getClass() == InterfaceSignal_c.class) {
			return "4020";
		}
		if (element.getClass() == InterfaceOperation_c.class) {
			return "4019";
		}
		if (element.getClass() == PropertyParameter_c.class) {
			return "4021";
		}
		if (element.getClass() == StructureMember_c.class) {
			return "46";
		}
		return "";
	}

	public static String getAssociationPhrase(Object element) {
		if (element.getClass() == FunctionParameter_c.class) {
			return "Succeeds";
		}
		if (element.getClass() == Operation_c.class) {
			return "Succeeds";
		}
		if (element.getClass() == OperationParameter_c.class) {
			return "Succeeds";
		}
		if (element.getClass() == StateMachineEventDataItem_c.class) {
			return "Succeeds";
		}
		if (element.getClass() == Attribute_c.class) {
			return "Succeeds";
		}
		if (element.getClass() == Enumerator_c.class) {
			return "Succeeds";
		}
		if (element.getClass() == BridgeParameter_c.class) {
			return "Succeeds";
		}
		if (element.getClass() == InterfaceSignal_c.class) {
			return "Succeeds";
		}
		if (element.getClass() == InterfaceOperation_c.class) {
			return "Succeeds";
		}
		if (element.getClass() == PropertyParameter_c.class) {
			return "Succeeds";
		}
		if (element.getClass() == StructureMember_c.class) {
			return "Succeeds";
		}
		return "";
	}
}
