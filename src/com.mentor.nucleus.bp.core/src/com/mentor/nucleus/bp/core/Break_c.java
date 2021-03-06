package com.mentor.nucleus.bp.core;
//====================================================================
//
// File:      com.mentor.nucleus.bp.core.Break_c.java
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
abstract class EV_BREAK extends genericEvent_c {
	public abstract int getEvtcode();
}

public class Break_c extends NonRootModelElement
		implements
			IAdaptable,
			Cloneable {
	// Public Constructors
	public Break_c(ModelRoot modelRoot, java.util.UUID p_m_statement_id) {
		super(modelRoot);
		//pre-process the uuid so that we re-use null uuid instance rather then creating a new one.           
		m_statement_id = IdAssigner.preprocessUUID(p_m_statement_id);

		Object[] key = {m_statement_id};
		addInstanceToMap(key);
	}
	static public Break_c createProxy(ModelRoot modelRoot,
			java.util.UUID p_m_statement_id, String p_contentPath,
			IPath p_localPath) {
		ModelRoot resolvedModelRoot = ModelRoot.findModelRoot(modelRoot,
				p_contentPath, p_localPath);
		// if a model root was not resolved it is most likely
		// due to a missing file of the proxy, defualt back to
		// the original model root
		if (resolvedModelRoot != null)
			modelRoot = resolvedModelRoot;
		InstanceList instances = modelRoot.getInstanceList(Break_c.class);
		Break_c new_inst = null;
		synchronized (instances) {
			Object[] key = {p_m_statement_id};
			new_inst = (Break_c) instances.get(key);
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
				new_inst.m_statement_id = IdAssigner
						.preprocessUUID(p_m_statement_id);

			}
		}
		if (new_inst == null) {
			// there is no instance matching the id, create a proxy
			// if the resource doesn't exist then this will be a dangling reference
			new_inst = new Break_c(modelRoot, p_m_statement_id);
			new_inst.m_contentPath = contentPath;
		}
		return new_inst;
	}

	static public Break_c resolveInstance(ModelRoot modelRoot,
			java.util.UUID p_m_statement_id) {
		InstanceList instances = modelRoot.getInstanceList(Break_c.class);
		Break_c source = null;
		synchronized (instances) {
			Object[] key = {p_m_statement_id};
			source = (Break_c) instances.get(key);
			if (source != null && !modelRoot.isCompareRoot()) {
				source.convertFromProxy();
				source.batchUnrelate();
				//pre-process the uuid so that we re-use null uuid instance rather then creating a new one.           
				source.m_statement_id = IdAssigner
						.preprocessUUID(p_m_statement_id);

				return source;
			}
		}
		// there is no instance matching the id
		Break_c new_inst = new Break_c(modelRoot, p_m_statement_id);
		return new_inst;
	}
	public Break_c(ModelRoot modelRoot) {
		super(modelRoot);
		m_statement_id = IdAssigner.NULL_UUID;
		Object[] key = {m_statement_id};
		addInstanceToMap(key);
	}

	public Object getInstanceKey() {
		Object[] key = {m_statement_id};
		return key;
	}

	public boolean setInstanceKey(UUID p_newKey) {

		boolean changed = false;
		// round p1
		// round p2
		// round p3
		// round p4
		// round p5
		if (m_statement_id != p_newKey) {

			m_statement_id = p_newKey;
			changed = true;
		}
		return changed;
	}

	public boolean equals(Object elem) {
		if (!(elem instanceof Break_c)) {
			return false;
		}
		// check that the model-roots are the same
		if (((NonRootModelElement) elem).getModelRoot() != getModelRoot()) {
			return false;
		}

		return identityEquals(elem);
	}

	public boolean identityEquals(Object elem) {
		if (!(elem instanceof Break_c)) {
			return false;
		}

		Break_c me = (Break_c) elem;
		// don't allow an empty id-value to produce a false positive result;
		// in this case, use whether the two instances are actually the same 
		// one in memory, instead
		if ((IdAssigner.NULL_UUID.equals(getStatement_id()) || IdAssigner.NULL_UUID
				.equals(((Break_c) elem).getStatement_id())) && this != elem) {
			return false;
		}
		if (!getStatement_id().equals(((Break_c) elem).getStatement_id()))
			return false;
		return true;
	}

	public boolean cachedIdentityEquals(Object elem) {
		if (!(elem instanceof Break_c)) {
			return false;
		}

		Break_c me = (Break_c) elem;
		if (!getStatement_idCachedValue().equals(
				((Break_c) elem).getStatement_idCachedValue()))
			return false;
		return true;
	}

	// Attributes
	private java.util.UUID m_statement_id;

	// declare association references from this class

	// referring navigation

	Statement_c IsSupertypeStatement;
	public void relateAcrossR603To(Statement_c target) {
		relateAcrossR603To(target, true);
	}
	public void relateAcrossR603To(Statement_c target, boolean notifyChanges) {
		if (target == null)
			return;

		if (target == IsSupertypeStatement)
			return; // already related

		if (IsSupertypeStatement != target) {

			Object oldKey = getInstanceKey();

			if (IsSupertypeStatement != null) {

				IsSupertypeStatement.clearBackPointerR603To(this);

				if (Boolean.valueOf(System.getenv("PTC_MCC_ENABLED")) == true) { //$NON-NLS-1$
					Ooaofooa.log
							.println(
									ILogger.CONSISTENCY,
									"Break_c.relateAcrossR603To(Statement_c target)",
									"Relate performed across R603 from Break to Statement without unrelate of prior instance.");
				}
			}

			IsSupertypeStatement = target;
			m_statement_id = target.getStatement_id();
			updateInstanceKey(oldKey, getInstanceKey());
			target.setBackPointerR603To(this);
			target.addRef();
		}
	}
	public void unrelateAcrossR603From(Statement_c target) {
		unrelateAcrossR603From(target, true);
	}
	public void unrelateAcrossR603From(Statement_c target, boolean notifyChanges) {
		if (target == null)
			return;

		if (IsSupertypeStatement == null)
			return; // already unrelated

		if (target != IsSupertypeStatement) {
			Exception e = new Exception();
			e.fillInStackTrace();
			CorePlugin.logError(
					"Tried to unrelate from non-related instance across R603",
					e);
			return;
		}

		if (target != null) {
			target.clearBackPointerR603To(this);
		}

		if (IsSupertypeStatement != null) {

			m_statement_id = IsSupertypeStatement.getStatement_id();
			IsSupertypeStatement = null;
			target.removeRef();
		}
	}

	public static Break_c getOneACT_BRKOnR603(Statement_c[] targets) {
		return getOneACT_BRKOnR603(targets, null);
	}

	public static Break_c getOneACT_BRKOnR603(Statement_c[] targets,
			ClassQueryInterface_c test) {
		Break_c ret_val = null;
		if (targets != null) {
			for (int i = 0; i < targets.length && ret_val == null; ++i) {
				ret_val = getOneACT_BRKOnR603(targets[i], test);
			}
		}

		return ret_val;
	}

	public static Break_c getOneACT_BRKOnR603(Statement_c target) {
		return getOneACT_BRKOnR603(target, null);
	}

	public static Break_c getOneACT_BRKOnR603(Statement_c target,
			boolean loadComponent) {
		return getOneACT_BRKOnR603(target.getModelRoot(), target, null,
				loadComponent);
	}

	public static Break_c getOneACT_BRKOnR603(Statement_c target,
			ClassQueryInterface_c test) {
		if (target != null) {
			return getOneACT_BRKOnR603(target.getModelRoot(), target, test);
		}
		return null;
	}

	public static Break_c getOneACT_BRKOnR603(ModelRoot modelRoot,
			Statement_c target, ClassQueryInterface_c test) {
		return getOneACT_BRKOnR603(modelRoot, target, test, true);
	}

	public static Break_c getOneACT_BRKOnR603(ModelRoot modelRoot,
			Statement_c target, ClassQueryInterface_c test,
			boolean loadComponent) {
		return find_getOneACT_BRKOnR603(modelRoot, target, test);
	}
	private static Break_c find_getOneACT_BRKOnR603(ModelRoot modelRoot,
			Statement_c target, ClassQueryInterface_c test) {
		if (target != null) {
			Break_c source = (Break_c) target.backPointer_IsSubtypeBreakIsSubtype_R603;
			if (source != null && (test == null || test.evaluate(source))) {
				return source;
			}
		}
		// not found
		return null;
	}

	public static Break_c[] getManyACT_BRKsOnR603(Statement_c[] targets) {
		return getManyACT_BRKsOnR603(targets, null);
	}
	public static Break_c[] getManyACT_BRKsOnR603(Statement_c[] targets,
			boolean loadComponent) {
		return getManyACT_BRKsOnR603(targets, null, loadComponent);
	}
	public static Break_c[] getManyACT_BRKsOnR603(Statement_c[] targets,
			ClassQueryInterface_c test) {
		return getManyACT_BRKsOnR603(targets, test, true);
	}

	public static Break_c[] getManyACT_BRKsOnR603(Statement_c[] targets,
			ClassQueryInterface_c test, boolean loadComponent) {

		if (targets == null || targets.length == 0 || targets[0] == null)
			return new Break_c[0];

		ModelRoot modelRoot = targets[0].getModelRoot();

		InstanceList instances = modelRoot.getInstanceList(Break_c.class);

		Vector matches = new Vector();
		for (int i = 0; i < targets.length; i++) {
			Break_c source = (Break_c) targets[i].backPointer_IsSubtypeBreakIsSubtype_R603;
			if (source != null && (test == null || test.evaluate(source))) {
				matches.add(source);
			}
		}
		if (matches.size() > 0) {
			Break_c[] ret_set = new Break_c[matches.size()];
			matches.copyInto(ret_set);
			return ret_set;
		} else {
			return new Break_c[0];
		}
	}

	public static Break_c[] getManyACT_BRKsOnR603(Statement_c target) {
		if (target != null) {
			Statement_c[] targetArray = new Statement_c[1];
			targetArray[0] = target;
			return getManyACT_BRKsOnR603(targetArray);
		} else {
			Break_c[] result = new Break_c[0];
			return result;
		}
	}

	public static Break_c[] getManyACT_BRKsOnR603(Statement_c target,
			boolean loadComponent) {
		if (target != null) {
			Statement_c[] targetArray = new Statement_c[1];
			targetArray[0] = target;
			return getManyACT_BRKsOnR603(targetArray, loadComponent);
		} else {
			Break_c[] result = new Break_c[0];
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

		// R603
		Statement_c relInst56442 = (Statement_c) baseRoot.getInstanceList(
				Statement_c.class).get(new Object[]{m_statement_id});
		// if there was no local element, check for any global elements
		// failing that proceed to check other model roots
		if (relInst56442 == null) {
			relInst56442 = (Statement_c) Ooaofooa.getDefaultInstance()
					.getInstanceList(Statement_c.class)
					.get(new Object[]{m_statement_id});
		}
		if (relInst56442 == null && searchAllRoots && !baseRoot.isCompareRoot()) {
			Ooaofooa[] roots = Ooaofooa.getInstances();
			for (int i = 0; i < roots.length; i++) {
				if (roots[i].isCompareRoot()) {
					// never use elements from any compare root
					continue;
				}
				relInst56442 = (Statement_c) roots[i].getInstanceList(
						Statement_c.class).get(new Object[]{m_statement_id});
				if (relInst56442 != null)
					break;
			}
		}
		//synchronized
		if (relInst56442 != null) {
			if (relateProxies || !isProxy()
					|| (inSameComponent(this, relInst56442) && !isProxy())) {
				relInst56442.relateAcrossR603To(this, notifyChanges);
			}
		}

	}
	public void batchUnrelate(boolean notifyChanges) {
		NonRootModelElement inst = null;
		// R603
		// ACT_SMT
		inst = IsSupertypeStatement;
		unrelateAcrossR603From(IsSupertypeStatement, notifyChanges);
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
	InstanceList instances = modelRoot.getInstanceList(Break_c.class);
    synchronized(instances) {
        Iterator<NonRootModelElement> cursor = instances.iterator() ;
    	while (cursor.hasNext())
	    {
            final Break_c inst = (Break_c)cursor.next() ;
	        inst.batchRelate(modelRoot, relateProxies, notifyChanges, searchAllRoots );
	    }
	}
  }
	public static void clearInstances(ModelRoot modelRoot) {
		InstanceList instances = modelRoot.getInstanceList(Break_c.class);
		synchronized (instances) {
			for (int i = instances.size() - 1; i >= 0; i--) {
				((NonRootModelElement) instances.get(i)).delete_unchecked();
			}

		}
	}

	public static Break_c BreakInstance(ModelRoot modelRoot,
			ClassQueryInterface_c test, boolean loadComponent) {
		Break_c result = findBreakInstance(modelRoot, test, loadComponent);
		return result;
	}
	private static Break_c findBreakInstance(ModelRoot modelRoot,
			ClassQueryInterface_c test, boolean loadComponent) {
		InstanceList instances = modelRoot.getInstanceList(Break_c.class);
		synchronized (instances) {
			for (int i = 0; i < instances.size(); ++i) {
				Break_c x = (Break_c) instances.get(i);
				if (test == null || test.evaluate(x)) {
					return x;
				}
			}
		}
		return null;
	}
	public static Break_c BreakInstance(ModelRoot modelRoot,
			ClassQueryInterface_c test) {
		return BreakInstance(modelRoot, test, true);
	}

	public static Break_c BreakInstance(ModelRoot modelRoot) {
		return BreakInstance(modelRoot, null, true);
	}

	public static Break_c[] BreakInstances(ModelRoot modelRoot,
			ClassQueryInterface_c test, boolean loadComponent) {
		InstanceList instances = modelRoot.getInstanceList(Break_c.class);
		Vector matches = new Vector();
		synchronized (instances) {
			for (int i = 0; i < instances.size(); ++i) {
				Break_c x = (Break_c) instances.get(i);
				if (test == null || test.evaluate(x)) {
					matches.add(x);
				}
			}
			if (matches.size() > 0) {
				Break_c[] ret_set = new Break_c[matches.size()];
				matches.copyInto(ret_set);
				return ret_set;
			} else {
				return new Break_c[0];
			}
		}
	}
	public static Break_c[] BreakInstances(ModelRoot modelRoot,
			ClassQueryInterface_c test) {
		return BreakInstances(modelRoot, test, true);
	}
	public static Break_c[] BreakInstances(ModelRoot modelRoot) {
		return BreakInstances(modelRoot, null, true);
	}

	public boolean delete() {
		boolean result = super.delete();
		boolean delete_error = false;
		String errorMsg = "The following relationships were not torn down by the Break.dispose call: ";
		Statement_c testR603Inst23 = Statement_c.getOneACT_SMTOnR603(this,
				false);

		if (testR603Inst23 != null) {
			delete_error = true;
			errorMsg = errorMsg + "603 ";
		}
		if (delete_error == true) {

			if (CorePlugin.getDefault().isDebugging()) {
				Ooaofooa.log.println(ILogger.DELETE, "Break", errorMsg);
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
		if (attributeName.equals("statement_id")) {
			return true;
		}
		return false;
	}
	// declare attribute accessors
	public long getStatement_idLongBased() {
		if (IsSupertypeStatement != null) {
			return IsSupertypeStatement.getStatement_idLongBased();
		}
		return 0;
	}
	public java.util.UUID getStatement_id() {
		if (IsSupertypeStatement != null) {
			return IsSupertypeStatement.getStatement_id();
		}
		return IdAssigner.NULL_UUID;
	}

	public boolean hasSuperType() {
		return (IsSupertypeStatement != null);

	}

	public java.util.UUID getStatement_idCachedValue() {
		if (!IdAssigner.NULL_UUID.equals(m_statement_id))
			return m_statement_id;
		else
			return getStatement_id();
	}

	public void setStatement_id(java.util.UUID newValue) {
		m_statement_id = IdAssigner.preprocessUUID(newValue);
	}
	// end declare accessors
	public static void checkClassConsistency(ModelRoot modelRoot) {
		Ooaofooa.log.println(ILogger.OPERATION, "Break", //$NON-NLS-1$
				" Operation entered: Break::checkClassConsistency"); //$NON-NLS-1$
		if (Boolean.valueOf(System.getenv("PTC_MCC_ENABLED")) == false) { //$NON-NLS-1$
			return;
		}
		Break_c[] objs = Break_c.BreakInstances(modelRoot, null, false);

		for (int i = 0; i < objs.length; i++) {
			objs[i].checkConsistency();
		}
	}
	public boolean checkConsistency() {
		Ooaofooa.log.println(ILogger.OPERATION, "Break", //$NON-NLS-1$
				" Operation entered: Break::checkConsistency"); //$NON-NLS-1$
		if (Boolean.valueOf(System.getenv("PTC_MCC_ENABLED")) == false) { //$NON-NLS-1$
			return true;
		}
		ModelRoot modelRoot = getModelRoot();
		boolean retval = true;
		class Break_c_test56444_c implements ClassQueryInterface_c {
			Break_c_test56444_c(java.util.UUID p56445) {
				m_p56445 = p56445;
			}
			private java.util.UUID m_p56445;
			public boolean evaluate(Object candidate) {
				Break_c selected = (Break_c) candidate;
				boolean retval = false;
				retval = (selected.getStatement_id().equals(m_p56445));
				return retval;
			}
		}

		Break_c[] objs56443 = Break_c.BreakInstances(modelRoot,
				new Break_c_test56444_c(getStatement_id()));

		if (((objs56443.length) == 0)) {

			if (CorePlugin.getDefault().isDebugging()) {
				Ooaofooa.log
						.println(ILogger.CONSISTENCY,
								"Break", //$NON-NLS-1$
								"Consistency: Object: Break: Cardinality of an identifier is zero. " //$NON-NLS-1$
										+ "Actual Value: " + Integer.toString(objs56443.length)); //$NON-NLS-1$
			} else {
				Exception e = new Exception();
				CorePlugin.logError(
						"Consistency: Object: Break: Cardinality of an identifier is zero. " //$NON-NLS-1$ 
								+ "Actual Value: " //$NON-NLS-1$
								+ Integer.toString(objs56443.length), e);
			}
			retval = false;

		}

		if (((objs56443.length) > 1)) {

			if (CorePlugin.getDefault().isDebugging()) {
				Ooaofooa.log.println(ILogger.CONSISTENCY, "Break", //$NON-NLS-1$
						"Consistency: Object: Break: Cardinality of an identifier is greater than 1. " //$NON-NLS-1$
								+ "Actual Value: " //$NON-NLS-1$ 
								+ Integer.toString(objs56443.length)
								+ " Statement_ID: " + "Not Printable"); //$NON-NLS-1$
			} else {
				Exception e = new Exception();
				CorePlugin.logError(
						"Consistency: Object: Break: Cardinality of an identifier is greater than 1. " //$NON-NLS-1$ 
								+ "Actual Value: " //$NON-NLS-1$
								+ Integer.toString(objs56443.length)
								+ " Statement_ID: " + "Not Printable", e); //$NON-NLS-1$
			}
			retval = false;

		}

		// Break is a subtype in association: rel.Numb = 603
		// The supertype class is: Statement
		class Statement_c_test56449_c implements ClassQueryInterface_c {
			Statement_c_test56449_c(java.util.UUID p56450) {
				m_p56450 = p56450;
			}
			private java.util.UUID m_p56450;
			public boolean evaluate(Object candidate) {
				Statement_c selected = (Statement_c) candidate;
				boolean retval = false;
				retval = (selected.getStatement_id().equals(m_p56450));
				return retval;
			}
		}

		Statement_c[] objs56448 = Statement_c.StatementInstances(modelRoot,
				new Statement_c_test56449_c(getStatement_id()));

		if (((objs56448.length) != 1)) {

			if (CorePlugin.getDefault().isDebugging()) {
				Ooaofooa.log
						.println(ILogger.CONSISTENCY,
								"Break", //$NON-NLS-1$
								"Consistency: Object: Break: Association: 603: Cardinality of a supertype is not equal to 1. " //$NON-NLS-1$
										+ "Actual Value: " + Integer.toString(objs56448.length)); //$NON-NLS-1$
			} else {
				Exception e = new Exception();
				CorePlugin
						.logError(
								"Consistency: Object: Break: Association: 603: Cardinality of a supertype is not equal to 1. " //$NON-NLS-1$ 
										+ "Actual Value: " //$NON-NLS-1$
										+ Integer.toString(objs56448.length), e);
			}
			retval = false;

		}

		return retval;
	}

	// declare transform functions
	public void Dispose() {
		Ooaofooa.log.println(ILogger.OPERATION, "Break",
				" Operation entered: Break::Dispose");
		final ModelRoot modelRoot = getModelRoot();
		delete();

	} // End dispose
	public void Execute(final java.util.UUID p_Stack_frame_id) {
		Ooaofooa.log.println(ILogger.OPERATION, "Break",
				" Operation entered: Break::Execute");
		final ModelRoot modelRoot = getModelRoot();

	} // End execute

	// end transform functions

	public Object getAdapter(Class adapter) {
		Object superAdapter = super.getAdapter(adapter);
		if (superAdapter != null) {
			return superAdapter;
		}
		return null;
	}
} // end Break
