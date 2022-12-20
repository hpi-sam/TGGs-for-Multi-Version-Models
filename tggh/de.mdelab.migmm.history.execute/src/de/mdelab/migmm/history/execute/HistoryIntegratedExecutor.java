package de.mdelab.migmm.history.execute;

import java.util.Collection;
import java.util.Collections;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

import de.mdelab.migmm.history.History;
import de.mdelab.migmm.history.merge.HistoryIdentityMerger;
import de.mdelab.mltgg.mote2.TransformationDirectionEnum;
import de.mdelab.mltgg.mote2.sdm.MoTE2Sdm;
import de.mdelab.mltgg.mote2.sdm.SdmOperationalTGG;

public class HistoryIntegratedExecutor {
	
	public MoTE2Sdm executeTransformation(History inputHistory,
			TransformationDirectionEnum direction, SdmOperationalTGG operationaTGG) {			
		final MoTE2Sdm engine = new MoTE2Sdm();
		engine.initRules(operationaTGG);
		EList<EObject> leftElements = new BasicEList<EObject>();
		EList<EObject> rightElements = new BasicEList<EObject>();
		if(direction == TransformationDirectionEnum.FORWARD) {
			leftElements.add(inputHistory);
		}
		else if(direction == TransformationDirectionEnum.BACKWARD){
			rightElements.add(inputHistory);
		}
		engine.initModels(leftElements, rightElements);
		
		engine.transform(direction, false, false, false, false, null);
		Collection<EObject> result = direction == TransformationDirectionEnum.FORWARD ? engine.getRightInputElements() : engine.getLeftInputElements();
			
		new HistoryIdentityMerger(direction).mergeElements(Collections.singleton(inputHistory), engine.getTggNodes().keySet(), result);
		
		return engine;
	}
}
