/*
 * Copyright 2010-2010 LinkedIn, Inc
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

package org.linkedin.glu.provisioner.core.model

/**
 * Flatten the entry ({@link SystemEntry#flatten()}) and use <code>name</code> as a key in the
 * flattened map (this filter is expensive!).
 * 
 * @author ypujante@linkedin.com */
class FlattenSystemFilter extends NameEqualsValueSystemFilter
{
  String getKind()
  {
    return 'f';
  }

  def boolean filter(SystemEntry entry)
  {
    return entry.flatten()."${name}" == value
  }
}
