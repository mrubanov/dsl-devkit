/*******************************************************************************
 * Copyright (c) 2016 Avaloq Evolution AG and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Avaloq Evolution AG - initial API and implementation
 *******************************************************************************/
package com.avaloq.tools.ddk.check.ui.wizard;

import org.eclipse.core.runtime.IPath;
import org.eclipse.xtext.generator.JavaIoFileSystemAccess;

import com.google.inject.Inject;
import com.google.inject.Singleton;


/**
 * The Class CheckFileGeneratorUtil.
 */
@Singleton
public class CheckCatalogGenerator {

  @Inject
  private CheckQuickfixProvider quickfixProvider;

  @Inject
  private CheckNewProject newProject;

  @Inject
  private JavaIoFileSystemAccess fsa;

  /**
   * Generates a check file. Calls an Xpand template.
   *
   * @param path
   *          the path used for the output file destination
   * @param projectInfo
   *          the project info
   */
  public void generateCheckFile(final IPath path, final CheckProjectInfo projectInfo) {
    fsa.setOutputPath(path.toOSString());
    newProject.doGenerate(projectInfo, fsa);
  }

  /**
   * Generates a default quickfix provider.
   *
   * @param path
   *          the path
   * @param projectInfo
   *          the project info
   */
  public void generateDefaultQuickfixProvider(final IPath path, final CheckProjectInfo projectInfo) {
    fsa.setOutputPath(path.toOSString());
    quickfixProvider.doGenerate(projectInfo, fsa);
  }

}

