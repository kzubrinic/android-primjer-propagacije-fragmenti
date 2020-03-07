package hr.kruno.primjerpropagacijefragmenti;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;


public class PrviFragment extends Fragment {

    private OnKetchupChangeListener kListener;
    private OnMaslineChangeListener mListener;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_prvi, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        // Registrira se promjene izbora na komponenti
        CheckBox dm = view.findViewById(R.id.dodatneMasline);
        dm.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // šalje se callback objekt koji dohvaćaju sve klase koje implementiraju ovo sučelje
                if (mListener != null)
                    mListener.onMaslineChange(isChecked);

            }
        });
        CheckBox dk = view.findViewById(R.id.dodatniKetchup);
        dk.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // šalje se callback objekt koji dohvaćaju sve klase koje implementiraju ovo sučelje
                if (kListener != null)
                    kListener.onKetchupChange(isChecked);

            }
        });

    }

    // registriraju se listeneri
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnKetchupChangeListener) {
            kListener = (OnKetchupChangeListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnKetchupChangeListener");
        }
        if (context instanceof OnMaslineChangeListener) {
            mListener = (OnMaslineChangeListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnMaslineChangeListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
        kListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */

    // Sve klase koje koriste ovaj fragment moraju implkementirati ova dva sučelja
    public interface OnMaslineChangeListener {
        void onMaslineChange(boolean choose);
    }
    public interface OnKetchupChangeListener {
        void onKetchupChange(boolean choose);
    }
}
