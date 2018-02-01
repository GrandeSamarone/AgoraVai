package com.example.fulanoeciclano.agoravai.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;

import com.example.fulanoeciclano.agoravai.DAO.WifiDAO;
import com.example.fulanoeciclano.agoravai.R;
import com.example.fulanoeciclano.agoravai.RecicleView.wifiAdapterRec;
import com.firebase.ui.auth.AuthUI;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    public static final String ANONYMOUS = "anonymous";
    private static final int RC_SIGN_IN = 1;

    private Toolbar toolbarprincipal;
    private Intent intentaddwifi;
    private Button BotaoMaisWifi;
    private FirebaseAuth mFirebaseAuth;
    private FirebaseAuth.AuthStateListener mAuthStateListener;
    private String mUsername;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mUsername = ANONYMOUS;
        mFirebaseAuth = FirebaseAuth.getInstance();

    toolbarprincipal = findViewById(R.id.toobar_principal);
        setSupportActionBar(toolbarprincipal);

           /*toolbarprincipal.setLogo(R.drawable.ic_beach_access_branco_24dp);
            toolbarprincipal.setTitleTextColor(getResources().getColor(R.color.colortitle));
        */

        BotaoMaisWifi = (Button) findViewById(R.id.botaomaiswifi);
        BotaoMaisWifi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intentaddwifi = new Intent(MainActivity.this,Procurar_Wifi.class);
                startActivity(intentaddwifi);
            }
        });


        mAuthStateListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null) {
                    onSignedInInitialize(user.getDisplayName());
                } else {
                    onSignedOutCleanup();
                    List<AuthUI.IdpConfig> providers = Arrays.asList(
                            new AuthUI.IdpConfig.Builder(AuthUI.FACEBOOK_PROVIDER).build(),
                            new AuthUI.IdpConfig.Builder(AuthUI.GOOGLE_PROVIDER).build(),
                            new AuthUI.IdpConfig.Builder(AuthUI.PHONE_VERIFICATION_PROVIDER).build()
                    );
                    startActivityForResult(
                            AuthUI.getInstance()
                                    .createSignInIntentBuilder()
                                    .setIsSmartLockEnabled(false)
                                    .setAvailableProviders(providers)
                                    .build(),
                            RC_SIGN_IN);

                }
            }
        };



    }


    private void onSignedInInitialize(String username) {
        mUsername = username;
       // attachDatabaseReadListener();

    }

    private void onSignedOutCleanup() {
        mUsername = ANONYMOUS;
       // mMessageAdapter.clear();
    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main,menu);
        return true;
    }


    RecyclerView recyclerView;
    private wifiAdapterRec adapter;
    private void configurarRecycler() {
        // Configurando o gerenciador de layout para ser uma lista.
        recyclerView = (RecyclerView)findViewById(R.id.recyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        // Adiciona o adapter que irá anexar os objetos à lista.
        WifiDAO dao = new WifiDAO(this);
        adapter = new wifiAdapterRec(dao.retornarwifi());
        recyclerView.setAdapter(adapter);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
    }


    protected void onResume(){
        super.onResume();
        configurarRecycler();
    }

}



