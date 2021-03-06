package com.mentor.nucleus.bp.core;
//====================================================================
//
// File:      com.mentor.nucleus.bp.core.AutomaticWiring_c.java
//
// WARNING: Do not edit this generated file
// Generated by ../MC-Java/java.arc, $Revision: 1.111 $
//
// (c) Copyright 2005-2014 by Mentor Graphics Corp.  All rights reserved.
//
//====================================================================

// No special imports
import java.util.*;
import java.lang.reflect.*;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import com.mentor.nucleus.bp.core.util.PersistenceUtil;
import org.eclipse.core.runtime.NullProgressMonitor;
import com.mentor.nucleus.bp.core.ui.marker.UmlProblem;
import com.mentor.nucleus.bp.core.common.*;
abstract class EV_AUTOMATIC_WIRING extends genericEvent_c {
	public abstract int getEvtcode();
}

public class AutomaticWiring_c extends NonRootModelElement
		implements
			IAdaptable,
			Cloneable {
	// Public Constructors
	public AutomaticWiring_c(ModelRoot modelRoot, java.util.UUID p_m_brg_id,
			java.util.UUID p_m_sync_id) {
		super(modelRoot);
		//pre-process the uuid so that we re-use null uuid instance rather then creating a new one.           
		m_brg_id = IdAssigner.preprocessUUID(p_m_brg_id);
		//pre-process the uuid so that we re-use null uuid instance rather then creating a new one.           
		m_sync_id = IdAssigner.preprocessUUID(p_m_sync_id);

	}
	static public AutomaticWiring_c createProxy(ModelRoot modelRoot,
			java.util.UUID p_m_brg_id, java.util.UUID p_m_sync_id,
			String p_contentPath, IPath p_localPath) {
		ModelRoot resolvedModelRoot = ModelRoot.findModelRoot(modelRoot,
				p_contentPath, p_localPath);
		// if a model root was not resolved it is most likely
		// due to a missing file of the proxy, defualt back to
		// the original model root
		if (resolvedModelRoot != null)
			modelRoot = resolvedModelRoot;
		InstanceList instances = modelRoot
				.getInstanceList(AutomaticWiring_c.class);
		AutomaticWiring_c new_inst = null;
		synchronized (instances) {
		}
		String contentPath = PersistenceUtil.resolveRelativePath(p_localPath,
				new Path(p_contentPath));
		if (modelRoot.isNewCompareRoot()) {
			// for comparisons we do not want to change
			// the content path
			contentPath = p_contentPath;
		}
		if (new_inst != null && !modelRoot.isCompareRoot()) {
			PersistableModelComponent pmc = new_inst.getPersistableComponent();
			if (pmc == null) {
				// dangling reference, redo this instance
				new_inst.batchUnrelate();
				//pre-process the uuid so that we re-use null uuid instance rather then creating a new one.           
				new_inst.m_brg_id = IdAssigner.preprocessUUID(p_m_brg_id);
				//pre-process the uuid so that we re-use null uuid instance rather then creating a new one.           
				new_inst.m_sync_id = IdAssigner.preprocessUUID(p_m_sync_id);

			}
		}
		if (new_inst == null) {
			// there is no instance matching the id, create a proxy
			// if the resource doesn't exist then this will be a dangling reference
			new_inst = new AutomaticWiring_c(modelRoot, p_m_brg_id, p_m_sync_id);
			new_inst.m_contentPath = contentPath;
		}
		return new_inst;
	}

	static public AutomaticWiring_c resolveInstance(ModelRoot modelRoot,
			java.util.UUID p_m_brg_id, java.util.UUID p_m_sync_id) {
		InstanceList instances = modelRoot
				.getInstanceList(AutomaticWiring_c.class);
		AutomaticWiring_c source = null;
		synchronized (instances) {
			Object[] key = {};
			source = (AutomaticWiring_c) instances.get(key);
			if (source != null && !modelRoot.isCompareRoot()) {
				source.convertFromProxy();
				source.batchUnrelate();
				//pre-process the uuid so that we re-use null uuid instance rather then creating a new one.           
				source.m_brg_id = IdAssigner.preprocessUUID(p_m_brg_id);
				//pre-process the uuid so that we re-use null uuid instance rather then creating a new one.           
				source.m_sync_id = IdAssigner.preprocessUUID(p_m_sync_id);

				return source;
			}
		}
		// there is no instance matching the id
		AutomaticWiring_c new_inst = new AutomaticWiring_c(modelRoot,
				p_m_brg_id, p_m_sync_id);
		return new_inst;
	}
	public AutomaticWiring_c(ModelRoot modelRoot) {
		super(modelRoot);
		m_brg_id = IdAssigner.NULL_UUID;
		m_sync_id = IdAssigner.NULL_UUID;
	}

	public boolean equals(Object elem) {
		if (!(elem instanceof AutomaticWiring_c)) {
			return false;
		}
		// check that the model-roots are the same
		if (((NonRootModelElement) elem).getModelRoot() != getModelRoot()) {
			return false;
		}

		return identityEquals(elem);
	}

	public boolean identityEquals(Object elem) {
		if (!(elem instanceof AutomaticWiring_c)) {
			return false;
		}

		AutomaticWiring_c me = (AutomaticWiring_c) elem;
		return true;
	}

	public boolean cachedIdentityEquals(Object elem) {
		if (!(elem instanceof AutomaticWiring_c)) {
			return false;
		}

		AutomaticWiring_c me = (AutomaticWiring_c) elem;
		return true;
	}

	// Attributes
	private java.util.UUID m_brg_id;
	private java.util.UUID m_sync_id;

	// declare association references from this class

	// referring navigation

	Function_c ConnectsBridgeExecutionToFunction;
	public void relateAcrossR3201To(Function_c target) {
		relateAcrossR3201To(target, true);
	}
	public void relateAcrossR3201To(Function_c target, boolean notifyChanges) {
		if (target == null)
			return;

		if (target == ConnectsBridgeExecutionToFunction)
			return; // already related

		if (ConnectsBridgeExecutionToFunction != target) {

			Object oldKey = getInstanceKey();

			if (ConnectsBridgeExecutionToFunction != null) {

				ConnectsBridgeExecutionToFunction.clearBackPointerR3201To(this);

				if (Boolean.valueOf(System.getenv("PTC_MCC_ENABLED")) == true) { //$NON-NLS-1$
					Ooaofooa.log
							.println(
									ILogger.CONSISTENCY,
									"AutomaticWiring_c.relateAcrossR3201To(Function_c target)",
									"Relate performed across R3201 from Automatic Wiring to Function without unrelate of prior instance.");
				}
			}

			ConnectsBridgeExecutionToFunction = target;
			if (IdAssigner.NULL_UUID.equals(target.getSync_id())) {
				// do not update cached value
			} else {
				// update cached value
				m_sync_id = target.getSync_idCachedValue();
			}
			updateInstanceKey(oldKey, getInstanceKey());
			target.setBackPointerR3201To(this);
			target.addRef();
			if (notifyChanges) {
				RelationshipChangeModelDelta change = new RelationshipChangeModelDelta(
						Modeleventnotification_c.DELTA_ELEMENT_RELATED, this,
						target, "3201", "");
				Ooaofooa.getDefaultInstance().fireModelElementRelationChanged(
						change);
			}
		}
	}
	public void unrelateAcrossR3201From(Function_c target) {
		unrelateAcrossR3201From(target, true);
	}
	public void unrelateAcrossR3201From(Function_c target, boolean notifyChanges) {
		if (target == null)
			return;

		if (ConnectsBridgeExecutionToFunction == null)
			return; // already unrelated

		if (target != ConnectsBridgeExecutionToFunction) {
			Exception e = new Exception();
			e.fillInStackTrace();
			CorePlugin.logError(
					"Tried to unrelate from non-related instance across R3201",
					e);
			return;
		}

		if (target != null) {
			target.clearBackPointerR3201To(this);
		}

		if (ConnectsBridgeExecutionToFunction != null) {

			m_sync_id = ConnectsBridgeExecutionToFunction.getSync_id();
			if (IdAssigner.NULL_UUID.equals(m_sync_id)) {
				m_sync_id = ConnectsBridgeExecutionToFunction
						.getSync_idCachedValue();
			}
			ConnectsBridgeExecutionToFunction = null;
			target.removeRef();
			if (notifyChanges) {
				RelationshipChangeModelDelta change = new RelationshipChangeModelDelta(
						Modeleventnotification_c.DELTA_ELEMENT_UNRELATED, this,
						target, "3201", "");
				Ooaofooa.getDefaultInstance().fireModelElementRelationChanged(
						change);
			}
		}
	}

	public static AutomaticWiring_c getOneS_AWOnR3201(Function_c[] targets) {
		return getOneS_AWOnR3201(targets, null);
	}

	public static AutomaticWiring_c getOneS_AWOnR3201(Function_c[] targets,
			ClassQueryInterface_c test) {
		AutomaticWiring_c ret_val = null;
		if (targets != null) {
			for (int i = 0; i < targets.length && ret_val == null; ++i) {
				ret_val = getOneS_AWOnR3201(targets[i], test);
			}
		}

		return ret_val;
	}

	public static AutomaticWiring_c getOneS_AWOnR3201(Function_c target) {
		return getOneS_AWOnR3201(target, null);
	}

	public static AutomaticWiring_c getOneS_AWOnR3201(Function_c target,
			boolean loadComponent) {
		return getOneS_AWOnR3201(target.getModelRoot(), target, null,
				loadComponent);
	}

	public static AutomaticWiring_c getOneS_AWOnR3201(Function_c target,
			ClassQueryInterface_c test) {
		if (target != null) {
			return getOneS_AWOnR3201(target.getModelRoot(), target, test);
		}
		return null;
	}

	public static AutomaticWiring_c getOneS_AWOnR3201(ModelRoot modelRoot,
			Function_c target, ClassQueryInterface_c test) {
		return getOneS_AWOnR3201(modelRoot, target, test, true);
	}

	public static AutomaticWiring_c getOneS_AWOnR3201(ModelRoot modelRoot,
			Function_c target, ClassQueryInterface_c test, boolean loadComponent) {
		return find_getOneS_AWOnR3201(modelRoot, target, test);
	}
	private static AutomaticWiring_c find_getOneS_AWOnR3201(
			ModelRoot modelRoot, Function_c target, ClassQueryInterface_c test) {
		if (target != null) {
			synchronized (target.backPointer_ProvidesExecutionForAutomaticWiringProvidesExecutionFor_R3201) {
				for (int i = 0; i < target.backPointer_ProvidesExecutionForAutomaticWiringProvidesExecutionFor_R3201
						.size(); ++i) {
					AutomaticWiring_c source = (AutomaticWiring_c) target.backPointer_ProvidesExecutionForAutomaticWiringProvidesExecutionFor_R3201
							.get(i);
					if (source != null
							&& (test == null || test.evaluate(source))) {
						return source;
					}
				}
			}
		}
		// not found
		return null;
	}

	public static AutomaticWiring_c[] getManyS_AWsOnR3201(Function_c[] targets) {
		return getManyS_AWsOnR3201(targets, null);
	}
	public static AutomaticWiring_c[] getManyS_AWsOnR3201(Function_c[] targets,
			boolean loadComponent) {
		return getManyS_AWsOnR3201(targets, null, loadComponent);
	}
	public static AutomaticWiring_c[] getManyS_AWsOnR3201(Function_c[] targets,
			ClassQueryInterface_c test) {
		return getManyS_AWsOnR3201(targets, test, true);
	}

	public static AutomaticWiring_c[] getManyS_AWsOnR3201(Function_c[] targets,
			ClassQueryInterface_c test, boolean loadComponent) {

		if (targets == null || targets.length == 0 || targets[0] == null)
			return new AutomaticWiring_c[0];

		ModelRoot modelRoot = targets[0].getModelRoot();

		InstanceList instances = modelRoot
				.getInstanceList(AutomaticWiring_c.class);

		Vector matches = new Vector();
		for (int i = 0; i < targets.length; i++) {
			synchronized (targets[i].backPointer_ProvidesExecutionForAutomaticWiringProvidesExecutionFor_R3201) {
				for (int j = 0; j < targets[i].backPointer_ProvidesExecutionForAutomaticWiringProvidesExecutionFor_R3201
						.size(); ++j) {
					AutomaticWiring_c source = (AutomaticWiring_c) targets[i].backPointer_ProvidesExecutionForAutomaticWiringProvidesExecutionFor_R3201
							.get(j);
					if (source != null
							&& (test == null || test.evaluate(source))) {
						matches.add(source);
					}
				}
			}
		}
		if (matches.size() > 0) {
			AutomaticWiring_c[] ret_set = new AutomaticWiring_c[matches.size()];
			matches.copyInto(ret_set);
			return ret_set;
		} else {
			return new AutomaticWiring_c[0];
		}
	}

	public static AutomaticWiring_c[] getManyS_AWsOnR3201(Function_c target) {
		return getManyS_AWsOnR3201(target, null);
	}

	public static AutomaticWiring_c[] getManyS_AWsOnR3201(Function_c target,
			boolean loadComponent) {
		return getManyS_AWsOnR3201(target, null, loadComponent);
	}

	public static AutomaticWiring_c[] getManyS_AWsOnR3201(Function_c target,
			ClassQueryInterface_c test) {
		return getManyS_AWsOnR3201(target, test, true);
	}

	public static AutomaticWiring_c[] getManyS_AWsOnR3201(Function_c target,
			ClassQueryInterface_c test, boolean loadComponent) {
		if (target == null)
			return new AutomaticWiring_c[0];

		ModelRoot modelRoot = target.getModelRoot();
		Vector matches = new Vector();
		synchronized (target.backPointer_ProvidesExecutionForAutomaticWiringProvidesExecutionFor_R3201) {
			for (int i = 0; i < target.backPointer_ProvidesExecutionForAutomaticWiringProvidesExecutionFor_R3201
					.size(); ++i) {
				AutomaticWiring_c source = (AutomaticWiring_c) target.backPointer_ProvidesExecutionForAutomaticWiringProvidesExecutionFor_R3201
						.get(i);
				if (source != null && (test == null || test.evaluate(source))) {

					matches.add(source);
				}
			}
		}

		if (matches.size() > 0) {
			AutomaticWiring_c[] ret_set = new AutomaticWiring_c[matches.size()];
			matches.copyInto(ret_set);
			return ret_set;
		} else {
			return new AutomaticWiring_c[0];
		}
	}

	// referring navigation

	Bridge_c ForBridgeExecutionBridge;
	public void relateAcrossR3200To(Bridge_c target) {
		relateAcrossR3200To(target, true);
	}
	public void relateAcrossR3200To(Bridge_c target, boolean notifyChanges) {
		if (target == null)
			return;

		if (target == ForBridgeExecutionBridge)
			return; // already related

		if (ForBridgeExecutionBridge != target) {

			Object oldKey = getInstanceKey();

			if (ForBridgeExecutionBridge != null) {

				ForBridgeExecutionBridge.clearBackPointerR3200To(this);

				if (Boolean.valueOf(System.getenv("PTC_MCC_ENABLED")) == true) { //$NON-NLS-1$
					Ooaofooa.log
							.println(
									ILogger.CONSISTENCY,
									"AutomaticWiring_c.relateAcrossR3200To(Bridge_c target)",
									"Relate performed across R3200 from Automatic Wiring to Bridge without unrelate of prior instance.");
				}
			}

			ForBridgeExecutionBridge = target;
			m_brg_id = target.getBrg_id();
			updateInstanceKey(oldKey, getInstanceKey());
			target.setBackPointerR3200To(this);
			target.addRef();
			if (notifyChanges) {
				RelationshipChangeModelDelta change = new RelationshipChangeModelDelta(
						Modeleventnotification_c.DELTA_ELEMENT_RELATED, this,
						target, "3200", "");
				Ooaofooa.getDefaultInstance().fireModelElementRelationChanged(
						change);
			}
		}
	}
	public void unrelateAcrossR3200From(Bridge_c target) {
		unrelateAcrossR3200From(target, true);
	}
	public void unrelateAcrossR3200From(Bridge_c target, boolean notifyChanges) {
		if (target == null)
			return;

		if (ForBridgeExecutionBridge == null)
			return; // already unrelated

		if (target != ForBridgeExecutionBridge) {
			Exception e = new Exception();
			e.fillInStackTrace();
			CorePlugin.logError(
					"Tried to unrelate from non-related instance across R3200",
					e);
			return;
		}

		if (target != null) {
			target.clearBackPointerR3200To(this);
		}

		if (ForBridgeExecutionBridge != null) {

			m_brg_id = ForBridgeExecutionBridge.getBrg_id();
			ForBridgeExecutionBridge = null;
			target.removeRef();
			if (notifyChanges) {
				RelationshipChangeModelDelta change = new RelationshipChangeModelDelta(
						Modeleventnotification_c.DELTA_ELEMENT_UNRELATED, this,
						target, "3200", "");
				Ooaofooa.getDefaultInstance().fireModelElementRelationChanged(
						change);
			}
		}
	}

	public static AutomaticWiring_c getOneS_AWOnR3200(Bridge_c[] targets) {
		return getOneS_AWOnR3200(targets, null);
	}

	public static AutomaticWiring_c getOneS_AWOnR3200(Bridge_c[] targets,
			ClassQueryInterface_c test) {
		AutomaticWiring_c ret_val = null;
		if (targets != null) {
			for (int i = 0; i < targets.length && ret_val == null; ++i) {
				ret_val = getOneS_AWOnR3200(targets[i], test);
			}
		}

		return ret_val;
	}

	public static AutomaticWiring_c getOneS_AWOnR3200(Bridge_c target) {
		return getOneS_AWOnR3200(target, null);
	}

	public static AutomaticWiring_c getOneS_AWOnR3200(Bridge_c target,
			boolean loadComponent) {
		return getOneS_AWOnR3200(target.getModelRoot(), target, null,
				loadComponent);
	}

	public static AutomaticWiring_c getOneS_AWOnR3200(Bridge_c target,
			ClassQueryInterface_c test) {
		if (target != null) {
			return getOneS_AWOnR3200(target.getModelRoot(), target, test);
		}
		return null;
	}

	public static AutomaticWiring_c getOneS_AWOnR3200(ModelRoot modelRoot,
			Bridge_c target, ClassQueryInterface_c test) {
		return getOneS_AWOnR3200(modelRoot, target, test, true);
	}

	public static AutomaticWiring_c getOneS_AWOnR3200(ModelRoot modelRoot,
			Bridge_c target, ClassQueryInterface_c test, boolean loadComponent) {
		return find_getOneS_AWOnR3200(modelRoot, target, test);
	}
	private static AutomaticWiring_c find_getOneS_AWOnR3200(
			ModelRoot modelRoot, Bridge_c target, ClassQueryInterface_c test) {
		if (target != null) {
			AutomaticWiring_c source = (AutomaticWiring_c) target.backPointer_IsExecutedThroughAutomaticWiringIsExecutedThrough_R3200;
			if (source != null && (test == null || test.evaluate(source))) {
				return source;
			}
		}
		// not found
		return null;
	}

	public static AutomaticWiring_c[] getManyS_AWsOnR3200(Bridge_c[] targets) {
		return getManyS_AWsOnR3200(targets, null);
	}
	public static AutomaticWiring_c[] getManyS_AWsOnR3200(Bridge_c[] targets,
			boolean loadComponent) {
		return getManyS_AWsOnR3200(targets, null, loadComponent);
	}
	public static AutomaticWiring_c[] getManyS_AWsOnR3200(Bridge_c[] targets,
			ClassQueryInterface_c test) {
		return getManyS_AWsOnR3200(targets, test, true);
	}

	public static AutomaticWiring_c[] getManyS_AWsOnR3200(Bridge_c[] targets,
			ClassQueryInterface_c test, boolean loadComponent) {

		if (targets == null || targets.length == 0 || targets[0] == null)
			return new AutomaticWiring_c[0];

		ModelRoot modelRoot = targets[0].getModelRoot();

		InstanceList instances = modelRoot
				.getInstanceList(AutomaticWiring_c.class);

		Vector matches = new Vector();
		for (int i = 0; i < targets.length; i++) {
			AutomaticWiring_c source = (AutomaticWiring_c) targets[i].backPointer_IsExecutedThroughAutomaticWiringIsExecutedThrough_R3200;
			if (source != null && (test == null || test.evaluate(source))) {
				matches.add(source);
			}
		}
		if (matches.size() > 0) {
			AutomaticWiring_c[] ret_set = new AutomaticWiring_c[matches.size()];
			matches.copyInto(ret_set);
			return ret_set;
		} else {
			return new AutomaticWiring_c[0];
		}
	}

	public static AutomaticWiring_c[] getManyS_AWsOnR3200(Bridge_c target) {
		if (target != null) {
			Bridge_c[] targetArray = new Bridge_c[1];
			targetArray[0] = target;
			return getManyS_AWsOnR3200(targetArray);
		} else {
			AutomaticWiring_c[] result = new AutomaticWiring_c[0];
			return result;
		}
	}

	public static AutomaticWiring_c[] getManyS_AWsOnR3200(Bridge_c target,
			boolean loadComponent) {
		if (target != null) {
			Bridge_c[] targetArray = new Bridge_c[1];
			targetArray[0] = target;
			return getManyS_AWsOnR3200(targetArray, loadComponent);
		} else {
			AutomaticWiring_c[] result = new AutomaticWiring_c[0];
			return result;
		}
	}

	public void batchRelate(ModelRoot modelRoot, boolean notifyChanges,
			boolean searchAllRoots) {
		batchRelate(modelRoot, false, notifyChanges, searchAllRoots);
	}

	public void batchRelate(ModelRoot modelRoot, boolean relateProxies,
			boolean notifyChanges, boolean searchAllRoots) {
		InstanceList instances = null;
		ModelRoot baseRoot = modelRoot;

		if (ConnectsBridgeExecutionToFunction == null) {
			// R3201
			Function_c relInst37207 = (Function_c) baseRoot.getInstanceList(
					Function_c.class).get(new Object[]{m_sync_id});
			// if there was no local element, check for any global elements
			// failing that proceed to check other model roots
			if (relInst37207 == null) {
				relInst37207 = (Function_c) Ooaofooa.getDefaultInstance()
						.getInstanceList(Function_c.class)
						.get(new Object[]{m_sync_id});
			}
			if (relInst37207 == null && searchAllRoots
					&& !baseRoot.isCompareRoot()) {
				Ooaofooa[] roots = Ooaofooa.getInstances();
				for (int i = 0; i < roots.length; i++) {
					if (roots[i].isCompareRoot()) {
						// never use elements from any compare root
						continue;
					}
					relInst37207 = (Function_c) roots[i].getInstanceList(
							Function_c.class).get(new Object[]{m_sync_id});
					if (relInst37207 != null)
						break;
				}
			}
			//synchronized
			if (relInst37207 != null) {
				if (relateProxies || !isProxy()
						|| (inSameComponent(this, relInst37207) && !isProxy())) {
					relInst37207.relateAcrossR3201To(this, notifyChanges);
				}
			}
		}

		if (ForBridgeExecutionBridge == null) {
			// R3200
			Bridge_c relInst37208 = (Bridge_c) baseRoot.getInstanceList(
					Bridge_c.class).get(new Object[]{m_brg_id});
			// if there was no local element, check for any global elements
			// failing that proceed to check other model roots
			if (relInst37208 == null) {
				relInst37208 = (Bridge_c) Ooaofooa.getDefaultInstance()
						.getInstanceList(Bridge_c.class)
						.get(new Object[]{m_brg_id});
			}
			if (relInst37208 == null && searchAllRoots
					&& !baseRoot.isCompareRoot()) {
				Ooaofooa[] roots = Ooaofooa.getInstances();
				for (int i = 0; i < roots.length; i++) {
					if (roots[i].isCompareRoot()) {
						// never use elements from any compare root
						continue;
					}
					relInst37208 = (Bridge_c) roots[i].getInstanceList(
							Bridge_c.class).get(new Object[]{m_brg_id});
					if (relInst37208 != null)
						break;
				}
			}
			//synchronized
			if (relInst37208 != null) {
				if (relateProxies || !isProxy()
						|| (inSameComponent(this, relInst37208) && !isProxy())) {
					relInst37208.relateAcrossR3200To(this, notifyChanges);
				}
			}
		}

	}
	public void batchUnrelate(boolean notifyChanges) {
		NonRootModelElement inst = null;
		// R3201
		// S_SYNC
		inst = ConnectsBridgeExecutionToFunction;
		unrelateAcrossR3201From(ConnectsBridgeExecutionToFunction,
				notifyChanges);
		if (inst != null) {
			inst.removeRef();
		}
		// R3200
		// S_BRG
		inst = ForBridgeExecutionBridge;
		unrelateAcrossR3200From(ForBridgeExecutionBridge, notifyChanges);
		if (inst != null) {
			inst.removeRef();
		}
	}
	public static void batchRelateAll(ModelRoot modelRoot,
			boolean notifyChanges, boolean searchAllRoots) {
		batchRelateAll(modelRoot, notifyChanges, searchAllRoots, false);
	}
	public static void batchRelateAll(ModelRoot modelRoot, boolean notifyChanges, boolean searchAllRoots, boolean relateProxies)
  {
	InstanceList instances = modelRoot.getInstanceList(AutomaticWiring_c.class);
    synchronized(instances) {
        Iterator<NonRootModelElement> cursor = instances.iterator() ;
    	while (cursor.hasNext())
	    {
            final AutomaticWiring_c inst = (AutomaticWiring_c)cursor.next() ;
	        inst.batchRelate(modelRoot, relateProxies, notifyChanges, searchAllRoots );
	    }
	}
  }
	public static void clearInstances(ModelRoot modelRoot) {
		InstanceList instances = modelRoot
				.getInstanceList(AutomaticWiring_c.class);
		synchronized (instances) {
			for (int i = instances.size() - 1; i >= 0; i--) {
				((NonRootModelElement) instances.get(i)).delete_unchecked();
			}

		}
	}

	public static AutomaticWiring_c AutomaticWiringInstance(
			ModelRoot modelRoot, ClassQueryInterface_c test,
			boolean loadComponent) {
		AutomaticWiring_c result = findAutomaticWiringInstance(modelRoot, test,
				loadComponent);
		return result;
	}
	private static AutomaticWiring_c findAutomaticWiringInstance(
			ModelRoot modelRoot, ClassQueryInterface_c test,
			boolean loadComponent) {
		InstanceList instances = modelRoot
				.getInstanceList(AutomaticWiring_c.class);
		synchronized (instances) {
			for (int i = 0; i < instances.size(); ++i) {
				AutomaticWiring_c x = (AutomaticWiring_c) instances.get(i);
				if (test == null || test.evaluate(x)) {
					return x;
				}
			}
		}
		return null;
	}
	public static AutomaticWiring_c AutomaticWiringInstance(
			ModelRoot modelRoot, ClassQueryInterface_c test) {
		return AutomaticWiringInstance(modelRoot, test, true);
	}

	public static AutomaticWiring_c AutomaticWiringInstance(ModelRoot modelRoot) {
		return AutomaticWiringInstance(modelRoot, null, true);
	}

	public static AutomaticWiring_c[] AutomaticWiringInstances(
			ModelRoot modelRoot, ClassQueryInterface_c test,
			boolean loadComponent) {
		InstanceList instances = modelRoot
				.getInstanceList(AutomaticWiring_c.class);
		Vector matches = new Vector();
		synchronized (instances) {
			for (int i = 0; i < instances.size(); ++i) {
				AutomaticWiring_c x = (AutomaticWiring_c) instances.get(i);
				if (test == null || test.evaluate(x)) {
					matches.add(x);
				}
			}
			if (matches.size() > 0) {
				AutomaticWiring_c[] ret_set = new AutomaticWiring_c[matches
						.size()];
				matches.copyInto(ret_set);
				return ret_set;
			} else {
				return new AutomaticWiring_c[0];
			}
		}
	}
	public static AutomaticWiring_c[] AutomaticWiringInstances(
			ModelRoot modelRoot, ClassQueryInterface_c test) {
		return AutomaticWiringInstances(modelRoot, test, true);
	}
	public static AutomaticWiring_c[] AutomaticWiringInstances(
			ModelRoot modelRoot) {
		return AutomaticWiringInstances(modelRoot, null, true);
	}

	public boolean delete() {
		boolean result = super.delete();
		boolean delete_error = false;
		String errorMsg = "The following relationships were not torn down by the Automatic Wiring.dispose call: ";
		Function_c testR3201Inst = Function_c.getOneS_SYNCOnR3201(this, false);

		if (testR3201Inst != null) {
			delete_error = true;
			errorMsg = errorMsg + "3201 ";
		}
		Bridge_c testR3200Inst = Bridge_c.getOneS_BRGOnR3200(this, false);

		if (testR3200Inst != null) {
			delete_error = true;
			errorMsg = errorMsg + "3200 ";
		}
		if (delete_error == true) {

			if (CorePlugin.getDefault().isDebugging()) {
				Ooaofooa.log.println(ILogger.DELETE, "Automatic Wiring",
						errorMsg);
			} else {
				Exception e = new Exception();
				e.fillInStackTrace();
				CorePlugin.logError(errorMsg, e);
			}
		}
		return result;
	}

	// end declare instance pool

	// declare attribute accessors
	public boolean isUUID(String attributeName) {
		if (attributeName.equals("brg_id")) {
			return true;
		}
		if (attributeName.equals("sync_id")) {
			return true;
		}
		return false;
	}
	// declare attribute accessors
	public long getBrg_idLongBased() {
		if (ForBridgeExecutionBridge != null) {
			return ForBridgeExecutionBridge.getBrg_idLongBased();
		}
		return 0;
	}
	public java.util.UUID getBrg_id() {
		if (ForBridgeExecutionBridge != null) {
			return ForBridgeExecutionBridge.getBrg_id();
		}
		return IdAssigner.NULL_UUID;
	}

	public java.util.UUID getBrg_idCachedValue() {
		if (!IdAssigner.NULL_UUID.equals(m_brg_id))
			return m_brg_id;
		else
			return getBrg_id();
	}

	public void setBrg_id(java.util.UUID newValue) {
		if (newValue != null) {
			if (newValue.equals(m_brg_id)) {
				return;
			}
		} else if (m_brg_id != null) {
			if (m_brg_id.equals(newValue)) {
				return;
			}
		} else {
			return;
		}
		AttributeChangeModelDelta change = new AttributeChangeModelDelta(
				Modeleventnotification_c.DELTA_ATTRIBUTE_CHANGE, this,
				"Brg_id", m_brg_id, newValue, false);
		m_brg_id = IdAssigner.preprocessUUID(newValue);
		Ooaofooa.getDefaultInstance().fireModelElementAttributeChanged(change);
	}
	public long getSync_idLongBased() {
		if (ConnectsBridgeExecutionToFunction != null) {
			return ConnectsBridgeExecutionToFunction.getSync_idLongBased();
		}
		return 0;
	}
	public java.util.UUID getSync_id() {
		if (ConnectsBridgeExecutionToFunction != null) {
			return ConnectsBridgeExecutionToFunction.getSync_id();
		}
		return IdAssigner.NULL_UUID;
	}

	public java.util.UUID getSync_idCachedValue() {
		if (!IdAssigner.NULL_UUID.equals(m_sync_id))
			return m_sync_id;
		else
			return getSync_id();
	}

	public void setSync_id(java.util.UUID newValue) {
		if (newValue != null) {
			if (newValue.equals(m_sync_id)) {
				return;
			}
		} else if (m_sync_id != null) {
			if (m_sync_id.equals(newValue)) {
				return;
			}
		} else {
			return;
		}
		AttributeChangeModelDelta change = new AttributeChangeModelDelta(
				Modeleventnotification_c.DELTA_ATTRIBUTE_CHANGE, this,
				"Sync_id", m_sync_id, newValue, false);
		m_sync_id = IdAssigner.preprocessUUID(newValue);
		Ooaofooa.getDefaultInstance().fireModelElementAttributeChanged(change);
	}
	// end declare accessors
	public static void checkClassConsistency(ModelRoot modelRoot) {
		Ooaofooa.log.println(ILogger.OPERATION, "Automatic Wiring", //$NON-NLS-1$
				" Operation entered: Automatic Wiring::checkClassConsistency"); //$NON-NLS-1$
		if (Boolean.valueOf(System.getenv("PTC_MCC_ENABLED")) == false) { //$NON-NLS-1$
			return;
		}
		AutomaticWiring_c[] objs = AutomaticWiring_c.AutomaticWiringInstances(
				modelRoot, null, false);

		for (int i = 0; i < objs.length; i++) {
			objs[i].checkConsistency();
		}
	}
	public boolean checkConsistency() {
		Ooaofooa.log.println(ILogger.OPERATION, "Automatic Wiring", //$NON-NLS-1$
				" Operation entered: Automatic Wiring::checkConsistency"); //$NON-NLS-1$
		if (Boolean.valueOf(System.getenv("PTC_MCC_ENABLED")) == false) { //$NON-NLS-1$
			return true;
		}
		ModelRoot modelRoot = getModelRoot();
		boolean retval = true;
		// Automatic Wiring is a referring class in association: rel.Numb = 3200
		// The participating class is: Bridge
		class Bridge_c_test37213_c implements ClassQueryInterface_c {
			Bridge_c_test37213_c(java.util.UUID p37214) {
				m_p37214 = p37214;
			}
			private java.util.UUID m_p37214;
			public boolean evaluate(Object candidate) {
				Bridge_c selected = (Bridge_c) candidate;
				boolean retval = false;
				retval = (selected.getBrg_id().equals(m_p37214));
				return retval;
			}
		}

		Bridge_c[] objs37212 = Bridge_c.BridgeInstances(modelRoot,
				new Bridge_c_test37213_c(getBrg_id()));

		// The participant is unconditional
		// The multiplicity of the participant is one
		if (((objs37212.length) != 1)) {

			if (CorePlugin.getDefault().isDebugging()) {
				Ooaofooa.log
						.println(ILogger.CONSISTENCY,
								"Automatic Wiring", //$NON-NLS-1$
								"Consistency: Object: Automatic Wiring: Association: 3200: Cardinality of a participant is not equal to 1. " //$NON-NLS-1$
										+ "Actual Value: " //$NON-NLS-1$ 
										+ Integer.toString(objs37212.length)
										+ " Brg_ID: " + "Not Printable"); //$NON-NLS-1$
			} else {
				Exception e = new Exception();
				CorePlugin
						.logError(
								"Consistency: Object: Automatic Wiring: Association: 3200: Cardinality of a participant is not equal to 1. " //$NON-NLS-1$ 
										+ "Actual Value: " //$NON-NLS-1$
										+ Integer.toString(objs37212.length)
										+ " Brg_ID: " + "Not Printable", e); //$NON-NLS-1$
			}
			retval = false;

		}

		// Automatic Wiring is a referring class in association: rel.Numb = 3201
		// The participating class is: Function
		class Function_c_test37216_c implements ClassQueryInterface_c {
			Function_c_test37216_c(java.util.UUID p37217) {
				m_p37217 = p37217;
			}
			private java.util.UUID m_p37217;
			public boolean evaluate(Object candidate) {
				Function_c selected = (Function_c) candidate;
				boolean retval = false;
				retval = (selected.getSync_id().equals(m_p37217));
				return retval;
			}
		}

		Function_c[] objs37215 = Function_c.FunctionInstances(modelRoot,
				new Function_c_test37216_c(getSync_id()));

		if (((objs37215.length) > 1)) {

			if (CorePlugin.getDefault().isDebugging()) {
				Ooaofooa.log
						.println(ILogger.CONSISTENCY,
								"Automatic Wiring", //$NON-NLS-1$
								"Consistency: Object: Automatic Wiring: Association: 3201: Cardinality of a participant is greater than 1. " //$NON-NLS-1$
										+ "Actual Value: " //$NON-NLS-1$ 
										+ Integer.toString(objs37215.length)
										+ " Sync_ID: " + "Not Printable"); //$NON-NLS-1$
			} else {
				Exception e = new Exception();
				CorePlugin
						.logError(
								"Consistency: Object: Automatic Wiring: Association: 3201: Cardinality of a participant is greater than 1. " //$NON-NLS-1$ 
										+ "Actual Value: " //$NON-NLS-1$
										+ Integer.toString(objs37215.length)
										+ " Sync_ID: " + "Not Printable", e); //$NON-NLS-1$
			}
			retval = false;

		}

		return retval;
	}

	// declare transform functions
	public void Dispose() {
		Ooaofooa.log.println(ILogger.OPERATION, "Automatic Wiring",
				" Operation entered: AutomaticWiring::Dispose");
		final ModelRoot modelRoot = getModelRoot();
		Function_c v_function = Function_c.getOneS_SYNCOnR3201(this);

		if (((v_function != null))) {

			if (v_function != null) {
				v_function.unrelateAcrossR3201From(this);
			} else {
				Throwable t = new Throwable();
				t.fillInStackTrace();
				CorePlugin.logError(
						"Unrelate attempted on null left hand instance.", t);
			}

		}

		Bridge_c v_brg = Bridge_c.getOneS_BRGOnR3200(this);

		if (((v_brg != null))) {

			if (v_brg != null) {
				v_brg.unrelateAcrossR3200From(this);
			} else {
				Throwable t = new Throwable();
				t.fillInStackTrace();
				CorePlugin.logError(
						"Unrelate attempted on null left hand instance.", t);
			}

		}

		if (delete()) {
			Ooaofooa.getDefaultInstance().fireModelElementDeleted(
					new BaseModelDelta(Modeleventnotification_c.DELTA_DELETE,
							this));
		}

	} // End dispose

	// end transform functions

	public Object getAdapter(Class adapter) {
		Object superAdapter = super.getAdapter(adapter);
		if (superAdapter != null) {
			return superAdapter;
		}
		return null;
	}
} // end Automatic Wiring
