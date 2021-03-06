//======================================================================
//
// File: ActivitiesA_APropertySource.java
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

public class ActivitiesA_APropertySource implements IPropertySource {
	private Activity_c m_inst;
	private Activity_c[] m_Activities;
	private ForkJoinNode_c[] m_ForkJoins;
	private InitialNode_c[] m_InitialNodes;
	private ActivityEdge_c[] m_ActivityEdges;
	private ActivityPartition_c[] m_ActivityPartitions;
	private ActivityFinalNode_c[] m_ActivityFinalNodes;
	private FlowFinalNode_c[] m_FlowFinalNodes;
	private ActivityDiagramAction_c[] m_ActivityDiagramActions;
	private DecisionMergeNode_c[] m_DecisionMergeNodes;
	private ObjectNode_c[] m_ObjectNodes;
	private AcceptEventAction_c[] m_AcceptEventActions;
	private SendSignal_c[] m_SendSignalActions;
	private AcceptTimeEventAction_c[] m_AcceptTimeEventActions;
	private PropertyDescriptor[] m_propertyDescriptors;

	MetadataSortingManager sorter = MetadataSortingManager.createDefault();

	public ActivitiesA_APropertySource(Activity_c inst) {
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
		Activity_c[] v_activities = Activity_c
				.getManyA_AsOnR1110(ActivityInActivity_c
						.getManyA_AIAsOnR1109((Activity_c) m_inst));

		m_Activities = v_activities;
		num_children += m_Activities.length;

		sorter.sort(v_activities);
		ForkJoinNode_c[] v_forkjoins = ForkJoinNode_c
				.getManyA_FJsOnR1106(ControlNode_c
						.getManyA_CTLsOnR1105(ActivityNode_c
								.getManyA_NsOnR1101((Activity_c) m_inst)));

		m_ForkJoins = v_forkjoins;
		num_children += m_ForkJoins.length;

		sorter.sort(v_forkjoins);
		InitialNode_c[] v_initialnodes = InitialNode_c
				.getManyA_INIsOnR1106(ControlNode_c
						.getManyA_CTLsOnR1105(ActivityNode_c
								.getManyA_NsOnR1101((Activity_c) m_inst)));

		m_InitialNodes = v_initialnodes;
		num_children += m_InitialNodes.length;

		sorter.sort(v_initialnodes);
		ActivityEdge_c[] v_activityedges = ActivityEdge_c
				.getManyA_EsOnR1102((Activity_c) m_inst);

		m_ActivityEdges = v_activityedges;
		num_children += m_ActivityEdges.length;

		sorter.sort(v_activityedges);
		ActivityPartition_c[] v_activitypartitions = ActivityPartition_c
				.getManyA_APsOnR1111((Activity_c) m_inst);

		m_ActivityPartitions = v_activitypartitions;
		num_children += m_ActivityPartitions.length;

		sorter.sort(v_activitypartitions);
		ActivityFinalNode_c[] v_activityfinalnodes = ActivityFinalNode_c
				.getManyA_AFsOnR1106(ControlNode_c
						.getManyA_CTLsOnR1105(ActivityNode_c
								.getManyA_NsOnR1101((Activity_c) m_inst)));

		m_ActivityFinalNodes = v_activityfinalnodes;
		num_children += m_ActivityFinalNodes.length;

		sorter.sort(v_activityfinalnodes);
		FlowFinalNode_c[] v_flowfinalnodes = FlowFinalNode_c
				.getManyA_FFsOnR1106(ControlNode_c
						.getManyA_CTLsOnR1105(ActivityNode_c
								.getManyA_NsOnR1101((Activity_c) m_inst)));

		m_FlowFinalNodes = v_flowfinalnodes;
		num_children += m_FlowFinalNodes.length;

		sorter.sort(v_flowfinalnodes);
		ActivityDiagramAction_c[] v_activitydiagramactions = ActivityDiagramAction_c
				.getManyA_GAsOnR1107(ActionNode_c
						.getManyA_ACTsOnR1105(ActivityNode_c
								.getManyA_NsOnR1101((Activity_c) m_inst)));

		m_ActivityDiagramActions = v_activitydiagramactions;
		num_children += m_ActivityDiagramActions.length;

		sorter.sort(v_activitydiagramactions);
		DecisionMergeNode_c[] v_decisionmergenodes = DecisionMergeNode_c
				.getManyA_DMsOnR1106(ControlNode_c
						.getManyA_CTLsOnR1105(ActivityNode_c
								.getManyA_NsOnR1101((Activity_c) m_inst)));

		m_DecisionMergeNodes = v_decisionmergenodes;
		num_children += m_DecisionMergeNodes.length;

		sorter.sort(v_decisionmergenodes);
		ObjectNode_c[] v_objectnodes = ObjectNode_c
				.getManyA_OBJsOnR1105(ActivityNode_c
						.getManyA_NsOnR1101((Activity_c) m_inst));

		m_ObjectNodes = v_objectnodes;
		num_children += m_ObjectNodes.length;

		sorter.sort(v_objectnodes);
		AcceptEventAction_c[] v_accepteventactions = AcceptEventAction_c
				.getManyA_AEAsOnR1112(AcceptEvent_c.getManyA_AEsOnR1107(ActionNode_c
						.getManyA_ACTsOnR1105(ActivityNode_c
								.getManyA_NsOnR1101((Activity_c) m_inst))));

		m_AcceptEventActions = v_accepteventactions;
		num_children += m_AcceptEventActions.length;

		sorter.sort(v_accepteventactions);
		SendSignal_c[] v_sendsignalactions = SendSignal_c
				.getManyA_SSsOnR1107(ActionNode_c
						.getManyA_ACTsOnR1105(ActivityNode_c
								.getManyA_NsOnR1101((Activity_c) m_inst)));

		m_SendSignalActions = v_sendsignalactions;
		num_children += m_SendSignalActions.length;

		sorter.sort(v_sendsignalactions);
		AcceptTimeEventAction_c[] v_accepttimeeventactions = AcceptTimeEventAction_c
				.getManyA_ATEsOnR1112(AcceptEvent_c.getManyA_AEsOnR1107(ActionNode_c
						.getManyA_ACTsOnR1105(ActivityNode_c
								.getManyA_NsOnR1101((Activity_c) m_inst))));

		m_AcceptTimeEventActions = v_accepttimeeventactions;
		num_children += m_AcceptTimeEventActions.length;

		sorter.sort(v_accepttimeeventactions);
		if (m_propertyDescriptors == null
				|| 2 + num_children != m_propertyDescriptors.length) {
			m_propertyDescriptors = new PropertyDescriptor[2 + num_children];
			boolean readonly = false;

			m_propertyDescriptors[0] = new TextPropertyDescriptor("Name",
					"Activity Name");
			m_propertyDescriptors[0]
					.setValidator(new ModelElementNameValidator(m_inst));
			m_propertyDescriptors[0]
					.setCategory(BridgepointPropertySheetPage.basicCategoryName);
			m_propertyDescriptors[1] = new DescriptionPropertyDescriptor(
					"Descrip", "Activity Description", m_inst);
			m_propertyDescriptors[1]
					.setCategory(BridgepointPropertySheetPage.basicCategoryName);

			int d_index = 2;
			for (int i = 0; i < m_Activities.length; ++i) {
				m_propertyDescriptors[d_index] = new PropertyDescriptor(
						"Activities." + String.valueOf(i), "Activity");
				m_propertyDescriptors[d_index].setCategory("Activities");
				++d_index;
			}

			for (int i = 0; i < m_ForkJoins.length; ++i) {
				m_propertyDescriptors[d_index] = new PropertyDescriptor(
						"ForkJoins." + String.valueOf(i), "Fork Join Node");
				m_propertyDescriptors[d_index].setCategory("ForkJoins");
				++d_index;
			}

			for (int i = 0; i < m_InitialNodes.length; ++i) {
				m_propertyDescriptors[d_index] = new PropertyDescriptor(
						"InitialNodes." + String.valueOf(i), "Initial Node");
				m_propertyDescriptors[d_index].setCategory("InitialNodes");
				++d_index;
			}

			for (int i = 0; i < m_ActivityEdges.length; ++i) {
				m_propertyDescriptors[d_index] = new PropertyDescriptor(
						"ActivityEdges." + String.valueOf(i), "Activity Edge");
				m_propertyDescriptors[d_index].setCategory("ActivityEdges");
				++d_index;
			}

			for (int i = 0; i < m_ActivityPartitions.length; ++i) {
				m_propertyDescriptors[d_index] = new PropertyDescriptor(
						"ActivityPartitions." + String.valueOf(i),
						"Activity Partition");
				m_propertyDescriptors[d_index]
						.setCategory("ActivityPartitions");
				++d_index;
			}

			for (int i = 0; i < m_ActivityFinalNodes.length; ++i) {
				m_propertyDescriptors[d_index] = new PropertyDescriptor(
						"ActivityFinalNodes." + String.valueOf(i),
						"Activity Final Node");
				m_propertyDescriptors[d_index]
						.setCategory("ActivityFinalNodes");
				++d_index;
			}

			for (int i = 0; i < m_FlowFinalNodes.length; ++i) {
				m_propertyDescriptors[d_index] = new PropertyDescriptor(
						"FlowFinalNodes." + String.valueOf(i),
						"Flow Final Node");
				m_propertyDescriptors[d_index].setCategory("FlowFinalNodes");
				++d_index;
			}

			for (int i = 0; i < m_ActivityDiagramActions.length; ++i) {
				m_propertyDescriptors[d_index] = new PropertyDescriptor(
						"ActivityDiagramActions." + String.valueOf(i),
						"Activity Diagram Action");
				m_propertyDescriptors[d_index]
						.setCategory("ActivityDiagramActions");
				++d_index;
			}

			for (int i = 0; i < m_DecisionMergeNodes.length; ++i) {
				m_propertyDescriptors[d_index] = new PropertyDescriptor(
						"DecisionMergeNodes." + String.valueOf(i),
						"Decision Merge Node");
				m_propertyDescriptors[d_index]
						.setCategory("DecisionMergeNodes");
				++d_index;
			}

			for (int i = 0; i < m_ObjectNodes.length; ++i) {
				m_propertyDescriptors[d_index] = new PropertyDescriptor(
						"ObjectNodes." + String.valueOf(i), "Object Node");
				m_propertyDescriptors[d_index].setCategory("ObjectNodes");
				++d_index;
			}

			for (int i = 0; i < m_AcceptEventActions.length; ++i) {
				m_propertyDescriptors[d_index] = new PropertyDescriptor(
						"AcceptEventActions." + String.valueOf(i),
						"Accept Event Action");
				m_propertyDescriptors[d_index]
						.setCategory("AcceptEventActions");
				++d_index;
			}

			for (int i = 0; i < m_SendSignalActions.length; ++i) {
				m_propertyDescriptors[d_index] = new PropertyDescriptor(
						"SendSignalActions." + String.valueOf(i), "Send Signal");
				m_propertyDescriptors[d_index].setCategory("SendSignalActions");
				++d_index;
			}

			for (int i = 0; i < m_AcceptTimeEventActions.length; ++i) {
				m_propertyDescriptors[d_index] = new PropertyDescriptor(
						"AcceptTimeEventActions." + String.valueOf(i),
						"Accept Time Event Action");
				m_propertyDescriptors[d_index]
						.setCategory("AcceptTimeEventActions");
				++d_index;
			}

		}
		if (m_propertyDescriptors.length > 0)
			m_propertyDescriptors[0].setValidator(new ActivityNameValidator());
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
		}
		int d_index = 2;
		for (int i = 0; i < m_Activities.length; ++i) {
			if (m_propertyDescriptors[d_index].getId().equals(id)) {
				return new ActivitiesA_APropertySource(m_Activities[i]);
			}
			++d_index;
		}

		for (int i = 0; i < m_ForkJoins.length; ++i) {
			if (m_propertyDescriptors[d_index].getId().equals(id)) {
				return new ForkJoinsA_FJPropertySource(m_ForkJoins[i]);
			}
			++d_index;
		}

		for (int i = 0; i < m_InitialNodes.length; ++i) {
			if (m_propertyDescriptors[d_index].getId().equals(id)) {
				return new InitialNodesA_INIPropertySource(m_InitialNodes[i]);
			}
			++d_index;
		}

		for (int i = 0; i < m_ActivityEdges.length; ++i) {
			if (m_propertyDescriptors[d_index].getId().equals(id)) {
				return new ActivityEdgesA_EPropertySource(m_ActivityEdges[i]);
			}
			++d_index;
		}

		for (int i = 0; i < m_ActivityPartitions.length; ++i) {
			if (m_propertyDescriptors[d_index].getId().equals(id)) {
				return new ActivityPartitionsA_APPropertySource(
						m_ActivityPartitions[i]);
			}
			++d_index;
		}

		for (int i = 0; i < m_ActivityFinalNodes.length; ++i) {
			if (m_propertyDescriptors[d_index].getId().equals(id)) {
				return new ActivityFinalNodesA_AFPropertySource(
						m_ActivityFinalNodes[i]);
			}
			++d_index;
		}

		for (int i = 0; i < m_FlowFinalNodes.length; ++i) {
			if (m_propertyDescriptors[d_index].getId().equals(id)) {
				return new FlowFinalNodesA_FFPropertySource(m_FlowFinalNodes[i]);
			}
			++d_index;
		}

		for (int i = 0; i < m_ActivityDiagramActions.length; ++i) {
			if (m_propertyDescriptors[d_index].getId().equals(id)) {
				return new ActivityDiagramActionsA_GAPropertySource(
						m_ActivityDiagramActions[i]);
			}
			++d_index;
		}

		for (int i = 0; i < m_DecisionMergeNodes.length; ++i) {
			if (m_propertyDescriptors[d_index].getId().equals(id)) {
				return new DecisionMergeNodesA_DMPropertySource(
						m_DecisionMergeNodes[i]);
			}
			++d_index;
		}

		for (int i = 0; i < m_ObjectNodes.length; ++i) {
			if (m_propertyDescriptors[d_index].getId().equals(id)) {
				return new ObjectNodesA_OBJPropertySource(m_ObjectNodes[i]);
			}
			++d_index;
		}

		for (int i = 0; i < m_AcceptEventActions.length; ++i) {
			if (m_propertyDescriptors[d_index].getId().equals(id)) {
				return new AcceptEventActionsA_AEAPropertySource(
						m_AcceptEventActions[i]);
			}
			++d_index;
		}

		for (int i = 0; i < m_SendSignalActions.length; ++i) {
			if (m_propertyDescriptors[d_index].getId().equals(id)) {
				return new SendSignalActionsA_SSPropertySource(
						m_SendSignalActions[i]);
			}
			++d_index;
		}

		for (int i = 0; i < m_AcceptTimeEventActions.length; ++i) {
			if (m_propertyDescriptors[d_index].getId().equals(id)) {
				return new AcceptTimeEventActionsA_ATEPropertySource(
						m_AcceptTimeEventActions[i]);
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
					trans_name = "Change in property: 'Name' of Activity";//$NON-NLS-1$
					tr = tm.startTransaction(trans_name,
							Ooaofooa.getDefaultInstance());
					value_changed = true;
					m_inst.setName(value.toString());
				}
			} else if (id.equals("Descrip")) {
				if (!value.toString().equals(m_inst.getDescrip())) {
					trans_name = "Change in property: 'Descrip' of Activity";//$NON-NLS-1$
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
