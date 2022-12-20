package de.mdelab.migmm.history.execute;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

import de.mdelab.migmm.history.TimingUnit;
import de.mdelab.migmm.history.projection.HistoryProjector;
import de.mdelab.mltgg.mote2.TransformationDirectionEnum;
import de.mdelab.mltgg.mote2.sdm.MoTE2Sdm;
import de.mdelab.mltgg.mote2.sdm.SdmOperationalTGG;

public class HistoryProjectionExecutor {

	private HistoryProjector projector;

	public HistoryProjectionExecutor() {
		this.projector = new HistoryProjector();
	}
	
	public Map<TimingUnit, Collection<EObject>> executeTransformation(Collection<EObject> inputElements,
			TransformationDirectionEnum direction, Collection<TimingUnit> timingUnits,
			SdmOperationalTGG operationaTGG) {
		Map<TimingUnit, Collection<EObject>> transformed = new HashMap<TimingUnit, Collection<EObject>>();
		
		for(TimingUnit t:timingUnits) {
			projector.project(t, inputElements);
			
			final MoTE2Sdm engine = new MoTE2Sdm();
			engine.initRules(operationaTGG);
			EList<EObject> leftElements = new BasicEList<EObject>();
			EList<EObject> rightElements = new BasicEList<EObject>();
			if(direction == TransformationDirectionEnum.FORWARD) {
				leftElements.addAll(inputElements);
			}
			else if(direction == TransformationDirectionEnum.BACKWARD){
				rightElements.addAll(inputElements);
			}
			engine.initModels(leftElements, rightElements);
			
			engine.transform(direction, false, false, false, false, null);
			Collection<EObject> result = direction == TransformationDirectionEnum.FORWARD ? engine.getRightInputElements() : engine.getLeftInputElements();
			transformed.put(t, result);
			
			projector.unproject(inputElements);	
		}
		
		return transformed;
	}
}
