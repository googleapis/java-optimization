package com.example.optimizationai;

// [START cloudoptimization_async_api]
import com.google.api.gax.longrunning.OperationFuture;
import com.google.cloud.optimization.v1.AsyncModelMetadata;
import com.google.cloud.optimization.v1.BatchOptimizeToursRequest;
import com.google.cloud.optimization.v1.BatchOptimizeToursResponse;
import com.google.cloud.optimization.v1.FleetRoutingClient;
import com.google.protobuf.TextFormat;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

/**
 * This is an example to send a request to Cloud Fleet Routing asynchronous API via Java API Client.
 * A sample async_request_java.textproto file and a sample request_model_java.json file can be found
 * in the resources folder.
 */
public class AsyncAPI {
  // TODO(developer): Replace these variables before running the sample.
  private static final String PROJECT_PARENT = "projects/{YOUR_GCP_PROJECT_ID}";
  private static final String REQUEST_PATH = "async_request_java.textproto";

  public static void callAsyncAPI(String[] args) throws Exception {
    InputStream modelInputstream = new FileInputStream(REQUEST_PATH);
    Reader modelInputStreamReader = new InputStreamReader(modelInputstream);
    BatchOptimizeToursRequest.Builder requestBuilder =
        BatchOptimizeToursRequest.newBuilder().setParent(PROJECT_PARENT);
    TextFormat.getParser().merge(modelInputStreamReader, requestBuilder);
    FleetRoutingClient fleetRoutingClient = FleetRoutingClient.create();
    OperationFuture<BatchOptimizeToursResponse, AsyncModelMetadata> response =
        fleetRoutingClient.batchOptimizeToursAsync(requestBuilder.build());
    System.out.format("the response name: %s\n", response.getInitialFuture().get().getName());

    // Block to wait for the job to finish.
    response.getPollingFuture().get();
    if (response.getMetadata().get().getState() == AsyncModelMetadata.State.SUCCEEDED) {
      // Code to do your stuff
    } else {
      System.out.println(
          "Job failed with message:" + response.getPollingFuture().get().getErrorMessage());
    }
  }
}
// [END cloudoptimization_async_api]
