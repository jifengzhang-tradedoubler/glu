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


package org.linkedin.glu.agent.rest.resources

import org.restlet.Context
import org.restlet.Request
import org.restlet.Response
import org.restlet.representation.Representation
import org.restlet.representation.Variant

/**
 * Handles resources to the agent directly (like the list of mount points)
 *
 * @author ypujante@linkedin.com
 */
class AgentResource extends BaseResource
{

  AgentResource(Context context, Request request, Response response)
  {
    super(context, request, response);
  }

  public boolean allowGet()
  {
    return true
  }

  public boolean allowPut()
  {
    return true
  }

  /**
   * GET: return the list of mount points
   */
  public Representation represent(Variant variant)
  {
    return noException {
      return toRepresentation([mountPoints: agent.getMountPoints()])
    }
  }

  /**
   * PUT: sync
   */
  public void storeRepresentation(Representation representation)
  {
    noException {
      agent.sync()
    }
  }

}
