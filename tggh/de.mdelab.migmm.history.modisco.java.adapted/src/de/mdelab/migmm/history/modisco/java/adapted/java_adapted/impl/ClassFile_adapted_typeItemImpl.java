/**
 */
package de.mdelab.migmm.history.modisco.java.adapted.java_adapted.impl;

import de.mdelab.migmm.history.impl.EdgeWithHistoryImpl;

import de.mdelab.migmm.history.modisco.java.adapted.java_adapted.AbstractTypeDeclaration_adapted;
import de.mdelab.migmm.history.modisco.java.adapted.java_adapted.ClassFile_adapted_typeItem;
import de.mdelab.migmm.history.modisco.java.adapted.java_adapted.Java_adaptedPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Class File adapted type Item</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.mdelab.migmm.history.modisco.java.adapted.java_adapted.impl.ClassFile_adapted_typeItemImpl#getType <em>Type</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ClassFile_adapted_typeItemImpl extends EdgeWithHistoryImpl implements ClassFile_adapted_typeItem {
	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected AbstractTypeDeclaration_adapted type;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ClassFile_adapted_typeItemImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Java_adaptedPackage.eINSTANCE.getClassFile_adapted_typeItem();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public AbstractTypeDeclaration_adapted getType() {
		if (type != null && type.eIsProxy()) {
			InternalEObject oldType = (InternalEObject)type;
			type = (AbstractTypeDeclaration_adapted)eResolveProxy(oldType);
			if (type != oldType) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, Java_adaptedPackage.CLASS_FILE_ADAPTED_TYPE_ITEM__TYPE, oldType, type));
			}
		}
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AbstractTypeDeclaration_adapted basicGetType() {
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setType(AbstractTypeDeclaration_adapted newType) {
		AbstractTypeDeclaration_adapted oldType = type;
		type = newType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Java_adaptedPackage.CLASS_FILE_ADAPTED_TYPE_ITEM__TYPE, oldType, type));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case Java_adaptedPackage.CLASS_FILE_ADAPTED_TYPE_ITEM__TYPE:
				if (resolve) return getType();
				return basicGetType();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case Java_adaptedPackage.CLASS_FILE_ADAPTED_TYPE_ITEM__TYPE:
				setType((AbstractTypeDeclaration_adapted)newValue);
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
			case Java_adaptedPackage.CLASS_FILE_ADAPTED_TYPE_ITEM__TYPE:
				setType((AbstractTypeDeclaration_adapted)null);
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
			case Java_adaptedPackage.CLASS_FILE_ADAPTED_TYPE_ITEM__TYPE:
				return type != null;
		}
		return super.eIsSet(featureID);
	}

} //ClassFile_adapted_typeItemImpl
