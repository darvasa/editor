      
package com.mentor.nucleus.bp.core ;
//====================================================================
//
// File:      com.mentor.nucleus.bp.core.EePackageInPackage_c.java
//
// WARNING: Do not edit this generated file
// Generated by ../MC-Java/java.arc, $Revision: 1.111 $
//
// (c) Copyright 2005-2014 by Mentor Graphics Corp.  All rights reserved.
//
//====================================================================

// No special imports
import java.util.* ;
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
abstract class EV_EE_PACKAGE_IN_PACKAGE extends genericEvent_c 
{
  public abstract int getEvtcode() ;
}

public class EePackageInPackage_c extends NonRootModelElement implements IAdaptable, Cloneable
{
  // Public Constructors
  public EePackageInPackage_c(ModelRoot modelRoot,
       java.util.UUID         p_m_eepack_id)
  {
    super(modelRoot);
       //pre-process the uuid so that we re-use null uuid instance rather then creating a new one.           
       m_eepack_id = IdAssigner.preprocessUUID(p_m_eepack_id);
        
    Object [] key = {m_eepack_id};
    addInstanceToMap(key);
  }
  static public EePackageInPackage_c createProxy(ModelRoot modelRoot,
       java.util.UUID         p_m_eepack_id, String p_contentPath, IPath p_localPath)
  {
	  ModelRoot resolvedModelRoot = ModelRoot.findModelRoot(modelRoot, p_contentPath, p_localPath);
	  // if a model root was not resolved it is most likely
	  // due to a missing file of the proxy, defualt back to
	  // the original model root
	  if(resolvedModelRoot != null)
	  	modelRoot = resolvedModelRoot;
      InstanceList instances = modelRoot.getInstanceList(EePackageInPackage_c.class);
      EePackageInPackage_c new_inst = null;
      synchronized(instances) {
          Object[] key = {p_m_eepack_id};
          new_inst = (EePackageInPackage_c) instances.get(key) ;
        }
	String contentPath = PersistenceUtil.resolveRelativePath(
			p_localPath,
			new Path(p_contentPath));
	if(modelRoot.isNewCompareRoot()) {
	      // for comparisons we do not want to change
	      // the content path
	      contentPath = p_contentPath;
	}
	if ( new_inst != null && !modelRoot.isCompareRoot()) {
		PersistableModelComponent pmc = new_inst.getPersistableComponent();
		if (pmc == null) {
			// dangling reference, redo this instance
			new_inst.batchUnrelate();
       //pre-process the uuid so that we re-use null uuid instance rather then creating a new one.           
       new_inst.m_eepack_id = IdAssigner.preprocessUUID(p_m_eepack_id);
        
		}
	}
	if ( new_inst == null ) {
		// there is no instance matching the id, create a proxy
		// if the resource doesn't exist then this will be a dangling reference
    	new_inst = new EePackageInPackage_c(modelRoot,
p_m_eepack_id
);
		new_inst.m_contentPath = contentPath;
	}
    return new_inst;
  }

  static public EePackageInPackage_c resolveInstance(ModelRoot modelRoot,
       java.util.UUID         p_m_eepack_id){
    InstanceList instances = modelRoot.getInstanceList(EePackageInPackage_c.class);
    EePackageInPackage_c source = null;
    synchronized(instances) {
        Object [] key = {
        p_m_eepack_id
            };
        source = (EePackageInPackage_c) instances.get(key);
        if (source != null && !modelRoot.isCompareRoot()) {
           source.convertFromProxy();
           source.batchUnrelate();
       //pre-process the uuid so that we re-use null uuid instance rather then creating a new one.           
       source.m_eepack_id = IdAssigner.preprocessUUID(p_m_eepack_id);
        
           return source ;
        }
      }
      // there is no instance matching the id
    EePackageInPackage_c new_inst = new EePackageInPackage_c(modelRoot,
p_m_eepack_id
);
    return new_inst;
  }
  public EePackageInPackage_c(ModelRoot modelRoot)
  {
    super(modelRoot);
     m_eepack_id = IdAssigner.NULL_UUID;   
    Object [] key = {m_eepack_id};
    addInstanceToMap(key);
  }

  public Object getInstanceKey() {
    Object [] key =  {m_eepack_id};
		return key;
  }
  
  public boolean setInstanceKey(UUID p_newKey){
  
  	boolean changed = false;
		// round p1
		// round p2
		// round p3
			// round p4
			// round p5
	if (m_eepack_id !=  p_newKey ){
	
		m_eepack_id = p_newKey; 	
		changed = true;
	}
  	return changed;
  }
  

  



  public boolean equals (Object elem) {
     if (!(elem instanceof EePackageInPackage_c)) {
         return false;
     }
	    // check that the model-roots are the same
    	if (((NonRootModelElement)elem).getModelRoot() != getModelRoot()) {
    		return false;
    	}
    	
     return identityEquals(elem);
  }
  
   public boolean identityEquals(Object elem) {
       if (!(elem instanceof EePackageInPackage_c)) {
           return false;
       }
       
       EePackageInPackage_c me = (EePackageInPackage_c)elem;
      // don't allow an empty id-value to produce a false positive result;
      // in this case, use whether the two instances are actually the same 
      // one in memory, instead
      if ((IdAssigner.NULL_UUID.equals(getEepack_id()) || IdAssigner.NULL_UUID.equals(((EePackageInPackage_c)elem).getEepack_id())) && this != elem) {
      	return false;
      }
      if (!getEepack_id().equals(((EePackageInPackage_c)elem).getEepack_id())) return false;
      return true;
    }

   public boolean cachedIdentityEquals(Object elem) {
       if (!(elem instanceof EePackageInPackage_c)) {
           return false;
       }
       
       EePackageInPackage_c me = (EePackageInPackage_c)elem;
      if (!getEepack_idCachedValue().equals(((EePackageInPackage_c)elem).getEepack_idCachedValue())) return false;
      return true;
    }


  // Attributes
  private java.util.UUID         m_eepack_id ;
      
// declare association references from this class
  
  
    
// referring navigation

ExternalEntityPackage_c ContainsChildrenOfExternalEntityPackage ;
public void relateAcrossR34To(ExternalEntityPackage_c target)
{
	relateAcrossR34To(target, true);
}
public void relateAcrossR34To(ExternalEntityPackage_c target, boolean notifyChanges)
{
	if (target == null) return;
	
	if (target == ContainsChildrenOfExternalEntityPackage) return;  // already related

    if ( ContainsChildrenOfExternalEntityPackage != target ) {
    
    Object oldKey = getInstanceKey();

    if (ContainsChildrenOfExternalEntityPackage != null) {
    
        ContainsChildrenOfExternalEntityPackage.clearBackPointerR34To(this);
        
		if (Boolean.valueOf(System.getenv("PTC_MCC_ENABLED")) == true) {   //$NON-NLS-1$
		Ooaofooa.log.println(ILogger.CONSISTENCY, 
			"EePackageInPackage_c.relateAcrossR34To(ExternalEntityPackage_c target)", 
			"Relate performed across R34 from EE Package in Package to External Entity Package without unrelate of prior instance.");  
		}
    }
                
    	ContainsChildrenOfExternalEntityPackage = target ;
        m_eepack_id = target.getEepack_id();
      updateInstanceKey(oldKey, getInstanceKey());
	    target.setBackPointerR34To(this);
        target.addRef();
      if(notifyChanges) {
	    	RelationshipChangeModelDelta change = new RelationshipChangeModelDelta(Modeleventnotification_c.DELTA_ELEMENT_RELATED, this, target, "34", "");
        Ooaofooa.getDefaultInstance().fireModelElementRelationChanged(change);
      }
    }
}
public void unrelateAcrossR34From(ExternalEntityPackage_c target)
{
	unrelateAcrossR34From(target, true);
}
public void unrelateAcrossR34From(ExternalEntityPackage_c target, boolean notifyChanges)
{
	if (target == null) return;
	
	if (ContainsChildrenOfExternalEntityPackage == null) return;  // already unrelated
	
	if (target != ContainsChildrenOfExternalEntityPackage) {
		Exception e = new Exception();
		e.fillInStackTrace();
		CorePlugin.logError("Tried to unrelate from non-related instance across R34", e);
		return;
	}

    if (target != null) {
        target.clearBackPointerR34To(this);
    }
    

      if(ContainsChildrenOfExternalEntityPackage != null) {
      
        m_eepack_id = ContainsChildrenOfExternalEntityPackage.getEepack_id();
        ContainsChildrenOfExternalEntityPackage = null ;
        target.removeRef();
      if(notifyChanges) { 
        RelationshipChangeModelDelta change = new RelationshipChangeModelDelta(Modeleventnotification_c.DELTA_ELEMENT_UNRELATED, this, target, "34", "");
        Ooaofooa.getDefaultInstance().fireModelElementRelationChanged(change);
      }
    }
}

  
    
      
public static EePackageInPackage_c getOneS_EEPIPOnR34(ExternalEntityPackage_c [] targets)
{
    return getOneS_EEPIPOnR34(targets, null);
}

public static EePackageInPackage_c getOneS_EEPIPOnR34(ExternalEntityPackage_c [] targets, ClassQueryInterface_c test)
{
    EePackageInPackage_c ret_val = null;
    if (targets != null)
    {
        for (int i = 0; i < targets.length && ret_val == null; ++i )
        {
           ret_val = getOneS_EEPIPOnR34(targets[i], test);
        }
    }

    return ret_val;
}

public static EePackageInPackage_c getOneS_EEPIPOnR34(ExternalEntityPackage_c target)
{
  return getOneS_EEPIPOnR34(target, null);
}

public static EePackageInPackage_c getOneS_EEPIPOnR34(ExternalEntityPackage_c target, boolean loadComponent)
{
    return getOneS_EEPIPOnR34(target.getModelRoot(), target, null, loadComponent);
}

public static EePackageInPackage_c getOneS_EEPIPOnR34(ExternalEntityPackage_c target, ClassQueryInterface_c test)
{
  if (target != null) {
    return getOneS_EEPIPOnR34(target.getModelRoot(), target, test);
  }
  return null;
}

public static EePackageInPackage_c getOneS_EEPIPOnR34(ModelRoot modelRoot, ExternalEntityPackage_c target, ClassQueryInterface_c test)
{
	return getOneS_EEPIPOnR34(modelRoot, target, test, true);
}

public static EePackageInPackage_c getOneS_EEPIPOnR34(ModelRoot modelRoot, ExternalEntityPackage_c target, ClassQueryInterface_c test, boolean loadComponent)
{
   return find_getOneS_EEPIPOnR34(modelRoot,target,test);
}
private static EePackageInPackage_c find_getOneS_EEPIPOnR34(ModelRoot modelRoot, ExternalEntityPackage_c target, ClassQueryInterface_c test)
{
  if (target != null) {
    EePackageInPackage_c source = (EePackageInPackage_c)target.backPointer_IsParentToOtherPackagesViaEePackageInPackageIsParentToOtherPackagesVia_R34;
    if (source != null && (test == null || test.evaluate(source))) {
      return source;
    }
  }
  // not found
  return null ;
}

public static EePackageInPackage_c [] getManyS_EEPIPsOnR34(ExternalEntityPackage_c [] targets)
{
  return getManyS_EEPIPsOnR34(targets, null);
}
public static EePackageInPackage_c [] getManyS_EEPIPsOnR34(ExternalEntityPackage_c [] targets, boolean loadComponent)
{
  return getManyS_EEPIPsOnR34(targets, null, loadComponent);
}
public static EePackageInPackage_c [] getManyS_EEPIPsOnR34(ExternalEntityPackage_c [] targets, ClassQueryInterface_c test)
{
	return getManyS_EEPIPsOnR34(targets, test, true);
}

public static EePackageInPackage_c [] getManyS_EEPIPsOnR34(ExternalEntityPackage_c [] targets, ClassQueryInterface_c test, boolean loadComponent)
{

  if(targets == null || targets.length == 0 || targets[0] == null)
  	return new EePackageInPackage_c[0];

  ModelRoot modelRoot = targets[0].getModelRoot();
 
   InstanceList instances = modelRoot.getInstanceList(EePackageInPackage_c.class);

  Vector matches = new Vector();
  for (int i = 0 ; i < targets.length ; i++) {
      EePackageInPackage_c source = (EePackageInPackage_c)targets[i].backPointer_IsParentToOtherPackagesViaEePackageInPackageIsParentToOtherPackagesVia_R34;
      if (source != null && (test == null || test.evaluate(source))) {
        matches.add(source);
      }
  }
  if (matches.size() > 0) {
	EePackageInPackage_c[] ret_set = new EePackageInPackage_c[matches.size()];
	matches.copyInto(ret_set);
	return ret_set;
  } else {
	return new EePackageInPackage_c[0];
  }
  }

public static EePackageInPackage_c [] getManyS_EEPIPsOnR34(ExternalEntityPackage_c target)
{
  if (target != null) {
    ExternalEntityPackage_c [] targetArray = new ExternalEntityPackage_c[1];
    targetArray[0] = target;
    return getManyS_EEPIPsOnR34(targetArray);
  } else {
    EePackageInPackage_c [] result = new EePackageInPackage_c [0] ;
  return result ;
}
}

public static EePackageInPackage_c [] getManyS_EEPIPsOnR34(ExternalEntityPackage_c target, boolean loadComponent)
{
  if (target != null) {
    ExternalEntityPackage_c [] targetArray = new ExternalEntityPackage_c[1];
    targetArray[0] = target;
    return getManyS_EEPIPsOnR34(targetArray, loadComponent);
  } else {
    EePackageInPackage_c [] result = new EePackageInPackage_c [0] ;
  return result ;
}
}




// declare associations referring to this class

    
  
  
// referred to navigation

ArrayList<ExternalEntityPackage_c> backPointer_ContainsExternalEntityPackageContains_R35 = new ArrayList<ExternalEntityPackage_c>();

public void setExternalEntityPackageOrderInChildListR35(ExternalEntityPackage_c target, int index) {
	unrelateAcrossR35From(target);
	ExternalEntityPackage_c[] elements = ExternalEntityPackage_c.getManyS_EEPKsOnR35(this);
	int count = 0;
	for(int i = 0; i < elements.length; i++) {
		if(count >= index) {
			unrelateAcrossR35From((ExternalEntityPackage_c) elements[i]); 
		}
		count++;
	}
	relateAcrossR35To(target);
	count = 0;
	for(int i = 0; i < elements.length; i++) {
		if(count >= index) {
			relateAcrossR35To((ExternalEntityPackage_c) elements[i]);
		}
		count++;
	}
}

public void relateAcrossR35To(ExternalEntityPackage_c target)
{
  if (target != null) {
    target.relateAcrossR35To(this, true) ;
  }
}

public void relateAcrossR35To(ExternalEntityPackage_c target, boolean notifyChanges)
{
  if (target != null) {
    target.relateAcrossR35To(this, notifyChanges) ;
  }
}

public void setBackPointerR35To(ExternalEntityPackage_c target)
{
  	synchronized (backPointer_ContainsExternalEntityPackageContains_R35) {
		backPointer_ContainsExternalEntityPackageContains_R35.add(target);
	}
}

public void unrelateAcrossR35From(ExternalEntityPackage_c target)
{
  if (target != null) {
    target.unrelateAcrossR35From(this, true) ;
  }
}

public void unrelateAcrossR35From(ExternalEntityPackage_c target, boolean notifyChanges)
{
  if (target != null) {
    target.unrelateAcrossR35From(this, notifyChanges) ;
  }
}

public void clearBackPointerR35To(ExternalEntityPackage_c target)
{
  synchronized (backPointer_ContainsExternalEntityPackageContains_R35) {
	    backPointer_ContainsExternalEntityPackageContains_R35.remove(target);
	}
}

public static EePackageInPackage_c getOneS_EEPIPOnR35(ExternalEntityPackage_c [] targets)
{
    return getOneS_EEPIPOnR35(targets, null);
}

public static EePackageInPackage_c getOneS_EEPIPOnR35(ExternalEntityPackage_c [] targets, ClassQueryInterface_c test)
{
    return getOneS_EEPIPOnR35(targets, test, true);
}

public static EePackageInPackage_c getOneS_EEPIPOnR35(ExternalEntityPackage_c [] targets, ClassQueryInterface_c test, boolean loadComponent)
{
    EePackageInPackage_c ret_val = null;
    if (targets != null)
    {
        for (int i = 0; i < targets.length && ret_val == null; ++i )
        {
           if (test != null) {
             EePackageInPackage_c candidate_val = getOneS_EEPIPOnR35(targets[i],true);
             if ( candidate_val != null && test.evaluate(candidate_val) )
             {
               ret_val = candidate_val;
               break;
             }
           }
           else {
             ret_val = getOneS_EEPIPOnR35(targets[i], loadComponent);
             if (ret_val != null) {
               break;
             }
           }
        }
    }
    return ret_val;
}

public static EePackageInPackage_c getOneS_EEPIPOnR35(ExternalEntityPackage_c target)
{
	return getOneS_EEPIPOnR35(target, true);
}
public static EePackageInPackage_c getOneS_EEPIPOnR35(ExternalEntityPackage_c target, boolean loadComponent)
{
  if (target != null) {
	if(loadComponent){
	     target.loadProxy();
	    if(target.IsChildViaEePackageInPackage != null){
		target.IsChildViaEePackageInPackage.loadProxy();
	}
	}
    return target.IsChildViaEePackageInPackage ;
  } else {
    return null;
  }
}

public static EePackageInPackage_c [] getManyS_EEPIPsOnR35(ExternalEntityPackage_c [] targets,
    ClassQueryInterface_c test)
{
	return getManyS_EEPIPsOnR35(targets, test, true);
}

public static EePackageInPackage_c [] getManyS_EEPIPsOnR35(ExternalEntityPackage_c [] targets,
    ClassQueryInterface_c test, boolean loadComponent)
{
  if(targets == null || targets.length == 0 || targets[0] == null)
    return new EePackageInPackage_c[0];
  
  
  LinkedHashSet<EePackageInPackage_c> elementsSet = new LinkedHashSet<EePackageInPackage_c>();
  for (int i = 0; i < targets.length; i++) {
	if(loadComponent && targets[i] != null && targets[i].IsChildViaEePackageInPackage == null)
	  targets[i].loadProxy();
    EePackageInPackage_c associate = targets[i].IsChildViaEePackageInPackage;
    if (targets[i] != null && associate != null
    	&& (test == null || test.evaluate(associate))) {
        	if (elementsSet.add(associate)){ 
                if(loadComponent){
                   associate.loadProxy();
                }
            }
    }
  }

  EePackageInPackage_c[] result = new EePackageInPackage_c[elementsSet.size()];
  elementsSet.toArray(result);
  return result;
}

public static EePackageInPackage_c [] getManyS_EEPIPsOnR35(ExternalEntityPackage_c [] targets)
{
  return getManyS_EEPIPsOnR35(targets, null);
}

public static EePackageInPackage_c [] getManyS_EEPIPsOnR35(ExternalEntityPackage_c target,
    ClassQueryInterface_c test, boolean loadComponent)
{
  if (target != null) {
    ExternalEntityPackage_c [] targetArray = new ExternalEntityPackage_c[1];
    targetArray[0] = target;
    return getManyS_EEPIPsOnR35(targetArray, test, loadComponent);
  } else {
    EePackageInPackage_c [] result = new EePackageInPackage_c [0] ;
    return result ;
  }
  
}

public static EePackageInPackage_c [] getManyS_EEPIPsOnR35(ExternalEntityPackage_c target,
    ClassQueryInterface_c test)
{
    return getManyS_EEPIPsOnR35(target, null, true);
}

public static EePackageInPackage_c [] getManyS_EEPIPsOnR35(ExternalEntityPackage_c target)
{
    return getManyS_EEPIPsOnR35(target, null, true);
}

public static EePackageInPackage_c [] getManyS_EEPIPsOnR35(ExternalEntityPackage_c target, boolean loadComponent)
{
    return getManyS_EEPIPsOnR35(target, null, loadComponent);
}


      
  public void batchRelate(ModelRoot modelRoot, boolean notifyChanges, boolean searchAllRoots)
  {
      batchRelate(modelRoot, false, notifyChanges, searchAllRoots);
  }
  
  public void batchRelate(ModelRoot modelRoot, boolean relateProxies, boolean notifyChanges, boolean searchAllRoots)
  {
        InstanceList instances=null;
        ModelRoot baseRoot = modelRoot;

	if (ContainsChildrenOfExternalEntityPackage == null) {          
      // R34
      ExternalEntityPackage_c relInst55039 = (ExternalEntityPackage_c) baseRoot.getInstanceList(ExternalEntityPackage_c.class).get(new Object[] {m_eepack_id});
            // if there was no local element, check for any global elements
            // failing that proceed to check other model roots
      		if (relInst55039 == null) {
      			relInst55039 = (ExternalEntityPackage_c) Ooaofooa.getDefaultInstance().getInstanceList(ExternalEntityPackage_c.class).get(new Object[] {m_eepack_id});
      		}
			if (relInst55039 == null && searchAllRoots && !baseRoot.isCompareRoot()) {
				Ooaofooa[] roots = Ooaofooa.getInstances();
				for (int i = 0; i < roots.length; i++) {
				    if(roots[i].isCompareRoot()) {
				         // never use elements from any compare root
				         continue;
				    }
					relInst55039 = (ExternalEntityPackage_c) roots[i].getInstanceList(ExternalEntityPackage_c.class).get(new Object[] {m_eepack_id});
					if (relInst55039 != null)
						break;
				}
			}
			//synchronized
      if ( relInst55039 != null )
      {
          if (relateProxies || !isProxy() || (inSameComponent(this, relInst55039) && !isProxy())) {
	      relInst55039.relateAcrossR34To(this, notifyChanges);
	  }
	  }
	}
	          
	}
  public void batchUnrelate(boolean notifyChanges)
  {
		NonRootModelElement inst=null;
      // R34
      // S_EEPK
		  inst=ContainsChildrenOfExternalEntityPackage;
			unrelateAcrossR34From(ContainsChildrenOfExternalEntityPackage, notifyChanges);
          if ( inst != null ) {
			   inst.removeRef();
	      }
	}
  public static void batchRelateAll(ModelRoot modelRoot, boolean notifyChanges, boolean searchAllRoots) {
		batchRelateAll(modelRoot, notifyChanges, searchAllRoots, false);
  }	  
  public static void batchRelateAll(ModelRoot modelRoot, boolean notifyChanges, boolean searchAllRoots, boolean relateProxies)
  {
	InstanceList instances = modelRoot.getInstanceList(EePackageInPackage_c.class);
    synchronized(instances) {
        Iterator<NonRootModelElement> cursor = instances.iterator() ;
    	while (cursor.hasNext())
	    {
            final EePackageInPackage_c inst = (EePackageInPackage_c)cursor.next() ;
	        inst.batchRelate(modelRoot, relateProxies, notifyChanges, searchAllRoots );
	    }
	}
  }

  public static void clearInstances(ModelRoot modelRoot)
  {
    InstanceList instances = modelRoot.getInstanceList(EePackageInPackage_c.class);
    synchronized(instances) {
       for(int i=instances.size()-1; i>=0; i--){
              ((NonRootModelElement)instances.get(i)).delete_unchecked();
       }
    
    }
  }

  public static EePackageInPackage_c EePackageInPackageInstance(ModelRoot modelRoot, ClassQueryInterface_c test, boolean loadComponent)
  {
  		EePackageInPackage_c result=findEePackageInPackageInstance(modelRoot,test,loadComponent);
  		if(result==null && loadComponent){
     List pmcs =  PersistenceManager.findAllComponents(modelRoot,EePackageInPackage_c.class);
		for (int i = 0; i < pmcs.size(); i++) {
			PersistableModelComponent component = (PersistableModelComponent) pmcs
				.get(i);
			if (!component.isLoaded()) {
				try {
					component.load(new NullProgressMonitor());
					 result=findEePackageInPackageInstance(modelRoot,test,loadComponent);
					 if(result!=null) return result;
				} catch (Exception e) {
					CorePlugin.logError("Error Loading component", e);
				}
			}
		}
	    }
	    if(result!=null && loadComponent){
    	    result.loadProxy();
	    }
	  return result;  
  }
private static EePackageInPackage_c findEePackageInPackageInstance(ModelRoot modelRoot, ClassQueryInterface_c test, boolean loadComponent)
{
	InstanceList instances = modelRoot.getInstanceList(EePackageInPackage_c.class);
		synchronized (instances) {
            for (int i = 0; i < instances.size(); ++i) {
				EePackageInPackage_c x = (EePackageInPackage_c) instances.get(i);
				if (test==null || test.evaluate(x)){
					if(x.ensureLoaded(loadComponent))
					return x;
			}
		}
		}
			return null;
}
  public static EePackageInPackage_c EePackageInPackageInstance(ModelRoot modelRoot, ClassQueryInterface_c test){
     return EePackageInPackageInstance(modelRoot,test,true);
  }
  
  public static EePackageInPackage_c EePackageInPackageInstance(ModelRoot modelRoot)
  {
	 return EePackageInPackageInstance(modelRoot,null,true);
  }

  public static EePackageInPackage_c [] EePackageInPackageInstances(ModelRoot modelRoot, ClassQueryInterface_c test, boolean loadComponent)
  {	
            if(loadComponent){
  			   PersistenceManager.ensureAllInstancesLoaded(modelRoot, EePackageInPackage_c.class);
  			}
		    InstanceList instances = modelRoot.getInstanceList(EePackageInPackage_c.class);
			Vector matches = new Vector();
			synchronized (instances) {
                for (int i = 0; i < instances.size(); ++i) {
					EePackageInPackage_c x = (EePackageInPackage_c) instances.get(i);
					if (test==null ||test.evaluate(x)){
						if(x.ensureLoaded(loadComponent))
						matches.add(x);
			    }
				}
			if (matches.size() > 0) {
				EePackageInPackage_c[] ret_set = new EePackageInPackage_c[matches.size()];
				matches.copyInto(ret_set);
				return ret_set;
			} else {
				return new EePackageInPackage_c[0];
			}		
		} 
  }
  public static EePackageInPackage_c [] EePackageInPackageInstances(ModelRoot modelRoot, ClassQueryInterface_c test){
    return  EePackageInPackageInstances(modelRoot,test,true);
  }
  public static EePackageInPackage_c [] EePackageInPackageInstances(ModelRoot modelRoot)
  {
	return EePackageInPackageInstances(modelRoot,null,true);
  }

  public boolean delete()
  {
    boolean result = super.delete();
	boolean delete_error = false;
	String errorMsg = "The following relationships were not torn down by the EE Package in Package.dispose call: ";
	ExternalEntityPackage_c testR35Inst = ExternalEntityPackage_c.getOneS_EEPKOnR35(this, false);

	if ( testR35Inst != null )
	{
	delete_error = true;
	errorMsg = errorMsg + "35 ";	
	}
	ExternalEntityPackage_c testR34Inst = ExternalEntityPackage_c.getOneS_EEPKOnR34(this, false);

	if ( testR34Inst != null )
	{
   	delete_error = true;	        
	errorMsg = errorMsg + "34 ";
	}
	if(delete_error == true) {

		if(CorePlugin.getDefault().isDebugging()) {
			Ooaofooa.log.println(ILogger.DELETE, "EE Package in Package", errorMsg);
		}
		else {
			Exception e = new Exception();
            e.fillInStackTrace();
			CorePlugin.logError(errorMsg, e);
		}
	}
	return result;
  }

  // end declare instance pool

  // declare attribute accessors
  public boolean isUUID(String attributeName){
      if(attributeName.equals("eepack_id")){
         return true;
      }
      return false;      
  }      
 public String getCompUniqueID(){
    UUID tempID=null;
    long longID=0L;
    StringBuffer result= new StringBuffer();
    
    tempID= getEepack_id();
    
        if(IdAssigner.NULL_UUID.equals(tempID))
	      tempID=getEepack_idCachedValue(); 
	      result.append(Long.toHexString(tempID.getMostSignificantBits()));
          result.append(Long.toHexString(tempID.getLeastSignificantBits()));
    return result.toString();
 }
  // declare attribute accessors
  public long getEepack_idLongBased()
  {
    if ( ContainsChildrenOfExternalEntityPackage != null )
    {
      return ContainsChildrenOfExternalEntityPackage.getEepack_idLongBased();
    }
    return 0;  
  }          
  public java.util.UUID getEepack_id()
  {
    if ( ContainsChildrenOfExternalEntityPackage != null )
    {
      return ContainsChildrenOfExternalEntityPackage.getEepack_id();
    }
    return IdAssigner.NULL_UUID;
  }


  public java.util.UUID getEepack_idCachedValue()
  {
    if ( !IdAssigner.NULL_UUID.equals(m_eepack_id) )
      return m_eepack_id;
    else
      return getEepack_id();
  }
  
  public void setEepack_id(java.util.UUID newValue)
  {
	if(newValue != null){
	    if(newValue.equals(m_eepack_id)){
	        return;
	    }
	}else if(m_eepack_id != null){
	    if(m_eepack_id.equals(newValue)){
	        return;
	    }
	}else{
	    return;
	}
	AttributeChangeModelDelta change = new AttributeChangeModelDelta(Modeleventnotification_c.DELTA_ATTRIBUTE_CHANGE, this, "Eepack_id", m_eepack_id, newValue,true); 
   m_eepack_id = IdAssigner.preprocessUUID(newValue);
    Ooaofooa.getDefaultInstance().fireModelElementAttributeChanged(change);
  }
  // end declare accessors
  public static void checkClassConsistency (ModelRoot modelRoot) {
    Ooaofooa.log.println(
	  ILogger.OPERATION,
	  "EE Package in Package", //$NON-NLS-1$
	  " Operation entered: EE Package in Package::checkClassConsistency"); //$NON-NLS-1$
     if (Boolean.valueOf(System.getenv("PTC_MCC_ENABLED")) == false) {  //$NON-NLS-1$
       return;
     }
     EePackageInPackage_c [] objs = EePackageInPackage_c.EePackageInPackageInstances(modelRoot,null,false); 
     
     for ( int i = 0; i < objs.length; i++) {
       objs[i].checkConsistency();
     }  
  } 
  public boolean checkConsistency () {
    Ooaofooa.log.println(
	  ILogger.OPERATION,
	  "EE Package in Package", //$NON-NLS-1$
	  " Operation entered: EE Package in Package::checkConsistency");  //$NON-NLS-1$
    if (Boolean.valueOf(System.getenv("PTC_MCC_ENABLED")) == false) {  //$NON-NLS-1$
      return true;
    }
	ModelRoot modelRoot = getModelRoot();
    boolean      retval = true;
    class EePackageInPackage_c_test55041_c implements ClassQueryInterface_c
    {
	  EePackageInPackage_c_test55041_c( java.util.UUID            p55042 ) {
	  m_p55042 = p55042;
	  }
	  private java.util.UUID             m_p55042; 
	  public boolean evaluate (Object candidate)
	  {
	      EePackageInPackage_c selected = (EePackageInPackage_c) candidate;
	      boolean retval = false;
	      retval = (selected.getEepack_id().equals(m_p55042));
	      return retval;
	  }
    }

    EePackageInPackage_c [] objs55040 = 
    EePackageInPackage_c.EePackageInPackageInstances(modelRoot, new EePackageInPackage_c_test55041_c(getEepack_id())) ;

    if ( (  (objs55040.length) == 0) )
    {

      if (CorePlugin.getDefault().isDebugging()){
          Ooaofooa.log.println(ILogger.CONSISTENCY, "EE Package in Package", //$NON-NLS-1$
           "Consistency: Object: EE Package in Package: Cardinality of an identifier is zero. " //$NON-NLS-1$
           + "Actual Value: " + Integer.toString( objs55040.length ) ); //$NON-NLS-1$
      }
      else {
          Exception e = new Exception();
          CorePlugin.logError("Consistency: Object: EE Package in Package: Cardinality of an identifier is zero. " //$NON-NLS-1$ 
          + "Actual Value: " //$NON-NLS-1$
          + Integer.toString( objs55040.length )  , e); 
      }
      retval = false;

    }

    if ( (  (objs55040.length) > 1) )
    {

      if (CorePlugin.getDefault().isDebugging()){
          Ooaofooa.log.println(ILogger.CONSISTENCY, "EE Package in Package", //$NON-NLS-1$
           "Consistency: Object: EE Package in Package: Cardinality of an identifier is greater than 1. " //$NON-NLS-1$
           + "Actual Value: " //$NON-NLS-1$ 
           + Integer.toString( objs55040.length )  + " EEPack_ID: " + "Not Printable" ); //$NON-NLS-1$
      }
      else {
          Exception e = new Exception();
          CorePlugin.logError("Consistency: Object: EE Package in Package: Cardinality of an identifier is greater than 1. " //$NON-NLS-1$ 
          + "Actual Value: " //$NON-NLS-1$
          + Integer.toString( objs55040.length )  + " EEPack_ID: " + "Not Printable" , e); //$NON-NLS-1$
      }
      retval = false;

    }

          // EE Package in Package is a referring class in association: rel.Numb = 34
          // The participating class is: External Entity Package
    class ExternalEntityPackage_c_test55046_c implements ClassQueryInterface_c
    {
	  ExternalEntityPackage_c_test55046_c( java.util.UUID            p55047 ) {
	  m_p55047 = p55047;
	  }
	  private java.util.UUID             m_p55047; 
	  public boolean evaluate (Object candidate)
	  {
	      ExternalEntityPackage_c selected = (ExternalEntityPackage_c) candidate;
	      boolean retval = false;
	      retval = (selected.getEepack_id().equals(m_p55047));
	      return retval;
	  }
    }

    ExternalEntityPackage_c [] objs55045 = 
    ExternalEntityPackage_c.ExternalEntityPackageInstances(modelRoot, new ExternalEntityPackage_c_test55046_c(getEepack_id())) ;

          // The participant is unconditional
          // The multiplicity of the participant is one
    if ( (  (objs55045.length) != 1) )
    {

      if (CorePlugin.getDefault().isDebugging()){
          Ooaofooa.log.println(ILogger.CONSISTENCY, "EE Package in Package", //$NON-NLS-1$
           "Consistency: Object: EE Package in Package: Association: 34: Cardinality of a participant is not equal to 1. " //$NON-NLS-1$
           + "Actual Value: " //$NON-NLS-1$ 
           + Integer.toString( objs55045.length )  + " EEPack_ID: " + "Not Printable" ); //$NON-NLS-1$
      }
      else {
          Exception e = new Exception();
          CorePlugin.logError("Consistency: Object: EE Package in Package: Association: 34: Cardinality of a participant is not equal to 1. " //$NON-NLS-1$ 
          + "Actual Value: " //$NON-NLS-1$
          + Integer.toString( objs55045.length )  + " EEPack_ID: " + "Not Printable" , e); //$NON-NLS-1$
      }
      retval = false;

    }

          // EE Package in Package is a participating class in association: rel.Numb = 35
             // Object: External Entity Package
    return retval;
  }



  public Object getAdapter(Class adapter) {
    Object superAdapter = super.getAdapter(adapter);
    if(superAdapter != null) {
    	return superAdapter;
    }
	  return null;
  }
} // end EE Package in Package
