package xyz.jaswanth.bitwall;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.Path;
import retrofit2.http.Query;
import xyz.jaswanth.bitwall.pojo.BitriseAppListResponse;
import xyz.jaswanth.bitwall.pojo.BitriseArtifactDetailResponse;
import xyz.jaswanth.bitwall.pojo.BitriseArtifactListResponse;
import xyz.jaswanth.bitwall.pojo.BitriseBuildListResponse;
import xyz.jaswanth.bitwall.pojo.BuildLog;
import xyz.jaswanth.bitwall.pojo.Crypto;

public interface ApiService {
    String BASE_URL = "https://api.bitrise.io/v0.1/";

    @GET("apps")
    @Headers({
    "Accept:application/json"})
    Observable<BitriseAppListResponse> getBitriseAppList(@Header("Authorization") String authorization);

    @GET("apps/{appSlug}/builds")
    @Headers({
            "Accept:application/json"})
    Observable<BitriseBuildListResponse> getBitriseBuildList(@Path("appSlug") String appSlug,
                                                             @Query("limit") int limit, @Query("next") String nextSlug,
                                                             @Header("Authorization") String authorization);

    @GET("apps/{appSlug}/builds/{buildSlug}/artifacts")
    @Headers({
            "Accept:application/json"})
    Observable<BitriseArtifactListResponse> getBitriseArtifactList(@Path("appSlug") String appSlug,
                                                                   @Path("buildSlug") String buildSlug,
                                                                   @Query("limit") int limit,
                                                                   @Header("Authorization") String authorization);

    @GET("apps/{appSlug}/builds/{buildSlug}/log")
    @Headers({
            "Accept:application/json"})
    Observable<BuildLog> getBitriseBuildLog(@Path("appSlug") String appSlug,
                                            @Path("buildSlug") String buildSlug,
                                            @Header("Authorization") String authorization);


    @GET("apps/{appSlug}/builds/{buildSlug}/artifacts/{artifactSlug}")
    @Headers({
            "Accept:application/json"})
    Observable<BitriseArtifactDetailResponse> getBitriseArtifactDetail(@Path("appSlug") String appSlug,
                                                                       @Path("buildSlug") String buildSlug,
                                                                       @Path("artifactSlug") String artifactSlug,
                                                                       @Query("limit") int limit,
                                                                       @Header("Authorization") String authorization);

}
