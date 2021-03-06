package com.mentor.nucleus.bp.core.ui;
//====================================================================
//
// File:    CommunicationFunctionFormalizeOnMSG_SMWizard.java
//
// WARNING: Do not edit this generated file
// Generated by arc/wizard.inc
//
// (c) Copyright 2003-2014 Mentor Graphics Corporation  All rights reserved.
//
//====================================================================
import java.util.Iterator;

import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.StructuredViewer;
import org.eclipse.jface.wizard.*;
import org.eclipse.ui.IWorkbench;

import com.mentor.nucleus.bp.core.*;
import com.mentor.nucleus.bp.core.common.*;
import com.mentor.nucleus.bp.core.util.TransactionUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * CommunicationFunctionFormalizeOnMSG_SMWizard class
 */
public class CommunicationFunctionFormalizeOnMSG_SMWizard extends Wizard {
	public static final String copyright = "(c) Copyright 2003-2014 Mentor Graphics Corporation  All rights reserved.";

	// workbench selection when the wizard was started
	protected IStructuredSelection m_selection;

	// the workbench instance
	protected IWorkbench m_workbench;

	// the viewer the wizard was started from. This must be replaced with a listener system
	protected Viewer m_viewer;

	// Pages stack
	protected Stack m_pagesStack = new Stack();

	// wizard pages
	CommunicationFunctionFormalizeOnMSG_SMWizardPage4 MSG_SM_CommunicationFunctionFormalizePage4;

	// wizard state
	// constants
	protected static final int INITIAL_WIZARD_STATE = -1;
	protected static final int MSG_SM_COMMUNICATIONFUNCTIONFORMALIZE0_WIZARD_STATE = 0;
	// member
	protected int m_state = INITIAL_WIZARD_STATE;
	// end wizard state

	// cache for contextual selections (public for use by unit tests)
	public SynchronousMessage_c v_syncMessage = null;
	public FunctionPackageParticipant_c v_fpp = null;

	// cache for the users selections (public for use by unit tests)
	public Function_c v_Message = null;

	/**
	 * Constructor for CommunicationFunctionFormalizeOnMSG_SMWizard.
	 */
	public CommunicationFunctionFormalizeOnMSG_SMWizard() {
		super();
	}

	/**
	 * See field.
	 */
	public IStructuredSelection getSelection() {
		return m_selection;
	}

	public void addPages() {
		MSG_SM_CommunicationFunctionFormalizePage4 = new CommunicationFunctionFormalizeOnMSG_SMWizardPage4(
				"CommunicationFunctionFormalizeOnMSG_SMWizardPage4");
		addPage(MSG_SM_CommunicationFunctionFormalizePage4);
	}

	/**
	 * @see IWorkbenchWizard#init(IWorkbench, IStructuredSelection)
	 */
	public void init(IWorkbench workbench, IStructuredSelection selection,
			Viewer viewer) {
		this.m_workbench = workbench;
		this.m_selection = selection;
		this.m_viewer = viewer;
		for (Iterator iterator = selection.iterator(); iterator.hasNext();) {
			Object context = iterator.next();
			if (context instanceof SynchronousMessage_c) {
				v_syncMessage = (SynchronousMessage_c) context;
			}
			if (context instanceof FunctionPackageParticipant_c) {
				v_fpp = (FunctionPackageParticipant_c) context;
			}
		}
	}

	public boolean canFinish() {
		boolean pagesComplete = true;
		pagesComplete = pagesComplete
				&& MSG_SM_CommunicationFunctionFormalizePage4.isPageComplete();
		return pagesComplete;
	}

	public IWizardPage getNextPage(IWizardPage page) {
		List pages = new ArrayList(getPages().length);
		for (int i = 0; i < getPages().length; i++) {
			pages.add(getPages()[i]);
		}
		switch (pages.indexOf(page)) {
			case MSG_SM_COMMUNICATIONFUNCTIONFORMALIZE0_WIZARD_STATE :
				return null;
		}
		return null;
	}

	public IWizardPage getPreviousPage(IWizardPage page) {
		if (m_pagesStack.empty()) {
			return null;
		} else {
			List pages = new ArrayList(getPages().length);
			for (int i = 0; i < getPages().length; i++) {
				pages.add(getPages()[i]);
			}
			m_state = pages.indexOf((IWizardPage) m_pagesStack.peek());
			((PtWizardPage) m_pagesStack.peek()).onPageEntry();
			return (IWizardPage) m_pagesStack.pop();
		}
	}

	public boolean performFinish() {
		TransactionUtil.TransactionGroup transactionGroup = null;
		ModelRoot modelRoot = v_fpp.getModelRoot();
		try {
			transactionGroup = TransactionUtil
					.startTransactionsOnSelectedModelRoots("Communication Function Formalize"); //$NON-NLS-1$
			if (((v_syncMessage != null))) {

				Function_c v_function = Function_c
						.getOneS_SYNCOnR1010(FunctionMessage_c
								.getOneMSG_FOnR1020(v_syncMessage));

				if (((v_fpp != null))) {

					java.util.UUID v_existingId = Gd_c.Null_unique_id();

					if (((v_function != null))) {

						v_existingId = v_function.getSync_id();

					}

					Message_c v_message = Message_c
							.getOneMSG_MOnR1018(v_syncMessage);

					InteractionParticipant_c v_participant = InteractionParticipant_c
							.getOneSQ_POnR930(v_fpp);

					if (v_message != null) {
						v_message.relateAcrossR1007To(v_participant);
					} else {
						Throwable t = new Throwable();
						t.fillInStackTrace();
						CorePlugin.logError(
								"Relate attempted on null left hand instance.",
								t);
					}

					FunctionPackage_c v_fpk = FunctionPackage_c
							.getOneS_FPKOnR932(v_fpp);

					if (((v_fpk != null))) {

						if (v_syncMessage != null) {
							v_syncMessage.Formalizewithfunction(v_Message
									.getSync_id());
						} else {
							Throwable t = new Throwable();
							t.fillInStackTrace();
							CorePlugin
									.logError(
											"Attempted to call an operation on a null instance.",
											t);
						}

						Sel_c.Clearselection();

					}

				}

			}

			// catch all exceptions and cancel the transaction
		} catch (Exception e) {
			if (transactionGroup != null)
				TransactionUtil.cancelTransactions(transactionGroup, e);
			CorePlugin.logError(
					"Transaction: Communication Function Formalize failed", e);//$NON-NLS-1$
			// return true so that the wizard will
			// close
			return true;
		}
		if (transactionGroup != null)
			TransactionUtil.endTransactions(transactionGroup);
		if (m_viewer != null) {
			if (m_viewer instanceof StructuredViewer) {
				((StructuredViewer) m_viewer).refresh(v_fpp);
			} else {
				m_viewer.refresh();
			}
		}
		return true;
	}
}
