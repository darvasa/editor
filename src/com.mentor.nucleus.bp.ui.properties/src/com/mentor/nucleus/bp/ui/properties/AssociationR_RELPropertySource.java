//======================================================================
//
// File: AssociationR_RELPropertySource.java
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

public class AssociationR_RELPropertySource implements IPropertySource {
	private Association_c m_inst;
	private ClassAsSimpleParticipant_c[] m_AssociationParticipantEnd;
	private ClassAsSimpleFormalizer_c[] m_AssociationFormalizerEnd;
	private ClassAsAssociatedOneSide_c[] m_AssociativeOneEnd;
	private ClassAsAssociatedOtherSide_c[] m_AssociativeOtherEnd;
	private ClassAsLink_c[] m_Associative;
	private ClassAsSupertype_c[] m_Supertype;
	private ClassAsSubtype_c[] m_Subtype;
	private DerivedAssociation_c[] m_DerivedAssociation;
	private PropertyDescriptor[] m_propertyDescriptors;

	MetadataSortingManager sorter = MetadataSortingManager.createDefault();

	public AssociationR_RELPropertySource(Association_c inst) {
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
		ClassAsSimpleParticipant_c[] v_associationparticipantend = ClassAsSimpleParticipant_c
				.getManyR_PARTsOnR204(ReferredToClassInAssoc_c
						.getManyR_RTOsOnR203(ClassInAssociation_c
								.getManyR_OIRsOnR201((Association_c) m_inst)));

		m_AssociationParticipantEnd = v_associationparticipantend;
		num_children += m_AssociationParticipantEnd.length;

		sorter.sort(v_associationparticipantend);
		ClassAsSimpleFormalizer_c[] v_associationformalizerend = ClassAsSimpleFormalizer_c
				.getManyR_FORMsOnR205(ReferringClassInAssoc_c
						.getManyR_RGOsOnR203(ClassInAssociation_c
								.getManyR_OIRsOnR201((Association_c) m_inst)));

		m_AssociationFormalizerEnd = v_associationformalizerend;
		num_children += m_AssociationFormalizerEnd.length;

		sorter.sort(v_associationformalizerend);
		ClassAsAssociatedOneSide_c[] v_associativeoneend = ClassAsAssociatedOneSide_c
				.getManyR_AONEsOnR204(ReferredToClassInAssoc_c
						.getManyR_RTOsOnR203(ClassInAssociation_c
								.getManyR_OIRsOnR201((Association_c) m_inst)));

		m_AssociativeOneEnd = v_associativeoneend;
		num_children += m_AssociativeOneEnd.length;

		sorter.sort(v_associativeoneend);
		ClassAsAssociatedOtherSide_c[] v_associativeotherend = ClassAsAssociatedOtherSide_c
				.getManyR_AOTHsOnR204(ReferredToClassInAssoc_c
						.getManyR_RTOsOnR203(ClassInAssociation_c
								.getManyR_OIRsOnR201((Association_c) m_inst)));

		m_AssociativeOtherEnd = v_associativeotherend;
		num_children += m_AssociativeOtherEnd.length;

		sorter.sort(v_associativeotherend);
		ClassAsLink_c[] v_associative = ClassAsLink_c
				.getManyR_ASSRsOnR205(ReferringClassInAssoc_c
						.getManyR_RGOsOnR203(ClassInAssociation_c
								.getManyR_OIRsOnR201((Association_c) m_inst)));

		m_Associative = v_associative;
		num_children += m_Associative.length;

		sorter.sort(v_associative);
		ClassAsSupertype_c[] v_supertype = ClassAsSupertype_c
				.getManyR_SUPERsOnR204(ReferredToClassInAssoc_c
						.getManyR_RTOsOnR203(ClassInAssociation_c
								.getManyR_OIRsOnR201((Association_c) m_inst)));

		m_Supertype = v_supertype;
		num_children += m_Supertype.length;

		sorter.sort(v_supertype);
		ClassAsSubtype_c[] v_subtype = ClassAsSubtype_c
				.getManyR_SUBsOnR205(ReferringClassInAssoc_c
						.getManyR_RGOsOnR203(ClassInAssociation_c
								.getManyR_OIRsOnR201((Association_c) m_inst)));

		m_Subtype = v_subtype;
		num_children += m_Subtype.length;

		sorter.sort(v_subtype);
		DerivedAssociation_c[] v_derivedassociation = DerivedAssociation_c
				.getManyR_COMPsOnR206((Association_c) m_inst);

		m_DerivedAssociation = v_derivedassociation;
		num_children += m_DerivedAssociation.length;

		sorter.sort(v_derivedassociation);
		if (m_propertyDescriptors == null
				|| 2 + num_children != m_propertyDescriptors.length) {
			m_propertyDescriptors = new PropertyDescriptor[2 + num_children];
			boolean readonly = false;

			m_propertyDescriptors[0] = new IntegerPropertyDescriptor("Numb",
					"Association Number", 0, 9999, readonly);
			m_propertyDescriptors[0]
					.setCategory(BridgepointPropertySheetPage.basicCategoryName);
			m_propertyDescriptors[1] = new DescriptionPropertyDescriptor(
					"Descrip", "Association Description", m_inst);
			m_propertyDescriptors[1]
					.setCategory(BridgepointPropertySheetPage.basicCategoryName);

			int d_index = 2;
			for (int i = 0; i < m_AssociationParticipantEnd.length; ++i) {
				m_propertyDescriptors[d_index] = new PropertyDescriptor(
						"AssociationParticipantEnd." + String.valueOf(i),
						"Class As Simple Participant");
				m_propertyDescriptors[d_index]
						.setCategory("Association Participant End");
				++d_index;
			}

			for (int i = 0; i < m_AssociationFormalizerEnd.length; ++i) {
				m_propertyDescriptors[d_index] = new PropertyDescriptor(
						"AssociationFormalizerEnd." + String.valueOf(i),
						"Class As Simple Formalizer");
				m_propertyDescriptors[d_index]
						.setCategory("Association Formalizer End");
				++d_index;
			}

			for (int i = 0; i < m_AssociativeOneEnd.length; ++i) {
				m_propertyDescriptors[d_index] = new PropertyDescriptor(
						"AssociativeOneEnd." + String.valueOf(i),
						"Class As Associated One Side");
				m_propertyDescriptors[d_index]
						.setCategory("Associative One End");
				++d_index;
			}

			for (int i = 0; i < m_AssociativeOtherEnd.length; ++i) {
				m_propertyDescriptors[d_index] = new PropertyDescriptor(
						"AssociativeOtherEnd." + String.valueOf(i),
						"Class As Associated Other Side");
				m_propertyDescriptors[d_index]
						.setCategory("Associative Other End");
				++d_index;
			}

			for (int i = 0; i < m_Associative.length; ++i) {
				m_propertyDescriptors[d_index] = new PropertyDescriptor(
						"Associative." + String.valueOf(i), "Class As Link");
				m_propertyDescriptors[d_index].setCategory("Associative");
				++d_index;
			}

			for (int i = 0; i < m_Supertype.length; ++i) {
				m_propertyDescriptors[d_index] = new PropertyDescriptor(
						"Supertype." + String.valueOf(i), "Class As Supertype");
				m_propertyDescriptors[d_index].setCategory("Supertype");
				++d_index;
			}

			for (int i = 0; i < m_Subtype.length; ++i) {
				m_propertyDescriptors[d_index] = new PropertyDescriptor(
						"Subtype." + String.valueOf(i), "Class As Subtype");
				m_propertyDescriptors[d_index].setCategory("Subtype");
				++d_index;
			}

			for (int i = 0; i < m_DerivedAssociation.length; ++i) {
				m_propertyDescriptors[d_index] = new PropertyDescriptor(
						"DerivedAssociation." + String.valueOf(i),
						"Derived Association");
				m_propertyDescriptors[d_index]
						.setCategory("Derived Association");
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
		if (id.equals("Numb")) {
			return String.valueOf(m_inst.getNumb());
		} else if (id.equals("Descrip")) {
			return m_inst.getDescrip().replace('\n', '/');
		}
		int d_index = 2;
		for (int i = 0; i < m_AssociationParticipantEnd.length; ++i) {
			if (m_propertyDescriptors[d_index].getId().equals(id)) {
				return new AssociationParticipantEndR_PARTPropertySource(
						m_AssociationParticipantEnd[i]);
			}
			++d_index;
		}

		for (int i = 0; i < m_AssociationFormalizerEnd.length; ++i) {
			if (m_propertyDescriptors[d_index].getId().equals(id)) {
				return new AssociationFormalizerEndR_FORMPropertySource(
						m_AssociationFormalizerEnd[i]);
			}
			++d_index;
		}

		for (int i = 0; i < m_AssociativeOneEnd.length; ++i) {
			if (m_propertyDescriptors[d_index].getId().equals(id)) {
				return new AssociativeOneEndR_AONEPropertySource(
						m_AssociativeOneEnd[i]);
			}
			++d_index;
		}

		for (int i = 0; i < m_AssociativeOtherEnd.length; ++i) {
			if (m_propertyDescriptors[d_index].getId().equals(id)) {
				return new AssociativeOtherEndR_AOTHPropertySource(
						m_AssociativeOtherEnd[i]);
			}
			++d_index;
		}

		for (int i = 0; i < m_Associative.length; ++i) {
			if (m_propertyDescriptors[d_index].getId().equals(id)) {
				return new AssociativeR_ASSRPropertySource(m_Associative[i]);
			}
			++d_index;
		}

		for (int i = 0; i < m_Supertype.length; ++i) {
			if (m_propertyDescriptors[d_index].getId().equals(id)) {
				return new SupertypeR_SUPERPropertySource(m_Supertype[i]);
			}
			++d_index;
		}

		for (int i = 0; i < m_Subtype.length; ++i) {
			if (m_propertyDescriptors[d_index].getId().equals(id)) {
				return new SubtypeR_SUBPropertySource(m_Subtype[i]);
			}
			++d_index;
		}

		for (int i = 0; i < m_DerivedAssociation.length; ++i) {
			if (m_propertyDescriptors[d_index].getId().equals(id)) {
				return new DerivedAssociationR_COMPPropertySource(
						m_DerivedAssociation[i]);
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
			if (id.equals("Numb")) {
				int new_val = Integer.parseInt(value.toString());
				if (new_val != m_inst.getNumb()) {
					trans_name = "Change in property: 'Numb' of Association";//$NON-NLS-1$
					tr = tm.startTransaction(trans_name,
							Ooaofooa.getDefaultInstance());
					value_changed = true;
					m_inst.setNumb(new_val);
				}
			} else if (id.equals("Descrip")) {
				if (!value.toString().equals(m_inst.getDescrip())) {
					trans_name = "Change in property: 'Descrip' of Association";//$NON-NLS-1$
					tr = tm.startTransaction(trans_name,
							Ooaofooa.getDefaultInstance());
					value_changed = true;
					m_inst.setDescrip(value.toString());
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
