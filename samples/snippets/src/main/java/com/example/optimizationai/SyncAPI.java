package com.example.optimizationai;

// [START cloudoptimization_sync_api]

import com.google.cloud.optimization.v1.FleetRoutingClient;
import com.google.cloud.optimization.v1.OptimizeToursRequest;
import com.google.cloud.optimization.v1.OptimizeToursResponse;
import com.google.protobuf.Duration;
import com.google.protobuf.TextFormat;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

/**
 * This is an example to send a request to Cloud Fleet Routing synchronous API via Java API Client.
 * A sample sync_request.textproto file can be found in the resources folder.
 */
public class SyncAPI {
  public static void callSyncAPI() throws Exception {
    // TODO(developer): Replace these variables before running the sample.
    private static final String PROJECT_PARENT = "projects/{YOUR_GCP_PROJECT_ID}";
    private static final String MODEL_PATH = "YOUR_MODEL_PATH";
    callSyncAPI(PROJECT_PARENT, MODEL_PATH);
  }

  public static void callSyncAPI(String projectId, String modelPath) throws Exception {
    private static int TIMEOUT_SECONDS = 100;
    InputStream modelInputstream = new FileInputStream(modelPath);
    Reader modelInputStreamReader = new InputStreamReader(modelInputstream);
    OptimizeToursRequest.Builder requestBuilder =
        OptimizeToursRequest.newBuilder()
            .setTimeout(Duration.newBuilder().setSeconds(TIMEOUT_SECONDS).build())
            .setParent(PROJECT_PARENT);
    TextFormat.getParser().merge(modelInputStreamReader, requestBuilder);
    FleetRoutingClient fleetRoutingClient = FleetRoutingClient.create();
    OptimizeToursResponse response = fleetRoutingClient.optimizeTours(requestBuilder.build());
    System.out.println(response.toString());
  }
}
// [END cloudoptimization_sync_api]
