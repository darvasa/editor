//======================================================================
//
// File: BridgeS_BRGPropertySource.java
//
// WARNING:      Do not edit this generated file
// Generated by: arc/BuildPropertySource.arc
// Version:      $Revision: 1.66 $
//
// (c) Copyright 2006-2014 by Mentor Graphics Corp.  All rights reserved.
//
//======================================================================

package com.mentor.nucleus.bp.ui.properties;
import java.text.Collator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.Vector;

import org.eclipse.ui.views.properties.*;

import com.mentor.nucleus.bp.core.*;
import com.mentor.nucleus.bp.core.common.*;
import com.mentor.nucleus.bp.core.sorter.MetadataSortingManager;
import com.mentor.nucleus.bp.core.ui.cells.editors.*;
import com.mentor.nucleus.bp.core.util.DimensionsUtil;

public class BridgeS_BRGPropertySource implements IPropertySource {
	private Bridge_c m_inst;
	private String[] m_DataTypeReturnType;
	private BridgeParameter_c[] m_BridgeParameter;
	private PropertyDescriptor[] m_propertyDescriptors;
	private String[] Brg_Typ_vals = {"User-Defined", "Built-in"};
	private String[] Suc_Pars_vals = {"Do not parse", "Parse successful",
			"Parse unsuccessful", "Do parse"};
	MetadataSortingManager sorter = MetadataSortingManager.createDefault();

	public BridgeS_BRGPropertySource(Bridge_c inst) {
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
		return m_inst.getName();
	}

	/* (non-Javadoc)
	 * @see org.eclipse.ui.views.properties.IPropertySource#getPropertyDescriptors()
	 */
	public IPropertyDescriptor[] getPropertyDescriptors() {
		if (m_inst == null || m_inst.isOrphaned())
			return new IPropertyDescriptor[0];
		int num_children = 0;
		BridgeParameter_c[] v_bridgeparameter = BridgeParameter_c
				.getManyS_BPARMsOnR21((Bridge_c) m_inst);

		m_BridgeParameter = v_bridgeparameter;
		num_children += m_BridgeParameter.length;

		sorter.sort(v_bridgeparameter);
		if (m_propertyDescriptors == null
				|| 7 + num_children != m_propertyDescriptors.length) {
			m_propertyDescriptors = new PropertyDescriptor[7 + num_children];
			boolean readonly = false;

			m_propertyDescriptors[0] = new TextPropertyDescriptor("Name",
					"Bridge Name");
			m_propertyDescriptors[0]
					.setValidator(new ModelElementNameValidator(m_inst));
			m_propertyDescriptors[0]
					.setCategory(BridgepointPropertySheetPage.basicCategoryName);
			m_propertyDescriptors[1] = new DescriptionPropertyDescriptor(
					"Descrip", "Bridge Description", m_inst);
			m_propertyDescriptors[1]
					.setCategory(BridgepointPropertySheetPage.basicCategoryName);
			m_propertyDescriptors[2] = new EnumPropertyDescriptor("Brg_Typ",
					"Bridge Type", Brg_Typ_vals, true);
			m_propertyDescriptors[2]
					.setCategory(BridgepointPropertySheetPage.basicCategoryName);
			m_propertyDescriptors[3] = new ActivityPropertyDescriptor(
					"Action_Semantics", "Action Semantics Field", m_inst);
			m_propertyDescriptors[3]
					.setCategory(BridgepointPropertySheetPage.basicCategoryName);
			m_propertyDescriptors[4] = new EnumPropertyDescriptor("Suc_Pars",
					"Successful Parse Indicator", Suc_Pars_vals, readonly);
			m_propertyDescriptors[4]
					.setCategory(BridgepointPropertySheetPage.basicCategoryName);
			m_propertyDescriptors[5] = new DimensionsPropertyDescriptor(
					"Return_Dimensions", "Return Array Dimensions", readonly
							|| m_inst.Isvoid());
			m_propertyDescriptors[5].setValidator(new DimensionsValidator(
					(NonRootModelElement) m_inst));
			m_propertyDescriptors[5].setDescription(DimensionsValidator
					.getDimensionsHelpText(readonly || m_inst.Isvoid()));
			m_propertyDescriptors[5]
					.setCategory(BridgepointPropertySheetPage.basicCategoryName);

			int d_index = 6;
			// create combobox descriptor for Data Type
			DataType_c[] set19 = new DataType_c[0];
			DataType_c[] set19_2 = new DataType_c[0];
			// Note that datatypes our handled by the dt chooser dialog
			List list20 = new ArrayList(set19.length + set19_2.length);
			for (int i = 0; i < set19.length; ++i) {
				if (m_inst.Isallowedreturntype(set19[i].getName())) {
					list20.add(set19[i].getName());
				}
			}
			Collections.sort(list20, new Comparator() {
				Collator coll = Collator.getInstance(Locale.getDefault());
				public int compare(Object a, Object b) {
					return coll.compare((String) a, (String) b);
				}
			});
			m_DataTypeReturnType = new String[list20.size()];
			for (int i = 0; i < list20.size(); ++i) {
				m_DataTypeReturnType[i] = (String) list20.get(i);
			}
			m_propertyDescriptors[d_index] = new ChooserPropertyDescriptor(
					"DataType",
					"Return Type",
					m_inst,
					"com.mentor.nucleus.bp.core.ui.actions.SetReturnTypeOnS_BRGAction",
					readonly);
			m_propertyDescriptors[d_index]
					.setCategory(BridgepointPropertySheetPage.basicCategoryName);
			++d_index;
			for (int i = 0; i < m_BridgeParameter.length; ++i) {
				m_propertyDescriptors[d_index] = new PropertyDescriptor(
						"BridgeParameter." + String.valueOf(i),
						"Bridge Parameter");
				m_propertyDescriptors[d_index].setCategory("Bridge Parameter");
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
		if (id.equals("Name")) {
			return m_inst.getName();
		} else if (id.equals("Descrip")) {
			return m_inst.getDescrip().replace('\n', '/');
		} else if (id.equals("Brg_Typ")) {
			return Brg_Typ_vals[m_inst.getBrg_typ()];
		} else if (id.equals("Action_Semantics")) {
			return m_inst.getAction_semantics().replace('\n', '/');
		} else if (id.equals("Suc_Pars")) {
			return Suc_Pars_vals[m_inst.getSuc_pars()];
		} else if (id.equals("Return_Dimensions")) {
			return m_inst.getReturn_dimensions();
		}
		int d_index = 6;
		// getPropertyValue for combobox for Data Type
		if (id.equals("DataType")) {
			DataType_c val = DataType_c.getOneS_DTOnR20((Bridge_c) m_inst);

			if (val != null)
				return val.getName();
		}
		++d_index;
		for (int i = 0; i < m_BridgeParameter.length; ++i) {
			if (m_propertyDescriptors[d_index].getId().equals(id)) {
				return new BridgeParameterS_BPARMPropertySource(
						m_BridgeParameter[i]);
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
			if (id.equals("Name")) {
				if (!value.toString().equals(m_inst.getName())) {
					trans_name = "Change in property: 'Name' of Bridge";//$NON-NLS-1$
					tr = tm.startTransaction(trans_name,
							Ooaofooa.getDefaultInstance());
					value_changed = true;
					m_inst.setName(value.toString());
				}
			} else if (id.equals("Descrip")) {
				if (!value.toString().equals(m_inst.getDescrip())) {
					trans_name = "Change in property: 'Descrip' of Bridge";//$NON-NLS-1$
					tr = tm.startTransaction(trans_name,
							Ooaofooa.getDefaultInstance());
					value_changed = true;
					m_inst.setDescrip(value.toString());
				}
			} else if (id.equals("Brg_Typ")) {
				int new_val = Integer.parseInt(value.toString());
				if (new_val != m_inst.getBrg_typ()) {
					trans_name = "Change in property: 'Brg_Typ' of Bridge";//$NON-NLS-1$
					tr = tm.startTransaction(trans_name,
							Ooaofooa.getDefaultInstance());
					value_changed = true;
					m_inst.setBrg_typ(new_val);
				}
			} else if (id.equals("Suc_Pars")) {
				int new_val = Integer.parseInt(value.toString());
				if (new_val != m_inst.getSuc_pars()) {
					trans_name = "Change in property: 'Suc_Pars' of Bridge";//$NON-NLS-1$
					tr = tm.startTransaction(trans_name,
							Ooaofooa.getDefaultInstance());
					value_changed = true;
					m_inst.setSuc_pars(new_val);
				}
			} else if (id.equals("Return_Dimensions")) {
				if (!value.toString().equals(m_inst.getReturn_dimensions())) {
					trans_name = "Change in property: 'Return_Dimensions' of Bridge";//$NON-NLS-1$
					tr = tm.startTransaction(trans_name,
							Ooaofooa.getDefaultInstance());
					value_changed = true;
					Vector dims = DimensionsUtil.getDimensionsData(
							value.toString(), m_inst);
					if (dims.size() > 0) {
						for (int i = 0; i < dims.size(); i++) {
							int numElements = ((Integer) dims.get(i))
									.intValue();
							m_inst.Resizereturn_dimensions(i, numElements,
									dims.size());
						}
					} else {
						m_inst.Resizereturn_dimensions(0, 0, 0);
					}
					m_inst.setReturn_dimensions(value.toString());
				}
			}

			int d_index = 6;
			if (id.equals("DataType")) {
				DataType_c val = DataType_c.getOneS_DTOnR20((Bridge_c) m_inst);

				if (!value.equals(val.getName())) {
					DataType_c[] set21_1 = new DataType_c[0];
					DataType_c[] set21_2 = new DataType_c[0];
					if (m_inst.isInGenericPackage()) {
						Package_c pkg = m_inst.getFirstParentPackage();
						Component_c component = m_inst
								.getFirstParentComponent();
						if ((pkg != null)) {
							pkg.Clearscope();
							pkg.Collectvisibleelementsforname(false,
									Gd_c.Null_unique_id(), false, "",
									pkg.getPackage_id(),
									Elementtypeconstants_c.DATATYPE);

							class SearchResultSet_test24870_c
									implements
										ClassQueryInterface_c {
								public boolean evaluate(Object candidate) {
									SearchResultSet_c selected = (SearchResultSet_c) candidate;
									return selected.getName().equals("")
											&& selected.getType() == Elementtypeconstants_c.DATATYPE;
								}
							}
							SearchResultSet_c v_resultSet = SearchResultSet_c
									.getOnePE_SRSOnR8005(pkg,
											new SearchResultSet_test24870_c());

							set21_2 = DataType_c
									.getManyS_DTsOnR8001(PackageableElement_c
											.getManyPE_PEsOnR8002(ElementVisibility_c
													.getManyPE_VISsOnR8006(v_resultSet)));
						} else {
							if (component != null) {
								component.Clearscope();
								component.Collectvisibleelementsforname(false,
										Gd_c.Null_unique_id(), "",
										component.getId(),
										Elementtypeconstants_c.DATATYPE);

								class ComponentResultSet_test24870_c
										implements
											ClassQueryInterface_c {
									public boolean evaluate(Object candidate) {
										ComponentResultSet_c selected = (ComponentResultSet_c) candidate;
										return selected.getName().equals("")
												&& selected.getType() == Elementtypeconstants_c.DATATYPE;
									}
								}
								ComponentResultSet_c v_resultSet = ComponentResultSet_c
										.getOnePE_CRSOnR8007(
												component,
												new ComponentResultSet_test24870_c());

								set21_2 = DataType_c
										.getManyS_DTsOnR8001(PackageableElement_c
												.getManyPE_PEsOnR8004(ComponentVisibility_c
														.getManyPE_CVSsOnR8008(v_resultSet)));

							} else {
								// only throw an error the the element owning
								// this property source, are expected to not
								// have a package or component (the cases that
								// are not are UDTs that are built in)  Note that
								// the tool will behave properly, as the field
								// for these are read-only.
								if (!m_inst.selfIsCoreDataType()) {
									Throwable t = new Throwable();
									t.fillInStackTrace();
									CorePlugin
											.logError(
													"Attempted to call an operation on a null instance.",
													t);
								}
							}

						}
					}

					else {
						Domain_c domain = Domain_c
								.getOneS_DOMOnR8(ExternalEntity_c
										.getOneS_EEOnR19((Bridge_c) m_inst));
						set21_1 = DataType_c.getManyS_DTsOnR14(domain);
						set21_2 = DataType_c
								.getManyS_DTsOnR4401(SystemDatatypeInPackage_c.getManySLD_SDINPsOnR4402(SystemModel_c
										.getManyS_SYSsOnR4606(ComponentPackage_c
												.getManyCP_CPsOnR4608(Component_c
														.getManyC_CsOnR4204(DomainAsComponent_c
																.getManyCN_DCsOnR4204(domain))))));
					} // end isInGenericPackage
						// copy the system level data types into the
						// domain level data types array
					DataType_c[] set21_3 = new DataType_c[0];
					if (((SystemModel_c) m_inst.getRoot()).getUseglobals() == true) {
						set21_3 = DataType_c
								.getManyS_DTsOnR8001(PackageableElement_c
										.getManyPE_PEsOnR9100(GlobalElementInSystem_c
												.getManyG_EISsOnR9100((SystemModel_c) this.m_inst
														.getRoot())));
					}
					DataType_c[] set21 = new DataType_c[set21_1.length
							+ set21_2.length + +set21_3.length];
					System.arraycopy(set21_1, 0, set21, 0, set21_1.length);
					System.arraycopy(set21_2, 0, set21, set21_1.length,
							set21_2.length);
					System.arraycopy(set21_3, 0, set21, set21_1.length
							+ set21_2.length, set21_3.length);
					for (int i = 0; i < set21.length; ++i) {
						if (value.equals(set21[i].getName())) {
							trans_name = "Change in property: 'Return Type' of Bridge"; //$NON-NLS-1$
							tr = tm.startTransaction(trans_name,
									Ooaofooa.getDefaultInstance());
							m_inst.unrelateAcrossR20From(val);
							m_inst.relateAcrossR20To(set21[i]);
							value_changed = true;
							break;
						}
					}
				}
			}
			++d_index;

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