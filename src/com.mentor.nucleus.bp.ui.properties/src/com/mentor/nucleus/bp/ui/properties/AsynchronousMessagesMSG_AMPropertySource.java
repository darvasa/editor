//======================================================================
//
// File: AsynchronousMessagesMSG_AMPropertySource.java
//
// WARNING:      Do not edit this generated file
// Generated by: arc/BuildPropertySource.arc
// Version:      $Revision: 1.66 $
//
// (c) Copyright 2006-2014 by Mentor Graphics Corp.  All rights reserved.
//
//======================================================================

package com.mentor.nucleus.bp.ui.properties;
import org.eclipse.ui.views.properties.*;

import com.mentor.nucleus.bp.core.*;
import com.mentor.nucleus.bp.core.common.*;
import com.mentor.nucleus.bp.core.sorter.MetadataSortingManager;
import com.mentor.nucleus.bp.core.ui.cells.editors.*;
import com.mentor.nucleus.bp.core.util.DimensionsUtil;

public class AsynchronousMessagesMSG_AMPropertySource
		implements
			IPropertySource {
	private AsynchronousMessage_c m_inst;
	private MessageArgument_c[] m_InformalMessageArguments;
	private MessageArgument_c[] m_MessageArguments;
	private InformalAsynchronousMessage_c[] m_InformalMessageInformalMessage;
	private EventMessage_c[] m_FormalEventFormalEvent;
	private SignalMessage_c[] m_FormalSignalFormalSignalEvent;
	private PropertyDescriptor[] m_propertyDescriptors;

	MetadataSortingManager sorter = MetadataSortingManager.createDefault();

	public AsynchronousMessagesMSG_AMPropertySource(AsynchronousMessage_c inst) {
		m_inst = inst;
	}
	/* (non-Javadoc)
	 * @see org.eclipse.ui.views.properties.IPropertySource#getEditableValue()
	 */
	public Object getEditableValue() {
		return this;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.ui.views.properties.IPropertySource#isPropertySet(java.lang.Object)
	 */
	public boolean isPropertySet(Object id) {
		return false;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.ui.views.properties.IPropertySource#resetPropertyValue(java.lang.Object)
	 */
	public void resetPropertyValue(Object id) {
		// do nothing
	}

	public String toString() {
		return m_inst.Get_name();
	}

	/* (non-Javadoc)
	 * @see org.eclipse.ui.views.properties.IPropertySource#getPropertyDescriptors()
	 */
	public IPropertyDescriptor[] getPropertyDescriptors() {
		if (m_inst == null || m_inst.isOrphaned())
			return new IPropertyDescriptor[0];
		int num_children = 0;
		MessageArgument_c[] v_informalmessagearguments = MessageArgument_c
				.getManyMSG_AsOnR1013(InformalArgument_c.getManyMSG_IAsOnR1013(MessageArgument_c.getManyMSG_AsOnR1000(Message_c
						.getManyMSG_MsOnR1018((AsynchronousMessage_c) m_inst))));

		m_InformalMessageArguments = v_informalmessagearguments;
		num_children += m_InformalMessageArguments.length;

		sorter.sort(v_informalmessagearguments);
		MessageArgument_c[] v_messagearguments = MessageArgument_c
				.getManyMSG_AsOnR1001(Message_c
						.getManyMSG_MsOnR1018((AsynchronousMessage_c) m_inst));

		m_MessageArguments = v_messagearguments;
		num_children += m_MessageArguments.length;

		sorter.sort(v_messagearguments);
		InformalAsynchronousMessage_c[] v_informalmessageInformalMessage = InformalAsynchronousMessage_c
				.getManyMSG_IAMsOnR1019((AsynchronousMessage_c) m_inst);

		m_InformalMessageInformalMessage = v_informalmessageInformalMessage;
		num_children += m_InformalMessageInformalMessage.length;

		sorter.sort(v_informalmessageInformalMessage);
		EventMessage_c[] v_formaleventFormalEvent = EventMessage_c
				.getManyMSG_EsOnR1019((AsynchronousMessage_c) m_inst);

		m_FormalEventFormalEvent = v_formaleventFormalEvent;
		num_children += m_FormalEventFormalEvent.length;

		sorter.sort(v_formaleventFormalEvent);
		SignalMessage_c[] v_formalsignalFormalSignalEvent = SignalMessage_c
				.getManyMSG_SIGsOnR1019((AsynchronousMessage_c) m_inst);

		m_FormalSignalFormalSignalEvent = v_formalsignalFormalSignalEvent;
		num_children += m_FormalSignalFormalSignalEvent.length;

		sorter.sort(v_formalsignalFormalSignalEvent);
		if (m_propertyDescriptors == null
				|| 7 + num_children != m_propertyDescriptors.length) {
			m_propertyDescriptors = new PropertyDescriptor[7 + num_children];
			boolean readonly = false;

			m_propertyDescriptors[0] = new TextPropertyDescriptor(
					"GuardCondition", "Guard Condition");
			m_propertyDescriptors[0]
					.setCategory(BridgepointPropertySheetPage.basicCategoryName);
			m_propertyDescriptors[1] = new DescriptionPropertyDescriptor(
					"Descrip", "Message Description", m_inst);
			m_propertyDescriptors[1]
					.setCategory(BridgepointPropertySheetPage.basicCategoryName);
			m_propertyDescriptors[2] = new PropertyDescriptor("isFormal",
					"Is Formal");
			m_propertyDescriptors[2]
					.setCategory(BridgepointPropertySheetPage.basicCategoryName);
			m_propertyDescriptors[3] = new TextPropertyDescriptor(
					"DurationConstraint", "Duration Constraint");
			m_propertyDescriptors[3]
					.setCategory(BridgepointPropertySheetPage.basicCategoryName);
			m_propertyDescriptors[4] = new TextPropertyDescriptor(
					"DurationObservation", "Duration Observation");
			m_propertyDescriptors[4]
					.setCategory(BridgepointPropertySheetPage.basicCategoryName);
			m_propertyDescriptors[5] = new TextPropertyDescriptor(
					"InformalName", "Informal Name");
			m_propertyDescriptors[5]
					.setCategory(BridgepointPropertySheetPage.basicCategoryName);
			m_propertyDescriptors[6] = new TextPropertyDescriptor(
					"SequenceNumb", "Sequence Number");
			m_propertyDescriptors[6]
					.setCategory(BridgepointPropertySheetPage.basicCategoryName);

			int d_index = 7;
			for (int i = 0; i < m_InformalMessageArguments.length; ++i) {
				m_propertyDescriptors[d_index] = new PropertyDescriptor(
						"InformalMessageArguments." + String.valueOf(i),
						"Message Argument");
				m_propertyDescriptors[d_index]
						.setCategory("Informal Message Arguments");
				++d_index;
			}

			for (int i = 0; i < m_MessageArguments.length; ++i) {
				m_propertyDescriptors[d_index] = new PropertyDescriptor(
						"MessageArguments." + String.valueOf(i),
						"Message Argument");
				m_propertyDescriptors[d_index].setCategory("Message Arguments");
				++d_index;
			}

			for (int i = 0; i < m_InformalMessageInformalMessage.length; ++i) {
				m_propertyDescriptors[d_index] = new PropertyDescriptor(
						"InformalMessageInformalMessage." + String.valueOf(i),
						"Informal Message");
				m_propertyDescriptors[d_index].setCategory("Informal Message");
				++d_index;
			}

			for (int i = 0; i < m_FormalEventFormalEvent.length; ++i) {
				m_propertyDescriptors[d_index] = new PropertyDescriptor(
						"FormalEventFormalEvent." + String.valueOf(i),
						"Formal Event");
				m_propertyDescriptors[d_index].setCategory("Formal Event");
				++d_index;
			}

			for (int i = 0; i < m_FormalSignalFormalSignalEvent.length; ++i) {
				m_propertyDescriptors[d_index] = new PropertyDescriptor(
						"FormalSignalFormalSignalEvent." + String.valueOf(i),
						"Formal Signal Event");
				m_propertyDescriptors[d_index].setCategory("Formal Signal");
				++d_index;
			}

		}
		return m_propertyDescriptors;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.ui.views.properties.IPropertySource#getPropertyValue(java.lang.Object)
	 */
	public Object getPropertyValue(Object id) {
		if (m_inst.isOrphaned()) {
			return "";
		}
		if (id.equals("GuardCondition")) {
			return m_inst.getGuardcondition();
		} else if (id.equals("Descrip")) {
			return m_inst.getDescrip().replace('\n', '/');
		} else if (id.equals("isFormal")) {
			return new Boolean(m_inst.getIsformal());
		} else if (id.equals("DurationConstraint")) {
			return m_inst.getDurationconstraint();
		} else if (id.equals("DurationObservation")) {
			return m_inst.getDurationobservation();
		} else if (id.equals("InformalName")) {
			return m_inst.getInformalname();
		} else if (id.equals("SequenceNumb")) {
			return m_inst.getSequencenumb();
		}
		int d_index = 7;
		for (int i = 0; i < m_InformalMessageArguments.length; ++i) {
			if (m_propertyDescriptors[d_index].getId().equals(id)) {
				return new InformalMessageArgumentsMSG_APropertySource(
						m_InformalMessageArguments[i]);
			}
			++d_index;
		}

		for (int i = 0; i < m_MessageArguments.length; ++i) {
			if (m_propertyDescriptors[d_index].getId().equals(id)) {
				return new MessageArgumentsMSG_APropertySource(
						m_MessageArguments[i]);
			}
			++d_index;
		}

		for (int i = 0; i < m_InformalMessageInformalMessage.length; ++i) {
			if (m_propertyDescriptors[d_index].getId().equals(id)) {
				return new InformalMessageMSG_IAMPropertySource(
						m_InformalMessageInformalMessage[i]);
			}
			++d_index;
		}

		for (int i = 0; i < m_FormalEventFormalEvent.length; ++i) {
			if (m_propertyDescriptors[d_index].getId().equals(id)) {
				return new FormalEventMSG_EPropertySource(
						m_FormalEventFormalEvent[i]);
			}
			++d_index;
		}

		for (int i = 0; i < m_FormalSignalFormalSignalEvent.length; ++i) {
			if (m_propertyDescriptors[d_index].getId().equals(id)) {
				return new FormalSignalMSG_SIGPropertySource(
						m_FormalSignalFormalSignalEvent[i]);
			}
			++d_index;
		}

		return null;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.ui.views.properties.IPropertySource#setPropertyValue(java.lang.Object, java.lang.Object)
	 */
	public void setPropertyValue(Object id, Object value) {
		boolean value_changed = false;
		String trans_name = "";
		Transaction tr = null;
		Ooaofooa modelRoot = (Ooaofooa) m_inst.getModelRoot();
		TransactionManager tm = TransactionManager.getSingleton();
		try {
			if (id.equals("GuardCondition")) {
				if (!value.toString().equals(m_inst.getGuardcondition())) {
					trans_name = "Change in property: 'GuardCondition' of Asynchronous Message";//$NON-NLS-1$
					tr = tm.startTransaction(trans_name,
							Ooaofooa.getDefaultInstance());
					value_changed = true;
					m_inst.setGuardcondition(value.toString());
				}
			} else if (id.equals("Descrip")) {
				if (!value.toString().equals(m_inst.getDescrip())) {
					trans_name = "Change in property: 'Descrip' of Asynchronous Message";//$NON-NLS-1$
					tr = tm.startTransaction(trans_name,
							Ooaofooa.getDefaultInstance());
					value_changed = true;
					m_inst.setDescrip(value.toString());
				}
			} else if (id.equals("DurationConstraint")) {
				if (!value.toString().equals(m_inst.getDurationconstraint())) {
					trans_name = "Change in property: 'DurationConstraint' of Asynchronous Message";//$NON-NLS-1$
					tr = tm.startTransaction(trans_name,
							Ooaofooa.getDefaultInstance());
					value_changed = true;
					m_inst.setDurationconstraint(value.toString());
				}
			} else if (id.equals("DurationObservation")) {
				if (!value.toString().equals(m_inst.getDurationobservation())) {
					trans_name = "Change in property: 'DurationObservation' of Asynchronous Message";//$NON-NLS-1$
					tr = tm.startTransaction(trans_name,
							Ooaofooa.getDefaultInstance());
					value_changed = true;
					m_inst.setDurationobservation(value.toString());
				}
			} else if (id.equals("InformalName")) {
				if (!value.toString().equals(m_inst.getInformalname())) {
					trans_name = "Change in property: 'InformalName' of Asynchronous Message";//$NON-NLS-1$
					tr = tm.startTransaction(trans_name,
							Ooaofooa.getDefaultInstance());
					value_changed = true;
					m_inst.setInformalname(value.toString());
				}
			} else if (id.equals("SequenceNumb")) {
				if (!value.toString().equals(m_inst.getSequencenumb())) {
					trans_name = "Change in property: 'SequenceNumb' of Asynchronous Message";//$NON-NLS-1$
					tr = tm.startTransaction(trans_name,
							Ooaofooa.getDefaultInstance());
					value_changed = true;
					m_inst.setSequencenumb(value.toString());
				}
			}

			// catch all exceptions and cancel the transaction
		} catch (Exception e) {
			// this can be null if there was
			// an exception starting the
			// transaction
			if (tr != null) {
				tm.cancelTransaction(tr, e);
				tr = null;
			}
			CorePlugin.logError("Transaction: " + trans_name
					+ " could not complete", e);
		}
		if (tr != null) {
			if (value_changed)
				tm.endTransaction(tr);
			else
				tm.cancelTransaction(tr);
		}
	}
}
