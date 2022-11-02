// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: google/cloud/optimization/v1/fleet_routing.proto

package com.google.cloud.optimization.v1;

public interface OptimizeToursRequestOrBuilder extends
    // @@protoc_insertion_point(interface_extends:google.cloud.optimization.v1.OptimizeToursRequest)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <pre>
   * Required. Target project and location to make a call.
   * Format: `projects/{project-id}/locations/{location-id}`.
   * If no location is specified, a region will be chosen automatically.
   * </pre>
   *
   * <code>string parent = 1 [(.google.api.field_behavior) = REQUIRED];</code>
   * @return The parent.
   */
  java.lang.String getParent();
  /**
   * <pre>
   * Required. Target project and location to make a call.
   * Format: `projects/{project-id}/locations/{location-id}`.
   * If no location is specified, a region will be chosen automatically.
   * </pre>
   *
   * <code>string parent = 1 [(.google.api.field_behavior) = REQUIRED];</code>
   * @return The bytes for parent.
   */
  com.google.protobuf.ByteString
      getParentBytes();

  /**
   * <pre>
   * If this timeout is set, the server returns a response before the timeout
   * period has elapsed or the server deadline for synchronous requests is
   * reached, whichever is sooner.
   * For asynchronous requests, the server will generate a solution (if
   * possible) before the timeout has elapsed.
   * </pre>
   *
   * <code>.google.protobuf.Duration timeout = 2;</code>
   * @return Whether the timeout field is set.
   */
  boolean hasTimeout();
  /**
   * <pre>
   * If this timeout is set, the server returns a response before the timeout
   * period has elapsed or the server deadline for synchronous requests is
   * reached, whichever is sooner.
   * For asynchronous requests, the server will generate a solution (if
   * possible) before the timeout has elapsed.
   * </pre>
   *
   * <code>.google.protobuf.Duration timeout = 2;</code>
   * @return The timeout.
   */
  com.google.protobuf.Duration getTimeout();
  /**
   * <pre>
   * If this timeout is set, the server returns a response before the timeout
   * period has elapsed or the server deadline for synchronous requests is
   * reached, whichever is sooner.
   * For asynchronous requests, the server will generate a solution (if
   * possible) before the timeout has elapsed.
   * </pre>
   *
   * <code>.google.protobuf.Duration timeout = 2;</code>
   */
  com.google.protobuf.DurationOrBuilder getTimeoutOrBuilder();

  /**
   * <pre>
   * Shipment model to solve.
   * </pre>
   *
   * <code>.google.cloud.optimization.v1.ShipmentModel model = 3;</code>
   * @return Whether the model field is set.
   */
  boolean hasModel();
  /**
   * <pre>
   * Shipment model to solve.
   * </pre>
   *
   * <code>.google.cloud.optimization.v1.ShipmentModel model = 3;</code>
   * @return The model.
   */
  com.google.cloud.optimization.v1.ShipmentModel getModel();
  /**
   * <pre>
   * Shipment model to solve.
   * </pre>
   *
   * <code>.google.cloud.optimization.v1.ShipmentModel model = 3;</code>
   */
  com.google.cloud.optimization.v1.ShipmentModelOrBuilder getModelOrBuilder();

  /**
   * <pre>
   * By default, the solving mode is `DEFAULT_SOLVE` (0).
   * </pre>
   *
   * <code>.google.cloud.optimization.v1.OptimizeToursRequest.SolvingMode solving_mode = 4;</code>
   * @return The enum numeric value on the wire for solvingMode.
   */
  int getSolvingModeValue();
  /**
   * <pre>
   * By default, the solving mode is `DEFAULT_SOLVE` (0).
   * </pre>
   *
   * <code>.google.cloud.optimization.v1.OptimizeToursRequest.SolvingMode solving_mode = 4;</code>
   * @return The solvingMode.
   */
  com.google.cloud.optimization.v1.OptimizeToursRequest.SolvingMode getSolvingMode();

  /**
   * <pre>
   * Truncates the number of validation errors returned. Those errors are
   * typically attached to an INVALID_ARGUMENT error payload as a BadRequest
   * error detail (https://cloud.google.com/apis/design/errors#error_details),
   * unless solving_mode=VALIDATE_ONLY: see the
   * [OptimizeToursResponse.validation_errors][google.cloud.optimization.v1.OptimizeToursResponse.validation_errors]
   * field.
   * This defaults to 100 and is capped at 10,000.
   * </pre>
   *
   * <code>optional int32 max_validation_errors = 5;</code>
   * @return Whether the maxValidationErrors field is set.
   */
  boolean hasMaxValidationErrors();
  /**
   * <pre>
   * Truncates the number of validation errors returned. Those errors are
   * typically attached to an INVALID_ARGUMENT error payload as a BadRequest
   * error detail (https://cloud.google.com/apis/design/errors#error_details),
   * unless solving_mode=VALIDATE_ONLY: see the
   * [OptimizeToursResponse.validation_errors][google.cloud.optimization.v1.OptimizeToursResponse.validation_errors]
   * field.
   * This defaults to 100 and is capped at 10,000.
   * </pre>
   *
   * <code>optional int32 max_validation_errors = 5;</code>
   * @return The maxValidationErrors.
   */
  int getMaxValidationErrors();

  /**
   * <pre>
   * Search mode used to solve the request.
   * </pre>
   *
   * <code>.google.cloud.optimization.v1.OptimizeToursRequest.SearchMode search_mode = 6;</code>
   * @return The enum numeric value on the wire for searchMode.
   */
  int getSearchModeValue();
  /**
   * <pre>
   * Search mode used to solve the request.
   * </pre>
   *
   * <code>.google.cloud.optimization.v1.OptimizeToursRequest.SearchMode search_mode = 6;</code>
   * @return The searchMode.
   */
  com.google.cloud.optimization.v1.OptimizeToursRequest.SearchMode getSearchMode();

  /**
   * <pre>
   * Guide the optimization algorithm in finding a first solution that is
   * similar to a previous solution.
   * The model is constrained when the first solution is built.
   * Any shipments not performed on a route are implicitly skipped in the first
   * solution, but they may be performed in successive solutions.
   * The solution must satisfy some basic validity assumptions:
   *   * for all routes, `vehicle_index` must be in range and not be duplicated.
   *   * for all visits, `shipment_index` and `visit_request_index` must be
   *     in range.
   *   * a shipment may only be referenced on one route.
   *   * the pickup of a pickup-delivery shipment must be performed before
   *     the delivery.
   *   * no more than one pickup alternative or delivery alternative of
   *     a shipment may be performed.
   *   * for all routes, times are increasing (i.e., `vehicle_start_time
   *     &lt;= visits[0].start_time &lt;= visits[1].start_time ...
   *     &lt;= vehicle_end_time`).
   *   * a shipment may only be performed on a vehicle that is allowed. A
   *     vehicle is allowed if [Shipment.allowed_vehicle_indices][google.cloud.optimization.v1.Shipment.allowed_vehicle_indices] is empty or
   *     its `vehicle_index` is included in
   *     [Shipment.allowed_vehicle_indices][google.cloud.optimization.v1.Shipment.allowed_vehicle_indices].
   * If the injected solution is not feasible, a validation error is not
   * necessarily returned and an error indicating infeasibility may be returned
   * instead.
   * </pre>
   *
   * <code>repeated .google.cloud.optimization.v1.ShipmentRoute injected_first_solution_routes = 7;</code>
   */
  java.util.List<com.google.cloud.optimization.v1.ShipmentRoute> 
      getInjectedFirstSolutionRoutesList();
  /**
   * <pre>
   * Guide the optimization algorithm in finding a first solution that is
   * similar to a previous solution.
   * The model is constrained when the first solution is built.
   * Any shipments not performed on a route are implicitly skipped in the first
   * solution, but they may be performed in successive solutions.
   * The solution must satisfy some basic validity assumptions:
   *   * for all routes, `vehicle_index` must be in range and not be duplicated.
   *   * for all visits, `shipment_index` and `visit_request_index` must be
   *     in range.
   *   * a shipment may only be referenced on one route.
   *   * the pickup of a pickup-delivery shipment must be performed before
   *     the delivery.
   *   * no more than one pickup alternative or delivery alternative of
   *     a shipment may be performed.
   *   * for all routes, times are increasing (i.e., `vehicle_start_time
   *     &lt;= visits[0].start_time &lt;= visits[1].start_time ...
   *     &lt;= vehicle_end_time`).
   *   * a shipment may only be performed on a vehicle that is allowed. A
   *     vehicle is allowed if [Shipment.allowed_vehicle_indices][google.cloud.optimization.v1.Shipment.allowed_vehicle_indices] is empty or
   *     its `vehicle_index` is included in
   *     [Shipment.allowed_vehicle_indices][google.cloud.optimization.v1.Shipment.allowed_vehicle_indices].
   * If the injected solution is not feasible, a validation error is not
   * necessarily returned and an error indicating infeasibility may be returned
   * instead.
   * </pre>
   *
   * <code>repeated .google.cloud.optimization.v1.ShipmentRoute injected_first_solution_routes = 7;</code>
   */
  com.google.cloud.optimization.v1.ShipmentRoute getInjectedFirstSolutionRoutes(int index);
  /**
   * <pre>
   * Guide the optimization algorithm in finding a first solution that is
   * similar to a previous solution.
   * The model is constrained when the first solution is built.
   * Any shipments not performed on a route are implicitly skipped in the first
   * solution, but they may be performed in successive solutions.
   * The solution must satisfy some basic validity assumptions:
   *   * for all routes, `vehicle_index` must be in range and not be duplicated.
   *   * for all visits, `shipment_index` and `visit_request_index` must be
   *     in range.
   *   * a shipment may only be referenced on one route.
   *   * the pickup of a pickup-delivery shipment must be performed before
   *     the delivery.
   *   * no more than one pickup alternative or delivery alternative of
   *     a shipment may be performed.
   *   * for all routes, times are increasing (i.e., `vehicle_start_time
   *     &lt;= visits[0].start_time &lt;= visits[1].start_time ...
   *     &lt;= vehicle_end_time`).
   *   * a shipment may only be performed on a vehicle that is allowed. A
   *     vehicle is allowed if [Shipment.allowed_vehicle_indices][google.cloud.optimization.v1.Shipment.allowed_vehicle_indices] is empty or
   *     its `vehicle_index` is included in
   *     [Shipment.allowed_vehicle_indices][google.cloud.optimization.v1.Shipment.allowed_vehicle_indices].
   * If the injected solution is not feasible, a validation error is not
   * necessarily returned and an error indicating infeasibility may be returned
   * instead.
   * </pre>
   *
   * <code>repeated .google.cloud.optimization.v1.ShipmentRoute injected_first_solution_routes = 7;</code>
   */
  int getInjectedFirstSolutionRoutesCount();
  /**
   * <pre>
   * Guide the optimization algorithm in finding a first solution that is
   * similar to a previous solution.
   * The model is constrained when the first solution is built.
   * Any shipments not performed on a route are implicitly skipped in the first
   * solution, but they may be performed in successive solutions.
   * The solution must satisfy some basic validity assumptions:
   *   * for all routes, `vehicle_index` must be in range and not be duplicated.
   *   * for all visits, `shipment_index` and `visit_request_index` must be
   *     in range.
   *   * a shipment may only be referenced on one route.
   *   * the pickup of a pickup-delivery shipment must be performed before
   *     the delivery.
   *   * no more than one pickup alternative or delivery alternative of
   *     a shipment may be performed.
   *   * for all routes, times are increasing (i.e., `vehicle_start_time
   *     &lt;= visits[0].start_time &lt;= visits[1].start_time ...
   *     &lt;= vehicle_end_time`).
   *   * a shipment may only be performed on a vehicle that is allowed. A
   *     vehicle is allowed if [Shipment.allowed_vehicle_indices][google.cloud.optimization.v1.Shipment.allowed_vehicle_indices] is empty or
   *     its `vehicle_index` is included in
   *     [Shipment.allowed_vehicle_indices][google.cloud.optimization.v1.Shipment.allowed_vehicle_indices].
   * If the injected solution is not feasible, a validation error is not
   * necessarily returned and an error indicating infeasibility may be returned
   * instead.
   * </pre>
   *
   * <code>repeated .google.cloud.optimization.v1.ShipmentRoute injected_first_solution_routes = 7;</code>
   */
  java.util.List<? extends com.google.cloud.optimization.v1.ShipmentRouteOrBuilder> 
      getInjectedFirstSolutionRoutesOrBuilderList();
  /**
   * <pre>
   * Guide the optimization algorithm in finding a first solution that is
   * similar to a previous solution.
   * The model is constrained when the first solution is built.
   * Any shipments not performed on a route are implicitly skipped in the first
   * solution, but they may be performed in successive solutions.
   * The solution must satisfy some basic validity assumptions:
   *   * for all routes, `vehicle_index` must be in range and not be duplicated.
   *   * for all visits, `shipment_index` and `visit_request_index` must be
   *     in range.
   *   * a shipment may only be referenced on one route.
   *   * the pickup of a pickup-delivery shipment must be performed before
   *     the delivery.
   *   * no more than one pickup alternative or delivery alternative of
   *     a shipment may be performed.
   *   * for all routes, times are increasing (i.e., `vehicle_start_time
   *     &lt;= visits[0].start_time &lt;= visits[1].start_time ...
   *     &lt;= vehicle_end_time`).
   *   * a shipment may only be performed on a vehicle that is allowed. A
   *     vehicle is allowed if [Shipment.allowed_vehicle_indices][google.cloud.optimization.v1.Shipment.allowed_vehicle_indices] is empty or
   *     its `vehicle_index` is included in
   *     [Shipment.allowed_vehicle_indices][google.cloud.optimization.v1.Shipment.allowed_vehicle_indices].
   * If the injected solution is not feasible, a validation error is not
   * necessarily returned and an error indicating infeasibility may be returned
   * instead.
   * </pre>
   *
   * <code>repeated .google.cloud.optimization.v1.ShipmentRoute injected_first_solution_routes = 7;</code>
   */
  com.google.cloud.optimization.v1.ShipmentRouteOrBuilder getInjectedFirstSolutionRoutesOrBuilder(
      int index);

  /**
   * <pre>
   * Constrain the optimization algorithm to find a final solution that is
   * similar to a previous solution. For example, this may be used to freeze
   * portions of routes which have already been completed or which are to be
   * completed but must not be modified.
   * If the injected solution is not feasible, a validation error is not
   * necessarily returned and an error indicating infeasibility may be returned
   * instead.
   * </pre>
   *
   * <code>.google.cloud.optimization.v1.InjectedSolutionConstraint injected_solution_constraint = 8;</code>
   * @return Whether the injectedSolutionConstraint field is set.
   */
  boolean hasInjectedSolutionConstraint();
  /**
   * <pre>
   * Constrain the optimization algorithm to find a final solution that is
   * similar to a previous solution. For example, this may be used to freeze
   * portions of routes which have already been completed or which are to be
   * completed but must not be modified.
   * If the injected solution is not feasible, a validation error is not
   * necessarily returned and an error indicating infeasibility may be returned
   * instead.
   * </pre>
   *
   * <code>.google.cloud.optimization.v1.InjectedSolutionConstraint injected_solution_constraint = 8;</code>
   * @return The injectedSolutionConstraint.
   */
  com.google.cloud.optimization.v1.InjectedSolutionConstraint getInjectedSolutionConstraint();
  /**
   * <pre>
   * Constrain the optimization algorithm to find a final solution that is
   * similar to a previous solution. For example, this may be used to freeze
   * portions of routes which have already been completed or which are to be
   * completed but must not be modified.
   * If the injected solution is not feasible, a validation error is not
   * necessarily returned and an error indicating infeasibility may be returned
   * instead.
   * </pre>
   *
   * <code>.google.cloud.optimization.v1.InjectedSolutionConstraint injected_solution_constraint = 8;</code>
   */
  com.google.cloud.optimization.v1.InjectedSolutionConstraintOrBuilder getInjectedSolutionConstraintOrBuilder();

  /**
   * <pre>
   * If non-empty, the given routes will be refreshed, without modifying their
   * underlying sequence of visits or travel times: only other details will be
   * updated. This does not solve the model.
   * As of 2020/11, this only populates the polylines of non-empty routes and
   * requires that `populate_polylines` is true.
   * The `route_polyline` fields of the passed-in routes may be inconsistent
   * with route `transitions`.
   * This field must not be used together with `injected_first_solution_routes`
   * or `injected_solution_constraint`.
   * `Shipment.ignore` and `Vehicle.ignore` have no effect on the behavior.
   * Polylines are still populated between all visits in all non-empty routes
   * regardless of whether the related shipments or vehicles are ignored.
   * </pre>
   *
   * <code>repeated .google.cloud.optimization.v1.ShipmentRoute refresh_details_routes = 9;</code>
   */
  java.util.List<com.google.cloud.optimization.v1.ShipmentRoute> 
      getRefreshDetailsRoutesList();
  /**
   * <pre>
   * If non-empty, the given routes will be refreshed, without modifying their
   * underlying sequence of visits or travel times: only other details will be
   * updated. This does not solve the model.
   * As of 2020/11, this only populates the polylines of non-empty routes and
   * requires that `populate_polylines` is true.
   * The `route_polyline` fields of the passed-in routes may be inconsistent
   * with route `transitions`.
   * This field must not be used together with `injected_first_solution_routes`
   * or `injected_solution_constraint`.
   * `Shipment.ignore` and `Vehicle.ignore` have no effect on the behavior.
   * Polylines are still populated between all visits in all non-empty routes
   * regardless of whether the related shipments or vehicles are ignored.
   * </pre>
   *
   * <code>repeated .google.cloud.optimization.v1.ShipmentRoute refresh_details_routes = 9;</code>
   */
  com.google.cloud.optimization.v1.ShipmentRoute getRefreshDetailsRoutes(int index);
  /**
   * <pre>
   * If non-empty, the given routes will be refreshed, without modifying their
   * underlying sequence of visits or travel times: only other details will be
   * updated. This does not solve the model.
   * As of 2020/11, this only populates the polylines of non-empty routes and
   * requires that `populate_polylines` is true.
   * The `route_polyline` fields of the passed-in routes may be inconsistent
   * with route `transitions`.
   * This field must not be used together with `injected_first_solution_routes`
   * or `injected_solution_constraint`.
   * `Shipment.ignore` and `Vehicle.ignore` have no effect on the behavior.
   * Polylines are still populated between all visits in all non-empty routes
   * regardless of whether the related shipments or vehicles are ignored.
   * </pre>
   *
   * <code>repeated .google.cloud.optimization.v1.ShipmentRoute refresh_details_routes = 9;</code>
   */
  int getRefreshDetailsRoutesCount();
  /**
   * <pre>
   * If non-empty, the given routes will be refreshed, without modifying their
   * underlying sequence of visits or travel times: only other details will be
   * updated. This does not solve the model.
   * As of 2020/11, this only populates the polylines of non-empty routes and
   * requires that `populate_polylines` is true.
   * The `route_polyline` fields of the passed-in routes may be inconsistent
   * with route `transitions`.
   * This field must not be used together with `injected_first_solution_routes`
   * or `injected_solution_constraint`.
   * `Shipment.ignore` and `Vehicle.ignore` have no effect on the behavior.
   * Polylines are still populated between all visits in all non-empty routes
   * regardless of whether the related shipments or vehicles are ignored.
   * </pre>
   *
   * <code>repeated .google.cloud.optimization.v1.ShipmentRoute refresh_details_routes = 9;</code>
   */
  java.util.List<? extends com.google.cloud.optimization.v1.ShipmentRouteOrBuilder> 
      getRefreshDetailsRoutesOrBuilderList();
  /**
   * <pre>
   * If non-empty, the given routes will be refreshed, without modifying their
   * underlying sequence of visits or travel times: only other details will be
   * updated. This does not solve the model.
   * As of 2020/11, this only populates the polylines of non-empty routes and
   * requires that `populate_polylines` is true.
   * The `route_polyline` fields of the passed-in routes may be inconsistent
   * with route `transitions`.
   * This field must not be used together with `injected_first_solution_routes`
   * or `injected_solution_constraint`.
   * `Shipment.ignore` and `Vehicle.ignore` have no effect on the behavior.
   * Polylines are still populated between all visits in all non-empty routes
   * regardless of whether the related shipments or vehicles are ignored.
   * </pre>
   *
   * <code>repeated .google.cloud.optimization.v1.ShipmentRoute refresh_details_routes = 9;</code>
   */
  com.google.cloud.optimization.v1.ShipmentRouteOrBuilder getRefreshDetailsRoutesOrBuilder(
      int index);

  /**
   * <pre>
   * If true:
   *   * uses [ShipmentRoute.vehicle_label][google.cloud.optimization.v1.ShipmentRoute.vehicle_label] instead of `vehicle_index` to
   *     match routes in an injected solution with vehicles in the request;
   *     reuses the mapping of original [ShipmentRoute.vehicle_index][google.cloud.optimization.v1.ShipmentRoute.vehicle_index] to new
   *     [ShipmentRoute.vehicle_index][google.cloud.optimization.v1.ShipmentRoute.vehicle_index] to update
   *     [ConstraintRelaxation.vehicle_indices][google.cloud.optimization.v1.InjectedSolutionConstraint.ConstraintRelaxation.vehicle_indices]
   *     if non-empty, but the mapping must be unambiguous (i.e., multiple
   *     `ShipmentRoute`s must not share the same original `vehicle_index`).
   *   * uses [ShipmentRoute.Visit.shipment_label][google.cloud.optimization.v1.ShipmentRoute.Visit.shipment_label] instead of `shipment_index`
   *     to match visits in an injected solution with shipments in the request;
   *   * uses [SkippedShipment.label][google.cloud.optimization.v1.SkippedShipment.label] instead of [SkippedShipment.index][google.cloud.optimization.v1.SkippedShipment.index] to
   *     match skipped shipments in the injected solution with request
   *     shipments.
   * This interpretation applies to the `injected_first_solution_routes`,
   * `injected_solution_constraint`, and `refresh_details_routes` fields.
   * It can be used when shipment or vehicle indices in the request have
   * changed since the solution was created, perhaps because shipments or
   * vehicles have been removed from or added to the request.
   * If true, labels in the following categories must appear at most once in
   * their category:
   *   * [Vehicle.label][google.cloud.optimization.v1.Vehicle.label] in the request;
   *   * [Shipment.label][google.cloud.optimization.v1.Shipment.label] in the request;
   *   * [ShipmentRoute.vehicle_label][google.cloud.optimization.v1.ShipmentRoute.vehicle_label] in the injected solution;
   *   * [SkippedShipment.label][google.cloud.optimization.v1.SkippedShipment.label] and [ShipmentRoute.Visit.shipment_label][google.cloud.optimization.v1.ShipmentRoute.Visit.shipment_label] in
   *     the injected solution (except pickup/delivery visit pairs, whose
   *     `shipment_label` must appear twice).
   * If a `vehicle_label` in the injected solution does not correspond to a
   * request vehicle, the corresponding route is removed from the solution
   * along with its visits. If a `shipment_label` in the injected solution does
   * not correspond to a request shipment, the corresponding visit is removed
   * from the solution. If a [SkippedShipment.label][google.cloud.optimization.v1.SkippedShipment.label] in the injected solution
   * does not correspond to a request shipment, the `SkippedShipment` is removed
   * from the solution.
   * Removing route visits or entire routes from an injected solution may
   * have an effect on the implied constraints, which may lead to change in
   * solution, validation errors, or infeasibility.
   * NOTE: The caller must ensure that each [Vehicle.label][google.cloud.optimization.v1.Vehicle.label]
   * (resp. [Shipment.label][google.cloud.optimization.v1.Shipment.label]) uniquely identifies a vehicle (resp. shipment)
   * entity used across the two relevant requests: the past request that
   * produced the `OptimizeToursResponse` used in the injected solution and the
   * current request that includes the injected solution. The uniqueness checks
   * described above are not enough to guarantee this requirement.
   * </pre>
   *
   * <code>bool interpret_injected_solutions_using_labels = 10;</code>
   * @return The interpretInjectedSolutionsUsingLabels.
   */
  boolean getInterpretInjectedSolutionsUsingLabels();

  /**
   * <pre>
   * Consider traffic estimation in calculating `ShipmentRoute` fields
   * [Transition.travel_duration][google.cloud.optimization.v1.ShipmentRoute.Transition.travel_duration],
   * [Visit.start_time][google.cloud.optimization.v1.ShipmentRoute.Visit.start_time],
   * and `vehicle_end_time`; in setting the
   * [ShipmentRoute.has_traffic_infeasibilities][google.cloud.optimization.v1.ShipmentRoute.has_traffic_infeasibilities] field, and in calculating the
   * [OptimizeToursResponse.total_cost][google.cloud.optimization.v1.OptimizeToursResponse.total_cost] field.
   * </pre>
   *
   * <code>bool consider_road_traffic = 11;</code>
   * @return The considerRoadTraffic.
   */
  boolean getConsiderRoadTraffic();

  /**
   * <pre>
   * If true, polylines will be populated in response `ShipmentRoute`s.
   * </pre>
   *
   * <code>bool populate_polylines = 12;</code>
   * @return The populatePolylines.
   */
  boolean getPopulatePolylines();

  /**
   * <pre>
   * If true, polylines will be populated in response
   * [ShipmentRoute.transitions][google.cloud.optimization.v1.ShipmentRoute.transitions].
   * Note that in this case, the polylines will also be populated in the
   * deprecated `travel_steps`.
   * </pre>
   *
   * <code>bool populate_transition_polylines = 13;</code>
   * @return The populateTransitionPolylines.
   */
  boolean getPopulateTransitionPolylines();

  /**
   * <pre>
   * If this is set, then the request can have a deadline
   * (see https://grpc.io/blog/deadlines) of up to 60 minutes.
   * Otherwise, the maximum deadline is only 30 minutes.
   * Note that long-lived requests have a significantly larger (but still small)
   * risk of interruption.
   * </pre>
   *
   * <code>bool allow_large_deadline_despite_interruption_risk = 14;</code>
   * @return The allowLargeDeadlineDespiteInterruptionRisk.
   */
  boolean getAllowLargeDeadlineDespiteInterruptionRisk();

  /**
   * <pre>
   * If true, travel distances will be computed using geodesic distances instead
   * of Google Maps distances, and travel times will be computed using geodesic
   * distances with a speed defined by `geodesic_meters_per_second`.
   * </pre>
   *
   * <code>bool use_geodesic_distances = 15;</code>
   * @return The useGeodesicDistances.
   */
  boolean getUseGeodesicDistances();

  /**
   * <pre>
   * When `use_geodesic_distances` is true, this field must be set and defines
   * the speed applied to compute travel times. Its value must be at least 1.0
   * meters/seconds.
   * </pre>
   *
   * <code>optional double geodesic_meters_per_second = 16;</code>
   * @return Whether the geodesicMetersPerSecond field is set.
   */
  boolean hasGeodesicMetersPerSecond();
  /**
   * <pre>
   * When `use_geodesic_distances` is true, this field must be set and defines
   * the speed applied to compute travel times. Its value must be at least 1.0
   * meters/seconds.
   * </pre>
   *
   * <code>optional double geodesic_meters_per_second = 16;</code>
   * @return The geodesicMetersPerSecond.
   */
  double getGeodesicMetersPerSecond();

  /**
   * <pre>
   * Label that may be used to identify this request, reported back in the
   * [OptimizeToursResponse.request_label][google.cloud.optimization.v1.OptimizeToursResponse.request_label].
   * </pre>
   *
   * <code>string label = 17;</code>
   * @return The label.
   */
  java.lang.String getLabel();
  /**
   * <pre>
   * Label that may be used to identify this request, reported back in the
   * [OptimizeToursResponse.request_label][google.cloud.optimization.v1.OptimizeToursResponse.request_label].
   * </pre>
   *
   * <code>string label = 17;</code>
   * @return The bytes for label.
   */
  com.google.protobuf.ByteString
      getLabelBytes();

  /**
   * <pre>
   * Deprecated: Use [OptimizeToursRequest.populate_transition_polylines][] instead.
   * If true, polylines will be populated in response
   * [ShipmentRoute.transitions][google.cloud.optimization.v1.ShipmentRoute.transitions]. Note that in this case, the polylines will
   * also be populated in the deprecated `travel_steps`.
   * </pre>
   *
   * <code>bool populate_travel_step_polylines = 20 [deprecated = true];</code>
   * @deprecated google.cloud.optimization.v1.OptimizeToursRequest.populate_travel_step_polylines is deprecated.
   *     See google/cloud/optimization/v1/fleet_routing.proto;l=327
   * @return The populateTravelStepPolylines.
   */
  @java.lang.Deprecated boolean getPopulateTravelStepPolylines();
}