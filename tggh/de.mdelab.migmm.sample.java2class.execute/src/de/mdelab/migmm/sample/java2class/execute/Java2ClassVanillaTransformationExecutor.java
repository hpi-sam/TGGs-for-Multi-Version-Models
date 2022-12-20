package de.mdelab.migmm.sample.java2class.execute;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.modisco.java.emf.JavaPackage;

import de.hpi.sam.classDiagram.ClassDiagramPackage;
import de.mdelab.emf.util.EMFUtil;
import de.mdelab.mltgg.java2class.java2class.Java2classPackage;
import de.mdelab.mltgg.mote2.TransformationDirectionEnum;
import de.mdelab.mltgg.mote2.sdm.MoTE2Sdm;
import de.mdelab.mltgg.mote2.sdm.SdmOperationalTGG;

public class Java2ClassVanillaTransformationExecutor {
	
	public static void main(String[] args)  {
		if(args.length < 2) {
			System.out.println("2 arguments: inputModel, tggPath");
			return;
		}
		String inputModelPath = args[0];
		String tggPath = args[1];
		
		registerEPackages();

		warmup(inputModelPath, tggPath);
		
		long totalTime = 0;
		File modelDir = new File(inputModelPath);
		
		for(String modelFile:modelDir.list()) {
			System.out.println("STARTED LOADING TGG");
			SdmOperationalTGG tgg = (SdmOperationalTGG) loadEObject(tggPath);
			System.out.println("FINISHED LOADING TGG");
			
			System.out.println("STARTED LOADING MODEL " + modelFile);
			List<EObject> model = EMFUtil.loadMDELabModel(modelDir + "/" + modelFile);
			System.out.println("FINISHED LOADING MODEL");

			System.out.println("STARTING TRANSFORMATION");
			long start = System.nanoTime();
			final MoTE2Sdm engine = new MoTE2Sdm();
			engine.initRules(tgg);
			EList<EObject> leftElements = new BasicEList<EObject>();
			leftElements.addAll(model);
			EList<EObject> rightElements = new BasicEList<EObject>();
			engine.initModels(leftElements, rightElements);
			
			engine.transform(TransformationDirectionEnum.FORWARD, false, false, false, false, null);
			long end = System.nanoTime();
			System.out.println("TIME=" + (end - start) / 1000000);
			System.out.println("FINISHED TRANSFORMATION");
			totalTime += (end - start);
			
			System.out.println("STARTING WRITING MODEL");
			EMFUtil.writeMDELabModel(engine.getRightInputElements(),
						"instances/"
								+ inputModelPath.substring(inputModelPath.lastIndexOf('/')) + "_transformed"
								+ "/" + modelFile.substring(0, modelFile.lastIndexOf('.'))
								+ ".classDiagram");
			System.out.println("FINISHED WRITING MODEL");
		}
		
		System.out.println("TOTAL TIME=" +  totalTime / 1000000);
	}

	private static void warmup(String inputModelPath, String tggPath) {
		File modelDir = new File(inputModelPath);
		String modelFile = modelDir.list()[0];
		
		SdmOperationalTGG tgg = (SdmOperationalTGG) loadEObject(tggPath);

		List<EObject> model = EMFUtil.loadMDELabModel(modelDir + "/" + modelFile);
		
		final MoTE2Sdm engine = new MoTE2Sdm();
		engine.initRules(tgg);
		EList<EObject> leftElements = new BasicEList<EObject>();
		leftElements.addAll(model);
		EList<EObject> rightElements = new BasicEList<EObject>();
		engine.initModels(leftElements, rightElements);
		
		engine.transform(TransformationDirectionEnum.FORWARD, false, false, false, false, null);
	}

	private static void registerEPackages() {
		JavaPackage.eINSTANCE.getName();
		Java2classPackage.eINSTANCE.getName();
		ClassDiagramPackage.eINSTANCE.getName();

		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("history", new XMIResourceFactoryImpl());
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("mlsdm", new XMIResourceFactoryImpl());
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("mlsp", new XMIResourceFactoryImpl());
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("xmi", new XMIResourceFactoryImpl());
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
