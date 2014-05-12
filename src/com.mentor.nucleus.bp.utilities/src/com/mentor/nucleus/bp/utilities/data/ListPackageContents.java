//========================================================================
//
//File:      com.mentor.nucleus.bp.utilities/src/com/mentor/nucleus/bp/utilities/actions/CheckModelIntegrity.java
//
//Copyright 2005-2014 Mentor Graphics Corporation. All rights reserved.
//
//========================================================================
// Licensed under the Apache License, Version 2.0 (the "License"); you may not 
// use this file except in compliance with the License.  You may obtain a copy 
// of the License at
//
//       http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software 
// distributed under the License is distributed on an "AS IS" BASIS, WITHOUT 
// WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.   See the 
// License for the specific language governing permissions and limitations under
// the License.
//======================================================================== 
package com.mentor.nucleus.bp.utilities.data;

import java.util.Collection;
import java.util.Iterator;
import java.util.Vector;

import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IActionDelegate;
import org.eclipse.ui.PlatformUI;

import com.mentor.nucleus.bp.core.Component_c;
import com.mentor.nucleus.bp.core.Package_c;
import com.mentor.nucleus.bp.core.PackageableElement_c;
import com.mentor.nucleus.bp.core.util.UIUtil;

public class ListPackageContents implements IActionDelegate {

	private ISelection selection;

	@Override
	public void run(IAction action) {
		IStructuredSelection ss = (IStructuredSelection) selection;
		Package_c pkg = null;
		for (Iterator<?> iterator = ss.iterator(); iterator.hasNext();) {
			Object element = iterator.next();
			if (element instanceof Package_c) {
				pkg = (Package_c) element;
				break;
			}
		}

		Shell shell = PlatformUI.getWorkbench().getDisplay().getActiveShell();

		if (null == pkg) {
			MessageBox mb = new MessageBox(shell);
			mb.setText("Error");
			mb.setMessage("Unable to show contents");
			mb.open();
			return;
		}

		StringBuilder contents = new StringBuilder();

		for (Object childName : getChildNamesOf(pkg, 0)) {
			contents.append(childName);
			contents.append("\n");
		}

		UIUtil.openScrollableTextDialog(shell, false, "Package Contents",
				contents.toString(), "Contents of " + pkg.getName(), "", "",
				true);
	}

	private String repeatTabs(int n) {
		String r = "";
		for (int i = 0; i < n; ++i) {
			r += "\t";
		}
		return r;
	}

	private Collection<String> getChildNamesOf(Package_c pkg, int level) {
		Vector<String> result = new Vector<String>();
		String prefix = repeatTabs(level) + "- ";

		Package_c[] subPkgs = Package_c
				.getManyEP_PKGsOnR8001(PackageableElement_c
						.getManyPE_PEsOnR8000(pkg));

		for (Package_c subPkg : subPkgs) {
			result.add(prefix + subPkg.getName());
			result.addAll(getChildNamesOf(subPkg, level + 1));
		}

		Component_c[] subComps = Component_c
				.getManyC_CsOnR8001(PackageableElement_c
						.getManyPE_PEsOnR8000(pkg));

		for (Component_c subComp : subComps) {
			result.add(prefix + subComp.getName());
		}

		return result;
	}

	@Override
	public void selectionChanged(IAction action, ISelection selection) {
		// cache the selection
		this.selection = selection;
	}

}
