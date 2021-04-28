package xyz.jaswanth.bitwall;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


import java.util.ArrayList;
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
import xyz.jaswanth.bitwall.pojo.BitriseArtifactDetailResponse;
import xyz.jaswanth.bitwall.pojo.BitriseBuild;
import xyz.jaswanth.bitwall.pojo.Data;
import xyz.jaswanth.bitwall.pojo.Datum;

import static xyz.jaswanth.bitwall.ApiService.BASE_URL;


public class ArtifactListRecyclerViewAdapter extends RecyclerView.Adapter<ArtifactListRecyclerViewAdapter.ViewHolder> {

    Retrofit retrofit;

    private List<BitriseArtifact> bitriseBuildList;
    private Context activityContext;
    Datum app;
    BitriseBuild build;


    HttpLoggingInterceptor interceptor;
    OkHttpClient client;
    Gson gson;
    ApiService apiService;

    public ArtifactListRecyclerViewAdapter(Context context, Datum app) {
        bitriseBuildList = new ArrayList<>();
        this.activityContext = context;
        this.app = app;
        initApiComponents();
    }

    @Override
    public ArtifactListRecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                                         int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.artifact_list_recyclerview_item_layout, parent, false);

        ArtifactListRecyclerViewAdapter.ViewHolder viewHolder = new ArtifactListRecyclerViewAdapter.ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ArtifactListRecyclerViewAdapter.ViewHolder holder, int position) {
        final BitriseArtifact app = bitriseBuildList.get(position);
        holder.txtCoin.setText(String.valueOf(app.getTitle()));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openArtifact(app);
            }
        });
    }

    private void handleResults(Data appList) {
        if (appList != null) {
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(appList.getPublicInstallPageUrl()));
            activityContext.startActivity(browserIntent);
        } else {
            Toast.makeText(activityContext, "NO RESULTS FOUND",
                    Toast.LENGTH_LONG).show();
        }
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

    }

    private void handleError(Throwable t) {
        Toast.makeText(activityContext, "ERROR IN FETCHING API RESPONSE. Try again",
                Toast.LENGTH_LONG).show();
    }

    private String getPassword() {
        SharedPreferences prefs = activityContext.getSharedPreferences("bitwall", Context.MODE_PRIVATE);
        String token = prefs.getString("token", null);
        return token;
    }

    private void openArtifact(BitriseArtifact artifact) {
        ApiService apiService = retrofit.create(ApiService.class);
        //Single call
        Observable<BitriseArtifactDetailResponse> cryptoObservable = apiService.getBitriseArtifactDetail(app.getSlug(),build.getSlug(), artifact.getSlug(), 50, getPassword());
        cryptoObservable.subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .map(result -> result.getData())
                .subscribe(this::handleResults, this::handleError);

    }

    @Override
    public int getItemCount() {
        return bitriseBuildList.size();
    }

    public void setData(List<BitriseArtifact> data, BitriseBuild build) {
        this.build = build;

        List<BitriseArtifact> filteredList = new ArrayList<>();
        for(int i=0; i< data.size();i++) {
            if(data.get(i).getTitle().contains(".apk") || data.get(i).getTitle().contains(".ipa")) {
                filteredList.add(data.get(i));
            }
        }

//        this.bitriseBuildList.addAll(filteredList);
        //TODO show all artifacts or just apk and ipa
        this.bitriseBuildList.addAll(data);

        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView txtCoin;

        public ViewHolder(View view) {
            super(view);

            txtCoin = view.findViewById(R.id.txtBuildNumber);
        }
    }
}
