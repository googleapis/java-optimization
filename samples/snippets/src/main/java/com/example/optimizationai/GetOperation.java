/*
 * Copyright 2022 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.optimizationai;

// [START cloudoptimization_get_operation]
import com.google.cloud.optimization.v1.FleetRoutingClient;
import com.google.longrunning.Operation;
import java.io.IOException;

class GetOperation {

  static void getOperation() throws IOException {
    // TODO(developer): Replace these variables before running the sample.
    String operationFullId = "projects/[projectId]/operations/[operationId]";
    getOperation(operationFullId);
  }

  // Get the status of an operation
  static void getOperation(String operationFullId) throws IOException {
    // Initialize client that will be used to send requests. This client only needs to be created
    // once, and can be reused for multiple requests. After completing all of your requests, call
    // the "close" method on the client to safely clean up any remaining background resources.
    try (FleetRoutingClient client = FleetRoutingClient.create()) {
      // Get the latest state of a long-running operation.
      Operation operation = client.getOperationsClient().getOperation(operationFullId);

      // Display operation details.
      System.out.println("Operation details:");
      System.out.format("\tName: %s\n", operation.getName());
      System.out.format("\tMetadata Type Url: %s\n", operation.getMetadata().getTypeUrl());
      System.out.format("\tDone: %s\n", operation.getDone());
      if (operation.hasResponse()) {
        System.out.format("\tResponse Type Url: %s\n", operation.getResponse().getTypeUrl());
      }
      if (operation.hasError()) {
        System.out.println("\tResponse:");
        System.out.format("\t\tError code: %s\n", operation.getError().getCode());
        System.out.format("\t\tError message: %s\n", operation.getError().getMessage());
      }
    }
  }
}
// [END cloudoptimization_get_operation]
