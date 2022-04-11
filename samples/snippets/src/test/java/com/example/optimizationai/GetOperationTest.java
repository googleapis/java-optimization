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

import com.google.cloud.optimization.v1.FleetRoutingClient;
import static com.google.common.truth.Truth.assertThat;
import com.google.protobuf.Duration;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/** Tests for GetOperation sample. */
public class GetOperationTest {
  private static final String PROJECT_ID = System.getenv("GOOGLE_CLOUD_PROJECT");
  private static final String PROJECT_PARENT = String.format("projects/%s", PROJECT_ID);

  private ByteArrayOutputStream bout;
  private PrintStream out;
  private PrintStream originalPrintStream;

  @Before
  public void setUp() {
    bout = new ByteArrayOutputStream();
    out = new PrintStream(bout);
    originalPrintStream = System.out;
    System.setOut(out);
  }

  @After
  public void tearDown() {
    System.out.flush();
    System.setOut(originalPrintStream);
  }

  @Test
  public void testSyncApi() throws Exception {
    FleetRoutingClient fleetRoutingClient = FleetRoutingClient.create()
    OptimizeToursRequest request =
        OptimizeToursRequest.newBuilder()
            .setParent(PROJECT_PARENT)
            .setTimeout(Duration.newBuilder().build())
            .build();
    OptimizeToursResponse response = fleetRoutingClient.batchOptimizeTours(request);

    GetOperation.getOperation(response.getInitialFuture().get().getName());
    String got = bout.toString();
    assertThat(got).contains("operations");
  }
}
