/*
 * Copyright (c) 2010-2010 LinkedIn, Inc
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

package org.linkedin.glu.provisioner.plan.api;

/**
 * @author ypujante@linkedin.com
 */
public interface IStepCompletionStatusVisitor<T>
{
  /**
   * Called on visit start
   */
  void startVisit();

  /**
   * Visits status of a leaf step.
   */
  void visitLeafStepStatus(IStepCompletionStatus<T> status);

  /**
   * Visit status of a sequential step.
   *
   * @return <code>null</code> if you want to stop the recursion, otherwise another visitor
   */
  IStepCompletionStatusVisitor<T> visitSequentialStepStatus(IStepCompletionStatus<T> status);

  /**
   * Visit status a parallel step.
   *
   * @return <code>null</code> if you want to stop the recursion, otherwise another visitor
   */
  IStepCompletionStatusVisitor<T> visitParallelStepStatus(IStepCompletionStatus<T> status);

  /**
   * Called on visit end
   */
  void endVisit();
}