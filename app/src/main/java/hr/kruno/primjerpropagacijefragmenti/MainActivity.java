package hr.kruno.primjerpropagacijefragmenti;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements PrviFragment.OnKetchupChangeListener, PrviFragment.OnMaslineChangeListener{
    private FragmentManager fm;
    private PrviFragment f1;
    private DrugiFragment f2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fm = getSupportFragmentManager();
        // Započni transakciju
        f1 = new PrviFragment();
        f2 = new DrugiFragment();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.prvi_fragment, f1);
        // Zamijeni sadržaj kontejnera aktivnosti fragmentom
        ft.replace(R.id.drugi_fragment, f2);
        //ft.addToBackStack("tag1");
        // or ft.add(R.id.your_placeholder, new FooFragment());
        // Potvrdi promjenu
        ft.commit();
    }

    // Implementacija callback metoda sučelja fragmenta
    // Promjenu sadržaja komponenti fragmenta odrađuju sami fragmenti
    // Aktivnost im delegira taj zadatak
    @Override
    public void onMaslineChange(boolean choose) {
        f2.promijeniMasline(choose);
    }

    @Override
    public void onKetchupChange(boolean choose) {
        f2.promijeniKetchup(choose);
    }
}
