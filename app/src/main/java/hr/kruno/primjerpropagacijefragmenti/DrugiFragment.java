package hr.kruno.primjerpropagacijefragmenti;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;


public class DrugiFragment extends Fragment {
    private TextView iK, iM, iU;
     @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_drugi, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        iK = view.findViewById(R.id.iznosKetchup);
        iM = view.findViewById(R.id.iznosMasline);
        iU = view.findViewById(R.id.iznos);
    }

    // Fragment je zadužen za promjenu vrijednosti svojih komponenti
    public void promijeniMasline(boolean da){
         if (da)
             iM.setText("7");
         else
             iM.setText("0");
         azurirajIznos();
    }
    public void promijeniKetchup(boolean da){
        if (da)
            iK.setText("5");
        else
            iK.setText("0");
        azurirajIznos();
    }
    private void azurirajIznos(){
        int ik = Integer.parseInt(iK.getText().toString());
        int im = Integer.parseInt(iM.getText().toString());
        int iu = 100+ik+im;
        iU.setText(String.valueOf(iu));
    }

}
