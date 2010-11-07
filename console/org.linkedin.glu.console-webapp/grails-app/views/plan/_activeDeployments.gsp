%{--
  - Copyright 2010-2010 LinkedIn, Inc
  -
  - Licensed under the Apache License, Version 2.0 (the "License"); you may not
  - use this file except in compliance with the License. You may obtain a copy of
  - the License at
  -
  - http://www.apache.org/licenses/LICENSE-2.0
  -
  - Unless required by applicable law or agreed to in writing, software
  - distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
  - WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
  - License for the specific language governing permissions and limitations under
  - the License.
  --}%

<h2>Active deployments [${deployments?.size()}]</h2>
<g:if test="${deployments}">
<table id="activeDeployments">
  <tr>
    <th class="descriptionFilter">Description</th>
    <th class="usernameFilter">Username</th>
    <th class="startTimeFilter">Start Time</th>
    <th class="durationFilter">Duration</th>
    <th>Steps</th>
    <th>Progress</th>
  </tr>
  <g:each in="${deployments}" var="deployment">
    <g:set var="planExecution" value="${deployment.planExecution}"/>
    <tr class="${planExecution.completionStatus?.status ?: 'RUNNING'}">
      <td class="descriptionFilter"><g:link action="deployments" id="${deployment.id}">${deployment.description}</g:link></td>
      <td class="usernameFilter">${deployment.username}</td>
      <td class="startTimeFilter"><cl:formatDate date="${new Date(deployment.progressTracker.planStartTime)}"/></td>
      <td class="durationFilter"><cl:formatDuration duration="${planExecution.duration}"/></td>
      <td>${deployment.progressTracker.leafStepsCompletedCount}/${deployment.planExecution.plan.leafStepsCount}</td>
      <td><g:render template="progress" model="[deployment: deployment]"/></td>
    </tr>
  </g:each>
</table>
</g:if>
<g:else>
  <h3>No active deployments...</h3>
</g:else>
