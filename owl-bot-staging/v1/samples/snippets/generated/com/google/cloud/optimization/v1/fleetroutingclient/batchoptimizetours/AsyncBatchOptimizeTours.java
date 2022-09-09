/*
 * Copyright 2022 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.optimization.v1.samples;

// [START optimization_v1_generated_fleetroutingclient_batchoptimizetours_async]
import com.google.api.core.ApiFuture;
import com.google.cloud.optimization.v1.BatchOptimizeToursRequest;
import com.google.cloud.optimization.v1.FleetRoutingClient;
import com.google.longrunning.Operation;
import java.util.ArrayList;

public class AsyncBatchOptimizeTours {

  public static void main(String[] args) throws Exception {
    asyncBatchOptimizeTours();
  }

  public static void asyncBatchOptimizeTours() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (FleetRoutingClient fleetRoutingClient = FleetRoutingClient.create()) {
      BatchOptimizeToursRequest request =
          BatchOptimizeToursRequest.newBuilder()
              .setParent("parent-995424086")
              .addAllModelConfigs(new ArrayList<BatchOptimizeToursRequest.AsyncModelConfig>())
              .build();
      ApiFuture<Operation> future =
          fleetRoutingClient.batchOptimizeToursCallable().futureCall(request);
      // Do something.
      Operation response = future.get();
    }
  }
}
// [END optimization_v1_generated_fleetroutingclient_batchoptimizetours_async]
