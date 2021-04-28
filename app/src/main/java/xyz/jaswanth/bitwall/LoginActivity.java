package xyz.jaswanth.bitwall;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.List;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import xyz.jaswanth.bitwall.pojo.BitriseAppListResponse;
import xyz.jaswanth.bitwall.pojo.Datum;

import static xyz.jaswanth.bitwall.ApiService.BASE_URL;


public class LoginActivity extends AppCompatActivity {

    Retrofit retrofit;
    String token = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();

        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        EditText password = (EditText) findViewById(R.id.password);
        Button signIn = (Button) findViewById(R.id.login);
        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login(String.valueOf(password.getEditableText()));
            }
        });

        TextView getToken = (TextView) findViewById(R.id.txtGetToken);
        getToken.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://app.bitrise.io/me/profile#/security"));
                startActivity(browserIntent);            }
        });

    }

    private void login(String password) {
        this.token = password;
        ApiService apiService = retrofit.create(ApiService.class);
        //Single call
        Observable<BitriseAppListResponse> cryptoObservable = apiService.getBitriseAppList(password);
        cryptoObservable
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers
                        .mainThread())
                .map(result -> result.getData())
                .subscribe(this::handleResults, this::handleError);
    }


    private void handleResults(List<Datum> appList) {
        SharedPreferences pref = getApplicationContext().getSharedPreferences("bitwall", 0); // 0 - for private mode
        SharedPreferences.Editor editor = pref.edit();
        editor.putString("token", this.token); // Storing string
        editor.commit(); // commit changes

        this.finish();
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    private void handleError(Throwable t) {
        Toast.makeText(this, "Error Logging in. Try again",
                Toast.LENGTH_LONG).show();
    }
}