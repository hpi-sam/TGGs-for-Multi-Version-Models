package de.mdelab.migmm.sample.java2class.execute;

import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

import de.hpi.sam.classDiagram_adapted.ClassDiagram_adaptedPackage;
import de.mdelab.emf.util.EMFUtil;
import de.mdelab.migmm.history.History;
import de.mdelab.migmm.history.HistoryPackage;
import de.mdelab.migmm.history.TimingUnit;
import de.mdelab.migmm.history.execute.HistoryIntegratedExecutor;
import de.mdelab.migmm.history.execute.conflict.Conflict;
import de.mdelab.migmm.history.execute.conflict.HistoryConflictDetector;
import de.mdelab.migmm.history.execute.conflict.Tuple;
import de.mdelab.migmm.history.modisco.java.adapted.java_adapted.Java_adaptedPackage;
import de.mdelab.migmm.history.timing.TimingPackage;
import de.mdelab.migmm.java2class_adapted.Java2class_adaptedPackage;
import de.mdelab.mlsdm.interpreter.searchModel.patternMatcher.MLSDMReferenceIndex;
import de.mdelab.mltgg.mote2.TGGNode;
import de.mdelab.mltgg.mote2.TransformationDirectionEnum;
import de.mdelab.mltgg.mote2.sdm.MoTE2Sdm;
import de.mdelab.mltgg.mote2.sdm.SdmOperationalTGG;
import tggh.TGGNodeWithHistory;

public class Java2ClassHistoryTransformationExecutor {

	public static void main(String[] args)  {
		if(args.length < 2) {
			System.out.println("2 arguments: inputModel, tggPath");
			return;
		}
		String inputModelPath = args[0];
		String tggPath = args[1];
		
		registerEPackages();
		
		warmup(inputModelPath, tggPath);
		
		System.out.println("STARTED LOADING MODEL");
		History inputModel = (History) EMFUtil.loadMDELabModel(inputModelPath).get(0);
		System.out.println("FINISHED LOADING MODEL");
		
		System.out.println("STARTED LOADING TGG");
		SdmOperationalTGG tgg = loadTGG(tggPath);
		System.out.println("FINISHED LOADING TGG");
		
		System.out.println("STARTING TRANSFORMATION");
		long start = System.nanoTime();
		HistoryIntegratedExecutor executor = new HistoryIntegratedExecutor();
		MoTE2Sdm engine = executor.executeTransformation(inputModel, TransformationDirectionEnum.FORWARD, tgg);
		long end = System.nanoTime();
		System.out.println("FINISHED TRANSFORMATION");
		System.out.println("TIME=" + (end - start) / 1000000);

		System.out.println("STARTING WRITING MODEL");
		EMFUtil.writeMDELabModel(engine.getRightInputElements(), "instances/" + inputModelPath.substring(inputModelPath.lastIndexOf('/') + 1, inputModelPath.lastIndexOf('.')) + "_transformed.history");
		System.out.println("FINISHED WRITING MODEL");
		
		long[] coverageCounts = countCoverages(engine.getTggNodes().keySet());
		System.out.println("COVERAGE HISTOGRAM");
		for(int i = 0; i < coverageCounts.length; i++) {
			System.out.println(i + ";" + coverageCounts[i]);
		}
		
//		System.out.println("STARTING REFERENCE INDEX CREATION");
//		MLSDMReferenceIndex referenceIndex = new MLSDMReferenceIndex();
//		referenceIndex.registerEObjects(engine.getLeftInputElements());
//		referenceIndex.registerEObjects(engine.getRightInputElements());
//		referenceIndex.registerEObjects(new ArrayList<EObject>(engine.getTggNodes().keySet()));
//		System.out.println("FINISHED REFERENCE INDEX CREATION");
//
//		System.out.println("STARTING CONFLICT DETECTION");
//		HistoryConflictDetector conflictDetector = new HistoryConflictDetector(referenceIndex);
//		Collection<Conflict> conflicts = conflictDetector.getConflicts();
//		for(Conflict conflict:conflicts) {
//			Iterator<Tuple<TimingUnit, TimingUnit>> it = conflict.getConflictPairs();
//			while(it.hasNext()) {
//				System.out.println(it.next());
//			}
//		}
//		System.out.println("FINISHED CONFLICT DETECTION");
	}

	private static void warmup(String inputModelPath, String tggPath) {
		History inputModel = (History) EMFUtil.loadMDELabModel(inputModelPath).get(0);
		
		SdmOperationalTGG tgg = loadTGG(tggPath);
		
		HistoryIntegratedExecutor executor = new HistoryIntegratedExecutor();
		MoTE2Sdm engine = executor.executeTransformation(inputModel, TransformationDirectionEnum.FORWARD, tgg);
		
		engine.getRightInputElements();
	}

	private static long[] countCoverages(Set<TGGNode> tggNodes) {
		Map<TGGNode, Integer> coveredVersions = new HashMap<TGGNode, Integer>();
		int maxCoverage = 0;
		for(TGGNode node:tggNodes) {
			int coverage = ((TGGNodeWithHistory) node).getValidIn().getPresentTiming().size();
			maxCoverage = maxCoverage > coverage ? maxCoverage : coverage;
			coveredVersions.put(node, coverage);
		}
		
		long[] coverages = new long[maxCoverage + 1];
		for(int i = 0; i < maxCoverage + 1; i++) {
			coverages[i] = 0;
		}
		
		for(Entry<TGGNode, Integer> e:coveredVersions.entrySet()) {
			coverages[e.getValue()] = coverages[e.getValue()] + 1;
		}
		return coverages;
	}

	private static void registerEPackages() {
		HistoryPackage.eINSTANCE.getName();
		TimingPackage.eINSTANCE.getName();
		Java_adaptedPackage.eINSTANCE.getName();
		Java2class_adaptedPackage.eINSTANCE.getName();
		ClassDiagram_adaptedPackage.eINSTANCE.getName();

		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("history", new XMIResourceFactoryImpl());
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("mlsdm", new XMIResourceFactoryImpl());
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("mlsp", new XMIResourceFactoryImpl());
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("xmi", new XMIResourceFactoryImpl());
	}

	private static SdmOperationalTGG loadTGG(String inputModelPath) {
		ResourceSet rs = new ResourceSetImpl();
		Resource r = rs.createResource(URI.createFileURI(inputModelPath));
		try {
			r.load(null);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return (SdmOperationalTGG) r.getContents().get(0);
	}

	private static EObject loadEObject(String inputModelPath) {
		ResourceSet rs = new ResourceSetImpl();
		Resource r = rs.createResource(URI.createFileURI(inputModelPath));
		try {
			r.load(null);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return r.getContents().get(0);
	}
	
}
