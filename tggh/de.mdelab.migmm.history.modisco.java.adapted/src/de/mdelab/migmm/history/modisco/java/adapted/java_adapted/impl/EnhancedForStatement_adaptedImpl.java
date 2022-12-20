/**
 */
package de.mdelab.migmm.history.modisco.java.adapted.java_adapted.impl;

import de.mdelab.migmm.history.modisco.java.adapted.java_adapted.EnhancedForStatement_adapted;
import de.mdelab.migmm.history.modisco.java.adapted.java_adapted.EnhancedForStatement_adapted_bodyItem;
import de.mdelab.migmm.history.modisco.java.adapted.java_adapted.EnhancedForStatement_adapted_expressionItem;
import de.mdelab.migmm.history.modisco.java.adapted.java_adapted.EnhancedForStatement_adapted_parameterItem;
import de.mdelab.migmm.history.modisco.java.adapted.java_adapted.Java_adaptedPackage;

import java.util.Collection;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Enhanced For Statement adapted</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.mdelab.migmm.history.modisco.java.adapted.java_adapted.impl.EnhancedForStatement_adaptedImpl#getBody <em>Body</em>}</li>
 *   <li>{@link de.mdelab.migmm.history.modisco.java.adapted.java_adapted.impl.EnhancedForStatement_adaptedImpl#getExpression <em>Expression</em>}</li>
 *   <li>{@link de.mdelab.migmm.history.modisco.java.adapted.java_adapted.impl.EnhancedForStatement_adaptedImpl#getParameter <em>Parameter</em>}</li>
 * </ul>
 *
 * @generated
 */
public class EnhancedForStatement_adaptedImpl extends Statement_adaptedImpl implements EnhancedForStatement_adapted {
	/**
	 * The cached value of the '{@link #getBody() <em>Body</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBody()
	 * @generated
	 * @ordered
	 */
	protected EList<EnhancedForStatement_adapted_bodyItem> body;

	/**
	 * The cached value of the '{@link #getExpression() <em>Expression</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExpression()
	 * @generated
	 * @ordered
	 */
	protected EList<EnhancedForStatement_adapted_expressionItem> expression;

	/**
	 * The cached value of the '{@link #getParameter() <em>Parameter</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParameter()
	 * @generated
	 * @ordered
	 */
	protected EList<EnhancedForStatement_adapted_parameterItem> parameter;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EnhancedForStatement_adaptedImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Java_adaptedPackage.eINSTANCE.getEnhancedForStatement_adapted();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<EnhancedForStatement_adapted_bodyItem> getBody() {
		if (body == null) {
			body = new EObjectResolvingEList<EnhancedForStatement_adapted_bodyItem>(EnhancedForStatement_adapted_bodyItem.class, this, Java_adaptedPackage.ENHANCED_FOR_STATEMENT_ADAPTED__BODY);
		}
		return body;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<EnhancedForStatement_adapted_expressionItem> getExpression() {
		if (expression == null) {
			expression = new EObjectResolvingEList<EnhancedForStatement_adapted_expressionItem>(EnhancedForStatement_adapted_expressionItem.class, this, Java_adaptedPackage.ENHANCED_FOR_STATEMENT_ADAPTED__EXPRESSION);
		}
		return expression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<EnhancedForStatement_adapted_parameterItem> getParameter() {
		if (parameter == null) {
			parameter = new EObjectResolvingEList<EnhancedForStatement_adapted_parameterItem>(EnhancedForStatement_adapted_parameterItem.class, this, Java_adaptedPackage.ENHANCED_FOR_STATEMENT_ADAPTED__PARAMETER);
		}
		return parameter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case Java_adaptedPackage.ENHANCED_FOR_STATEMENT_ADAPTED__BODY:
				return getBody();
			case Java_adaptedPackage.ENHANCED_FOR_STATEMENT_ADAPTED__EXPRESSION:
				return getExpression();
			case Java_adaptedPackage.ENHANCED_FOR_STATEMENT_ADAPTED__PARAMETER:
				return getParameter();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case Java_adaptedPackage.ENHANCED_FOR_STATEMENT_ADAPTED__BODY:
				getBody().clear();
				getBody().addAll((Collection<? extends EnhancedForStatement_adapted_bodyItem>)newValue);
				return;
			case Java_adaptedPackage.ENHANCED_FOR_STATEMENT_ADAPTED__EXPRESSION:
				getExpression().clear();
				getExpression().addAll((Collection<? extends EnhancedForStatement_adapted_expressionItem>)newValue);
				return;
			case Java_adaptedPackage.ENHANCED_FOR_STATEMENT_ADAPTED__PARAMETER:
				getParameter().clear();
				getParameter().addAll((Collection<? extends EnhancedForStatement_adapted_parameterItem>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case Java_adaptedPackage.ENHANCED_FOR_STATEMENT_ADAPTED__BODY:
				getBody().clear();
				return;
			case Java_adaptedPackage.ENHANCED_FOR_STATEMENT_ADAPTED__EXPRESSION:
				getExpression().clear();
				return;
			case Java_adaptedPackage.ENHANCED_FOR_STATEMENT_ADAPTED__PARAMETER:
				getParameter().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case Java_adaptedPackage.ENHANCED_FOR_STATEMENT_ADAPTED__BODY:
				return body != null && !body.isEmpty();
			case Java_adaptedPackage.ENHANCED_FOR_STATEMENT_ADAPTED__EXPRESSION:
				return expression != null && !expression.isEmpty();
			case Java_adaptedPackage.ENHANCED_FOR_STATEMENT_ADAPTED__PARAMETER:
				return parameter != null && !parameter.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //EnhancedForStatement_adaptedImpl
