/**
 */
package de.mdelab.migmm.history.modisco.java.adapted.java_adapted.impl;

import de.mdelab.migmm.history.impl.ContainmentEdgeWithHistoryImpl;
import de.mdelab.migmm.history.modisco.java.adapted.java_adapted.Annotation_adapted;
import de.mdelab.migmm.history.modisco.java.adapted.java_adapted.BodyDeclaration_adapted_annotationsItem;
import de.mdelab.migmm.history.modisco.java.adapted.java_adapted.Java_adaptedPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Body Declaration adapted annotations Item</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.mdelab.migmm.history.modisco.java.adapted.java_adapted.impl.BodyDeclaration_adapted_annotationsItemImpl#getAnnotations <em>Annotations</em>}</li>
 * </ul>
 *
 * @generated
 */
public class BodyDeclaration_adapted_annotationsItemImpl extends ContainmentEdgeWithHistoryImpl implements BodyDeclaration_adapted_annotationsItem {
	/**
	 * The cached value of the '{@link #getAnnotations() <em>Annotations</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAnnotations()
	 * @generated
	 * @ordered
	 */
	protected Annotation_adapted annotations;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BodyDeclaration_adapted_annotationsItemImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Java_adaptedPackage.eINSTANCE.getBodyDeclaration_adapted_annotationsItem();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Annotation_adapted getAnnotations() {
		if (annotations != null && annotations.eIsProxy()) {
			InternalEObject oldAnnotations = (InternalEObject)annotations;
			annotations = (Annotation_adapted)eResolveProxy(oldAnnotations);
			if (annotations != oldAnnotations) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, Java_adaptedPackage.BODY_DECLARATION_ADAPTED_ANNOTATIONS_ITEM__ANNOTATIONS, oldAnnotations, annotations));
			}
		}
		return annotations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Annotation_adapted basicGetAnnotations() {
		return annotations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setAnnotations(Annotation_adapted newAnnotations) {
		Annotation_adapted oldAnnotations = annotations;
		annotations = newAnnotations;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Java_adaptedPackage.BODY_DECLARATION_ADAPTED_ANNOTATIONS_ITEM__ANNOTATIONS, oldAnnotations, annotations));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case Java_adaptedPackage.BODY_DECLARATION_ADAPTED_ANNOTATIONS_ITEM__ANNOTATIONS:
				if (resolve) return getAnnotations();
				return basicGetAnnotations();
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
			case Java_adaptedPackage.BODY_DECLARATION_ADAPTED_ANNOTATIONS_ITEM__ANNOTATIONS:
				setAnnotations((Annotation_adapted)newValue);
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
			case Java_adaptedPackage.BODY_DECLARATION_ADAPTED_ANNOTATIONS_ITEM__ANNOTATIONS:
				setAnnotations((Annotation_adapted)null);
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
			case Java_adaptedPackage.BODY_DECLARATION_ADAPTED_ANNOTATIONS_ITEM__ANNOTATIONS:
				return annotations != null;
		}
		return super.eIsSet(featureID);
	}

} //BodyDeclaration_adapted_annotationsItemImpl
