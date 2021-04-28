package xyz.jaswanth.bitwall;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.StrictMode;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import xyz.jaswanth.bitwall.pojo.BitriseArtifact;
import xyz.jaswanth.bitwall.pojo.BitriseArtifactListResponse;
import xyz.jaswanth.bitwall.pojo.BitriseBuild;
import xyz.jaswanth.bitwall.pojo.BitriseBuildListResponse;
import xyz.jaswanth.bitwall.pojo.BuildLog;
import xyz.jaswanth.bitwall.pojo.Datum;

import static xyz.jaswanth.bitwall.ApiService.BASE_URL;


public class AppDetailActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerView bottomSheetRecyclerview;

    BuildListRecyclerViewAdapter recyclerViewAdapter;
    ArtifactListRecyclerViewAdapter artifactListRecyclerViewAdapter;

    Retrofit retrofit;
    Datum app;
    BitriseBuild build;

    HttpLoggingInterceptor interceptor;
    OkHttpClient client;
    Gson gson;
    ApiService apiService;

    LinearLayoutManager layoutManager;

    private CoordinatorLayout coordinatorLayout;
    private BottomSheetBehavior behavior;
    private View persistentbottomSheet;

    private BottomSheetBehavior behaviorLog;
    private View persistentbottomSheetLog;

    private boolean isLoading = false;
    private boolean isLastPage = false;
    private int PAGE_SIZE = 5;
    private String nextSlug = "";

    public void expandBottomSheet(BitriseBuild build) {

        getArtifactList(build);
    }

    public void expandLogBottomSheet(BitriseBuild build) {

        getBuildLog(build);
    }

    private void initApiComponents() {
        interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        client = new OkHttpClient.Builder().addInterceptor(interceptor).build();

        gson = new GsonBuilder()
                .setLenient()
                .create();

        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_detail);

        coordinatorLayout = (CoordinatorLayout)findViewById(R.id.coordinator);
        persistentbottomSheet = coordinatorLayout.findViewById(R.id.bottomsheet);
        behavior = BottomSheetBehavior.from(persistentbottomSheet);

        persistentbottomSheetLog = coordinatorLayout.findViewById(R.id.logBottomsheet);
        behaviorLog = BottomSheetBehavior.from(persistentbottomSheetLog);

        Bundle extras = getIntent().getExtras();

        if (extras != null) {
            app = (Datum) extras.getParcelable("app");
            // and get whatever type user account id is
        }

        recyclerView = findViewById(R.id.recyclerView);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerViewAdapter = new BuildListRecyclerViewAdapter(this);
        recyclerView.setAdapter(recyclerViewAdapter);
        recyclerView.addOnScrollListener(recyclerViewOnScrollListener);


        bottomSheetRecyclerview = coordinatorLayout.findViewById(R.id.recyclerview_bottom_sheet);
        bottomSheetRecyclerview.setLayoutManager(new LinearLayoutManager(this));
        artifactListRecyclerViewAdapter = new ArtifactListRecyclerViewAdapter(this, app);
        bottomSheetRecyclerview.setAdapter(artifactListRecyclerViewAdapter);


        initApiComponents();

        callEndpoints();
    }

    private String getPassword() {
        SharedPreferences prefs = this.getSharedPreferences("bitwall", Context.MODE_PRIVATE);
        String token = prefs.getString("token", null);
        return token;
    }

    private void callEndpoints() {
        apiService = retrofit.create(ApiService.class);

        Observable<BitriseBuildListResponse> cryptoObservable = apiService.getBitriseBuildList(app.getSlug(), PAGE_SIZE, nextSlug, getPassword());
        cryptoObservable.subscribeOn(
                Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .map(result -> result)
                .subscribe(this::handleResults, this::handleError);
    }

    private void getArtifactList(BitriseBuild build) {
        this.build = build;
        Observable<BitriseArtifactListResponse> cryptoObservable = apiService.getBitriseArtifactList(app.getSlug(),build.getSlug(),50, getPassword());
        cryptoObservable.subscribeOn(
                Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .map(result -> result.getData())
                .subscribe(this::handleArtifactResults, this::handleError);

    }

    private void getBuildLog(BitriseBuild build) {
        this.build = build;
        Observable<BuildLog> cryptoObservable = apiService.getBitriseBuildLog(app.getSlug(),build.getSlug(), getPassword());
        cryptoObservable.subscribeOn(
                Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .map(result -> result.getExpiringRawLogUrl())
                .subscribe(this::handleLogResults, this::handleError);

    }

    private void handleArtifactResults(List<BitriseArtifact> appList) {
        if (appList != null && appList.size() != 0) {
            artifactListRecyclerViewAdapter.setData(appList, build);

            if (behavior.getState() == BottomSheetBehavior.STATE_COLLAPSED) {
                behavior.setState(BottomSheetBehavior.STATE_EXPANDED);
            } else {
                behavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
            }


        } else {
            Toast.makeText(this, "NO RESULTS FOUND",
                    Toast.LENGTH_LONG).show();
        }
    }

    private void handleLogResults(String buildUrl) {
        if (buildUrl != null && !buildUrl.isEmpty()) {
            try {
                // Create a URL for the desired page
                URL url = new URL(buildUrl);

                // Read all the text returned by the server
                BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
                String completeLog = "";
                String str;

                StringBuilder total = new StringBuilder();
                for (String line; (line = in.readLine()) != null; ) {
                    total.append(line).append('\n');
                }

//                while ((str = in.readLine()) != null) {
//                    // str is one line of text; readLine() strips the newline character(s)
//                    completeLog += str;
//                }
                in.close();

                TextView descTxtView= (TextView) coordinatorLayout.findViewById(R.id.descTxtView);
                descTxtView.setMovementMethod(new ScrollingMovementMethod());
                descTxtView.setText(total);

                if (behaviorLog.getState() == BottomSheetBehavior.STATE_COLLAPSED) {
                    behaviorLog.setState(BottomSheetBehavior.STATE_EXPANDED);
                } else {
                    behaviorLog.setState(BottomSheetBehavior.STATE_COLLAPSED);
                }

            } catch (MalformedURLException e) {
                Toast.makeText(this, "Malformed URL",
                        Toast.LENGTH_LONG).show();

            } catch (IOException e) {
                Toast.makeText(this, "IO Exception",
                        Toast.LENGTH_LONG).show();

            }
        } else {
            Toast.makeText(this, "NO RESULTS FOUND",
                    Toast.LENGTH_LONG).show();
        }
    }


    private void handleResults(BitriseBuildListResponse response) {
        List<BitriseBuild> appList = response.getData();
        isLoading = false;

        if (appList != null && appList.size() != 0) {
            recyclerViewAdapter.setData(appList);
            nextSlug = response.getPaging().getNext();
            Log.e("Next", nextSlug);
        } else {
            Toast.makeText(this, "NO RESULTS FOUND",
                    Toast.LENGTH_LONG).show();
        }
    }

    private void handleError(Throwable t) {
        isLoading = false;

        Toast.makeText(this, "ERROR IN FETCHING API RESPONSE. Try again",
                Toast.LENGTH_LONG).show();
    }

    private RecyclerView.OnScrollListener recyclerViewOnScrollListener = new RecyclerView.OnScrollListener() {
        @Override
        public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
            super.onScrollStateChanged(recyclerView, newState);
        }

        @Override
        public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
            super.onScrolled(recyclerView, dx, dy);
            int visibleItemCount = layoutManager.getChildCount();
            int totalItemCount = layoutManager.getItemCount();
            int firstVisibleItemPosition = layoutManager.findFirstVisibleItemPosition();

            if (!isLoading && !isLastPage) {
                if ((visibleItemCount + firstVisibleItemPosition) >= totalItemCount
                        && firstVisibleItemPosition >= 0
                        && totalItemCount >= PAGE_SIZE && nextSlug != null && nextSlug != "") {
                    isLoading = true;
                    callEndpoints();
                }
            }
        }
    };

}
